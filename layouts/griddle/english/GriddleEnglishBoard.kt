package com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english

import android.content.Context
import com.galacticware.griddle.domain.keyboard.Keyboard
import com.galacticware.griddle.domain.operation.implementation.switchscreens.SwitchScreenArgs
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultFunctionBuilder
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultNumericBuilder
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultNumeroSymbolicBuilder
import com.galacticware.griddle.view.composable.screen.SwitchableScreen

val OpenMacroEditor = SwitchScreenArgs(SwitchableScreen.SWITCH_TO_MACRO_EDITOR)
val OpenMultiClipboard = SwitchScreenArgs(SwitchableScreen.SWITCH_TO_CLIPBOARD)
val OpenAutoFixers = SwitchScreenArgs(SwitchableScreen.SWITCH_TO_AUTO_FIXERS)
val OpenGriddleSetting = SwitchScreenArgs(SwitchableScreen.SWITCH_TO_USER_CHANGEABLE_SETTINGS)
val OpenLanguagePreferences = SwitchScreenArgs(SwitchableScreen.SWITCH_TO_LANGUAGE_SELECTION)
val OpenKeyboardDesigner = SwitchScreenArgs(SwitchableScreen.SWITCH_TO_BUILD_YOUR_OWN_KEYBOARD)
val OpenWordPrediction = SwitchScreenArgs(SwitchableScreen.SWITCH_TO_WORD_PREDICTION)
val OpenEmojis = SwitchScreenArgs(SwitchableScreen.SWITCH_TO_EMOJI)

















val GriddleEnglishBoard = { context: Context ->
    Keyboard(
        context,
        name = "GriddleEnglishBoard",
        // Order matters! Instantiate language and numeric layers before
        // the alphanumeric layer, because it uses their mappings to
        // build its own.
        layers = listOf(
            GriddleEnglishLayerBuilder,
            DefaultNumericBuilder,
            DefaultNumeroSymbolicBuilder,
            GriddleAlphanumericEnglishBuilder,
            DefaultFunctionBuilder,
        )
            .map { it.build(context) }
            .toMutableSet()
    )
}