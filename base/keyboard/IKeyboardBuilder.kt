package com.galacticware.griddle.domain.design.base.keyboard

import com.galacticware.griddle.domain.input.IMEService
import com.galacticware.griddle.domain.keyboard.Keyboard
import com.galacticware.griddle.domain.design.base.layer.ILayerBuilder
import com.galacticware.griddle.domain.design.base.layer.LayerDefinable
import com.galacticware.griddle.domain.visual.IKeyboardColorScheme

/**
 * Define a contract for objects that build a [Keyboard].
 */
interface IKeyboardBuilder: (IMEService) -> Keyboard {
    val kind: KeyboardKind

    val name: String

    val layers: LinkedHashSet<ILayerBuilder>

    val keyboardColorScheme: IKeyboardColorScheme

    override fun invoke(imeService: IMEService) = Keyboard(
        name,
        layers = sortedSetOf<LayerDefinable>().apply {
            addAll(layers.map { it(imeService) }.toMutableSet())
        },
        kind,
        //layerColorization,
    )

    fun withColors(keyboardColorScheme: IKeyboardColorScheme) : IKeyboardBuilder

    fun replaceLanguageLayersWith(
        name: String,
        builder: ILayerBuilder,
        vararg builders: ILayerBuilder
    ) : IKeyboardBuilder = replaceLanguageLayersWith(name, builder, *builders)

    fun copy(name: String, kind: KeyboardKind, layers: LinkedHashSet<ILayerBuilder>, keyboardColorScheme: IKeyboardColorScheme, doRegister: Boolean): IKeyboardBuilder
}