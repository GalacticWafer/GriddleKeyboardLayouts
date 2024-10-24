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
import org.galacticware.griddle.domain.griddlebutton.builder.GriddleButtonBuilder.Companion.gestureButton
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
import org.galacticware.griddle.domain.keybinder.AppSymbol.NUMERIC_LAYER
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
import org.galacticware.griddle.domain.modifier.ModifierTheme.Companion.modifierThemes
import org.galacticware.griddle.domain.modifier.ModifierThemeSet
import org.galacticware.griddle.domain.operation.applyAlt
import org.galacticware.griddle.domain.operation.applyControl
import org.galacticware.griddle.domain.operation.arrowDown
import org.galacticware.griddle.domain.operation.arrowUp
import org.galacticware.griddle.domain.operation.moveEnd
import org.galacticware.griddle.domain.operation.moveHome
import org.galacticware.griddle.domain.operation.moveLeft
import org.galacticware.griddle.domain.operation.moveRight
import org.galacticware.griddle.domain.operation.moveWordLeft
import org.galacticware.griddle.domain.operation.moveWordRight
import org.galacticware.griddle.domain.operation.noOp
import org.galacticware.griddle.domain.operation.openMacroEditor
import org.galacticware.griddle.domain.operation.pressEnterKey
import org.galacticware.griddle.domain.operation.pressKey
import org.galacticware.griddle.domain.operation.pressSpace
import org.galacticware.griddle.domain.operation.remappedSymbolLookup
import org.galacticware.griddle.domain.operation.selectAll
import org.galacticware.griddle.domain.operation.simpleInput
import org.galacticware.griddle.domain.operation.startRecognizingSpeech
import org.galacticware.griddle.domain.operation.swapHandedness
import org.galacticware.griddle.domain.operation.swappable
import org.galacticware.griddle.domain.operation.switchLayer
import org.galacticware.griddle.domain.operation.switchToScreen
import org.galacticware.griddle.domain.operation.toggleAltLock
import org.galacticware.griddle.domain.operation.toggleControlLock
import org.galacticware.griddle.domain.operation.toggleTurboMode
import org.galacticware.griddle.domain.util.caseSensitive
import org.galacticware.griddle.domain.util.reversedCase
import org.galacticware.griddle.domain.util.triple
import org.galacticware.griddle.keyboarddefinition.system.ClipboardScreen
import org.galacticware.griddle.view.composable.screen.BaseSettingsScreen
import spamBackspace

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
        gesture(CLICK, noOp, appSymbol = TOGGLE_SETTINGS, isIndicator = true),
        gesture(HOLD, switchToScreen(BaseSettingsScreen)),
        gesture(SWIPE_LEFT, pressKey(KeyEvent.KEYCODE_Z, control), threeStrings = triple("UNDO")),
        gesture(SWIPE_RIGHT, pressKey(KeyEvent.KEYCODE_Y, control), threeStrings = triple("REDO")),
        gesture(SWIPE_UP, toggleTurboMode),
        gesture(CIRCLE_ANTI_CLOCKWISE, switchLayer, appSymbol = UNIFIED_ALPHA_NUMERIC_LAYER),
        gesture(CIRCLE_CLOCKWISE, switchLayer, appSymbol = UNIFIED_ALPHA_NUMERIC_LAYER),
    ),
)

// you can define a triple of text that will be re-used in multiple gestures
val shiftLegends = Triple(SHIFTED.value, CAPSLOCKED.value, UNSHIFTED.value)
val unShiftLegends = Triple(" ", UNSHIFTED.value, UNSHIFTED.value)


val cycleEmojisLeft = gestureButton(
    rowStart = 3, colStart = 0, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(CLICK, /* cycleEmojiPage */noOp, threeStrings = caseSensitive("⬅\uFE0F"))
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
        gesture(SWIPE_UP, remappedSymbolLookup, appSymbol = COPY),
        gesture(SWIPE_LEFT, remappedSymbolLookup, appSymbol = CUT),
        gesture(SWIPE_UP_LEFT, openMacroEditor, appSymbol = MACRO, ),
        gesture(SWIPE_DOWN, remappedSymbolLookup, appSymbol = PASTE),
        gesture(CLICK, switchLayer, appSymbol = ALPHA_LAYER),
        gesture(SWIPE_RIGHT, swapHandedness, appSymbol = SWAP_HANDEDNESS),
        gesture(CIRCLE_ANTI_CLOCKWISE, pressKey(KEYCODE_A, control)),
        gesture(CIRCLE_CLOCKWISE, pressKey(KEYCODE_A, control)),
        gesture(SWIPE_DOWN_RIGHT, startRecognizingSpeech, appSymbol = MICROPHONE_CHAR),
        gesture(BOOMERANG_DOWN, switchToScreen(ClipboardScreen), appSymbol = TOGGLE_CLIPBOARD),
    ),
)

val NumericLayerToggle = gestureButton(
    rowStart = 1, colStart = 3, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(SWIPE_UP, remappedSymbolLookup, appSymbol = COPY),
        gesture(SWIPE_LEFT, remappedSymbolLookup, appSymbol = CUT),
        gesture(SWIPE_DOWN, remappedSymbolLookup, appSymbol = PASTE),
        gesture(SWIPE_UP_LEFT, openMacroEditor, appSymbol = MACRO, ),
        gesture(SWIPE_RIGHT, swapHandedness, appSymbol = SWAP_HANDEDNESS),
        gesture(CLICK, switchLayer, appSymbol = NUMERIC_LAYER),
        gesture(CIRCLE_ANTI_CLOCKWISE, selectAll, appSymbol = SELECT_ALL_TEXT),
        gesture(CIRCLE_CLOCKWISE, selectAll, appSymbol = SELECT_ALL_TEXT),
        gesture(SWIPE_DOWN_RIGHT, startRecognizingSpeech, appSymbol = MICROPHONE_CHAR),
        gesture(BOOMERANG_DOWN, switchToScreen(ClipboardScreen), appSymbol = TOGGLE_CLIPBOARD),
    ),
)

val enter = gestureButton(
    rowStart = 3, colStart = 3, rowSpan = 1, colSpan = 1,
    gestureSet = mutableSetOf(
        gesture(CLICK, pressEnterKey, appSymbol = GO),
        gesture(SWIPE_UP_LEFT, applyAlt, modifierThemeSet = modifierThemes(ALT.value, kind = ModifierKeyKind.ALT), isIndicator = true),
        gesture(BOOMERANG_UP_LEFT, toggleAltLock),
        gesture(SWIPE_UP_RIGHT, applyControl, modifierThemeSet = modifierThemes(CONTROL.value, kind = ModifierKeyKind.CONTROL), isIndicator = true),
        gesture(BOOMERANG_UP_RIGHT, toggleControlLock),
    ),
)

val space = gestureButton(
    rowStart = 3, colStart = 0, rowSpan = 1, colSpan = 3,
    gestureSet = mutableSetOf(
        gesture(CLICK, pressSpace),
        gesture(SWIPE_DOWN_LEFT, switchLayer, appSymbol = FUNCTION_LAYER),
        //gesture(BOOMERANG_DOWN_RIGHT, /* clearLogs */noOp),
        gesture(HOLD, simpleInput, threeStrings = reversedCase("0")),
        gesture(SWIPE_LEFT, moveLeft, appSymbol = AppSymbol.LEFT_ARROW),
        gesture(BOOMERANG_LEFT, moveWordLeft),
        gesture(SWIPE_RIGHT, moveRight, appSymbol = RIGHT_ARROW),
        gesture(BOOMERANG_RIGHT, moveWordRight),
        gesture(SWIPE_UP, arrowUp, threeStrings = triple(UP_ARROW)),
        gesture(BOOMERANG_UP, pressKey(KEYCODE_PAGE_UP), appSymbol = MOVE_PGUP),
        gesture(SWIPE_UP_RIGHT, pressKey(KEYCODE_DPAD_UP)),
        gesture(BOOMERANG_UP_RIGHT, pressKey(KEYCODE_DPAD_UP, control)),
        gesture(SWIPE_DOWN_RIGHT, pressKey(KEYCODE_DPAD_RIGHT)),
        gesture(BOOMERANG_RIGHT, moveWordRight),
        gesture(SWIPE_UP_LEFT, pressKey(KEYCODE_DPAD_LEFT)),
        gesture(SWIPE_DOWN_LEFT, pressKey(KEYCODE_DPAD_LEFT)),
        gesture(BOOMERANG_LEFT, moveWordLeft),
        gesture(SWIPE_DOWN, arrowDown, threeStrings = triple(DOWN_ARROW)),
        gesture(BOOMERANG_DOWN, pressKey(KEYCODE_PAGE_DOWN), appSymbol = MOVE_PGDN),
        gesture(CIRCLE_CLOCKWISE, moveEnd, threeStrings = triple(MOVE_END)),
        gesture(CIRCLE_ANTI_CLOCKWISE, moveHome, threeStrings = triple(MOVE_HOME)),
    ),
)

val numericSpaceLeft = space
    .withoutGesture { g: Gesture -> g.currentText == AppSymbol.SETTINGS.value }
    .withPosition(0, 3, 1, 1)

val numericSpaceRight = numericSpaceLeft
    .withPosition(colStart = 2)


