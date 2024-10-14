package org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.french

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntSize
import org.galacticware.griddle.domain.geometry.GridPosition
import org.galacticware.griddle.domain.keyboard.Keyboard
import org.galacticware.griddle.domain.modifier.ModifierTheme
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.GriddleFunctionLayer
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.GriddleNumericLayer
import org.galacticware.griddle.keyboarddefinition.system.EmojiScreen
import org.galacticware.griddle.view.core.AppColor
import javax.inject.Inject


/**
 * The default French keyboard for the Griddle layout.
 * All default language keyboards (as opposed to user-defined ones) should follow the naming convention:
 * "<Language>DefaultBoard", where <Language> is the capitalized name of the given language.
 */
// Define all the layers that make up a keyboard as constructor parameters.
class GriddleFrenchBoard @Inject constructor(
    context: Context,
    griddleFrenchLayer: GriddleFrenchLayer,
    griddleNumericLayer: GriddleNumericLayer,
    griddleFunctionLayer: GriddleFunctionLayer,
    emojiScreen: EmojiScreen,
    griddleFrenchAlphaNumericLayer: GriddleFrenchAlphaNumericLayer,
): Keyboard(
    context,
    layers = setOf(
        griddleFrenchLayer,
        griddleNumericLayer,
        griddleFunctionLayer,
        griddleFrenchAlphaNumericLayer,
    )
) {
        companion object {
            // used to nest the keyboard another composable grid arrangement. Usually 1x1. Your
            // keyboard should probably also be 1x1.
            val positionAndSize: GridPosition = GridPosition.originUnit

            val defaultModifierTheme = ModifierTheme(
                textColor = Color(0xFF00FFFF),
                backgroundColor = AppColor.PURPLE.color,
                borderColor = Color(0xFFFF559F),
            )
            const val DEFAULT_HEIGHT: Int = 70
            const val DEFAULT_WIDTH: Int = 90
            val defaultButtonSize = IntSize(DEFAULT_WIDTH, DEFAULT_HEIGHT)
        }
}

