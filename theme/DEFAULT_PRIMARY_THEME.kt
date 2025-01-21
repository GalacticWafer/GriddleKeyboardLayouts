package com.galacticware.griddle.keyboarddefinition.opensource.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntSize
import com.galacticware.griddle.domain.modifier.ModifierTheme
import com.galacticware.griddle.view.core.AppColor

val DEFAULT_PRIMARY_THEME = ModifierTheme(
    primaryTextColor = AppColor.MEOK_DEFAULT_YELLOW.color,
    primaryBackgroundColor = AppColor.MEOK_DARK_GRAY.color,
    primaryBorderColor = AppColor.MEOK_LIGHT_GRAY.color,
)
val DEFAULT_SECONDARY_THEME = ModifierTheme(
    primaryBorderColor = AppColor.MEOK_LIGHT_GRAY.color,
    primaryTextColor = Color.White,
    primaryBackgroundColor = AppColor.YELLOW.color,
)

val DEFAULT_FONT_SIZE = 23f
val DEFAULT_SIZE = IntSize(90, 70)