package com.galacticware.griddle.keyboarddefinition.opensource.layouts

import android.content.Context
import androidx.compose.ui.unit.IntSize
import com.galacticware.griddle.domain.button.GestureButton
import com.galacticware.griddle.domain.button.GestureButtonBuilder
import com.galacticware.griddle.domain.keyboard.KeyboardHandedness
import com.galacticware.griddle.domain.language.LanguageTag
import com.galacticware.griddle.domain.layer.LayerDefinable
import com.galacticware.griddle.domain.layer.LayerKind
import com.galacticware.griddle.keyboarddefinition.system.layerkind.AbstractKeyboardLayer

interface GridKeyMapper {
    val name: String
    val languageTag: LanguageTag?
    val layerKind: LayerKind
    val isPrimary: Boolean
    val keyboardHandedness: KeyboardHandedness
    val defalultSize: IntSize
    fun allMappings(): MutableSet<GestureButtonBuilder>
    fun build(context: Context): LayerDefinable
}

fun CreateLayout(
    context: Context,
    name: String,
    builders: MutableSet<GestureButtonBuilder>,
    keyboardHandedness: KeyboardHandedness,
    defaultButtonSize: IntSize,
    isPrimary: Boolean,
    layerKind: LayerKind,
    languageTag: LanguageTag?,
) : AbstractKeyboardLayer {
    return object: AbstractKeyboardLayer(
        context = context,
        gestureButtonBuilders = builders,
        name = name,
        keyboardHandedness = keyboardHandedness,
        defaultButtonSize = defaultButtonSize,
        isPrimary = isPrimary,
        layerKind = layerKind,
        languageTag = languageTag,
    ){}
}