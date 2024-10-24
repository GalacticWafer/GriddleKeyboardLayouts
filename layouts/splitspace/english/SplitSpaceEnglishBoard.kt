package org.galacticware.griddle.keyboarddefinition.opensource.layouts.splitspace.english

import android.content.Context
import org.galacticware.griddle.domain.keyboard.Keyboard
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultFunctionMap
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultNumericMap


val SplitSpaceEnglishBoard = { context: Context ->
    Keyboard(
        context,
        // Order matters! Instantiate language and numeric layers before
        // the alphanumeric layer, because it uses their mappings to
        // build its own.
        layers = listOf(
            SplitSpaceEnglishMap,
            DefaultNumericMap,
            SplitSpaceAlphanumericEnglishMap,
            DefaultFunctionMap,
        )
            .map { it.build(context) }
            .toMutableSet()
    )
}