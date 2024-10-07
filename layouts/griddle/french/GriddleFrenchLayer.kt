package org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.french

import android.content.Context
import android.graphics.Rect
import androidx.compose.ui.graphics.Color
import org.galacticware.griddle.domain.keyboard.KeyboardHandedness
import org.galacticware.griddle.domain.language.LanguageTag
import org.galacticware.griddle.domain.layer.LayerType
import org.galacticware.griddle.domain.layer.LayerDefinition
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.backspace
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.cursorControlButton
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.enter
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.rightNumLayerToggle
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.space
import org.galacticware.griddle.keyboarddefinition.system.LanguageLayer

/**
 * Represents the default alpha layer for the Griddle French keyboard layout.
 * This layer is responsible for defining the alpha (alphabetic) keys and their properties.
 */
class GriddleFrenchLayer(
    context: Context,
    override val language: LanguageTag = LanguageTag.FRENCH,
) : LanguageLayer(
    context,
    // Set of button builders used to create the buttons in this layer
    griddleButtonBuilders = buttonBuilders,
    // Sample button used internally for sizing of rows and columns.
    // For most keyboards, this will be a 1x1 button.
    // Default border color for the buttons in this layer, which can a [GriddleButtonBuilder] can
    // override
    borderColor = GriddleFrenchBoard.defaultModifierTheme.textColor,
    // Default background color for the buttons in this layer, which can a [GriddleButtonBuilder]
    // can override
    backgroundColor = Color.Black,
    // Default text color for the buttons in this layer, which can a [GriddleButtonBuilder] can
    // override
    textColor = GriddleFrenchBoard.defaultModifierTheme.textColor,
    // Default border font size for the buttons in this layer, which can a [GriddleButtonBuilder]
    // can override
    fontSize = GriddleFrenchBoard.defaultModifierTheme.calculateFontSize(
        availableSpace = Rect(0, 0, 1, 1)
    ),
    // Defines whether the keyboard can switch between left and right, and if so, the pivot column
    // by which to rotate all columns on the left to the right, and on the right to the left.
    keyboardHandedness = KeyboardHandedness(
        hasHandedness = true,
        pivotColumn = 1
    ),
) {
    // Set of button builders used to create the buttons in this layer
    override var builders = buttonBuilders
    // Defines the layer as an alpha layer
    override val layerDefinition = LayerDefinition.ALPHA_LAYER
    // Specifies the type of the layer as alpha
    override val layerType = LayerType.ALPHA

    companion object {
        // Set of button builders used to create the buttons in this layer
        val buttonBuilders = mutableSetOf(
            button_0_0, button_0_1, button_0_2, cursorControlButton,
            button_1_0, button_1_1, button_1_2, rightNumLayerToggle,
            button2_0, button_2_1, button2_2, backspace,
            space, enter
        )
    }
}