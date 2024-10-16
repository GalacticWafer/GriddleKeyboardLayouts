package org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english

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
import org.galacticware.griddle.domain.keybinder.AppSymbol.SHIFTED
import org.galacticware.griddle.domain.keybinder.AppSymbol.TAB_RIGHT
import org.galacticware.griddle.domain.keybinder.KeyBinder.Companion.gesture
import org.galacticware.griddle.domain.operation.cycleAccentCharacters
import org.galacticware.griddle.domain.operation.cycleShiftState
import org.galacticware.griddle.domain.operation.pressTab
import org.galacticware.griddle.domain.operation.releaseShift
import org.galacticware.griddle.domain.operation.repeatPreviousOperation
import org.galacticware.griddle.domain.operation.sendEnter
import org.galacticware.griddle.domain.operation.sendTab
import org.galacticware.griddle.domain.operation.simpleInput
import org.galacticware.griddle.domain.operation.toggleCapslock
import org.galacticware.griddle.domain.util.caseSensitive
import org.galacticware.griddle.domain.util.reversedCase
import org.galacticware.griddle.domain.util.triple
import org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.shiftLegends

/***
 * The definitions for English keys, roughly-based on the MessagEase layout.
 * Alphas and numerics are in the same place, with the same possible gestures for them.
 */

// By convention, we name the buttons `button_<row>_<col>`, where `<row>` and `<col>`
// are the row start and and column start indices of the button, respectively.
val button_0_0 get() = makeClassicGestureButton(
    // define the position and size of the button
    rowStart = 0, colStart = 0, rowSpan = 1, colSpan = 1,
    // define the gestures that can be performed on the button
    gestureSet = mutableSetOf(
        gesture(CLICK, simpleInput, threeStrings = caseSensitive("a")),
        gesture(HOLD, simpleInput, oneString = "1"),
        gesture(SWIPE_UP_LEFT, cycleAccentCharacters, AppSymbol.CYCLE_ACCENTED_CHARS),
        gesture(SWIPE_RIGHT, simpleInput, threeStrings = caseSensitive("-", "÷", "÷")),
        gesture(BOOMERANG_RIGHT, simpleInput, threeStrings = reversedCase("÷", "-", "-")),
        gesture(SWIPE_DOWN_LEFT, simpleInput, threeStrings = caseSensitive("$")),
        gesture(BOOMERANG_DOWN_LEFT, simpleInput, threeStrings = reversedCase("¢")),
        gesture(SWIPE_DOWN_RIGHT, simpleInput, threeStrings = caseSensitive("v")),
        gesture(BOOMERANG_DOWN_RIGHT, simpleInput, threeStrings = reversedCase("V")),
        gesture(CIRCLE_CLOCKWISE, simpleInput, threeStrings = reversedCase("A")),
        gesture(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeStrings = reversedCase("A")), ),
)

val button_0_1 get() = makeClassicGestureButton(
    rowStart = 0, colStart = 1, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(BOOMERANG_UP, simpleInput, threeStrings = caseSensitive("ˇ")),
        gesture(CLICK, simpleInput, threeStrings = caseSensitive("n")),
        gesture(HOLD, simpleInput, threeStrings = triple("2")),
        gesture(SWIPE_UP_LEFT, simpleInput, threeStrings = caseSensitive("`", "\\", "\\")),
        gesture(BOOMERANG_UP_LEFT, simpleInput, threeStrings = caseSensitive("\\", "`", "`")),
        gesture(SWIPE_UP, simpleInput, threeStrings = caseSensitive("^", "’", "’")),
        gesture(SWIPE_UP_RIGHT, simpleInput, threeStrings = Triple("^", "’", "’")),
        gesture(SWIPE_RIGHT, simpleInput, threeStrings = caseSensitive("!", "¡", "¡")),
        gesture(BOOMERANG_RIGHT, simpleInput, threeStrings = caseSensitive("¡", "!", "!")),
        gesture(SWIPE_DOWN_RIGHT, simpleInput, threeStrings = caseSensitive("/", "—", "—")),
        gesture(BOOMERANG_DOWN_RIGHT, simpleInput, threeStrings = caseSensitive("—", "/", "/")),
        gesture(SWIPE_DOWN, simpleInput, threeStrings = caseSensitive("l")),
        gesture(BOOMERANG_DOWN, simpleInput, threeStrings = reversedCase("L")),
        gesture(SWIPE_DOWN_LEFT, simpleInput, threeStrings = caseSensitive("/", "—", "—")),
        gesture(BOOMERANG_DOWN_LEFT, simpleInput, threeStrings = caseSensitive("—", "/", "/")),
        gesture(SWIPE_LEFT, simpleInput, threeStrings = caseSensitive("+", "×", "×")),
        gesture(BOOMERANG_LEFT, simpleInput, threeStrings = caseSensitive("×", "+", "+")),
        gesture(CIRCLE_CLOCKWISE, simpleInput, threeStrings = reversedCase("n")),
        gesture(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeStrings = reversedCase("n")),
    ),
)


val button_0_2 get() = makeClassicGestureButton(
    rowStart = 0, colStart = 2, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(CLICK, simpleInput, threeStrings = caseSensitive("i")),
        gesture(SWIPE_DOWN_RIGHT, simpleInput, threeStrings = caseSensitive("€", "£", "£")),
        gesture(BOOMERANG_DOWN_RIGHT, simpleInput, threeStrings = caseSensitive("£", "€", "€")),
        gesture(SWIPE_DOWN, simpleInput, threeStrings = caseSensitive("=", "±", "±")),
        gesture(BOOMERANG_DOWN, simpleInput, threeStrings = caseSensitive("±", "=", "=")),
        gesture(SWIPE_DOWN_LEFT, simpleInput, threeStrings = caseSensitive("x")),
        gesture(BOOMERANG_DOWN_LEFT, simpleInput, threeStrings = reversedCase("X")),
        gesture(SWIPE_LEFT, simpleInput, threeStrings = caseSensitive("?", "¿", "¿")),
        gesture(BOOMERANG_LEFT, simpleInput, threeStrings = caseSensitive("¿", "?", "?")),
        gesture(CIRCLE_CLOCKWISE, simpleInput, threeStrings = reversedCase("I")),
        gesture(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeStrings = reversedCase("I")),
        gesture(HOLD, simpleInput, threeStrings = triple("3")),
    ),
    isPeripheral = true,
)


val button_1_0 get() = makeClassicGestureButton(
    rowStart = 1, colStart = 0, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(SWIPE_UP, cycleShiftState, threeStrings = shiftLegends, isIndicator = true),
        gesture(SWIPE_DOWN, releaseShift, threeStrings = caseSensitive("", SHIFTED.value, SHIFTED.value)),
        gesture(SWIPE_UP_LEFT, simpleInput, threeStrings = Triple("{", "}", "}")),
        gesture(BOOMERANG_UP_LEFT, simpleInput, threeStrings = Triple("}", "{", "{")),
        gesture(BOOMERANG_UP, toggleCapslock),
        gesture(SWIPE_UP_RIGHT, simpleInput, threeStrings = Triple("%", "‰", "‰")),
        gesture(BOOMERANG_UP_RIGHT, simpleInput, threeStrings = Triple("‰", "%", "%")),
        gesture(SWIPE_RIGHT, simpleInput, threeStrings = caseSensitive("k")),
        gesture(BOOMERANG_RIGHT, simpleInput, threeStrings = reversedCase("K")),
        gesture(SWIPE_DOWN_RIGHT, simpleInput, threeStrings = Triple("_", "¬", "¬")),
        gesture(BOOMERANG_DOWN_RIGHT, simpleInput, threeStrings = Triple("¬", "_", "_")),
        gesture(SWIPE_DOWN_LEFT, simpleInput, threeStrings = Triple("[", "]", "]")),
        gesture(BOOMERANG_DOWN_LEFT, simpleInput, threeStrings = Triple("]", "[", "[")),
        gesture(SWIPE_LEFT, simpleInput, threeStrings = Triple("(", ")", ")")),
        gesture(BOOMERANG_LEFT, simpleInput, threeStrings = Triple(")", "(", "(")),
        gesture(CIRCLE_CLOCKWISE, simpleInput, threeStrings = reversedCase("H")),
        gesture(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeStrings = reversedCase("H")),
        gesture(HOLD, simpleInput, threeStrings = caseSensitive("4")),
        gesture(CLICK, simpleInput, threeStrings = caseSensitive("h")),
    ),
)

val button_1_1 get() = makeClassicGestureButton(
    rowStart = 1, colStart = 1, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(CLICK, simpleInput, threeStrings = caseSensitive("o")),
        gesture(SWIPE_UP_LEFT, simpleInput, threeStrings = caseSensitive("q")),
        gesture(BOOMERANG_UP_LEFT, simpleInput, threeStrings = reversedCase("q")),
        gesture(SWIPE_UP, simpleInput, threeStrings = caseSensitive("u")),
        gesture(BOOMERANG_UP, simpleInput, threeStrings = reversedCase("u")),
        gesture(SWIPE_UP_RIGHT, simpleInput, threeStrings = caseSensitive("p")),
        gesture(BOOMERANG_UP_RIGHT, simpleInput, threeStrings = reversedCase("P")),
        gesture(SWIPE_RIGHT, simpleInput, threeStrings = caseSensitive("b")),
        gesture(BOOMERANG_RIGHT, simpleInput, threeStrings = reversedCase("B")),
        gesture(SWIPE_DOWN_RIGHT, simpleInput, threeStrings = caseSensitive("j")),
        gesture(BOOMERANG_DOWN_RIGHT, simpleInput, threeStrings = reversedCase("J")),
        gesture(SWIPE_DOWN, simpleInput, threeStrings = caseSensitive("d")),
        gesture(BOOMERANG_DOWN, simpleInput, threeStrings = reversedCase("D")),
        gesture(SWIPE_DOWN_LEFT, simpleInput, threeStrings = caseSensitive("g")),
        gesture(BOOMERANG_DOWN_LEFT, simpleInput, threeStrings = reversedCase("G")),
        gesture(SWIPE_LEFT, simpleInput, threeStrings = caseSensitive("c")),
        gesture(BOOMERANG_LEFT, simpleInput, threeStrings = reversedCase("C")),
        gesture(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeStrings = reversedCase("O")),
        gesture(CIRCLE_CLOCKWISE, simpleInput, threeStrings = reversedCase("O")),
        gesture(HOLD, simpleInput, threeStrings = reversedCase("5")),
    ),
)

val button_1_2 get() = makeClassicGestureButton(
    rowStart = 1, colStart = 2, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(SWIPE_UP, cycleShiftState, threeStrings = shiftLegends, isIndicator = true),
        gesture(SWIPE_DOWN, releaseShift, threeStrings = caseSensitive("", SHIFTED.value, SHIFTED.value)),
        gesture(SWIPE_UP_LEFT, simpleInput, threeStrings = caseSensitive("|", "\\", "\\")),
        gesture(BOOMERANG_UP_LEFT, simpleInput, threeStrings = caseSensitive("\\", "|", "|")),
        gesture(BOOMERANG_UP, toggleCapslock),
        gesture(SWIPE_UP_RIGHT, simpleInput, threeStrings = caseSensitive("}", "{", "{")),
        gesture(BOOMERANG_UP_RIGHT, simpleInput, threeStrings = caseSensitive("{", "}", "}")),
        gesture(SWIPE_RIGHT, simpleInput, threeStrings = caseSensitive(")", "(", "(")),
        gesture(BOOMERANG_RIGHT, simpleInput, threeStrings = caseSensitive("(", ")", ")")),
        gesture(SWIPE_DOWN_RIGHT, simpleInput, threeStrings = caseSensitive("]", "[", "[")),
        gesture(BOOMERANG_DOWN_RIGHT, simpleInput, threeStrings = caseSensitive("[", "]", "]")),
        gesture(BOOMERANG_DOWN, simpleInput, threeStrings = caseSensitive("—")),
        gesture(SWIPE_DOWN_LEFT, simpleInput, threeStrings = caseSensitive("@", "ª", "ª")),
        gesture(BOOMERANG_DOWN_LEFT, simpleInput, threeStrings = reversedCase("ª", "@", "@")),
        gesture(SWIPE_LEFT, simpleInput, threeStrings = caseSensitive("m")),
        gesture(BOOMERANG_LEFT, simpleInput, threeStrings = reversedCase("M")),
        gesture(CIRCLE_CLOCKWISE, simpleInput, threeStrings = reversedCase("R")),
        gesture(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeStrings = reversedCase("R")),
        gesture(CLICK, simpleInput, threeStrings = caseSensitive("r")),
        gesture(HOLD, simpleInput, threeStrings = reversedCase("6")),
    ),
)


val button2_0 get() = makeClassicGestureButton(
    rowStart = 2, colStart = 0, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(CLICK, simpleInput, threeStrings = caseSensitive("t")),
        gesture(HOLD, simpleInput, threeStrings = reversedCase("7")),
        gesture(SWIPE_UP_LEFT, simpleInput, threeStrings = caseSensitive("~")),
        gesture(SWIPE_UP, simpleInput, threeStrings = Triple("¨", "¨", "¨")),
        gesture(BOOMERANG_UP, simpleInput, threeStrings = Triple("˝", "¨", "¨")),
        gesture(SWIPE_UP_RIGHT, simpleInput, threeStrings = caseSensitive("y", "y", "Y")),
        gesture(BOOMERANG_UP_RIGHT, simpleInput, threeStrings = reversedCase("Y")),
        gesture(SWIPE_RIGHT, simpleInput, threeStrings = Triple("*", "†", "†")),
        gesture(BOOMERANG_RIGHT, simpleInput, threeStrings = Triple("†", "*", "*")),
        gesture(SWIPE_LEFT, simpleInput, threeStrings = Triple("<", ">", ">")),
        gesture(BOOMERANG_LEFT, simpleInput, threeStrings = Triple(">", "<", "<")),
        gesture(SWIPE_DOWN_RIGHT, sendTab /*pressKey(KEYCODE_TAB)*/, threeStrings = triple(TAB_RIGHT)),
        gesture(BOOMERANG_DOWN_RIGHT, pressTab /*pressKey(KEYCODE_TAB)*/, threeStrings = triple(TAB_RIGHT)),
        gesture(CIRCLE_CLOCKWISE, simpleInput, threeStrings = reversedCase("T")),
        gesture(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeStrings = reversedCase("T")),
        gesture(SWIPE_DOWN, repeatPreviousOperation, appSymbol = AppSymbol.REPEAT),
    ),
)


val button_2_1 get() = makeClassicGestureButton(
    rowStart = 2, colStart = 1, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(SWIPE_UP_LEFT, simpleInput, threeStrings = caseSensitive("\"")),
        gesture(BOOMERANG_UP_LEFT, simpleInput, threeStrings = caseSensitive(" ")),
        gesture(SWIPE_UP, simpleInput, threeStrings = caseSensitive("w")),
        gesture(BOOMERANG_UP, simpleInput, threeStrings = reversedCase("W")),
        gesture(SWIPE_UP_RIGHT, simpleInput, threeStrings = caseSensitive("\'")),
        gesture(BOOMERANG_UP_RIGHT, simpleInput, threeStrings = caseSensitive("\'")),
        gesture(SWIPE_RIGHT, simpleInput, threeStrings = caseSensitive("z")),
        gesture(BOOMERANG_RIGHT, simpleInput, threeStrings = reversedCase("Z")),
        gesture(SWIPE_DOWN_RIGHT, simpleInput, threeStrings = caseSensitive(":")),
        gesture(BOOMERANG_RIGHT, simpleInput, threeStrings = caseSensitive(";")),
        gesture(BOOMERANG_DOWN_RIGHT, simpleInput, threeStrings = caseSensitive(",")),
        gesture(SWIPE_DOWN, simpleInput, threeStrings = caseSensitive(".", "…", "…")),
        gesture(BOOMERANG_DOWN, simpleInput, threeStrings = caseSensitive("…", ".", ".")),
        gesture(SWIPE_DOWN_LEFT, simpleInput, threeStrings = caseSensitive(",")),
        gesture(BOOMERANG_DOWN_LEFT, simpleInput, threeStrings = caseSensitive(",")),
        gesture(SWIPE_LEFT, simpleInput, threeStrings = caseSensitive(",")),
        gesture(BOOMERANG_LEFT, simpleInput, threeStrings = caseSensitive(",")),
        gesture(CIRCLE_CLOCKWISE, simpleInput, threeStrings = reversedCase("E")),
        gesture(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeStrings = reversedCase("E")),
        gesture(HOLD, simpleInput, threeStrings = caseSensitive("8")),
        gesture(CLICK, simpleInput, threeStrings = caseSensitive("e")),
        gesture(HOLD, simpleInput, threeStrings = reversedCase("8")),
    ),
)


val button2_2 get() = makeClassicGestureButton(
    rowStart = 2, colStart = 2, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(CLICK, simpleInput, threeStrings = caseSensitive("s")),
        gesture(SWIPE_UP_LEFT, simpleInput, threeStrings = caseSensitive("f")),
        gesture(BOOMERANG_UP_LEFT, simpleInput, threeStrings = reversedCase("F")),
        gesture(SWIPE_UP, simpleInput, threeStrings = caseSensitive("&")),
        gesture(SWIPE_RIGHT, simpleInput, threeStrings = caseSensitive(">")),
        gesture(SWIPE_UP_RIGHT, simpleInput, threeStrings = caseSensitive("°")),
        gesture(SWIPE_DOWN_LEFT, simpleInput, threeStrings = caseSensitive(";")),
        gesture(SWIPE_DOWN, sendEnter, oneString = "\\n"),
        gesture(BOOMERANG_DOWN_LEFT, simpleInput, threeStrings = caseSensitive(";")),
        gesture(SWIPE_LEFT, simpleInput, threeStrings = caseSensitive("#")),
        gesture(BOOMERANG_LEFT, simpleInput, threeStrings = caseSensitive(" ")),
        gesture(CIRCLE_CLOCKWISE, simpleInput, threeStrings = reversedCase("S")),
        gesture(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeStrings = reversedCase("S")),
        gesture(HOLD, simpleInput, threeStrings = caseSensitive("9")),
        gesture(CLICK, simpleInput, threeStrings = caseSensitive("s")),
        gesture(HOLD, simpleInput, threeStrings = reversedCase("9")),
    ),
)