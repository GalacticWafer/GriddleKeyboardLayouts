package com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english

import android.content.Context
import com.galacticware.griddle.domain.keyboard.Keyboard
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultFunctionMap
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultNumericMap
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultNumeroSymbolicMap


val GriddleEnglishBoard = { context: Context ->
    Keyboard(
        context,
        // Order matters! Instantiate language and numeric layers before
        // the alphanumeric layer, because it uses their mappings to
        // build its own.
        layers = listOf(
            GriddleEnglishMap,
            DefaultNumericMap,
            DefaultNumeroSymbolicMap,
            GriddleAlphanumericEnglishMap,
            DefaultFunctionMap,
        )
            .map { it.build(context) }
            .toMutableSet()
    )
}