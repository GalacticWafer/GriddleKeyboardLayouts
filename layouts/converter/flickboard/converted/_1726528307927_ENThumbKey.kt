package org.galacticware.griddle.keyboarddefinition.layouts.converter.flickboard.converted

//import org.galacticware.griddle.model.operation.shiftBoardLeft
//import org.galacticware.griddle.model.operation.shiftBoardRight
import org.galacticware.griddle.domain.operation.simpleInput
import org.galacticware.griddle.domain.gesture.GestureType.CLICK
import org.galacticware.griddle.domain.gesture.GestureType.SWIPE_DOWN
import org.galacticware.griddle.domain.gesture.GestureType.SWIPE_DOWN_LEFT
import org.galacticware.griddle.domain.gesture.GestureType.SWIPE_DOWN_RIGHT
import org.galacticware.griddle.domain.gesture.GestureType.SWIPE_LEFT
import org.galacticware.griddle.domain.gesture.GestureType.SWIPE_RIGHT
import org.galacticware.griddle.domain.gesture.GestureType.SWIPE_UP
import org.galacticware.griddle.domain.gesture.GestureType.SWIPE_UP_LEFT
import org.galacticware.griddle.domain.gesture.GestureType.SWIPE_UP_RIGHT
import org.galacticware.griddle.domain.griddlebutton.builder.GriddleButtonBuilder.Companion.makeClassicGestureButton
import org.galacticware.griddle.domain.keybinder.KeyBinder.Companion.gesture
import org.galacticware.griddle.domain.util.caseSensitive

/**
 * This file was generated by the FlickBoardConverter.kt script.
 * The original file should be kept in the same directory as this file.
 */



private val _ENThumbKey_button0_0 = makeClassicGestureButton(
	rowStart = 0, colStart = 0, rowSpan = 1, colSpan = 1,
	gestureSet = mutableSetOf(
		gesture(CLICK, simpleInput, threeChars = caseSensitive("s")),
		gesture(SWIPE_DOWN_RIGHT, simpleInput, threeChars = caseSensitive("w")),
	)
)
private val _ENThumbKey_button0_1 = makeClassicGestureButton(
	rowStart = 0, colStart = 1, rowSpan = 1, colSpan = 1,
	gestureSet = mutableSetOf(
		gesture(CLICK, simpleInput, threeChars = caseSensitive("r")),
		gesture(SWIPE_DOWN, simpleInput, threeChars = caseSensitive("g")),
	)
)
private val _ENThumbKey_button0_2 = makeClassicGestureButton(
	rowStart = 0, colStart = 2, rowSpan = 1, colSpan = 1,
	gestureSet = mutableSetOf(
		gesture(CLICK, simpleInput, threeChars = caseSensitive("o")),
		gesture(SWIPE_DOWN_LEFT, simpleInput, threeChars = caseSensitive("u")),
	)
)
private val _ENThumbKey_button1_0 = makeClassicGestureButton(
	rowStart = 1, colStart = 0, rowSpan = 1, colSpan = 1,
	gestureSet = mutableSetOf(
		gesture(CLICK, simpleInput, threeChars = caseSensitive("n")),
		gesture(SWIPE_RIGHT, simpleInput, threeChars = caseSensitive("m")),
	)
)
private val _ENThumbKey_button1_1 = makeClassicGestureButton(
	rowStart = 1, colStart = 1, rowSpan = 1, colSpan = 1,
	gestureSet = mutableSetOf(
		gesture(CLICK, simpleInput, threeChars = caseSensitive("h")),
		gesture(SWIPE_UP_LEFT, simpleInput, threeChars = caseSensitive("j")),
		gesture(SWIPE_UP, simpleInput, threeChars = caseSensitive("q")),
		gesture(SWIPE_UP_RIGHT, simpleInput, threeChars = caseSensitive("b")),
		gesture(SWIPE_LEFT, simpleInput, threeChars = caseSensitive("k")),
		gesture(SWIPE_RIGHT, simpleInput, threeChars = caseSensitive("p")),
		gesture(SWIPE_DOWN_LEFT, simpleInput, threeChars = caseSensitive("v")),
		gesture(SWIPE_DOWN, simpleInput, threeChars = caseSensitive("x")),
		gesture(SWIPE_DOWN_RIGHT, simpleInput, threeChars = caseSensitive("y")),
	)
)
private val _ENThumbKey_button1_2 = makeClassicGestureButton(
	rowStart = 1, colStart = 2, rowSpan = 1, colSpan = 1,
	gestureSet = mutableSetOf(
		gesture(CLICK, simpleInput, threeChars = caseSensitive("a")),
		gesture(SWIPE_LEFT, simpleInput, threeChars = caseSensitive("l")),
	)
)
private val _ENThumbKey_button2_0 = makeClassicGestureButton(
	rowStart = 2, colStart = 0, rowSpan = 1, colSpan = 1,
	gestureSet = mutableSetOf(
		gesture(CLICK, simpleInput, threeChars = caseSensitive("t")),
		gesture(SWIPE_UP_RIGHT, simpleInput, threeChars = caseSensitive("c")),
	)
)
private val _ENThumbKey_button2_1 = makeClassicGestureButton(
	rowStart = 2, colStart = 1, rowSpan = 1, colSpan = 1,
	gestureSet = mutableSetOf(
		gesture(CLICK, simpleInput, threeChars = caseSensitive("i")),
		gesture(SWIPE_UP, simpleInput, threeChars = caseSensitive("f")),
		gesture(SWIPE_RIGHT, simpleInput, threeChars = caseSensitive("z")),
	)
)
private val _ENThumbKey_button2_2 = makeClassicGestureButton(
	rowStart = 2, colStart = 2, rowSpan = 1, colSpan = 1,
	gestureSet = mutableSetOf(
		gesture(CLICK, simpleInput, threeChars = caseSensitive("e")),
		gesture(SWIPE_UP_LEFT, simpleInput, threeChars = caseSensitive("d")),
	)
)