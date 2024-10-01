package org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.default

import android.content.Context
import android.graphics.Rect
import androidx.compose.ui.graphics.Color
import org.galacticware.griddle.domain.keyboard.KeyboardHandedness
import org.galacticware.griddle.domain.griddlebutton.builder.GriddleButtonBuilder
import org.galacticware.griddle.keyboarddefinition.system.AbstractKeyboardLayer
import org.galacticware.griddle.domain.layer.LayerType
import org.galacticware.griddle.domain.layer.LayerDefinition

/**
 * All language layers should have the  [AbstractKeyboardLayer.layerDefinition] property set to [LayerDefinition.ALPHA_LAYER].
 */
class GriddleEnglishDefaultUnifiedAlphaNumericLayer(
    context: Context,
) : AbstractKeyboardLayer(
    context,
    griddleButtonBuilders = buttonBuilders,
    borderColor = GriddleEnglishDefaultBoard.defaultModifierTheme.textColor,
    backgroundColor = Color.Black,
    textColor = GriddleEnglishDefaultBoard.defaultModifierTheme.textColor,
    fontSize = GriddleEnglishDefaultBoard.defaultModifierTheme.calculateFontSize(
        availableSpace = Rect(0, 0, 1, 1),
    ),
    keyboardHandedness = KeyboardHandedness(
        hasHandedness = true,
        pivotColumn = 3,
    ),
) {
    override val layerDefinition = LayerDefinition.ALPHA_NUMERIC_UNIFIED
    override val layerType = LayerType.ALPHA_NUMERIC_UNIFIED
    override val builders: Set<GriddleButtonBuilder> = buttonBuilders
    
    companion object {
        val buttonBuilders = setOf(
            button_0_0, button_0_1, button_0_2, cursorControlButton,
            button_1_0, button_1_1, button_1_2, rightAlphaLayerToggle,
            button2_0, button_2_1, button2_2, backspace,
            numericSpaceLeft, enter, numericSpaceRight
        ).plus(
            setOf(
                button1, button2, button3,
                button4, button5, button6,
                button7, button8, button9,
                button0.withPosition(colStart = 0, colSpan = 3)
                // right-side buttons start at column <pivot column + 1> == 4
            ).map { it.withPosition(colStart = 4 + it.positionAndSize.colStart) }
        )
    }
}