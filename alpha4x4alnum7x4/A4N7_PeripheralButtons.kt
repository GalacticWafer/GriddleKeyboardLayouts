package com.galacticware.griddle.domain.design.implementation.alpha4x4alnum7x4

import android.view.KeyEvent.KEYCODE_DEL
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
import android.view.KeyEvent.KEYCODE_FORWARD_DEL
import android.view.KeyEvent.KEYCODE_SPACE
import com.galacticware.griddle.domain.design.base.IGNORE_SHIFT
import com.galacticware.griddle.domain.design.base.button.IButtonBuilder
import com.galacticware.griddle.domain.design.implementation.alpha4x4alnum7x4.dsl.invoke
import com.galacticware.griddle.domain.gesture.Click
import com.galacticware.griddle.domain.gesture.GestureData
import com.galacticware.griddle.domain.gesture.Hold
import com.galacticware.griddle.domain.gesture.HotSwapGestureType
import com.galacticware.griddle.domain.gesture.LongBoomerangEast
import com.galacticware.griddle.domain.gesture.LongBoomerangWest
import com.galacticware.griddle.domain.gesture.ShortBoomerangEast
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
import com.galacticware.griddle.domain.language.LayerTag.English
import com.galacticware.griddle.domain.language.LayerTag.Function
import com.galacticware.griddle.domain.language.LayerTag.Hybrid
import com.galacticware.griddle.domain.language.LayerTag.Numpad
import com.galacticware.griddle.domain.language.LayerTag.Symbolic
import com.galacticware.griddle.domain.model.type.base.tag.AppSymbol
import com.galacticware.griddle.domain.model.type.base.tag.AppSymbol.BACKSPACE_KEY_LEGEND
import com.galacticware.griddle.domain.model.type.base.tag.AppSymbol.CHANGE_IME_SYMBOL
import com.galacticware.griddle.domain.model.type.base.tag.AppSymbol.COPY_KEY_LEGEND
import com.galacticware.griddle.domain.model.type.base.tag.AppSymbol.CUT_KEY_LEGEND
import com.galacticware.griddle.domain.model.type.base.tag.AppSymbol.F10_KEY_LEGEND
import com.galacticware.griddle.domain.model.type.base.tag.AppSymbol.F11_KEY_LEGEND
import com.galacticware.griddle.domain.model.type.base.tag.AppSymbol.F12_KEY_LEGEND
import com.galacticware.griddle.domain.model.type.base.tag.AppSymbol.F1_KEY_LEGEND
import com.galacticware.griddle.domain.model.type.base.tag.AppSymbol.F2_KEY_LEGEND
import com.galacticware.griddle.domain.model.type.base.tag.AppSymbol.F3_KEY_LEGEND
import com.galacticware.griddle.domain.model.type.base.tag.AppSymbol.F4_KEY_LEGEND
import com.galacticware.griddle.domain.model.type.base.tag.AppSymbol.F5_KEY_LEGEND
import com.galacticware.griddle.domain.model.type.base.tag.AppSymbol.F6_KEY_LEGEND
import com.galacticware.griddle.domain.model.type.base.tag.AppSymbol.F7_KEY_LEGEND
import com.galacticware.griddle.domain.model.type.base.tag.AppSymbol.F8_KEY_LEGEND
import com.galacticware.griddle.domain.model.type.base.tag.AppSymbol.F9_KEY_LEGEND
import com.galacticware.griddle.domain.model.type.base.tag.AppSymbol.GO_TO_GLOBAL_SETTINGS_SYMBOL
import com.galacticware.griddle.domain.model.type.base.tag.AppSymbol.MICROPHONE_CHAR_SYMBOL
import com.galacticware.griddle.domain.model.type.base.tag.AppSymbol.PASTE_KEY_LEGEND
import com.galacticware.griddle.domain.model.type.base.tag.AppSymbol.SWAP_HANDEDNESS_SYMBOL
import com.galacticware.griddle.domain.model.type.base.tag.ButtonPaletteTemplate.BrightMonochromeTemplate
import com.galacticware.griddle.domain.model.type.base.tag.ButtonPaletteTemplate.DarkMonochromeTemplate
import com.galacticware.griddle.domain.model.type.base.tag.GesturePaletteTemplate.BrightMonochromeColors
import com.galacticware.griddle.domain.model.type.base.tag.GesturePaletteTemplate.DarkMonochromeColors
import com.galacticware.griddle.domain.model.type.base.tag.GesturePaletteTemplate.NoColor
import com.galacticware.griddle.domain.modifier.ModifierCycleDirection
import com.galacticware.griddle.domain.operation.implementation.noargs.backspace.Backspace
import com.galacticware.griddle.domain.operation.implementation.noargs.backspace.RepeatableDeleteWordLeft
import com.galacticware.griddle.domain.operation.implementation.noargs.backspace.RepeatableDeleteWordRight
import com.galacticware.griddle.domain.operation.implementation.noargs.changeinputmethod.ChangeInputMethod
import com.galacticware.griddle.domain.operation.implementation.noargs.copycolors.CopyColors
import com.galacticware.griddle.domain.operation.implementation.noargs.cursorcontrol.MoveEnd
import com.galacticware.griddle.domain.operation.implementation.noargs.cursorcontrol.MoveHome
import com.galacticware.griddle.domain.operation.implementation.noargs.cursorcontrol.MoveLeft
import com.galacticware.griddle.domain.operation.implementation.noargs.cursorcontrol.MoveRight
import com.galacticware.griddle.domain.operation.implementation.noargs.cursorcontrol.MoveWordLeft
import com.galacticware.griddle.domain.operation.implementation.noargs.cursorcontrol.MoveWordRight
import com.galacticware.griddle.domain.operation.implementation.noargs.cursorcontrol.Redo
import com.galacticware.griddle.domain.operation.implementation.noargs.cursorcontrol.SelectAll
import com.galacticware.griddle.domain.operation.implementation.noargs.cursorcontrol.Undo
import com.galacticware.griddle.domain.operation.implementation.noargs.hidekeyboard.HideKeyboard
import com.galacticware.griddle.domain.operation.implementation.noargs.noop.NoOp
import com.galacticware.griddle.domain.operation.implementation.noargs.speechtotext.SpeechToText
import com.galacticware.griddle.domain.operation.implementation.noargs.swaphandedness.SwapHandedness
import com.galacticware.griddle.domain.operation.implementation.someargs.changemodifier.ChangeModifierArgs.Companion.ForwardCycleAlt
import com.galacticware.griddle.domain.operation.implementation.someargs.changemodifier.ChangeModifierArgs.Companion.ForwardCycleControl
import com.galacticware.griddle.domain.operation.implementation.someargs.changemodifier.ChangeModifierArgs.Companion.ToggleAltRepeat
import com.galacticware.griddle.domain.operation.implementation.someargs.changemodifier.ChangeModifierArgs.Companion.ToggleControlRepeat
import com.galacticware.griddle.domain.operation.implementation.someargs.changeusersettings.ToggleGestureCorrection
import com.galacticware.griddle.domain.operation.implementation.someargs.inserttext.InsertText
import com.galacticware.griddle.domain.operation.implementation.someargs.presskey.child.PressEnterKey
import com.galacticware.griddle.domain.operation.implementation.someargs.switchscreens.SwitchScreenArgs

val settingsButton by lazy {
    DarkMonochromeTemplate(rowStart = 0, colStart = 3, rowSpan = 1, colSpan = 1) {
        use(DarkMonochromeColors) {
            +Click.assign(NoOp, legend = GO_TO_GLOBAL_SETTINGS_SYMBOL, hotSwapType = HotSwapGestureType.LISTENER)
            +Hold.switchScreens(SwitchScreenArgs.OpenBaseSettings)
            +ShortSwipeWest.repeat(Undo)
            +ShortSwipeEast.repeat(Redo)
            +ShortBoomerangSouth.assign(CopyColors)
            +ShortSwipeNorth.assign(ToggleGestureCorrection)
            +ShortSwipeSouth.assign(HideKeyboard)
            +SmallCircleCounterClockwise.switchLayer(Numpad, Hybrid)
            +SmallCircleClockwise.switchLayer(Symbolic, Hybrid)
        }
    }
}

val backspace by lazy {
    DarkMonochromeTemplate(rowStart = 2, colStart = 3, rowSpan = 1, colSpan = 1) {
        use(DarkMonochromeColors) { (_ , pos) ->
            +Click.remappedSymbolLookup(BACKSPACE_KEY_LEGEND)
        }
        use(NoColor) { (_, pos) ->
            /**
             * Short swipes usually have color, but we don't want a bunch of tiny backspace symbols
             * on the backspace key, so we hide these by using NoColor for short swipes on the
             * backspace key.
             */
            +ShortSwipeWest.remappedSymbolLookup(BACKSPACE_KEY_LEGEND)
            +ShortSwipeNorthWest.remappedSymbolLookup(BACKSPACE_KEY_LEGEND)
            +ShortSwipeSouthWest.remappedSymbolLookup(BACKSPACE_KEY_LEGEND)
            +ShortSwipeEast.remappedSymbolLookup(AppSymbol.DELETE_KEY_LEGEND)
            +ShortSwipeNorthEast.remappedSymbolLookup(AppSymbol.DELETE_KEY_LEGEND)
            +ShortSwipeSouthEast.remappedSymbolLookup(AppSymbol.DELETE_KEY_LEGEND)

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
    BrightMonochromeTemplate(rowStart = 1, colStart = 3, rowSpan = 1, colSpan = 1) {
        use(BrightMonochromeColors) {
            +Click.switchLayer(English)
            +Hold.switchLayer(Numpad)
            +ShortSwipeNorth.remappedSymbolLookup(COPY_KEY_LEGEND)
            +ShortSwipeWest.remappedSymbolLookup(CUT_KEY_LEGEND)
            +ShortSwipeNorthWest.switchScreens(SwitchScreenArgs.OpenTextReplacementEditor)
            +ShortSwipeSouth.remappedSymbolLookup(PASTE_KEY_LEGEND)
            +ShortSwipeSouthEast.assign(ChangeInputMethod, legend = CHANGE_IME_SYMBOL)
            +ShortSwipeNorthEast.switchScreens(SwitchScreenArgs.OpenEmoji)
            +ShortSwipeEast.assign(SwapHandedness, legend = SWAP_HANDEDNESS_SYMBOL)
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
    BrightMonochromeTemplate(rowStart = 1, colStart = 3, rowSpan = 1, colSpan = 1) {
        use(BrightMonochromeColors) {
            +Click.switchLayer(Symbolic)
            +Hold.switchLayer(Numpad)
            +ShortSwipeNorth.remappedSymbolLookup(COPY_KEY_LEGEND)
            +ShortSwipeNorthWest.switchScreens(SwitchScreenArgs.OpenTextReplacementEditor)
            +ShortSwipeWest.remappedSymbolLookup(CUT_KEY_LEGEND)
            +ShortSwipeSouthEast.assign(ChangeInputMethod, legend = CHANGE_IME_SYMBOL)
            +ShortSwipeSouth.remappedSymbolLookup(PASTE_KEY_LEGEND)
            +ShortSwipeSouthWest.assign(SpeechToText, legend = MICROPHONE_CHAR_SYMBOL)
            +ShortSwipeEast.assign(SwapHandedness, legend = SWAP_HANDEDNESS_SYMBOL)
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
    BrightMonochromeTemplate(rowStart = 3, colStart = 3, rowSpan = 1, colSpan = 1) {
        use(BrightMonochromeColors) {
            +Click.assign(PressEnterKey)
            +ShortSwipeNorthWest.changeModifier(ForwardCycleAlt)
            +ShortBoomerangNorthWest.changeModifier(ToggleAltRepeat)
            +ShortSwipeNorthEast.changeModifier(ForwardCycleControl)
            +ShortBoomerangNorthEast.changeModifier(ToggleControlRepeat)
        }
    }
}

val space2u by lazy {
    DarkMonochromeTemplate(rowStart = 3, colStart = 1, rowSpan = 1, colSpan = 2) {
        use(DarkMonochromeColors) {
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

val symbol1 by lazy { englishA.withoutLetters().addAssignments(Click.insertText("1"))}
val symbol2 by lazy { englishN.withoutLetters().addAssignments(Click.insertText("2"))}
val symbol3 by lazy { englishI.withoutLetters().addAssignments(Click.insertText("3"))}
val symbol4 by lazy { englishH.withoutLetters().addAssignments(Click.insertText("4"))}
val symbol5 by lazy { englishO.withoutLetters().addAssignments(Click.insertText("5"))}
val symbol6 by lazy { englishR.withoutLetters().addAssignments(Click.insertText("6"))}
val symbol7 by lazy { englishT.withoutLetters().addAssignments(Click.insertText("7"))}
val symbol8 by lazy { englishE.withoutLetters().addAssignments(Click.insertText("8"))}
val symbol9 by lazy { englishS.withoutLetters().addAssignments(Click.insertText("9"))}
val symbol0 by lazy { symbol8.at(rowStart = 3).addAssignments(Click.insertText("0")) }

val numpad0 by lazy { symbol0.replaceGesturesWith(Click.insertText("0")) }
val numpad1 by lazy { symbol1.replaceGesturesWith(Click.insertText("1")) }
val numpad2 by lazy { symbol2.replaceGesturesWith(Click.insertText("2")) }
val numpad3 by lazy { symbol3.replaceGesturesWith(Click.insertText("3")) }
val numpad4 by lazy { symbol4.replaceGesturesWith(Click.insertText("4")) }
val numpad5 by lazy { symbol5.replaceGesturesWith(Click.insertText("5")) }
val numpad6 by lazy { symbol6.replaceGesturesWith(Click.insertText("6")) }
val numpad7 by lazy { symbol7.replaceGesturesWith(Click.insertText("7")) }
val numpad8 by lazy { symbol8.replaceGesturesWith(Click.insertText("8")) }
val numpad9 by lazy { symbol9.replaceGesturesWith(Click.insertText("9")) }

private fun makeFunctionButton(
    legend: AppSymbol,
    keycode: Int,
    buttonWithCorrectPosition: IButtonBuilder,
) = buttonWithCorrectPosition
    .replaceGesturesWith(Click.pressKey(legend = legend, keycode = keycode))

val f1 by lazy { makeFunctionButton(F1_KEY_LEGEND, KEYCODE_F1, numpad1) }
val f2 by lazy { makeFunctionButton(F2_KEY_LEGEND, KEYCODE_F2, numpad2) }
val f3 by lazy { makeFunctionButton(F3_KEY_LEGEND, KEYCODE_F3, numpad3) }
val f4 by lazy { makeFunctionButton(F4_KEY_LEGEND, KEYCODE_F4, numpad4) }
val f5 by lazy { makeFunctionButton(F5_KEY_LEGEND, KEYCODE_F5, numpad5) }
val f6 by lazy { makeFunctionButton(F6_KEY_LEGEND, KEYCODE_F6, numpad6) }
val f7 by lazy { makeFunctionButton(F7_KEY_LEGEND, KEYCODE_F7, numpad7) }
val f8 by lazy { makeFunctionButton(F8_KEY_LEGEND, KEYCODE_F8, numpad8) }
val f9 by lazy { makeFunctionButton(F9_KEY_LEGEND, KEYCODE_F9, numpad9) }
val f10 by lazy { makeFunctionButton(F10_KEY_LEGEND, KEYCODE_F10, numpad7.at(rowStart = 3)) }
val f11 by lazy { makeFunctionButton(F11_KEY_LEGEND, KEYCODE_F11, numpad8.at(rowStart = 3)) }
val f12 by lazy { makeFunctionButton(F12_KEY_LEGEND, KEYCODE_F12, numpad9.at(rowStart = 3)) }