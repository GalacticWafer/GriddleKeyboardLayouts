package com.galacticware.griddle.domain.design.base.layer

import com.galacticware.griddle.domain.button.Button

data class ButtonDisplayInfo(
    val button: Button,
    val themes: Set<ThemeDisplayInfo>,
)
