package org.galacticware.griddle.keyboarddefinition.keyboarddefinitions.layouts.griddle.english.default

import android.graphics.Rect
import org.galacticware.griddle.domain.keyboard.KeyboardHandedness
import org.galacticware.griddle.domain.griddlebutton.GestureButtonType
import org.galacticware.griddle.domain.layer.LayerDefinition
import org.galacticware.griddle.domain.layer.LayerType
import org.galacticware.griddle.keyboarddefinition.system.AbstractKeyboardLayer

class GriddleEnglishDefaultFunctionLayer : AbstractKeyboardLayer(
    griddleButtonBuilders = buttonBuilders,
    defaultButtonSample = run {
        buttonBuilder(
            rowStart = 0, colStart = 0, rowSpan = 1, colSpan = 1, widthRuler = EnglishDefaultBoard.DEFAULT_WIDTH,
            heightRuler = EnglishDefaultBoard.DEFAULT_HEIGHT,
            modifierTheme = EnglishDefaultBoard.defaultModifierTheme,
            boxType = GestureButtonType.TWENTY_GESTURE_CLASSIC,
            settingsValueProvider = null,
        )
    },
    borderColor = EnglishDefaultBoard.defaultModifierTheme.borderColor,
    backgroundColor = EnglishDefaultBoard.defaultModifierTheme.backgroundColor,
    textColor = EnglishDefaultBoard.defaultModifierTheme.textColor,
    fontSize = EnglishDefaultBoard.defaultModifierTheme.calculateFontSize(
        availableSpace = Rect(0, 0, 1, 1),
    ),
    keyboardHandedness = KeyboardHandedness(
        hasHandedness = true,
        pivotColumn = 1,
    ),
) {
    override val builders = buttonBuilders
    companion object {
        val buttonBuilders=  setOf(
            f1, f2, f3, cursorControlButton,
            f4, f5, f6, rightAlphaLayerToggle,
            f7, f8, f9, backspace,
            f10, f11, f12, enter,
        )
    }
    override val layerDefinition = LayerDefinition.FUNCTION_LAYER
    override val layerType = LayerType.FUNCTION
}