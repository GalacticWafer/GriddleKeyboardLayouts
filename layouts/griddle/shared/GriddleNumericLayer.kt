package com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared

import androidx.compose.ui.unit.IntSize
import com.galacticware.griddle.domain.gesture.GestureType.HOLD
import com.galacticware.griddle.domain.keybinder.KeyBinder.Companion.switchLayer
import com.galacticware.griddle.domain.keyboard.KeyboardHandedness
import com.galacticware.griddle.domain.layer.LayerKind
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.GriddleLayerBuilder
import com.galacticware.griddle.keyboarddefinition.opensource.theme.DEFAULT_SIZE

object DefaultNumericBuilder: GriddleLayerBuilder() {
    override val isPrimary: Boolean = false
    override val keyboardHandedness = KeyboardHandedness(hasHandedness = true, pivotColumn = 1)
    override val layerKind: LayerKind = LayerKind.NUMERIC
    override val languageTag = null
    override val defalultSize: IntSize = DEFAULT_SIZE

    val button0 = DefaultNumeroSymbolicBuilder.button0.withoutSymbols()
    val button1 = DefaultNumeroSymbolicBuilder.button1.withoutSymbols()
    val button2 = DefaultNumeroSymbolicBuilder.button2.withoutSymbols()
    val button3 = DefaultNumeroSymbolicBuilder.button3.withoutSymbols()
    val button4 = DefaultNumeroSymbolicBuilder.button4.withoutSymbols()
    val button5 = DefaultNumeroSymbolicBuilder.button5.withoutSymbols()
    val button6 = DefaultNumeroSymbolicBuilder.button6.withoutSymbols()
    val button7 = DefaultNumeroSymbolicBuilder.button7.withoutSymbols()
    val button8 = DefaultNumeroSymbolicBuilder.button8.withoutSymbols()
    val button9 = DefaultNumeroSymbolicBuilder.button9.withoutSymbols()

    override fun buttonBuilders() = mutableSetOf(
        button1, button2, button3,
        button4, button5, button6,
        button7, button8, button9, button0,
        cursorControlButton,
        AlphabeticLayerToggle.withGesture(switchLayer(HOLD, LayerKind.NUMERO_SYMBOLIC)),
        backspace,
        enter,
        numericSpaceLeft,
        numericSpaceRight,
    )
}