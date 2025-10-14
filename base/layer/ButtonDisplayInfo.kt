package com.galacticwarev2.griddle.domain.design.base.layer

import com.galacticwarev2.griddle.domain.button.Button

data class ButtonDisplayInfo(
    val button: Button,
    val themes: Set<ThemeDisplayInfo>,
)
