package com.galacticware.griddle.domain.design.base.layer

import androidx.compose.ui.unit.IntSize
import com.galacticware.griddle.domain.keyboard.KeyboardHandedness
import com.galacticware.griddle.domain.design.base.collection.ButtonBuilders
import com.galacticware.griddle.domain.design.base.keyboard.KeyboardDefinable
import com.galacticware.griddle.domain.design.implementation.alpha4x4alnum7x4.DEFAULT_SIZE
import com.galacticware.griddle.domain.language.LayerTag
import com.galacticware.griddle.domain.modifier.GestureColors
import com.galacticware.griddle.domain.registrar.LayerRegistrar

/**
 * This class has implementation sufficient to instantiate an [ILayerBuilder] object.
 */
abstract class AbstractLayerBuilder(
    override val keyboardName: String,
    override val layerTags: List<LayerTag>,
    override val charSet: CharSet,
    override val isPrimary: Boolean,
    override val keyboardHandedness: KeyboardHandedness,
    override val defaultSize: IntSize,
    override val defaultGestureColors: GestureColors,
    private val builders: ButtonBuilders,
): ILayerBuilder {
    init {
        LayerRegistrar.builders[charSet] = this
    }

    override fun buttonBuilders(): ButtonBuilders = builders

    override fun withBuilders(builders: ButtonBuilders): ILayerBuilder = copy(builders = builders)

    override fun renameWithKeyboardName(
        keyboardName: String,
    ): ILayerBuilder = object : AbstractLayerBuilder(
        keyboardName,
        layerTags,
        charSet,
        isPrimary,
        keyboardHandedness,
        defaultSize,
        defaultGestureColors,
        builders,
    ) {}

    companion object {
        fun getLayerBuilder(
            vararg layerTags: LayerTag,
            keyboardDefinable: KeyboardDefinable,
            keyboardHandedness: KeyboardHandedness,
            isPrimary: Boolean = layerTags.size == 1 && layerTags.first().isAlphabet,
            defaultSize: IntSize = DEFAULT_SIZE,
            defaultGestureColors: GestureColors = keyboardDefinable.defaultGestureColors,
            buttonBuilders: ButtonBuilders,
        ): AbstractLayerBuilder = object : AbstractLayerBuilder(
            keyboardDefinable.name,
            layerTags.toList(),
            CharSet.id(*layerTags),
            isPrimary,
            keyboardHandedness,
            defaultSize,
            defaultGestureColors,
            buttonBuilders,
        ) {}
    }
}
