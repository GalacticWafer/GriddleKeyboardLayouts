package com.galacticware.griddle.model.keyboard.definition.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntSize
import com.galacticware.griddle.model.modifier.ModifierTheme
import com.galacticware.griddle.view.core.AppColor
val defaultTextColorTriple = Triple(Color.White, AppColor.YELLOW.color, Color.Red)
val unShiftTextColorTriple = Triple(Color.Transparent, Color.Transparent, Color.Red)
val modifierTextColorTriple = Triple(Color.Black, Color.Black, Color.Black)
val modifierBackgroundColorTriple = Triple(Color.Transparent, Color.Yellow, Color.Green)
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
