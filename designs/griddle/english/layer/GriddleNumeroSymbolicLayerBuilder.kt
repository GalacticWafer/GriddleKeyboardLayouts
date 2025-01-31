package com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.layer

import androidx.compose.ui.unit.IntSize
import com.galacticware.griddle.model.gesture.GestureType.CLICK
import com.galacticware.griddle.model.keybinder.KeyBinder.Companion.simpleInput
import com.galacticware.griddle.model.keyboard.KeyboardHandedness
import com.galacticware.griddle.model.layer.LayerKind
import com.galacticware.griddle.model.keyboard.definition.theme.DEFAULT_SIZE
import com.galacticware.griddle.model.keyboard.definition.designs.base.GriddleLayerBuilder
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.button.GriddleButtonBuilders as builders

object GriddleNumeroSymbolicLayerBuilder: GriddleLayerBuilder() {
    override val isPrimary: Boolean = false
    override val keyboardHandedness = KeyboardHandedness(hasHandedness = true, pivotColumn = 1)
    override val layerKind: LayerKind = LayerKind.NUMERO_SYMBOLIC
    override val languageTag = null
    override val defalultSize: IntSize = DEFAULT_SIZE

    val button0 by lazy { builders.space.reposition(rowStart = 3, colStart = 1).withGesture(simpleInput(CLICK, "0")) }
    val button1 by lazy { builders.englishA.withoutLetters().withGesture(simpleInput(CLICK, "1")) }
    val button2 by lazy { builders.englishN.withoutLetters().withGesture(simpleInput(CLICK, "2")) }
    val button3 by lazy { builders.englishI.withoutLetters().withGesture(simpleInput(CLICK, "3")) }
    val button4 by lazy { builders.englishH.withoutLetters().withGesture(simpleInput(CLICK, "4")) }
    val button5 by lazy { builders.englishO.withoutLetters().withGesture(simpleInput(CLICK, "5")) }
    val button6 by lazy { builders.englishR.withoutLetters().withGesture(simpleInput(CLICK, "6")) }
    val button7 by lazy { builders.englishT.withoutLetters().withGesture(simpleInput(CLICK, "7")) }
    val button8 by lazy { builders.englishE.withoutLetters().withGesture(simpleInput(CLICK, "8")) }
    val button9 by lazy { builders.englishS.withoutLetters().withGesture(simpleInput(CLICK, "9")) }

    override fun buttonBuilders() = mutableSetOf(
        button1, button2, button3, button4, button5, button6, button7, button8, button9, button0,
        builders.settingsButton,
        builders.AlphabeticLayerToggle,
        builders.backspace,
        builders.enter,
        builders.numericSpaceLeft,
        builders.numericSpaceRight,
    )
}