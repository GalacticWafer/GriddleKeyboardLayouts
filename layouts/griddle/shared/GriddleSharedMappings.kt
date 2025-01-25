package com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared

import android.view.KeyEvent.KEYCODE_A
import android.view.KeyEvent.KEYCODE_DEL
import android.view.KeyEvent.KEYCODE_DPAD_LEFT
import android.view.KeyEvent.KEYCODE_DPAD_RIGHT
import android.view.KeyEvent.KEYCODE_DPAD_UP
import android.view.KeyEvent.KEYCODE_FORWARD_DEL
import android.view.KeyEvent.KEYCODE_PAGE_DOWN
import android.view.KeyEvent.KEYCODE_PAGE_UP
import android.view.KeyEvent.KEYCODE_SPACE
import android.view.KeyEvent.KEYCODE_Y
import android.view.KeyEvent.KEYCODE_Z
import androidx.compose.ui.graphics.Color
import com.galacticware.griddle.domain.button.GestureButtonBuilder.Companion.gestureButton
import com.galacticware.griddle.domain.gesture.Gesture
import com.galacticware.griddle.domain.gesture.GestureType.BOOMERANG_DOWN
import com.galacticware.griddle.domain.gesture.GestureType.BOOMERANG_LEFT
import com.galacticware.griddle.domain.gesture.GestureType.BOOMERANG_RIGHT
import com.galacticware.griddle.domain.gesture.GestureType.BOOMERANG_UP
import com.galacticware.griddle.domain.gesture.GestureType.BOOMERANG_UP_LEFT
import com.galacticware.griddle.domain.gesture.GestureType.BOOMERANG_UP_RIGHT
import com.galacticware.griddle.domain.gesture.GestureType.CIRCLE_ANTI_CLOCKWISE
import com.galacticware.griddle.domain.gesture.GestureType.CIRCLE_CLOCKWISE
import com.galacticware.griddle.domain.gesture.GestureType.CLICK
import com.galacticware.griddle.domain.gesture.GestureType.HOLD
import com.galacticware.griddle.domain.gesture.GestureType.SWIPE_DOWN
import com.galacticware.griddle.domain.gesture.GestureType.SWIPE_DOWN_LEFT
import com.galacticware.griddle.domain.gesture.GestureType.SWIPE_DOWN_RIGHT
import com.galacticware.griddle.domain.gesture.GestureType.SWIPE_LEFT
import com.galacticware.griddle.domain.gesture.GestureType.SWIPE_RIGHT
import com.galacticware.griddle.domain.gesture.GestureType.SWIPE_UP
import com.galacticware.griddle.domain.gesture.GestureType.SWIPE_UP_LEFT
import com.galacticware.griddle.domain.gesture.GestureType.SWIPE_UP_RIGHT
import com.galacticware.griddle.domain.keybinder.AppSymbol
import com.galacticware.griddle.domain.keybinder.AppSymbol.ALT
import com.galacticware.griddle.domain.keybinder.AppSymbol.BACKSPACE
import com.galacticware.griddle.domain.keybinder.AppSymbol.CAPSLOCKED
import com.galacticware.griddle.domain.keybinder.AppSymbol.CONTROL
import com.galacticware.griddle.domain.keybinder.AppSymbol.COPY
import com.galacticware.griddle.domain.keybinder.AppSymbol.CUT
import com.galacticware.griddle.domain.keybinder.AppSymbol.DOWN_ARROW
import com.galacticware.griddle.domain.keybinder.AppSymbol.GO
import com.galacticware.griddle.domain.keybinder.AppSymbol.MICROPHONE_CHAR
import com.galacticware.griddle.domain.keybinder.AppSymbol.MOVE_END
import com.galacticware.griddle.domain.keybinder.AppSymbol.MOVE_HOME
import com.galacticware.griddle.domain.keybinder.AppSymbol.MOVE_PGDN
import com.galacticware.griddle.domain.keybinder.AppSymbol.MOVE_PGUP
import com.galacticware.griddle.domain.keybinder.AppSymbol.PASTE
import com.galacticware.griddle.domain.keybinder.AppSymbol.RIGHT_ARROW
import com.galacticware.griddle.domain.keybinder.AppSymbol.SELECT_ALL_TEXT
import com.galacticware.griddle.domain.keybinder.AppSymbol.SHIFTED
import com.galacticware.griddle.domain.keybinder.AppSymbol.SWAP_HANDEDNESS
import com.galacticware.griddle.domain.keybinder.AppSymbol.TOGGLE_SETTINGS
import com.galacticware.griddle.domain.keybinder.AppSymbol.UNSHIFTED
import com.galacticware.griddle.domain.keybinder.AppSymbol.UP_ARROW
import com.galacticware.griddle.domain.keybinder.KeyBinder.Companion.bindGesture
import com.galacticware.griddle.domain.keybinder.KeyBinder.Companion.changeUserSetting
import com.galacticware.griddle.domain.keybinder.KeyBinder.Companion.pressKey
import com.galacticware.griddle.domain.keybinder.KeyBinder.Companion.remappedSymbolLookup
import com.galacticware.griddle.domain.keybinder.KeyBinder.Companion.switchLayer
import com.galacticware.griddle.domain.keybinder.KeyBinder.Companion.switchScreens
import com.galacticware.griddle.domain.layer.LayerKind
import com.galacticware.griddle.domain.modifier.AppModifierKey.Companion.control
import com.galacticware.griddle.domain.modifier.ModifierKeyKind
import com.galacticware.griddle.domain.modifier.ModifierTheme.Companion.modifierThemes
import com.galacticware.griddle.domain.modifier.ModifierThemeSet
import com.galacticware.griddle.domain.operation.ApplyAlt
import com.galacticware.griddle.domain.operation.ApplyControl
import com.galacticware.griddle.domain.operation.MoveEnd
import com.galacticware.griddle.domain.operation.MoveHome
import com.galacticware.griddle.domain.operation.MoveLeft
import com.galacticware.griddle.domain.operation.MoveRight
import com.galacticware.griddle.domain.operation.MoveWordLeft
import com.galacticware.griddle.domain.operation.MoveWordRight
import com.galacticware.griddle.domain.operation.NoOp
import com.galacticware.griddle.domain.operation.PressEnterKey
import com.galacticware.griddle.domain.operation.SelectAll
import com.galacticware.griddle.domain.operation.SimpleInput
import com.galacticware.griddle.domain.operation.SpamBackspace
import com.galacticware.griddle.domain.operation.StartRecognizingSpeech
import com.galacticware.griddle.domain.operation.SwapHandedness
import com.galacticware.griddle.domain.operation.ToggleAltLock
import com.galacticware.griddle.domain.operation.ToggleControlLock
import com.galacticware.griddle.domain.operation.swappable
import com.galacticware.griddle.domain.usercontolled.GriddleSetting.TURBO_MODE_CHOICE
import com.galacticware.griddle.domain.usercontolled.IncrementalAdjustmentType.TOGGLE
import com.galacticware.griddle.domain.util.caseSensitive
import com.galacticware.griddle.domain.util.reversedCase
import com.galacticware.griddle.domain.util.triple
import com.galacticware.griddle.view.composable.screen.SwitchableScreen.SWITCH_TO_BASE_SETTINGS
import com.galacticware.griddle.view.composable.screen.SwitchableScreen.SWITCH_TO_CLIPBOARD
import com.galacticware.griddle.view.composable.screen.SwitchableScreen.SWITCH_TO_MACRO_EDITOR

/**
 * These are blank GestureButtonBuilders positioned in the traditional MessagEase layout positions.
 * You can use the builder methods to add appropriate gestures and themes.
 */
val button_0_0 get() = gestureButton(rowStart = 0, colStart = 0, rowSpan = 1, colSpan = 1)
val button_0_1 get() = gestureButton(rowStart = 0, colStart = 1, rowSpan = 1, colSpan = 1)
val button_0_2 get() = gestureButton(rowStart = 0, colStart = 2, rowSpan = 1, colSpan = 1, isPeripheral = true)
val button_1_0 get() = gestureButton(rowStart = 1, colStart = 0, rowSpan = 1, colSpan = 1)
val button_1_1 get() = gestureButton(rowStart = 1, colStart = 1, rowSpan = 1, colSpan = 1)
val button_1_2 get() = gestureButton(rowStart = 1, colStart = 2, rowSpan = 1, colSpan = 1)
val button_2_0 get() = gestureButton(rowStart = 2, colStart = 0, rowSpan = 1, colSpan = 1)
val button_2_1 get() = gestureButton(rowStart = 2, colStart = 1, rowSpan = 1, colSpan = 1)
val button_2_2 get() = gestureButton(rowStart = 2, colStart = 2, rowSpan = 1, colSpan = 1)

val shiftIndicatorTheme = ModifierThemeSet
    .forModifierWithDefaultTheme(SHIFTED.value, UNSHIFTED.value, UNSHIFTED.value, kind = ModifierKeyKind.SHIFT)
    .withTextColorSet(Color.White, Color.Yellow, Color.Red)
    .withTransparentBackground()

val unShiftIndicatorTheme = ModifierThemeSet
    .forModifierWithDefaultTheme("", UNSHIFTED.value, UNSHIFTED.value, kind = ModifierKeyKind.SHIFT)
    .withTextColorSet(Color.White)
    .withTransparentBackground()

private const val IGNORE_SHIFT = false
private const val RESPECT_SHIFT = true

val cursorControlButton = gestureButton(
    rowStart = 0, colStart = 3, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        bindGesture(CLICK, NoOp, remappedSymbol = TOGGLE_SETTINGS, isIndicator = true),
        switchScreens(HOLD, SWITCH_TO_BASE_SETTINGS),
        pressKey(SWIPE_LEFT, KEYCODE_Z, setOf(control), IGNORE_SHIFT, AppSymbol.UNDO),
        pressKey(SWIPE_RIGHT, KEYCODE_Y, setOf(control), IGNORE_SHIFT, AppSymbol.REDO),
        changeUserSetting(SWIPE_UP, TURBO_MODE_CHOICE, TOGGLE),
        switchLayer(CIRCLE_ANTI_CLOCKWISE, LayerKind.UNIFIED_ALPHA_NUMERIC),
        switchLayer(CIRCLE_CLOCKWISE, LayerKind.UNIFIED_ALPHA_NUMERIC),
    ),
)

// you can define a triple of text that will be re-used in multiple gestures
val shiftLegends = Triple(SHIFTED.value, CAPSLOCKED.value , UNSHIFTED.value)
val unShiftLegends = Triple(" ", UNSHIFTED.value, UNSHIFTED.value)


val cycleEmojisLeft = gestureButton(
    rowStart = 3, colStart = 0, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        bindGesture(CLICK, /* cycleEmojiPage */NoOp, threeStrings = caseSensitive("⬅\uFE0F"))
    ),
)

val cycleEmojisRight = cycleEmojisLeft
    .withPosition(rowStart = 3, colStart=2, rowSpan = 1, colSpan = 1,)

val multiKey: Gesture =  bindGesture(CLICK, swappable(
    pressKey(CLICK, KEYCODE_DEL, appSymbol = BACKSPACE),
//    repeatPreviousOperation to withSymbol(AppSymbol.REPEAT),
))

val backspace = gestureButton(
    rowStart = 2, colStart = 3, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        bindGesture(HOLD, /*swapGesture(multiKey)*/SpamBackspace),
        pressKey(CLICK, KEYCODE_DEL, appSymbol = BACKSPACE)/*multiKey*/,
        pressKey(SWIPE_LEFT, KEYCODE_DEL),
        pressKey(SWIPE_UP_LEFT, KEYCODE_DEL),
        pressKey(SWIPE_DOWN_LEFT, KEYCODE_DEL),
        pressKey(BOOMERANG_LEFT, KEYCODE_DEL, setOf(control)),
        pressKey(SWIPE_RIGHT, KEYCODE_FORWARD_DEL),
        pressKey(SWIPE_UP_RIGHT, KEYCODE_FORWARD_DEL),
        pressKey(SWIPE_DOWN_RIGHT, KEYCODE_FORWARD_DEL),
        pressKey(BOOMERANG_RIGHT, KEYCODE_FORWARD_DEL, setOf(control))
    ),
)

val rightBackspace = backspace
    .withPosition(rowStart = 2, colStart = 3, rowSpan = 1, colSpan = 1,)

val AlphabeticLayerToggle = gestureButton(
    rowStart = 1, colStart = 3, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        remappedSymbolLookup(SWIPE_UP, COPY),
        remappedSymbolLookup(SWIPE_LEFT, CUT),
        switchScreens(SWIPE_UP_LEFT, SWITCH_TO_MACRO_EDITOR),
        remappedSymbolLookup(SWIPE_DOWN, PASTE),
        switchLayer(CLICK, LayerKind.ALPHA),
        switchLayer(HOLD, LayerKind.NUMERIC),
        bindGesture(SWIPE_RIGHT, SwapHandedness, remappedSymbol = SWAP_HANDEDNESS),
        pressKey(CIRCLE_ANTI_CLOCKWISE, KEYCODE_A, setOf(control)),
        pressKey(CIRCLE_CLOCKWISE, KEYCODE_A, setOf(control)),
        bindGesture(SWIPE_DOWN_RIGHT, StartRecognizingSpeech, remappedSymbol = MICROPHONE_CHAR),
        switchScreens(BOOMERANG_DOWN, SWITCH_TO_CLIPBOARD),
    ),
)

val NumericLayerToggle = gestureButton(
    rowStart = 1, colStart = 3, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        remappedSymbolLookup(SWIPE_UP, COPY),
        remappedSymbolLookup(SWIPE_LEFT, CUT),
        remappedSymbolLookup(SWIPE_DOWN, PASTE),
        switchScreens(SWIPE_UP_LEFT, SWITCH_TO_MACRO_EDITOR),
        bindGesture(SWIPE_RIGHT, SwapHandedness, remappedSymbol = SWAP_HANDEDNESS),
        switchLayer(CLICK, LayerKind.NUMERO_SYMBOLIC),
        switchLayer(HOLD, LayerKind.NUMERIC),
        bindGesture(CIRCLE_ANTI_CLOCKWISE, SelectAll, remappedSymbol = SELECT_ALL_TEXT),
        bindGesture(CIRCLE_CLOCKWISE, SelectAll, remappedSymbol = SELECT_ALL_TEXT),
        bindGesture(SWIPE_DOWN_RIGHT, StartRecognizingSpeech, remappedSymbol = MICROPHONE_CHAR),
        switchScreens(BOOMERANG_DOWN, SWITCH_TO_CLIPBOARD),
    ),
)

val enter = gestureButton(
    rowStart = 3, colStart = 3, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        bindGesture(CLICK, PressEnterKey, remappedSymbol = GO),
        bindGesture(SWIPE_UP_LEFT, ApplyAlt, modifierThemeSet = modifierThemes(ALT.value, kind = ModifierKeyKind.ALT), isIndicator = true),
        bindGesture(BOOMERANG_UP_LEFT, ToggleAltLock),
        bindGesture(SWIPE_UP_RIGHT, ApplyControl, modifierThemeSet = modifierThemes(CONTROL.value, kind = ModifierKeyKind.CONTROL), isIndicator = true),
        bindGesture(BOOMERANG_UP_RIGHT, ToggleControlLock),
    ),
)

val space = gestureButton(
    rowStart = 3, colStart = 0, rowSpan = 1, colSpan = 3,
    gestureSet = mutableSetOf(
        pressKey(CLICK, KEYCODE_SPACE, respectShift = IGNORE_SHIFT),
        switchLayer(SWIPE_DOWN_LEFT, LayerKind.FUNCTION),
        //gesture(BOOMERANG_DOWN_RIGHT, /* clearLogs */noOp),
        bindGesture(HOLD, SimpleInput, threeStrings = reversedCase("0")),
        bindGesture(SWIPE_LEFT, MoveLeft, remappedSymbol = AppSymbol.LEFT_ARROW),
        bindGesture(BOOMERANG_LEFT, MoveWordLeft),
        bindGesture(SWIPE_RIGHT, MoveRight, remappedSymbol = RIGHT_ARROW),
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
        pressKey(SWIPE_DOWN, KEYCODE_DPAD_UP, appSymbol = DOWN_ARROW),
        pressKey(BOOMERANG_DOWN, KEYCODE_PAGE_DOWN, appSymbol = MOVE_PGDN),
        bindGesture(CIRCLE_CLOCKWISE, MoveEnd, threeStrings = triple(MOVE_END)),
        bindGesture(CIRCLE_ANTI_CLOCKWISE, MoveHome, threeStrings = triple(MOVE_HOME)),
    ),
)

val numericSpaceLeft = space
    .withoutGesture { g: Gesture -> g.currentText == AppSymbol.SETTINGS.value }
    .withPosition(0, 3, 1, 1)

val numericSpaceRight = numericSpaceLeft
    .withPosition(colStart = 2)


