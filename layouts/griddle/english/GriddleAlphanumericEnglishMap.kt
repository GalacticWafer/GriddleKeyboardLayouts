package com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english

import androidx.compose.ui.unit.IntSize
import com.galacticware.griddle.domain.button.GestureButton
import com.galacticware.griddle.domain.button.GestureButtonBuilder
import com.galacticware.griddle.domain.keyboard.KeyboardHandedness
import com.galacticware.griddle.domain.layer.LayerKind
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishMap.englishA
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishMap.englishI
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishMap.englishN
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishMap.englishE
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishMap.englishH
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishMap.englishO
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishMap.englishR
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishMap.englishS
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishMap.englishT
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.AlphabeticLayerToggle
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultNumericMap.button0
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultNumericMap.button1
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultNumericMap.button2
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultNumericMap.button3
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultNumericMap.button4
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultNumericMap.button5
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultNumericMap.button6
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultNumericMap.button7
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultNumericMap.button8
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultNumericMap.button9
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.backspace
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.cursorControlButton
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.enter
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.space
import com.galacticware.griddle.keyboarddefinition.system.layerkind.AbstractKeyboardLayer

/**
 * All language layers should have the  [AbstractKeyboardLayer.layerKind] property set to [LayerKind.ALPHA].
 */
object GriddleAlphanumericEnglishMap : GriddleKeyMap() {
    override val isPrimary: Boolean = false
    override val keyboardHandedness = KeyboardHandedness(hasHandedness = true, pivotColumn = 3)
    override val layerKind: LayerKind = LayerKind.UNIFIED_ALPHA_NUMERIC
    override val languageTag = null
    override val defalultSize: IntSize = IntSize(45, 35)

    override fun allMappings(): MutableSet<GestureButtonBuilder> {
        return setOf(
            englishA, englishN, englishI,
            englishH, englishO, englishR, cursorControlButton,
            englishT, englishE, englishS, AlphabeticLayerToggle, backspace,
            space, enter,
        ).plus(
            setOf(
                button1, button2, button3,
                button4, button5, button6,
                button7, button8, button9,
                button0.withPosition(colStart = 0, colSpan = 3),
                // right-side buttons start at column <pivot column + 1> == 4
            ).map { it.withPosition(colStart = 4 + it.gridPosition.colStart) }
        ).toMutableSet()
    }
}