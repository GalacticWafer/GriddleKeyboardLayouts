package org.galacticware.griddle.keyboarddefinition.opensource.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.IntSize
import org.galacticware.griddle.domain.modifier.ModifierTheme
import org.galacticware.griddle.view.core.AppColor

val DEFAULT_PRIMARY_THEME = ModifierTheme(
    primaryTextColor = AppColor.MEOK_DEFAULT_YELLOW.color.toArgb(),
    primaryBackgroundColor = AppColor.MEOK_DARK_GRAY.color.toArgb(),
    primaryBorderColor = AppColor.MEOK_LIGHT_GRAY.color.toArgb(),
)
val DEFAULT_SECONDARY_THEME = ModifierTheme(
    primaryBorderColor = AppColor.MEOK_LIGHT_GRAY.color.toArgb(),
    primaryTextColor = Color.White.toArgb(),
    primaryBackgroundColor = AppColor.YELLOW.color.toArgb(),
)

val DEFAULT_FONT_SIZE = 23f
val DEFAULT_SIZE = IntSize(90, 70)