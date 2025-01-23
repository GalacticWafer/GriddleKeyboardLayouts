package com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared

import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_A
import android.view.KeyEvent.KEYCODE_DEL
import android.view.KeyEvent.KEYCODE_DPAD_LEFT
import android.view.KeyEvent.KEYCODE_DPAD_RIGHT
import android.view.KeyEvent.KEYCODE_DPAD_UP
import android.view.KeyEvent.KEYCODE_FORWARD_DEL
import android.view.KeyEvent.KEYCODE_PAGE_DOWN
import android.view.KeyEvent.KEYCODE_PAGE_UP
import androidx.compose.ui.graphics.Color
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
import com.galacticware.griddle.domain.button.GestureButtonBuilder.Companion.gestureButton
import com.galacticware.griddle.domain.keybinder.AppSymbol
import com.galacticware.griddle.domain.keybinder.AppSymbol.ALPHA_LAYER
import com.galacticware.griddle.domain.keybinder.AppSymbol.ALT
import com.galacticware.griddle.domain.keybinder.AppSymbol.BACKSPACE
import com.galacticware.griddle.domain.keybinder.AppSymbol.CAPSLOCKED
import com.galacticware.griddle.domain.keybinder.AppSymbol.CONTROL
import com.galacticware.griddle.domain.keybinder.AppSymbol.COPY
import com.galacticware.griddle.domain.keybinder.AppSymbol.CUT
import com.galacticware.griddle.domain.keybinder.AppSymbol.DOWN_ARROW
import com.galacticware.griddle.domain.keybinder.AppSymbol.FUNCTION_LAYER
import com.galacticware.griddle.domain.keybinder.AppSymbol.GO
import com.galacticware.griddle.domain.keybinder.AppSymbol.MACRO
import com.galacticware.griddle.domain.keybinder.AppSymbol.MICROPHONE_CHAR
import com.galacticware.griddle.domain.keybinder.AppSymbol.MOVE_END
import com.galacticware.griddle.domain.keybinder.AppSymbol.MOVE_HOME
import com.galacticware.griddle.domain.keybinder.AppSymbol.MOVE_PGDN
import com.galacticware.griddle.domain.keybinder.AppSymbol.MOVE_PGUP
import com.galacticware.griddle.domain.keybinder.AppSymbol.NUMERIC_LAYER
import com.galacticware.griddle.domain.keybinder.AppSymbol.PASTE
import com.galacticware.griddle.domain.keybinder.AppSymbol.RIGHT_ARROW
import com.galacticware.griddle.domain.keybinder.AppSymbol.SELECT_ALL_TEXT
import com.galacticware.griddle.domain.keybinder.AppSymbol.SHIFTED
import com.galacticware.griddle.domain.keybinder.AppSymbol.SWAP_HANDEDNESS
import com.galacticware.griddle.domain.keybinder.AppSymbol.TOGGLE_CLIPBOARD
import com.galacticware.griddle.domain.keybinder.AppSymbol.TOGGLE_SETTINGS
import com.galacticware.griddle.domain.keybinder.AppSymbol.UNIFIED_ALPHA_NUMERIC_LAYER
import com.galacticware.griddle.domain.keybinder.AppSymbol.UNSHIFTED
import com.galacticware.griddle.domain.keybinder.AppSymbol.UP_ARROW
import com.galacticware.griddle.domain.keybinder.KeyBinder.Companion.gesture
import com.galacticware.griddle.domain.modifier.AppModifierKey.Companion.control
import com.galacticware.griddle.domain.modifier.ModifierKeyKind
import com.galacticware.griddle.domain.modifier.ModifierTheme.Companion.modifierThemes
import com.galacticware.griddle.domain.modifier.ModifierThemeSet
import com.galacticware.griddle.domain.operation.MoveDown
import com.galacticware.griddle.domain.operation.ApplyAlt
import com.galacticware.griddle.domain.operation.ApplyControl
import com.galacticware.griddle.domain.operation.MoveEnd
import com.galacticware.griddle.domain.operation.MoveHome
import com.galacticware.griddle.domain.operation.MoveLeft
import com.galacticware.griddle.domain.operation.MoveRight
import com.galacticware.griddle.domain.operation.MoveUp
import com.galacticware.griddle.domain.operation.MoveWordLeft
import com.galacticware.griddle.domain.operation.MoveWordRight
import com.galacticware.griddle.domain.operation.NoOp
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.OpenMacroEditor
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.OpenMultiClipboard
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english.OpenSettings
import com.galacticware.griddle.domain.operation.PressEnterKey
import com.galacticware.griddle.domain.operation.pressKey
import com.galacticware.griddle.domain.operation.pressSpace
import com.galacticware.griddle.domain.operation.RemappedSymbolLookup
import com.galacticware.griddle.domain.operation.SelectAll
import com.galacticware.griddle.domain.operation.SimpleInput
import com.galacticware.griddle.domain.operation.spamBackspace
import com.galacticware.griddle.domain.operation.StartRecognizingSpeech
import com.galacticware.griddle.domain.operation.SwapHandedness
import com.galacticware.griddle.domain.operation.swappable
import com.galacticware.griddle.domain.operation.SwitchLayer
import com.galacticware.griddle.domain.operation.ToggleAltLock
import com.galacticware.griddle.domain.operation.ToggleControlLock
import com.galacticware.griddle.domain.operation.toggleTurboMode
import com.galacticware.griddle.domain.util.caseSensitive
import com.galacticware.griddle.domain.util.reversedCase
import com.galacticware.griddle.domain.util.triple

val button_0_0 get() = gestureButton(rowStart = 0, colStart = 0, rowSpan = 1, colSpan = 1)
val button_0_1 get() = gestureButton(rowStart = 0, colStart = 1, rowSpan = 1, colSpan = 1)
val button_0_2 get() = gestureButton(rowStart = 0, colStart = 2, rowSpan = 1, colSpan = 1, isPeripheral = true)
val button_1_0 get() = gestureButton(rowStart = 1, colStart = 0, rowSpan = 1, colSpan = 1)
val button_1_1 get() = gestureButton(rowStart = 1, colStart = 1, rowSpan = 1, colSpan = 1)
val button_1_2 get() = gestureButton(rowStart = 1, colStart = 2, rowSpan = 1, colSpan = 1)
val button_2_0 get() = gestureButton(rowStart = 2, colStart = 0, rowSpan = 1, colSpan = 1)
val button_2_1 get() = gestureButton(rowStart = 2, colStart = 1, rowSpan = 1, colSpan = 1)
val button_2_2 get() = gestureButton(rowStart = 2, colStart = 2, rowSpan = 1, colSpan = 1)

val shiftIndicatorColorTheme = ModifierThemeSet
    .forModifierWithDefaultTheme(SHIFTED.value, UNSHIFTED.value, UNSHIFTED.value, kind = ModifierKeyKind.SHIFT)
    .withTextColorSet(Color.White, Color.Yellow, Color.Red)
    .withTransparentBackground()
val unShiftIndicator = ModifierThemeSet
    .forModifierWithDefaultTheme("", UNSHIFTED.value, UNSHIFTED.value, kind = ModifierKeyKind.SHIFT)
    .withTextColorSet(Color.White)
    .withTransparentBackground()

val cursorControlButton = gestureButton(
    rowStart = 0, colStart = 3, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(CLICK, NoOp, appSymbol = TOGGLE_SETTINGS, isIndicator = true),
        gesture(HOLD, OpenSettings),
        gesture(SWIPE_LEFT, pressKey(KeyEvent.KEYCODE_Z, control), threeStrings = triple(AppSymbol.UNDO.name)),
        gesture(SWIPE_RIGHT, pressKey(KeyEvent.KEYCODE_Y, control), threeStrings = triple(AppSymbol.REDO.name)),
        gesture(SWIPE_UP, toggleTurboMode),
        gesture(CIRCLE_ANTI_CLOCKWISE, SwitchLayer, appSymbol = UNIFIED_ALPHA_NUMERIC_LAYER),
        gesture(CIRCLE_CLOCKWISE, SwitchLayer, appSymbol = UNIFIED_ALPHA_NUMERIC_LAYER),
    ),
)

// you can define a triple of text that will be re-used in multiple gestures
val shiftLegends = Triple(SHIFTED.value, CAPSLOCKED.value , UNSHIFTED.value)
val unShiftLegends = Triple(" ", UNSHIFTED.value, UNSHIFTED.value)


val cycleEmojisLeft = gestureButton(
    rowStart = 3, colStart = 0, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(CLICK, /* cycleEmojiPage */NoOp, threeStrings = caseSensitive("⬅\uFE0F"))
    ),
)

val cycleEmojisRight = cycleEmojisLeft
    .withPosition(rowStart = 3, colStart=2, rowSpan = 1, colSpan = 1,)

val multiKey: Gesture =  gesture(CLICK, swappable(
    pressKey(KEYCODE_DEL) to triple(BACKSPACE),
//    repeatPreviousOperation to withSymbol(AppSymbol.REPEAT),
), threeStrings = triple(BACKSPACE))

val backspace = gestureButton(
    rowStart = 2, colStart = 3, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(HOLD, /*swapGesture(multiKey)*/spamBackspace),
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

val AlphabeticLayerToggle = gestureButton(
    rowStart = 1, colStart = 3, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(SWIPE_UP, RemappedSymbolLookup, appSymbol = COPY),
        gesture(SWIPE_LEFT, RemappedSymbolLookup, appSymbol = CUT),
        gesture(SWIPE_UP_LEFT, OpenMacroEditor, appSymbol = MACRO, ),
        gesture(SWIPE_DOWN, RemappedSymbolLookup, appSymbol = PASTE),
        gesture(CLICK, SwitchLayer, appSymbol = ALPHA_LAYER),
        gesture(SWIPE_RIGHT, SwapHandedness, appSymbol = SWAP_HANDEDNESS),
        gesture(CIRCLE_ANTI_CLOCKWISE, pressKey(KEYCODE_A, control)),
        gesture(CIRCLE_CLOCKWISE, pressKey(KEYCODE_A, control)),
        gesture(SWIPE_DOWN_RIGHT, StartRecognizingSpeech, appSymbol = MICROPHONE_CHAR),
        gesture(BOOMERANG_DOWN, OpenMultiClipboard, appSymbol = TOGGLE_CLIPBOARD),
    ),
)

val NumericLayerToggle = gestureButton(
    rowStart = 1, colStart = 3, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(SWIPE_UP, RemappedSymbolLookup, appSymbol = COPY),
        gesture(SWIPE_LEFT, RemappedSymbolLookup, appSymbol = CUT),
        gesture(SWIPE_DOWN, RemappedSymbolLookup, appSymbol = PASTE),
        gesture(SWIPE_UP_LEFT, OpenMacroEditor, appSymbol = MACRO, ),
        gesture(SWIPE_RIGHT, SwapHandedness, appSymbol = SWAP_HANDEDNESS),
        gesture(CLICK, SwitchLayer, appSymbol = NUMERIC_LAYER),
        gesture(CIRCLE_ANTI_CLOCKWISE, SelectAll, appSymbol = SELECT_ALL_TEXT),
        gesture(CIRCLE_CLOCKWISE, SelectAll, appSymbol = SELECT_ALL_TEXT),
        gesture(SWIPE_DOWN_RIGHT, StartRecognizingSpeech, appSymbol = MICROPHONE_CHAR),
        gesture(BOOMERANG_DOWN, OpenMultiClipboard, appSymbol = TOGGLE_CLIPBOARD),
    ),
)

val enter = gestureButton(
    rowStart = 3, colStart = 3, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(CLICK, PressEnterKey, appSymbol = GO),
        gesture(SWIPE_UP_LEFT, ApplyAlt, modifierThemeSet = modifierThemes(ALT.value, kind = ModifierKeyKind.ALT), isIndicator = true),
        gesture(BOOMERANG_UP_LEFT, ToggleAltLock),
        gesture(SWIPE_UP_RIGHT, ApplyControl, modifierThemeSet = modifierThemes(CONTROL.value, kind = ModifierKeyKind.CONTROL), isIndicator = true),
        gesture(BOOMERANG_UP_RIGHT, ToggleControlLock),
    ),
)

val space = gestureButton(
    rowStart = 3, colStart = 0, rowSpan = 1, colSpan = 3,
    gestureSet = mutableSetOf(
        gesture(CLICK, pressSpace),
        gesture(SWIPE_DOWN_LEFT, SwitchLayer, appSymbol = FUNCTION_LAYER),
        //gesture(BOOMERANG_DOWN_RIGHT, /* clearLogs */noOp),
        gesture(HOLD, SimpleInput, threeStrings = reversedCase("0")),
        gesture(SWIPE_LEFT, MoveLeft, appSymbol = AppSymbol.LEFT_ARROW),
        gesture(BOOMERANG_LEFT, MoveWordLeft),
        gesture(SWIPE_RIGHT, MoveRight, appSymbol = RIGHT_ARROW),
        gesture(BOOMERANG_RIGHT, MoveWordRight),
        gesture(SWIPE_UP, MoveUp, threeStrings = triple(UP_ARROW)),
        gesture(BOOMERANG_UP, pressKey(KEYCODE_PAGE_UP), appSymbol = MOVE_PGUP),
        gesture(SWIPE_UP_RIGHT, pressKey(KEYCODE_DPAD_UP)),
        gesture(BOOMERANG_UP_RIGHT, pressKey(KEYCODE_DPAD_UP, control)),
        gesture(SWIPE_DOWN_RIGHT, pressKey(KEYCODE_DPAD_RIGHT)),
        gesture(BOOMERANG_RIGHT, MoveWordRight),
        gesture(SWIPE_UP_LEFT, pressKey(KEYCODE_DPAD_LEFT)),
        gesture(SWIPE_DOWN_LEFT, pressKey(KEYCODE_DPAD_LEFT)),
        gesture(BOOMERANG_LEFT, MoveWordLeft),
        gesture(SWIPE_DOWN, MoveDown, threeStrings = triple(DOWN_ARROW)),
        gesture(BOOMERANG_DOWN, pressKey(KEYCODE_PAGE_DOWN), appSymbol = MOVE_PGDN),
        gesture(CIRCLE_CLOCKWISE, MoveEnd, threeStrings = triple(MOVE_END)),
        gesture(CIRCLE_ANTI_CLOCKWISE, MoveHome, threeStrings = triple(MOVE_HOME)),
    ),
)

val numericSpaceLeft = space
    .withoutGesture { g: Gesture -> g.currentText == AppSymbol.SETTINGS.value }
    .withPosition(0, 3, 1, 1)

val numericSpaceRight = numericSpaceLeft
    .withPosition(colStart = 2)


