package com.galacticware.griddle.domain.design.base.layer

import androidx.compose.ui.unit.IntSize
import com.galacticware.griddle.domain.input.IMEService
import com.galacticware.griddle.domain.keyboard.KeyboardHandedness
import com.galacticware.griddle.domain.design.base.collection.ButtonBuilders
import com.galacticware.griddle.domain.language.LayerTag
import com.galacticware.griddle.domain.visual.Colorable
import com.galacticware.griddle.domain.modifier.GestureColors
import com.galacticware.griddle.domain.util.toPascalCase
interface ButtonColorable: Colorable, (IMEService) -> LayerDefinable

/**
 * Define a contract for objects that build a [LayerDefinable].
 */
interface ILayerBuilder: ButtonColorable {
    val layerTags: List<LayerTag>
    val charSet: CharSet
    val keyboardName: String
    val layerName get() = if(layerTags.isEmpty()) {
        "${keyboardName}${charSet.name}"
    } else {
        val tags = layerTags.map { it.camelCasedName.toPascalCase() }
            .withIndex()
            .joinToString { (index, tag) -> if (index == 0) "($tag)" else tag }
        "${keyboardName}_$tags"
    }
    val isPrimary: Boolean
    val keyboardHandedness: KeyboardHandedness
    val defaultSize: IntSize
    val defaultGestureColors: GestureColors

    fun buttonBuilders(): ButtonBuilders
    fun withBuilders(builders: ButtonBuilders): ILayerBuilder
    override fun invoke(imeService: IMEService): LayerDefinable = object: AbstractLayerDefinition(
        imeService = imeService,
        buttonBuilders = buttonBuilders(),
        name = layerName,
        keyboardHandedness = keyboardHandedness,
        defaultButtonSize = defaultSize,
        isPrimary = isPrimary,
        charSet = this@ILayerBuilder.charSet,
        layerTags = layerTags,
        defaultGestureColors = defaultGestureColors,
        languageLayerTag = layerTags.firstOrNull { it.isAlphabet },
    ){}

    fun copy(
        keyboardName: String = this.keyboardName,
        layerTag: List<LayerTag> = this.layerTags,
        charSets: CharSet = this.charSet,
        isPrimary: Boolean = this.isPrimary,
        keyboardHandedness: KeyboardHandedness = this.keyboardHandedness,
        defaultSize: IntSize = this.defaultSize,
        defaultGestureColors: GestureColors = this.defaultGestureColors,
        builders: ButtonBuilders = this.buttonBuilders(),
    ): ILayerBuilder = object : AbstractLayerBuilder(
        keyboardName,
        layerTag,
        charSets,
        isPrimary,
        keyboardHandedness,
        defaultSize,
        defaultGestureColors,
        builders,
    ){}

    /**
     * @return a new layer builder for use on a different keyboard.
     * (Layers are partially named after the keyboard they are used in).
     */
    fun renameWithKeyboardName(keyboardName: String): ILayerBuilder
}