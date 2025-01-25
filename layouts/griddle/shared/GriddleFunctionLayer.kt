package com.galacticware.griddle.keyboarddefinition.opensource.layouts.griddle.shared

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
import androidx.compose.ui.unit.IntSize
import com.galacticware.griddle.domain.gesture.GestureType.CLICK
import com.galacticware.griddle.domain.keybinder.AppSymbol.F10_SYMBOL
import com.galacticware.griddle.domain.keybinder.AppSymbol.F11_SYMBOL
import com.galacticware.griddle.domain.keybinder.AppSymbol.F12_SYMBOL
import com.galacticware.griddle.domain.keybinder.AppSymbol.F1_SYMBOL
import com.galacticware.griddle.domain.keybinder.AppSymbol.F2_SYMBOL
import com.galacticware.griddle.domain.keybinder.AppSymbol.F3_SYMBOL
import com.galacticware.griddle.domain.keybinder.AppSymbol.F4_SYMBOL
import com.galacticware.griddle.domain.keybinder.AppSymbol.F5_SYMBOL
import com.galacticware.griddle.domain.keybinder.AppSymbol.F6_SYMBOL
import com.galacticware.griddle.domain.keybinder.AppSymbol.F7_SYMBOL
import com.galacticware.griddle.domain.keybinder.AppSymbol.F8_SYMBOL
import com.galacticware.griddle.domain.keybinder.AppSymbol.F9_SYMBOL
import com.galacticware.griddle.domain.keybinder.KeyBinder.Companion.bindGesture
import com.galacticware.griddle.domain.keyboard.KeyboardHandedness
import com.galacticware.griddle.domain.layer.LayerKind
import com.galacticware.griddle.domain.operation.implementation.presskey.PressKey
import com.galacticware.griddle.keyboarddefinition.opensource.theme.DEFAULT_SIZE
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.GriddleLayerBuilder

object DefaultFunctionBuilder: GriddleLayerBuilder() {
    override val isPrimary: Boolean = false
    override val keyboardHandedness = KeyboardHandedness(hasHandedness = true, pivotColumn = 1)
    override val layerKind: LayerKind = LayerKind.FUNCTION
    override val languageTag = null
    override val defalultSize: IntSize = DEFAULT_SIZE

    val f1 get() = DefaultNumericBuilder.button1
        .replaceGesturesWith(bindGesture(CLICK, PressKey, keycode = KEYCODE_F1, appSymbol = F1_SYMBOL))

    val f2 get() = DefaultNumericBuilder.button2
        .replaceGesturesWith(bindGesture(CLICK, PressKey, keycode = KEYCODE_F2, appSymbol = F2_SYMBOL))

    val f3 get() = DefaultNumericBuilder.button3
        .replaceGesturesWith(bindGesture(CLICK, PressKey, keycode = KEYCODE_F3, appSymbol = F3_SYMBOL))

    val f4 get() = DefaultNumericBuilder.button4
        .replaceGesturesWith(bindGesture(CLICK, PressKey, keycode = KEYCODE_F4, appSymbol = F4_SYMBOL))

    val f5 get() = DefaultNumericBuilder.button5
        .replaceGesturesWith(bindGesture(CLICK, PressKey, keycode = KEYCODE_F5, appSymbol = F5_SYMBOL))

    val f6 get() = DefaultNumericBuilder.button6
        .replaceGesturesWith(bindGesture(CLICK, PressKey, keycode = KEYCODE_F6, appSymbol = F6_SYMBOL))

    val f7 get() = DefaultNumericBuilder.button7
        .replaceGesturesWith(bindGesture(CLICK, PressKey, keycode = KEYCODE_F7, appSymbol = F7_SYMBOL))

    val f8 get() = DefaultNumericBuilder.button8
        .replaceGesturesWith(bindGesture(CLICK, PressKey, keycode = KEYCODE_F8, appSymbol = F8_SYMBOL))

    val f9 get() = DefaultNumericBuilder.button9
        .replaceGesturesWith(bindGesture(CLICK, PressKey, keycode = KEYCODE_F9, appSymbol = F9_SYMBOL))

    val f10 = numericSpaceLeft
        .replaceGesturesWith(bindGesture(CLICK, PressKey, keycode = KEYCODE_F10, appSymbol = F10_SYMBOL))

    val f11 get() = DefaultNumericBuilder.button0
        .replaceGesturesWith(bindGesture(CLICK, PressKey, keycode = KEYCODE_F11, appSymbol = F11_SYMBOL))

    val f12 get() = numericSpaceRight
        .replaceGesturesWith(bindGesture(CLICK, PressKey, keycode = KEYCODE_F12, appSymbol = F12_SYMBOL))

    override fun buttonBuilders() = mutableSetOf(
        f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12,
        cursorControlButton,
        AlphabeticLayerToggle,
        backspace,
        enter,
    )
}