package org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared

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
import org.galacticware.griddle.domain.button.GestureButtonBuilder.Companion.gestureButton
import org.galacticware.griddle.domain.gesture.Gesture
import org.galacticware.griddle.domain.gesture.GestureType.BOOMERANG_DOWN
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
import org.galacticware.griddle.domain.keybinder.AppSymbol
import org.galacticware.griddle.domain.keybinder.AppSymbol.ALPHA_LAYER
import org.galacticware.griddle.domain.keybinder.AppSymbol.ALT
import org.galacticware.griddle.domain.keybinder.AppSymbol.BACKSPACE
import org.galacticware.griddle.domain.keybinder.AppSymbol.CAPSLOCKED
import org.galacticware.griddle.domain.keybinder.AppSymbol.CONTROL
import org.galacticware.griddle.domain.keybinder.AppSymbol.COPY
import org.galacticware.griddle.domain.keybinder.AppSymbol.CUT
import org.galacticware.griddle.domain.keybinder.AppSymbol.DOWN_ARROW
import org.galacticware.griddle.domain.keybinder.AppSymbol.FUNCTION_LAYER
import org.galacticware.griddle.domain.keybinder.AppSymbol.GO
import org.galacticware.griddle.domain.keybinder.AppSymbol.MACRO
import org.galacticware.griddle.domain.keybinder.AppSymbol.MICROPHONE_CHAR
import org.galacticware.griddle.domain.keybinder.AppSymbol.MOVE_END
import org.galacticware.griddle.domain.keybinder.AppSymbol.MOVE_HOME
import org.galacticware.griddle.domain.keybinder.AppSymbol.MOVE_PGDN
import org.galacticware.griddle.domain.keybinder.AppSymbol.MOVE_PGUP
import org.galacticware.griddle.domain.keybinder.AppSymbol.PASTE
import org.galacticware.griddle.domain.keybinder.AppSymbol.RIGHT_ARROW
import org.galacticware.griddle.domain.keybinder.AppSymbol.SELECT_ALL_TEXT
import org.galacticware.griddle.domain.keybinder.AppSymbol.SHIFTED
import org.galacticware.griddle.domain.keybinder.AppSymbol.SWAP_HANDEDNESS
import org.galacticware.griddle.domain.keybinder.AppSymbol.TOGGLE_CLIPBOARD
import org.galacticware.griddle.domain.keybinder.AppSymbol.TOGGLE_SETTINGS
import org.galacticware.griddle.domain.keybinder.AppSymbol.UNIFIED_ALPHA_NUMERIC_LAYER
import org.galacticware.griddle.domain.keybinder.AppSymbol.UNSHIFTED
import org.galacticware.griddle.domain.keybinder.AppSymbol.UP_ARROW
import org.galacticware.griddle.domain.keybinder.KeyBinder.Companion.gesture
import org.galacticware.griddle.domain.modifier.AppModifierKey.Companion.control
import org.galacticware.griddle.domain.modifier.ModifierKeyKind
import org.galacticware.griddle.domain.modifier.Theme.Companion.modifierThemes
import org.galacticware.griddle.domain.modifier.ThemeTriplet
import org.galacticware.griddle.domain.operation.Copy
import org.galacticware.griddle.domain.operation.Cut
import org.galacticware.griddle.domain.operation.DeleteWordLeft
import org.galacticware.griddle.domain.operation.DeleteWordRight
import org.galacticware.griddle.domain.operation.DpadLeft
import org.galacticware.griddle.domain.operation.DpadRight
import org.galacticware.griddle.domain.operation.GoToSettingsMenu
import org.galacticware.griddle.domain.operation.MoveEnd
import org.galacticware.griddle.domain.operation.MoveHome
import org.galacticware.griddle.domain.operation.MoveWordLeft
import org.galacticware.griddle.domain.operation.MoveWordRight
import org.galacticware.griddle.domain.operation.OpenTextReplacerEditor
import org.galacticware.griddle.domain.operation.OpenMultiClipboard
import org.galacticware.griddle.domain.operation.Paste
import org.galacticware.griddle.domain.operation.SelectAllToClipboard
import org.galacticware.griddle.domain.operation.Undo
import org.galacticware.griddle.domain.operation.ApplyAlt
import org.galacticware.griddle.domain.operation.ApplyControl
import org.galacticware.griddle.domain.operation.arrowDown
import org.galacticware.griddle.domain.operation.arrowUp
import org.galacticware.griddle.domain.operation.noOp
import org.galacticware.griddle.domain.operation.pressEnterKey
import org.galacticware.griddle.domain.operation.pressKey
import org.galacticware.griddle.domain.operation.pressSpace
import org.galacticware.griddle.domain.operation.simpleInput
import org.galacticware.griddle.domain.operation.spamBackspace
import org.galacticware.griddle.domain.operation.startRecognizingSpeech
import org.galacticware.griddle.domain.operation.SwapHandedness
import org.galacticware.griddle.domain.operation.swappable
import org.galacticware.griddle.domain.operation.switchLayer
import org.galacticware.griddle.domain.operation.ToggleAltLock
import org.galacticware.griddle.domain.operation.ToggleControlLock
import org.galacticware.griddle.domain.operation.toggleTurboMode
import org.galacticware.griddle.domain.util.reversedCase
import org.galacticware.griddle.domain.util.triple

val button_0_0 get() = gestureButton(rowStart = 0, colStart = 0, rowSpan = 1, colSpan = 1)
val button_0_1 get() = gestureButton(rowStart = 0, colStart = 1, rowSpan = 1, colSpan = 1)
val button_0_2 get() = gestureButton(rowStart = 0, colStart = 2, rowSpan = 1, colSpan = 1, isPeripheral = true)
val button_1_0 get() = gestureButton(rowStart = 1, colStart = 0, rowSpan = 1, colSpan = 1)
val button_1_1 get() = gestureButton(rowStart = 1, colStart = 1, rowSpan = 1, colSpan = 1)
val button_1_2 get() = gestureButton(rowStart = 1, colStart = 2, rowSpan = 1, colSpan = 1)
val button_2_0 get() = gestureButton(rowStart = 2, colStart = 0, rowSpan = 1, colSpan = 1)
val button_2_1 get() = gestureButton(rowStart = 2, colStart = 1, rowSpan = 1, colSpan = 1)
val button_2_2 get() = gestureButton(rowStart = 2, colStart = 2, rowSpan = 1, colSpan = 1)

val shiftIndicatorColorTheme = ThemeTriplet
    .forModifierWithDefaultTheme(SHIFTED.text, UNSHIFTED.text, UNSHIFTED.text, kind = ModifierKeyKind.SHIFT)
    .withTextColorSet(Color.White, Color.Yellow, Color.Red)
    .withTransparentBackground()
val unShiftIndicator = ThemeTriplet
    .forModifierWithDefaultTheme("", UNSHIFTED.text, UNSHIFTED.text, kind = ModifierKeyKind.SHIFT)
    .withTextColorSet(Color.White)
    .withTransparentBackground()

val cursorControlButton = gestureButton(
    rowStart = 0, colStart = 3, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(CLICK, noOp, appSymbol = TOGGLE_SETTINGS, isIndicator = true),
        gesture(HOLD, GoToSettingsMenu, appSymbol = TOGGLE_SETTINGS),
        gesture(SWIPE_LEFT, Undo, threeStrings = triple("UNDO")),
        gesture(SWIPE_RIGHT, pressKey(KeyEvent.KEYCODE_Y, control), threeStrings = triple("REDO")),
        gesture(SWIPE_UP, toggleTurboMode),
        gesture(CIRCLE_ANTI_CLOCKWISE, switchLayer, appSymbol = UNIFIED_ALPHA_NUMERIC_LAYER),
        gesture(CIRCLE_CLOCKWISE, switchLayer, appSymbol = UNIFIED_ALPHA_NUMERIC_LAYER),
    ),
)

// you can define a triple of text that will be re-used in multiple gestures
val shiftLegends = Triple(SHIFTED.text, CAPSLOCKED.text, UNSHIFTED.text)
val unShiftLegends = Triple(" ", UNSHIFTED.text, UNSHIFTED.text)

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
        gesture(BOOMERANG_LEFT, DeleteWordLeft),
        gesture(SWIPE_RIGHT, pressKey(KEYCODE_FORWARD_DEL)),
        gesture(SWIPE_UP_RIGHT, pressKey(KEYCODE_FORWARD_DEL)),
        gesture(SWIPE_DOWN_RIGHT, pressKey(KEYCODE_FORWARD_DEL)),
        gesture(BOOMERANG_RIGHT, DeleteWordRight),
    ),
)

val rightBackspace = backspace
    .withPosition(rowStart = 2, colStart = 3, rowSpan = 1, colSpan = 1,)

val AlphabeticLayerToggle = gestureButton(
    rowStart = 1, colStart = 3, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(SWIPE_UP, Copy, appSymbol = COPY),
        gesture(SWIPE_LEFT, Cut, appSymbol = CUT),
        gesture(SWIPE_UP_LEFT, OpenTextReplacerEditor, appSymbol = MACRO, ),
        gesture(SWIPE_DOWN, Paste, appSymbol = PASTE),
        gesture(CLICK, switchLayer, appSymbol = ALPHA_LAYER),
        gesture(SWIPE_RIGHT, SwapHandedness, appSymbol = SWAP_HANDEDNESS),
        gesture(CIRCLE_ANTI_CLOCKWISE, pressKey(KEYCODE_A, control)),
        gesture(CIRCLE_CLOCKWISE, pressKey(KEYCODE_A, control)),
        gesture(SWIPE_DOWN_RIGHT, startRecognizingSpeech, appSymbol = MICROPHONE_CHAR),
        gesture(BOOMERANG_DOWN, OpenMultiClipboard, appSymbol = TOGGLE_CLIPBOARD),
    ),
)

val NumericLayerToggle = gestureButton(
    rowStart = 1, colStart = 3, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(SWIPE_UP, Copy, appSymbol = COPY),
        gesture(SWIPE_LEFT, Cut, appSymbol = CUT),
        gesture(SWIPE_DOWN, Paste, appSymbol = PASTE),
        gesture(SWIPE_UP_LEFT, OpenTextReplacerEditor, appSymbol = MACRO, ),
        gesture(SWIPE_RIGHT, SwapHandedness, appSymbol = SWAP_HANDEDNESS),
        gesture(CLICK, switchLayer, appSymbol = AppSymbol.NUMERIC_LAYER),
        gesture(HOLD, switchLayer, appSymbol = AppSymbol.NUMPAD_LAYER),
        gesture(CIRCLE_ANTI_CLOCKWISE, SelectAllToClipboard, appSymbol = SELECT_ALL_TEXT),
        gesture(CIRCLE_CLOCKWISE, SelectAllToClipboard, appSymbol = SELECT_ALL_TEXT),
        gesture(SWIPE_DOWN_RIGHT, startRecognizingSpeech, appSymbol = MICROPHONE_CHAR),
        gesture(BOOMERANG_DOWN, OpenMultiClipboard, appSymbol = TOGGLE_CLIPBOARD),
    ),
)

val enter = gestureButton(
    rowStart = 3, colStart = 3, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(CLICK, pressEnterKey, appSymbol = GO),
        gesture(SWIPE_UP_LEFT, ApplyAlt, themeTriplet = modifierThemes(ALT.text, kind = ModifierKeyKind.ALT), isIndicator = true),
        gesture(BOOMERANG_UP_LEFT, ToggleAltLock),
        gesture(SWIPE_UP_RIGHT, ApplyControl, themeTriplet = modifierThemes(CONTROL.text, kind = ModifierKeyKind.CONTROL), isIndicator = true),
        gesture(BOOMERANG_UP_RIGHT, ToggleControlLock),
    ),
)

val space = gestureButton(
    rowStart = 3, colStart = 0, rowSpan = 1, colSpan = 3,
    gestureSet = mutableSetOf(
        gesture(CLICK, pressSpace),
        gesture(SWIPE_DOWN_LEFT, switchLayer, appSymbol = FUNCTION_LAYER),
        //gesture(BOOMERANG_DOWN_RIGHT, /* clearLogs */noOp),
        gesture(HOLD, simpleInput, threeStrings = reversedCase("0")),
        gesture(SWIPE_LEFT, DpadLeft, appSymbol = AppSymbol.LEFT_ARROW),
        gesture(BOOMERANG_LEFT, MoveWordLeft),
        gesture(SWIPE_RIGHT, DpadRight, appSymbol = RIGHT_ARROW),
        gesture(BOOMERANG_RIGHT, MoveWordRight),
        gesture(SWIPE_UP, arrowUp, threeStrings = triple(UP_ARROW)),
        gesture(BOOMERANG_UP, pressKey(KEYCODE_PAGE_UP), appSymbol = MOVE_PGUP),
        gesture(SWIPE_UP_RIGHT, pressKey(KEYCODE_DPAD_UP)),
        gesture(BOOMERANG_UP_RIGHT, pressKey(KEYCODE_DPAD_UP, control)),
        gesture(SWIPE_DOWN_RIGHT, pressKey(KEYCODE_DPAD_RIGHT)),
        gesture(SWIPE_UP_LEFT, pressKey(KEYCODE_DPAD_LEFT)),
        gesture(SWIPE_DOWN_LEFT, pressKey(KEYCODE_DPAD_LEFT)),
        gesture(BOOMERANG_LEFT, MoveWordLeft),
        gesture(SWIPE_DOWN, arrowDown, threeStrings = triple(DOWN_ARROW)),
        gesture(BOOMERANG_DOWN, pressKey(KEYCODE_PAGE_DOWN), appSymbol = MOVE_PGDN),
        gesture(CIRCLE_CLOCKWISE, MoveEnd, threeStrings = triple(MOVE_END)),
        gesture(CIRCLE_ANTI_CLOCKWISE, MoveHome, threeStrings = triple(MOVE_HOME)),
    ),
)

val numericSpaceLeft = space
    .withoutGesture { g: Gesture -> g.currentText == AppSymbol.SETTINGS.text }
    .withPosition(0, 3, 1, 1)

val numericSpaceRight = numericSpaceLeft
    .withPosition(colStart = 2)


