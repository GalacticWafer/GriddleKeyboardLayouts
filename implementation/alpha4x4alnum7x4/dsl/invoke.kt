package com.galacticware.griddle.domain.design.implementation.alpha4x4alnum7x4.dsl

import com.galacticware.griddle.domain.design.base.button.IButtonBuilder
import com.galacticware.griddle.domain.geometry.GridPosition
import com.galacticware.griddle.domain.visual.ButtonPaletteTemplate

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