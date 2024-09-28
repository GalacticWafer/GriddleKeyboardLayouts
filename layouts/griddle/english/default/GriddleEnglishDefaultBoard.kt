package org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.default

import android.content.Context
import androidx.compose.ui.graphics.Color
import org.galacticware.griddle.keyboarddefinition.system.BaseSettingsLayer
import org.galacticware.griddle.keyboarddefinition.system.ClipboardLayer
import org.galacticware.griddle.keyboarddefinition.system.EmojiLayer
import org.galacticware.griddle.keyboarddefinition.system.UserSettingsLayer
import org.galacticware.griddle.domain.modifier.ModifierTheme
import org.galacticware.griddle.domain.keyboard.Keyboard
import org.galacticware.griddle.domain.geometry.GridPosition
import org.galacticware.griddle.keyboarddefinition.system.LanguagePreferencesLayer
//import org.galacticware.griddle.keyboarddefinition.system.MoveAndResizeBoardLayer
import org.galacticware.griddle.view.core.AppColor
import javax.inject.Inject


/**
 * The default English keyboard for the Griddle layout.
 * All default language keyboards (as opposed to user-defined ones) should follow the naming convention:
 * "<Language>DefaultBoard", where <Language> is the capitalized name of the given language.
 */
// Define all the layers that make up a keyboard as constructor parameters.
class EnglishDefaultBoard @Inject constructor(
    context: Context,
    griddleEnglishDefaultAlphaLayer: GriddleEnglishDefaultAlphaLayer,
    griddleEnglishDefaultNumericLayer: GriddleEnglishDefaultNumericLayer,
    griddleEnglishDefaultFunctionLayer: GriddleEnglishDefaultFunctionLayer,
    emojiLayer: EmojiLayer,
    clipboardLayer: ClipboardLayer,
    baseSettingsLayer: BaseSettingsLayer,
    userSettingsLayer: UserSettingsLayer,
    griddleEnglishDefaultUnifiedAlphaNumericLayer: GriddleEnglishDefaultUnifiedAlphaNumericLayer,
    languagePreferencesLayer: LanguagePreferencesLayer,
//    moveAndResizeBoardLayer: MoveAndResizeBoardLayer,
): Keyboard(
    context,
    layers = setOf(
        griddleEnglishDefaultAlphaLayer,
        griddleEnglishDefaultNumericLayer,
        griddleEnglishDefaultFunctionLayer,
        emojiLayer,
        clipboardLayer,
        baseSettingsLayer,
        griddleEnglishDefaultUnifiedAlphaNumericLayer,
        userSettingsLayer,
        languagePreferencesLayer,
//        moveAndResizeBoardLayer,
    )
) {
        companion object {
            // used to nest the keyboard another composable grid arrangement. Usually 1x1. Your
            // keyboard should probably also be 1x1.
            val positionAndSize: GridPosition = GridPosition.oneByOne

            val defaultModifierTheme = ModifierTheme(
                textColor = Color(0xFF00FFFF),
                backgroundColor = AppColor.PURPLE.color,
                borderColor = Color(0xFFFF559F),
            )
            const val DEFAULT_HEIGHT: Int = 7
            const val DEFAULT_WIDTH: Int = 9
        }
}

