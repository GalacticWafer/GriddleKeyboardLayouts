package com.galacticwarev2.griddle.domain.design.base.button

import androidx.compose.ui.unit.IntSize
import com.galacticwarev2.griddle.domain.geometry.GridPosition
import com.galacticwarev2.griddle.domain.gesture.GestureData
import com.galacticwarev2.griddle.domain.model.gesture.GestureType
import com.galacticwarev2.griddle.domain.model.type.base.tag.ButtonPaletteTemplate
import com.galacticwarev2.griddle.domain.modifier.GestureColors

data class ButtonInfo(
    val gridPosition: GridPosition,
    val gestureMap: MutableMap<GestureType, GestureData>,
    val size: IntSize,
    val overrideTheme: GestureColors,
    val paletteType: ButtonPaletteTemplate,
    val hotSwapTypes: MutableMap<GestureType, GridPosition> = mutableMapOf(),
    val name: String,
)