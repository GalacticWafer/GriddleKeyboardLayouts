package com.galacticwarev2.griddle.domain.design.base.layer

import com.galacticwarev2.griddle.domain.model.gesture.GestureType
import com.galacticwarev2.griddle.domain.model.type.base.tag.AppSymbol
import com.galacticwarev2.griddle.domain.model.type.base.tag.GesturePaletteTemplate

data class ThemeDisplayInfo(
    val gestureType: GestureType,
    val paletteType: GesturePaletteTemplate,
    val currentText: String,
    val isIndicator: Boolean,
    val legend: AppSymbol?,
)