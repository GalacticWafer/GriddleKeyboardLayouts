package org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english

import android.content.Context
import org.galacticware.griddle.domain.keyboard.Keyboard
import org.galacticware.griddle.domain.keyboard.KeyboardKind
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultFunctionMap
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultNumericMap
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.MessageaseNumbersWithSymbolsMap


val GriddleEnglishBoard = { context: Context ->
    Keyboard(
        context,
        layers = listOf(
            GriddleEnglishMap,
            DefaultNumericMap,
            GriddleAlphanumericEnglishMap,
            MessageaseNumbersWithSymbolsMap,
            DefaultFunctionMap,
        )
            .map { it.build(context) }
            .toMutableSet()
        ,
        name = "Griddle English",
        KeyboardKind.DEFAULT,
    )
}