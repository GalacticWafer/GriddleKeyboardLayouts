package com.galacticware.griddle.domain.design.base.layer

import android.content.Context
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.galacticware.griddle.domain.design.base.button.IButtonBuilder
import com.galacticware.griddle.domain.keyboard.KeyboardHandedness
import com.galacticware.griddle.domain.keyboard.KeyboardOffsetAndSize
import com.galacticware.griddle.domain.design.base.collection.ButtonBuilders
import com.galacticware.griddle.domain.geometry.GridPosition
import com.galacticware.griddle.domain.gesture.GestureData
import com.galacticware.griddle.domain.language.LayerTag
import com.galacticware.griddle.domain.layer.AppEntity
import com.galacticware.griddle.domain.layer.LayerModel
import com.galacticware.griddle.domain.model.gesture.GestureType
import com.galacticware.griddle.domain.visual.Colorable
import com.galacticware.griddle.domain.modifier.GestureColors
import com.galacticware.griddle.domain.registrar.LayerPositionRegistrationKey

/**
 * Interface for all layers such that they all provide a singleton instance of their class, and
 * provide a way to load their GestureButtons for the corresponding layer.
 */
interface LayerDefinable: AppEntity<LayerModel>, Colorable, Comparable<LayerDefinable> {
    val name: String
    val isPrimary: Boolean
    val languageLayerTag: LayerTag?
    var defaultGestureColors: GestureColors
    var buttonBuilders: ButtonBuilders
    val charSet: CharSet
    val layerTags: List<LayerTag>
    val keyboardHandedness: KeyboardHandedness
    var rowHeight: Int
    var colWidth: Int
    val colSpan: Int
    val rowSpan: Int
    val originalRowHeight: Int
    val originalColWidth: Int
    val minBoardHeight get() = 100.dp
    val maxBoardHeight get() = 700.dp
    val minRowHeight get() = 50
    val maxRowHeight get() = 100
    val minColWidth get() = 70
    val registrationKey get() = LayerPositionRegistrationKey(IntSize(originalColWidth, originalRowHeight), rowSpan, colSpan)
    val maxColWidth get() = run {
        val originalAspectRatio = originalColWidth / originalRowHeight
        return@run (originalAspectRatio * rowHeight).let {
            if (it < minColWidth) minColWidth else it
        }
    }
    var offsetX: Float

    fun minBoardWidth(context: Context) = (context.resources.displayMetrics.widthPixels * .33f)
    fun maxBoardWidth(context: Context) = context.resources.displayMetrics.widthPixels

    fun resizeToFitScreen()
    fun saveBoardPositionAndSize(value: KeyboardOffsetAndSize)
    fun copy(builders: ButtonBuilders): LayerDefinable
    fun withSingleButton(button: IButtonBuilder): LayerDefinable

    override fun compareTo(other: LayerDefinable): Int = charSet.compareTo(other.charSet)
    fun remap(position: GridPosition, type: GestureType, data: GestureData): LayerDefinable
}