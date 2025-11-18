package com.galacticware.griddle.domain.design.base.button

import androidx.compose.ui.unit.IntSize
import com.galacticware.griddle.domain.geometry.GridPosition
import com.galacticware.griddle.domain.gesture.GestureData
import com.galacticware.griddle.domain.model.gesture.GestureType
import com.galacticware.griddle.domain.visual.ButtonPaletteTemplate
import com.galacticware.griddle.domain.modifier.GestureColors

data class ButtonInfo(
    val name: String,
    val gridPosition: GridPosition,
    val gestureMap: MutableMap<GestureType, GestureData>,
    val size: IntSize,
    val overrideTheme: GestureColors,
    val paletteType: ButtonPaletteTemplate,
    val hotSwapTypes: MutableMap<GestureType, GridPosition> = mutableMapOf(),
)