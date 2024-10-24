package org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english

import androidx.compose.ui.unit.IntSize
import org.galacticware.griddle.domain.griddlebutton.builder.GriddleButtonBuilder
import org.galacticware.griddle.domain.keyboard.KeyboardHandedness
import org.galacticware.griddle.domain.layer.LayerKind
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishMap.englishA
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishMap.englishI
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishMap.englishN
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishMap.englishE
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishMap.englishH
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishMap.englishO
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishMap.englishR
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishMap.englishS
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishMap.englishT
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.AlphabeticLayerToggle
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
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.backspace
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.cursorControlButton
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.enter
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.space
import org.galacticware.griddle.keyboarddefinition.system.layerkind.AbstractKeyboardLayout

/**
 * All language layers should have the  [AbstractKeyboardLayout.layerKind] property set to [LayerKind.ALPHA].
 */
object GriddleAlphanumericEnglishMap : GriddleKeyMap() {
    override val isPrimary: Boolean = false
    override val keyboardHandedness = KeyboardHandedness(hasHandedness = true, pivotColumn = 3)
    override val layerKind: LayerKind = LayerKind.UNIFIED_ALPHA_NUMERIC
    override val languageTag = null
    override val defalultSize: IntSize = IntSize(45, 35)

    override fun allMappings(): MutableSet<GriddleButtonBuilder> {
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