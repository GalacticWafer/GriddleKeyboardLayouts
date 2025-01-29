package com.galacticware.griddle.model.keyboard.definition.designs.griddle.shared.button

import android.view.KeyEvent.KEYCODE_A
import android.view.KeyEvent.KEYCODE_DEL
import android.view.KeyEvent.KEYCODE_DPAD_DOWN
import android.view.KeyEvent.KEYCODE_DPAD_LEFT
import android.view.KeyEvent.KEYCODE_DPAD_RIGHT
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
import com.galacticware.griddle.model.keybinder.AppSymbol.RIGHT_ARROW
import com.galacticware.griddle.model.keybinder.AppSymbol.SELECT_ALL_TEXT
import com.galacticware.griddle.model.keybinder.AppSymbol.SHIFT
import com.galacticware.griddle.model.keybinder.AppSymbol.SWAP_HANDEDNESS
import com.galacticware.griddle.model.keybinder.AppSymbol.TOGGLE_SETTINGS
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
import com.galacticware.griddle.model.operation.implementation.noargs.backspace.Backspace
import com.galacticware.griddle.model.operation.implementation.noargs.changeinputmethod.ChangeInputMethod
import com.galacticware.griddle.model.operation.implementation.noargs.cursorcontrol.DeleteWordLeftGesture
import com.galacticware.griddle.model.operation.implementation.noargs.cursorcontrol.MoveEnd
import com.galacticware.griddle.model.operation.implementation.noargs.cursorcontrol.MoveHome
import com.galacticware.griddle.model.operation.implementation.noargs.cursorcontrol.MoveLeft
import com.galacticware.griddle.model.operation.implementation.noargs.cursorcontrol.MoveRight
import com.galacticware.griddle.model.operation.implementation.noargs.cursorcontrol.MoveWordLeft
import com.galacticware.griddle.model.operation.implementation.noargs.cursorcontrol.MoveWordRight
import com.galacticware.griddle.model.operation.implementation.noargs.cursorcontrol.SelectAll
import com.galacticware.griddle.model.operation.implementation.noargs.noop.NoOp
import com.galacticware.griddle.model.operation.implementation.noargs.simpleinput.SimpleInput
import com.galacticware.griddle.model.operation.implementation.noargs.speechtotext.SpeechToText
import com.galacticware.griddle.model.operation.implementation.noargs.swaphandedness.SwapHandedness
import com.galacticware.griddle.model.operation.implementation.someargs.changemodifier.base.ChangeModifierArgs.Companion.ForwardCycleAlt
import com.galacticware.griddle.model.operation.implementation.someargs.changemodifier.base.ChangeModifierArgs.Companion.ForwardCycleControl
import com.galacticware.griddle.model.operation.implementation.someargs.changemodifier.base.ChangeModifierArgs.Companion.ToggleAltRepeat
import com.galacticware.griddle.model.operation.implementation.someargs.changemodifier.base.ChangeModifierArgs.Companion.ToggleControlRepeat
import com.galacticware.griddle.model.operation.implementation.someargs.changeusersettings.ChangeUserSettingArgs.Companion.ToggleTurboMode
import com.galacticware.griddle.model.operation.implementation.someargs.presskey.PressEnterKey
import com.galacticware.griddle.model.operation.implementation.someargs.switchscreens.SwitchScreenArgs
import com.galacticware.griddle.model.util.reversedCase
import com.galacticware.griddle.model.util.triple

/**
 * These are blank GestureButtonBuilders positioned in the traditional MessagEase layout positions.
 * You can use the builder methods to add appropriate gestures and themes.
 */
val button_0_0 by lazy { gestureButton(rowStart = 0, colStart = 0, rowSpan = 1, colSpan = 1) }
val button_0_1 by lazy { gestureButton(rowStart = 0, colStart = 1, rowSpan = 1, colSpan = 1) }
val button_0_2 by lazy { gestureButton(rowStart = 0, colStart = 2, rowSpan = 1, colSpan = 1, isPeripheral = true) }
val button_1_0 by lazy { gestureButton(rowStart = 1, colStart = 0, rowSpan = 1, colSpan = 1) }
val button_1_1 by lazy { gestureButton(rowStart = 1, colStart = 1, rowSpan = 1, colSpan = 1) }
val button_1_2 by lazy { gestureButton(rowStart = 1, colStart = 2, rowSpan = 1, colSpan = 1) }
val button_2_0 by lazy { gestureButton(rowStart = 2, colStart = 0, rowSpan = 1, colSpan = 1) }
val button_2_1 by lazy { gestureButton(rowStart = 2, colStart = 1, rowSpan = 1, colSpan = 1) }
val button_2_2 by lazy { gestureButton(rowStart = 2, colStart = 2, rowSpan = 1, colSpan = 1) }

val cursorControlButton by lazy {
    gestureButton(
        rowStart = 0, colStart = 3, rowSpan = 1, colSpan = 1,
        gestureSet = mutableSetOf(
            bindGesture(CLICK, NoOp, appSymbol = TOGGLE_SETTINGS, isIndicator = true),
            switchScreens(HOLD, SwitchScreenArgs.OpenBaseSettings),
            pressKey(SWIPE_LEFT, KEYCODE_Z, setOf(control), IGNORE_SHIFT, AppSymbol.UNDO),
            pressKey(SWIPE_RIGHT, KEYCODE_Y, setOf(control), IGNORE_SHIFT, AppSymbol.REDO),
            changeUserSetting(SWIPE_UP, ToggleTurboMode),
            switchLayer(CIRCLE_ANTI_CLOCKWISE, LayerKind.UNIFIED_ALPHA_NUMERIC),
            switchLayer(CIRCLE_CLOCKWISE, LayerKind.UNIFIED_ALPHA_NUMERIC),
        ),
    )
}

// you can define a triple of text that will be reused in multiple gestures
val applyShiftLegends = Triple(SHIFT.value, CAPSLOCKED.value , UNSHIFTED.value)
val unApplyShiftLegends = Triple(" ", UNSHIFTED.value, UNSHIFTED.value)
val altLegends = triple(AppSymbol.ALT.value)
val controlLegends = triple(AppSymbol.CONTROL.value)

val backspace by lazy {
    gestureButton(
        rowStart = 2, colStart = 3, rowSpan = 1, colSpan = 1,
        gestureSet = mutableSetOf(
            bindGesture(HOLD, Backspace),
            remappedSymbolLookup(CLICK, BACKSPACE),
            pressKey(SWIPE_LEFT, KEYCODE_DEL),
            pressKey(SWIPE_UP_LEFT, KEYCODE_DEL),
            pressKey(SWIPE_DOWN_LEFT, KEYCODE_DEL),
            bindGesture(BOOMERANG_LEFT, Backspace, modifiers = setOf(control)),
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
            bindGesture(
                SWIPE_DOWN_LEFT,
                ChangeInputMethod,
                appSymbol = CHOOSE_DIFFERENT_INPUT_METHOD
            ),
            switchLayer(CLICK, LayerKind.ALPHA),
            switchLayer(HOLD, LayerKind.NUMERIC),
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
            bindGesture(
                SWIPE_DOWN_LEFT,
                ChangeInputMethod,
                appSymbol = CHOOSE_DIFFERENT_INPUT_METHOD
            ),
            switchScreens(SWIPE_UP_LEFT, SwitchScreenArgs.OpenTextReplacementEditor),
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

val space by lazy {
    gestureButton(
        rowStart = 3, colStart = 0, rowSpan = 1, colSpan = 3,
        gestureSet = mutableSetOf(
            pressKey(CLICK, KEYCODE_SPACE, respectShift = IGNORE_SHIFT),
            switchLayer(SWIPE_DOWN_LEFT, LayerKind.FUNCTION),
            bindGesture(HOLD, SimpleInput, threeStrings = reversedCase("0")),
            bindGesture(SWIPE_LEFT, MoveLeft, appSymbol = AppSymbol.LEFT_ARROW),
            bindGesture(BOOMERANG_LEFT, MoveWordLeft),
            bindGesture(SWIPE_RIGHT, MoveRight, appSymbol = RIGHT_ARROW),
            bindGesture(BOOMERANG_RIGHT, MoveWordRight),
            pressKey(SWIPE_UP, KEYCODE_DPAD_UP, appSymbol = UP_ARROW),
            pressKey(BOOMERANG_UP, KEYCODE_PAGE_UP, appSymbol = MOVE_PGUP),
            pressKey(SWIPE_UP_RIGHT, KEYCODE_DPAD_UP),
            pressKey(BOOMERANG_UP_RIGHT, KEYCODE_DPAD_UP, modifiers = setOf(control)),
            pressKey(SWIPE_DOWN_RIGHT, KEYCODE_DPAD_RIGHT),
            bindGesture(BOOMERANG_RIGHT, MoveWordRight),
            pressKey(SWIPE_UP_LEFT, KEYCODE_DPAD_LEFT),
            pressKey(SWIPE_DOWN_LEFT, KEYCODE_DPAD_LEFT),
            bindGesture(BOOMERANG_LEFT, MoveWordLeft),
            pressKey(SWIPE_DOWN, KEYCODE_DPAD_DOWN, appSymbol = DOWN_ARROW),
            pressKey(BOOMERANG_DOWN, KEYCODE_PAGE_DOWN, appSymbol = MOVE_PGDN),
            bindGesture(CIRCLE_CLOCKWISE, MoveEnd, threeStrings = triple(MOVE_END)),
            bindGesture(CIRCLE_ANTI_CLOCKWISE, MoveHome, threeStrings = triple(MOVE_HOME)),
        ),
    )
}

val numericSpaceLeft by lazy {
    space
        .withoutGesture { g: Gesture -> g.currentText == AppSymbol.SETTINGS.value }
        .reposition(0, 3, 1, 1)
}

val numericSpaceRight by lazy {
    numericSpaceLeft
        .reposition(colStart = 2)
}


