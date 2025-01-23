package com.galacticware.griddle.keyboarddefinition.opensource.layouts

import android.content.Context
import androidx.compose.ui.unit.IntSize
import com.galacticware.griddle.domain.button.GestureButtonBuilder
import com.galacticware.griddle.domain.keyboard.KeyboardHandedness
import com.galacticware.griddle.domain.language.LanguageTag
import com.galacticware.griddle.domain.layer.LayerDefinable
import com.galacticware.griddle.domain.layer.LayerKind
import com.galacticware.griddle.keyboarddefinition.system.layerkind.AbstractKeyboardLayer
import java.util.Locale

interface LayerBuilder {
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

/***
 * The definitions for English keys, roughly-based on the MessagEase layout.
 * Alphas and numerics are in the same place, with the same possible gestures for them.
 */
abstract class GriddleLayerBuilder: LayerBuilder {
    private val nameRegex = Regex("(?<=[a-z])(?=[A-Z])")
    override val name get() = this::class.simpleName!!.split(nameRegex).dropLast(1).joinToString(" ") { s ->
        s.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
    }
    override fun build(context: Context): LayerDefinable = CreateLayout(
        context,
        name,
        allMappings(),
        keyboardHandedness,
        defalultSize,
        isPrimary,
        layerKind,
        languageTag,
    )
}