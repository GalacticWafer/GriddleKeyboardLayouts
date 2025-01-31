package com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.layer

import android.view.KeyEvent.KEYCODE_F
import android.view.KeyEvent.KEYCODE_F1
import android.view.KeyEvent.KEYCODE_F2
import android.view.KeyEvent.KEYCODE_F3
import android.view.KeyEvent.KEYCODE_F4
import android.view.KeyEvent.KEYCODE_F5
import android.view.KeyEvent.KEYCODE_F6
import android.view.KeyEvent.KEYCODE_F7
import android.view.KeyEvent.KEYCODE_F8
import android.view.KeyEvent.KEYCODE_F9
import androidx.compose.ui.unit.IntSize
import com.galacticware.griddle.model.button.GestureButtonBuilder
import com.galacticware.griddle.model.gesture.GestureType
import com.galacticware.griddle.model.gesture.GestureType.CLICK
import com.galacticware.griddle.model.keybinder.AppSymbol
import com.galacticware.griddle.model.keybinder.AppSymbol.F10_SYMBOL
import com.galacticware.griddle.model.keybinder.AppSymbol.F11_SYMBOL
import com.galacticware.griddle.model.keybinder.AppSymbol.F12_SYMBOL
import com.galacticware.griddle.model.keybinder.AppSymbol.F1_SYMBOL
import com.galacticware.griddle.model.keybinder.AppSymbol.F2_SYMBOL
import com.galacticware.griddle.model.keybinder.AppSymbol.F3_SYMBOL
import com.galacticware.griddle.model.keybinder.AppSymbol.F4_SYMBOL
import com.galacticware.griddle.model.keybinder.AppSymbol.F5_SYMBOL
import com.galacticware.griddle.model.keybinder.AppSymbol.F6_SYMBOL
import com.galacticware.griddle.model.keybinder.AppSymbol.F7_SYMBOL
import com.galacticware.griddle.model.keybinder.AppSymbol.F8_SYMBOL
import com.galacticware.griddle.model.keybinder.AppSymbol.F9_SYMBOL
import com.galacticware.griddle.model.keybinder.KeyBinder.Companion.bindGesture
import com.galacticware.griddle.model.keyboard.KeyboardHandedness
import com.galacticware.griddle.model.keyboard.definition.designs.base.GriddleLayerBuilder
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.button.GriddleButtonBuilders as buttonBuilders
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.layer.GriddleNumericLayerBuilder.button1
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.layer.GriddleNumericLayerBuilder.button2
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.layer.GriddleNumericLayerBuilder.button3
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.layer.GriddleNumericLayerBuilder.button4
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.layer.GriddleNumericLayerBuilder.button5
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.layer.GriddleNumericLayerBuilder.button6
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.english.layer.GriddleNumericLayerBuilder.button8
import com.galacticware.griddle.model.keyboard.definition.theme.DEFAULT_SIZE
import com.galacticware.griddle.model.layer.LayerKind
import com.galacticware.griddle.model.operation.implementation.someargs.presskey.PressKey
data class X(val a:GestureButtonBuilder,val b:GestureButtonBuilder,val c:GestureButtonBuilder,val d:GestureButtonBuilder,val e:GestureButtonBuilder,val f:GestureButtonBuilder,val g:GestureButtonBuilder)

object GriddleFunctionLayerBuilder: GriddleLayerBuilder() {
    override val isPrimary: Boolean = false
    override val keyboardHandedness = KeyboardHandedness(hasHandedness = true, pivotColumn = 1)
    override val layerKind: LayerKind = LayerKind.FUNCTION
    override val languageTag = null
    override val defalultSize: IntSize = DEFAULT_SIZE


    val f1 by lazy { makeFunctionButton(CLICK, PressKey, F1_SYMBOL, KEYCODE_F1, button1) }
    val f2 by lazy { makeFunctionButton(CLICK, PressKey, F2_SYMBOL, KEYCODE_F2, button2) }
    val f3 by lazy { makeFunctionButton(CLICK, PressKey, F3_SYMBOL, KEYCODE_F3, button3) }
    val f4 by lazy { makeFunctionButton(CLICK, PressKey, F4_SYMBOL, KEYCODE_F4, buttonBuilders.settingsButton) }
    val f5 by lazy { makeFunctionButton(CLICK, PressKey, F5_SYMBOL, KEYCODE_F5, button4) }
    val f6 by lazy { makeFunctionButton(CLICK, PressKey, F6_SYMBOL, KEYCODE_F6, button5) }
    val f7 by lazy { makeFunctionButton(CLICK, PressKey, F7_SYMBOL, KEYCODE_F7, button6) }
    val f8 by lazy { makeFunctionButton(CLICK, PressKey, F8_SYMBOL, KEYCODE_F8, buttonBuilders.AlphabeticLayerToggle) }
    val f9 by lazy { makeFunctionButton(CLICK, PressKey, F9_SYMBOL, KEYCODE_F9, buttonBuilders.numericSpaceLeft) }
    val f10 by lazy { makeFunctionButton(CLICK, PressKey, F10_SYMBOL, KEYCODE_F, button8) }
    val f11 by lazy { makeFunctionButton(CLICK, PressKey, F11_SYMBOL, KEYCODE_F, buttonBuilders.numericSpaceRight) }
    val f12 by lazy { makeFunctionButton(CLICK, PressKey, F12_SYMBOL, KEYCODE_F, buttonBuilders.enter) }

    private fun makeFunctionButton(
        click: GestureType,
        pressKey: PressKey,
        appSymbol: AppSymbol,
        keycode: Int,
        buttonWithCorrectPosition: GestureButtonBuilder,
    ) = buttonWithCorrectPosition.replaceGesturesWith(bindGesture(
        CLICK,
        PressKey,
        appSymbol = F4_SYMBOL,
        keycode = KEYCODE_F4
    ))

    override fun buttonBuilders() = mutableSetOf(
        f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12,
        buttonBuilders.settingsButton,
        buttonBuilders.AlphabeticLayerToggle,
        buttonBuilders.backspace,
        buttonBuilders.enter,
    )
}