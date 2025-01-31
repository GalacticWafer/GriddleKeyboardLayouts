package com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.layer

import androidx.compose.ui.unit.IntSize
import com.galacticware.griddle.model.button.GestureButtonBuilder
import com.galacticware.griddle.model.keyboard.KeyboardHandedness
import com.galacticware.griddle.model.keyboard.definition.designs.base.GriddleLayerBuilder
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

    private val _buttonBuilders = GriddleEnglishLayerBuilder.buttonBuilders()
        // button0 needs to be moved, so we need to remove the old version and add a new one.
        .minus(GriddleNumericLayerBuilder.button0).plus(
            GriddleNumericLayerBuilder.button0.reposition(colStart = 0, colSpan = 3),
        ).plus(
            setOf(
                GriddleNumericLayerBuilder.buttonBuilders()
                    .minus(GriddleNumericLayerBuilder.button0)
                // right-side buttons start at column <pivot column + 1> == 4
            ).flatten().map { it.reposition(colStart = 4 + it.gridPosition.colStart) }
        ).toMutableSet()

    override fun buttonBuilders(): MutableSet<GestureButtonBuilder> = _buttonBuilders
}