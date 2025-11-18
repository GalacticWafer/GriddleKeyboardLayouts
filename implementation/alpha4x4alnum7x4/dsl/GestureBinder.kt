package com.galacticware.griddle.domain.design.implementation.alpha4x4alnum7x4.dsl

import com.galacticware.griddle.domain.design.base.gesture.GestureBinding
import com.galacticware.griddle.domain.gesture.GestureData
import com.galacticware.griddle.domain.visual.GesturePaletteTemplate
import kotlin.collections.mutableListOf
import kotlin.collections.plusAssign

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