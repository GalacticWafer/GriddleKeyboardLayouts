package org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.default

import android.view.KeyEvent.KEYCODE_1
import android.view.KeyEvent.KEYCODE_2
import android.view.KeyEvent.KEYCODE_3
import android.view.KeyEvent.KEYCODE_4
import android.view.KeyEvent.KEYCODE_5
import android.view.KeyEvent.KEYCODE_6
import android.view.KeyEvent.KEYCODE_7
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
import org.galacticware.griddle.domain.keybinder.AppSymbol.TOGGLE_CLIPBOARD_LAYER_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.TOGGLE_FUNCTION_LAYER_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.TOGGLE_NUMBER_LAYER_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.TOGGLE_SETTINGS_LAYER_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.UNSHIFTED_SYMBOL
import org.galacticware.griddle.domain.keybinder.AppSymbol.UP_ARROW_SYMBOL
import org.galacticware.griddle.domain.keybinder.KeyBinder.Companion.gestureSet
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
        gestureSet(CLICK, simpleInput, threeChars = caseSensitive("a")),
        gestureSet(HOLD, simpleInput, char = "1"),
        gestureSet(SWIPE_UP_LEFT, cycleAccentCharacters, AppSymbol.CYCLE_ACCENTED_CHARS_SYMBOL),
        gestureSet(SWIPE_RIGHT, simpleInput, threeChars = caseSensitive("-", "÷", "÷")),
        gestureSet(BOOMERANG_RIGHT, simpleInput, threeChars = reversedCase("÷", "-", "-")),
        gestureSet(SWIPE_DOWN_LEFT, simpleInput, threeChars = caseSensitive("$")),
        gestureSet(BOOMERANG_DOWN_LEFT, simpleInput, threeChars = reversedCase("¢")),
        gestureSet(SWIPE_DOWN_RIGHT, simpleInput, threeChars = caseSensitive("v")),
        gestureSet(BOOMERANG_DOWN_RIGHT, simpleInput, threeChars = reversedCase("V")),
        gestureSet(CIRCLE_CLOCKWISE, simpleInput, threeChars = reversedCase("A")),
        gestureSet(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeChars = reversedCase("A")), ),
)

val button_0_1 = makeClassicGestureButton(
    rowStart = 0, colStart = 1, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gestureSet(BOOMERANG_UP, simpleInput, threeChars = caseSensitive("ˇ")),
        gestureSet(CLICK, simpleInput, threeChars = caseSensitive("n")),
        gestureSet(HOLD, simpleInput, threeChars = withSymbol("2")),
        gestureSet(SWIPE_UP_LEFT, simpleInput, threeChars = caseSensitive("`", "\\", "\\")),
        gestureSet(BOOMERANG_UP_LEFT, simpleInput, threeChars = caseSensitive("\\", "`", "`")),
        gestureSet(SWIPE_UP, simpleInput, threeChars = caseSensitive("^", "’", "’")),
        gestureSet(SWIPE_UP_RIGHT, simpleInput, threeChars = Triple("^", "’", "’")),
        gestureSet(SWIPE_RIGHT, simpleInput, threeChars = caseSensitive("!", "¡", "¡")),
        gestureSet(BOOMERANG_RIGHT, simpleInput, threeChars = caseSensitive("¡", "!", "!")),
        gestureSet(SWIPE_DOWN_RIGHT, simpleInput, threeChars = caseSensitive("/", "—", "—")),
        gestureSet(BOOMERANG_DOWN_RIGHT, simpleInput, threeChars = caseSensitive("—", "/", "/")),
        gestureSet(SWIPE_DOWN, simpleInput, threeChars = caseSensitive("l")),
        gestureSet(BOOMERANG_DOWN, simpleInput, threeChars = reversedCase("L")),
        gestureSet(SWIPE_DOWN_LEFT, simpleInput, threeChars = caseSensitive("/", "—", "—")),
        gestureSet(BOOMERANG_DOWN_LEFT, simpleInput, threeChars = caseSensitive("—", "/", "/")),
        gestureSet(SWIPE_LEFT, simpleInput, threeChars = caseSensitive("+", "×", "×")),
        gestureSet(BOOMERANG_LEFT, simpleInput, threeChars = caseSensitive("×", "+", "+")),
        gestureSet(CIRCLE_CLOCKWISE, simpleInput, threeChars = reversedCase("n")),
        gestureSet(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeChars = reversedCase("n")),
    ),
)


val button_0_2 = makeClassicGestureButton(
    rowStart = 0, colStart = 2, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gestureSet(CLICK, simpleInput, threeChars = caseSensitive("i")),
        gestureSet(SWIPE_DOWN_RIGHT, simpleInput, threeChars = caseSensitive("€", "£", "£")),
        gestureSet(BOOMERANG_DOWN_RIGHT, simpleInput, threeChars = caseSensitive("£", "€", "€")),
        gestureSet(SWIPE_DOWN, simpleInput, threeChars = caseSensitive("=", "±", "±")),
        gestureSet(BOOMERANG_DOWN, simpleInput, threeChars = caseSensitive("±", "=", "=")),
        gestureSet(SWIPE_DOWN_LEFT, simpleInput, threeChars = caseSensitive("x")),
        gestureSet(BOOMERANG_DOWN_LEFT, simpleInput, threeChars = reversedCase("X")),
        gestureSet(SWIPE_LEFT, simpleInput, threeChars = caseSensitive("?", "¿", "¿")),
        gestureSet(BOOMERANG_LEFT, simpleInput, threeChars = caseSensitive("¿", "?", "?")),
        gestureSet(CIRCLE_CLOCKWISE, simpleInput, threeChars = reversedCase("I")),
        gestureSet(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeChars = reversedCase("I")),
        gestureSet(HOLD, simpleInput, threeChars = withSymbol("3")),
    ),
)

val shiftIndicator = ModifierThemeSet.forModifierWithDefaultTheme("LOWER", "UPPER", "CAPS ", kind = ModifierKeyKind.SHIFT)

val cursorControlButton = makeClassicGestureButton(
    rowStart = 0, colStart = 3, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gestureSet(CLICK, noOp, modifierThemeSet = shiftIndicator),
        gestureSet(HOLD, toggleCapslock),
        gestureSet(SWIPE_UP, pressKey(KEYCODE_DPAD_UP), threeChars = withSymbol(UP_ARROW_SYMBOL)),
        gestureSet(BOOMERANG_UP, pressKey(KEYCODE_PAGE_UP), threeChars = withSymbol(MOVE_PGDN_SYMBOL)),
        gestureSet(SWIPE_RIGHT, moveRight, threeChars = withSymbol(RIGHT_ARROW_SYMBOL)),
        gestureSet(SWIPE_UP_RIGHT, pressKey(KEYCODE_DPAD_UP)),
        gestureSet(BOOMERANG_UP_RIGHT, pressKey(KEYCODE_DPAD_UP, control)),
        gestureSet(SWIPE_DOWN_RIGHT, pressKey(KEYCODE_DPAD_RIGHT)),
        gestureSet(BOOMERANG_RIGHT, moveWordRight),
        gestureSet(SWIPE_LEFT, moveLeft, threeChars = withSymbol(LEFT_ARROW_SYMBOL)),
        gestureSet(SWIPE_UP_LEFT, pressKey(KEYCODE_DPAD_LEFT)),
        gestureSet(SWIPE_DOWN_LEFT, pressKey(KEYCODE_DPAD_LEFT)),
        gestureSet(BOOMERANG_LEFT, moveWordLeft),
        gestureSet(SWIPE_DOWN, pressKey(KEYCODE_DPAD_DOWN), threeChars = withSymbol(DOWN_ARROW_SYMBOL)),
        gestureSet(BOOMERANG_DOWN, pressKey(KEYCODE_PAGE_DOWN), threeChars = withSymbol(MOVE_PGDN_SYMBOL)),
        gestureSet(CIRCLE_CLOCKWISE, pressKey(KEYCODE_MOVE_END), threeChars = withSymbol(MOVE_END_SYMBOL)),
        gestureSet(CIRCLE_ANTI_CLOCKWISE, pressKey(KEYCODE_MOVE_HOME), threeChars = withSymbol(MOVE_HOME_SYMBOL)),
    ),
)

// you can define a triple of text that will be re-used in multiple gestures
val shiftLegends = Triple(SHIFTED_SYMBOL.value, CAPSLOCKED_SYMBOL.value, UNSHIFTED_SYMBOL.value)

val button_1_0 = makeClassicGestureButton(
    rowStart = 1, colStart = 0, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gestureSet(SWIPE_UP, cycleShiftState, threeChars = shiftLegends),
        gestureSet(SWIPE_DOWN, releaseShift, threeChars = caseSensitive("", SHIFTED_SYMBOL.value, SHIFTED_SYMBOL.value)),
        gestureSet(SWIPE_UP_LEFT, simpleInput, threeChars = Triple("{", "}", "}")),
        gestureSet(BOOMERANG_UP_LEFT, simpleInput, threeChars = Triple("}", "{", "{")),
        gestureSet(SWIPE_UP_RIGHT, simpleInput, threeChars = Triple("%", "‰", "‰")),
        gestureSet(BOOMERANG_UP_RIGHT, simpleInput, threeChars = Triple("‰", "%", "%")),
        gestureSet(SWIPE_RIGHT, simpleInput, threeChars = caseSensitive("k")),
        gestureSet(BOOMERANG_RIGHT, simpleInput, threeChars = reversedCase("K")),
        gestureSet(SWIPE_DOWN_RIGHT, simpleInput, threeChars = Triple("_", "¬", "¬")),
        gestureSet(BOOMERANG_DOWN_RIGHT, simpleInput, threeChars = Triple("¬", "_", "_")),
        gestureSet(SWIPE_DOWN_LEFT, simpleInput, threeChars = Triple("[", "]", "]")),
        gestureSet(BOOMERANG_DOWN_LEFT, simpleInput, threeChars = Triple("]", "[", "[")),
        gestureSet(SWIPE_LEFT, simpleInput, threeChars = Triple("(", ")", ")")),
        gestureSet(BOOMERANG_LEFT, simpleInput, threeChars = Triple(")", "(", "(")),
        gestureSet(CIRCLE_CLOCKWISE, simpleInput, threeChars = reversedCase("H")),
        gestureSet(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeChars = reversedCase("H")),
        gestureSet(HOLD, simpleInput, threeChars = caseSensitive("4")),
        gestureSet(CLICK, simpleInput, threeChars = caseSensitive("h")),
    ),
)

val button_1_1 = makeClassicGestureButton(
    rowStart = 1, colStart = 1, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gestureSet(CLICK, simpleInput, threeChars = caseSensitive("o")),
        gestureSet(SWIPE_UP_LEFT, simpleInput, threeChars = caseSensitive("q")),
        gestureSet(BOOMERANG_UP_LEFT, simpleInput, threeChars = reversedCase("q")),
        gestureSet(SWIPE_UP, simpleInput, threeChars = caseSensitive("u")),
        gestureSet(BOOMERANG_UP, simpleInput, threeChars = reversedCase("u")),
        gestureSet(SWIPE_UP_RIGHT, simpleInput, threeChars = caseSensitive("p")),
        gestureSet(BOOMERANG_UP_RIGHT, simpleInput, threeChars = reversedCase("P")),
        gestureSet(SWIPE_RIGHT, simpleInput, threeChars = caseSensitive("b")),
        gestureSet(BOOMERANG_RIGHT, simpleInput, threeChars = reversedCase("B")),
        gestureSet(SWIPE_DOWN_RIGHT, simpleInput, threeChars = caseSensitive("j")),
        gestureSet(BOOMERANG_DOWN_RIGHT, simpleInput, threeChars = reversedCase("J")),
        gestureSet(SWIPE_DOWN, simpleInput, threeChars = caseSensitive("d")),
        gestureSet(BOOMERANG_DOWN, simpleInput, threeChars = reversedCase("D")),
        gestureSet(SWIPE_DOWN_LEFT, simpleInput, threeChars = caseSensitive("g")),
        gestureSet(BOOMERANG_DOWN_LEFT, simpleInput, threeChars = reversedCase("G")),
        gestureSet(SWIPE_LEFT, simpleInput, threeChars = caseSensitive("c")),
        gestureSet(BOOMERANG_LEFT, simpleInput, threeChars = reversedCase("C")),
        gestureSet(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeChars = reversedCase("O")),
        gestureSet(CIRCLE_CLOCKWISE, simpleInput, threeChars = reversedCase("O")),
        gestureSet(HOLD, simpleInput, threeChars = reversedCase("5")),
    ),
)

val button_1_2 = makeClassicGestureButton(
    rowStart = 1, colStart = 2, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gestureSet(SWIPE_UP, cycleShiftState, threeChars = shiftLegends),
        gestureSet(SWIPE_DOWN, releaseShift, threeChars = caseSensitive("", SHIFTED_SYMBOL.value, SHIFTED_SYMBOL.value)),
        gestureSet(SWIPE_UP_LEFT, simpleInput, threeChars = caseSensitive("|", "\\", "\\")),
        gestureSet(BOOMERANG_UP_LEFT, simpleInput, threeChars = caseSensitive("\\", "|", "|")),
        gestureSet(SWIPE_UP_RIGHT, simpleInput, threeChars = caseSensitive("}", "{", "{")),
        gestureSet(BOOMERANG_UP_RIGHT, simpleInput, threeChars = caseSensitive("{", "}", "}")),
        gestureSet(SWIPE_RIGHT, simpleInput, threeChars = caseSensitive(")", "(", "(")),
        gestureSet(BOOMERANG_RIGHT, simpleInput, threeChars = caseSensitive("(", ")", ")")),
        gestureSet(SWIPE_DOWN_RIGHT, simpleInput, threeChars = caseSensitive("]", "[", "[")),
        gestureSet(BOOMERANG_DOWN_RIGHT, simpleInput, threeChars = caseSensitive("[", "]", "]")),
        gestureSet(BOOMERANG_DOWN, simpleInput, threeChars = caseSensitive("—")),
        gestureSet(SWIPE_DOWN_LEFT, simpleInput, threeChars = caseSensitive("@", "ª", "ª")),
        gestureSet(BOOMERANG_DOWN_LEFT, simpleInput, threeChars = reversedCase("ª", "@", "@")),
        gestureSet(SWIPE_LEFT, simpleInput, threeChars = caseSensitive("m")),
        gestureSet(BOOMERANG_LEFT, simpleInput, threeChars = reversedCase("M")),
        gestureSet(CIRCLE_CLOCKWISE, simpleInput, threeChars = reversedCase("R")),
        gestureSet(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeChars = reversedCase("R")),
        gestureSet(CLICK, simpleInput, threeChars = caseSensitive("r")),
        gestureSet(HOLD, simpleInput, threeChars = reversedCase("6")),
    ),
)


val button2_0 = makeClassicGestureButton(
    rowStart = 2, colStart = 0, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gestureSet(CLICK, simpleInput, threeChars = caseSensitive("t")),
        gestureSet(HOLD, simpleInput, threeChars = reversedCase("7")),
        gestureSet(SWIPE_UP_LEFT, simpleInput, threeChars = caseSensitive("~")),
        gestureSet(SWIPE_UP, simpleInput, threeChars = Triple("¨", "¨", "¨")),
        gestureSet(BOOMERANG_UP, simpleInput, threeChars = Triple("˝", "¨", "¨")),
        gestureSet(SWIPE_UP_RIGHT, simpleInput, threeChars = caseSensitive("y", "y", "Y")),
        gestureSet(BOOMERANG_UP_RIGHT, simpleInput, threeChars = reversedCase("Y")),
        gestureSet(SWIPE_RIGHT, simpleInput, threeChars = Triple("*", "†", "†")),
        gestureSet(BOOMERANG_RIGHT, simpleInput, threeChars = Triple("†", "*", "*")),
        gestureSet(SWIPE_LEFT, simpleInput, threeChars = Triple("<", ">", ">")),
        gestureSet(BOOMERANG_LEFT, simpleInput, threeChars = Triple(">", "<", "<")),
        gestureSet(SWIPE_DOWN_RIGHT, pressKey(KEYCODE_TAB), threeChars = withSymbol(TAB_RIGHT_SYMBOL)),
        gestureSet(CIRCLE_CLOCKWISE, simpleInput, threeChars = reversedCase("T")),
        gestureSet(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeChars = reversedCase("T")),
        gestureSet(SWIPE_DOWN, repeatPreviousOperation, appSymbol = AppSymbol.REPEAT_SYMBOL),
    ),
)


val button_2_1 = makeClassicGestureButton(
    rowStart = 2, colStart = 1, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gestureSet(SWIPE_UP_LEFT, simpleInput, threeChars = caseSensitive("\"")),
        gestureSet(BOOMERANG_UP_LEFT, simpleInput, threeChars = caseSensitive(" ")),
        gestureSet(SWIPE_UP, simpleInput, threeChars = caseSensitive("w")),
        gestureSet(BOOMERANG_UP, simpleInput, threeChars = reversedCase("W")),
        gestureSet(SWIPE_UP_RIGHT, simpleInput, threeChars = caseSensitive("\'")),
        gestureSet(BOOMERANG_UP_RIGHT, simpleInput, threeChars = caseSensitive("\'")),
        gestureSet(SWIPE_RIGHT, simpleInput, threeChars = caseSensitive("z")),
        gestureSet(BOOMERANG_RIGHT, simpleInput, threeChars = reversedCase("Z")),
        gestureSet(SWIPE_DOWN_RIGHT, simpleInput, threeChars = caseSensitive(":")),
        gestureSet(BOOMERANG_RIGHT, simpleInput, threeChars = caseSensitive(";")),
        gestureSet(BOOMERANG_DOWN_RIGHT, simpleInput, threeChars = caseSensitive(",")),
        gestureSet(SWIPE_DOWN, simpleInput, threeChars = caseSensitive(".", "…", "…")),
        gestureSet(BOOMERANG_DOWN, simpleInput, threeChars = caseSensitive("…", ".", ".")),
        gestureSet(SWIPE_DOWN_LEFT, simpleInput, threeChars = caseSensitive(",")),
        gestureSet(BOOMERANG_DOWN_LEFT, simpleInput, threeChars = caseSensitive(",")),
        gestureSet(SWIPE_LEFT, simpleInput, threeChars = caseSensitive(",")),
        gestureSet(BOOMERANG_LEFT, simpleInput, threeChars = caseSensitive(",")),
        gestureSet(CIRCLE_CLOCKWISE, simpleInput, threeChars = reversedCase("E")),
        gestureSet(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeChars = reversedCase("E")),
        gestureSet(HOLD, simpleInput, threeChars = caseSensitive("8")),
        gestureSet(CLICK, simpleInput, threeChars = caseSensitive("e")),
        gestureSet(HOLD, simpleInput, threeChars = reversedCase("8")),
    ),
)


val button2_2 = makeClassicGestureButton(
    rowStart = 2, colStart = 2, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gestureSet(CLICK, simpleInput, threeChars = caseSensitive("s")),
        gestureSet(SWIPE_UP_LEFT, simpleInput, threeChars = caseSensitive("f")),
        gestureSet(BOOMERANG_UP_LEFT, simpleInput, threeChars = reversedCase("F")),
        gestureSet(SWIPE_UP, simpleInput, threeChars = caseSensitive("&")),
        gestureSet(SWIPE_RIGHT, simpleInput, threeChars = caseSensitive(">")),
        gestureSet(SWIPE_UP_RIGHT, simpleInput, threeChars = caseSensitive("°")),
        gestureSet(SWIPE_DOWN_LEFT, simpleInput, threeChars = caseSensitive(";")),
        gestureSet(BOOMERANG_DOWN_LEFT, simpleInput, threeChars = caseSensitive(";")),
        gestureSet(SWIPE_LEFT, simpleInput, threeChars = caseSensitive("#")),
        gestureSet(BOOMERANG_LEFT, simpleInput, threeChars = caseSensitive(" ")),
        gestureSet(CIRCLE_CLOCKWISE, simpleInput, threeChars = reversedCase("S")),
        gestureSet(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeChars = reversedCase("S")),
        gestureSet(HOLD, simpleInput, threeChars = caseSensitive("9")),
        gestureSet(CLICK, simpleInput, threeChars = caseSensitive("s")),
        gestureSet(HOLD, simpleInput, threeChars = reversedCase("9")),
    ),
)



val cycleEmojisLeft = makeClassicGestureButton(
    rowStart = 3, colStart = 0, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gestureSet(CLICK, /* cycleEmojiPage */noOp, threeChars = caseSensitive("⬅\uFE0F"))
    ),
)


val cycleEmojisRight = cycleEmojisLeft
    .withPosition(rowStart = 3, colStart=2, rowSpan = 1, colSpan = 1,)



val multiKey: Gesture =  gestureSet(CLICK, swappable(
    pressKey(KEYCODE_DEL) to withSymbol(BACKSPACE_SYMBOL),
    repeatPreviousOperation to withSymbol(AppSymbol.REPEAT_SYMBOL),
), threeChars = withSymbol(BACKSPACE_SYMBOL))

val backspace = makeClassicGestureButton(
    rowStart = 2, colStart = 3, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gestureSet(HOLD, swapGesture(multiKey)),
        multiKey,
        gestureSet(SWIPE_LEFT, pressKey(KEYCODE_DEL)),
        gestureSet(SWIPE_UP_LEFT, pressKey(KEYCODE_DEL)),
        gestureSet(SWIPE_DOWN_LEFT, pressKey(KEYCODE_DEL)),
        gestureSet(BOOMERANG_LEFT, pressKey(KEYCODE_DEL, control)),
        gestureSet(SWIPE_RIGHT, pressKey(KEYCODE_FORWARD_DEL)),
        gestureSet(SWIPE_UP_RIGHT, pressKey(KEYCODE_FORWARD_DEL)),
        gestureSet(SWIPE_DOWN_RIGHT, pressKey(KEYCODE_FORWARD_DEL)),
        gestureSet(BOOMERANG_RIGHT, pressKey(KEYCODE_FORWARD_DEL, control)),
    ),
)


val rightBackspace = backspace
    .withPosition(rowStart = 2, colStart = 3, rowSpan = 1, colSpan = 1,)


val rightAlphaLayerToggle = makeClassicGestureButton(
    rowStart = 1, colStart = 3, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gestureSet(SWIPE_UP, remappedSymbolLookup, appSymbol = COPY_SYMBOL),
        gestureSet(SWIPE_LEFT, remappedSymbolLookup, appSymbol = CUT_SYMBOL),
        gestureSet(SWIPE_UP_LEFT, openMacroEditor, appSymbol = MACRO_SYMBOL, ),
        gestureSet(SWIPE_DOWN, remappedSymbolLookup, appSymbol = PASTE_SYMBOL),
        gestureSet(CLICK, switchLayer, appSymbol = TOGGLE_ALPHA_LAYER_SYMBOL),
        gestureSet(SWIPE_RIGHT, swapHandedness, appSymbol = SWAP_HANDEDNESS),
        gestureSet(CIRCLE_ANTI_CLOCKWISE, pressKey(KEYCODE_A, control)),
        gestureSet(CIRCLE_CLOCKWISE, pressKey(KEYCODE_A, control)),
        gestureSet(SWIPE_DOWN_RIGHT, startRecognizingSpeech, appSymbol = MICROPHONE_CHAR),
        gestureSet(BOOMERANG_DOWN, switchLayer, appSymbol = TOGGLE_CLIPBOARD_LAYER_SYMBOL),
    ),
)

val lefAlphaLayerToggle = rightAlphaLayerToggle
    .withPosition(rowStart = 1, colStart = 3, rowSpan = 1, colSpan = 1,)

val rightNumLayerToggle = makeClassicGestureButton(
    rowStart = 1, colStart = 3, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gestureSet(SWIPE_UP, remappedSymbolLookup, appSymbol = COPY_SYMBOL),
        gestureSet(SWIPE_LEFT, remappedSymbolLookup, appSymbol = CUT_SYMBOL),
        gestureSet(SWIPE_DOWN, remappedSymbolLookup, appSymbol = PASTE_SYMBOL),
        gestureSet(SWIPE_UP_LEFT, openMacroEditor, appSymbol = MACRO_SYMBOL, ),
        gestureSet(SWIPE_RIGHT, swapHandedness, appSymbol = SWAP_HANDEDNESS),
        gestureSet(CLICK, switchLayer, appSymbol = TOGGLE_NUMBER_LAYER_SYMBOL),
        gestureSet(CIRCLE_ANTI_CLOCKWISE, selectAll, appSymbol = SELECT_ALL_TEXT_SYMBOL),
        gestureSet(CIRCLE_CLOCKWISE, selectAll, appSymbol = SELECT_ALL_TEXT_SYMBOL),
        gestureSet(SWIPE_DOWN_RIGHT, startRecognizingSpeech, appSymbol = MICROPHONE_CHAR),
        gestureSet(BOOMERANG_DOWN, switchLayer, appSymbol = TOGGLE_CLIPBOARD_LAYER_SYMBOL),
    ),
)

val leftNumLayerToggles = rightNumLayerToggle
    .withPosition(rowStart = 1, colStart = 3, rowSpan = 1, colSpan = 1)

val enter = makeClassicGestureButton(
    rowStart = 3, colStart = 3, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gestureSet(CLICK, pressKey(KEYCODE_ENTER), threeChars = withSymbol(ENTER_SYMBOL)),
        gestureSet(SWIPE_UP_LEFT, applyAlt, modifierThemeSet = modifierThemes(ALT_SYMBOL.value, kind = ModifierKeyKind.ALT)),
        gestureSet(BOOMERANG_UP_LEFT, toggleAltLock),
        gestureSet(SWIPE_UP_RIGHT, applyControl, modifierThemeSet = modifierThemes(CONTROL_SYMBOL.value, kind = ModifierKeyKind.CONTROL)),
        gestureSet(BOOMERANG_UP_RIGHT, toggleControlLock),
    ),
)


val space = makeClassicGestureButton(
    rowStart = 3, colStart = 0, rowSpan = 1, colSpan = 3,
    gestureSet = mutableSetOf(
        gestureSet(CLICK, pressSpace),
        gestureSet(SWIPE_UP, toggleOneShotShift, threeChars = UNSHIFTED_SYMBOL.value.let { Triple(SHIFTED_SYMBOL.value, it, it) }),
        gestureSet(BOOMERANG_UP, toggleCapslock, threeChars = Triple(UNSHIFTED_SYMBOL.value, UNSHIFTED_SYMBOL.value, CAPSLOCKED_SYMBOL.value)),
        gestureSet(SWIPE_DOWN, switchLayer, threeChars = withSymbol(TOGGLE_SETTINGS_LAYER_SYMBOL), appSymbol = TOGGLE_SETTINGS_LAYER_SYMBOL),
        gestureSet(SWIPE_DOWN_LEFT, switchLayer, appSymbol = TOGGLE_FUNCTION_LAYER_SYMBOL),
        gestureSet(BOOMERANG_DOWN_RIGHT, /* clearLogs */noOp),
        gestureSet(CIRCLE_ANTI_CLOCKWISE, switchLayer, appSymbol = TOGGLE_ALPHA_NUMERIC_UNIFIED_LAYER_SYMBOL),
        gestureSet(CIRCLE_CLOCKWISE, switchLayer, appSymbol = TOGGLE_ALPHA_NUMERIC_UNIFIED_LAYER_SYMBOL),
        gestureSet(HOLD, simpleInput, threeChars = reversedCase("0")),
        gestureSet(BOOMERANG_DOWN, simpleInput, threeChars = reversedCase("H")),
    ),
)

val numericSpaceLeft = space.withoutGesture { g: Gesture -> g.currentText == AppSymbol.SETTINGS_SYMBOL.value }
    .withPosition(3, 0, 1, 1)

val numericSpaceRight = space.withPosition(3, 2, 1, 1)

val button0 = makeClassicGestureButton(
    rowStart = 3, colStart = 1, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gestureSet(CLICK, simpleInput, threeChars = caseSensitive("0"))
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
    .withGesture(CLICK, pressKey(KEYCODE_7, respectShift = false), threeChars = caseSensitive("7"))

val button8 = button_2_1.withoutLetters()
    .withGesture(CLICK, pressKey(KEYCODE_8, respectShift = false), threeChars = caseSensitive("8"))

val button9 = button2_2.withoutLetters()
    .withGesture(CLICK, pressKey(KEYCODE_9, respectShift = false), threeChars = caseSensitive("9"))

val f1 = button_0_0
    .replaceGesturesWith(gestureSet(CLICK, pressKey(KEYCODE_F1), appSymbol = F1_SYMBOL))
val f2 = button_0_1
    .replaceGesturesWith(gestureSet(CLICK, pressKey(KEYCODE_F2), appSymbol = F2_SYMBOL))
val f3 = button_0_2
    .replaceGesturesWith(gestureSet(CLICK, pressKey(KEYCODE_F3), appSymbol = F3_SYMBOL))
val f4 = button_1_0
    .replaceGesturesWith(gestureSet(CLICK, pressKey(KEYCODE_F4), appSymbol = F4_SYMBOL))
val f5 = button_1_1
    .replaceGesturesWith(gestureSet(CLICK, pressKey(KEYCODE_F5), appSymbol = F5_SYMBOL))
val f6 = button_1_2
    .replaceGesturesWith(gestureSet(CLICK, pressKey(KEYCODE_F6), appSymbol = F6_SYMBOL))
val f7 = button2_0
    .replaceGesturesWith(gestureSet(CLICK, pressKey(KEYCODE_F7), appSymbol = F7_SYMBOL))
val f8 = button_2_1
    .replaceGesturesWith(gestureSet(CLICK, pressKey(KEYCODE_F8), appSymbol = F8_SYMBOL))
val f9 = button2_2
    .replaceGesturesWith(gestureSet(CLICK, pressKey(KEYCODE_F9), appSymbol = F9_SYMBOL))
val f10 = numericSpaceLeft
    .replaceGesturesWith(gestureSet(CLICK, pressKey(KEYCODE_F10), appSymbol = F10_SYMBOL))
val f11 = button0
    .replaceGesturesWith(gestureSet(CLICK, pressKey(KEYCODE_F11), appSymbol = F11_SYMBOL))
val f12 = numericSpaceRight
    .replaceGesturesWith(gestureSet(CLICK, pressKey(KEYCODE_F12), appSymbol = F12_SYMBOL))
