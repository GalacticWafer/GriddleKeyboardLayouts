package com.galacticware.griddle.domain.design.base.layer

import com.galacticware.griddle.domain.model.gesture.GestureType
import com.galacticware.griddle.domain.model.type.base.tag.AppSymbol
import com.galacticware.griddle.domain.visual.GesturePaletteTemplate

data class ThemeDisplayInfo(
    val gestureType: GestureType,
    val paletteType: GesturePaletteTemplate,
    val currentText: String,
    val isIndicator: Boolean,
    val legend: AppSymbol?,
)