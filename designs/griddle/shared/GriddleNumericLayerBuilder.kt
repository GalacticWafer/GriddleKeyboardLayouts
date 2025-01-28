package com.galacticware.griddle.model.keyboard.definition.designs.griddle.shared

import androidx.compose.ui.unit.IntSize
import com.galacticware.griddle.model.gesture.GestureType.HOLD
import com.galacticware.griddle.model.keybinder.KeyBinder.Companion.switchLayer
import com.galacticware.griddle.model.keyboard.KeyboardHandedness
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.builder.AlphabeticLayerToggle
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.builder.backspace
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.builder.cursorControlButton
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.builder.enter
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.builder.numericSpaceLeft
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.builder.numericSpaceRight
import com.galacticware.griddle.model.layer.LayerKind
import com.galacticware.griddle.model.keyboard.definition.theme.DEFAULT_SIZE
import com.galacticware.griddle.model.layer.GriddleLayerBuilder

object GriddleNumericLayerBuilder: GriddleLayerBuilder() {
    override val isPrimary: Boolean = false
    override val keyboardHandedness = KeyboardHandedness(hasHandedness = true, pivotColumn = 1)
    override val layerKind: LayerKind = LayerKind.NUMERIC
    override val languageTag = null
    override val defalultSize: IntSize = DEFAULT_SIZE

    val button0 = GriddleNumeroSymbolicLayerBuilder.button0.withoutSymbols()
    val button1 = GriddleNumeroSymbolicLayerBuilder.button1.withoutSymbols()
    val button2 = GriddleNumeroSymbolicLayerBuilder.button2.withoutSymbols()
    val button3 = GriddleNumeroSymbolicLayerBuilder.button3.withoutSymbols()
    val button4 = GriddleNumeroSymbolicLayerBuilder.button4.withoutSymbols()
    val button5 = GriddleNumeroSymbolicLayerBuilder.button5.withoutSymbols()
    val button6 = GriddleNumeroSymbolicLayerBuilder.button6.withoutSymbols()
    val button7 = GriddleNumeroSymbolicLayerBuilder.button7.withoutSymbols()
    val button8 = GriddleNumeroSymbolicLayerBuilder.button8.withoutSymbols()
    val button9 = GriddleNumeroSymbolicLayerBuilder.button9.withoutSymbols()

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