package com.galacticware.griddle.model.keyboard.definition.designs.base

import android.content.Context
import androidx.compose.ui.unit.IntSize
import com.galacticware.griddle.model.button.GestureButtonBuilder
import com.galacticware.griddle.model.keyboard.KeyboardHandedness
import com.galacticware.griddle.model.language.LanguageTag
import com.galacticware.griddle.model.layer.LayerDefinable
import com.galacticware.griddle.model.layer.LayerKind

interface LayerBuilder {
    val name: String
    val languageTag: LanguageTag?
    val layerKind: LayerKind
    val isPrimary: Boolean
    val keyboardHandedness: KeyboardHandedness
    val defalultSize: IntSize
    fun buttonBuilders(): MutableSet<GestureButtonBuilder>
    fun build(context: Context): LayerDefinable
}