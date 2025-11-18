package com.galacticware.griddle.domain.design.implementation.alpha4x4alnum7x4

import com.galacticware.griddle.domain.design.base.gesture.Click
import com.galacticware.griddle.domain.design.base.gesture.Hold
import com.galacticware.griddle.domain.design.base.gesture.LongSwipeEast
import com.galacticware.griddle.domain.design.base.gesture.LongSwipeNorth
import com.galacticware.griddle.domain.design.base.gesture.LongSwipeWest
import com.galacticware.griddle.domain.design.base.gesture.ShortBoomerangEast
import com.galacticware.griddle.domain.design.base.gesture.ShortBoomerangNorth
import com.galacticware.griddle.domain.design.base.gesture.ShortBoomerangNorthEast
import com.galacticware.griddle.domain.design.base.gesture.ShortBoomerangNorthWest
import com.galacticware.griddle.domain.design.base.gesture.ShortBoomerangSouth
import com.galacticware.griddle.domain.design.base.gesture.ShortBoomerangSouthEast
import com.galacticware.griddle.domain.design.base.gesture.ShortBoomerangSouthWest
import com.galacticware.griddle.domain.design.base.gesture.ShortBoomerangWest
import com.galacticware.griddle.domain.design.base.gesture.ShortSwipeEast
import com.galacticware.griddle.domain.design.base.gesture.ShortSwipeNorth
import com.galacticware.griddle.domain.design.base.gesture.ShortSwipeNorthEast
import com.galacticware.griddle.domain.design.base.gesture.ShortSwipeNorthWest
import com.galacticware.griddle.domain.design.base.gesture.ShortSwipeSouth
import com.galacticware.griddle.domain.design.base.gesture.ShortSwipeSouthEast
import com.galacticware.griddle.domain.design.base.gesture.ShortSwipeSouthWest
import com.galacticware.griddle.domain.design.base.gesture.ShortSwipeWest
import com.galacticware.griddle.domain.design.base.gesture.SmallCircleClockwise
import com.galacticware.griddle.domain.design.base.gesture.SmallCircleCounterClockwise
import com.galacticware.griddle.domain.visual.ButtonPaletteTemplate.MultiColorButtonTemplate
import com.galacticware.griddle.domain.visual.GesturePaletteTemplate.CentralAlphanumericColor
import com.galacticware.griddle.domain.visual.GesturePaletteTemplate.NoColor
import com.galacticware.griddle.domain.visual.GesturePaletteTemplate.NonCentralAlphanumericColor
import com.galacticware.griddle.domain.visual.GesturePaletteTemplate.PeripheralSymbolicColor
import com.galacticware.griddle.domain.util.caseSensitive
import com.galacticware.griddle.domain.util.reversedCase
import com.galacticware.griddle.domain.util.triple
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
            +Click.insertText("a")
        }
        use(NonCentralAlphanumericColor) {
            +ShortSwipeSouthEast.insertText(caseSensitive("v"))
        }
        use(PeripheralSymbolicColor) {
            +ShortSwipeNorthWest.cycleAccentCharacters()
            +ShortSwipeEast.insertText(caseSensitive("-", "÷", "÷"))
            +ShortSwipeSouthWest.insertText(caseSensitive("$"))
        }

        use(NoColor) {
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
            +Click.insertText("n")
        }
        use(NonCentralAlphanumericColor) {
            +ShortSwipeSouth.insertText(caseSensitive("l"))
        }
        use(PeripheralSymbolicColor) {
            +ShortSwipeNorthWest.insertText(caseSensitive("`", "\\", "\\"))
            +ShortSwipeNorth.insertText(caseSensitive("^", "’", "’"))
            +ShortSwipeNorthEast.insertText(Triple("^", "’", "’"))
            +ShortSwipeEast.insertText(caseSensitive("!", "¡", "¡"))
            +ShortSwipeSouthEast.insertText(caseSensitive("\\"))
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
            +SmallCircleCounterClockwise.insertText(reversedCase("n"))
            +Hold.insertText(triple("2"))
        }
    }
}

val englishI by lazy {
    MultiColorButtonTemplate("English I", rowStart = 0, colStart = 2, rowSpan = 1, colSpan = 1) {
        use(CentralAlphanumericColor) {
            +Click.insertText("i")
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
            +ShortBoomerangSouthEast.insertText(caseSensitive("£", "€", "€"))
            +ShortBoomerangSouth.insertText(caseSensitive("±", "=", "="))
            +ShortBoomerangSouthWest.insertText(reversedCase("X"))
            +ShortBoomerangWest.insertText(caseSensitive("¿", "?", "?"))
            +SmallCircleClockwise.insertText(reversedCase("3"))
            +SmallCircleCounterClockwise.reversedCase(reversedCase("I"))
            +ShortBoomerangNorth.repeat(MovePageUp)
            +Hold.insertText(triple("3"))
        }
    }
}

val englishH by lazy {
    MultiColorButtonTemplate("English H", rowStart = 1, colStart = 0, rowSpan = 1, colSpan = 1) {
        use(CentralAlphanumericColor) {
            +Click.insertText("h")
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
            +Click.insertText("o")
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
            +Click.insertText("r")
        }
        use(NonCentralAlphanumericColor) {
            +ShortSwipeWest.insertText(caseSensitive("m"))
            +LongSwipeWest.insertText(caseSensitive("m"))
        }
        use(PeripheralSymbolicColor) {
            +ShortSwipeNorthWest.insertText("")
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
            +ShortSwipeSouthWest.insertText("@")
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
            +Click.insertText("t")
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
            +Hold.insertText(reversedCase("7"))
        }
    }
}

val englishE by lazy {
    MultiColorButtonTemplate("English E", rowStart = 2, colStart = 1, rowSpan = 1, colSpan = 1) {
        use(CentralAlphanumericColor) {
            +Click.insertText("e")
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
            +Click.insertText("s")
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
            +ShortBoomerangEast.insertText("<", "<", ">")
            +SmallCircleCounterClockwise.insertText(reversedCase("S"))
            +SmallCircleClockwise.insertText(reversedCase("9"))
            +Hold.insertText(caseSensitive("9"))
        }
    }
}