package com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.layer

import androidx.compose.ui.unit.IntSize
import com.galacticware.griddle.model.gesture.GestureType.HOLD
import com.galacticware.griddle.model.keybinder.KeyBinder.Companion.switchLayer
import com.galacticware.griddle.model.keyboard.KeyboardHandedness
import com.galacticware.griddle.model.layer.LayerKind
import com.galacticware.griddle.model.keyboard.definition.theme.DEFAULT_SIZE
import com.galacticware.griddle.model.keyboard.definition.designs.base.GriddleLayerBuilder
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.button.GriddleButtonBuilders as buttonBuilders

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
        buttonBuilders.settingsButton,
        buttonBuilders.AlphabeticLayerToggle.withGesture(switchLayer(HOLD, LayerKind.NUMERO_SYMBOLIC)),
        buttonBuilders.backspace,
        buttonBuilders.enter,
        buttonBuilders.numericSpaceLeft,
        buttonBuilders.numericSpaceRight,
    )
}