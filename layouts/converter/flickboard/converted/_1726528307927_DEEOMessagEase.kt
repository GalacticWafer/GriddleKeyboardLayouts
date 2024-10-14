/*
package org.galacticware.griddle.keyboarddefinition.layouts.converter.flickboard.converted

import android.view.KeyEvent
import org.galacticware.griddle.model.operation.cycleAccentCharacters
import org.galacticware.griddle.model.operation.cycleShiftState
import org.galacticware.griddle.model.operation.moveLeft
import org.galacticware.griddle.model.operation.moveRight
import org.galacticware.griddle.model.operation.moveWordLeft
import org.galacticware.griddle.model.operation.moveWordRight
import org.galacticware.griddle.model.operation.noOp
import org.galacticware.griddle.model.operation.openMacroEditor
import org.galacticware.griddle.model.operation.pressKey
import org.galacticware.griddle.model.operation.releaseShift
import org.galacticware.griddle.model.operation.remappedSymbolLookup
import org.galacticware.griddle.model.operation.repeatPreviousOperation
import org.galacticware.griddle.model.operation.selectAll
//import org.galacticware.griddle.model.operation.shiftBoardLeft
//import org.galacticware.griddle.model.operation.shiftBoardRight
import org.galacticware.griddle.model.operation.simpleInput
import org.galacticware.griddle.model.operation.spamBackspace
import org.galacticware.griddle.model.operation.startRecognizingSpeech
import org.galacticware.griddle.model.operation.swapHandedness
import org.galacticware.griddle.model.operation.switchLayer
import org.galacticware.griddle.model.operation.toggleAltLock
import org.galacticware.griddle.model.operation.toggleCapslock
import org.galacticware.griddle.model.operation.toggleControlLock
import org.galacticware.griddle.model.operation.toggleOneShotShift
import org.galacticware.griddle.model.gesture.Gesture
import org.galacticware.griddle.model.gesture.GestureType.BOOMERANG_DOWN
import org.galacticware.griddle.model.gesture.GestureType.BOOMERANG_DOWN_LEFT
import org.galacticware.griddle.model.gesture.GestureType.BOOMERANG_DOWN_RIGHT
import org.galacticware.griddle.model.gesture.GestureType.BOOMERANG_LEFT
import org.galacticware.griddle.model.gesture.GestureType.BOOMERANG_RIGHT
import org.galacticware.griddle.model.gesture.GestureType.BOOMERANG_UP
import org.galacticware.griddle.model.gesture.GestureType.BOOMERANG_UP_LEFT
import org.galacticware.griddle.model.gesture.GestureType.BOOMERANG_UP_RIGHT
import org.galacticware.griddle.model.gesture.GestureType.CIRCLE_ANTI_CLOCKWISE
import org.galacticware.griddle.model.gesture.GestureType.CIRCLE_CLOCKWISE
import org.galacticware.griddle.model.gesture.GestureType.CLICK
import org.galacticware.griddle.model.gesture.GestureType.HOLD
import org.galacticware.griddle.model.gesture.GestureType.SWIPE_DOWN
import org.galacticware.griddle.model.gesture.GestureType.SWIPE_DOWN_LEFT
import org.galacticware.griddle.model.gesture.GestureType.SWIPE_DOWN_RIGHT
import org.galacticware.griddle.model.gesture.GestureType.SWIPE_LEFT
import org.galacticware.griddle.model.gesture.GestureType.SWIPE_RIGHT
import org.galacticware.griddle.model.gesture.GestureType.SWIPE_UP
import org.galacticware.griddle.model.gesture.GestureType.SWIPE_UP_LEFT
import org.galacticware.griddle.model.gesture.GestureType.SWIPE_UP_RIGHT
import org.galacticware.griddle.model.griddlebutton.builder.GriddleButtonBuilder.Companion.makeClassicGestureButton
import org.galacticware.griddle.model.keybinder.KeyBinder.Companion.bind
import org.galacticware.griddle.model.modifier.AppModifierKey.Companion.control
import org.galacticware.griddle.model.modifier.ModifierThemeSet
import org.galacticware.griddle.model.modifier.ModifierTheme.Companion.modifierThemes
import org.galacticware.griddle.model.keybinder.AppSymbol
import org.galacticware.griddle.model.keybinder.AppSymbol.ALT
import org.galacticware.griddle.model.keybinder.AppSymbol.BACKSPACE
import org.galacticware.griddle.model.keybinder.AppSymbol.CAPSLOCKED
import org.galacticware.griddle.model.keybinder.AppSymbol.CONTROL
import org.galacticware.griddle.model.keybinder.AppSymbol.COPY
import org.galacticware.griddle.model.keybinder.AppSymbol.CUT
import org.galacticware.griddle.model.keybinder.AppSymbol.DOWN_ARROW
import org.galacticware.griddle.model.keybinder.AppSymbol.ENTER
import org.galacticware.griddle.model.keybinder.AppSymbol.F10_SYMBOL
import org.galacticware.griddle.model.keybinder.AppSymbol.F11_SYMBOL
import org.galacticware.griddle.model.keybinder.AppSymbol.F12_SYMBOL
import org.galacticware.griddle.model.keybinder.AppSymbol.F1_SYMBOL
import org.galacticware.griddle.model.keybinder.AppSymbol.F2_SYMBOL
import org.galacticware.griddle.model.keybinder.AppSymbol.F3_SYMBOL
import org.galacticware.griddle.model.keybinder.AppSymbol.F4_SYMBOL
import org.galacticware.griddle.model.keybinder.AppSymbol.F5_SYMBOL
import org.galacticware.griddle.model.keybinder.AppSymbol.F6_SYMBOL
import org.galacticware.griddle.model.keybinder.AppSymbol.F7_SYMBOL
import org.galacticware.griddle.model.keybinder.AppSymbol.F8_SYMBOL
import org.galacticware.griddle.model.keybinder.AppSymbol.F9_SYMBOL
import org.galacticware.griddle.model.keybinder.AppSymbol.LEFT_ARROW
import org.galacticware.griddle.model.keybinder.AppSymbol.MACRO
import org.galacticware.griddle.model.keybinder.AppSymbol.MICROPHONE_CHAR
import org.galacticware.griddle.model.keybinder.AppSymbol.MOVE_END
import org.galacticware.griddle.model.keybinder.AppSymbol.MOVE_HOME
import org.galacticware.griddle.model.keybinder.AppSymbol.MOVE_PGDN
import org.galacticware.griddle.model.keybinder.AppSymbol.PASTE
import org.galacticware.griddle.model.keybinder.AppSymbol.RIGHT_ARROW
import org.galacticware.griddle.model.keybinder.AppSymbol.SELECT_ALL_TEXT
import org.galacticware.griddle.model.keybinder.AppSymbol.SHIFTED
import org.galacticware.griddle.model.keybinder.AppSymbol.SWAP_HANDEDNESS
import org.galacticware.griddle.model.keybinder.AppSymbol.TAB_RIGHT
import org.galacticware.griddle.model.keybinder.AppSymbol.TOGGLE_ALPHA
import org.galacticware.griddle.model.keybinder.AppSymbol.TOGGLE_ALPHA_NUMERIC_UNIFIED_LAYER
import org.galacticware.griddle.model.keybinder.AppSymbol.TOGGLE_FUNCTION_LAYER
import org.galacticware.griddle.model.keybinder.AppSymbol.TOGGLE_NUMBER_LAYER
import org.galacticware.griddle.model.keybinder.AppSymbol.TOGGLE_SETTINGS
import org.galacticware.griddle.model.keybinder.AppSymbol.UNSHIFTED
import org.galacticware.griddle.model.keybinder.AppSymbol.UP_ARROW
import org.galacticware.griddle.model.modifier.ModifierKeyKind
import org.galacticware.griddle.model.util.caseSensitive
import org.galacticware.griddle.model.util.reversedCase
import org.galacticware.griddle.model.util.withSymbol

*/
/**
 * This file was generated by the FlickBoardConverter.kt script.
 * The original file should be kept in the same directory as this file.
 *//*




private val _DEEOMessagEase_button0_0 = makeClassicGestureButton(
	rowStart = 0, colStart = 0, rowSpan = 1, colSpan = 1,
	gestureSet = mutableSetOf(
		bind(CLICK, simpleInput, threeStrings = caseSensitive("a")),
		bind(SWIPE_DOWN, simpleInput, threeStrings = caseSensitive("ä")),
		bind(SWIPE_DOWN_RIGHT, simpleInput, threeStrings = caseSensitive("v")),
		bind(SWIPE_UP_RIGHT, simpleInput, threeStrings = caseSensitive("ŭ")),
		bind(SWIPE_UP, simpleInput, threeStrings = caseSensitive("ĝ")),
		bind(SWIPE_UP_RIGHT, simpleInput, threeStrings = caseSensitive("ŭ")),
		bind(SWIPE_LEFT, simpleInput, threeStrings = caseSensitive("ŝ")),
	)
)
private val _DEEOMessagEase_button0_1 = makeClassicGestureButton(
	rowStart = 0, colStart = 1, rowSpan = 1, colSpan = 1,
	gestureSet = mutableSetOf(
		bind(CLICK, simpleInput, threeStrings = caseSensitive("n")),
		bind(SWIPE_DOWN, simpleInput, threeStrings = caseSensitive("l")),
	)
)
private val _DEEOMessagEase_button0_2 = makeClassicGestureButton(
	rowStart = 0, colStart = 2, rowSpan = 1, colSpan = 1,
	gestureSet = mutableSetOf(
		bind(CLICK, simpleInput, threeStrings = caseSensitive("i")),
		bind(SWIPE_DOWN_LEFT, simpleInput, threeStrings = caseSensitive("x")),
		bind(SWIPE_UP_LEFT, simpleInput, threeStrings = caseSensitive("ĉ")),
		bind(SWIPE_UP_RIGHT, simpleInput, threeStrings = caseSensitive("ĵ")),
		bind(SWIPE_RIGHT, simpleInput, threeStrings = caseSensitive("ĥ")),
	)
)
private val _DEEOMessagEase_button1_0 = makeClassicGestureButton(
	rowStart = 1, colStart = 0, rowSpan = 1, colSpan = 1,
	gestureSet = mutableSetOf(
		bind(SWIPE_UP, simpleInput, threeStrings = caseSensitive("ü")),
		bind(CLICK, simpleInput, threeStrings = caseSensitive("h")),
		bind(SWIPE_RIGHT, simpleInput, threeStrings = caseSensitive("k")),
		bind(SWIPE_DOWN, simpleInput, threeStrings = caseSensitive("ö")),
	)
)
private val _DEEOMessagEase_button1_1 = makeClassicGestureButton(
	rowStart = 1, colStart = 1, rowSpan = 1, colSpan = 1,
	gestureSet = mutableSetOf(
		bind(CLICK, simpleInput, threeStrings = caseSensitive("d")),
		bind(SWIPE_UP_LEFT, simpleInput, threeStrings = caseSensitive("q")),
		bind(SWIPE_UP, simpleInput, threeStrings = caseSensitive("u")),
		bind(SWIPE_UP_RIGHT, simpleInput, threeStrings = caseSensitive("p")),
		bind(SWIPE_LEFT, simpleInput, threeStrings = caseSensitive("c")),
		bind(SWIPE_RIGHT, simpleInput, threeStrings = caseSensitive("b")),
		bind(SWIPE_DOWN_LEFT, simpleInput, threeStrings = caseSensitive("g")),
		bind(SWIPE_DOWN, simpleInput, threeStrings = caseSensitive("o")),
		bind(SWIPE_DOWN_RIGHT, simpleInput, threeStrings = caseSensitive("j")),
	)
)
private val _DEEOMessagEase_button1_2 = makeClassicGestureButton(
	rowStart = 1, colStart = 2, rowSpan = 1, colSpan = 1,
	gestureSet = mutableSetOf(
		bind(CLICK, simpleInput, threeStrings = caseSensitive("r")),
		bind(SWIPE_LEFT, simpleInput, threeStrings = caseSensitive("m")),
	)
)
private val _DEEOMessagEase_button2_0 = makeClassicGestureButton(
	rowStart = 2, colStart = 0, rowSpan = 1, colSpan = 1,
	gestureSet = mutableSetOf(
		bind(CLICK, simpleInput, threeStrings = caseSensitive("t")),
		bind(SWIPE_UP_RIGHT, simpleInput, threeStrings = caseSensitive("y")),
		bind(SWIPE_DOWN, simpleInput, threeStrings = caseSensitive("ß")),
		bind(SWIPE_DOWN_LEFT, simpleInput, threeStrings = caseSensitive("ch")),
	)
			)
private val _DEEOMessagEase_button2_0 = makeClassicGestureButton(
	rowStart = 2, colStart = 0, rowSpan = 1, colSpan = 1,
	gestureSet = mutableSetOf(
		bind(SWIPE_DOWN, simpleInput, threeStrings = caseSensitive("ẞ")),
		bind(SWIPE_DOWN_LEFT, simpleInput, threeStrings = caseSensitive("Ch")),
	)
)
private val _DEEOMessagEase_button2_1 = makeClassicGestureButton(
	rowStart = 2, colStart = 1, rowSpan = 1, colSpan = 1,
	gestureSet = mutableSetOf(
		bind(CLICK, simpleInput, threeStrings = caseSensitive("e")),
		bind(SWIPE_UP, simpleInput, threeStrings = caseSensitive("w")),
		bind(SWIPE_RIGHT, simpleInput, threeStrings = caseSensitive("z")),
		bind(SWIPE_LEFT, simpleInput, threeStrings = caseSensitive("ck")),
private val _DEEOMessagEase_button2_0 = makeClassicGestureButton(
	rowStart = 2, colStart = 0, rowSpan = 1, colSpan = 1,
	gestureSet = mutableSetOf(
		bind(SWIPE_LEFT, simpleInput, threeStrings = caseSensitive("Ck")),
	)
)
private val _DEEOMessagEase_button2_1 = makeClassicGestureButton(
	rowStart = 2, colStart = 1, rowSpan = 1, colSpan = 1,
	gestureSet = mutableSetOf(
		bind(CLICK, simpleInput, threeStrings = caseSensitive("s")),
		bind(SWIPE_UP_LEFT, simpleInput, threeStrings = caseSensitive("f")),
		bind(SWIPE_DOWN_RIGHT, simpleInput, threeStrings = caseSensitive("sch")),
private val _DEEOMessagEase_button2_0 = makeClassicGestureButton(
	rowStart = 2, colStart = 0, rowSpan = 1, colSpan = 1,
	gestureSet = mutableSetOf(
		bind(SWIPE_DOWN_RIGHT, simpleInput, threeStrings = caseSensitive("Sch")),
	)
)*/
