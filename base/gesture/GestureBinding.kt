package com.galacticware.griddle.domain.design.base.gesture

import com.galacticware.griddle.domain.gesture.GestureData
import com.galacticware.griddle.domain.gesture.HotSwapGestureType
import com.galacticware.griddle.domain.gesture.ModifierSets
import com.galacticware.griddle.domain.model.gesture.GestureType
import com.galacticware.griddle.domain.model.type.base.tag.AppSymbol
import com.galacticware.griddle.domain.model.type.base.tag.ForegroundEntity
import com.galacticware.griddle.domain.model.type.base.tag.GesturePaletteTemplate
import com.galacticware.griddle.domain.model.type.base.tag.ModifierKeyKind
import com.galacticware.griddle.domain.operation.base.Operation
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient


/**
 * Simple data class to simplify passing around an assigned gesture with its data.
 */
@Serializable
data class GestureBinding(
    val type: GestureType,
    @Transient val data: GestureData = GestureData.Companion.EMPTY_DATA,
): ForegroundEntity {
    fun pair() =  type to data

    // Our DSL requires the color palette to be loaded after we have collected data for gestures.
    // Therefore, we *almost* have eveything we need to create a gesture binding. This Incubator
    // is returned, and used to complete the creation of a gesture binding some time in the future.
    data class Incubator(
        val type: GestureType,
        val operation: Operation,
        val modifiers: Set<ModifierKeyKind>,
        val modifierSets: ModifierSets,
        val symbol: AppSymbol? = null,
        val overrideMetaState: Boolean = false,
        val argsJson: String?,
        val duration: Long,
        val hotSwapType: HotSwapGestureType? = null,
    ) {
        internal var color: GesturePaletteTemplate? = null

        fun default() = build(GesturePaletteTemplate.BrightMonochromeColor)

        fun build(colors: GesturePaletteTemplate): GestureBinding = GestureBinding(
                type,
            GestureData(
                operation,
                modifierSets,
                symbol,
                overrideMetaState,
                colors,
                argsJson,
                duration,
                hotSwapType to colors,
            ),
        )
    }
}