package com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.layer

import androidx.compose.ui.unit.IntSize
import com.galacticware.griddle.model.button.GestureButtonBuilder
import com.galacticware.griddle.model.keyboard.KeyboardHandedness
import com.galacticware.griddle.model.keyboard.definition.designs.base.GriddleLayerBuilder
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.button.GriddleButtonBuilders as builders
import com.galacticware.griddle.model.keyboard.definition.theme.DEFAULT_SIZE
import com.galacticware.griddle.model.language.LanguageTag
import com.galacticware.griddle.model.layer.LayerKind

object GriddleEnglishLayerBuilder: GriddleLayerBuilder() {
    override val isPrimary: Boolean = true
    override val keyboardHandedness = KeyboardHandedness(hasHandedness = true, pivotColumn = 1)
    override val defalultSize: IntSize = DEFAULT_SIZE
    override fun buttonBuilders(): MutableSet<GestureButtonBuilder> = _buttonBuilders
    override val layerKind: LayerKind = LayerKind.ALPHA
    override val languageTag = LanguageTag.ENGLISH


    private val _buttonBuilders by lazy {
        builders.let {
            mutableSetOf(
                it.englishA, it.englishN, it.englishI, it.settingsButton,
                it.englishH, it.englishO, it.englishR, it.NumericLayerToggle,
                it.englishT, it.englishE, it.englishS, it.backspace,
                it.space3u, it.enter
            )
        }
    }
}