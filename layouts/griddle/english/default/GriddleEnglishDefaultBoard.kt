package org.galacticware.griddle.keyboarddefinition.layouts.griddle.english.default

import android.content.Context
import androidx.compose.ui.graphics.Color
import org.galacticware.griddle.keyboarddefinition.system.BaseSettingsLayer
import org.galacticware.griddle.keyboarddefinition.system.ClipboardLayer
import org.galacticware.griddle.keyboarddefinition.system.CustomizeKeyboardLayer
import org.galacticware.griddle.keyboarddefinition.system.EmojiLayer
import org.galacticware.griddle.keyboarddefinition.system.LayoutEditorLayer
import org.galacticware.griddle.keyboarddefinition.system.UserSettingsLayer
import org.galacticware.griddle.domain.modifier.ModifierTheme
import org.galacticware.griddle.domain.keyboard.Keyboard
import org.galacticware.griddle.domain.geometry.GridPosition
import org.galacticware.griddle.keyboarddefinition.system.MoveAndResizeBoardLayer
import org.galacticware.griddle.view.core.AppColor
import javax.inject.Inject


/**
 * The default English keyboard for the Griddle layout.
 * All default language keyboards (as opposed to user-defined ones) should follow the naming convention:
 * "<Language>DefaultBoard", where <Language> is the capitalized name of the given language.
 */
class EnglishDefaultBoard @Inject constructor(
    context: Context,
    griddleEnglishDefaultAlphaLayer: GriddleEnglishDefaultAlphaLayer,
    griddleEnglishDefaultNumericLayer: GriddleEnglishDefaultNumericLayer,
    griddleEnglishDefaultFunctionLayer: GriddleEnglishDefaultFunctionLayer,
    layoutEditorLayer: LayoutEditorLayer,
    emojiLayer: EmojiLayer,
    clipboardLayer: ClipboardLayer,
    baseSettingsLayer: BaseSettingsLayer,
    userSettingsLayer: UserSettingsLayer,
    customizeKeyboardLayer: CustomizeKeyboardLayer,
    griddleEnglishDefaultUnifiedAlphaNumericLayer: GriddleEnglishDefaultUnifiedAlphaNumericLayer,
    moveAndResizeBoardLayer: MoveAndResizeBoardLayer,
): Keyboard(
    context,
    layers = setOf(
        griddleEnglishDefaultAlphaLayer,
        griddleEnglishDefaultNumericLayer,
        griddleEnglishDefaultFunctionLayer,
        layoutEditorLayer,
        emojiLayer,
        clipboardLayer,
        baseSettingsLayer,
        userSettingsLayer,
        customizeKeyboardLayer,
        griddleEnglishDefaultUnifiedAlphaNumericLayer,
        moveAndResizeBoardLayer,
    )
) {
        companion object {
            val positionAndSize: GridPosition = GridPosition.oneByOne

            /**
             * Todo, we should try to get the theme from user settings first, and return the default if not found.
             */
            val defaultModifierTheme = ModifierTheme(
                textColor = Color(0xFF00FFFF),
                // Change backgroundColor for debug
                backgroundColor = AppColor.PURPLE.color,
                borderColor = Color(0xFFFF559F),
            )
            val DEFAULT_HEIGHT: Int = 7
            val DEFAULT_WIDTH: Int = 9
        }
}

