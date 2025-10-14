package com.galacticwarev2.griddle.domain.design.base.keyboard

import com.galacticwarev2.griddle.domain.design.base.layer.ILayerBuilder
import com.galacticwarev2.griddle.domain.model.type.base.tag.IKeyboardColorScheme

/**
 * This class has implementation sufficient to instantiate an [IKeyboardBuilder] object.
 */
abstract class AbstractKeyboardBuilder(
    override val name: String,
    override val kind: KeyboardKind,
    override val layers: LinkedHashSet<ILayerBuilder>,
    override val keyboardColorScheme: IKeyboardColorScheme,
) : IKeyboardBuilder {

    override fun toString(): String = "$name-${kind.label}-${layers.flatMap { it.layerTags }.toSet().sorted().joinToString("_")}"

    override fun withColors(keyboardColorScheme: IKeyboardColorScheme): IKeyboardBuilder = run {
        privateCopy(keyboardColorScheme = keyboardColorScheme)
    }

    override fun copy(
        name: String,
        kind: KeyboardKind,
        layers: LinkedHashSet<ILayerBuilder>,
        keyboardColorScheme: IKeyboardColorScheme,
    ): IKeyboardBuilder = object : AbstractKeyboardBuilder(name, kind, layers, keyboardColorScheme) {}

    private fun privateCopy(
        name: String = this.name,
        kind: KeyboardKind = this.kind,
        layers: LinkedHashSet<ILayerBuilder> = this.layers,
        keyboardColorScheme: IKeyboardColorScheme = this.keyboardColorScheme,
    ): IKeyboardBuilder = copy(name, kind, layers, keyboardColorScheme)

    override fun replaceLanguageLayersWith(
        name: String,
        builder: ILayerBuilder,
        vararg layerBuilders: ILayerBuilder
    ): IKeyboardBuilder =  privateCopy(name).apply {
        layers.removeIf { it.layerTags.isNotEmpty() }
        layers.add(builder)
        layers.addAll(layerBuilders)
    }

    companion object {
        fun getKeyboardBuilder(
            keyboardDefinable: KeyboardDefinable,
            kind: KeyboardKind = KeyboardKind.DEFAULT,
            keyboardColorScheme: IKeyboardColorScheme,
            vararg layers: ILayerBuilder,
        ): IKeyboardBuilder = object : AbstractKeyboardBuilder(
            keyboardDefinable.name,
            kind,
            linkedSetOf(*layers.map { it.renameWithKeyboardName(keyboardDefinable.name) }.toTypedArray()),
            keyboardColorScheme,
        ){}
    }
}