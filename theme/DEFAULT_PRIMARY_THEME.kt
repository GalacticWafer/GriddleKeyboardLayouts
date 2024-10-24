package org.galacticware.griddle.keyboarddefinition.opensource.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.IntSize
import org.galacticware.griddle.domain.modifier.Theme
import org.galacticware.griddle.view.core.AppColor

val DEFAULT_PRIMARY_THEME = Theme(
    primaryTextColor = AppColor.MEOK_DEFAULT_YELLOW.color,
    primaryBackgroundColor = AppColor.MEOK_DARK_GRAY.color,
    primaryBorderColor = AppColor.MEOK_LIGHT_GRAY.color,
)
val DEFAULT_SECONDARY_THEME = Theme(
    primaryBorderColor = AppColor.MEOK_LIGHT_GRAY.color,
    primaryTextColor = Color.White,
    primaryBackgroundColor = AppColor.YELLOW.color,
)

val DEFAULT_FONT_SIZE = 23f
val DEFAULT_SIZE = IntSize(90, 70)