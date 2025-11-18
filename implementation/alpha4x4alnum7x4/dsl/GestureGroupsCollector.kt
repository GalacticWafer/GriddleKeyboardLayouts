package com.galacticware.griddle.domain.design.implementation.alpha4x4alnum7x4.dsl


import com.galacticware.griddle.domain.design.base.button.IButtonBuilder
import com.galacticware.griddle.domain.design.base.button.IButtonBuilder.Companion.button
import com.galacticware.griddle.domain.design.base.gesture.GestureBinding
import com.galacticware.griddle.domain.geometry.GridPosition
import com.galacticware.griddle.domain.model.gesture.GestureMagnitude
import com.galacticware.griddle.domain.model.gesture.GestureType
import com.galacticware.griddle.domain.visual.ButtonPaletteTemplate
import com.galacticware.griddle.domain.visual.GesturePaletteTemplate
import kotlinx.serialization.Serializable


@Serializable
class GestureGroupsCollector(
    private val template: ButtonPaletteTemplate,
    private val gridPosition: GridPosition,
    private val name: String,
) {
    private val allBindings = mutableMapOf<GestureType, GestureBinding>()

    fun use(
        palette: GesturePaletteTemplate,
        block: GestureBinder.(GestureDecorationArgs) -> Unit
    ) {
        val binder = GestureBinder(palette)
        binder.block(GestureDecorationArgs(palette, gridPosition))
        allBindings.putAll(binder.bindings.associate { it.type to it })
    }

    fun build(): IButtonBuilder = button(
        buttonPaletteTemplate = template,
        rowStart = gridPosition.rowStart,
        rowSpan = gridPosition.rowSpan,
        colStart = gridPosition.colStart,
        colSpan = gridPosition.colSpan,
        gestureMap = allBindings.entries
            .flatMap {
                val t = GestureType(it.key.gestureShape, GestureMagnitude.LARGE, it.key.direction)
                listOf(it.key to it.value, if(t !in allBindings.keys) {
                    t to it.value
                } else null)
                    .mapNotNull { it }
            }
            .associate { it.first to it.second.data }
            .toMutableMap(),
        name = name,
    )
}