package org.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared

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
import org.galacticware.griddle.domain.keybinder.AppSymbol.MICROPHONE_CHAR
import org.galacticware.griddle.domain.keybinder.AppSymbol.MOVE_END
import org.galacticware.griddle.domain.keybinder.AppSymbol.MOVE_HOME
import org.galacticware.griddle.domain.keybinder.AppSymbol.MOVE_PGDN
import org.galacticware.griddle.domain.keybinder.AppSymbol.MOVE_PGUP
import org.galacticware.griddle.domain.keybinder.AppSymbol.NUMERIC_LAYER
import org.galacticware.griddle.domain.keybinder.AppSymbol.NUMPAD_LAYER
import org.galacticware.griddle.domain.keybinder.AppSymbol.PASTE
import org.galacticware.griddle.domain.keybinder.AppSymbol.REDO
import org.galacticware.griddle.domain.keybinder.AppSymbol.REPEAT
import org.galacticware.griddle.domain.keybinder.AppSymbol.RIGHT_ARROW
import org.galacticware.griddle.domain.keybinder.AppSymbol.SELECT_ALL_TEXT
import org.galacticware.griddle.domain.keybinder.AppSymbol.SHIFTED
import org.galacticware.griddle.domain.keybinder.AppSymbol.SWAP_HANDEDNESS
import org.galacticware.griddle.domain.keybinder.AppSymbol.TEXT_REPLACERS
import org.galacticware.griddle.domain.keybinder.AppSymbol.TOGGLE_CLIPBOARD
import org.galacticware.griddle.domain.keybinder.AppSymbol.TOGGLE_SETTINGS
import org.galacticware.griddle.domain.keybinder.AppSymbol.UNDO
import org.galacticware.griddle.domain.keybinder.AppSymbol.UNIFIED_ALPHA_NUMERIC_LAYER
import org.galacticware.griddle.domain.keybinder.AppSymbol.UNSHIFTED
import org.galacticware.griddle.domain.keybinder.AppSymbol.UP_ARROW
import org.galacticware.griddle.domain.keybinder.KeyBinder.Companion.gesture
import org.galacticware.griddle.domain.modifier.AppModifierKey.Companion.control
import org.galacticware.griddle.domain.modifier.ModifierKeyKind
import org.galacticware.griddle.domain.modifier.Theme.Companion.modifierThemes
import org.galacticware.griddle.domain.modifier.ThemeTriplet
import org.galacticware.griddle.domain.operation.ApplyAlt
import org.galacticware.griddle.domain.operation.ApplyControl
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
import org.galacticware.griddle.domain.operation.OpenMultiClipboard
import org.galacticware.griddle.domain.operation.OpenTextReplacerEditor
import org.galacticware.griddle.domain.operation.Paste
import org.galacticware.griddle.domain.operation.Redo
import org.galacticware.griddle.domain.operation.SelectAllToClipboard
import org.galacticware.griddle.domain.operation.SimpleInput
import org.galacticware.griddle.domain.operation.StartRecognizingSpeech
import org.galacticware.griddle.domain.operation.SwapHandedness
import org.galacticware.griddle.domain.operation.SwitchLayer
import org.galacticware.griddle.domain.operation.ToggleAltLock
import org.galacticware.griddle.domain.operation.ToggleControlLock
import org.galacticware.griddle.domain.operation.ToggleTurboMode
import org.galacticware.griddle.domain.operation.Undo
import org.galacticware.griddle.domain.operation.ArrowDown
import org.galacticware.griddle.domain.operation.ArrowUp
import org.galacticware.griddle.domain.operation.noOp
import org.galacticware.griddle.domain.operation.pressEnterKey
import org.galacticware.griddle.domain.operation.pressKey
import org.galacticware.griddle.domain.operation.pressSpace
import org.galacticware.griddle.domain.operation.repeatPreviousOperation
import org.galacticware.griddle.domain.operation.simpleInput
import org.galacticware.griddle.domain.operation.spamBackspace
import org.galacticware.griddle.domain.operation.swapGesture
import org.galacticware.griddle.domain.operation.swappable
import org.galacticware.griddle.domain.util.reversedCase
import org.galacticware.griddle.domain.util.triple

// Define empty gesture buttons for the main 3x3 keyboard layout template.
val button_0_0 get() = gestureButton(rowStart = 0, colStart = 0, rowSpan = 1, colSpan = 1)
val button_0_1 get() = gestureButton(rowStart = 0, colStart = 1, rowSpan = 1, colSpan = 1)
val button_0_2 get() = gestureButton(rowStart = 0, colStart = 2, rowSpan = 1, colSpan = 1, isPeripheral = true)
val button_1_0 get() = gestureButton(rowStart = 1, colStart = 0, rowSpan = 1, colSpan = 1)
val button_1_1 get() = gestureButton(rowStart = 1, colStart = 1, rowSpan = 1, colSpan = 1)
val button_1_2 get() = gestureButton(rowStart = 1, colStart = 2, rowSpan = 1, colSpan = 1)
val button_2_0 get() = gestureButton(rowStart = 2, colStart = 0, rowSpan = 1, colSpan = 1)
val button_2_1 get() = gestureButton(rowStart = 2, colStart = 1, rowSpan = 1, colSpan = 1)
val button_2_2 get() = gestureButton(rowStart = 2, colStart = 2, rowSpan = 1, colSpan = 1)

// A theme is 3 states of a button, which will change based on the modifier state.
// If the theme should not change, then define the same state for all three.
// However, in this example, all 3 states are different, because this theme is for
// the shift key legend.
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

        // The isIndicator flag will ensure that the legend is still visible when in turbo mode.
        // If you don't specify this flag and the legend is not an alphabet key, nor a center key,
        // then it will disappear when turbo mode is active.
        gesture(CLICK, noOp, TOGGLE_SETTINGS, isIndicator = true),
        gesture(HOLD, GoToSettingsMenu, TOGGLE_SETTINGS),
        gesture(SWIPE_LEFT, Undo, UNDO),
        gesture(SWIPE_RIGHT, Redo, REDO),
        gesture(SWIPE_UP, ToggleTurboMode),
        gesture(CIRCLE_ANTI_CLOCKWISE, SwitchLayer(UNIFIED_ALPHA_NUMERIC_LAYER)),
        gesture(CIRCLE_CLOCKWISE, SwitchLayer(UNIFIED_ALPHA_NUMERIC_LAYER)),
    ),
)

// you can define a triple of text that will be re-used in multiple gestures
// The following line will provide "▲", "⇪", and "▼" as the text for the three states of the shift key legends
val shiftLegends = Triple(SHIFTED.text, CAPSLOCKED.text, UNSHIFTED.text)

// The following line will provide " ", "▼", and "▼" as the text for the three states of the un-shift key legends
val unShiftLegends = Triple(" ", UNSHIFTED.text, UNSHIFTED.text)

// You can define a key that can rotate through different gestures
// based on performing whichever gesture you want.
val multiKey: Gesture = gesture(CLICK, swappable(
    // Just like a normal gesture definition, you have to
    // specify the operation and the text for each swappable
    // operation. This example starts out with backspace.
    pressKey(KEYCODE_DEL) to triple(BACKSPACE),

    // But then, it will change to repeat if you hold it down
    // (holding the key down a second time will rotate the current action
    // to the original backspace action, since there are only two actions).
//    repeatPreviousOperation to triple(REPEAT),
), BACKSPACE)

val backspace = gestureButton(
    rowStart = 2, colStart = 3, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        // This advanced example shows a backspace key that can be swapped
        // with the "repeat-previous-operation" action, by holding
        // the key down.
        gesture(HOLD, /*swapGesture(multiKey)*/ spamBackspace),
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

val AlphabeticLayerToggle = gestureButton(
    rowStart = 1, colStart = 3, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(SWIPE_UP, Copy, COPY),
        gesture(SWIPE_LEFT, Cut, CUT),
        gesture(SWIPE_UP_LEFT, OpenTextReplacerEditor, TEXT_REPLACERS, ),
        gesture(SWIPE_DOWN, Paste, PASTE),
        gesture(CLICK, SwitchLayer(ALPHA_LAYER)),
        gesture(SWIPE_RIGHT, SwapHandedness, SWAP_HANDEDNESS),
        gesture(CIRCLE_ANTI_CLOCKWISE, pressKey(KEYCODE_A, control)),
        gesture(CIRCLE_CLOCKWISE, pressKey(KEYCODE_A, control)),
        gesture(SWIPE_DOWN_RIGHT, StartRecognizingSpeech, MICROPHONE_CHAR),
        gesture(BOOMERANG_DOWN, OpenMultiClipboard, TOGGLE_CLIPBOARD),
    ),
)

val NumericLayerToggle = gestureButton(
    rowStart = 1, colStart = 3, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(SWIPE_UP, Copy, COPY),
        gesture(SWIPE_LEFT, Cut, CUT),
        gesture(SWIPE_DOWN, Paste, PASTE),
        gesture(SWIPE_UP_LEFT, OpenTextReplacerEditor, TEXT_REPLACERS, ),
        gesture(SWIPE_RIGHT, SwapHandedness, SWAP_HANDEDNESS),
        gesture(CLICK, SwitchLayer(NUMERIC_LAYER)),
        gesture(HOLD, SwitchLayer(NUMPAD_LAYER)),
        gesture(CIRCLE_ANTI_CLOCKWISE, SelectAllToClipboard, SELECT_ALL_TEXT),
        gesture(CIRCLE_CLOCKWISE, SelectAllToClipboard, SELECT_ALL_TEXT),
        gesture(SWIPE_DOWN_RIGHT, StartRecognizingSpeech, MICROPHONE_CHAR),
        gesture(BOOMERANG_DOWN, OpenMultiClipboard, TOGGLE_CLIPBOARD),
    ),
)

val altIndicator = modifierThemes(ALT.text, kind = ModifierKeyKind.ALT)
val controlIndicator = modifierThemes(CONTROL.text, kind = ModifierKeyKind.CONTROL)
val enter = gestureButton(
    rowStart = 3, colStart = 3, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(CLICK, pressEnterKey, GO),
        gesture(SWIPE_UP_LEFT, ApplyAlt, themeTriplet = altIndicator, isIndicator = true),
        gesture(BOOMERANG_UP_LEFT, ToggleAltLock),
        gesture(SWIPE_UP_RIGHT, ApplyControl, themeTriplet = controlIndicator, isIndicator = true),
        gesture(BOOMERANG_UP_RIGHT, ToggleControlLock),
    ),
)

val space = gestureButton(
    rowStart = 3, colStart = 0, rowSpan = 1, colSpan = 3,
    gestureSet = mutableSetOf(
        gesture(CLICK, pressSpace),
        gesture(SWIPE_DOWN_LEFT, SwitchLayer(FUNCTION_LAYER)),
        gesture(HOLD, simpleInput, threeStrings = reversedCase("0")),
        gesture(SWIPE_LEFT, DpadLeft, AppSymbol.LEFT_ARROW),
        gesture(BOOMERANG_LEFT, MoveWordLeft),
        gesture(SWIPE_RIGHT, DpadRight, RIGHT_ARROW),
        gesture(BOOMERANG_RIGHT, MoveWordRight),
        gesture(SWIPE_UP, ArrowUp, threeStrings = triple(UP_ARROW)),
        gesture(BOOMERANG_UP, pressKey(KEYCODE_PAGE_UP), MOVE_PGUP),
        gesture(SWIPE_UP_RIGHT, pressKey(KEYCODE_DPAD_UP)),
        gesture(BOOMERANG_UP_RIGHT, pressKey(KEYCODE_DPAD_UP, control)),
        gesture(SWIPE_DOWN_RIGHT, pressKey(KEYCODE_DPAD_RIGHT)),
        gesture(SWIPE_UP_LEFT, pressKey(KEYCODE_DPAD_LEFT)),
        gesture(SWIPE_DOWN_LEFT, pressKey(KEYCODE_DPAD_LEFT)),
        gesture(BOOMERANG_LEFT, MoveWordLeft),
        gesture(SWIPE_DOWN, ArrowDown, threeStrings = triple(DOWN_ARROW)),
        gesture(BOOMERANG_DOWN, pressKey(KEYCODE_PAGE_DOWN), MOVE_PGDN),
        gesture(CIRCLE_CLOCKWISE, MoveEnd, threeStrings = triple(MOVE_END)),
        gesture(CIRCLE_ANTI_CLOCKWISE, MoveHome, threeStrings = triple(MOVE_HOME)),
    ),
)

val numericSpaceLeft = space
    // You can write custom logic to remove gestures from a button.
    .withoutGesture { g: Gesture -> g.currentText == AppSymbol.SETTINGS.text }
    // You can change the position and size of an existing button to make a new one.
    .withPosition(colStart = 0, rowStart = 3,  colSpan = 1, rowSpan = 1)

val numericSpaceRight = numericSpaceLeft
    .withPosition(colStart = 2)


