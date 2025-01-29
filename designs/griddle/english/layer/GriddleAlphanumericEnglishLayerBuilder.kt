package com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.layer

import androidx.compose.ui.unit.IntSize
import com.galacticware.griddle.model.button.GestureButtonBuilder
import com.galacticware.griddle.model.keyboard.KeyboardHandedness
import com.galacticware.griddle.model.keyboard.definition.designs.base.GriddleLayerBuilder
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.shared.layer.GriddleNumericLayerBuilder.button0
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.shared.layer.GriddleNumericLayerBuilder.button1
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.shared.layer.GriddleNumericLayerBuilder.button2
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.shared.layer.GriddleNumericLayerBuilder.button3
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.shared.layer.GriddleNumericLayerBuilder.button4
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.shared.layer.GriddleNumericLayerBuilder.button5
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.shared.layer.GriddleNumericLayerBuilder.button6
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.shared.layer.GriddleNumericLayerBuilder.button7
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.shared.layer.GriddleNumericLayerBuilder.button8
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.shared.layer.GriddleNumericLayerBuilder.button9
import com.galacticware.griddle.model.keyboard.system.layerkind.AbstractKeyboardLayer
import com.galacticware.griddle.model.layer.LayerKind

/**
 * All language layers should have the  [AbstractKeyboardLayer.layerKind] property set to [LayerKind.ALPHA].
 */
object GriddleAlphanumericEnglishLayerBuilder : GriddleLayerBuilder() {
    override val isPrimary: Boolean = false
    override val keyboardHandedness = KeyboardHandedness(hasHandedness = true, pivotColumn = 3)
    override val layerKind: LayerKind = LayerKind.UNIFIED_ALPHA_NUMERIC
    override val languageTag = null
    override val defalultSize: IntSize = IntSize(45, 35)

    override fun buttonBuilders(): MutableSet<GestureButtonBuilder> {
        return GriddleEnglishLayerBuilder.buttonBuilders()
            .minus(button0).plus(button0.reposition(colStart = 0, colSpan = 3),
        ).plus(
            setOf(
                button1, button2, button3,
                button4, button5, button6,
                button7, button8, button9,
                // right-side buttons start at column <pivot column + 1> == 4
            ).map { it.reposition(colStart = 4 + it.gridPosition.colStart) }
        ).toMutableSet()
    }
}