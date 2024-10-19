package org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared

import android.view.KeyEvent.KEYCODE_1
import android.view.KeyEvent.KEYCODE_2
import android.view.KeyEvent.KEYCODE_3
import android.view.KeyEvent.KEYCODE_4
import android.view.KeyEvent.KEYCODE_5
import android.view.KeyEvent.KEYCODE_6
import android.view.KeyEvent.KEYCODE_8
import android.view.KeyEvent.KEYCODE_9
import androidx.compose.ui.unit.IntSize
import org.galacticware.griddle.domain.gesture.GestureType.CLICK
import org.galacticware.griddle.domain.griddlebutton.builder.GriddleButtonBuilder.Companion.gestureButton
import org.galacticware.griddle.domain.keybinder.KeyBinder.Companion.gesture
import org.galacticware.griddle.domain.keyboard.KeyboardHandedness
import org.galacticware.griddle.domain.layer.LayerKind
import org.galacticware.griddle.domain.operation.pressKey
import org.galacticware.griddle.domain.operation.simpleInput
import org.galacticware.griddle.domain.util.caseSensitive
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.GriddleKeyMap
import org.galacticware.griddle.keyboarddefinition.opensource.theme.DEFAULT_SIZE

object DefaultNumericMap: GriddleKeyMap() {
    override val isPrimary: Boolean = false
    override val keyboardHandedness = KeyboardHandedness(hasHandedness = true, pivotColumn = 1)
    override val layerKind: LayerKind = LayerKind.NUMERIC
    override val languageTag = null
    override val defalultSize: IntSize = DEFAULT_SIZE

    val button0 = gestureButton(
        rowStart = 3, colStart = 1, rowSpan = 1, colSpan = 1,
        gestureSet = mutableSetOf(
            gesture(CLICK, simpleInput, threeStrings = caseSensitive("0"))
        ),
    )

    val button1 = button_0_0
        .withoutLetters()
        .withGesture(CLICK, pressKey(KEYCODE_1, respectShift = false), oneString = "1")

    val button2 = button_0_1
        .withoutLetters()
        .withGesture(CLICK, pressKey(KEYCODE_2, respectShift = false), oneString = "2")

    val button3 = button_0_2
        .withoutLetters()
        .withGesture(CLICK, pressKey(KEYCODE_3, respectShift = false), oneString = "3")

    val button4 = button_1_0
        .withoutLetters()
        .withGesture(CLICK, pressKey(KEYCODE_4, respectShift = false), oneString = "4")

    val button5 = button_1_1
        .withoutLetters()
        .withGesture(CLICK, pressKey(KEYCODE_5, respectShift = false), oneString = "5")

    val button6 = button_1_2
        .withoutLetters()
        .withGesture(CLICK, pressKey(KEYCODE_6, respectShift = false), oneString = "6")

    val button7 = button_2_0
        .withoutLetters()
        .withGesture(CLICK, pressKey(KEYCODE_6, respectShift = false), oneString = "7")

    val button8 = button_2_1
        .withoutLetters()
        .withGesture(CLICK, pressKey(KEYCODE_8, respectShift = false), oneString = "8")

    val button9 = button_2_2
        .withoutLetters()
        .withGesture(CLICK, pressKey(KEYCODE_9, respectShift = false), oneString = "9")
    override fun allMappings() = mutableSetOf(
        button1, button2, button3, button4, button5, button6, button7, button8, button9, button0,
        cursorControlButton,
        AlphabeticLayerToggle,
        backspace,
        enter,
        numericSpaceLeft,
        numericSpaceRight,
    )
}