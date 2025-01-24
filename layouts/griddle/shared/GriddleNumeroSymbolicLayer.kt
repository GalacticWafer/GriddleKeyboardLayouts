package com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared

import android.view.KeyEvent.KEYCODE_1
import android.view.KeyEvent.KEYCODE_2
import android.view.KeyEvent.KEYCODE_3
import android.view.KeyEvent.KEYCODE_4
import android.view.KeyEvent.KEYCODE_5
import android.view.KeyEvent.KEYCODE_6
import android.view.KeyEvent.KEYCODE_7
import android.view.KeyEvent.KEYCODE_8
import android.view.KeyEvent.KEYCODE_9
import androidx.compose.ui.unit.IntSize
import com.galacticware.griddle.domain.gesture.GestureType.CLICK
import com.galacticware.griddle.domain.button.GestureButtonBuilder.Companion.gestureButton
import com.galacticware.griddle.domain.keybinder.KeyBinder.Companion.gesture
import com.galacticware.griddle.domain.keyboard.KeyboardHandedness
import com.galacticware.griddle.domain.layer.LayerKind
import com.galacticware.griddle.domain.operation.PressKey
import com.galacticware.griddle.domain.operation.SimpleInput
import com.galacticware.griddle.domain.util.caseSensitive
import com.galacticware.griddle.keyboarddefinition.opensource.theme.DEFAULT_SIZE
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.GriddleLayerBuilder

object DefaultNumeroSymbolicMap: GriddleLayerBuilder() {
//    override val name = this::class.simpleName
    override val isPrimary: Boolean = false
    override val keyboardHandedness = KeyboardHandedness(hasHandedness = true, pivotColumn = 1)
    override val layerKind: LayerKind = LayerKind.NUMERO_SYMBOLIC
    override val languageTag = null
    override val defalultSize: IntSize = DEFAULT_SIZE

    val button0 = gestureButton(
        rowStart = 3, colStart = 1, rowSpan = 1, colSpan = 1,
        gestureSet = mutableSetOf(
            gesture(CLICK, SimpleInput, threeStrings = caseSensitive("0"))
        ),
    )

    val button1 = button_0_0
        .withoutLetters()
        .withGesture(CLICK, PressKey, keycode = KEYCODE_1, respectShift = false, oneString = "1")

    val button2 = button_0_1
        .withoutLetters()
        .withGesture(CLICK, PressKey, keycode = KEYCODE_2, respectShift = false, oneString = "2")

    val button3 = button_0_2
        .withoutLetters()
        .withGesture(CLICK, PressKey, keycode = KEYCODE_3, respectShift = false, oneString = "3")

    val button4 = button_1_0
        .withoutLetters()
        .withGesture(CLICK, PressKey, keycode = KEYCODE_4, respectShift = false, oneString = "4")

    val button5 = button_1_1
        .withoutLetters()
        .withGesture(CLICK, PressKey, keycode = KEYCODE_5, respectShift = false, oneString = "5")

    val button6 = button_1_2
        .withoutLetters()
        .withGesture(CLICK, PressKey, keycode = KEYCODE_6, respectShift = false, oneString = "6")

    val button7 = button_2_0
        .withoutLetters()
        .withGesture(CLICK, PressKey, keycode = KEYCODE_7, respectShift = false, oneString = "7")

    val button8 = button_2_1
        .withoutLetters()
        .withGesture(CLICK, PressKey, keycode = KEYCODE_8, respectShift = false, oneString = "8")

    val button9 = button_2_2
        .withoutLetters()
        .withGesture(CLICK, PressKey, keycode = KEYCODE_9, respectShift = false, oneString = "9")
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