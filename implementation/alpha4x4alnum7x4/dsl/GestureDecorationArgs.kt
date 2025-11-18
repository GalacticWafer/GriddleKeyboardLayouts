package com.galacticware.griddle.domain.design.implementation.alpha4x4alnum7x4.dsl

import com.galacticware.griddle.domain.geometry.GridPosition
import com.galacticware.griddle.domain.visual.GesturePaletteTemplate
import kotlinx.serialization.Serializable

@Serializable
data class GestureDecorationArgs(
    val template: GesturePaletteTemplate,
    val position: GridPosition,
)