package com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.english

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
import com.galacticware.griddle.domain.layer.LayerKind
import com.galacticware.griddle.domain.operation.CycleAccentCharacters
import com.galacticware.griddle.domain.operation.PressTab
import com.galacticware.griddle.domain.operation.SendNewLineFeed
import com.galacticware.griddle.domain.operation.SendTab
import com.galacticware.griddle.domain.operation.ApplyShift
import com.galacticware.griddle.domain.operation.SimpleInput
import com.galacticware.griddle.domain.operation.ToggleCapslock
import com.galacticware.griddle.domain.util.caseSensitive
import com.galacticware.griddle.domain.util.reversedCase
import com.galacticware.griddle.domain.util.triple
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.GriddleLayerBuilder
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

object GriddleEnglishLayerBuilder: GriddleLayerBuilder() {
    override val isPrimary: Boolean = true
    override val keyboardHandedness = KeyboardHandedness(hasHandedness = true, pivotColumn = 1)
    override val defalultSize: IntSize = DEFAULT_SIZE
    override val layerKind: LayerKind = LayerKind.ALPHA
    override val languageTag = LanguageTag.ENGLISH

    val englishA = button_0_0.replaceGesturesWith(
        gesture(CLICK, SimpleInput, threeStrings = caseSensitive("a")),
        gesture(HOLD, SimpleInput, oneString = "1"),
        gesture(SWIPE_UP_LEFT, CycleAccentCharacters, AppSymbol.CYCLE_ACCENTED_CHARS),
        gesture(SWIPE_RIGHT, SimpleInput, threeStrings = caseSensitive("-", "÷", "÷")),
        gesture(BOOMERANG_RIGHT, SimpleInput, threeStrings = reversedCase("÷", "-", "-")),
        gesture(SWIPE_DOWN_LEFT, SimpleInput, threeStrings = caseSensitive("$")),
        gesture(BOOMERANG_DOWN_LEFT, SimpleInput, threeStrings = reversedCase("¢")),
        gesture(SWIPE_DOWN_RIGHT, SimpleInput, threeStrings = caseSensitive("v")),
        gesture(BOOMERANG_DOWN_RIGHT, SimpleInput, threeStrings = reversedCase("V")),
        gesture(CIRCLE_CLOCKWISE, SimpleInput, threeStrings = reversedCase("A")),
        gesture(CIRCLE_ANTI_CLOCKWISE, SimpleInput, threeStrings = reversedCase("A")),
    )

    val englishN = button_0_1.replaceGesturesWith(
        gesture(BOOMERANG_UP, SimpleInput, threeStrings = caseSensitive("ˇ")),
        gesture(CLICK, SimpleInput, threeStrings = caseSensitive("n")),
        gesture(HOLD, SimpleInput, threeStrings = triple("2")),
        gesture(SWIPE_UP_LEFT, SimpleInput, threeStrings = caseSensitive("`", "\\", "\\")),
        gesture(BOOMERANG_UP_LEFT, SimpleInput, threeStrings = caseSensitive("\\", "`", "`")),
        gesture(SWIPE_UP, SimpleInput, threeStrings = caseSensitive("^", "’", "’")),
        gesture(SWIPE_UP_RIGHT, SimpleInput, threeStrings = Triple("^", "’", "’")),
        gesture(SWIPE_RIGHT, SimpleInput, threeStrings = caseSensitive("!", "¡", "¡")),
        gesture(BOOMERANG_RIGHT, SimpleInput, threeStrings = caseSensitive("¡", "!", "!")),
        gesture(SWIPE_DOWN_RIGHT, SimpleInput, threeStrings = caseSensitive("/", "—", "—")),
        gesture(BOOMERANG_DOWN_RIGHT, SimpleInput, threeStrings = caseSensitive("—", "/", "/")),
        gesture(SWIPE_DOWN, SimpleInput, threeStrings = caseSensitive("l")),
        gesture(BOOMERANG_DOWN, SimpleInput, threeStrings = reversedCase("L")),
        gesture(SWIPE_DOWN_LEFT, SimpleInput, threeStrings = caseSensitive("/", "—", "—")),
        gesture(BOOMERANG_DOWN_LEFT, SimpleInput, threeStrings = caseSensitive("—", "/", "/")),
        gesture(SWIPE_LEFT, SimpleInput, threeStrings = caseSensitive("+", "×", "×")),
        gesture(BOOMERANG_LEFT, SimpleInput, threeStrings = caseSensitive("×", "+", "+")),
        gesture(CIRCLE_CLOCKWISE, SimpleInput, threeStrings = reversedCase("n")),
        gesture(CIRCLE_ANTI_CLOCKWISE, SimpleInput, threeStrings = reversedCase("n")),
    )


    val englishI = button_0_2.replaceGesturesWith(
        gesture(CLICK, SimpleInput, threeStrings = caseSensitive("i")),
        gesture(SWIPE_DOWN_RIGHT, SimpleInput, threeStrings = caseSensitive("€", "£", "£")),
        gesture(BOOMERANG_DOWN_RIGHT, SimpleInput, threeStrings = caseSensitive("£", "€", "€")),
        gesture(SWIPE_DOWN, SimpleInput, threeStrings = caseSensitive("=", "±", "±")),
        gesture(BOOMERANG_DOWN, SimpleInput, threeStrings = caseSensitive("±", "=", "=")),
        gesture(SWIPE_DOWN_LEFT, SimpleInput, threeStrings = caseSensitive("x")),
        gesture(BOOMERANG_DOWN_LEFT, SimpleInput, threeStrings = reversedCase("X")),
        gesture(SWIPE_LEFT, SimpleInput, threeStrings = caseSensitive("?", "¿", "¿")),
        gesture(BOOMERANG_LEFT, SimpleInput, threeStrings = caseSensitive("¿", "?", "?")),
        gesture(CIRCLE_CLOCKWISE, SimpleInput, threeStrings = reversedCase("I")),
        gesture(CIRCLE_ANTI_CLOCKWISE, SimpleInput, threeStrings = reversedCase("I")),
        gesture(HOLD, SimpleInput, threeStrings = triple("3")),
    )

    val englishH = button_1_0.replaceGesturesWith(
        gesture(SWIPE_UP, ApplyShift, threeStrings = shiftLegends, modifierThemeSet = shiftIndicatorColorTheme, isIndicator = true),
        gesture(SWIPE_DOWN, ApplyShift, threeStrings = unShiftLegends, modifierThemeSet = unShiftIndicator, isIndicator = true),
        gesture(SWIPE_UP_LEFT, SimpleInput, threeStrings = Triple("{", "}", "}")),
        gesture(BOOMERANG_UP_LEFT, SimpleInput, threeStrings = Triple("}", "{", "{")),
        gesture(BOOMERANG_UP, ToggleCapslock),
        gesture(SWIPE_UP_RIGHT, SimpleInput, threeStrings = Triple("%", "‰", "‰")),
        gesture(BOOMERANG_UP_RIGHT, SimpleInput, threeStrings = Triple("‰", "%", "%")),
        gesture(SWIPE_RIGHT, SimpleInput, threeStrings = caseSensitive("k")),
        gesture(BOOMERANG_RIGHT, SimpleInput, threeStrings = reversedCase("K")),
        gesture(SWIPE_DOWN_RIGHT, SimpleInput, threeStrings = Triple("_", "¬", "¬")),
        gesture(BOOMERANG_DOWN_RIGHT, SimpleInput, threeStrings = Triple("¬", "_", "_")),
        gesture(SWIPE_DOWN_LEFT, SimpleInput, threeStrings = Triple("[", "]", "]")),
        gesture(BOOMERANG_DOWN_LEFT, SimpleInput, threeStrings = Triple("]", "[", "[")),
        gesture(SWIPE_LEFT, SimpleInput, threeStrings = Triple("(", ")", ")")),
        gesture(BOOMERANG_LEFT, SimpleInput, threeStrings = Triple(")", "(", "(")),
        gesture(CIRCLE_CLOCKWISE, SimpleInput, threeStrings = reversedCase("H")),
        gesture(CIRCLE_ANTI_CLOCKWISE, SimpleInput, threeStrings = reversedCase("H")),
        gesture(HOLD, SimpleInput, threeStrings = caseSensitive("4")),
        gesture(CLICK, SimpleInput, threeStrings = caseSensitive("h")),
    )

    val englishO = button_1_1.replaceGesturesWith(
        gesture(CLICK, SimpleInput, threeStrings = caseSensitive("o")),
        gesture(SWIPE_UP_LEFT, SimpleInput, threeStrings = caseSensitive("q")),
        gesture(BOOMERANG_UP_LEFT, SimpleInput, threeStrings = reversedCase("q")),
        gesture(SWIPE_UP, SimpleInput, threeStrings = caseSensitive("u")),
        gesture(BOOMERANG_UP, SimpleInput, threeStrings = reversedCase("u")),
        gesture(SWIPE_UP_RIGHT, SimpleInput, threeStrings = caseSensitive("p")),
        gesture(BOOMERANG_UP_RIGHT, SimpleInput, threeStrings = reversedCase("P")),
        gesture(SWIPE_RIGHT, SimpleInput, threeStrings = caseSensitive("b")),
        gesture(BOOMERANG_RIGHT, SimpleInput, threeStrings = reversedCase("B")),
        gesture(SWIPE_DOWN_RIGHT, SimpleInput, threeStrings = caseSensitive("j")),
        gesture(BOOMERANG_DOWN_RIGHT, SimpleInput, threeStrings = reversedCase("J")),
        gesture(SWIPE_DOWN, SimpleInput, threeStrings = caseSensitive("d")),
        gesture(BOOMERANG_DOWN, SimpleInput, threeStrings = reversedCase("D")),
        gesture(SWIPE_DOWN_LEFT, SimpleInput, threeStrings = caseSensitive("g")),
        gesture(BOOMERANG_DOWN_LEFT, SimpleInput, threeStrings = reversedCase("G")),
        gesture(SWIPE_LEFT, SimpleInput, threeStrings = caseSensitive("c")),
        gesture(BOOMERANG_LEFT, SimpleInput, threeStrings = reversedCase("C")),
        gesture(CIRCLE_ANTI_CLOCKWISE, SimpleInput, threeStrings = reversedCase("O")),
        gesture(CIRCLE_CLOCKWISE, SimpleInput, threeStrings = reversedCase("O")),
        gesture(HOLD, SimpleInput, threeStrings = reversedCase("5")),
    )

    val englishR = button_1_2.replaceGesturesWith(
        gesture(SWIPE_UP, ApplyShift, threeStrings = shiftLegends, modifierThemeSet = shiftIndicatorColorTheme, isIndicator = true),
        //        gesture(SWIPE_DOWN, releaseShift, threeStrings = caseSensitive("", "▼", "▼")),
        gesture(SWIPE_DOWN, ApplyShift, threeStrings = unShiftLegends, isIndicator = true),

        gesture(SWIPE_UP_LEFT, SimpleInput, threeStrings = caseSensitive("|", "\\", "\\")),
        gesture(BOOMERANG_UP_LEFT, SimpleInput, threeStrings = caseSensitive("\\", "|", "|")),
        gesture(BOOMERANG_UP, ToggleCapslock),
        gesture(SWIPE_UP_RIGHT, SimpleInput, threeStrings = caseSensitive("}", "{", "{")),
        gesture(BOOMERANG_UP_RIGHT, SimpleInput, threeStrings = caseSensitive("{", "}", "}")),
        gesture(SWIPE_RIGHT, SimpleInput, threeStrings = caseSensitive(")", "(", "(")),
        gesture(BOOMERANG_RIGHT, SimpleInput, threeStrings = caseSensitive("(", ")", ")")),
        gesture(SWIPE_DOWN_RIGHT, SimpleInput, threeStrings = caseSensitive("]", "[", "[")),
        gesture(BOOMERANG_DOWN_RIGHT, SimpleInput, threeStrings = caseSensitive("[", "]", "]")),
        gesture(BOOMERANG_DOWN, SimpleInput, threeStrings = caseSensitive("—")),
        gesture(SWIPE_DOWN_LEFT, SimpleInput, oneString = "@"),
        gesture(BOOMERANG_DOWN_LEFT, SimpleInput, threeStrings = Triple("ª", "@", "@")),
        gesture(SWIPE_LEFT, SimpleInput, threeStrings = caseSensitive("m")),
        gesture(BOOMERANG_LEFT, SimpleInput, threeStrings = reversedCase("M")),
        gesture(CIRCLE_CLOCKWISE, SimpleInput, threeStrings = reversedCase("R")),
        gesture(CIRCLE_ANTI_CLOCKWISE, SimpleInput, threeStrings = reversedCase("R")),
        gesture(CLICK, SimpleInput, threeStrings = caseSensitive("r")),
        gesture(HOLD, SimpleInput, threeStrings = reversedCase("6")),
    )

    val englishT = button_2_0.replaceGesturesWith(
        gesture(CLICK, SimpleInput, threeStrings = caseSensitive("t")),
        gesture(HOLD, SimpleInput, threeStrings = reversedCase("7")),
        gesture(SWIPE_UP_LEFT, SimpleInput, threeStrings = caseSensitive("~")),
        gesture(SWIPE_UP, SimpleInput, threeStrings = Triple("¨", "¨", "¨")),
        gesture(BOOMERANG_UP, SimpleInput, threeStrings = Triple("˝", "¨", "¨")),
        gesture(SWIPE_UP_RIGHT, SimpleInput, threeStrings = caseSensitive("y")),
        gesture(BOOMERANG_UP_RIGHT, SimpleInput, threeStrings = reversedCase("Y")),
        gesture(SWIPE_RIGHT, SimpleInput, threeStrings = Triple("*", "†", "†")),
        gesture(BOOMERANG_RIGHT, SimpleInput, threeStrings = Triple("†", "*", "*")),
        gesture(SWIPE_LEFT, SimpleInput, threeStrings = Triple("<", ">", ">")),
        gesture(BOOMERANG_LEFT, SimpleInput, threeStrings = Triple(">", "<", "<")),
        gesture(SWIPE_DOWN_RIGHT, SendTab /*pressKey(KEYCODE_TAB)*/, threeStrings = triple(TAB_RIGHT)),
        gesture(BOOMERANG_DOWN_RIGHT, PressTab /*pressKey(KEYCODE_TAB)*/, threeStrings = triple(TAB_RIGHT)),
        gesture(CIRCLE_CLOCKWISE, SimpleInput, threeStrings = reversedCase("T")),
        gesture(CIRCLE_ANTI_CLOCKWISE, SimpleInput, threeStrings = reversedCase("T")),
        //        gesture(SWIPE_DOWN, repeatPreviousOperation, appSymbol = AppSymbol.REPEAT),
    )

    val englishE = button_2_1.replaceGesturesWith(
        gesture(SWIPE_UP_LEFT, SimpleInput, threeStrings = caseSensitive("\"")),
        gesture(BOOMERANG_UP_LEFT, SimpleInput, threeStrings = caseSensitive(" ")),
        gesture(SWIPE_UP, SimpleInput, threeStrings = caseSensitive("w")),
        gesture(BOOMERANG_UP, SimpleInput, threeStrings = reversedCase("W")),
        gesture(SWIPE_UP_RIGHT, SimpleInput, threeStrings = caseSensitive("\'")),
        gesture(BOOMERANG_UP_RIGHT, SimpleInput, threeStrings = caseSensitive("\'")),
        gesture(SWIPE_RIGHT, SimpleInput, threeStrings = caseSensitive("z")),
        gesture(BOOMERANG_RIGHT, SimpleInput, threeStrings = reversedCase("Z")),
        gesture(SWIPE_DOWN_RIGHT, SimpleInput, threeStrings = caseSensitive(":")),
        gesture(BOOMERANG_RIGHT, SimpleInput, threeStrings = caseSensitive(";")),
        gesture(BOOMERANG_DOWN_RIGHT, SimpleInput, threeStrings = caseSensitive(",")),
        gesture(SWIPE_DOWN, SimpleInput, threeStrings = caseSensitive(".", "…", "…")),
        gesture(BOOMERANG_DOWN, SimpleInput, threeStrings = caseSensitive("…", ".", ".")),
        gesture(SWIPE_DOWN_LEFT, SimpleInput, threeStrings = caseSensitive(",")),
        gesture(BOOMERANG_DOWN_LEFT, SimpleInput, threeStrings = caseSensitive(",")),
        gesture(SWIPE_LEFT, SimpleInput, threeStrings = caseSensitive(",")),
        gesture(BOOMERANG_LEFT, SimpleInput, threeStrings = caseSensitive(",")),
        gesture(CIRCLE_CLOCKWISE, SimpleInput, threeStrings = reversedCase("E")),
        gesture(CIRCLE_ANTI_CLOCKWISE, SimpleInput, threeStrings = reversedCase("E")),
        gesture(HOLD, SimpleInput, threeStrings = caseSensitive("8")),
        gesture(CLICK, SimpleInput, threeStrings = caseSensitive("e")),
        gesture(HOLD, SimpleInput, threeStrings = reversedCase("8")),
    )

    val englishS = button_2_2.replaceGesturesWith(
        gesture(CLICK, SimpleInput, threeStrings = caseSensitive("s")),
        gesture(SWIPE_UP_LEFT, SimpleInput, threeStrings = caseSensitive("f")),
        gesture(BOOMERANG_UP_LEFT, SimpleInput, threeStrings = reversedCase("F")),
        gesture(SWIPE_UP, SimpleInput, threeStrings = caseSensitive("&")),
        gesture(SWIPE_RIGHT, SimpleInput, threeStrings = caseSensitive(">")),
        gesture(SWIPE_UP_RIGHT, SimpleInput, threeStrings = caseSensitive("°")),
        gesture(SWIPE_DOWN_LEFT, SimpleInput, threeStrings = caseSensitive(";")),
        gesture(SWIPE_DOWN, SendNewLineFeed, appSymbol = AppSymbol.NEW_LINE),
        gesture(BOOMERANG_DOWN_LEFT, SimpleInput, threeStrings = caseSensitive(";")),
        gesture(SWIPE_LEFT, SimpleInput, threeStrings = caseSensitive("#")),
        gesture(BOOMERANG_LEFT, SimpleInput, threeStrings = caseSensitive(" ")),
        gesture(CIRCLE_CLOCKWISE, SimpleInput, threeStrings = reversedCase("S")),
        gesture(CIRCLE_ANTI_CLOCKWISE, SimpleInput, threeStrings = reversedCase("S")),
        gesture(HOLD, SimpleInput, threeStrings = caseSensitive("9")),
        gesture(CLICK, SimpleInput, threeStrings = caseSensitive("s")),
        gesture(HOLD, SimpleInput, threeStrings = reversedCase("9")),
    )

    override fun allMappings() = mutableSetOf(
        englishA, englishN, englishI, cursorControlButton,
        englishH, englishO, englishR, NumericLayerToggle,
        englishT, englishE, englishS, backspace,
        space, enter
    )
}