package com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.button

import android.view.KeyEvent.KEYCODE_A
import android.view.KeyEvent.KEYCODE_DEL
import android.view.KeyEvent.KEYCODE_DPAD_DOWN
import android.view.KeyEvent.KEYCODE_DPAD_UP
import android.view.KeyEvent.KEYCODE_FORWARD_DEL
import android.view.KeyEvent.KEYCODE_PAGE_DOWN
import android.view.KeyEvent.KEYCODE_PAGE_UP
import android.view.KeyEvent.KEYCODE_SPACE
import android.view.KeyEvent.KEYCODE_Y
import android.view.KeyEvent.KEYCODE_Z
import com.galacticware.griddle.model.button.GestureButtonBuilder.Companion.gestureButton
import com.galacticware.griddle.model.gesture.Gesture
import com.galacticware.griddle.model.gesture.GestureType.BOOMERANG_DOWN
import com.galacticware.griddle.model.gesture.GestureType.BOOMERANG_DOWN_LEFT
import com.galacticware.griddle.model.gesture.GestureType.BOOMERANG_DOWN_RIGHT
import com.galacticware.griddle.model.gesture.GestureType.BOOMERANG_LEFT
import com.galacticware.griddle.model.gesture.GestureType.BOOMERANG_RIGHT
import com.galacticware.griddle.model.gesture.GestureType.BOOMERANG_UP
import com.galacticware.griddle.model.gesture.GestureType.BOOMERANG_UP_LEFT
import com.galacticware.griddle.model.gesture.GestureType.BOOMERANG_UP_RIGHT
import com.galacticware.griddle.model.gesture.GestureType.CIRCLE_ANTI_CLOCKWISE
import com.galacticware.griddle.model.gesture.GestureType.CIRCLE_CLOCKWISE
import com.galacticware.griddle.model.gesture.GestureType.CLICK
import com.galacticware.griddle.model.gesture.GestureType.HOLD
import com.galacticware.griddle.model.gesture.GestureType.SWIPE_DOWN
import com.galacticware.griddle.model.gesture.GestureType.SWIPE_DOWN_LEFT
import com.galacticware.griddle.model.gesture.GestureType.SWIPE_DOWN_RIGHT
import com.galacticware.griddle.model.gesture.GestureType.SWIPE_LEFT
import com.galacticware.griddle.model.gesture.GestureType.SWIPE_RIGHT
import com.galacticware.griddle.model.gesture.GestureType.SWIPE_UP
import com.galacticware.griddle.model.gesture.GestureType.SWIPE_UP_LEFT
import com.galacticware.griddle.model.gesture.GestureType.SWIPE_UP_RIGHT
import com.galacticware.griddle.model.keybinder.AppSymbol
import com.galacticware.griddle.model.keybinder.AppSymbol.BACKSPACE
import com.galacticware.griddle.model.keybinder.AppSymbol.CAPSLOCKED
import com.galacticware.griddle.model.keybinder.AppSymbol.CHOOSE_DIFFERENT_INPUT_METHOD
import com.galacticware.griddle.model.keybinder.AppSymbol.COPY
import com.galacticware.griddle.model.keybinder.AppSymbol.CUT
import com.galacticware.griddle.model.keybinder.AppSymbol.DOWN_ARROW
import com.galacticware.griddle.model.keybinder.AppSymbol.GO
import com.galacticware.griddle.model.keybinder.AppSymbol.MICROPHONE_CHAR
import com.galacticware.griddle.model.keybinder.AppSymbol.MOVE_END
import com.galacticware.griddle.model.keybinder.AppSymbol.MOVE_HOME
import com.galacticware.griddle.model.keybinder.AppSymbol.MOVE_PGDN
import com.galacticware.griddle.model.keybinder.AppSymbol.MOVE_PGUP
import com.galacticware.griddle.model.keybinder.AppSymbol.PASTE
import com.galacticware.griddle.model.keybinder.AppSymbol.REPEAT
import com.galacticware.griddle.model.keybinder.AppSymbol.RIGHT_ARROW
import com.galacticware.griddle.model.keybinder.AppSymbol.SELECT_ALL_TEXT
import com.galacticware.griddle.model.keybinder.AppSymbol.GLOBAL_SETTINGS
import com.galacticware.griddle.model.keybinder.AppSymbol.SHIFT
import com.galacticware.griddle.model.keybinder.AppSymbol.SWAP_HANDEDNESS
import com.galacticware.griddle.model.keybinder.AppSymbol.TAB_RIGHT
import com.galacticware.griddle.model.keybinder.AppSymbol.UNSHIFTED
import com.galacticware.griddle.model.keybinder.AppSymbol.UP_ARROW
import com.galacticware.griddle.model.keybinder.KeyBinder.Companion.bindGesture
import com.galacticware.griddle.model.keybinder.KeyBinder.Companion.changeModifier
import com.galacticware.griddle.model.keybinder.KeyBinder.Companion.changeUserSetting
import com.galacticware.griddle.model.keybinder.KeyBinder.Companion.pressKey
import com.galacticware.griddle.model.keybinder.KeyBinder.Companion.remappedSymbolLookup
import com.galacticware.griddle.model.keybinder.KeyBinder.Companion.switchLayer
import com.galacticware.griddle.model.keybinder.KeyBinder.Companion.switchScreens
import com.galacticware.griddle.model.keyboard.definition.designs.constant.IGNORE_SHIFT
import com.galacticware.griddle.model.layer.LayerKind
import com.galacticware.griddle.model.modifier.AppModifierKey.Companion.control
import com.galacticware.griddle.model.operation.implementation.noargs.accentchars.CycleAccentCharacters
import com.galacticware.griddle.model.operation.implementation.noargs.backspace.Backspace
import com.galacticware.griddle.model.operation.implementation.noargs.backspace.HotSwapControlBackspace
import com.galacticware.griddle.model.operation.implementation.noargs.changeinputmethod.ChangeInputMethod
import com.galacticware.griddle.model.operation.implementation.noargs.cursorcontrol.MoveEnd
import com.galacticware.griddle.model.operation.implementation.noargs.cursorcontrol.MoveHome
import com.galacticware.griddle.model.operation.implementation.noargs.cursorcontrol.MoveLeft
import com.galacticware.griddle.model.operation.implementation.noargs.cursorcontrol.MoveRight
import com.galacticware.griddle.model.operation.implementation.noargs.cursorcontrol.MoveWordLeft
import com.galacticware.griddle.model.operation.implementation.noargs.cursorcontrol.MoveWordRight
import com.galacticware.griddle.model.operation.implementation.noargs.cursorcontrol.SelectAll
import com.galacticware.griddle.model.operation.implementation.noargs.noop.NoOp
import com.galacticware.griddle.model.operation.implementation.noargs.repeat.Repeat
import com.galacticware.griddle.model.operation.implementation.noargs.simpleinput.SimpleInput
import com.galacticware.griddle.model.operation.implementation.noargs.speechtotext.SpeechToText
import com.galacticware.griddle.model.operation.implementation.noargs.swaphandedness.SwapHandedness
import com.galacticware.griddle.model.operation.implementation.someargs.changemodifier.base.ChangeModifierArgs.Companion.ForwardCycleAlt
import com.galacticware.griddle.model.operation.implementation.someargs.changemodifier.base.ChangeModifierArgs.Companion.ForwardCycleControl
import com.galacticware.griddle.model.operation.implementation.someargs.changemodifier.base.ChangeModifierArgs.Companion.ForwardCycleShift
import com.galacticware.griddle.model.operation.implementation.someargs.changemodifier.base.ChangeModifierArgs.Companion.ReleaseShift
import com.galacticware.griddle.model.operation.implementation.someargs.changemodifier.base.ChangeModifierArgs.Companion.ToggleAltRepeat
import com.galacticware.griddle.model.operation.implementation.someargs.changemodifier.base.ChangeModifierArgs.Companion.ToggleControlRepeat
import com.galacticware.griddle.model.operation.implementation.someargs.changemodifier.base.ChangeModifierArgs.Companion.ToggleShiftRepeat
import com.galacticware.griddle.model.operation.implementation.someargs.changeusersettings.ChangeUserSettingArgs.Companion.ToggleTurboMode
import com.galacticware.griddle.model.operation.implementation.someargs.presskey.PressEnterKey
import com.galacticware.griddle.model.operation.implementation.someargs.presskey.PressTab
import com.galacticware.griddle.model.operation.implementation.someargs.presskey.SendNewLineFeed
import com.galacticware.griddle.model.operation.implementation.someargs.presskey.SendTab
import com.galacticware.griddle.model.operation.implementation.someargs.switchscreens.SwitchScreenArgs
import com.galacticware.griddle.model.util.caseSensitive
import com.galacticware.griddle.model.util.reversedCase
import com.galacticware.griddle.model.util.triple

/**
 * These GestureButtonBuilders are positioned in the traditional MessagEase layout positions.
 */
// Define various `Triple`s of text that will be reused in multiple gestures.
val applyShiftLegends = Triple(SHIFT.value, CAPSLOCKED.value , UNSHIFTED.value)
val unApplyShiftLegends = Triple(" ", UNSHIFTED.value, UNSHIFTED.value)
val altLegends = triple(AppSymbol.ALT.value)
val controlLegends = triple(AppSymbol.CONTROL.value)

object GriddleButtonBuilders {
    val englishA by lazy {
        gestureButton(rowStart = 0, colStart = 0, rowSpan = 1, colSpan = 1,
            gestureSet = mutableSetOf(
                bindGesture(CLICK, SimpleInput, threeStrings = caseSensitive("a")),
                bindGesture(HOLD, SimpleInput, label = "1"),
                bindGesture(SWIPE_UP_LEFT, CycleAccentCharacters, AppSymbol.CYCLE_ACCENTED_CHARS),
                bindGesture(SWIPE_RIGHT, SimpleInput, threeStrings = caseSensitive("-", "÷", "÷")),
                bindGesture(BOOMERANG_RIGHT, SimpleInput, threeStrings = reversedCase("÷", "-", "-")),
                bindGesture(SWIPE_DOWN_LEFT, SimpleInput, threeStrings = caseSensitive("$")),
                bindGesture(BOOMERANG_DOWN_LEFT, SimpleInput, threeStrings = reversedCase("¢")),
                bindGesture(SWIPE_DOWN_RIGHT, SimpleInput, threeStrings = caseSensitive("v")),
                bindGesture(BOOMERANG_DOWN_RIGHT, SimpleInput, threeStrings = reversedCase("V")),
                bindGesture(CIRCLE_CLOCKWISE, SimpleInput, threeStrings = reversedCase("A")),
                bindGesture(CIRCLE_ANTI_CLOCKWISE, SimpleInput, threeStrings = reversedCase("A")),
            )
        )
    }

    val englishN by lazy {
        gestureButton(rowStart = 0, colStart = 1, rowSpan = 1, colSpan = 1,
            gestureSet = mutableSetOf(
                bindGesture(BOOMERANG_UP, SimpleInput, threeStrings = caseSensitive("ˇ")),
                bindGesture(CLICK, SimpleInput, threeStrings = caseSensitive("n")),
                bindGesture(HOLD, SimpleInput, threeStrings = triple("2")),
                bindGesture(SWIPE_UP_LEFT, SimpleInput, threeStrings = caseSensitive("`", "\\", "\\")),
                bindGesture(BOOMERANG_UP_LEFT, SimpleInput, threeStrings = caseSensitive("\\", "`", "`")),
                bindGesture(SWIPE_UP, SimpleInput, threeStrings = caseSensitive("^", "’", "’")),
                bindGesture(SWIPE_UP_RIGHT, SimpleInput, threeStrings = Triple("^", "’", "’")),
                bindGesture(SWIPE_RIGHT, SimpleInput, threeStrings = caseSensitive("!", "¡", "¡")),
                bindGesture(BOOMERANG_RIGHT, SimpleInput, threeStrings = caseSensitive("¡", "!", "!")),
                bindGesture(SWIPE_DOWN_RIGHT, SimpleInput, threeStrings = caseSensitive("/", "—", "—")),
                bindGesture(BOOMERANG_DOWN_RIGHT, SimpleInput, threeStrings = caseSensitive("—", "/", "/")),
                bindGesture(SWIPE_DOWN, SimpleInput, threeStrings = caseSensitive("l")),
                bindGesture(BOOMERANG_DOWN, SimpleInput, threeStrings = reversedCase("L")),
                bindGesture(SWIPE_DOWN_LEFT, SimpleInput, threeStrings = caseSensitive("/", "—", "—")),
                bindGesture(BOOMERANG_DOWN_LEFT, SimpleInput, threeStrings = caseSensitive("—", "/", "/")),
                bindGesture(SWIPE_LEFT, SimpleInput, threeStrings = caseSensitive("+", "×", "×")),
                bindGesture(BOOMERANG_LEFT, SimpleInput, threeStrings = caseSensitive("×", "+", "+")),
                bindGesture(CIRCLE_CLOCKWISE, SimpleInput, threeStrings = reversedCase("n")),
                bindGesture(CIRCLE_ANTI_CLOCKWISE, SimpleInput, threeStrings = reversedCase("n")),
            )
        )
    }


    val englishI by lazy {
        gestureButton(rowStart = 0, colStart = 2, rowSpan = 1, colSpan = 1,
            gestureSet = mutableSetOf(
                bindGesture(CLICK, SimpleInput, threeStrings = caseSensitive("i")),
                bindGesture(SWIPE_DOWN_RIGHT, SimpleInput, threeStrings = caseSensitive("€", "£", "£")),
                bindGesture(BOOMERANG_DOWN_RIGHT, SimpleInput, threeStrings = caseSensitive("£", "€", "€")),
                bindGesture(SWIPE_DOWN, SimpleInput, threeStrings = caseSensitive("=", "±", "±")),
                bindGesture(BOOMERANG_DOWN, SimpleInput, threeStrings = caseSensitive("±", "=", "=")),
                bindGesture(SWIPE_DOWN_LEFT, SimpleInput, threeStrings = caseSensitive("x")),
                bindGesture(BOOMERANG_DOWN_LEFT, SimpleInput, threeStrings = reversedCase("X")),
                bindGesture(SWIPE_LEFT, SimpleInput, threeStrings = caseSensitive("?", "¿", "¿")),
                bindGesture(BOOMERANG_LEFT, SimpleInput, threeStrings = caseSensitive("¿", "?", "?")),
                bindGesture(CIRCLE_CLOCKWISE, SimpleInput, threeStrings = reversedCase("I")),
                bindGesture(CIRCLE_ANTI_CLOCKWISE, SimpleInput, threeStrings = reversedCase("I")),
                bindGesture(HOLD, SimpleInput, threeStrings = triple("3")),
                pressKey(SWIPE_UP, KEYCODE_DPAD_UP, appSymbol = UP_ARROW),
                pressKey(BOOMERANG_UP, KEYCODE_PAGE_UP, appSymbol = MOVE_PGUP),
            )
        )
    }

    val englishH by lazy {
        gestureButton(rowStart = 1, colStart = 0, rowSpan = 1, colSpan = 1,
            gestureSet = mutableSetOf(
                changeModifier(SWIPE_UP, ForwardCycleShift),
                changeModifier(SWIPE_DOWN, ReleaseShift),
                bindGesture(SWIPE_UP_LEFT, SimpleInput, threeStrings = Triple("{", "}", "}")),
                bindGesture(BOOMERANG_UP_LEFT, SimpleInput, threeStrings = Triple("}", "{", "{")),
                changeModifier(BOOMERANG_UP, ToggleShiftRepeat),
                bindGesture(SWIPE_UP_RIGHT, SimpleInput, threeStrings = Triple("%", "‰", "‰")),
                bindGesture(BOOMERANG_UP_RIGHT, SimpleInput, threeStrings = Triple("‰", "%", "%")),
                bindGesture(SWIPE_RIGHT, SimpleInput, threeStrings = caseSensitive("k")),
                bindGesture(BOOMERANG_RIGHT, SimpleInput, threeStrings = reversedCase("K")),
                bindGesture(SWIPE_DOWN_RIGHT, SimpleInput, threeStrings = Triple("_", "¬", "¬")),
                bindGesture(BOOMERANG_DOWN_RIGHT, SimpleInput, threeStrings = Triple("¬", "_", "_")),
                bindGesture(SWIPE_DOWN_LEFT, SimpleInput, threeStrings = Triple("[", "]", "]")),
                bindGesture(BOOMERANG_DOWN_LEFT, SimpleInput, threeStrings = Triple("]", "[", "[")),
                bindGesture(SWIPE_LEFT, SimpleInput, threeStrings = Triple("(", ")", ")")),
                bindGesture(BOOMERANG_LEFT, SimpleInput, threeStrings = Triple(")", "(", "(")),
                bindGesture(CIRCLE_CLOCKWISE, SimpleInput, threeStrings = reversedCase("H")),
                bindGesture(CIRCLE_ANTI_CLOCKWISE, SimpleInput, threeStrings = reversedCase("H")),
                bindGesture(HOLD, SimpleInput, threeStrings = caseSensitive("4")),
                bindGesture(CLICK, SimpleInput, threeStrings = caseSensitive("h")),
            )
        )
    }

    val englishO by lazy {
        gestureButton(rowStart = 1, colStart = 1, rowSpan = 1, colSpan = 1,
            gestureSet = mutableSetOf(
                bindGesture(CLICK, SimpleInput, threeStrings = caseSensitive("o")),
                bindGesture(SWIPE_UP_LEFT, SimpleInput, threeStrings = caseSensitive("q")),
                bindGesture(BOOMERANG_UP_LEFT, SimpleInput, threeStrings = reversedCase("q")),
                bindGesture(SWIPE_UP, SimpleInput, threeStrings = caseSensitive("u")),
                bindGesture(BOOMERANG_UP, SimpleInput, threeStrings = reversedCase("u")),
                bindGesture(SWIPE_UP_RIGHT, SimpleInput, threeStrings = caseSensitive("p")),
                bindGesture(BOOMERANG_UP_RIGHT, SimpleInput, threeStrings = reversedCase("P")),
                bindGesture(SWIPE_RIGHT, SimpleInput, threeStrings = caseSensitive("b")),
                bindGesture(BOOMERANG_RIGHT, SimpleInput, threeStrings = reversedCase("B")),
                bindGesture(SWIPE_DOWN_RIGHT, SimpleInput, threeStrings = caseSensitive("j")),
                bindGesture(BOOMERANG_DOWN_RIGHT, SimpleInput, threeStrings = reversedCase("J")),
                bindGesture(SWIPE_DOWN, SimpleInput, threeStrings = caseSensitive("d")),
                bindGesture(BOOMERANG_DOWN, SimpleInput, threeStrings = reversedCase("D")),
                bindGesture(SWIPE_DOWN_LEFT, SimpleInput, threeStrings = caseSensitive("g")),
                bindGesture(BOOMERANG_DOWN_LEFT, SimpleInput, threeStrings = reversedCase("G")),
                bindGesture(SWIPE_LEFT, SimpleInput, threeStrings = caseSensitive("c")),
                bindGesture(BOOMERANG_LEFT, SimpleInput, threeStrings = reversedCase("C")),
                bindGesture(CIRCLE_ANTI_CLOCKWISE, SimpleInput, threeStrings = reversedCase("O")),
                bindGesture(CIRCLE_CLOCKWISE, SimpleInput, threeStrings = reversedCase("O")),
                bindGesture(HOLD, SimpleInput, threeStrings = reversedCase("5")),
            )
        )
    }

    val englishR by lazy {
        gestureButton(rowStart = 1, colStart = 2, rowSpan = 1, colSpan = 1,
            gestureSet = mutableSetOf(
                changeModifier(SWIPE_UP, ForwardCycleShift),
                changeModifier(SWIPE_DOWN, ReleaseShift),
                bindGesture(SWIPE_UP_LEFT, SimpleInput, threeStrings = caseSensitive("|", "\\", "\\")),
                bindGesture(BOOMERANG_UP_LEFT, SimpleInput, threeStrings = caseSensitive("\\", "|", "|")),
                changeModifier(BOOMERANG_UP, ToggleShiftRepeat),
                bindGesture(SWIPE_UP_RIGHT, SimpleInput, threeStrings = caseSensitive("}", "{", "{")),
                bindGesture(BOOMERANG_UP_RIGHT, SimpleInput, threeStrings = caseSensitive("{", "}", "}")),
                bindGesture(SWIPE_RIGHT, SimpleInput, threeStrings = caseSensitive(")", "(", "(")),
                bindGesture(BOOMERANG_RIGHT, SimpleInput, threeStrings = caseSensitive("(", ")", ")")),
                bindGesture(SWIPE_DOWN_RIGHT, SimpleInput, threeStrings = caseSensitive("]", "[", "[")),
                bindGesture(BOOMERANG_DOWN_RIGHT, SimpleInput, threeStrings = caseSensitive("[", "]", "]")),
                bindGesture(BOOMERANG_DOWN, SimpleInput, threeStrings = caseSensitive("—")),
                bindGesture(SWIPE_DOWN_LEFT, SimpleInput, label = "@"),
                bindGesture(BOOMERANG_DOWN_LEFT, SimpleInput, threeStrings = Triple("ª", "@", "@")),
                bindGesture(SWIPE_LEFT, SimpleInput, threeStrings = caseSensitive("m")),
                bindGesture(BOOMERANG_LEFT, SimpleInput, threeStrings = reversedCase("M")),
                bindGesture(CIRCLE_CLOCKWISE, SimpleInput, threeStrings = reversedCase("R")),
                bindGesture(CIRCLE_ANTI_CLOCKWISE, SimpleInput, threeStrings = reversedCase("R")),
                bindGesture(CLICK, SimpleInput, threeStrings = caseSensitive("r")),
                bindGesture(HOLD, SimpleInput, threeStrings = reversedCase("6")),
            )
        )
    }

    val englishT by lazy {
        gestureButton(rowStart = 2, colStart = 0, rowSpan = 1, colSpan = 1,
            gestureSet = mutableSetOf(
                bindGesture(CLICK, SimpleInput, threeStrings = caseSensitive("t")),
                bindGesture(HOLD, SimpleInput, threeStrings = reversedCase("7")),
                bindGesture(SWIPE_UP_LEFT, SimpleInput, threeStrings = caseSensitive("~")),
                bindGesture(SWIPE_UP, SimpleInput, threeStrings = Triple("¨", "¨", "¨")),
                bindGesture(BOOMERANG_UP, SimpleInput, threeStrings = Triple("˝", "¨", "¨")),
                bindGesture(SWIPE_UP_RIGHT, SimpleInput, threeStrings = caseSensitive("y")),
                bindGesture(BOOMERANG_UP_RIGHT, SimpleInput, threeStrings = reversedCase("Y")),
                bindGesture(SWIPE_RIGHT, SimpleInput, threeStrings = Triple("*", "†", "†")),
                bindGesture(BOOMERANG_RIGHT, SimpleInput, threeStrings = Triple("†", "*", "*")),
                bindGesture(SWIPE_LEFT, SimpleInput, threeStrings = Triple("<", ">", ">")),
                bindGesture(BOOMERANG_LEFT, SimpleInput, threeStrings = Triple(">", "<", "<")),
                bindGesture(SWIPE_DOWN_RIGHT, SendTab, threeStrings = triple(TAB_RIGHT)),
                bindGesture(BOOMERANG_DOWN_RIGHT, PressTab, threeStrings = triple(TAB_RIGHT)),
                bindGesture(CIRCLE_CLOCKWISE, SimpleInput, threeStrings = reversedCase("T")),
                bindGesture(CIRCLE_ANTI_CLOCKWISE, SimpleInput, threeStrings = reversedCase("T")),
            )
        )
    }

    val englishE by lazy {
        gestureButton(rowStart = 2, colStart = 1, rowSpan = 1, colSpan = 1,
            gestureSet = mutableSetOf(
                bindGesture(SWIPE_UP_LEFT, SimpleInput, threeStrings = caseSensitive("\"")),
                bindGesture(BOOMERANG_UP_LEFT, SimpleInput, threeStrings = caseSensitive(" ")),
                bindGesture(SWIPE_UP, SimpleInput, threeStrings = caseSensitive("w")),
                bindGesture(BOOMERANG_UP, SimpleInput, threeStrings = reversedCase("W")),
                bindGesture(SWIPE_UP_RIGHT, SimpleInput, threeStrings = caseSensitive("\'")),
                bindGesture(BOOMERANG_UP_RIGHT, SimpleInput, threeStrings = caseSensitive("\'")),
                bindGesture(SWIPE_RIGHT, SimpleInput, threeStrings = caseSensitive("z")),
                bindGesture(BOOMERANG_RIGHT, SimpleInput, threeStrings = reversedCase("Z")),
                bindGesture(SWIPE_DOWN_RIGHT, SimpleInput, threeStrings = caseSensitive(":")),
                bindGesture(BOOMERANG_DOWN_RIGHT, SimpleInput, threeStrings = caseSensitive(",")),
                bindGesture(SWIPE_DOWN, SimpleInput, threeStrings = caseSensitive(".", "…", "…")),
                bindGesture(BOOMERANG_DOWN, SimpleInput, threeStrings = caseSensitive("…", ".", ".")),
                bindGesture(SWIPE_DOWN_LEFT, SimpleInput, threeStrings = caseSensitive(",")),
                bindGesture(BOOMERANG_DOWN_LEFT, SimpleInput, threeStrings = caseSensitive(",")),
                bindGesture(SWIPE_LEFT, SimpleInput, threeStrings = caseSensitive(",")),
                bindGesture(BOOMERANG_LEFT, SimpleInput, threeStrings = caseSensitive(",")),
                bindGesture(CIRCLE_CLOCKWISE, SimpleInput, threeStrings = reversedCase("E")),
                bindGesture(CIRCLE_ANTI_CLOCKWISE, SimpleInput, threeStrings = reversedCase("E")),
                bindGesture(CLICK, SimpleInput, threeStrings = caseSensitive("e")),
                bindGesture(HOLD, SimpleInput, label = "8"),
            )
        )
    }

    val englishS by lazy {
        gestureButton(rowStart = 2, colStart = 2, rowSpan = 1, colSpan = 1,
            gestureSet = mutableSetOf(
                bindGesture(CLICK, SimpleInput, threeStrings = caseSensitive("s")),
                bindGesture(SWIPE_UP_LEFT, SimpleInput, threeStrings = caseSensitive("f")),
                bindGesture(BOOMERANG_UP_LEFT, SimpleInput, threeStrings = reversedCase("F")),
                bindGesture(SWIPE_UP, SimpleInput, threeStrings = caseSensitive("&")),
                bindGesture(SWIPE_RIGHT, SimpleInput, threeStrings = caseSensitive(">")),
                bindGesture(SWIPE_UP_RIGHT, SimpleInput, threeStrings = caseSensitive("°")),
                bindGesture(SWIPE_DOWN_LEFT, SimpleInput, threeStrings = caseSensitive(";")),
                bindGesture(SWIPE_DOWN, SendNewLineFeed, appSymbol = AppSymbol.NEW_LINE),
                bindGesture(BOOMERANG_DOWN_LEFT, SimpleInput, threeStrings = caseSensitive(";")),
                bindGesture(SWIPE_LEFT, SimpleInput, threeStrings = caseSensitive("#")),
                bindGesture(BOOMERANG_LEFT, SimpleInput, threeStrings = caseSensitive(" ")),
                bindGesture(CIRCLE_CLOCKWISE, SimpleInput, threeStrings = reversedCase("S")),
                bindGesture(CIRCLE_ANTI_CLOCKWISE, SimpleInput, threeStrings = reversedCase("S")),
                bindGesture(HOLD, SimpleInput, threeStrings = caseSensitive("9")),
                bindGesture(CLICK, SimpleInput, threeStrings = caseSensitive("s")),
                bindGesture(HOLD, SimpleInput, threeStrings = reversedCase("9")),
                pressKey(SWIPE_DOWN, KEYCODE_DPAD_DOWN, appSymbol = DOWN_ARROW),
                pressKey(BOOMERANG_DOWN, KEYCODE_PAGE_DOWN, appSymbol = MOVE_PGDN),
            )
        )
    }
    val settingsButton by lazy {
        gestureButton(
            rowStart = 0, colStart = 3, rowSpan = 1, colSpan = 1,
            gestureSet = mutableSetOf(
                bindGesture(CLICK, NoOp, appSymbol = GLOBAL_SETTINGS, isIndicator = true),
                switchScreens(HOLD, SwitchScreenArgs.OpenBaseSettings),
                pressKey(SWIPE_LEFT, KEYCODE_Z, setOf(control), IGNORE_SHIFT, AppSymbol.UNDO),
                pressKey(SWIPE_RIGHT, KEYCODE_Y, setOf(control), IGNORE_SHIFT, AppSymbol.REDO),
                changeUserSetting(SWIPE_UP, ToggleTurboMode),
                switchLayer(CIRCLE_ANTI_CLOCKWISE, LayerKind.UNIFIED_ALPHA_NUMERIC),
                switchLayer(CIRCLE_CLOCKWISE, LayerKind.UNIFIED_ALPHA_NUMERIC),
            ),
        )
    }
    val backspace by lazy {
        gestureButton(
            rowStart = 2, colStart = 3, rowSpan = 1, colSpan = 1,
            gestureSet = mutableSetOf(
                bindGesture(HOLD, Backspace),
                remappedSymbolLookup(CLICK, BACKSPACE).apply { swapAssignment = bindGesture(CLICK, Repeat, appSymbol = REPEAT).assignment },
                pressKey(SWIPE_LEFT, KEYCODE_DEL),
                pressKey(SWIPE_UP_LEFT, KEYCODE_DEL),
                pressKey(SWIPE_DOWN_LEFT, KEYCODE_DEL),
                bindGesture(BOOMERANG_LEFT, HotSwapControlBackspace),
                pressKey(SWIPE_RIGHT, KEYCODE_FORWARD_DEL),
                pressKey(SWIPE_UP_RIGHT, KEYCODE_FORWARD_DEL),
                pressKey(SWIPE_DOWN_RIGHT, KEYCODE_FORWARD_DEL),
                pressKey(BOOMERANG_RIGHT, KEYCODE_FORWARD_DEL, setOf(control))
            ),
        )
    }
    val AlphabeticLayerToggle by lazy {
        gestureButton(
            rowStart = 1, colStart = 3, rowSpan = 1, colSpan = 1,
            gestureSet = mutableSetOf(
                remappedSymbolLookup(SWIPE_UP, COPY),
                remappedSymbolLookup(SWIPE_LEFT, CUT),
                switchScreens(SWIPE_UP_LEFT, SwitchScreenArgs.OpenTextReplacementEditor),
                remappedSymbolLookup(SWIPE_DOWN, PASTE),
                bindGesture(SWIPE_DOWN_LEFT, ChangeInputMethod, appSymbol = CHOOSE_DIFFERENT_INPUT_METHOD),
                switchLayer(CLICK, LayerKind.ALPHA),
                switchLayer(HOLD, LayerKind.NUMERIC),
                switchScreens(SWIPE_UP_RIGHT, SwitchScreenArgs.OpenEmoji),
                bindGesture(SWIPE_RIGHT, SwapHandedness, appSymbol = SWAP_HANDEDNESS),
                pressKey(CIRCLE_ANTI_CLOCKWISE, KEYCODE_A, setOf(control)),
                pressKey(CIRCLE_CLOCKWISE, KEYCODE_A, setOf(control)),
                bindGesture(SWIPE_DOWN_RIGHT, SpeechToText, appSymbol = MICROPHONE_CHAR),
                switchScreens(BOOMERANG_DOWN, SwitchScreenArgs.OpenClipboard),
            ),
        )
    }
    val NumericLayerToggle by lazy {
        gestureButton(
            rowStart = 1, colStart = 3, rowSpan = 1, colSpan = 1,
            gestureSet = mutableSetOf(
                remappedSymbolLookup(SWIPE_UP, COPY),
                remappedSymbolLookup(SWIPE_LEFT, CUT),
                remappedSymbolLookup(SWIPE_DOWN, PASTE),
                bindGesture(SWIPE_DOWN_LEFT, ChangeInputMethod, appSymbol = CHOOSE_DIFFERENT_INPUT_METHOD),
                switchScreens(SWIPE_UP_LEFT, SwitchScreenArgs.OpenTextReplacementEditor),
                switchScreens(SWIPE_UP_RIGHT, SwitchScreenArgs.OpenEmoji),
                bindGesture(SWIPE_RIGHT, SwapHandedness, appSymbol = SWAP_HANDEDNESS),
                switchLayer(CLICK, LayerKind.NUMERO_SYMBOLIC),
                switchLayer(HOLD, LayerKind.NUMERIC),
                bindGesture(CIRCLE_ANTI_CLOCKWISE, SelectAll, appSymbol = SELECT_ALL_TEXT),
                bindGesture(CIRCLE_CLOCKWISE, SelectAll, appSymbol = SELECT_ALL_TEXT),
                bindGesture(SWIPE_DOWN_RIGHT, SpeechToText, appSymbol = MICROPHONE_CHAR),
                switchScreens(BOOMERANG_DOWN, SwitchScreenArgs.OpenClipboard),
            ),
        )
    }
    val enter by lazy {
        gestureButton(
            rowStart = 3, colStart = 3, rowSpan = 1, colSpan = 1,
            gestureSet = mutableSetOf(
                bindGesture(CLICK, PressEnterKey, appSymbol = GO),
                changeModifier(SWIPE_UP_LEFT, ForwardCycleAlt),
                changeModifier(BOOMERANG_UP_LEFT, ToggleAltRepeat),
                changeModifier(SWIPE_UP_RIGHT, ForwardCycleControl),
                changeModifier(BOOMERANG_UP_RIGHT, ToggleControlRepeat),
            ),
        )
    }
    val space2u by lazy {
        gestureButton(
            rowStart = 3, colStart = 1, rowSpan = 1, colSpan = 2,
            gestureSet = mutableSetOf(
                pressKey(CLICK, KEYCODE_SPACE, respectShift = IGNORE_SHIFT),
                switchLayer(SWIPE_DOWN_LEFT, LayerKind.FUNCTION),
                bindGesture(HOLD, SimpleInput, threeStrings = reversedCase("0")),
                bindGesture(SWIPE_LEFT, MoveLeft, appSymbol = AppSymbol.LEFT_ARROW),
                bindGesture(BOOMERANG_LEFT, MoveWordLeft),
                bindGesture(SWIPE_RIGHT, MoveRight, appSymbol = RIGHT_ARROW),
                bindGesture(BOOMERANG_RIGHT, MoveWordRight),
                bindGesture(CIRCLE_CLOCKWISE, MoveEnd, threeStrings = triple(MOVE_END)),
                bindGesture(CIRCLE_ANTI_CLOCKWISE, MoveHome, threeStrings = triple(MOVE_HOME)),            ),
        )
    }
    val space3u by lazy {
        space2u.reposition(colStart = 0, colSpan = 3)
    }
    val repeat by lazy {
        gestureButton(
            rowStart = 2, colStart = 3, rowSpan = 1, colSpan = 1,
            gestureSet = mutableSetOf(
                bindGesture(CLICK, Repeat, appSymbol = REPEAT),
            )
        )
    }
    val numericSpaceLeft by lazy {
        space2u
            .withoutGesture { g: Gesture -> g.currentText == AppSymbol.GLOBAL_SETTINGS.value }
            .reposition(0, 3, 1, 1)
    }
    val numericSpaceRight by lazy {
        numericSpaceLeft
            .reposition(colStart = 2)
    }
}