package com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english

import android.content.Context
import com.galacticware.griddle.domain.keyboard.Keyboard
import com.galacticware.griddle.domain.operation.makeSwitchNestedKeyboardScreenArgs
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultFunctionMap
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultNumericMap
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.DefaultNumeroSymbolicMap
import com.galacticware.griddle.view.composable.screen.UserSwitchableScreen

val OpenMacroEditor = makeSwitchNestedKeyboardScreenArgs(UserSwitchableScreen.MACRO_EDITOR)
val OpenMultiClipboard = makeSwitchNestedKeyboardScreenArgs(UserSwitchableScreen.CLIPBOARD)
val OpenAutoFixers = makeSwitchNestedKeyboardScreenArgs(UserSwitchableScreen.AUTO_FIXERS)
val OpenUserSettings = makeSwitchNestedKeyboardScreenArgs(UserSwitchableScreen.USER_SETTINGS)
val OpenLanguagePreferences = makeSwitchNestedKeyboardScreenArgs(UserSwitchableScreen.LANGUAGE_SELECTION)
val OpenKeyboardDesigner = makeSwitchNestedKeyboardScreenArgs(UserSwitchableScreen.BUILD_YOUR_OWN_KEYBOARD)
val OpenWordPrediction = makeSwitchNestedKeyboardScreenArgs(UserSwitchableScreen.WORD_PREDICTION)
val OpenEmojis = makeSwitchNestedKeyboardScreenArgs(UserSwitchableScreen.EMOJI)
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