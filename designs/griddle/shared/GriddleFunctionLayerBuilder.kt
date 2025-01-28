package com.galacticware.griddle.model.keyboard.definition.designs.griddle.shared

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
import com.galacticware.griddle.model.gesture.GestureType.CLICK
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
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.builder.AlphabeticLayerToggle
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.builder.backspace
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.builder.cursorControlButton
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.builder.enter
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.builder.numericSpaceLeft
import com.galacticware.griddle.model.keyboard.definition.designs.griddle.builder.numericSpaceRight
import com.galacticware.griddle.model.layer.LayerKind
import com.galacticware.griddle.model.operation.implementation.someargs.presskey.PressKey
import com.galacticware.griddle.model.keyboard.definition.theme.DEFAULT_SIZE
import com.galacticware.griddle.model.layer.GriddleLayerBuilder

object GriddleFunctionLayerBuilder: GriddleLayerBuilder() {
    override val isPrimary: Boolean = false
    override val keyboardHandedness = KeyboardHandedness(hasHandedness = true, pivotColumn = 1)
    override val layerKind: LayerKind = LayerKind.FUNCTION
    override val languageTag = null
    override val defalultSize: IntSize = DEFAULT_SIZE

    val f1 get() = GriddleNumericLayerBuilder.button1
        .replaceGesturesWith(bindGesture(
            CLICK,
            PressKey,
            appSymbol = F1_SYMBOL,
            keycode = KEYCODE_F1
        ))

    val f2 get() = GriddleNumericLayerBuilder.button2
        .replaceGesturesWith(bindGesture(
            CLICK,
            PressKey,
            appSymbol = F2_SYMBOL,
            keycode = KEYCODE_F2
        ))

    val f3 get() = GriddleNumericLayerBuilder.button3
        .replaceGesturesWith(bindGesture(
            CLICK,
            PressKey,
            appSymbol = F3_SYMBOL,
            keycode = KEYCODE_F3
        ))

    val f4 get() = GriddleNumericLayerBuilder.button4
        .replaceGesturesWith(bindGesture(
            CLICK,
            PressKey,
            appSymbol = F4_SYMBOL,
            keycode = KEYCODE_F4
        ))

    val f5 get() = GriddleNumericLayerBuilder.button5
        .replaceGesturesWith(bindGesture(
            CLICK,
            PressKey,
            appSymbol = F5_SYMBOL,
            keycode = KEYCODE_F5
        ))

    val f6 get() = GriddleNumericLayerBuilder.button6
        .replaceGesturesWith(bindGesture(
            CLICK,
            PressKey,
            appSymbol = F6_SYMBOL,
            keycode = KEYCODE_F6
        ))

    val f7 get() = GriddleNumericLayerBuilder.button7
        .replaceGesturesWith(bindGesture(
            CLICK,
            PressKey,
            appSymbol = F7_SYMBOL,
            keycode = KEYCODE_F7
        ))

    val f8 get() = GriddleNumericLayerBuilder.button8
        .replaceGesturesWith(bindGesture(
            CLICK,
            PressKey,
            appSymbol = F8_SYMBOL,
            keycode = KEYCODE_F8
        ))

    val f9 get() = GriddleNumericLayerBuilder.button9
        .replaceGesturesWith(bindGesture(
            CLICK,
            PressKey,
            appSymbol = F9_SYMBOL,
            keycode = KEYCODE_F9
        ))

    val f10 = numericSpaceLeft
        .replaceGesturesWith(bindGesture(
            CLICK,
            PressKey,
            appSymbol = F10_SYMBOL,
            keycode = KEYCODE_F10
        ))

    val f11 get() = GriddleNumericLayerBuilder.button0
        .replaceGesturesWith(bindGesture(
            CLICK,
            PressKey,
            appSymbol = F11_SYMBOL,
            keycode = KEYCODE_F11
        ))

    val f12 get() = numericSpaceRight
        .replaceGesturesWith(bindGesture(
            CLICK,
            PressKey,
            appSymbol = F12_SYMBOL,
            keycode = KEYCODE_F12
        ))

    override fun buttonBuilders() = mutableSetOf(
        f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12,
        cursorControlButton,
        AlphabeticLayerToggle,
        backspace,
        enter,
    )
}