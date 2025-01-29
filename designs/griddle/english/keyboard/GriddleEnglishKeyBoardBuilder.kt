package com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.keyboard

import android.content.Context
import com.galacticware.griddle.model.keyboard.Keyboard
import com.galacticware.griddle.model.keyboard.definition.designs.base.KeyboardBuilder
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.layer.GriddleAlphanumericEnglishLayerBuilder
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.layer.GriddleEnglishLayerBuilder
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.shared.layer.GriddleFunctionLayerBuilder
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.shared.layer.GriddleNumericLayerBuilder
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.shared.layer.GriddleNumeroSymbolicLayerBuilder

/**
 *
 * Build an English keyboard with the "Griddle" layout, using all the layers
 * defined in the
 * [com.galacticware.griddle.model.keyboard.definition.designs.griddle] package.
 */
object GriddleEnglishKeyBoardBuilder: KeyboardBuilder {
    override fun build(context: Context ): Keyboard = Keyboard(
        context,
        name = "GriddleEnglishBoard",
        layers = setOf(
            GriddleEnglishLayerBuilder,
            GriddleNumericLayerBuilder,
            GriddleNumeroSymbolicLayerBuilder,
            GriddleAlphanumericEnglishLayerBuilder,
            GriddleFunctionLayerBuilder,
        )
            .map { it.build(context) }
            .toMutableSet()
    )
}