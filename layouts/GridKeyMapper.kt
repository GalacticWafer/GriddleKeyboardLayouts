package org.galacticware.griddle.keyboarddefinition.opensource.layouts

import android.content.Context
import androidx.compose.ui.unit.IntSize
import org.galacticware.griddle.domain.button.GestureButtonBuilder
import org.galacticware.griddle.domain.keyboard.KeyboardHandedness
import org.galacticware.griddle.domain.language.LanguageTag
import org.galacticware.griddle.domain.layer.LayerDefinable
import org.galacticware.griddle.domain.layer.LayerKind
import org.galacticware.griddle.keyboarddefinition.system.layerkind.AbstractKeyboardLayout

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
) : AbstractKeyboardLayout {
    return object: AbstractKeyboardLayout(
        context,
        name,
        builders,
        keyboardHandedness,
        defaultButtonSize,
        isPrimary,
        layerKind,
        languageTag,
    ){}
}