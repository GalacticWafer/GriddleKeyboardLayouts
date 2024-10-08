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



private val _RUPHMessageEase_button0_0 = makeClassicGestureButton(
	rowStart = 0, colStart = 0, rowSpan = 1, colSpan = 1,
	gestureSet = mutableSetOf(
		gesture(CLICK, simpleInput, threeStrings = caseSensitive("а")),
		gesture(SWIPE_DOWN, simpleInput, threeStrings = caseSensitive("ч")),
		gesture(SWIPE_DOWN_RIGHT, simpleInput, threeStrings = caseSensitive("ж")),
	)
)
private val _RUPHMessageEase_button0_1 = makeClassicGestureButton(
	rowStart = 0, colStart = 1, rowSpan = 1, colSpan = 1,
	gestureSet = mutableSetOf(
		gesture(CLICK, simpleInput, threeStrings = caseSensitive("н")),
		gesture(SWIPE_DOWN, simpleInput, threeStrings = caseSensitive("л")),
	)
)
private val _RUPHMessageEase_button0_2 = makeClassicGestureButton(
	rowStart = 0, colStart = 2, rowSpan = 1, colSpan = 1,
	gestureSet = mutableSetOf(
		gesture(CLICK, simpleInput, threeStrings = caseSensitive("и")),
		gesture(SWIPE_DOWN_LEFT, simpleInput, threeStrings = caseSensitive("х")),
	)
)
private val _RUPHMessageEase_button1_0 = makeClassicGestureButton(
	rowStart = 1, colStart = 0, rowSpan = 1, colSpan = 1,
	gestureSet = mutableSetOf(
		gesture(CLICK, simpleInput, threeStrings = caseSensitive("в")),
		gesture(SWIPE_UP, simpleInput, threeStrings = caseSensitive("ъ")),
		gesture(SWIPE_RIGHT, simpleInput, threeStrings = caseSensitive("к")),
		gesture(SWIPE_DOWN, simpleInput, threeStrings = caseSensitive("ь")),
		gesture(SWIPE_DOWN_RIGHT, simpleInput, threeStrings = caseSensitive("ы")),
	)
)
private val _RUPHMessageEase_button1_1 = makeClassicGestureButton(
	rowStart = 1, colStart = 1, rowSpan = 1, colSpan = 1,
	gestureSet = mutableSetOf(
		gesture(CLICK, simpleInput, threeStrings = caseSensitive("о")),
		gesture(SWIPE_UP_LEFT, simpleInput, threeStrings = caseSensitive("я")),
		gesture(SWIPE_UP, simpleInput, threeStrings = caseSensitive("у")),
		gesture(SWIPE_UP_RIGHT, simpleInput, threeStrings = caseSensitive("п")),
		gesture(SWIPE_LEFT, simpleInput, threeStrings = caseSensitive("ц")),
		gesture(SWIPE_RIGHT, simpleInput, threeStrings = caseSensitive("б")),
		gesture(SWIPE_DOWN_LEFT, simpleInput, threeStrings = caseSensitive("г")),
		gesture(SWIPE_DOWN, simpleInput, threeStrings = caseSensitive("д")),
		gesture(SWIPE_DOWN_RIGHT, simpleInput, threeStrings = caseSensitive("й")),
	)
)
private val _RUPHMessageEase_button1_2 = makeClassicGestureButton(
	rowStart = 1, colStart = 2, rowSpan = 1, colSpan = 1,
	gestureSet = mutableSetOf(
		gesture(CLICK, simpleInput, threeStrings = caseSensitive("р")),
		gesture(SWIPE_LEFT, simpleInput, threeStrings = caseSensitive("м")),
	)
)
private val _RUPHMessageEase_button2_0 = makeClassicGestureButton(
	rowStart = 2, colStart = 0, rowSpan = 1, colSpan = 1,
	gestureSet = mutableSetOf(
		gesture(CLICK, simpleInput, threeStrings = caseSensitive("т")),
		gesture(SWIPE_UP, simpleInput, threeStrings = caseSensitive("ё")),
		gesture(SWIPE_UP_RIGHT, simpleInput, threeStrings = caseSensitive("ю")),
		gesture(SWIPE_RIGHT, simpleInput, threeStrings = caseSensitive("щ")),
	)
)
private val _RUPHMessageEase_button2_1 = makeClassicGestureButton(
	rowStart = 2, colStart = 1, rowSpan = 1, colSpan = 1,
	gestureSet = mutableSetOf(
		gesture(CLICK, simpleInput, threeStrings = caseSensitive("е")),
		gesture(SWIPE_LEFT, simpleInput, threeStrings = caseSensitive("ш")),
		gesture(SWIPE_UP, simpleInput, threeStrings = caseSensitive("э")),
		gesture(SWIPE_RIGHT, simpleInput, threeStrings = caseSensitive("з")),
	)
)
private val _RUPHMessageEase_button2_2 = makeClassicGestureButton(
	rowStart = 2, colStart = 2, rowSpan = 1, colSpan = 1,
	gestureSet = mutableSetOf(
		gesture(CLICK, simpleInput, threeStrings = caseSensitive("с")),
		gesture(SWIPE_UP_LEFT, simpleInput, threeStrings = caseSensitive("ф")),
	)
)