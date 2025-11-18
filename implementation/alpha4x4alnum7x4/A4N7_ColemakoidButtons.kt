package com.galacticware.griddle.domain.design.implementation.alpha4x4alnum7x4

import android.view.KeyEvent.KEYCODE_DPAD_DOWN
import android.view.KeyEvent.KEYCODE_DPAD_UP
import com.galacticware.griddle.domain.design.base.IGNORE_SHIFT
import com.galacticware.griddle.domain.design.base.gesture.Click
import com.galacticware.griddle.domain.design.base.gesture.Hold
import com.galacticware.griddle.domain.design.base.gesture.LongSwipeSouth
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
import com.galacticware.griddle.domain.language.LayerTag.Colemakoid
import com.galacticware.griddle.domain.language.LayerTag.Symbolic
import com.galacticware.griddle.domain.model.type.base.tag.AppSymbol
import com.galacticware.griddle.domain.visual.ButtonPaletteTemplate.MultiColorButtonTemplate
import com.galacticware.griddle.domain.visual.GesturePaletteTemplate.CentralAlphanumericColor
import com.galacticware.griddle.domain.visual.GesturePaletteTemplate.NoColor
import com.galacticware.griddle.domain.visual.GesturePaletteTemplate.NonCentralAlphanumericColor
import com.galacticware.griddle.domain.visual.GesturePaletteTemplate.PeripheralSymbolicColor
import com.galacticware.griddle.domain.util.caseSensitive
import com.galacticware.griddle.domain.util.reversedCase
import com.galacticware.griddle.domain.util.triple
import com.galacticware.griddle.domain.modifier.AppModifierKey.Companion.control
import com.galacticware.griddle.domain.operation.implementation.noargs.cursorcontrol.MovePageUp
import com.galacticware.griddle.domain.operation.implementation.noargs.cursorcontrol.MoveUp
import com.galacticware.griddle.domain.operation.implementation.someargs.changemodifier.ChangeModifierArgs.Companion.ForwardCycleShift
import com.galacticware.griddle.domain.operation.implementation.someargs.changemodifier.ChangeModifierArgs.Companion.ReleaseShift
import com.galacticware.griddle.domain.operation.implementation.someargs.changemodifier.ChangeModifierArgs.Companion.ToggleShiftRepeat
import com.galacticware.griddle.domain.operation.implementation.someargs.presskey.PressKey
import com.galacticware.griddle.domain.operation.implementation.someargs.presskey.child.PressTab
import com.galacticware.griddle.domain.operation.implementation.someargs.presskey.child.PressUnTab
import com.galacticware.griddle.domain.operation.implementation.someargs.presskey.child.SendNewLineFeed
import com.galacticware.griddle.domain.operation.implementation.someargs.presskey.child.SendTab

val colemakoidA by lazy {
    MultiColorButtonTemplate("Colemakoid A", rowStart = 0, colStart = 0, rowSpan = 1, colSpan = 1) {
        use(CentralAlphanumericColor) {
            +Click.insertText("a")
        }
        use(NonCentralAlphanumericColor) {
            +ShortSwipeSouthEast.insertText(caseSensitive("q"))
        }
        use(PeripheralSymbolicColor) {
            +ShortSwipeWest.insertText(caseSensitive("†"))
            +ShortSwipeNorth.insertText("¨")
            +ShortSwipeSouth.insertText("•")
            +ShortSwipeSouthWest.insertText("|")
            +ShortSwipeNorthWest.cycleAccentCharacters()
            +ShortSwipeEast.insertText("!", "¡", "¡")
            +ShortSwipeNorthEast.insertText("~")
        }

        use(NoColor) {
            +ShortBoomerangWest.insertText(reversedCase("†"))
            +Hold.insertText("1")
            +ShortBoomerangEast.insertText("÷", "-", "-")
            +ShortBoomerangSouthWest.insertText(reversedCase("¢"))
            +ShortBoomerangSouthEast.insertText(reversedCase("q"))
            +SmallCircleClockwise.insertText(reversedCase("a"))
            +SmallCircleCounterClockwise.insertText(reversedCase("a"))
        }
    }
}

val colemakoidN by lazy {
    MultiColorButtonTemplate("Colemakoid N", rowStart = 0, colStart = 1, rowSpan = 1, colSpan = 1) {
        use(CentralAlphanumericColor) {
            +Click.insertText("n")
        }
        use(NonCentralAlphanumericColor) {
            +ShortSwipeSouth.insertText(caseSensitive("f"))
            +ShortSwipeSouthEast.insertText(caseSensitive("p"))
            +ShortSwipeSouthWest.insertText(caseSensitive("w"))
        }
        use(PeripheralSymbolicColor) {
            +ShortSwipeNorthWest.insertText(caseSensitive("`", "\\", "\\"))
            +ShortSwipeNorth.insertText(caseSensitive("^", "’", "’"))
            +ShortSwipeNorthEast.insertText("’")
            +ShortSwipeEast.insertText(Triple("@", "ª", "ª"))
            +ShortSwipeWest.insertText(Triple("?", "¿", "¿"))
        }

        use(NoColor) {
            +Hold.insertText("2")
            +ShortBoomerangNorth.insertText(caseSensitive("ˇ"))
            +ShortBoomerangNorthWest.insertText(caseSensitive("\\", "`", "`"))
            +ShortBoomerangWest.insertText(Triple("¿", "?", "?"))
            +ShortBoomerangEast.insertText(Triple("ª", "@", "@"))
            +ShortBoomerangSouthEast.insertText(reversedCase("p"))
            +ShortBoomerangSouth.insertText(reversedCase("f"))
            +ShortBoomerangSouthWest.insertText(reversedCase("w"))
            +SmallCircleClockwise.insertText(reversedCase("n"))
            +SmallCircleCounterClockwise.insertText(reversedCase("n"))
        }
    }
}

val colemakoidI by lazy {
    MultiColorButtonTemplate("Colemakoid I", rowStart = 0, colStart = 2, rowSpan = 1, colSpan = 1) {
        use(CentralAlphanumericColor) {
            +Click.insertText("i")
        }

        use(NonCentralAlphanumericColor) {
            +ShortSwipeEast.insertText("∂")
            +ShortSwipeSouthWest.insertText(caseSensitive("g"))
            +ShortSwipeSouthEast.insertText(caseSensitive("ŋ"))
            +ShortSwipeSouth.repeat(SendNewLineFeed)
        }

        use(PeripheralSymbolicColor) {
            +ShortSwipeWest.insertText("#")
            +ShortSwipeNorth.repeat(MoveUp)
            +ShortSwipeNorthWest.insertText("°")
        }

        use(NoColor) {
            +Hold.insertText("3")
            +ShortBoomerangSouthEast.insertText(reversedCase("ŋ"))
            +ShortBoomerangSouth.insertText(caseSensitive("±", "=", "="))
            +ShortBoomerangSouthWest.insertText(reversedCase("g"))
            +ShortBoomerangWest.insertText(caseSensitive("¿", "?", "?"))
            +ShortBoomerangEast.insertText(reversedCase("∂"))
            +SmallCircleClockwise.insertText(reversedCase("3"))
            +ShortBoomerangNorth.repeat(MovePageUp)
            +SmallCircleClockwise.insertText(reversedCase("i"))
            +SmallCircleCounterClockwise.insertText(reversedCase("i"))
        }
    }
}

val colemakoidH by lazy {
    MultiColorButtonTemplate("Colemakoid H", rowStart = 1, colStart = 0, rowSpan = 1, colSpan = 1) {
        use(CentralAlphanumericColor) {
            +Click.insertText("h")
        }
        use(NonCentralAlphanumericColor) {
            +ShortSwipeNorthEast.insertText(caseSensitive("z"))
            +ShortSwipeSouthEast.insertText(caseSensitive("j"))
            +ShortSwipeSouth.insertText(caseSensitive("ð"))
        }
        use(PeripheralSymbolicColor) {
            +ShortSwipeNorth.insertText("–", "–", "–")
            +ShortSwipeNorthWest.insertText(Triple("{", "}", "}"))
            +ShortSwipeSouthWest.insertText(Triple("[", "]", "]"))
            +ShortSwipeWest.insertText(Triple("(", ")", ")"))
            +ShortSwipeEast.insertText("$", "¢", "¢")
        }
        use(NoColor) {
            +ShortBoomerangNorthWest.insertText(Triple("}", "{", "{"))
            +ShortBoomerangNorth.insertText("¬", "¬", "-")
            +ShortBoomerangNorthEast.insertText(reversedCase("z"))
            +ShortBoomerangSouth.insertText(reversedCase("ð"))
            +ShortBoomerangEast.insertText("¢", "$", "$")
            +ShortBoomerangSouthEast.insertText(reversedCase("j"))
            +ShortBoomerangSouthWest.insertText(Triple("]", "[", "["))
            +ShortBoomerangWest.insertText(Triple(")", "(", "("))
            +SmallCircleClockwise.insertText(reversedCase("4"))
            +SmallCircleClockwise.insertText(reversedCase("h"))
            +SmallCircleCounterClockwise.insertText(reversedCase("h"))
            +Hold.insertText("4")
        }
    }
}

val colemakoidO by lazy {
    MultiColorButtonTemplate("Colemakoid O", rowStart = 1, colStart = 1, rowSpan = 1, colSpan = 1,) {
        use(CentralAlphanumericColor) {
            +Click.insertText("o")
        }
        use(NonCentralAlphanumericColor) {
            +ShortSwipeNorthWest.insertText(caseSensitive("x"))
            +ShortSwipeNorth.insertText(caseSensitive("c"))
            +ShortSwipeNorthEast.insertText(caseSensitive("v"))
            +ShortSwipeSouthEast.insertText(caseSensitive("y"))
            +ShortSwipeSouth.insertText(caseSensitive("u"))
            +ShortSwipeSouthWest.insertText(caseSensitive("l"))
        }
        use(PeripheralSymbolicColor){
            +ShortSwipeEast.insertText("\"")
            +ShortSwipeWest.insertText("%", "%", "‰")
        }
        use(NoColor) {
            +ShortBoomerangNorthWest.insertText(reversedCase("x"))
            +ShortBoomerangNorth.insertText(reversedCase("c"))
            +ShortBoomerangNorthEast.insertText(reversedCase("v"))
            +ShortBoomerangSouthEast.insertText(reversedCase("y"))
            +ShortBoomerangSouth.insertText(reversedCase("u"))
            +ShortBoomerangSouthWest.insertText(reversedCase("l"))
            +ShortBoomerangWest.insertText("‰", "%", "%")
            +SmallCircleCounterClockwise.insertText(reversedCase("o"))
            +SmallCircleClockwise.insertText(reversedCase("o"))
            +Hold.insertText("5")
        }
    }
}

val colemakoidR by lazy {
    MultiColorButtonTemplate("Colemakoid R", rowStart = 1, colStart = 2, rowSpan = 1, colSpan = 1) {
        use(CentralAlphanumericColor) {
            +Click.insertText("r")
        }
        use(NonCentralAlphanumericColor) {
            +ShortSwipeSouthWest.insertText(caseSensitive("å"))
            +ShortSwipeNorthWest.insertText(caseSensitive("b"))
        }
        use(PeripheralSymbolicColor) {
            +ShortSwipeWest.insertText("'")
            +ShortSwipeNorth.changeModifier(ForwardCycleShift)
            +ShortSwipeSouth.changeModifier(ReleaseShift)
            +ShortBoomerangNorth.changeModifier(ToggleShiftRepeat)
            +ShortSwipeNorthEast.insertText(caseSensitive("}", "{", "{"))
            +ShortBoomerangNorthEast.insertText(caseSensitive("{", "}", "}"))
            +ShortSwipeEast.insertText(caseSensitive(")", "(", "("))
            +ShortBoomerangEast.insertText(caseSensitive("(", ")", ")"))
            +ShortSwipeSouthEast.insertText(caseSensitive("]", "[", "["))
            +ShortBoomerangSouthEast.insertText(caseSensitive("[", "]", "]"))
            +ShortBoomerangSouth.insertText(caseSensitive("—"))
        }
        use(NoColor) {
            +ShortBoomerangNorthWest.insertText(reversedCase("b"))
            +ShortBoomerangSouthWest.insertText(reversedCase("å"))
            +SmallCircleClockwise.insertText(reversedCase("r"))
            +SmallCircleCounterClockwise.insertText(reversedCase("r"))
            +Hold.insertText("6")
        }
    }
}

val colemakoidT by lazy {
    MultiColorButtonTemplate("Colemakoid T", rowStart = 2, colStart = 0, rowSpan = 1, colSpan = 1) {
        use(CentralAlphanumericColor) {
            +Click.insertText("t")
        }
        use(NonCentralAlphanumericColor) {
            +ShortSwipeNorthEast.insertText(caseSensitive("k"))
            +ShortSwipeNorth.insertText(caseSensitive("þ"))
        }
        use(PeripheralSymbolicColor) {
            +ShortSwipeNorthWest.insertText("\\", "/", "/")
            +ShortSwipeSouth.insertText("_")
            +ShortSwipeEast.insertText("&")
            +ShortSwipeWest.insertText(Triple("<", ">", ">"))
            +ShortSwipeSouthEast.repeat(PressTab)
            +ShortSwipeSouthWest.assign(PressUnTab)
        }
        use(NoColor) {
            +Hold.insertText("7")
            +ShortBoomerangNorth.insertText(reversedCase("þ"))
            +ShortBoomerangNorthEast.insertText(reversedCase("k"))
            +ShortBoomerangNorthWest.insertText("/", "\\", "\\")
            +ShortBoomerangEast.insertText(Triple("†", "*", "*"))
            +ShortBoomerangWest.insertText(Triple(">", "<", "<"))
            +ShortBoomerangSouthEast.assign(PressTab)
            +SmallCircleClockwise.insertText(reversedCase("t"))
            +SmallCircleCounterClockwise.insertText(reversedCase("t"))
        }
    }
}

val colemakoidE by lazy {
    MultiColorButtonTemplate("Colemakoid E", rowStart = 2, colStart = 1, rowSpan = 1, colSpan = 1) {
        use(CentralAlphanumericColor) {
            +Click.insertText("e")
        }
        use(NonCentralAlphanumericColor) {
            +ShortSwipeNorthWest.insertText(caseSensitive("m"))
            +ShortSwipeNorth.insertText(caseSensitive("d"))
            +ShortSwipeNorthEast.insertText(caseSensitive("ø"))
        }
        use(PeripheralSymbolicColor) {
            +ShortSwipeEast.insertText(caseSensitive("-"))
            +ShortSwipeWest.insertText("*")
            +ShortSwipeSouthEast.insertText(caseSensitive(":"))
            +ShortSwipeSouth.insertText(caseSensitive(".", "…", "…"))
            +ShortSwipeSouthWest.insertText(caseSensitive(","))
        }
        use(NoColor) {
            +ShortBoomerangNorthWest.insertText(caseSensitive("m"))
            +ShortBoomerangNorth.insertText(caseSensitive("d"))
            +ShortBoomerangNorthEast.insertText(caseSensitive("ø"))
            +ShortBoomerangEast.insertText(reversedCase("Z"))
            +ShortBoomerangSouthEast.insertText(caseSensitive(","))
            +ShortBoomerangSouth.insertText(caseSensitive("…", ".", "."))
            +ShortBoomerangSouthWest.insertText(caseSensitive(","))
            +ShortBoomerangWest.insertText(caseSensitive(","))
            +SmallCircleClockwise.insertText(reversedCase("e"))
            +SmallCircleCounterClockwise.insertText(reversedCase("e"))
            +Hold.insertText("8")
        }
    }
}

val colemakoidS by lazy {
    MultiColorButtonTemplate("Colemakoid S", rowStart = 2, colStart = 2, rowSpan = 1, colSpan = 1) {
        use(CentralAlphanumericColor) {
            +Click.insertText("s")
        }
        use(NonCentralAlphanumericColor) {
            +ShortSwipeNorthWest.insertText(caseSensitive("æ"))
        }
        use(PeripheralSymbolicColor) {
            +ShortSwipeNorthEast.insertText(caseSensitive("/"))
            +ShortSwipeWest.insertText(caseSensitive("+"))
            +ShortSwipeNorth.insertText(caseSensitive("="))
            +ShortSwipeEast.insertText(caseSensitive(">"))
            +ShortSwipeSouthWest.insertText(caseSensitive(";"))
            +ShortSwipeSouth.assign(PressKey, keycode = KEYCODE_DPAD_DOWN, /*respectShift = IGNORE_SHIFT,*/ legend =  AppSymbol.DOWN_ARROW_KEY_LEGEND, duration = 500L)
        }
        use(NoColor) {
            +ShortBoomerangNorthWest.insertText(reversedCase("æ"))
            +ShortBoomerangSouthWest.insertText(caseSensitive(";"))
            +ShortBoomerangWest.insertText(caseSensitive(" "))
            +ShortBoomerangSouth.assign(PressKey, keycode = KEYCODE_DPAD_DOWN, modifiers = setOf(control), /*respectShift = IGNORE_SHIFT,*/ legend =  AppSymbol.DOWN_ARROW_KEY_LEGEND, duration = 500L)
            +SmallCircleCounterClockwise.insertText(reversedCase("s"))
            +SmallCircleClockwise.insertText(reversedCase("s"))
            +Hold.insertText("9")
        }
    }
}

val colemakoid1 by lazy {
    MultiColorButtonTemplate("Colemakoid 1", rowStart = 0, colStart = 0, rowSpan = 1, colSpan = 1) {
        use(CentralAlphanumericColor) {
            +Click.insertText("1")
        }
        use(NonCentralAlphanumericColor) {
            +ShortSwipeSouthEast.insertText(caseSensitive("α"))
        }
        use(PeripheralSymbolicColor) {
            +ShortSwipeWest.insertText("≤")
            +ShortSwipeNorth.insertText("¨")
            +ShortSwipeSouth.insertText("•")
            +ShortSwipeSouthWest.insertText("|")
            +ShortSwipeNorthWest.cycleAccentCharacters()
            +ShortSwipeEast.insertText(Triple("!", "¡", "¡"))
            +ShortSwipeNorthEast.insertText("~")

        }

        use(NoColor) {
            +ShortBoomerangWest.insertText(reversedCase("†"))
            +Hold.insertText("1")
        }
    }
}

val colemakoid2 by lazy {
    MultiColorButtonTemplate("Colemakoid 2", rowStart = 0, colStart = 1, rowSpan = 1, colSpan = 1) {
        use(CentralAlphanumericColor) {
            +Click.insertText("2")
        }
        use(NonCentralAlphanumericColor) {
            +ShortSwipeSouth.insertText(caseSensitive("φ"))
            +ShortSwipeSouth.insertText(caseSensitive("f"))
            +ShortSwipeSouthEast.insertText(caseSensitive("π"))
            +ShortSwipeSouthWest.insertText(caseSensitive("ω"))
        }
        use(PeripheralSymbolicColor) {
            +ShortSwipeNorthWest.insertText(caseSensitive("`", "\\", "\\"))
            +ShortSwipeNorth.insertText(caseSensitive("^", "’", "’"))
            +ShortSwipeNorthEast.insertText("’")
            +ShortSwipeEast.insertText(Triple("@", "ª", "ª"))
            +ShortSwipeWest.insertText(Triple("?", "¿", "¿"))
        }

        use(NoColor) {
            +LongSwipeSouth.insertText(caseSensitive("l"))
            +Hold.insertText(triple("2"))
            +ShortBoomerangNorth.insertText(caseSensitive("ˇ"))
            +ShortBoomerangNorthWest.insertText(caseSensitive("\\", "`", "`"))
            +ShortBoomerangWest.insertText(Triple("¿", "?", "?"))
            +ShortBoomerangEast.insertText(Triple("ª", "@", "@"))
            +ShortBoomerangSouthEast.insertText(reversedCase("π"))
            +ShortBoomerangSouth.insertText(reversedCase("φ"))
            +ShortBoomerangSouthWest.insertText(reversedCase("ω"))
            +ShortBoomerangWest.insertText(caseSensitive("×", "+", "+"))
            +SmallCircleClockwise.insertText(reversedCase("2"))
            +SmallCircleCounterClockwise.insertText(reversedCase("n"))
        }
    }
}

val colemakoid3 by lazy {
    MultiColorButtonTemplate("Colemakoid 3", rowStart = 0, colStart = 2, rowSpan = 1, colSpan = 1) {
        use(CentralAlphanumericColor) {
            +Click.insertText("3")
        }

        use(NonCentralAlphanumericColor) {
            +ShortSwipeSouth.insertText("ʃ")
            +ShortSwipeEast.insertText("∂")
            +ShortSwipeSouthWest.insertText(caseSensitive("γ"))
            +ShortSwipeSouthEast.insertText(caseSensitive("€"))
        }

        use(PeripheralSymbolicColor) {
            +ShortSwipeWest.insertText("#")
            +ShortSwipeNorth.assign(PressKey, keycode = KEYCODE_DPAD_UP, respectShift = IGNORE_SHIFT, legend =  AppSymbol.UP_ARROW_KEY_LEGEND, duration = 500L)
            +ShortSwipeNorthWest.insertText("°")
            +ShortBoomerangSouth.insertText(reversedCase("ʃ"))
        }

        use(NoColor) {
            +ShortBoomerangSouthEast.insertText(reversedCase("€"))
            +ShortBoomerangSouthWest.insertText(reversedCase("γ"))
            +ShortBoomerangWest.insertText(caseSensitive("¿", "?", "?"))
            +ShortBoomerangEast.insertText(reversedCase("∂"))
            +SmallCircleClockwise.insertText(reversedCase("3"))
            +SmallCircleCounterClockwise.reversedCase(reversedCase("I"))
            +ShortBoomerangNorth.assign(PressKey, keycode = KEYCODE_DPAD_UP, modifiers = setOf(control), respectShift = IGNORE_SHIFT, legend =  AppSymbol.UP_ARROW_KEY_LEGEND, duration = 500L)
            +Hold.insertText(triple("3"))
        }
    }
}

val colemakoid4 by lazy {
    MultiColorButtonTemplate("Colemakoid 4", rowStart = 1, colStart = 0, rowSpan = 1, colSpan = 1) {
        use(CentralAlphanumericColor) {
            +Click.insertText("4")
        }
        use(NonCentralAlphanumericColor) {
            +ShortSwipeEast.insertText("$")
            +ShortSwipeNorthEast.insertText(caseSensitive("σ"))
            +ShortSwipeSouthEast.insertText(caseSensitive("λ"))
            +ShortSwipeSouth.insertText("×")
        }
        use(PeripheralSymbolicColor) {
            +ShortSwipeNorth.insertText("–", "–", "–")
            +ShortSwipeNorthWest.insertText(Triple("{", "}", "}"))
            +ShortSwipeSouthWest.insertText(Triple("[", "]", "]"))
            +ShortSwipeWest.insertText(Triple("(", ")", ")"))
            +ShortSwipeEast.insertText("$", "¢", "¢")
        }
        use(NoColor) {
            +ShortBoomerangNorthWest.insertText(Triple("}", "{", "{"))
            +ShortBoomerangNorth.insertText("¬", "¬", "-")
            +ShortBoomerangNorthEast.insertText(reversedCase("z"))
            +ShortBoomerangSouth.insertText(reversedCase("ð"))
            +ShortBoomerangEast.insertText("¢", "$", "$")
            +ShortBoomerangSouthEast.insertText(reversedCase("j"))
            +ShortBoomerangSouthWest.insertText(Triple("]", "[", "["))
            +ShortBoomerangWest.insertText(Triple(")", "(", "("))
            +SmallCircleClockwise.insertText(reversedCase("4"))
            +SmallCircleCounterClockwise.insertText(reversedCase("4"))
            +Hold.insertText(caseSensitive("4"))
        }
    }
}

val colemakoid5 by lazy {
    MultiColorButtonTemplate("Colemakoid 5", rowStart = 1, colStart = 1, rowSpan = 1, colSpan = 1,) {
        use(CentralAlphanumericColor) {
            +Click.insertText("5")
        }
        use(NonCentralAlphanumericColor) {
            +ShortSwipeNorthWest.insertText("¹")
            +ShortSwipeNorth.insertText("²")
            +ShortSwipeNorthEast.insertText("³")
            +ShortSwipeSouthEast.insertText("¾")
            +ShortSwipeSouth.insertText("½")
            +ShortSwipeSouthWest.insertText("¼")
        }
        use(PeripheralSymbolicColor){
            +ShortSwipeEast.insertText("\"")
            +ShortSwipeWest.insertText("%", "%", "‰")
        }
        use(NoColor) {
            +ShortBoomerangNorthWest.insertText(reversedCase("x"))
            +ShortBoomerangNorth.insertText(reversedCase("c"))
            +ShortBoomerangNorthEast.insertText(reversedCase("v"))
            +ShortBoomerangSouthEast.insertText(reversedCase("y"))
            +ShortBoomerangSouth.insertText(reversedCase("u"))
            +ShortBoomerangSouthWest.insertText(reversedCase("l"))
            +ShortBoomerangWest.insertText("‰", "%", "%")
            +SmallCircleCounterClockwise.insertText("5")
            +SmallCircleClockwise.insertText(reversedCase("5"))
            +Hold.insertText(reversedCase("5"))
        }
    }
}

val colemakoid6 by lazy {
    MultiColorButtonTemplate("Colemakoid 6", rowStart = 1, colStart = 2, rowSpan = 1, colSpan = 1) {
        use(CentralAlphanumericColor) {
            +Click.insertText("6")
        }
        use(NonCentralAlphanumericColor) {
            +ShortSwipeNorthWest.insertText(caseSensitive("β"))
        }
        use(PeripheralSymbolicColor) {
            +ShortSwipeWest.insertText("'")
            +ShortSwipeNorth.insertText("§")
            +ShortSwipeSouth.insertText("≈")
            +ShortSwipeNorthWest.insertText(caseSensitive("|", "\\", "\\"))
            +ShortBoomerangNorth.changeModifier(ToggleShiftRepeat)
            +ShortSwipeNorthEast.insertText(caseSensitive("}", "{", "{"))
            +ShortBoomerangNorthEast.insertText(caseSensitive("{", "}", "}"))
            +ShortSwipeEast.insertText(caseSensitive(")", "(", "("))
            +ShortBoomerangEast.insertText(caseSensitive("(", ")", ")"))
            +ShortSwipeSouthEast.insertText(caseSensitive("]", "[", "["))
            +ShortSwipeSouthWest.insertText("ρ")
            +ShortBoomerangSouthEast.insertText(caseSensitive("[", "]", "]"))
            +ShortBoomerangSouth.insertText(caseSensitive("—"))
        }
        use(NoColor) {
            +ShortBoomerangNorthWest.insertText(reversedCase("b"))
            +ShortBoomerangSouthWest.insertText(reversedCase("å"))
            +SmallCircleClockwise.insertText(reversedCase("6"))
            +SmallCircleCounterClockwise.insertText(reversedCase("6"))
            +Hold.insertText(reversedCase("6"))
        }
    }
}

val colemakoid7 by lazy {
    MultiColorButtonTemplate("Colemakoid 7", rowStart = 2, colStart = 0, rowSpan = 1, colSpan = 1) {
        use(CentralAlphanumericColor) {
            +Click.insertText("7")
        }
        use(NonCentralAlphanumericColor) {
            +ShortSwipeNorthEast.insertText(caseSensitive("y"))
            +ShortSwipeNorthEast.insertText(caseSensitive("κ"))
        }
        use(PeripheralSymbolicColor) {
            +ShortSwipeNorthWest.insertText("\\", "/", "/")
            +ShortSwipeNorth.insertText(caseSensitive("þ"))
            +ShortSwipeSouth.insertText("_")
            +ShortSwipeEast.insertText("&")
            +ShortSwipeWest.insertText(Triple("<", ">", ">"))
            +ShortSwipeSouthEast.assign(SendTab, legend = AppSymbol.TAB_RIGHT_KEY_LEGEND)
        }
        use(NoColor) {
            +Hold.insertText(reversedCase("7"))
            +ShortBoomerangNorth.insertText(reversedCase("þ"))
            +ShortBoomerangNorthEast.insertText(reversedCase("κ"))
            +ShortBoomerangNorthWest.insertText("/", "\\", "\\")
            +ShortBoomerangEast.insertText(Triple("†", "*", "*"))
            +ShortBoomerangWest.insertText(Triple(">", "<", "<"))
            +ShortBoomerangSouthEast.assign(PressTab, legend = AppSymbol.TAB_RIGHT_KEY_LEGEND)
            +SmallCircleClockwise.insertText(reversedCase("7"))
            +SmallCircleCounterClockwise.insertText("7")
        }
    }
}

val colemakoid8 by lazy {
    MultiColorButtonTemplate("Colemakoid 8", rowStart = 2, colStart = 1, rowSpan = 1, colSpan = 1) {
        use(CentralAlphanumericColor) {
            +Click.insertText("8")
        }
        use(NonCentralAlphanumericColor) {
            +ShortSwipeNorthWest.insertText(caseSensitive("µ"))
            +ShortSwipeNorth.insertText(caseSensitive("δ"))
            +ShortSwipeNorthEast.insertText(caseSensitive("θ"))
        }
        use(PeripheralSymbolicColor) {
            +ShortSwipeEast.insertText(caseSensitive("-"))
            +ShortSwipeWest.insertText("*")
            +ShortSwipeSouthEast.insertText(caseSensitive(":"))
            +ShortSwipeSouth.insertText(caseSensitive(".", "…", "…"))
            +ShortSwipeSouthWest.insertText(caseSensitive(","))
        }
        use(NoColor) {
            +ShortBoomerangNorthWest.insertText(caseSensitive("µ"))
            +ShortBoomerangNorth.insertText(caseSensitive("δ"))
            +ShortBoomerangNorthEast.insertText(caseSensitive("θ"))
            +ShortBoomerangEast.insertText(reversedCase("Z"))
            +ShortBoomerangSouthEast.insertText(caseSensitive(","))
            +ShortBoomerangSouth.insertText(caseSensitive("…", ".", "."))
            +ShortBoomerangSouthWest.insertText(caseSensitive(","))
            +ShortBoomerangWest.insertText(caseSensitive(","))
            +SmallCircleClockwise.insertText(reversedCase("8"))
            +SmallCircleCounterClockwise.insertText(reversedCase("8"))
            +Hold.insertText("8")
        }
    }
}

val colemakoid9 by lazy {
    MultiColorButtonTemplate("Colemakoid 9", rowStart = 2, colStart = 2, rowSpan = 1, colSpan = 1) {
        use(CentralAlphanumericColor) {
            +Click.insertText("9")
        }
        use(NonCentralAlphanumericColor) {
            +ShortSwipeNorthWest.insertText(caseSensitive("ε"))
            +ShortSwipeNorthEast.insertText(caseSensitive("/"))
        }
        use(PeripheralSymbolicColor) {
            +ShortSwipeWest.insertText(caseSensitive("+"))
            +ShortSwipeNorth.insertText(caseSensitive("="))
            +ShortSwipeEast.insertText(caseSensitive(">"))
            +ShortSwipeSouthWest.insertText(caseSensitive(";"))
            +ShortSwipeSouth.assign(PressKey, keycode = KEYCODE_DPAD_DOWN, /*respectShift = IGNORE_SHIFT,*/ legend =  AppSymbol.DOWN_ARROW_KEY_LEGEND, duration = 500L)
        }
        use(NoColor) {
            +ShortBoomerangNorthWest.insertText(reversedCase("ε"))
            +ShortBoomerangSouthWest.insertText(caseSensitive(";"))
            +ShortBoomerangWest.insertText(caseSensitive(" "))
            +ShortBoomerangSouth.assign(PressKey, keycode = KEYCODE_DPAD_DOWN, modifiers = setOf(control), /*respectShift = IGNORE_SHIFT,*/ legend =  AppSymbol.DOWN_ARROW_KEY_LEGEND, duration = 500L)
            +SmallCircleCounterClockwise.insertText(reversedCase("9"))
            +SmallCircleClockwise.insertText(reversedCase("9"))
            +Hold.insertText(caseSensitive("9"))
        }
    }
}

val colemakoidAlphaLayerToggle = alphabeticLayerToggle.addAssignments(Click.switchLayer(Colemakoid()) to CentralAlphanumericColor)
val colemakoidNumericLayerToggle = numericLayerToggle.addAssignments(Click.switchLayer(Colemakoid(Symbolic)) to CentralAlphanumericColor)