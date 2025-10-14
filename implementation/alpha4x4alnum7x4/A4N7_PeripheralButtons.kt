package com.galacticwarev2.griddle.domain.design.implementation.alpha4x4alnum7x4

import android.view.KeyEvent.KEYCODE_F1
import android.view.KeyEvent.KEYCODE_F10
import android.view.KeyEvent.KEYCODE_F11
import android.view.KeyEvent.KEYCODE_F12
import android.view.KeyEvent.KEYCODE_F2
import android.view.KeyEvent.KEYCODE_F3
import android.view.KeyEvent.KEYCODE_F4
import android.view.KeyEvent.KEYCODE_F5
import android.view.KeyEvent.KEYCODE_F6
import android.view.KeyEvent.KEYCODE_F7
import android.view.KeyEvent.KEYCODE_F8
import android.view.KeyEvent.KEYCODE_F9
import android.view.KeyEvent.KEYCODE_SPACE
import com.galacticwarev2.griddle.domain.design.base.IGNORE_SHIFT
import com.galacticwarev2.griddle.domain.design.base.button.IButtonBuilder
import com.galacticwarev2.griddle.domain.design.implementation.alpha4x4alnum7x4.dsl.invoke
import com.galacticwarev2.griddle.domain.gesture.Click
import com.galacticwarev2.griddle.domain.gesture.GestureData
import com.galacticwarev2.griddle.domain.gesture.Hold
import com.galacticwarev2.griddle.domain.gesture.HotSwapGestureType
import com.galacticwarev2.griddle.domain.gesture.LongBoomerangEast
import com.galacticwarev2.griddle.domain.gesture.LongBoomerangWest
import com.galacticwarev2.griddle.domain.gesture.ShortBoomerangEast
import com.galacticwarev2.griddle.domain.gesture.ShortBoomerangNorthEast
import com.galacticwarev2.griddle.domain.gesture.ShortBoomerangNorthWest
import com.galacticwarev2.griddle.domain.gesture.ShortBoomerangSouth
import com.galacticwarev2.griddle.domain.gesture.ShortBoomerangSouthEast
import com.galacticwarev2.griddle.domain.gesture.ShortBoomerangSouthWest
import com.galacticwarev2.griddle.domain.gesture.ShortBoomerangWest
import com.galacticwarev2.griddle.domain.gesture.ShortSwipeEast
import com.galacticwarev2.griddle.domain.gesture.ShortSwipeNorth
import com.galacticwarev2.griddle.domain.gesture.ShortSwipeNorthEast
import com.galacticwarev2.griddle.domain.gesture.ShortSwipeNorthWest
import com.galacticwarev2.griddle.domain.gesture.ShortSwipeSouth
import com.galacticwarev2.griddle.domain.gesture.ShortSwipeSouthEast
import com.galacticwarev2.griddle.domain.gesture.ShortSwipeSouthWest
import com.galacticwarev2.griddle.domain.gesture.ShortSwipeWest
import com.galacticwarev2.griddle.domain.gesture.SmallCircleClockwise
import com.galacticwarev2.griddle.domain.gesture.SmallCircleCounterClockwise
import com.galacticwarev2.griddle.domain.language.LayerTag.English
import com.galacticwarev2.griddle.domain.language.LayerTag.Function
import com.galacticwarev2.griddle.domain.language.LayerTag.Hybrid
import com.galacticwarev2.griddle.domain.language.LayerTag.Numpad
import com.galacticwarev2.griddle.domain.language.LayerTag.Symbolic
import com.galacticwarev2.griddle.domain.model.type.base.tag.AppSymbol
import com.galacticwarev2.griddle.domain.model.type.base.tag.AppSymbol.CHANGE_IME_LEGEND
import com.galacticwarev2.griddle.domain.model.type.base.tag.AppSymbol.F10_KEY_LEGEND
import com.galacticwarev2.griddle.domain.model.type.base.tag.AppSymbol.F11_KEY_LEGEND
import com.galacticwarev2.griddle.domain.model.type.base.tag.AppSymbol.F12_KEY_LEGEND
import com.galacticwarev2.griddle.domain.model.type.base.tag.AppSymbol.F1_KEY_LEGEND
import com.galacticwarev2.griddle.domain.model.type.base.tag.AppSymbol.F2_KEY_LEGEND
import com.galacticwarev2.griddle.domain.model.type.base.tag.AppSymbol.F3_KEY_LEGEND
import com.galacticwarev2.griddle.domain.model.type.base.tag.AppSymbol.F4_KEY_LEGEND
import com.galacticwarev2.griddle.domain.model.type.base.tag.AppSymbol.F5_KEY_LEGEND
import com.galacticwarev2.griddle.domain.model.type.base.tag.AppSymbol.F6_KEY_LEGEND
import com.galacticwarev2.griddle.domain.model.type.base.tag.AppSymbol.F7_KEY_LEGEND
import com.galacticwarev2.griddle.domain.model.type.base.tag.AppSymbol.F8_KEY_LEGEND
import com.galacticwarev2.griddle.domain.model.type.base.tag.AppSymbol.F9_KEY_LEGEND
import com.galacticwarev2.griddle.domain.model.type.base.tag.AppSymbol.GO_TO_GLOBAL_SETTINGS_SYMBOL
import com.galacticwarev2.griddle.domain.model.type.base.tag.AppSymbol.MICROPHONE_CHAR_SYMBOL
import com.galacticwarev2.griddle.domain.model.type.base.tag.AppSymbol.SWAP_HANDEDNESS_LEGEND
import com.galacticwarev2.griddle.domain.model.type.base.tag.ButtonPaletteTemplate.BrightMonochromeTemplate
import com.galacticwarev2.griddle.domain.model.type.base.tag.ButtonPaletteTemplate.DarkMonochromeTemplate
import com.galacticwarev2.griddle.domain.model.type.base.tag.GesturePaletteTemplate.BrightMonochromeColor
import com.galacticwarev2.griddle.domain.model.type.base.tag.GesturePaletteTemplate.CentralAlphanumericColor
import com.galacticwarev2.griddle.domain.model.type.base.tag.GesturePaletteTemplate.DarkMonochromeColor
import com.galacticwarev2.griddle.domain.model.type.base.tag.GesturePaletteTemplate.NoColor
import com.galacticwarev2.griddle.domain.modifier.ModifierCycleDirection
import com.galacticwarev2.griddle.domain.operation.implementation.noargs.backspace.Backspace
import com.galacticwarev2.griddle.domain.operation.implementation.noargs.backspace.Delete
import com.galacticwarev2.griddle.domain.operation.implementation.noargs.backspace.RepeatableDeleteWordLeft
import com.galacticwarev2.griddle.domain.operation.implementation.noargs.backspace.RepeatableDeleteWordRight
import com.galacticwarev2.griddle.domain.operation.implementation.noargs.changeinputmethod.ChangeInputMethod
import com.galacticwarev2.griddle.domain.operation.implementation.noargs.cursorcontrol.Copy
import com.galacticwarev2.griddle.domain.operation.implementation.noargs.cursorcontrol.Cut
import com.galacticwarev2.griddle.domain.operation.implementation.noargs.cursorcontrol.MoveEnd
import com.galacticwarev2.griddle.domain.operation.implementation.noargs.cursorcontrol.MoveHome
import com.galacticwarev2.griddle.domain.operation.implementation.noargs.cursorcontrol.MoveLeft
import com.galacticwarev2.griddle.domain.operation.implementation.noargs.cursorcontrol.MoveRight
import com.galacticwarev2.griddle.domain.operation.implementation.noargs.cursorcontrol.MoveWordLeft
import com.galacticwarev2.griddle.domain.operation.implementation.noargs.cursorcontrol.MoveWordRight
import com.galacticwarev2.griddle.domain.operation.implementation.noargs.cursorcontrol.Paste
import com.galacticwarev2.griddle.domain.operation.implementation.noargs.cursorcontrol.Redo
import com.galacticwarev2.griddle.domain.operation.implementation.noargs.cursorcontrol.SelectAll
import com.galacticwarev2.griddle.domain.operation.implementation.noargs.cursorcontrol.Undo
import com.galacticwarev2.griddle.domain.operation.implementation.noargs.noop.NoOp
import com.galacticwarev2.griddle.domain.operation.implementation.noargs.speechtotext.SpeechToText
import com.galacticwarev2.griddle.domain.operation.implementation.noargs.swaphandedness.SwapHandedness
import com.galacticwarev2.griddle.domain.operation.implementation.someargs.changemodifier.ChangeModifierArgs.Companion.ForwardCycleAlt
import com.galacticwarev2.griddle.domain.operation.implementation.someargs.changemodifier.ChangeModifierArgs.Companion.ForwardCycleControl
import com.galacticwarev2.griddle.domain.operation.implementation.someargs.changemodifier.ChangeModifierArgs.Companion.ToggleAltRepeat
import com.galacticwarev2.griddle.domain.operation.implementation.someargs.changemodifier.ChangeModifierArgs.Companion.ToggleControlRepeat
import com.galacticwarev2.griddle.domain.operation.implementation.someargs.changeusersettings.ToggleGestureCorrection
import com.galacticwarev2.griddle.domain.operation.implementation.someargs.inserttext.InsertText
import com.galacticwarev2.griddle.domain.operation.implementation.someargs.presskey.child.PressEnterKey
import com.galacticwarev2.griddle.domain.operation.implementation.someargs.switchscreens.SwitchScreenArgs

val settingsButton by lazy {
    DarkMonochromeTemplate("Settings", rowStart = 0, colStart = 3, rowSpan = 1, colSpan = 1) {
        use(DarkMonochromeColor) {
            +Click.assign(NoOp, legend = GO_TO_GLOBAL_SETTINGS_SYMBOL, hotSwapType = HotSwapGestureType.LISTENER)
            +Hold.switchScreens(SwitchScreenArgs.OpenBaseSettings)
            +ShortSwipeWest.repeat(Undo)
            +ShortSwipeEast.repeat(Redo)
            +ShortSwipeNorth.assign(ToggleGestureCorrection)
            +SmallCircleCounterClockwise.switchLayer(Numpad, Hybrid)
            +SmallCircleClockwise.switchLayer(Symbolic, Hybrid)
        }
    }
}

val backspace by lazy {
    DarkMonochromeTemplate("Backspace", rowStart = 2, colStart = 3, rowSpan = 1, colSpan = 1) {
        use(DarkMonochromeColor) { (_ , pos) ->
            +Click.assign(Backspace)
        }
        use(NoColor) { (_, pos) ->
            /**
             * Short swipes usually have color, but we don't want a bunch of tiny backspace symbols
             * on the backspace key, so we hide these by using NoColor for short swipes on the
             * backspace key.
             */
            +ShortSwipeWest.assign(Backspace)
            +ShortSwipeNorthWest.assign(Backspace)
            +ShortSwipeSouthWest.assign(Backspace)
            +ShortSwipeEast.assign(Delete)
            +ShortSwipeNorthEast.assign(Delete)
            +ShortSwipeSouthEast.assign(Delete)

            +Hold.assign(Backspace)
            +ShortBoomerangWest.repeat(RepeatableDeleteWordLeft)
            +ShortBoomerangNorthWest.repeat(RepeatableDeleteWordLeft)
            +ShortBoomerangSouthWest.repeat(RepeatableDeleteWordLeft)
            +ShortBoomerangEast.repeat(RepeatableDeleteWordRight)
            +ShortBoomerangNorthEast.repeat(RepeatableDeleteWordRight)
            +ShortBoomerangSouthEast.repeat(RepeatableDeleteWordRight)
        }
    }
}

val alphabeticLayerToggle by lazy {
    BrightMonochromeTemplate("Alpha layer switch", rowStart = 1, colStart = 3, rowSpan = 1, colSpan = 1) {
        use(BrightMonochromeColor) {
            +Click.switchLayer(English)
            +Hold.switchLayer(Numpad)
            +ShortSwipeNorth.assign(Copy)
            +ShortSwipeWest.assign(Cut)
            +ShortSwipeNorthWest.switchScreens(SwitchScreenArgs.OpenTextReplacementEditor)
            +ShortSwipeSouth.assign(Paste)
            +ShortSwipeSouthEast.assign(ChangeInputMethod, legend = CHANGE_IME_LEGEND)
            +ShortSwipeNorthEast.switchScreens(SwitchScreenArgs.OpenEmoji)
            +ShortSwipeEast.assign(SwapHandedness, legend = SWAP_HANDEDNESS_LEGEND)
            +ShortSwipeSouthWest.assign(SpeechToText, legend = MICROPHONE_CHAR_SYMBOL)
            +ShortBoomerangSouth.switchScreens(SwitchScreenArgs.OpenClipboard)
            +SmallCircleCounterClockwise.assign(SelectAll)
            +SmallCircleClockwise.assign(SelectAll)
            +ShortBoomerangEast.switchLanguage(ModifierCycleDirection.FORWARD)
            +ShortBoomerangWest.switchLanguage(ModifierCycleDirection.REVERSE)
        }
    }
}

val numericLayerToggle by lazy {
    BrightMonochromeTemplate("Numeric layer switch", rowStart = 1, colStart = 3, rowSpan = 1, colSpan = 1) {
        use(BrightMonochromeColor) {
            +Click.switchLayer(Symbolic)
            +Hold.switchLayer(Numpad)
            +ShortSwipeNorth.assign(Copy)
            +ShortSwipeNorthWest.switchScreens(SwitchScreenArgs.OpenTextReplacementEditor)
            +ShortSwipeWest.assign(Cut)
            +ShortSwipeSouthEast.assign(ChangeInputMethod, legend = CHANGE_IME_LEGEND)
            +ShortSwipeSouth.assign(Paste)
            +ShortSwipeSouthWest.assign(SpeechToText, legend = MICROPHONE_CHAR_SYMBOL)
            +ShortSwipeEast.assign(SwapHandedness, legend = SWAP_HANDEDNESS_LEGEND)
            +ShortSwipeNorthEast.switchScreens(SwitchScreenArgs.OpenEmoji)
            +ShortBoomerangSouth.switchScreens(SwitchScreenArgs.OpenClipboard)
            +SmallCircleCounterClockwise.assign(SelectAll)
            +SmallCircleClockwise.assign(SelectAll)
            +ShortBoomerangEast.switchLanguage(ModifierCycleDirection.FORWARD)
            +ShortBoomerangWest.switchLanguage(ModifierCycleDirection.REVERSE)
        }
    }
}

val enter by lazy {
    BrightMonochromeTemplate("Enter", rowStart = 3, colStart = 3, rowSpan = 1, colSpan = 1) {
        use(BrightMonochromeColor) {
            +Click.assign(PressEnterKey)
        }
        use(NoColor) {
            +ShortSwipeNorthWest.changeModifier(ForwardCycleAlt)
            +ShortSwipeNorthEast.changeModifier(ForwardCycleControl)
            +ShortBoomerangNorthWest.changeModifier(ToggleAltRepeat)
            +ShortBoomerangNorthEast.changeModifier(ToggleControlRepeat)
        }
    }
}

val space2u by lazy {
    DarkMonochromeTemplate("Space", rowStart = 3, colStart = 1, rowSpan = 1, colSpan = 2) {
        use(DarkMonochromeColor) {
            +Click.pressKey(KEYCODE_SPACE, respectShift = IGNORE_SHIFT)
            +ShortSwipeSouthEast.switchLayer(Function)
            +ShortSwipeWest.repeat(MoveLeft)
            +ShortSwipeEast.repeat(MoveRight)
            +ShortSwipeSouth.switchLanguage()
        }
         use(NoColor) {
            +ShortBoomerangSouth.switchLanguage()
            +ShortBoomerangWest.repeat(MoveWordLeft)
            +ShortBoomerangEast.repeat(MoveWordRight)
            +LongBoomerangWest.repeat(MoveHome)
            +LongBoomerangEast.repeat(MoveEnd)
            +SmallCircleClockwise.insertText("0")
            +SmallCircleCounterClockwise.insertText("0")
            +Hold.assign(InsertText, string1 = "")
         }
    }
}

val space3u by lazy { space2u.at(colStart = 0, colSpan = 3) }

val numericSpaceLeft by lazy {
    space2u.withoutGesture { g: GestureData -> g.currentText == GO_TO_GLOBAL_SETTINGS_SYMBOL.value }
        .at(0, 3, 1, 1)
}

val numericSpaceRight by lazy { numericSpaceLeft.at(colStart = 2) }

val symbol1 by lazy { englishA.withoutLetters().addAssignments(Click.insertText("1") to CentralAlphanumericColor)}
val symbol2 by lazy { englishN.renameTo("Symbol-Numeric 2").withoutLetters().addAssignments(Click.insertText("2") to CentralAlphanumericColor)}
val symbol3 by lazy { englishI.renameTo("Symbol-Numeric 3").withoutLetters().addAssignments(Click.insertText("3") to CentralAlphanumericColor)}
val symbol4 by lazy { englishH.renameTo("Symbol-Numeric 4").withoutLetters().addAssignments(Click.insertText("4") to CentralAlphanumericColor)}
val symbol5 by lazy { englishO.renameTo("Symbol-Numeric 5").withoutLetters().addAssignments(Click.insertText("5") to CentralAlphanumericColor)}
val symbol6 by lazy { englishR.renameTo("Symbol-Numeric 6").withoutLetters().addAssignments(Click.insertText("6") to CentralAlphanumericColor)}
val symbol7 by lazy { englishT.renameTo("Symbol-Numeric 7").withoutLetters().addAssignments(Click.insertText("7") to CentralAlphanumericColor)}
val symbol8 by lazy { englishE.renameTo("Symbol-Numeric 8").withoutLetters().addAssignments(Click.insertText("8") to CentralAlphanumericColor)}
val symbol9 by lazy { englishS.renameTo("Symbol-Numeric 9").withoutLetters().addAssignments(Click.insertText("9") to CentralAlphanumericColor)}
val symbol0 by lazy { symbol8.renameTo("Symbol-Numeric 0").at(rowStart = 3).addAssignments(Click.insertText("0") to CentralAlphanumericColor) }

val numpad0 by lazy { symbol0.renameTo("Numpad 0").replaceGesturesWith(Click.insertText("0") to CentralAlphanumericColor) }
val numpad1 by lazy { symbol1.renameTo("Numpad 1").replaceGesturesWith(Click.insertText("1") to CentralAlphanumericColor) }
val numpad2 by lazy { symbol2.renameTo("Numpad 2").replaceGesturesWith(Click.insertText("2") to CentralAlphanumericColor) }
val numpad3 by lazy { symbol3.renameTo("Numpad 3").replaceGesturesWith(Click.insertText("3") to CentralAlphanumericColor) }
val numpad4 by lazy { symbol4.renameTo("Numpad 4").replaceGesturesWith(Click.insertText("4") to CentralAlphanumericColor) }
val numpad5 by lazy { symbol5.renameTo("Numpad 5").replaceGesturesWith(Click.insertText("5") to CentralAlphanumericColor) }
val numpad6 by lazy { symbol6.renameTo("Numpad 6").replaceGesturesWith(Click.insertText("6") to CentralAlphanumericColor) }
val numpad7 by lazy { symbol7.renameTo("Numpad 7").replaceGesturesWith(Click.insertText("7") to CentralAlphanumericColor) }
val numpad8 by lazy { symbol8.renameTo("Numpad 8").replaceGesturesWith(Click.insertText("8") to CentralAlphanumericColor) }
val numpad9 by lazy { symbol9.renameTo("Numpad 9").replaceGesturesWith(Click.insertText("9") to CentralAlphanumericColor) }

private fun makeFunctionButton(
    name: String,
    legend: AppSymbol,
    keycode: Int,
    buttonWithCorrectPosition: IButtonBuilder,
) = buttonWithCorrectPosition
    .renameTo(name)
    .replaceGesturesWith(Click.pressKey(legend = legend, keycode = keycode) to CentralAlphanumericColor)

val f1 by lazy { makeFunctionButton("F1", F1_KEY_LEGEND, KEYCODE_F1, numpad1) }
val f2 by lazy { makeFunctionButton("F2", F2_KEY_LEGEND, KEYCODE_F2, numpad2) }
val f3 by lazy { makeFunctionButton("F3", F3_KEY_LEGEND, KEYCODE_F3, numpad3) }
val f4 by lazy { makeFunctionButton("F4", F4_KEY_LEGEND, KEYCODE_F4, numpad4) }
val f5 by lazy { makeFunctionButton("F5", F5_KEY_LEGEND, KEYCODE_F5, numpad5) }
val f6 by lazy { makeFunctionButton("F6", F6_KEY_LEGEND, KEYCODE_F6, numpad6) }
val f7 by lazy { makeFunctionButton("F7", F7_KEY_LEGEND, KEYCODE_F7, numpad7) }
val f8 by lazy { makeFunctionButton("F8", F8_KEY_LEGEND, KEYCODE_F8, numpad8) }
val f9 by lazy { makeFunctionButton("F9", F9_KEY_LEGEND, KEYCODE_F9, numpad9) }
val f10 by lazy { makeFunctionButton("F10", F10_KEY_LEGEND, KEYCODE_F10, numpad7.at(rowStart = 3)) }
val f11 by lazy { makeFunctionButton("F11", F11_KEY_LEGEND, KEYCODE_F11, numpad8.at(rowStart = 3)) }
val f12 by lazy { makeFunctionButton("F12", F12_KEY_LEGEND, KEYCODE_F12, numpad9.at(rowStart = 3)) }