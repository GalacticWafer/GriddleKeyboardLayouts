package com.galacticware.griddle.model.keyboard.definition.designs.griddle.builder

import android.content.Context
import com.galacticware.griddle.model.keyboard.Keyboard
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.GriddleAlphanumericEnglishLayerBuilder
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.GriddleEnglishLayerBuilder
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.shared.GriddleFunctionLayerBuilder
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.shared.GriddleNumericLayerBuilder
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.shared.GriddleNumeroSymbolicLayerBuilder

/**
 * Build an English keyboard with the "Griddle" layout, using all the layers
 * defined in the
 * [com.galacticware.griddle.model.keyboard.definition.designs.griddle] package.
 */
val GriddleEnglishBoardBuilder = { context: Context ->
    Keyboard(
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