package com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared

import androidx.compose.ui.unit.IntSize
import com.galacticware.griddle.domain.gesture.GestureType.CLICK
import com.galacticware.griddle.domain.keybinder.KeyBinder.Companion.bindGesture
import com.galacticware.griddle.domain.keybinder.KeyBinder.Companion.simpleInput
import com.galacticware.griddle.domain.keyboard.KeyboardHandedness
import com.galacticware.griddle.domain.layer.LayerKind
import com.galacticware.griddle.domain.operation.SimpleInput
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.GriddleLayerBuilder
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishLayerBuilder.englishA
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishLayerBuilder.englishE
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishLayerBuilder.englishH
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishLayerBuilder.englishI
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishLayerBuilder.englishN
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishLayerBuilder.englishO
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishLayerBuilder.englishR
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishLayerBuilder.englishS
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishLayerBuilder.englishT
import com.galacticware.griddle.keyboarddefinition.opensource.theme.DEFAULT_SIZE

object DefaultNumeroSymbolicMap: GriddleLayerBuilder() {
    override val isPrimary: Boolean = false
    override val keyboardHandedness = KeyboardHandedness(hasHandedness = true, pivotColumn = 1)
    override val layerKind: LayerKind = LayerKind.NUMERO_SYMBOLIC
    override val languageTag = null
    override val defalultSize: IntSize = DEFAULT_SIZE

    val button0 = button_0_0.withPosition(rowStart = 3, colStart = 1).withGesture(simpleInput(CLICK,"0"))
    val button1 = englishA.withoutLetters().withGesture(simpleInput(CLICK,"1"))
    val button2 = englishN.withoutLetters().withGesture(simpleInput(CLICK,"2"))
    val button3 = englishI.withoutLetters().withGesture(simpleInput(CLICK,"3"))
    val button4 = englishH.withoutLetters().withGesture(simpleInput(CLICK,"4"))
    val button5 = englishO.withoutLetters().withGesture(simpleInput(CLICK,"5"))
    val button6 = englishR.withoutLetters().withGesture(simpleInput(CLICK,"6"))
    val button7 = englishT.withoutLetters().withGesture(simpleInput(CLICK,"7"))
    val button8 = englishE.withoutLetters().withGesture(simpleInput(CLICK,"8"))
    val button9 = englishS.withoutLetters().withGesture(simpleInput(CLICK,"9"))

    override fun buttonBuilders() = mutableSetOf(
        button1, button2, button3, button4, button5, button6, button7, button8, button9, button0,
        cursorControlButton,
        AlphabeticLayerToggle,
        backspace,
        enter,
        numericSpaceLeft,
        numericSpaceRight,
    )
}