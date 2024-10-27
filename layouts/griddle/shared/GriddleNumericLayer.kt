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
import org.galacticware.griddle.domain.button.GestureButtonBuilder.Companion.gestureButton
import org.galacticware.griddle.domain.gesture.GestureType
import org.galacticware.griddle.domain.gesture.GestureType.CLICK
import org.galacticware.griddle.domain.gesture.GestureType.HOLD
import org.galacticware.griddle.domain.gesture.GestureType.SWIPE_DOWN_LEFT
import org.galacticware.griddle.domain.gesture.GestureType.SWIPE_DOWN_RIGHT
import org.galacticware.griddle.domain.gesture.GestureType.SWIPE_RIGHT
import org.galacticware.griddle.domain.gesture.GestureType.SWIPE_UP_LEFT
import org.galacticware.griddle.domain.gesture.GestureType.SWIPE_UP_RIGHT
import org.galacticware.griddle.domain.keybinder.AppSymbol
import org.galacticware.griddle.domain.keybinder.AppSymbol.NUMERIC_LAYER
import org.galacticware.griddle.domain.keybinder.KeyBinder.Companion.gesture
import org.galacticware.griddle.domain.keyboard.KeyboardHandedness
import org.galacticware.griddle.domain.layer.LayerKind
import org.galacticware.griddle.domain.operation.SwitchLayer
import org.galacticware.griddle.domain.operation.pressKey
import org.galacticware.griddle.domain.operation.pressTab
import org.galacticware.griddle.domain.operation.sendTab
import org.galacticware.griddle.domain.operation.simpleInput
import org.galacticware.griddle.domain.util.caseSensitive
import org.galacticware.griddle.domain.util.reversedCase
import org.galacticware.griddle.domain.util.triple
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.GriddleKeyMap
import org.galacticware.griddle.keyboarddefinition.opensource.theme.DEFAULT_SIZE

object DefaultNumericMap: GriddleKeyMap() {
    override val isPrimary: Boolean = false
    override val keyboardHandedness = KeyboardHandedness(hasHandedness = true, pivotColumn = 1)
    override val layerKind: LayerKind = LayerKind.NUMPAD
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
        .withGesture(gesture(SWIPE_DOWN_RIGHT, simpleInput, threeStrings = caseSensitive("α")))
        .withGesture(gesture(GestureType.BOOMERANG_DOWN_RIGHT, simpleInput, threeStrings = reversedCase("α")))
        .withGesture(gesture(GestureType.SWIPE_LEFT, simpleInput, threeStrings = Triple("≤", "≥", "≥")))
        .withGesture(gesture(GestureType.BOOMERANG_DOWN_LEFT, simpleInput, oneString = "|"))

    val button2 = button_0_1
        .withoutLetters()//
        .withGesture(CLICK, pressKey(KEYCODE_2, respectShift = false), oneString = "2")
        .withGesture(gesture(SWIPE_DOWN_LEFT, simpleInput, threeStrings = caseSensitive("ω")))
        .withGesture(gesture(GestureType.BOOMERANG_DOWN_LEFT, simpleInput, threeStrings = reversedCase("ω")))
        .withGesture(gesture(GestureType.SWIPE_DOWN, simpleInput, threeStrings = caseSensitive("φ")))
        .withGesture(gesture(GestureType.BOOMERANG_DOWN, simpleInput, threeStrings = reversedCase("φ")))
        .withGesture(gesture(SWIPE_DOWN_RIGHT, simpleInput, threeStrings = caseSensitive("π")))
        .withGesture(gesture(GestureType.BOOMERANG_DOWN_RIGHT, simpleInput, threeStrings = reversedCase("π")))

    val button3 = button_0_2
        .withoutLetters()
        .withGesture(CLICK, pressKey(KEYCODE_3, respectShift = false), oneString = "3")
        .withGesture(gesture(SWIPE_RIGHT, simpleInput, threeStrings = Triple("≥", "≤", "≤")))
        .withGesture(gesture(GestureType.BOOMERANG_RIGHT, simpleInput, threeStrings = Triple("≤" , "≥", "≥")))
        .withGesture(gesture(SWIPE_DOWN_LEFT, simpleInput, threeStrings = caseSensitive("γ")))
        .withGesture(gesture(GestureType.BOOMERANG_DOWN_LEFT, simpleInput, threeStrings = reversedCase("γ")))
        .withGesture(gesture(GestureType.SWIPE_DOWN, simpleInput, threeStrings = caseSensitive("ʃ")))
        .withGesture(gesture(GestureType.BOOMERANG_DOWN, simpleInput, threeStrings = reversedCase("ʃ")))
        .withGesture(gesture(SWIPE_DOWN_RIGHT, simpleInput, threeStrings = caseSensitive("€")))
        .withGesture(gesture(GestureType.BOOMERANG_DOWN_RIGHT, simpleInput, threeStrings = reversedCase("€")))

    val button4 = button_1_0
        .withoutLetters()
        .withGesture(CLICK, pressKey(KEYCODE_4, respectShift = false), oneString = "4")
        .withGesture(gesture(SWIPE_UP_LEFT, simpleInput, threeStrings = Triple("{", "}", "}")))
        .withGesture(gesture(GestureType.BOOMERANG_UP_LEFT, simpleInput, threeStrings = Triple("}", "{", "{")))
        .withGesture(gesture(GestureType.SWIPE_UP, simpleInput, threeStrings = Triple("–", "—", "—")))
        .withGesture(gesture(GestureType.BOOMERANG_UP, simpleInput, threeStrings = Triple("—", "–", "–")))
        .withGesture(gesture(SWIPE_UP_RIGHT, simpleInput, threeStrings = caseSensitive("σ")))
        .withGesture(gesture(GestureType.BOOMERANG_UP_RIGHT, simpleInput, threeStrings = reversedCase("σ")))
        .withGesture(gesture(SWIPE_DOWN_LEFT, simpleInput, threeStrings = Triple("[", "]", "]")))
        .withGesture(gesture(GestureType.BOOMERANG_DOWN_LEFT, simpleInput, threeStrings = Triple("]", "[", "[")))
        .withGesture(gesture(GestureType.SWIPE_DOWN, simpleInput, oneString = "×"))
        .withGesture(gesture(GestureType.BOOMERANG_DOWN, simpleInput, oneString = "÷"))
        .withGesture(gesture(SWIPE_DOWN_RIGHT, simpleInput, threeStrings = caseSensitive("λ")))
        .withGesture(gesture(GestureType.BOOMERANG_DOWN_RIGHT, simpleInput, threeStrings = reversedCase("λ")))

    val button5 = button_1_1
        .withoutLetters()
        .withGesture(CLICK, pressKey(KEYCODE_5, respectShift = false), oneString = "5")
        .withGesture(gesture(SWIPE_UP_LEFT, simpleInput, oneString = "¹"))
        .withGesture(gesture(GestureType.SWIPE_UP, simpleInput, oneString = "²"))
        .withGesture(gesture(SWIPE_UP_RIGHT, simpleInput, oneString = "³"))
        .withGesture(gesture(SWIPE_DOWN_LEFT, simpleInput, oneString = "¼"))
        .withGesture(gesture(GestureType.SWIPE_DOWN, simpleInput, oneString = "½"))
        .withGesture(gesture(SWIPE_DOWN_RIGHT, simpleInput, oneString = "¾"))

    val button6 = button_1_2
        .withoutLetters()
        .withGesture(CLICK, pressKey(KEYCODE_6, respectShift = false), oneString = "6")
        .withGesture(gesture(SWIPE_UP_LEFT, simpleInput, threeStrings = caseSensitive("β")))
        .withGesture(gesture(GestureType.BOOMERANG_UP_LEFT, simpleInput, threeStrings = reversedCase("β")))
        .withGesture(gesture(GestureType.SWIPE_UP, simpleInput, threeStrings = caseSensitive("§")))
        .withGesture(gesture(GestureType.BOOMERANG_UP, simpleInput, threeStrings = reversedCase("§")))
        .withGesture(gesture(SWIPE_UP_RIGHT, simpleInput, threeStrings = Triple("}","{","{")))
        .withGesture(gesture(GestureType.BOOMERANG_UP_RIGHT, simpleInput, threeStrings = Triple("{","}","}")))
        .withGesture(gesture(SWIPE_RIGHT, simpleInput, threeStrings = Triple(")", "(", "(")))
        .withGesture(gesture(GestureType.BOOMERANG_RIGHT, simpleInput, threeStrings = Triple("(", ")", ")")))
        .withGesture(gesture(SWIPE_DOWN_LEFT, simpleInput, threeStrings = caseSensitive("ρ")))
        .withGesture(gesture(GestureType.BOOMERANG_DOWN_LEFT, simpleInput, threeStrings = reversedCase("ρ")))
        .withGesture(gesture(GestureType.SWIPE_DOWN, simpleInput, oneString = "≈"))
        .withGesture(gesture(GestureType.BOOMERANG_DOWN, simpleInput, oneString = "≠"))
        .withGesture(gesture(SWIPE_DOWN_RIGHT, simpleInput, threeStrings = Triple("]", "[", "[")))
        .withGesture(gesture(GestureType.BOOMERANG_DOWN_RIGHT, simpleInput, threeStrings = Triple("[", "]", "]")))

    val button7 = button_2_0
        .withoutLetters()
        .withGesture(CLICK, pressKey(KEYCODE_6, respectShift = false), oneString = "7")
        .withGesture(gesture(GestureType.SWIPE_UP, simpleInput, threeStrings = Triple("÷", "×", "×")))
        .withGesture(gesture(GestureType.BOOMERANG_UP, simpleInput, threeStrings = Triple("×", "÷", "÷")))
        .withGesture(gesture(SWIPE_UP_RIGHT, simpleInput, threeStrings = caseSensitive("κ")))
        .withGesture(gesture(GestureType.BOOMERANG_UP_RIGHT, simpleInput, threeStrings = reversedCase("κ")))
        .withGesture(gesture(SWIPE_DOWN_RIGHT, sendTab, threeStrings = triple(AppSymbol.TAB_RIGHT)))
        .withGesture(gesture(GestureType.BOOMERANG_DOWN_RIGHT, pressTab, threeStrings = triple(AppSymbol.TAB_RIGHT)))

    val button8 = button_2_1
        .withoutLetters()
        .withGesture(CLICK, pressKey(KEYCODE_8, respectShift = false), oneString = "8")
        .withGesture(gesture(SWIPE_UP_LEFT, simpleInput, threeStrings = caseSensitive("µ")))
        .withGesture(gesture(GestureType.BOOMERANG_UP_LEFT, simpleInput, threeStrings = reversedCase("µ")))
        .withGesture(gesture(GestureType.SWIPE_UP, simpleInput, threeStrings = caseSensitive("δ")))
        .withGesture(gesture(GestureType.BOOMERANG_UP, simpleInput, threeStrings = reversedCase("δ")))
        .withGesture(gesture(SWIPE_UP_RIGHT, simpleInput, threeStrings = caseSensitive("θ")))
        .withGesture(gesture(GestureType.BOOMERANG_UP_RIGHT, simpleInput, threeStrings = reversedCase("θ")))

    val button9 = button_2_2
        .withoutLetters()
        .withGesture(CLICK, pressKey(KEYCODE_9, respectShift = false), oneString = "9")
        .withGesture(gesture(SWIPE_UP_LEFT, simpleInput, threeStrings = caseSensitive("ε")))
        .withGesture(gesture(GestureType.BOOMERANG_UP_LEFT, simpleInput, threeStrings = reversedCase("ε")))

    override fun allMappings() = mutableSetOf(
        button1, button2, button3, button4, button5, button6, button7, button8, button9, button0,
        cursorControlButton,
        AlphabeticLayerToggle
            .withGesture(gesture(HOLD, SwitchLayer(NUMERIC_LAYER))),
        backspace,
        enter,
        numericSpaceLeft,
        numericSpaceRight,
    )
}