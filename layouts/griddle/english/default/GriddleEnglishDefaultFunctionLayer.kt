package org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.default

import android.content.Context
import android.graphics.Rect
import org.galacticware.griddle.domain.keyboard.KeyboardHandedness
import org.galacticware.griddle.domain.layer.LayerDefinition
import org.galacticware.griddle.domain.layer.LayerType
import org.galacticware.griddle.keyboarddefinition.system.AbstractKeyboardLayer

class GriddleEnglishDefaultFunctionLayer(
    context: Context,
) : AbstractKeyboardLayer(
    context,
    griddleButtonBuilders = buttonBuilders,
    borderColor = GriddleEnglishDefaultBoard.defaultModifierTheme.borderColor,
    backgroundColor = GriddleEnglishDefaultBoard.defaultModifierTheme.backgroundColor,
    textColor = GriddleEnglishDefaultBoard.defaultModifierTheme.textColor,
    fontSize = GriddleEnglishDefaultBoard.defaultModifierTheme.calculateFontSize(
        availableSpace = Rect(0, 0, 1, 1),
    ),
    keyboardHandedness = KeyboardHandedness(
        hasHandedness = true,
        pivotColumn = 1,
    ),
) {
    override var builders = buttonBuilders
    companion object {
        val buttonBuilders =  mutableSetOf(
            f1, f2, f3, cursorControlButton,
            f4, f5, f6, rightAlphaLayerToggle,
            f7, f8, f9, backspace,
            f10, f11, f12, enter,
        )
    }
    override val layerDefinition = LayerDefinition.FUNCTION_LAYER
    override val layerType = LayerType.FUNCTION
}