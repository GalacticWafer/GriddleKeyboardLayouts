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
import com.galacticware.griddle.domain.operation.PressKey
import com.galacticware.griddle.keyboarddefinition.opensource.theme.DEFAULT_SIZE
import com.galacticware.griddle.keyboarddefinition.opensource.layouts.GriddleLayerBuilder

object DefaultFunctionMap: GriddleLayerBuilder() {
    override val isPrimary: Boolean = false
    override val keyboardHandedness = KeyboardHandedness(hasHandedness = true, pivotColumn = 1)
    override val layerKind: LayerKind = LayerKind.FUNCTION
    override val languageTag = null
    override val defalultSize: IntSize = DEFAULT_SIZE

    val f1 get() = DefaultNumericMap.button1
        .replaceGesturesWith(bindGesture(CLICK, PressKey, keycode = KEYCODE_F1, remappedSymbol = F1_SYMBOL))

    val f2 get() = DefaultNumericMap.button2
        .replaceGesturesWith(bindGesture(CLICK, PressKey, keycode = KEYCODE_F2, remappedSymbol = F2_SYMBOL))

    val f3 get() = DefaultNumericMap.button3
        .replaceGesturesWith(bindGesture(CLICK, PressKey, keycode = KEYCODE_F3, remappedSymbol = F3_SYMBOL))

    val f4 get() = DefaultNumericMap.button4
        .replaceGesturesWith(bindGesture(CLICK, PressKey, keycode = KEYCODE_F4, remappedSymbol = F4_SYMBOL))

    val f5 get() = DefaultNumericMap.button5
        .replaceGesturesWith(bindGesture(CLICK, PressKey, keycode = KEYCODE_F5, remappedSymbol = F5_SYMBOL))

    val f6 get() = DefaultNumericMap.button6
        .replaceGesturesWith(bindGesture(CLICK, PressKey, keycode = KEYCODE_F6, remappedSymbol = F6_SYMBOL))

    val f7 get() = DefaultNumericMap.button7
        .replaceGesturesWith(bindGesture(CLICK, PressKey, keycode = KEYCODE_F7, remappedSymbol = F7_SYMBOL))

    val f8 get() = DefaultNumericMap.button8
        .replaceGesturesWith(bindGesture(CLICK, PressKey, keycode = KEYCODE_F8, remappedSymbol = F8_SYMBOL))

    val f9 get() = DefaultNumericMap.button9
        .replaceGesturesWith(bindGesture(CLICK, PressKey, keycode = KEYCODE_F9, remappedSymbol = F9_SYMBOL))

    val f10 = numericSpaceLeft
        .replaceGesturesWith(bindGesture(CLICK, PressKey, keycode = KEYCODE_F10, remappedSymbol = F10_SYMBOL))

    val f11 get() = DefaultNumericMap.button0
        .replaceGesturesWith(bindGesture(CLICK, PressKey, keycode = KEYCODE_F11, remappedSymbol = F11_SYMBOL))

    val f12 get() = numericSpaceRight
        .replaceGesturesWith(bindGesture(CLICK, PressKey, keycode = KEYCODE_F12, remappedSymbol = F12_SYMBOL))

    override fun buttonBuilders() = mutableSetOf(
        f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12,
        cursorControlButton,
        AlphabeticLayerToggle,
        backspace,
        enter,
    )
}