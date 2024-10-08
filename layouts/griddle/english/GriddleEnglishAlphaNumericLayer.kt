package org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english

import android.content.Context
import android.graphics.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntSize
import org.galacticware.griddle.domain.keyboard.KeyboardHandedness
import org.galacticware.griddle.domain.language.LanguageTag
import org.galacticware.griddle.keyboarddefinition.system.AbstractKeyboardLayer
import org.galacticware.griddle.domain.layer.LayerType
import org.galacticware.griddle.domain.layer.LayerDefinition
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.backspace
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.button0
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.button1
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.button2
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.button3
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.button4
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.button5
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.button6
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.button7
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.button8
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.button9
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.cursorControlButton
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.enter
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.numericSpaceLeft
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.numericSpaceRight
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.rightAlphaLayerToggle
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.space
import org.galacticware.griddle.keyboarddefinition.system.LanguageLayer
import kotlin.math.roundToInt

/**
 * All language layers should have the  [AbstractKeyboardLayer.layerDefinition] property set to [LayerDefinition.ALPHA_LAYER].
 */
class GriddleEnglishAlphaNumericLayer(
    context: Context,
    override val language: LanguageTag = LanguageTag.ENGLISH,
) : LanguageLayer(
    context,
    griddleButtonBuilders = buttonBuilders,
    borderColor = GriddleEnglishBoard.defaultModifierTheme.textColor,
    backgroundColor = Color.Black,
    textColor = GriddleEnglishBoard.defaultModifierTheme.textColor,
    fontSize = GriddleEnglishBoard.defaultModifierTheme.calculateFontSize(
        availableSpace = Rect(0, 0, 1, 1),
    ),
    keyboardHandedness = KeyboardHandedness(
        hasHandedness = true,
        pivotColumn = 3,
    ),
) {
    private val defaultButtonSize: IntSize = GriddleEnglishBoard.defaultButtonSize.let{
        IntSize(
            width = (it.width * .75).roundToInt(),
            height = it.height,
        )
    }
    override val layerDefinition = LayerDefinition.ALPHA_NUMERIC_UNIFIED
    override val layerType = LayerType.ALPHA_NUMERIC_UNIFIED
    override var builders = buttonBuilders
    
    companion object {
        val buttonBuilders = setOf(
            button_0_0, button_0_1, button_0_2, cursorControlButton,
            button_1_0, button_1_1, button_1_2, rightAlphaLayerToggle,
            button2_0, button_2_1, button2_2, backspace,
           space, enter,
                   // numericSpaceLeft, enter, numericSpaceRight
        ).plus(
            setOf(
                button1, button2, button3,
                button4, button5, button6,
                button7, button8, button9,
                button0.withPosition(colStart = 0, colSpan = 3),
                // right-side buttons start at column <pivot column + 1> == 4
            ).map { it.withPosition(colStart = 4 + it.positionAndSize.colStart) }
        ).toMutableSet()
    }
}