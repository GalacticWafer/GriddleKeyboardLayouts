package org.galacticware.griddle.keyboarddefinition.keyboarddefinitions.layouts.griddle.english.default

import android.graphics.Rect
import org.galacticware.griddle.domain.keyboard.KeyboardHandedness
import org.galacticware.griddle.keyboarddefinition.system.AbstractKeyboardLayer
import org.galacticware.griddle.domain.layer.LayerType
import org.galacticware.griddle.domain.griddlebutton.GestureButtonType
import org.galacticware.griddle.domain.layer.LayerDefinition
import org.galacticware.griddle.keyboarddefinition.system.AbstractKeyboardLayer.Companion.buttonBuilder


val defaultButtonSample = buttonBuilder(
    rowStart = 0, colStart = 0, rowSpan = 1, colSpan = 1,    widthRuler = EnglishDefaultBoard.DEFAULT_WIDTH,
    heightRuler = EnglishDefaultBoard.DEFAULT_HEIGHT,
    modifierTheme = EnglishDefaultBoard.defaultModifierTheme,
    boxType = GestureButtonType.TWENTY_GESTURE_CLASSIC,
    settingsValueProvider = null,
)

class GriddleEnglishDefaultNumericLayer : AbstractKeyboardLayer(
    griddleButtonBuilders = buttonBuilders,
    defaultButtonSample = defaultButtonSample,
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
    override val layerDefinition = LayerDefinition.NUMERIC_LAYER
    override val layerType = LayerType.NUMERIC
    override val builders = buttonBuilders
    companion object {
        val buttonBuilders =  setOf(
            button1, button2, button3, cursorControlButton,
            button4, button5, button6, rightAlphaLayerToggle,
            button7, button8, button9,
            backspace, enter,
            numericSpaceLeft, button0, numericSpaceRight,
        )
    }
}