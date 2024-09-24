package org.galacticware.griddle.keyboarddefinition.keyboarddefinitions.layouts.griddle.english.default

import android.view.KeyEvent.KEYCODE_1
import android.view.KeyEvent.KEYCODE_2
import android.view.KeyEvent.KEYCODE_3
import android.view.KeyEvent.KEYCODE_4
import android.view.KeyEvent.KEYCODE_5
import android.view.KeyEvent.KEYCODE_6
import android.view.KeyEvent.KEYCODE_8
import android.view.KeyEvent.KEYCODE_9
import android.view.KeyEvent.KEYCODE_A
import android.view.KeyEvent.KEYCODE_DEL
import android.view.KeyEvent.KEYCODE_DPAD_DOWN
import android.view.KeyEvent.KEYCODE_DPAD_LEFT
import android.view.KeyEvent.KEYCODE_DPAD_RIGHT
import android.view.KeyEvent.KEYCODE_DPAD_UP
import android.view.KeyEvent.KEYCODE_ENTER
import android.view.KeyEvent.KEYCODE_F1
import android.view.KeyEvent.KEYCODE_F10
import android.view.KeyEvent.KEYCODE_F11
import android.view.KeyEvent.KEYCODE_F12
import android.view.KeyEvent.KEYCODE_F2
import android.view.KeyEvent.KEYCODE_F3
import android.view.KeyEvent.KEYCODE_F4
import android.view.KeyEvent.KEYCODE_F5
import android.view.KeyEvent.KEYCODE_F6
import android.view.KeyEvent.KEYCODE_F7
import android.view.KeyEvent.KEYCODE_F8
import android.view.KeyEvent.KEYCODE_F9
import android.view.KeyEvent.KEYCODE_FORWARD_DEL
import android.view.KeyEvent.KEYCODE_MOVE_END
import android.view.KeyEvent.KEYCODE_MOVE_HOME
import android.view.KeyEvent.KEYCODE_PAGE_DOWN
import android.view.KeyEvent.KEYCODE_PAGE_UP
import android.view.KeyEvent.KEYCODE_TAB
import org.galacticware.griddle.domain.gesture.Gesture
import org.galacticware.griddle.domain.gesture.GestureType.BOOMERANG_DOWN
import org.galacticware.griddle.domain.gesture.GestureType.BOOMERANG_DOWN_LEFT
import org.galacticware.griddle.domain.gesture.GestureType.BOOMERANG_DOWN_RIGHT
import org.galacticware.griddle.domain.gesture.GestureType.BOOMERANG_LEFT
import org.galacticware.griddle.domain.gesture.GestureType.BOOMERANG_RIGHT
import org.galacticware.griddle.domain.gesture.GestureType.BOOMERANG_UP
import org.galacticware.griddle.domain.gesture.GestureType.BOOMERANG_UP_LEFT
import org.galacticware.griddle.domain.gesture.GestureType.BOOMERANG_UP_RIGHT
import org.galacticware.griddle.domain.gesture.GestureType.CIRCLE_ANTI_CLOCKWISE
import org.galacticware.griddle.domain.gesture.GestureType.CIRCLE_CLOCKWISE
import org.galacticware.griddle.domain.gesture.GestureType.CLICK
import org.galacticware.griddle.domain.gesture.GestureType.HOLD
import org.galacticware.griddle.domain.gesture.GestureType.SWIPE_DOWN
import org.galacticware.griddle.domain.gesture.GestureType.SWIPE_DOWN_LEFT
import org.galacticware.griddle.domain.gesture.GestureType.SWIPE_DOWN_RIGHT
import org.galacticware.griddle.domain.gesture.GestureType.SWIPE_LEFT
import org.galacticware.griddle.domain.gesture.GestureType.SWIPE_RIGHT
import org.galacticware.griddle.domain.gesture.GestureType.SWIPE_UP
import org.galacticware.griddle.domain.gesture.GestureType.SWIPE_UP_LEFT
import org.galacticware.griddle.domain.gesture.GestureType.SWIPE_UP_RIGHT
import org.galacticware.griddle.domain.griddlebutton.builder.GriddleButtonBuilder.Companion.makeClassicGestureButton
import org.galacticware.griddle.domain.keybinder.AppSymbol
import org.galacticware.griddle.domain.keybinder.AppSymbol.ALT_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.BACKSPACE_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.CAPSLOCKED_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.CONTROL_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.COPY_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.CUT_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.DOWN_ARROW_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.ENTER_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.F10_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.F11_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.F12_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.F1_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.F2_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.F3_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.F4_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.F5_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.F6_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.F7_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.F8_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.F9_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.LEFT_ARROW_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.MACRO_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.MICROPHONE_CHAR
import org.galacticware.griddle.domain.keybinder.AppSymbol.MOVE_END_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.MOVE_HOME_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.MOVE_PGDN_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.PASTE_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.RIGHT_ARROW_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.SELECT_ALL_TEXT_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.SHIFTED_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.SWAP_HANDEDNESS
import org.galacticware.griddle.domain.keybinder.AppSymbol.TAB_RIGHT_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.TOGGLE_ALPHA_LAYER_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.TOGGLE_ALPHA_NUMERIC_UNIFIED_LAYER_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.TOGGLE_FUNCTION_LAYER_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.TOGGLE_NUMBER_LAYER_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.TOGGLE_SETTINGS_LAYER_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.UNSHIFTED_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.UP_ARROW_SYMBOL
import org.galacticware.griddle.domain.keybinder.KeyBinder.Companion.gesture
import org.galacticware.griddle.domain.modifier.AppModifierKey.Companion.control
import org.galacticware.griddle.domain.modifier.ModifierKeyKind
import org.galacticware.griddle.domain.modifier.ModifierTheme.Companion.modifierThemes
import org.galacticware.griddle.domain.modifier.ModifierThemeSet
import org.galacticware.griddle.domain.operation.applyAlt
import org.galacticware.griddle.domain.operation.applyControl
import org.galacticware.griddle.domain.operation.cycleAccentCharacters
import org.galacticware.griddle.domain.operation.cycleShiftState
import org.galacticware.griddle.domain.operation.moveLeft
import org.galacticware.griddle.domain.operation.moveRight
import org.galacticware.griddle.domain.operation.moveWordLeft
import org.galacticware.griddle.domain.operation.moveWordRight
import org.galacticware.griddle.domain.operation.noOp
import org.galacticware.griddle.domain.operation.openMacroEditor
import org.galacticware.griddle.domain.operation.pressKey
import org.galacticware.griddle.domain.operation.pressSpace
import org.galacticware.griddle.domain.operation.releaseShift
import org.galacticware.griddle.domain.operation.remappedSymbolLookup
import org.galacticware.griddle.domain.operation.repeatPreviousOperation
import org.galacticware.griddle.domain.operation.selectAll
import org.galacticware.griddle.domain.operation.simpleInput
import org.galacticware.griddle.domain.operation.startRecognizingSpeech
import org.galacticware.griddle.domain.operation.swapGesture
import org.galacticware.griddle.domain.operation.swapHandedness
import org.galacticware.griddle.domain.operation.swappable
import org.galacticware.griddle.domain.operation.switchLayer
import org.galacticware.griddle.domain.operation.toggleAltLock
import org.galacticware.griddle.domain.operation.toggleCapslock
import org.galacticware.griddle.domain.operation.toggleControlLock
import org.galacticware.griddle.domain.operation.toggleOneShotShift
import org.galacticware.griddle.domain.util.caseSensitive
import org.galacticware.griddle.domain.util.reversedCase
import org.galacticware.griddle.domain.util.withSymbol


/***
 * The definitions for English keys, roughly-based on the MessagEase layout.
 * Alphas and numerics are in the same place, with the same possible gestures for them.
 */

// By convention, we name the buttons `button_<row>_<col>`, where `<row>` and `<col>`
// are the row start and and column start indices of the button, respectively.
val button_0_0 = makeClassicGestureButton(
    // define the position and size of the button
    rowStart = 0, colStart = 0, rowSpan = 1, colSpan = 1,
    // define the gestures that can be performed on the button
    gestureSet = mutableSetOf(
        gesture(CLICK, simpleInput, threeChars = caseSensitive("a")),
        gesture(HOLD, simpleInput, char = "1"),
        gesture(SWIPE_UP_LEFT, cycleAccentCharacters, AppSymbol.CYCLE_ACCENTED_CHARS_SYMBOL),
        gesture(SWIPE_RIGHT, simpleInput, threeChars = caseSensitive("-", "÷", "÷")),
        gesture(BOOMERANG_RIGHT, simpleInput, threeChars = reversedCase("÷", "-", "-")),
        gesture(SWIPE_DOWN_LEFT, simpleInput, threeChars = caseSensitive("$")),
        gesture(BOOMERANG_DOWN_LEFT, simpleInput, threeChars = reversedCase("¢")),
        gesture(SWIPE_DOWN_RIGHT, simpleInput, threeChars = caseSensitive("v")),
        gesture(BOOMERANG_DOWN_RIGHT, simpleInput, threeChars = reversedCase("V")),
        gesture(CIRCLE_CLOCKWISE, simpleInput, threeChars = reversedCase("A")),
        gesture(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeChars = reversedCase("A")), ),
)

val button_0_1 = makeClassicGestureButton(
    rowStart = 0, colStart = 1, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(BOOMERANG_UP, simpleInput, threeChars = caseSensitive("ˇ")),
        gesture(CLICK, simpleInput, threeChars = caseSensitive("n")),
        gesture(HOLD, simpleInput, threeChars = withSymbol("2")),
        gesture(SWIPE_UP_LEFT, simpleInput, threeChars = caseSensitive("`", "\\", "\\")),
        gesture(BOOMERANG_UP_LEFT, simpleInput, threeChars = caseSensitive("\\", "`", "`")),
        gesture(SWIPE_UP, simpleInput, threeChars = caseSensitive("^", "’", "’")),
        gesture(SWIPE_UP_RIGHT, simpleInput, threeChars = Triple("^", "’", "’")),
        gesture(SWIPE_RIGHT, simpleInput, threeChars = caseSensitive("!", "¡", "¡")),
        gesture(BOOMERANG_RIGHT, simpleInput, threeChars = caseSensitive("¡", "!", "!")),
        gesture(SWIPE_DOWN_RIGHT, simpleInput, threeChars = caseSensitive("/", "—", "—")),
        gesture(BOOMERANG_DOWN_RIGHT, simpleInput, threeChars = caseSensitive("—", "/", "/")),
        gesture(SWIPE_DOWN, simpleInput, threeChars = caseSensitive("l")),
        gesture(BOOMERANG_DOWN, simpleInput, threeChars = reversedCase("L")),
        gesture(SWIPE_DOWN_LEFT, simpleInput, threeChars = caseSensitive("/", "—", "—")),
        gesture(BOOMERANG_DOWN_LEFT, simpleInput, threeChars = caseSensitive("—", "/", "/")),
        gesture(SWIPE_LEFT, simpleInput, threeChars = caseSensitive("+", "×", "×")),
        gesture(BOOMERANG_LEFT, simpleInput, threeChars = caseSensitive("×", "+", "+")),
        gesture(CIRCLE_CLOCKWISE, simpleInput, threeChars = reversedCase("n")),
        gesture(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeChars = reversedCase("n")),
    ),
)


val button_0_2 = makeClassicGestureButton(
    rowStart = 0, colStart = 2, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(CLICK, simpleInput, threeChars = caseSensitive("i")),
        gesture(SWIPE_DOWN_RIGHT, simpleInput, threeChars = caseSensitive("€", "£", "£")),
        gesture(BOOMERANG_DOWN_RIGHT, simpleInput, threeChars = caseSensitive("£", "€", "€")),
        gesture(SWIPE_DOWN, simpleInput, threeChars = caseSensitive("=", "±", "±")),
        gesture(BOOMERANG_DOWN, simpleInput, threeChars = caseSensitive("±", "=", "=")),
        gesture(SWIPE_DOWN_LEFT, simpleInput, threeChars = caseSensitive("x")),
        gesture(BOOMERANG_DOWN_LEFT, simpleInput, threeChars = reversedCase("X")),
        gesture(SWIPE_LEFT, simpleInput, threeChars = caseSensitive("?", "¿", "¿")),
        gesture(BOOMERANG_LEFT, simpleInput, threeChars = caseSensitive("¿", "?", "?")),
        gesture(CIRCLE_CLOCKWISE, simpleInput, threeChars = reversedCase("I")),
        gesture(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeChars = reversedCase("I")),
        gesture(HOLD, simpleInput, threeChars = withSymbol("3")),
    ),
)

val shiftIndicator = ModifierThemeSet.forModifierWithDefaultTheme("LOWER", "UPPER", "CAPS ", kind = ModifierKeyKind.SHIFT)

val cursorControlButton = makeClassicGestureButton(
    rowStart = 0, colStart = 3, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(CLICK, noOp, modifierThemeSet = shiftIndicator),
        gesture(HOLD, toggleCapslock),
        gesture(SWIPE_UP, pressKey(KEYCODE_DPAD_UP), threeChars = withSymbol(UP_ARROW_SYMBOL)),
        gesture(BOOMERANG_UP, pressKey(KEYCODE_PAGE_UP), threeChars = withSymbol(MOVE_PGDN_SYMBOL)),
        gesture(SWIPE_RIGHT, moveRight, threeChars = withSymbol(RIGHT_ARROW_SYMBOL)),
        gesture(SWIPE_UP_RIGHT, pressKey(KEYCODE_DPAD_UP)),
        gesture(BOOMERANG_UP_RIGHT, pressKey(KEYCODE_DPAD_UP, control)),
        gesture(SWIPE_DOWN_RIGHT, pressKey(KEYCODE_DPAD_RIGHT)),
        gesture(BOOMERANG_RIGHT, moveWordRight),
        gesture(SWIPE_LEFT, moveLeft, threeChars = withSymbol(LEFT_ARROW_SYMBOL)),
        gesture(SWIPE_UP_LEFT, pressKey(KEYCODE_DPAD_LEFT)),
        gesture(SWIPE_DOWN_LEFT, pressKey(KEYCODE_DPAD_LEFT)),
        gesture(BOOMERANG_LEFT, moveWordLeft),
        gesture(SWIPE_DOWN, pressKey(KEYCODE_DPAD_DOWN), threeChars = withSymbol(DOWN_ARROW_SYMBOL)),
        gesture(BOOMERANG_DOWN, pressKey(KEYCODE_PAGE_DOWN), threeChars = withSymbol(MOVE_PGDN_SYMBOL)),
        gesture(CIRCLE_CLOCKWISE, pressKey(KEYCODE_MOVE_END), threeChars = withSymbol(MOVE_END_SYMBOL)),
        gesture(CIRCLE_ANTI_CLOCKWISE, pressKey(KEYCODE_MOVE_HOME), threeChars = withSymbol(MOVE_HOME_SYMBOL)),
    ),
)

// you can define a triple of text that will be re-used in multiple gestures
val shiftLegends = Triple(SHIFTED_SYMBOL.value, CAPSLOCKED_SYMBOL.value, UNSHIFTED_SYMBOL.value)

val button_1_0 = makeClassicGestureButton(
    rowStart = 1, colStart = 0, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(SWIPE_UP, cycleShiftState, threeChars = shiftLegends),
        gesture(SWIPE_DOWN, releaseShift, threeChars = caseSensitive("", SHIFTED_SYMBOL.value, SHIFTED_SYMBOL.value)),
        gesture(SWIPE_UP_LEFT, simpleInput, threeChars = Triple("{", "}", "}")),
        gesture(BOOMERANG_UP_LEFT, simpleInput, threeChars = Triple("}", "{", "{")),
        gesture(SWIPE_UP_RIGHT, simpleInput, threeChars = Triple("%", "‰", "‰")),
        gesture(BOOMERANG_UP_RIGHT, simpleInput, threeChars = Triple("‰", "%", "%")),
        gesture(SWIPE_RIGHT, simpleInput, threeChars = caseSensitive("k")),
        gesture(BOOMERANG_RIGHT, simpleInput, threeChars = reversedCase("K")),
        gesture(SWIPE_DOWN_RIGHT, simpleInput, threeChars = Triple("_", "¬", "¬")),
        gesture(BOOMERANG_DOWN_RIGHT, simpleInput, threeChars = Triple("¬", "_", "_")),
        gesture(SWIPE_DOWN_LEFT, simpleInput, threeChars = Triple("[", "]", "]")),
        gesture(BOOMERANG_DOWN_LEFT, simpleInput, threeChars = Triple("]", "[", "[")),
        gesture(SWIPE_LEFT, simpleInput, threeChars = Triple("(", ")", ")")),
        gesture(BOOMERANG_LEFT, simpleInput, threeChars = Triple(")", "(", "(")),
        gesture(CIRCLE_CLOCKWISE, simpleInput, threeChars = reversedCase("H")),
        gesture(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeChars = reversedCase("H")),
        gesture(HOLD, simpleInput, threeChars = caseSensitive("4")),
        gesture(CLICK, simpleInput, threeChars = caseSensitive("h")),
    ),
)

val button_1_1 = makeClassicGestureButton(
    rowStart = 1, colStart = 1, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(CLICK, simpleInput, threeChars = caseSensitive("o")),
        gesture(SWIPE_UP_LEFT, simpleInput, threeChars = caseSensitive("q")),
        gesture(BOOMERANG_UP_LEFT, simpleInput, threeChars = reversedCase("q")),
        gesture(SWIPE_UP, simpleInput, threeChars = caseSensitive("u")),
        gesture(BOOMERANG_UP, simpleInput, threeChars = reversedCase("u")),
        gesture(SWIPE_UP_RIGHT, simpleInput, threeChars = caseSensitive("p")),
        gesture(BOOMERANG_UP_RIGHT, simpleInput, threeChars = reversedCase("P")),
        gesture(SWIPE_RIGHT, simpleInput, threeChars = caseSensitive("b")),
        gesture(BOOMERANG_RIGHT, simpleInput, threeChars = reversedCase("B")),
        gesture(SWIPE_DOWN_RIGHT, simpleInput, threeChars = caseSensitive("j")),
        gesture(BOOMERANG_DOWN_RIGHT, simpleInput, threeChars = reversedCase("J")),
        gesture(SWIPE_DOWN, simpleInput, threeChars = caseSensitive("d")),
        gesture(BOOMERANG_DOWN, simpleInput, threeChars = reversedCase("D")),
        gesture(SWIPE_DOWN_LEFT, simpleInput, threeChars = caseSensitive("g")),
        gesture(BOOMERANG_DOWN_LEFT, simpleInput, threeChars = reversedCase("G")),
        gesture(SWIPE_LEFT, simpleInput, threeChars = caseSensitive("c")),
        gesture(BOOMERANG_LEFT, simpleInput, threeChars = reversedCase("C")),
        gesture(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeChars = reversedCase("O")),
        gesture(CIRCLE_CLOCKWISE, simpleInput, threeChars = reversedCase("O")),
        gesture(HOLD, simpleInput, threeChars = reversedCase("5")),
    ),
)

val button_1_2 = makeClassicGestureButton(
    rowStart = 1, colStart = 2, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(SWIPE_UP, cycleShiftState, threeChars = shiftLegends),
        gesture(SWIPE_DOWN, releaseShift, threeChars = caseSensitive("", SHIFTED_SYMBOL.value, SHIFTED_SYMBOL.value)),
        gesture(SWIPE_UP_LEFT, simpleInput, threeChars = caseSensitive("|", "\\", "\\")),
        gesture(BOOMERANG_UP_LEFT, simpleInput, threeChars = caseSensitive("\\", "|", "|")),
        gesture(SWIPE_UP_RIGHT, simpleInput, threeChars = caseSensitive("}", "{", "{")),
        gesture(BOOMERANG_UP_RIGHT, simpleInput, threeChars = caseSensitive("{", "}", "}")),
        gesture(SWIPE_RIGHT, simpleInput, threeChars = caseSensitive(")", "(", "(")),
        gesture(BOOMERANG_RIGHT, simpleInput, threeChars = caseSensitive("(", ")", ")")),
        gesture(SWIPE_DOWN_RIGHT, simpleInput, threeChars = caseSensitive("]", "[", "[")),
        gesture(BOOMERANG_DOWN_RIGHT, simpleInput, threeChars = caseSensitive("[", "]", "]")),
        gesture(BOOMERANG_DOWN, simpleInput, threeChars = caseSensitive("—")),
        gesture(SWIPE_DOWN_LEFT, simpleInput, threeChars = caseSensitive("@", "ª", "ª")),
        gesture(BOOMERANG_DOWN_LEFT, simpleInput, threeChars = reversedCase("ª", "@", "@")),
        gesture(SWIPE_LEFT, simpleInput, threeChars = caseSensitive("m")),
        gesture(BOOMERANG_LEFT, simpleInput, threeChars = reversedCase("M")),
        gesture(CIRCLE_CLOCKWISE, simpleInput, threeChars = reversedCase("R")),
        gesture(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeChars = reversedCase("R")),
        gesture(CLICK, simpleInput, threeChars = caseSensitive("r")),
        gesture(HOLD, simpleInput, threeChars = reversedCase("6")),
    ),
)


val button2_0 = makeClassicGestureButton(
    rowStart = 2, colStart = 0, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(CLICK, simpleInput, threeChars = caseSensitive("t")),
        gesture(HOLD, simpleInput, threeChars = reversedCase("7")),
        gesture(SWIPE_UP_LEFT, simpleInput, threeChars = caseSensitive("~")),
        gesture(SWIPE_UP, simpleInput, threeChars = Triple("¨", "¨", "¨")),
        gesture(BOOMERANG_UP, simpleInput, threeChars = Triple("˝", "¨", "¨")),
        gesture(SWIPE_UP_RIGHT, simpleInput, threeChars = caseSensitive("y", "y", "Y")),
        gesture(BOOMERANG_UP_RIGHT, simpleInput, threeChars = reversedCase("Y")),
        gesture(SWIPE_RIGHT, simpleInput, threeChars = Triple("*", "†", "†")),
        gesture(BOOMERANG_RIGHT, simpleInput, threeChars = Triple("†", "*", "*")),
        gesture(SWIPE_LEFT, simpleInput, threeChars = Triple("<", ">", ">")),
        gesture(BOOMERANG_LEFT, simpleInput, threeChars = Triple(">", "<", "<")),
        gesture(SWIPE_DOWN_RIGHT, pressKey(KEYCODE_TAB), threeChars = withSymbol(TAB_RIGHT_SYMBOL)),
        gesture(CIRCLE_CLOCKWISE, simpleInput, threeChars = reversedCase("T")),
        gesture(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeChars = reversedCase("T")),
        gesture(SWIPE_DOWN, repeatPreviousOperation, appSymbol = AppSymbol.REPEAT_SYMBOL),
    ),
)


val button_2_1 = makeClassicGestureButton(
    rowStart = 2, colStart = 1, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(SWIPE_UP_LEFT, simpleInput, threeChars = caseSensitive("\"")),
        gesture(BOOMERANG_UP_LEFT, simpleInput, threeChars = caseSensitive(" ")),
        gesture(SWIPE_UP, simpleInput, threeChars = caseSensitive("w")),
        gesture(BOOMERANG_UP, simpleInput, threeChars = reversedCase("W")),
        gesture(SWIPE_UP_RIGHT, simpleInput, threeChars = caseSensitive("\'")),
        gesture(BOOMERANG_UP_RIGHT, simpleInput, threeChars = caseSensitive("\'")),
        gesture(SWIPE_RIGHT, simpleInput, threeChars = caseSensitive("z")),
        gesture(BOOMERANG_RIGHT, simpleInput, threeChars = reversedCase("Z")),
        gesture(SWIPE_DOWN_RIGHT, simpleInput, threeChars = caseSensitive(":")),
        gesture(BOOMERANG_RIGHT, simpleInput, threeChars = caseSensitive(";")),
        gesture(BOOMERANG_DOWN_RIGHT, simpleInput, threeChars = caseSensitive(",")),
        gesture(SWIPE_DOWN, simpleInput, threeChars = caseSensitive(".", "…", "…")),
        gesture(BOOMERANG_DOWN, simpleInput, threeChars = caseSensitive("…", ".", ".")),
        gesture(SWIPE_DOWN_LEFT, simpleInput, threeChars = caseSensitive(",")),
        gesture(BOOMERANG_DOWN_LEFT, simpleInput, threeChars = caseSensitive(",")),
        gesture(SWIPE_LEFT, simpleInput, threeChars = caseSensitive(",")),
        gesture(BOOMERANG_LEFT, simpleInput, threeChars = caseSensitive(",")),
        gesture(CIRCLE_CLOCKWISE, simpleInput, threeChars = reversedCase("E")),
        gesture(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeChars = reversedCase("E")),
        gesture(HOLD, simpleInput, threeChars = caseSensitive("8")),
        gesture(CLICK, simpleInput, threeChars = caseSensitive("e")),
        gesture(HOLD, simpleInput, threeChars = reversedCase("8")),
    ),
)


val button2_2 = makeClassicGestureButton(
    rowStart = 2, colStart = 2, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(CLICK, simpleInput, threeChars = caseSensitive("s")),
        gesture(SWIPE_UP_LEFT, simpleInput, threeChars = caseSensitive("f")),
        gesture(BOOMERANG_UP_LEFT, simpleInput, threeChars = reversedCase("F")),
        gesture(SWIPE_UP, simpleInput, threeChars = caseSensitive("&")),
        gesture(SWIPE_RIGHT, simpleInput, threeChars = caseSensitive(">")),
        gesture(SWIPE_UP_RIGHT, simpleInput, threeChars = caseSensitive("°")),
        gesture(SWIPE_DOWN_LEFT, simpleInput, threeChars = caseSensitive(";")),
        gesture(BOOMERANG_DOWN_LEFT, simpleInput, threeChars = caseSensitive(";")),
        gesture(SWIPE_LEFT, simpleInput, threeChars = caseSensitive("#")),
        gesture(BOOMERANG_LEFT, simpleInput, threeChars = caseSensitive(" ")),
        gesture(CIRCLE_CLOCKWISE, simpleInput, threeChars = reversedCase("S")),
        gesture(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeChars = reversedCase("S")),
        gesture(HOLD, simpleInput, threeChars = caseSensitive("9")),
        gesture(CLICK, simpleInput, threeChars = caseSensitive("s")),
        gesture(HOLD, simpleInput, threeChars = reversedCase("9")),
    ),
)



val cycleEmojisLeft = makeClassicGestureButton(
    rowStart = 3, colStart = 0, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(CLICK, /* cycleEmojiPage */noOp, threeChars = caseSensitive("⬅\uFE0F"))
    ),
)


val cycleEmojisRight = cycleEmojisLeft
    .withPosition(rowStart = 3, colStart=2, rowSpan = 1, colSpan = 1,)



val multiKey: Gesture =  gesture(CLICK, swappable(
    pressKey(KEYCODE_DEL) to withSymbol(BACKSPACE_SYMBOL),
    repeatPreviousOperation to withSymbol(AppSymbol.REPEAT_SYMBOL),
), threeChars = withSymbol(BACKSPACE_SYMBOL))

val backspace = makeClassicGestureButton(
    rowStart = 2, colStart = 3, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(HOLD, swapGesture(multiKey)),
        multiKey,
        gesture(SWIPE_LEFT, pressKey(KEYCODE_DEL)),
        gesture(SWIPE_UP_LEFT, pressKey(KEYCODE_DEL)),
        gesture(SWIPE_DOWN_LEFT, pressKey(KEYCODE_DEL)),
        gesture(BOOMERANG_LEFT, pressKey(KEYCODE_DEL, control)),
        gesture(SWIPE_RIGHT, pressKey(KEYCODE_FORWARD_DEL)),
        gesture(SWIPE_UP_RIGHT, pressKey(KEYCODE_FORWARD_DEL)),
        gesture(SWIPE_DOWN_RIGHT, pressKey(KEYCODE_FORWARD_DEL)),
        gesture(BOOMERANG_RIGHT, pressKey(KEYCODE_FORWARD_DEL, control)),
    ),
)


val rightBackspace = backspace
    .withPosition(rowStart = 2, colStart = 3, rowSpan = 1, colSpan = 1,)


val rightAlphaLayerToggle = makeClassicGestureButton(
    rowStart = 1, colStart = 3, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(SWIPE_UP, remappedSymbolLookup, appSymbol = COPY_SYMBOL),
        gesture(SWIPE_LEFT, remappedSymbolLookup, appSymbol = CUT_SYMBOL),
        gesture(SWIPE_UP_LEFT, openMacroEditor, appSymbol = MACRO_SYMBOL, ),
        gesture(SWIPE_DOWN, remappedSymbolLookup, appSymbol = PASTE_SYMBOL),
        gesture(CLICK, switchLayer, appSymbol = TOGGLE_ALPHA_LAYER_SYMBOL),
        gesture(SWIPE_RIGHT, swapHandedness, appSymbol = SWAP_HANDEDNESS),
        gesture(CIRCLE_ANTI_CLOCKWISE, pressKey(KEYCODE_A, control)),
        gesture(CIRCLE_CLOCKWISE, pressKey(KEYCODE_A, control)),
        gesture(SWIPE_DOWN_RIGHT, startRecognizingSpeech, appSymbol = MICROPHONE_CHAR),
    ),
)

val lefAlphaLayerToggle = rightAlphaLayerToggle
    .withPosition(rowStart = 1, colStart = 3, rowSpan = 1, colSpan = 1,)

val rightNumLayerToggle = makeClassicGestureButton(
    rowStart = 1, colStart = 3, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(SWIPE_UP, remappedSymbolLookup, appSymbol = COPY_SYMBOL),
        gesture(SWIPE_LEFT, remappedSymbolLookup, appSymbol = CUT_SYMBOL),
        gesture(SWIPE_DOWN, remappedSymbolLookup, appSymbol = PASTE_SYMBOL),
        gesture(SWIPE_UP_LEFT, openMacroEditor, appSymbol = MACRO_SYMBOL, ),
        gesture(SWIPE_RIGHT, swapHandedness, appSymbol = SWAP_HANDEDNESS),
        gesture(CLICK, switchLayer, appSymbol = TOGGLE_NUMBER_LAYER_SYMBOL),
        gesture(CIRCLE_ANTI_CLOCKWISE, selectAll, appSymbol = SELECT_ALL_TEXT_SYMBOL),
        gesture(CIRCLE_CLOCKWISE, selectAll, appSymbol = SELECT_ALL_TEXT_SYMBOL),
        gesture(SWIPE_DOWN_RIGHT, startRecognizingSpeech, appSymbol = MICROPHONE_CHAR),
    ),
)

val leftNumLayerToggles = rightNumLayerToggle
    .withPosition(rowStart = 1, colStart = 3, rowSpan = 1, colSpan = 1)

val enter = makeClassicGestureButton(
    rowStart = 3, colStart = 3, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(CLICK, pressKey(KEYCODE_ENTER), threeChars = withSymbol(ENTER_SYMBOL)),
        gesture(SWIPE_UP_LEFT, applyAlt, modifierThemeSet = modifierThemes(ALT_SYMBOL.value, kind = ModifierKeyKind.ALT)),
        gesture(BOOMERANG_UP_LEFT, toggleAltLock),
        gesture(SWIPE_UP_RIGHT, applyControl, modifierThemeSet = modifierThemes(CONTROL_SYMBOL.value, kind = ModifierKeyKind.CONTROL)),
        gesture(BOOMERANG_UP_RIGHT, toggleControlLock),
    ),
)


val space = makeClassicGestureButton(
    rowStart = 3, colStart = 0, rowSpan = 1, colSpan = 3,
    gestureSet = mutableSetOf(
        gesture(CLICK, pressSpace),
        gesture(SWIPE_UP, toggleOneShotShift, threeChars = UNSHIFTED_SYMBOL.value.let { Triple(SHIFTED_SYMBOL.value, it, it) }),
        gesture(BOOMERANG_UP, toggleCapslock, threeChars = Triple(UNSHIFTED_SYMBOL.value, UNSHIFTED_SYMBOL.value, CAPSLOCKED_SYMBOL.value)),
        gesture(SWIPE_DOWN, switchLayer, threeChars = withSymbol(TOGGLE_SETTINGS_LAYER_SYMBOL), appSymbol = TOGGLE_SETTINGS_LAYER_SYMBOL),
        gesture(SWIPE_DOWN_LEFT, switchLayer, appSymbol = TOGGLE_FUNCTION_LAYER_SYMBOL),
        gesture(BOOMERANG_DOWN_RIGHT, /* clearLogs */noOp),
        gesture(CIRCLE_ANTI_CLOCKWISE, switchLayer, appSymbol = TOGGLE_ALPHA_NUMERIC_UNIFIED_LAYER_SYMBOL),
        gesture(CIRCLE_CLOCKWISE, switchLayer, appSymbol = TOGGLE_ALPHA_NUMERIC_UNIFIED_LAYER_SYMBOL),
        gesture(HOLD, simpleInput, threeChars = reversedCase("0")),
        gesture(BOOMERANG_DOWN, simpleInput, threeChars = reversedCase("H")),
    ),
)

val numericSpaceLeft = space.withoutGesture { g: Gesture -> g.currentText == AppSymbol.SETTINGS_SYMBOL.value }
    .withPosition(3, 0, 1, 1)

val numericSpaceRight = space.withPosition(3, 2, 1, 1)

val button0 = makeClassicGestureButton(
    rowStart = 3, colStart = 1, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(CLICK, simpleInput, threeChars = caseSensitive("0"))
    ),
)

val button1 = button_0_0.withoutLetters()
    .withGesture(CLICK, pressKey(KEYCODE_1, respectShift = false), char = "1")

val button2 = button_0_1.withoutLetters()
    .withGesture(CLICK, pressKey(KEYCODE_2, respectShift = false), char = "2")

val button3 = button_0_2.withoutLetters()
    .withGesture(CLICK, pressKey(KEYCODE_3, respectShift = false), char = "3")

val button4 = button_1_0.withoutLetters()
    .withGesture(SWIPE_UP, cycleShiftState, threeChars = shiftLegends)
    .withGesture(SWIPE_DOWN, releaseShift, threeChars = caseSensitive("", SHIFTED_SYMBOL.value, SHIFTED_SYMBOL.value))
    .withGesture(CLICK, pressKey(KEYCODE_4, respectShift = false), threeChars = caseSensitive("4"))

val button5 = button_1_1.withoutLetters()
    .withGesture(CLICK, pressKey(KEYCODE_5, respectShift = false), threeChars = caseSensitive("5"))

val button6 = button_1_2.withoutLetters()
    .withGesture(SWIPE_UP, cycleShiftState, threeChars = shiftLegends)
    .withGesture(SWIPE_DOWN, releaseShift, threeChars = caseSensitive("", SHIFTED_SYMBOL.value, SHIFTED_SYMBOL.value))
    .withGesture(CLICK, pressKey(KEYCODE_6, respectShift = false), threeChars = caseSensitive("6"))

val button7 = button2_0.withoutLetters()
    .withGesture(CLICK, pressKey(KEYCODE_3, respectShift = false), threeChars = caseSensitive("7"))

val button8 = button_2_1.withoutLetters()
    .withGesture(CLICK, pressKey(KEYCODE_8, respectShift = false), threeChars = caseSensitive("8"))

val button9 = button2_2.withoutLetters()
    .withGesture(CLICK, pressKey(KEYCODE_9, respectShift = false), threeChars = caseSensitive("9"))

val f1 = button_0_0
    .replaceGesturesWith(gesture(CLICK, pressKey(KEYCODE_F1), appSymbol = F1_SYMBOL))
val f2 = button_0_1
    .replaceGesturesWith(gesture(CLICK, pressKey(KEYCODE_F2), appSymbol = F2_SYMBOL))
val f3 = button_0_2
    .replaceGesturesWith(gesture(CLICK, pressKey(KEYCODE_F3), appSymbol = F3_SYMBOL))
val f4 = button_1_0
    .replaceGesturesWith(gesture(CLICK, pressKey(KEYCODE_F4), appSymbol = F4_SYMBOL))
val f5 = button_1_1
    .replaceGesturesWith(gesture(CLICK, pressKey(KEYCODE_F5), appSymbol = F5_SYMBOL))
val f6 = button_1_2
    .replaceGesturesWith(gesture(CLICK, pressKey(KEYCODE_F6), appSymbol = F6_SYMBOL))
val f7 = button2_0
    .replaceGesturesWith(gesture(CLICK, pressKey(KEYCODE_F7), appSymbol = F7_SYMBOL))
val f8 = button_2_1
    .replaceGesturesWith(gesture(CLICK, pressKey(KEYCODE_F8), appSymbol = F8_SYMBOL))
val f9 = button2_2
    .replaceGesturesWith(gesture(CLICK, pressKey(KEYCODE_F9), appSymbol = F9_SYMBOL))
val f10 = numericSpaceLeft
    .replaceGesturesWith(gesture(CLICK, pressKey(KEYCODE_F10), appSymbol = F10_SYMBOL))
val f11 = button0
    .replaceGesturesWith(gesture(CLICK, pressKey(KEYCODE_F11), appSymbol = F11_SYMBOL))
val f12 = numericSpaceRight
    .replaceGesturesWith(gesture(CLICK, pressKey(KEYCODE_F12), appSymbol = F12_SYMBOL))
