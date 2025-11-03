package com.galacticware.griddle.domain.design.implementation.alpha4x4alnum7x4

import com.galacticware.griddle.domain.design.implementation.alpha4x4alnum7x4.dsl.invoke
import com.galacticware.griddle.domain.gesture.Click
import com.galacticware.griddle.domain.gesture.Hold
import com.galacticware.griddle.domain.gesture.LongSwipeEast
import com.galacticware.griddle.domain.gesture.LongSwipeNorth
import com.galacticware.griddle.domain.gesture.LongSwipeNorthWest
import com.galacticware.griddle.domain.gesture.LongSwipeSouthEast
import com.galacticware.griddle.domain.gesture.LongSwipeWest
import com.galacticware.griddle.domain.gesture.ShortBoomerangEast
import com.galacticware.griddle.domain.gesture.ShortBoomerangNorth
import com.galacticware.griddle.domain.gesture.ShortBoomerangNorthEast
import com.galacticware.griddle.domain.gesture.ShortBoomerangNorthWest
import com.galacticware.griddle.domain.gesture.ShortBoomerangSouth
import com.galacticware.griddle.domain.gesture.ShortBoomerangSouthEast
import com.galacticware.griddle.domain.gesture.ShortBoomerangSouthWest
import com.galacticware.griddle.domain.gesture.ShortBoomerangWest
import com.galacticware.griddle.domain.gesture.ShortSwipeEast
import com.galacticware.griddle.domain.gesture.ShortSwipeNorth
import com.galacticware.griddle.domain.gesture.ShortSwipeNorthEast
import com.galacticware.griddle.domain.gesture.ShortSwipeNorthWest
import com.galacticware.griddle.domain.gesture.ShortSwipeSouth
import com.galacticware.griddle.domain.gesture.ShortSwipeSouthEast
import com.galacticware.griddle.domain.gesture.ShortSwipeSouthWest
import com.galacticware.griddle.domain.gesture.ShortSwipeWest
import com.galacticware.griddle.domain.gesture.SmallCircleClockwise
import com.galacticware.griddle.domain.gesture.SmallCircleCounterClockwise
import com.galacticware.griddle.domain.model.type.base.tag.AppSymbol
import com.galacticware.griddle.domain.model.type.base.tag.ButtonPaletteTemplate.MultiColorButtonTemplate
import com.galacticware.griddle.domain.model.type.base.tag.GesturePaletteTemplate.CentralAlphanumericColor
import com.galacticware.griddle.domain.model.type.base.tag.GesturePaletteTemplate.NoColor
import com.galacticware.griddle.domain.model.type.base.tag.GesturePaletteTemplate.NonCentralAlphanumericColor
import com.galacticware.griddle.domain.model.type.base.tag.GesturePaletteTemplate.PeripheralSymbolicColor
import com.galacticware.griddle.domain.util.caseSensitive
import com.galacticware.griddle.domain.util.reversedCase
import com.galacticware.griddle.domain.util.triple
import com.galacticware.griddle.domain.operation.implementation.noargs.accentchars.CycleAccentCharacters
import com.galacticware.griddle.domain.operation.implementation.noargs.cursorcontrol.MoveDown
import com.galacticware.griddle.domain.operation.implementation.noargs.cursorcontrol.MovePageDown
import com.galacticware.griddle.domain.operation.implementation.noargs.cursorcontrol.MovePageUp
import com.galacticware.griddle.domain.operation.implementation.noargs.cursorcontrol.MoveUp
import com.galacticware.griddle.domain.operation.implementation.someargs.changemodifier.ChangeModifierArgs.Companion.ForwardCycleShift
import com.galacticware.griddle.domain.operation.implementation.someargs.changemodifier.ChangeModifierArgs.Companion.ReleaseShift
import com.galacticware.griddle.domain.operation.implementation.someargs.changemodifier.ChangeModifierArgs.Companion.ToggleShiftRepeat
import com.galacticware.griddle.domain.operation.implementation.someargs.presskey.child.PressTab
import com.galacticware.griddle.domain.operation.implementation.someargs.presskey.child.PressUnTab
import com.galacticware.griddle.domain.operation.implementation.someargs.presskey.child.SendNewLineFeed

val englishA by lazy {
    MultiColorButtonTemplate("English A", rowStart = 0, colStart = 0, rowSpan = 1, colSpan = 1) {
        use(CentralAlphanumericColor) {
            +Click.insertText(unpressedStateText = "a")
        }
        use(NonCentralAlphanumericColor) {
            +ShortSwipeSouthEast.insertText(caseSensitive("v"))
        }
        use(PeripheralSymbolicColor) {
            +ShortSwipeNorthWest.assign(CycleAccentCharacters, AppSymbol.CYCLE_ACCENTED_CHARS_LEGEND)
            +ShortSwipeEast.insertText(caseSensitive("-", "÷", "÷"))
            +ShortSwipeSouthWest.insertText(caseSensitive("$"))
        }
        use(NoColor) {
            +LongSwipeNorthWest.assign(CycleAccentCharacters, AppSymbol.CYCLE_ACCENTED_CHARS_LEGEND)
            +LongSwipeSouthEast.insertText(caseSensitive("v"))
            +ShortBoomerangEast.insertText(reversedCase("÷", "-", "-"))
            +ShortBoomerangSouthWest.insertText(reversedCase("¢"))
            +ShortBoomerangSouthEast.insertText(reversedCase("V"))
            +SmallCircleClockwise.insertText(reversedCase("1"))
            +SmallCircleCounterClockwise.insertText(reversedCase("A"))
            +Hold.insertText("1")
        }
    }
}

val englishN by lazy {
    MultiColorButtonTemplate("English N", rowStart = 0, colStart = 1, rowSpan = 1, colSpan = 1) {
        use(CentralAlphanumericColor) {
            +Click.insertText(unpressedStateText = "n")
        }
        use(NonCentralAlphanumericColor) {
            +ShortSwipeSouth.insertText(caseSensitive("l"))
        }
        use(PeripheralSymbolicColor) {
            +ShortSwipeNorthWest.insertText(caseSensitive("`", "\\", "\\"))
            +ShortSwipeNorth.insertText(caseSensitive("^", "’", "’"))
            +ShortSwipeNorthEast.insertText(Triple("^", "’", "’"))
            +ShortSwipeEast.insertText(caseSensitive("!", "¡", "¡"))
            +ShortSwipeSouthEast.insertText(caseSensitive("/", "—", "—"))
            +ShortSwipeSouthWest.insertText(caseSensitive("/", "—", "—"))
            +ShortSwipeWest.insertText(caseSensitive("+", "×", "×"))
        }
        use(NoColor) {
            +ShortBoomerangNorth.insertText(caseSensitive("ˇ"))
            +ShortBoomerangNorthWest.insertText(caseSensitive("\\", "`", "`"))
            +ShortBoomerangEast.insertText(caseSensitive("¡", "!", "!"))
            +ShortBoomerangSouthEast.insertText(caseSensitive("—", "/", "/"))
            +ShortBoomerangSouth.insertText(reversedCase("L"))
            +ShortBoomerangSouthWest.insertText(caseSensitive("—", "/", "/"))
            +ShortBoomerangWest.insertText(caseSensitive("×", "+", "+"))
            +SmallCircleClockwise.insertText(reversedCase("2"))
            +SmallCircleCounterClockwise.insertText(reversedCase("N"))
            +Hold.insertText("2")
        }
    }
}

val englishI by lazy {
    MultiColorButtonTemplate("English I", rowStart = 0, colStart = 2, rowSpan = 1, colSpan = 1) {
        use(CentralAlphanumericColor) {
            +Click.insertText(unpressedStateText = "i")
        }
        use(NonCentralAlphanumericColor) {
            +ShortSwipeSouthWest.insertText("x")
        }
        use(PeripheralSymbolicColor) {
            +ShortSwipeSouthEast.insertText(caseSensitive("€", "£", "£"))
            +ShortSwipeSouth.insertText(caseSensitive("=", "±", "±"))
            +ShortSwipeWest.insertText(caseSensitive("?", "¿", "¿"))
            +ShortSwipeNorth.repeat(MoveUp)
        }
        use(NoColor) {
            +ShortBoomerangNorth.repeat(MovePageUp)
            +ShortBoomerangSouthEast.insertText(caseSensitive("£", "€", "€"))
            +ShortBoomerangSouth.insertText(caseSensitive("±", "=", "="))
            +ShortBoomerangSouthWest.insertText(reversedCase("X"))
            +ShortBoomerangWest.insertText(caseSensitive("¿", "?", "?"))
            +SmallCircleClockwise.insertText(reversedCase("3"))
            +SmallCircleCounterClockwise.insertText(reversedCase("I"))
            +Hold.insertText("3")
        }
    }
}

val englishH by lazy {
    MultiColorButtonTemplate("English H", rowStart = 1, colStart = 0, rowSpan = 1, colSpan = 1) {
        use(CentralAlphanumericColor) {
            +Click.insertText(unpressedStateText = "h")
        }
        use(NonCentralAlphanumericColor) {
            +ShortSwipeEast.insertText(caseSensitive("k"))
            +LongSwipeEast.insertText(caseSensitive("k"))
        }
        use(PeripheralSymbolicColor) {
            +ShortSwipeNorth.changeModifier(ForwardCycleShift)
            +ShortSwipeSouth.changeModifier(ReleaseShift)
            +ShortSwipeNorthWest.insertText(Triple("{", "}", "}"))
            +ShortSwipeNorthEast.insertText(Triple("%", "‰", "‰"))
            +ShortSwipeSouthEast.insertText(Triple("_", "¬", "¬"))
            +ShortSwipeSouthWest.insertText(Triple("[", "]", "]"))
            +ShortSwipeWest.insertText(Triple("(", ")", ")"))
        }
        use(NoColor) {
            +ShortBoomerangNorthWest.insertText(Triple("}", "{", "{"))
            +ShortBoomerangNorth.changeModifier(ToggleShiftRepeat)
            +ShortBoomerangNorthEast.insertText(Triple("‰", "%", "%"))
            +ShortBoomerangEast.insertText(reversedCase("K"))
            +ShortBoomerangSouthEast.insertText(Triple("¬", "_", "_"))
            +ShortBoomerangSouthWest.insertText(Triple("]", "[", "["))
            +ShortBoomerangWest.insertText(Triple(")", "(", "("))
            +LongSwipeNorth.changeModifier(ForwardCycleShift)
            +SmallCircleClockwise.insertText(reversedCase("4"))
            +SmallCircleCounterClockwise.insertText(reversedCase("H"))
            +Hold.insertText("4")
        }
    }
}

val englishO by lazy {
    MultiColorButtonTemplate("English O", rowStart = 1, colStart = 1, rowSpan = 1, colSpan = 1,) {
        use(CentralAlphanumericColor) {
            +Click.insertText(unpressedStateText = "o")
        }
        use(NonCentralAlphanumericColor) {
            +ShortSwipeNorthWest.insertText(caseSensitive("q"))
            +ShortSwipeNorth.insertText(caseSensitive("u"))
            +ShortSwipeNorthEast.insertText(caseSensitive("p"))
            +ShortSwipeEast.insertText(caseSensitive("b"))
            +ShortSwipeSouthEast.insertText(caseSensitive("j"))
            +ShortSwipeSouth.insertText(caseSensitive("d"))
            +ShortSwipeSouthWest.insertText(caseSensitive("g"))
            +ShortSwipeWest.insertText(caseSensitive("c"))
        }
        use(NoColor) {
            +ShortBoomerangNorthWest.insertText(reversedCase("q"))
            +ShortBoomerangNorth.insertText(reversedCase("u"))
            +ShortBoomerangNorthEast.insertText(reversedCase("P"))
            +ShortBoomerangEast.insertText(reversedCase("B"))
            +ShortBoomerangSouthEast.insertText(reversedCase("J"))
            +ShortBoomerangSouth.insertText(reversedCase("D"))
            +ShortBoomerangSouthWest.insertText(reversedCase("G"))
            +ShortBoomerangWest.insertText(reversedCase("C"))
            +SmallCircleCounterClockwise.insertText(reversedCase("O"))
            +SmallCircleClockwise.insertText(reversedCase("5"))
            +Hold.insertText("5")
        }
    }
}

val englishR by lazy {
    MultiColorButtonTemplate("English R", rowStart = 1, colStart = 2, rowSpan = 1, colSpan = 1) {
        use(CentralAlphanumericColor) {
            +Click.insertText(unpressedStateText = "r")
        }
        use(NonCentralAlphanumericColor) {
            +ShortSwipeWest.insertText(caseSensitive("m"))
            +LongSwipeWest.insertText(caseSensitive("m"))
        }
        use(PeripheralSymbolicColor) {
            +ShortSwipeNorthWest.insertText(unpressedStateText = "")
            +ShortSwipeNorth.changeModifier(ForwardCycleShift)
            +ShortSwipeSouth.changeModifier(ReleaseShift)
            +ShortSwipeNorthWest.insertText(caseSensitive("|", "\\", "\\"))
            +ShortBoomerangNorthWest.insertText(caseSensitive("\\", "|", "|"))
            +ShortBoomerangNorth.changeModifier(ToggleShiftRepeat)
            +ShortSwipeNorthEast.insertText(caseSensitive("}", "{", "{"))
            +ShortBoomerangNorthEast.insertText(caseSensitive("{", "}", "}"))
            +ShortSwipeEast.insertText(caseSensitive(")", "(", "("))
            +ShortBoomerangEast.insertText(caseSensitive("(", ")", ")"))
            +ShortSwipeSouthEast.insertText(caseSensitive("]", "[", "["))
            +ShortBoomerangSouthEast.insertText(caseSensitive("[", "]", "]"))
            +ShortBoomerangSouth.insertText(caseSensitive("—"))
            +ShortSwipeSouthWest.insertText(unpressedStateText = "@")
        }
        use(NoColor) {
            +ShortBoomerangSouthWest.insertText(Triple("ª", "@", "@"))
            +ShortBoomerangWest.insertText(reversedCase("M"))
            +SmallCircleClockwise.insertText(reversedCase("6"))
            +SmallCircleCounterClockwise.insertText(reversedCase("R"))
            +Hold.insertText("6")
        }
    }
}

val englishT by lazy {
    MultiColorButtonTemplate("English T", rowStart = 2, colStart = 0, rowSpan = 1, colSpan = 1) {
        use(CentralAlphanumericColor) {
            +Click.insertText(unpressedStateText = "t")
        }
        use(NonCentralAlphanumericColor) {
            +ShortSwipeSouthEast.insertText(caseSensitive("v"))
            +ShortSwipeNorthEast.insertText(caseSensitive("y"))
        }
        use(PeripheralSymbolicColor) {
            +ShortSwipeNorthWest.insertText("~")
            +ShortSwipeNorth.insertText(Triple("¨", "¨", "¨"))
            +ShortSwipeSouth.repeat(SendNewLineFeed)
            +ShortSwipeEast.insertText(Triple("*", "†", "†"))
            +ShortSwipeWest.insertText(Triple("<", ">", ">"))
            +ShortSwipeSouthEast.repeat(PressTab)
            +ShortSwipeSouthWest.assign(PressUnTab)
        }
        use(NoColor) {
            +ShortBoomerangNorth.insertText("˝", "¨", "¨")
            +ShortBoomerangNorthEast.insertText(reversedCase("Y"))
            +ShortBoomerangEast.insertText("†", "*", "*")
            +ShortBoomerangWest.insertText(">", "<", "<")
            +ShortBoomerangSouthEast.repeat(PressUnTab)
            +ShortBoomerangSouthWest.repeat(PressTab)
            +SmallCircleClockwise.insertText(reversedCase("7"))
            +SmallCircleCounterClockwise.insertText(reversedCase("T"))
            +Hold.insertText("7")
        }
    }
}

val englishE by lazy {
    MultiColorButtonTemplate("English E", rowStart = 2, colStart = 1, rowSpan = 1, colSpan = 1) {
        use(CentralAlphanumericColor) {
            +Click.insertText(unpressedStateText = "e")
        }
        use(NonCentralAlphanumericColor) {
            +ShortSwipeNorth.insertText(caseSensitive("w"))
            +ShortSwipeEast.insertText(caseSensitive("z"))
        }
        use(PeripheralSymbolicColor) {
            +ShortSwipeNorthWest.insertText(caseSensitive("\""))
            +ShortSwipeNorthEast.insertText(caseSensitive("\'"))
            +ShortSwipeSouthEast.insertText(caseSensitive(":"))
            +ShortSwipeSouth.insertText(".", "…", "…")
            +ShortSwipeSouthWest.insertText(caseSensitive(","))
            +ShortSwipeWest.insertText(caseSensitive(","))
        }
        use(NoColor) {
            +ShortBoomerangNorthWest.insertText(caseSensitive(" "))
            +ShortBoomerangNorth.insertText(reversedCase("W"))
            +ShortBoomerangNorthEast.insertText(caseSensitive("\'"))
            +ShortBoomerangEast.insertText(reversedCase("Z"))
            +ShortBoomerangSouthEast.insertText(caseSensitive(","))
            +ShortBoomerangSouth.insertText("…", ".", ".")
            +ShortBoomerangSouthWest.insertText(caseSensitive(","))
            +ShortBoomerangWest.insertText(caseSensitive(","))
            +SmallCircleClockwise.insertText(reversedCase("8"))
            +SmallCircleCounterClockwise.insertText(reversedCase("E"))
            +Hold.insertText("8")
        }
    }
}

val englishS by lazy {
    MultiColorButtonTemplate("English S", rowStart = 2, colStart = 2, rowSpan = 1, colSpan = 1) {
        use(CentralAlphanumericColor) {
            +Click.insertText(unpressedStateText = "s")
        }
        use(NonCentralAlphanumericColor) {
            +ShortSwipeNorthWest.insertText(caseSensitive("f"))
        }
        use(PeripheralSymbolicColor) {
            +ShortSwipeNorth.insertText(caseSensitive("&"))
            +ShortSwipeEast.insertText(">", ">", "<")
            +ShortSwipeNorthEast.insertText(caseSensitive("°"))
            +ShortSwipeSouthWest.insertText(caseSensitive(";"))
            +ShortSwipeWest.insertText(caseSensitive("#"))
            +ShortSwipeSouth.repeat(MoveDown)
        }
        use(NoColor) {
            +ShortBoomerangNorthWest.insertText(reversedCase("F"))
            +ShortBoomerangSouthWest.insertText(caseSensitive(";"))
            +ShortBoomerangWest.insertText(caseSensitive(" "))
            +ShortBoomerangSouth.repeat(MovePageDown)
            +ShortBoomerangEast.insertText("<", "<" ,">")
            +SmallCircleClockwise.insertText(reversedCase("9"))
            +SmallCircleCounterClockwise.insertText(reversedCase("S"))
            +Hold.insertText("9")
        }
    }
}