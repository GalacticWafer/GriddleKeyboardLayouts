package org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared

import androidx.compose.ui.unit.IntSize
import org.galacticware.griddle.domain.button.GestureButtonBuilder
import org.galacticware.griddle.domain.keyboard.KeyboardHandedness
import org.galacticware.griddle.domain.layer.LayerKind
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.GriddleKeyMap
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishMap.englishA
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishMap.englishE
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishMap.englishH
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishMap.englishI
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishMap.englishN
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishMap.englishO
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishMap.englishR
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishMap.englishS
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishMap.englishT
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultNumericMap.button0
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultNumericMap.button1
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultNumericMap.button2
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultNumericMap.button3
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultNumericMap.button4
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultNumericMap.button5
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultNumericMap.button6
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultNumericMap.button7
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultNumericMap.button8
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultNumericMap.button9

object MessageaseNumbersWithSymbolsMap : GriddleKeyMap() {
    override val isPrimary = false
    override val keyboardHandedness = KeyboardHandedness(hasHandedness = true, pivotColumn = 3)
    override val layerKind = LayerKind.NUMERIC_WITH_SYMBOLS
    override val languageTag = null
    override val defalultSize = IntSize(45, 35)

    override fun allMappings(): MutableSet<GestureButtonBuilder> {
        return listOf(
            englishA to button1, englishN to button2, englishI to button3,
            englishH to button4, englishO to button5, englishR to button6,
            englishT to button7, englishE to button8, englishS to button9,
        ).map { (englishGestures, numpadGestures) ->
            numpadGestures.combinedWith(englishGestures.withoutLetters().gestureSet)
        }.plus(
            setOf(
                button0,
                cursorControlButton,
                AlphabeticLayerToggle, backspace,
                space, enter,
            )
        ).toMutableSet()
    }
}