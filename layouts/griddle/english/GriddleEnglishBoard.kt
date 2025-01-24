package com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english

import android.content.Context
import com.galacticware.griddle.domain.keyboard.Keyboard
import com.galacticware.griddle.domain.operation.SwitchScreenArgs
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultFunctionMap
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultNumericMap
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultNumeroSymbolicMap
import com.galacticware.griddle.view.composable.screen.SwitchableScreen

val OpenMacroEditor = SwitchScreenArgs(SwitchableScreen.MACRO_EDITOR)
val OpenMultiClipboard = SwitchScreenArgs(SwitchableScreen.CLIPBOARD)
val OpenAutoFixers = SwitchScreenArgs(SwitchableScreen.AUTO_FIXERS)
val OpenGriddleSetting = SwitchScreenArgs(SwitchableScreen.USER_SETTINGS)
val OpenLanguagePreferences = SwitchScreenArgs(SwitchableScreen.LANGUAGE_SELECTION)
val OpenKeyboardDesigner = SwitchScreenArgs(SwitchableScreen.BUILD_YOUR_OWN_KEYBOARD)
val OpenWordPrediction = SwitchScreenArgs(SwitchableScreen.WORD_PREDICTION)
val OpenEmojis = SwitchScreenArgs(SwitchableScreen.EMOJI)
val GriddleEnglishBoard = { context: Context ->
    Keyboard(
        context,
        name = "GriddleEnglishBoard",
        // Order matters! Instantiate language and numeric layers before
        // the alphanumeric layer, because it uses their mappings to
        // build its own.
        layers = listOf(
            GriddleEnglishLayerBuilder,
            DefaultNumericMap,
            DefaultNumeroSymbolicMap,
            GriddleAlphanumericEnglishMap,
            DefaultFunctionMap,
        )
            .map { it.build(context) }
            .toMutableSet()
    )
}