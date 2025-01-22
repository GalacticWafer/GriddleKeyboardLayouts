package com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared

import androidx.compose.ui.unit.IntSize
import com.galacticware.griddle.domain.keyboard.KeyboardHandedness
import com.galacticware.griddle.domain.layer.LayerKind
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.GriddleLayerBuilder
import com.galacticware.griddle.keyboarddefinition.opensource.theme.DEFAULT_SIZE

object DefaultNumericMap: GriddleLayerBuilder() {
//    override val name = this::class.simpleName
    override val isPrimary: Boolean = false
    override val keyboardHandedness = KeyboardHandedness(hasHandedness = true, pivotColumn = 1)
    override val layerKind: LayerKind = LayerKind.NUMERIC
    override val languageTag = null
    override val defalultSize: IntSize = DEFAULT_SIZE

    val button0 = DefaultNumeroSymbolicMap.button0.withoutSymbols()
    val button1 = DefaultNumeroSymbolicMap.button0.withoutSymbols()
    val button2 = DefaultNumeroSymbolicMap.button2.withoutSymbols()
    val button3 = DefaultNumeroSymbolicMap.button3.withoutSymbols()
    val button4 = DefaultNumeroSymbolicMap.button4.withoutSymbols()
    val button5 = DefaultNumeroSymbolicMap.button5.withoutSymbols()
    val button6 = DefaultNumeroSymbolicMap.button6.withoutSymbols()
    val button7 = DefaultNumeroSymbolicMap.button7.withoutSymbols()
    val button8 = DefaultNumeroSymbolicMap.button8.withoutSymbols()
    val button9 = DefaultNumeroSymbolicMap.button9.withoutSymbols()

    override fun allMappings() = mutableSetOf(
        button1, button2, button3,
        button4, button5, button6,
        button7, button8, button9, button0,
        cursorControlButton,
        AlphabeticLayerToggle,
        backspace,
        enter,
        numericSpaceLeft,
        numericSpaceRight,
    )
}