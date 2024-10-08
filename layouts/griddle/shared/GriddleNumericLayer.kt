package org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared

import android.content.Context
import android.graphics.Rect
import org.galacticware.griddle.domain.keyboard.KeyboardHandedness
import org.galacticware.griddle.keyboarddefinition.system.AbstractKeyboardLayer
import org.galacticware.griddle.domain.layer.LayerType
import org.galacticware.griddle.domain.layer.LayerDefinition
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.GriddleEnglishBoard

class GriddleNumericLayer(
    context: Context,
) : AbstractKeyboardLayer(
    context,
    griddleButtonBuilders = buttonBuilders,
    borderColor = GriddleEnglishBoard.defaultModifierTheme.borderColor,
    backgroundColor = GriddleEnglishBoard.defaultModifierTheme.backgroundColor,
    textColor = GriddleEnglishBoard.defaultModifierTheme.textColor,
    fontSize = GriddleEnglishBoard.defaultModifierTheme.calculateFontSize(
        availableSpace = Rect(0, 0, 1, 1),
    ),
    keyboardHandedness = KeyboardHandedness(
        hasHandedness = true,
        pivotColumn = 1,
    ),
) {
    override val layerDefinition = LayerDefinition.NUMERIC_LAYER
    override val layerType = LayerType.NUMERIC
    override var builders = buttonBuilders
    companion object {
        val buttonBuilders =  mutableSetOf(
            button1, button2, button3, cursorControlButton,
            button4, button5, button6, rightAlphaLayerToggle,
            button7, button8, button9,
            backspace, enter,
            numericSpaceLeft, button0, numericSpaceRight,
        )
    }
}