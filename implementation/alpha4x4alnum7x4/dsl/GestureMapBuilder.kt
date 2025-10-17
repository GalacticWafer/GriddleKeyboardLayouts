package com.galacticware.griddle.domain.design.implementation.alpha4x4alnum7x4.dsl


import com.galacticware.griddle.domain.design.base.button.IButtonBuilder
import com.galacticware.griddle.domain.design.base.button.IButtonBuilder.Companion.button
import com.galacticware.griddle.domain.geometry.GridPosition
import com.galacticware.griddle.domain.design.base.gesture.GestureBinding
import com.galacticware.griddle.domain.gesture.GestureData
import com.galacticware.griddle.domain.model.gesture.GestureMagnitude
import com.galacticware.griddle.domain.model.gesture.GestureType
import com.galacticware.griddle.domain.model.type.base.tag.ButtonPaletteTemplate
import com.galacticware.griddle.domain.model.type.base.tag.GesturePaletteTemplate
import kotlinx.serialization.Serializable

/**
 * Syntactical sugar on button definitions, since that is the part of the code of most interest to
 * contributors (for adding their own language support).
 */
operator fun ButtonPaletteTemplate.invoke(
    name: String,
    rowStart: Int,
    colStart: Int,
    rowSpan: Int,
    colSpan: Int,
    collect: GestureGroupsCollector.() -> Unit
): IButtonBuilder = with (
    GestureGroupsCollector(
        template = this,
        gridPosition = GridPosition(rowStart, colStart, rowSpan, colSpan),
        name = name
    )
) {
    collect()
    build()
}

@Serializable
data class GestureDecorationArgs(
    val template: GesturePaletteTemplate,
    val position: GridPosition,
)

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

class GestureBinder(
    private val palette: GesturePaletteTemplate
) {
    val bindings = mutableListOf<GestureBinding>()
    operator fun GestureBinding.Incubator.unaryPlus() =
        GestureBinding(
            type = type,
            data = GestureData(
                operation,
                modifierSets,
                symbol,
                overrideMetaState,
                palette,
                argsJson,
                duration,
                hotSwapType to palette,
            ),
        )
            .apply { bindings += this }
}