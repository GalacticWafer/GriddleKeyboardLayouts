package com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english

import android.content.Context
import androidx.compose.ui.unit.IntSize
import com.galacticware.griddle.domain.gesture.GestureType.BOOMERANG_DOWN
import com.galacticware.griddle.domain.gesture.GestureType.BOOMERANG_DOWN_LEFT
import com.galacticware.griddle.domain.gesture.GestureType.BOOMERANG_DOWN_RIGHT
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
import com.galacticware.griddle.domain.keybinder.AppSymbol.TAB_RIGHT
import com.galacticware.griddle.domain.keybinder.KeyBinder.Companion.gesture
import com.galacticware.griddle.domain.keyboard.KeyboardHandedness
import com.galacticware.griddle.domain.language.LanguageTag
import com.galacticware.griddle.domain.layer.LayerDefinable
import com.galacticware.griddle.domain.layer.LayerKind
import com.galacticware.griddle.domain.operation.cycleAccentCharacters
import com.galacticware.griddle.domain.operation.cycleShiftState
import com.galacticware.griddle.domain.operation.pressTab
import com.galacticware.griddle.domain.operation.sendNewLineFeed
import com.galacticware.griddle.domain.operation.sendTab
import com.galacticware.griddle.domain.operation.simpleInput
import com.galacticware.griddle.domain.operation.toggleCapslock
import com.galacticware.griddle.domain.util.caseSensitive
import com.galacticware.griddle.domain.util.reversedCase
import com.galacticware.griddle.domain.util.triple
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.CreateLayout
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.GridKeyMapper
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.NumericLayerToggle
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.backspace
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.button_0_0
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.button_0_1
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.button_0_2
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.button_1_0
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.button_1_1
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.button_1_2
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.button_2_0
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.button_2_1
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.button_2_2
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.cursorControlButton
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.enter
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.shiftIndicatorColorTheme
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.shiftLegends
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.space
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.unShiftIndicator
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared.unShiftLegends
import com.galacticware.griddle.keyboarddefinition.opensource.theme.DEFAULT_SIZE
import java.util.Locale

/***
 * The definitions for English keys, roughly-based on the MessagEase layout.
 * Alphas and numerics are in the same place, with the same possible gestures for them.
 */
abstract class GriddleKeyMap: GridKeyMapper {
    private val nameRegex = Regex("(?<=[a-z])(?=[A-Z])")
    override val name = this::class.simpleName!!.split(nameRegex).dropLast(1).joinToString(" ") { s ->
        s.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
    }
    override fun build(context: Context): LayerDefinable = CreateLayout(
        context,
        name,
        allMappings(),
        keyboardHandedness,
        defalultSize,
        isPrimary,
        layerKind,
        languageTag,
    )
}

object GriddleEnglishMap: GriddleKeyMap() {
    override val isPrimary: Boolean = true
    override val keyboardHandedness = KeyboardHandedness(hasHandedness = true, pivotColumn = 1)
    override val defalultSize: IntSize = DEFAULT_SIZE
    override val layerKind: LayerKind = LayerKind.ALPHA
    override val languageTag = LanguageTag.ENGLISH

    val englishA = button_0_0.replaceGesturesWith(
        gesture(CLICK, simpleInput, threeStrings = caseSensitive("a")),
        gesture(HOLD, simpleInput, oneString = "1"),
        gesture(SWIPE_UP_LEFT, cycleAccentCharacters, AppSymbol.CYCLE_ACCENTED_CHARS),
        gesture(SWIPE_RIGHT, simpleInput, threeStrings = caseSensitive("-", "÷", "÷")),
        gesture(BOOMERANG_RIGHT, simpleInput, threeStrings = reversedCase("÷", "-", "-")),
        gesture(SWIPE_DOWN_LEFT, simpleInput, threeStrings = caseSensitive("$")),
        gesture(BOOMERANG_DOWN_LEFT, simpleInput, threeStrings = reversedCase("¢")),
        gesture(SWIPE_DOWN_RIGHT, simpleInput, threeStrings = caseSensitive("v")),
        gesture(BOOMERANG_DOWN_RIGHT, simpleInput, threeStrings = reversedCase("V")),
        gesture(CIRCLE_CLOCKWISE, simpleInput, threeStrings = reversedCase("A")),
        gesture(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeStrings = reversedCase("A")),
    )

    val englishN = button_0_1.replaceGesturesWith(
        gesture(BOOMERANG_UP, simpleInput, threeStrings = caseSensitive("ˇ")),
        gesture(CLICK, simpleInput, threeStrings = caseSensitive("n")),
        gesture(HOLD, simpleInput, threeStrings = triple("2")),
        gesture(SWIPE_UP_LEFT, simpleInput, threeStrings = caseSensitive("`", "\\", "\\")),
        gesture(BOOMERANG_UP_LEFT, simpleInput, threeStrings = caseSensitive("\\", "`", "`")),
        gesture(SWIPE_UP, simpleInput, threeStrings = caseSensitive("^", "’", "’")),
        gesture(SWIPE_UP_RIGHT, simpleInput, threeStrings = Triple("^", "’", "’")),
        gesture(SWIPE_RIGHT, simpleInput, threeStrings = caseSensitive("!", "¡", "¡")),
        gesture(BOOMERANG_RIGHT, simpleInput, threeStrings = caseSensitive("¡", "!", "!")),
        gesture(SWIPE_DOWN_RIGHT, simpleInput, threeStrings = caseSensitive("/", "—", "—")),
        gesture(BOOMERANG_DOWN_RIGHT, simpleInput, threeStrings = caseSensitive("—", "/", "/")),
        gesture(SWIPE_DOWN, simpleInput, threeStrings = caseSensitive("l")),
        gesture(BOOMERANG_DOWN, simpleInput, threeStrings = reversedCase("L")),
        gesture(SWIPE_DOWN_LEFT, simpleInput, threeStrings = caseSensitive("/", "—", "—")),
        gesture(BOOMERANG_DOWN_LEFT, simpleInput, threeStrings = caseSensitive("—", "/", "/")),
        gesture(SWIPE_LEFT, simpleInput, threeStrings = caseSensitive("+", "×", "×")),
        gesture(BOOMERANG_LEFT, simpleInput, threeStrings = caseSensitive("×", "+", "+")),
        gesture(CIRCLE_CLOCKWISE, simpleInput, threeStrings = reversedCase("n")),
        gesture(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeStrings = reversedCase("n")),
    )


    val englishI = button_0_2.replaceGesturesWith(
        gesture(CLICK, simpleInput, threeStrings = caseSensitive("i")),
        gesture(SWIPE_DOWN_RIGHT, simpleInput, threeStrings = caseSensitive("€", "£", "£")),
        gesture(BOOMERANG_DOWN_RIGHT, simpleInput, threeStrings = caseSensitive("£", "€", "€")),
        gesture(SWIPE_DOWN, simpleInput, threeStrings = caseSensitive("=", "±", "±")),
        gesture(BOOMERANG_DOWN, simpleInput, threeStrings = caseSensitive("±", "=", "=")),
        gesture(SWIPE_DOWN_LEFT, simpleInput, threeStrings = caseSensitive("x")),
        gesture(BOOMERANG_DOWN_LEFT, simpleInput, threeStrings = reversedCase("X")),
        gesture(SWIPE_LEFT, simpleInput, threeStrings = caseSensitive("?", "¿", "¿")),
        gesture(BOOMERANG_LEFT, simpleInput, threeStrings = caseSensitive("¿", "?", "?")),
        gesture(CIRCLE_CLOCKWISE, simpleInput, threeStrings = reversedCase("I")),
        gesture(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeStrings = reversedCase("I")),
        gesture(HOLD, simpleInput, threeStrings = triple("3")),
    )

    val englishH = button_1_0.replaceGesturesWith(
        gesture(SWIPE_UP, cycleShiftState, threeStrings = shiftLegends, modifierThemeSet = shiftIndicatorColorTheme, isIndicator = true),
        gesture(SWIPE_DOWN, cycleShiftState, threeStrings = unShiftLegends, modifierThemeSet = unShiftIndicator, isIndicator = true),
        gesture(SWIPE_UP_LEFT, simpleInput, threeStrings = Triple("{", "}", "}")),
        gesture(BOOMERANG_UP_LEFT, simpleInput, threeStrings = Triple("}", "{", "{")),
        gesture(BOOMERANG_UP, toggleCapslock),
        gesture(SWIPE_UP_RIGHT, simpleInput, threeStrings = Triple("%", "‰", "‰")),
        gesture(BOOMERANG_UP_RIGHT, simpleInput, threeStrings = Triple("‰", "%", "%")),
        gesture(SWIPE_RIGHT, simpleInput, threeStrings = caseSensitive("k")),
        gesture(BOOMERANG_RIGHT, simpleInput, threeStrings = reversedCase("K")),
        gesture(SWIPE_DOWN_RIGHT, simpleInput, threeStrings = Triple("_", "¬", "¬")),
        gesture(BOOMERANG_DOWN_RIGHT, simpleInput, threeStrings = Triple("¬", "_", "_")),
        gesture(SWIPE_DOWN_LEFT, simpleInput, threeStrings = Triple("[", "]", "]")),
        gesture(BOOMERANG_DOWN_LEFT, simpleInput, threeStrings = Triple("]", "[", "[")),
        gesture(SWIPE_LEFT, simpleInput, threeStrings = Triple("(", ")", ")")),
        gesture(BOOMERANG_LEFT, simpleInput, threeStrings = Triple(")", "(", "(")),
        gesture(CIRCLE_CLOCKWISE, simpleInput, threeStrings = reversedCase("H")),
        gesture(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeStrings = reversedCase("H")),
        gesture(HOLD, simpleInput, threeStrings = caseSensitive("4")),
        gesture(CLICK, simpleInput, threeStrings = caseSensitive("h")),
    )

    val englishO = button_1_1.replaceGesturesWith(
        gesture(CLICK, simpleInput, threeStrings = caseSensitive("o")),
        gesture(SWIPE_UP_LEFT, simpleInput, threeStrings = caseSensitive("q")),
        gesture(BOOMERANG_UP_LEFT, simpleInput, threeStrings = reversedCase("q")),
        gesture(SWIPE_UP, simpleInput, threeStrings = caseSensitive("u")),
        gesture(BOOMERANG_UP, simpleInput, threeStrings = reversedCase("u")),
        gesture(SWIPE_UP_RIGHT, simpleInput, threeStrings = caseSensitive("p")),
        gesture(BOOMERANG_UP_RIGHT, simpleInput, threeStrings = reversedCase("P")),
        gesture(SWIPE_RIGHT, simpleInput, threeStrings = caseSensitive("b")),
        gesture(BOOMERANG_RIGHT, simpleInput, threeStrings = reversedCase("B")),
        gesture(SWIPE_DOWN_RIGHT, simpleInput, threeStrings = caseSensitive("j")),
        gesture(BOOMERANG_DOWN_RIGHT, simpleInput, threeStrings = reversedCase("J")),
        gesture(SWIPE_DOWN, simpleInput, threeStrings = caseSensitive("d")),
        gesture(BOOMERANG_DOWN, simpleInput, threeStrings = reversedCase("D")),
        gesture(SWIPE_DOWN_LEFT, simpleInput, threeStrings = caseSensitive("g")),
        gesture(BOOMERANG_DOWN_LEFT, simpleInput, threeStrings = reversedCase("G")),
        gesture(SWIPE_LEFT, simpleInput, threeStrings = caseSensitive("c")),
        gesture(BOOMERANG_LEFT, simpleInput, threeStrings = reversedCase("C")),
        gesture(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeStrings = reversedCase("O")),
        gesture(CIRCLE_CLOCKWISE, simpleInput, threeStrings = reversedCase("O")),
        gesture(HOLD, simpleInput, threeStrings = reversedCase("5")),
    )

    val englishR = button_1_2.replaceGesturesWith(
        gesture(SWIPE_UP, cycleShiftState, threeStrings = shiftLegends, modifierThemeSet = shiftIndicatorColorTheme, isIndicator = true),
        //        gesture(SWIPE_DOWN, releaseShift, threeStrings = caseSensitive("", "▼", "▼")),
        gesture(SWIPE_DOWN, cycleShiftState, threeStrings = unShiftLegends, isIndicator = true),

        gesture(SWIPE_UP_LEFT, simpleInput, threeStrings = caseSensitive("|", "\\", "\\")),
        gesture(BOOMERANG_UP_LEFT, simpleInput, threeStrings = caseSensitive("\\", "|", "|")),
        gesture(BOOMERANG_UP, toggleCapslock),
        gesture(SWIPE_UP_RIGHT, simpleInput, threeStrings = caseSensitive("}", "{", "{")),
        gesture(BOOMERANG_UP_RIGHT, simpleInput, threeStrings = caseSensitive("{", "}", "}")),
        gesture(SWIPE_RIGHT, simpleInput, threeStrings = caseSensitive(")", "(", "(")),
        gesture(BOOMERANG_RIGHT, simpleInput, threeStrings = caseSensitive("(", ")", ")")),
        gesture(SWIPE_DOWN_RIGHT, simpleInput, threeStrings = caseSensitive("]", "[", "[")),
        gesture(BOOMERANG_DOWN_RIGHT, simpleInput, threeStrings = caseSensitive("[", "]", "]")),
        gesture(BOOMERANG_DOWN, simpleInput, threeStrings = caseSensitive("—")),
        gesture(SWIPE_DOWN_LEFT, simpleInput, oneString = "@"),
        gesture(BOOMERANG_DOWN_LEFT, simpleInput, threeStrings = Triple("ª", "@", "@")),
        gesture(SWIPE_LEFT, simpleInput, threeStrings = caseSensitive("m")),
        gesture(BOOMERANG_LEFT, simpleInput, threeStrings = reversedCase("M")),
        gesture(CIRCLE_CLOCKWISE, simpleInput, threeStrings = reversedCase("R")),
        gesture(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeStrings = reversedCase("R")),
        gesture(CLICK, simpleInput, threeStrings = caseSensitive("r")),
        gesture(HOLD, simpleInput, threeStrings = reversedCase("6")),
    )

    val englishT = button_2_0.replaceGesturesWith(
        gesture(CLICK, simpleInput, threeStrings = caseSensitive("t")),
        gesture(HOLD, simpleInput, threeStrings = reversedCase("7")),
        gesture(SWIPE_UP_LEFT, simpleInput, threeStrings = caseSensitive("~")),
        gesture(SWIPE_UP, simpleInput, threeStrings = Triple("¨", "¨", "¨")),
        gesture(BOOMERANG_UP, simpleInput, threeStrings = Triple("˝", "¨", "¨")),
        gesture(SWIPE_UP_RIGHT, simpleInput, threeStrings = caseSensitive("y")),
        gesture(BOOMERANG_UP_RIGHT, simpleInput, threeStrings = reversedCase("Y")),
        gesture(SWIPE_RIGHT, simpleInput, threeStrings = Triple("*", "†", "†")),
        gesture(BOOMERANG_RIGHT, simpleInput, threeStrings = Triple("†", "*", "*")),
        gesture(SWIPE_LEFT, simpleInput, threeStrings = Triple("<", ">", ">")),
        gesture(BOOMERANG_LEFT, simpleInput, threeStrings = Triple(">", "<", "<")),
        gesture(SWIPE_DOWN_RIGHT, sendTab /*pressKey(KEYCODE_TAB)*/, threeStrings = triple(TAB_RIGHT)),
        gesture(BOOMERANG_DOWN_RIGHT, pressTab /*pressKey(KEYCODE_TAB)*/, threeStrings = triple(TAB_RIGHT)),
        gesture(CIRCLE_CLOCKWISE, simpleInput, threeStrings = reversedCase("T")),
        gesture(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeStrings = reversedCase("T")),
        //        gesture(SWIPE_DOWN, repeatPreviousOperation, appSymbol = AppSymbol.REPEAT),
    )

    val englishE = button_2_1.replaceGesturesWith(
        gesture(SWIPE_UP_LEFT, simpleInput, threeStrings = caseSensitive("\"")),
        gesture(BOOMERANG_UP_LEFT, simpleInput, threeStrings = caseSensitive(" ")),
        gesture(SWIPE_UP, simpleInput, threeStrings = caseSensitive("w")),
        gesture(BOOMERANG_UP, simpleInput, threeStrings = reversedCase("W")),
        gesture(SWIPE_UP_RIGHT, simpleInput, threeStrings = caseSensitive("\'")),
        gesture(BOOMERANG_UP_RIGHT, simpleInput, threeStrings = caseSensitive("\'")),
        gesture(SWIPE_RIGHT, simpleInput, threeStrings = caseSensitive("z")),
        gesture(BOOMERANG_RIGHT, simpleInput, threeStrings = reversedCase("Z")),
        gesture(SWIPE_DOWN_RIGHT, simpleInput, threeStrings = caseSensitive(":")),
        gesture(BOOMERANG_RIGHT, simpleInput, threeStrings = caseSensitive(";")),
        gesture(BOOMERANG_DOWN_RIGHT, simpleInput, threeStrings = caseSensitive(",")),
        gesture(SWIPE_DOWN, simpleInput, threeStrings = caseSensitive(".", "…", "…")),
        gesture(BOOMERANG_DOWN, simpleInput, threeStrings = caseSensitive("…", ".", ".")),
        gesture(SWIPE_DOWN_LEFT, simpleInput, threeStrings = caseSensitive(",")),
        gesture(BOOMERANG_DOWN_LEFT, simpleInput, threeStrings = caseSensitive(",")),
        gesture(SWIPE_LEFT, simpleInput, threeStrings = caseSensitive(",")),
        gesture(BOOMERANG_LEFT, simpleInput, threeStrings = caseSensitive(",")),
        gesture(CIRCLE_CLOCKWISE, simpleInput, threeStrings = reversedCase("E")),
        gesture(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeStrings = reversedCase("E")),
        gesture(HOLD, simpleInput, threeStrings = caseSensitive("8")),
        gesture(CLICK, simpleInput, threeStrings = caseSensitive("e")),
        gesture(HOLD, simpleInput, threeStrings = reversedCase("8")),
    )

    val englishS = button_2_2.replaceGesturesWith(
        gesture(CLICK, simpleInput, threeStrings = caseSensitive("s")),
        gesture(SWIPE_UP_LEFT, simpleInput, threeStrings = caseSensitive("f")),
        gesture(BOOMERANG_UP_LEFT, simpleInput, threeStrings = reversedCase("F")),
        gesture(SWIPE_UP, simpleInput, threeStrings = caseSensitive("&")),
        gesture(SWIPE_RIGHT, simpleInput, threeStrings = caseSensitive(">")),
        gesture(SWIPE_UP_RIGHT, simpleInput, threeStrings = caseSensitive("°")),
        gesture(SWIPE_DOWN_LEFT, simpleInput, threeStrings = caseSensitive(";")),
        gesture(SWIPE_DOWN, sendNewLineFeed, appSymbol = AppSymbol.NEW_LINE),
        gesture(BOOMERANG_DOWN_LEFT, simpleInput, threeStrings = caseSensitive(";")),
        gesture(SWIPE_LEFT, simpleInput, threeStrings = caseSensitive("#")),
        gesture(BOOMERANG_LEFT, simpleInput, threeStrings = caseSensitive(" ")),
        gesture(CIRCLE_CLOCKWISE, simpleInput, threeStrings = reversedCase("S")),
        gesture(CIRCLE_ANTI_CLOCKWISE, simpleInput, threeStrings = reversedCase("S")),
        gesture(HOLD, simpleInput, threeStrings = caseSensitive("9")),
        gesture(CLICK, simpleInput, threeStrings = caseSensitive("s")),
        gesture(HOLD, simpleInput, threeStrings = reversedCase("9")),
    )

    override fun allMappings() = mutableSetOf(
        englishA, englishN, englishI, cursorControlButton,
        englishH, englishO, englishR, NumericLayerToggle,
        englishT, englishE, englishS, backspace,
        space, enter
    )
}