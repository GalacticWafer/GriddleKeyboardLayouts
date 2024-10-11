package org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntSize
import org.galacticware.griddle.keyboarddefinition.system.ClipboardLayer
import org.galacticware.griddle.keyboarddefinition.system.EmojiLayer
import org.galacticware.griddle.keyboarddefinition.system.UserSettingsScreen
import org.galacticware.griddle.domain.modifier.ModifierTheme
import org.galacticware.griddle.domain.keyboard.Keyboard
import org.galacticware.griddle.domain.geometry.GridPosition
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.GriddleFunctionLayer
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.GriddleNumericLayer
import org.galacticware.griddle.keyboarddefinition.system.LanguagePreferencesLayer
import org.galacticware.griddle.view.core.AppColor
import javax.inject.Inject


/**
 * The default English keyboard for the Griddle layout.
 * All default language keyboards (as opposed to user-defined ones) should follow the naming convention:
 * "<Language>DefaultBoard", where <Language> is the capitalized name of the given language.
 */
// Define all the layers that make up a keyboard as constructor parameters.
class GriddleEnglishBoard @Inject constructor(
    context: Context,
    griddleEnglishLayer: GriddleEnglishLayer,
    griddleNumericLayer: GriddleNumericLayer,
    griddleFunctionLayer: GriddleFunctionLayer,
    emojiLayer: EmojiLayer,
    clipboardLayer: ClipboardLayer,
    griddleEnglishAlphaNumericLayer: GriddleEnglishAlphaNumericLayer,
    languagePreferencesLayer: LanguagePreferencesLayer,
): Keyboard(
    context,
    layers = setOf(
        griddleEnglishLayer,
        griddleNumericLayer,
        griddleFunctionLayer,
        emojiLayer,
        clipboardLayer,
        griddleEnglishAlphaNumericLayer,
        languagePreferencesLayer,
    )
) {
        companion object {
            // used to nest the keyboard another composable grid arrangement. Usually 1x1. Your
            // keyboard should probably also be 1x1.
            val positionAndSize: GridPosition = GridPosition.oneByOne

            val defaultModifierTheme = ModifierTheme(
                textColor = AppColor.MEOK_DEFAULT_YELLOW.color,
                backgroundColor = AppColor.MEOK_DARK_GRAY.color,
                borderColor = AppColor.MEOK_LIGHT_GRAY.color,
                secondaryTextColor = Color.White,
                secondaryBackgroundColor = AppColor.MEOK_LIGHT_GRAY.color,
            )
            const val DEFAULT_HEIGHT: Int = 70
            const val DEFAULT_WIDTH: Int = 90
            val defaultButtonSize = IntSize(DEFAULT_WIDTH, DEFAULT_HEIGHT)
        }
}

