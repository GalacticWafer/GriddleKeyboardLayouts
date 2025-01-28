package com.galacticware.griddle.model.keyboard.definition.designs.griddle.english

import androidx.compose.ui.unit.IntSize
import com.galacticware.griddle.model.gesture.GestureType.BOOMERANG_DOWN
import com.galacticware.griddle.model.gesture.GestureType.BOOMERANG_DOWN_LEFT
import com.galacticware.griddle.model.gesture.GestureType.BOOMERANG_DOWN_RIGHT
import com.galacticware.griddle.model.gesture.GestureType.BOOMERANG_LEFT
import com.galacticware.griddle.model.gesture.GestureType.BOOMERANG_RIGHT
import com.galacticware.griddle.model.gesture.GestureType.BOOMERANG_UP
import com.galacticware.griddle.model.gesture.GestureType.BOOMERANG_UP_LEFT
import com.galacticware.griddle.model.gesture.GestureType.BOOMERANG_UP_RIGHT
import com.galacticware.griddle.model.gesture.GestureType.CIRCLE_ANTI_CLOCKWISE
import com.galacticware.griddle.model.gesture.GestureType.CIRCLE_CLOCKWISE
import com.galacticware.griddle.model.gesture.GestureType.CLICK
import com.galacticware.griddle.model.gesture.GestureType.HOLD
import com.galacticware.griddle.model.gesture.GestureType.SWIPE_DOWN
import com.galacticware.griddle.model.gesture.GestureType.SWIPE_DOWN_LEFT
import com.galacticware.griddle.model.gesture.GestureType.SWIPE_DOWN_RIGHT
import com.galacticware.griddle.model.gesture.GestureType.SWIPE_LEFT
import com.galacticware.griddle.model.gesture.GestureType.SWIPE_RIGHT
import com.galacticware.griddle.model.gesture.GestureType.SWIPE_UP
import com.galacticware.griddle.model.gesture.GestureType.SWIPE_UP_LEFT
import com.galacticware.griddle.model.gesture.GestureType.SWIPE_UP_RIGHT
import com.galacticware.griddle.model.keybinder.AppSymbol
import com.galacticware.griddle.model.keybinder.AppSymbol.TAB_RIGHT
import com.galacticware.griddle.model.keybinder.KeyBinder.Companion.changeModifier
import com.galacticware.griddle.model.keybinder.KeyBinder.Companion.bindGesture
import com.galacticware.griddle.model.keyboard.KeyboardHandedness
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.builder.NumericLayerToggle
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.builder.backspace
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.builder.button_0_0
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.builder.button_0_1
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.builder.button_0_2
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.builder.button_1_0
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.builder.button_1_1
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.builder.button_1_2
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.builder.button_2_0
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.builder.button_2_1
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.builder.button_2_2
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.builder.cursorControlButton
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.builder.enter
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.builder.space
import com.galacticware.griddle.model.language.LanguageTag
import com.galacticware.griddle.model.layer.LayerKind
import com.galacticware.griddle.model.operation.implementation.noargs.accentchars.CycleAccentCharacters
import com.galacticware.griddle.model.operation.implementation.noargs.simpleinput.SimpleInput
import com.galacticware.griddle.model.operation.implementation.someargs.changemodifier.base.ChangeModifierArgs.Companion.ForwardCycleShift
import com.galacticware.griddle.model.operation.implementation.someargs.changemodifier.base.ChangeModifierArgs.Companion.ReleaseShift
import com.galacticware.griddle.model.operation.implementation.someargs.changemodifier.base.ChangeModifierArgs.Companion.ToggleShiftRepeat
import com.galacticware.griddle.model.operation.implementation.someargs.presskey.PressTab
import com.galacticware.griddle.model.operation.implementation.someargs.presskey.SendNewLineFeed
import com.galacticware.griddle.model.operation.implementation.someargs.presskey.SendTab
import com.galacticware.griddle.model.util.caseSensitive
import com.galacticware.griddle.model.util.reversedCase
import com.galacticware.griddle.model.util.triple
import com.galacticware.griddle.model.keyboard.definition.theme.DEFAULT_SIZE
import com.galacticware.griddle.model.layer.GriddleLayerBuilder

object GriddleEnglishLayerBuilder: GriddleLayerBuilder() {
    override val isPrimary: Boolean = true
    override val keyboardHandedness = KeyboardHandedness(hasHandedness = true, pivotColumn = 1)
    override val defalultSize: IntSize = DEFAULT_SIZE
    override val layerKind: LayerKind = LayerKind.ALPHA
    override val languageTag = LanguageTag.ENGLISH

    val englishA = button_0_0.replaceGesturesWith(
        bindGesture(CLICK, SimpleInput, threeStrings = caseSensitive("a")),
        bindGesture(HOLD, SimpleInput, label = "1"),
        bindGesture(SWIPE_UP_LEFT, CycleAccentCharacters, AppSymbol.CYCLE_ACCENTED_CHARS),
        bindGesture(SWIPE_RIGHT, SimpleInput, threeStrings = caseSensitive("-", "÷", "÷")),
        bindGesture(BOOMERANG_RIGHT, SimpleInput, threeStrings = reversedCase("÷", "-", "-")),
        bindGesture(SWIPE_DOWN_LEFT, SimpleInput, threeStrings = caseSensitive("$")),
        bindGesture(BOOMERANG_DOWN_LEFT, SimpleInput, threeStrings = reversedCase("¢")),
        bindGesture(SWIPE_DOWN_RIGHT, SimpleInput, threeStrings = caseSensitive("v")),
        bindGesture(BOOMERANG_DOWN_RIGHT, SimpleInput, threeStrings = reversedCase("V")),
        bindGesture(CIRCLE_CLOCKWISE, SimpleInput, threeStrings = reversedCase("A")),
        bindGesture(CIRCLE_ANTI_CLOCKWISE, SimpleInput, threeStrings = reversedCase("A")),
    )

    val englishN = button_0_1.replaceGesturesWith(
        bindGesture(BOOMERANG_UP, SimpleInput, threeStrings = caseSensitive("ˇ")),
        bindGesture(CLICK, SimpleInput, threeStrings = caseSensitive("n")),
        bindGesture(HOLD, SimpleInput, threeStrings = triple("2")),
        bindGesture(SWIPE_UP_LEFT, SimpleInput, threeStrings = caseSensitive("`", "\\", "\\")),
        bindGesture(BOOMERANG_UP_LEFT, SimpleInput, threeStrings = caseSensitive("\\", "`", "`")),
        bindGesture(SWIPE_UP, SimpleInput, threeStrings = caseSensitive("^", "’", "’")),
        bindGesture(SWIPE_UP_RIGHT, SimpleInput, threeStrings = Triple("^", "’", "’")),
        bindGesture(SWIPE_RIGHT, SimpleInput, threeStrings = caseSensitive("!", "¡", "¡")),
        bindGesture(BOOMERANG_RIGHT, SimpleInput, threeStrings = caseSensitive("¡", "!", "!")),
        bindGesture(SWIPE_DOWN_RIGHT, SimpleInput, threeStrings = caseSensitive("/", "—", "—")),
        bindGesture(BOOMERANG_DOWN_RIGHT, SimpleInput, threeStrings = caseSensitive("—", "/", "/")),
        bindGesture(SWIPE_DOWN, SimpleInput, threeStrings = caseSensitive("l")),
        bindGesture(BOOMERANG_DOWN, SimpleInput, threeStrings = reversedCase("L")),
        bindGesture(SWIPE_DOWN_LEFT, SimpleInput, threeStrings = caseSensitive("/", "—", "—")),
        bindGesture(BOOMERANG_DOWN_LEFT, SimpleInput, threeStrings = caseSensitive("—", "/", "/")),
        bindGesture(SWIPE_LEFT, SimpleInput, threeStrings = caseSensitive("+", "×", "×")),
        bindGesture(BOOMERANG_LEFT, SimpleInput, threeStrings = caseSensitive("×", "+", "+")),
        bindGesture(CIRCLE_CLOCKWISE, SimpleInput, threeStrings = reversedCase("n")),
        bindGesture(CIRCLE_ANTI_CLOCKWISE, SimpleInput, threeStrings = reversedCase("n")),
    )


    val englishI = button_0_2.replaceGesturesWith(
        bindGesture(CLICK, SimpleInput, threeStrings = caseSensitive("i")),
        bindGesture(SWIPE_DOWN_RIGHT, SimpleInput, threeStrings = caseSensitive("€", "£", "£")),
        bindGesture(BOOMERANG_DOWN_RIGHT, SimpleInput, threeStrings = caseSensitive("£", "€", "€")),
        bindGesture(SWIPE_DOWN, SimpleInput, threeStrings = caseSensitive("=", "±", "±")),
        bindGesture(BOOMERANG_DOWN, SimpleInput, threeStrings = caseSensitive("±", "=", "=")),
        bindGesture(SWIPE_DOWN_LEFT, SimpleInput, threeStrings = caseSensitive("x")),
        bindGesture(BOOMERANG_DOWN_LEFT, SimpleInput, threeStrings = reversedCase("X")),
        bindGesture(SWIPE_LEFT, SimpleInput, threeStrings = caseSensitive("?", "¿", "¿")),
        bindGesture(BOOMERANG_LEFT, SimpleInput, threeStrings = caseSensitive("¿", "?", "?")),
        bindGesture(CIRCLE_CLOCKWISE, SimpleInput, threeStrings = reversedCase("I")),
        bindGesture(CIRCLE_ANTI_CLOCKWISE, SimpleInput, threeStrings = reversedCase("I")),
        bindGesture(HOLD, SimpleInput, threeStrings = triple("3")),
    )

    val englishH = button_1_0.replaceGesturesWith(
        changeModifier(SWIPE_UP, ForwardCycleShift),
        changeModifier(SWIPE_DOWN, ReleaseShift),
        bindGesture(SWIPE_UP_LEFT, SimpleInput, threeStrings = Triple("{", "}", "}")),
        bindGesture(BOOMERANG_UP_LEFT, SimpleInput, threeStrings = Triple("}", "{", "{")),
        changeModifier(BOOMERANG_UP, ToggleShiftRepeat),
        bindGesture(SWIPE_UP_RIGHT, SimpleInput, threeStrings = Triple("%", "‰", "‰")),
        bindGesture(BOOMERANG_UP_RIGHT, SimpleInput, threeStrings = Triple("‰", "%", "%")),
        bindGesture(SWIPE_RIGHT, SimpleInput, threeStrings = caseSensitive("k")),
        bindGesture(BOOMERANG_RIGHT, SimpleInput, threeStrings = reversedCase("K")),
        bindGesture(SWIPE_DOWN_RIGHT, SimpleInput, threeStrings = Triple("_", "¬", "¬")),
        bindGesture(BOOMERANG_DOWN_RIGHT, SimpleInput, threeStrings = Triple("¬", "_", "_")),
        bindGesture(SWIPE_DOWN_LEFT, SimpleInput, threeStrings = Triple("[", "]", "]")),
        bindGesture(BOOMERANG_DOWN_LEFT, SimpleInput, threeStrings = Triple("]", "[", "[")),
        bindGesture(SWIPE_LEFT, SimpleInput, threeStrings = Triple("(", ")", ")")),
        bindGesture(BOOMERANG_LEFT, SimpleInput, threeStrings = Triple(")", "(", "(")),
        bindGesture(CIRCLE_CLOCKWISE, SimpleInput, threeStrings = reversedCase("H")),
        bindGesture(CIRCLE_ANTI_CLOCKWISE, SimpleInput, threeStrings = reversedCase("H")),
        bindGesture(HOLD, SimpleInput, threeStrings = caseSensitive("4")),
        bindGesture(CLICK, SimpleInput, threeStrings = caseSensitive("h")),
    )

    val englishO = button_1_1.replaceGesturesWith(
        bindGesture(CLICK, SimpleInput, threeStrings = caseSensitive("o")),
        bindGesture(SWIPE_UP_LEFT, SimpleInput, threeStrings = caseSensitive("q")),
        bindGesture(BOOMERANG_UP_LEFT, SimpleInput, threeStrings = reversedCase("q")),
        bindGesture(SWIPE_UP, SimpleInput, threeStrings = caseSensitive("u")),
        bindGesture(BOOMERANG_UP, SimpleInput, threeStrings = reversedCase("u")),
        bindGesture(SWIPE_UP_RIGHT, SimpleInput, threeStrings = caseSensitive("p")),
        bindGesture(BOOMERANG_UP_RIGHT, SimpleInput, threeStrings = reversedCase("P")),
        bindGesture(SWIPE_RIGHT, SimpleInput, threeStrings = caseSensitive("b")),
        bindGesture(BOOMERANG_RIGHT, SimpleInput, threeStrings = reversedCase("B")),
        bindGesture(SWIPE_DOWN_RIGHT, SimpleInput, threeStrings = caseSensitive("j")),
        bindGesture(BOOMERANG_DOWN_RIGHT, SimpleInput, threeStrings = reversedCase("J")),
        bindGesture(SWIPE_DOWN, SimpleInput, threeStrings = caseSensitive("d")),
        bindGesture(BOOMERANG_DOWN, SimpleInput, threeStrings = reversedCase("D")),
        bindGesture(SWIPE_DOWN_LEFT, SimpleInput, threeStrings = caseSensitive("g")),
        bindGesture(BOOMERANG_DOWN_LEFT, SimpleInput, threeStrings = reversedCase("G")),
        bindGesture(SWIPE_LEFT, SimpleInput, threeStrings = caseSensitive("c")),
        bindGesture(BOOMERANG_LEFT, SimpleInput, threeStrings = reversedCase("C")),
        bindGesture(CIRCLE_ANTI_CLOCKWISE, SimpleInput, threeStrings = reversedCase("O")),
        bindGesture(CIRCLE_CLOCKWISE, SimpleInput, threeStrings = reversedCase("O")),
        bindGesture(HOLD, SimpleInput, threeStrings = reversedCase("5")),
    )

    val englishR = button_1_2.replaceGesturesWith(
        changeModifier(SWIPE_UP, ForwardCycleShift),
        //        gesture(SWIPE_DOWN, releaseShift, threeStrings = caseSensitive("", "▼", "▼")),
        changeModifier(SWIPE_DOWN, ReleaseShift),

        bindGesture(SWIPE_UP_LEFT, SimpleInput, threeStrings = caseSensitive("|", "\\", "\\")),
        bindGesture(BOOMERANG_UP_LEFT, SimpleInput, threeStrings = caseSensitive("\\", "|", "|")),
        changeModifier(BOOMERANG_UP, ToggleShiftRepeat),
        bindGesture(SWIPE_UP_RIGHT, SimpleInput, threeStrings = caseSensitive("}", "{", "{")),
        bindGesture(BOOMERANG_UP_RIGHT, SimpleInput, threeStrings = caseSensitive("{", "}", "}")),
        bindGesture(SWIPE_RIGHT, SimpleInput, threeStrings = caseSensitive(")", "(", "(")),
        bindGesture(BOOMERANG_RIGHT, SimpleInput, threeStrings = caseSensitive("(", ")", ")")),
        bindGesture(SWIPE_DOWN_RIGHT, SimpleInput, threeStrings = caseSensitive("]", "[", "[")),
        bindGesture(BOOMERANG_DOWN_RIGHT, SimpleInput, threeStrings = caseSensitive("[", "]", "]")),
        bindGesture(BOOMERANG_DOWN, SimpleInput, threeStrings = caseSensitive("—")),
        bindGesture(SWIPE_DOWN_LEFT, SimpleInput, label = "@"),
        bindGesture(BOOMERANG_DOWN_LEFT, SimpleInput, threeStrings = Triple("ª", "@", "@")),
        bindGesture(SWIPE_LEFT, SimpleInput, threeStrings = caseSensitive("m")),
        bindGesture(BOOMERANG_LEFT, SimpleInput, threeStrings = reversedCase("M")),
        bindGesture(CIRCLE_CLOCKWISE, SimpleInput, threeStrings = reversedCase("R")),
        bindGesture(CIRCLE_ANTI_CLOCKWISE, SimpleInput, threeStrings = reversedCase("R")),
        bindGesture(CLICK, SimpleInput, threeStrings = caseSensitive("r")),
        bindGesture(HOLD, SimpleInput, threeStrings = reversedCase("6")),
    )

    val englishT = button_2_0.replaceGesturesWith(
        bindGesture(CLICK, SimpleInput, threeStrings = caseSensitive("t")),
        bindGesture(HOLD, SimpleInput, threeStrings = reversedCase("7")),
        bindGesture(SWIPE_UP_LEFT, SimpleInput, threeStrings = caseSensitive("~")),
        bindGesture(SWIPE_UP, SimpleInput, threeStrings = Triple("¨", "¨", "¨")),
        bindGesture(BOOMERANG_UP, SimpleInput, threeStrings = Triple("˝", "¨", "¨")),
        bindGesture(SWIPE_UP_RIGHT, SimpleInput, threeStrings = caseSensitive("y")),
        bindGesture(BOOMERANG_UP_RIGHT, SimpleInput, threeStrings = reversedCase("Y")),
        bindGesture(SWIPE_RIGHT, SimpleInput, threeStrings = Triple("*", "†", "†")),
        bindGesture(BOOMERANG_RIGHT, SimpleInput, threeStrings = Triple("†", "*", "*")),
        bindGesture(SWIPE_LEFT, SimpleInput, threeStrings = Triple("<", ">", ">")),
        bindGesture(BOOMERANG_LEFT, SimpleInput, threeStrings = Triple(">", "<", "<")),
        bindGesture(
            SWIPE_DOWN_RIGHT,
            SendTab /*PressKey, keycode = KEYCODE_TAB*/,
            threeStrings = triple(TAB_RIGHT)
        ),
        bindGesture(
            BOOMERANG_DOWN_RIGHT,
            PressTab /*PressKey, keycode = KEYCODE_TAB*/,
            threeStrings = triple(TAB_RIGHT)
        ),
        bindGesture(CIRCLE_CLOCKWISE, SimpleInput, threeStrings = reversedCase("T")),
        bindGesture(CIRCLE_ANTI_CLOCKWISE, SimpleInput, threeStrings = reversedCase("T")),
        //        gesture(SWIPE_DOWN, repeatPreviousOperation, appSymbol = AppSymbol.REPEAT),
    )

    val englishE = button_2_1.replaceGesturesWith(
        bindGesture(SWIPE_UP_LEFT, SimpleInput, threeStrings = caseSensitive("\"")),
        bindGesture(BOOMERANG_UP_LEFT, SimpleInput, threeStrings = caseSensitive(" ")),
        bindGesture(SWIPE_UP, SimpleInput, threeStrings = caseSensitive("w")),
        bindGesture(BOOMERANG_UP, SimpleInput, threeStrings = reversedCase("W")),
        bindGesture(SWIPE_UP_RIGHT, SimpleInput, threeStrings = caseSensitive("\'")),
        bindGesture(BOOMERANG_UP_RIGHT, SimpleInput, threeStrings = caseSensitive("\'")),
        bindGesture(SWIPE_RIGHT, SimpleInput, threeStrings = caseSensitive("z")),
        bindGesture(BOOMERANG_RIGHT, SimpleInput, threeStrings = reversedCase("Z")),
        bindGesture(SWIPE_DOWN_RIGHT, SimpleInput, threeStrings = caseSensitive(":")),
        bindGesture(BOOMERANG_RIGHT, SimpleInput, threeStrings = caseSensitive(";")),
        bindGesture(BOOMERANG_DOWN_RIGHT, SimpleInput, threeStrings = caseSensitive(",")),
        bindGesture(SWIPE_DOWN, SimpleInput, threeStrings = caseSensitive(".", "…", "…")),
        bindGesture(BOOMERANG_DOWN, SimpleInput, threeStrings = caseSensitive("…", ".", ".")),
        bindGesture(SWIPE_DOWN_LEFT, SimpleInput, threeStrings = caseSensitive(",")),
        bindGesture(BOOMERANG_DOWN_LEFT, SimpleInput, threeStrings = caseSensitive(",")),
        bindGesture(SWIPE_LEFT, SimpleInput, threeStrings = caseSensitive(",")),
        bindGesture(BOOMERANG_LEFT, SimpleInput, threeStrings = caseSensitive(",")),
        bindGesture(CIRCLE_CLOCKWISE, SimpleInput, threeStrings = reversedCase("E")),
        bindGesture(CIRCLE_ANTI_CLOCKWISE, SimpleInput, threeStrings = reversedCase("E")),
        bindGesture(HOLD, SimpleInput, threeStrings = caseSensitive("8")),
        bindGesture(CLICK, SimpleInput, threeStrings = caseSensitive("e")),
        bindGesture(HOLD, SimpleInput, threeStrings = reversedCase("8")),
    )

    val englishS = button_2_2.replaceGesturesWith(
        bindGesture(CLICK, SimpleInput, threeStrings = caseSensitive("s")),
        bindGesture(SWIPE_UP_LEFT, SimpleInput, threeStrings = caseSensitive("f")),
        bindGesture(BOOMERANG_UP_LEFT, SimpleInput, threeStrings = reversedCase("F")),
        bindGesture(SWIPE_UP, SimpleInput, threeStrings = caseSensitive("&")),
        bindGesture(SWIPE_RIGHT, SimpleInput, threeStrings = caseSensitive(">")),
        bindGesture(SWIPE_UP_RIGHT, SimpleInput, threeStrings = caseSensitive("°")),
        bindGesture(SWIPE_DOWN_LEFT, SimpleInput, threeStrings = caseSensitive(";")),
        bindGesture(SWIPE_DOWN, SendNewLineFeed, appSymbol = AppSymbol.NEW_LINE),
        bindGesture(BOOMERANG_DOWN_LEFT, SimpleInput, threeStrings = caseSensitive(";")),
        bindGesture(SWIPE_LEFT, SimpleInput, threeStrings = caseSensitive("#")),
        bindGesture(BOOMERANG_LEFT, SimpleInput, threeStrings = caseSensitive(" ")),
        bindGesture(CIRCLE_CLOCKWISE, SimpleInput, threeStrings = reversedCase("S")),
        bindGesture(CIRCLE_ANTI_CLOCKWISE, SimpleInput, threeStrings = reversedCase("S")),
        bindGesture(HOLD, SimpleInput, threeStrings = caseSensitive("9")),
        bindGesture(CLICK, SimpleInput, threeStrings = caseSensitive("s")),
        bindGesture(HOLD, SimpleInput, threeStrings = reversedCase("9")),
    )

    override fun buttonBuilders() = mutableSetOf(
        com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.GriddleEnglishLayerBuilder.englishA,
        com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.GriddleEnglishLayerBuilder.englishN,
        com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.GriddleEnglishLayerBuilder.englishI,
        cursorControlButton,
        com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.GriddleEnglishLayerBuilder.englishH,
        com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.GriddleEnglishLayerBuilder.englishO,
        com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.GriddleEnglishLayerBuilder.englishR,
        NumericLayerToggle,
        com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.GriddleEnglishLayerBuilder.englishT,
        com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.GriddleEnglishLayerBuilder.englishE,
        com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.GriddleEnglishLayerBuilder.englishS,
        backspace,
        space,
        enter
    )
}