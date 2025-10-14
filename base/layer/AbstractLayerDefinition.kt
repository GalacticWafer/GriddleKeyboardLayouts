package com.galacticwarev2.griddle.domain.design.base.layer

import androidx.compose.ui.unit.IntSize
import com.galacticwarev2.griddle.domain.button.Button
import com.galacticwarev2.griddle.domain.design.base.button.IButtonBuilder
import com.galacticwarev2.griddle.domain.design.base.collection.ButtonBuilders
import com.galacticwarev2.griddle.domain.design.base.collection.IButtonBuilderSet.Companion.toButtonBuilders
import com.galacticwarev2.griddle.domain.input.IMEService
import com.galacticwarev2.griddle.domain.keyboard.KeyboardHandedness
import com.galacticwarev2.griddle.domain.keyboard.KeyboardOffsetAndSize
import com.galacticwarev2.griddle.domain.language.LayerTag
import com.galacticwarev2.griddle.domain.layer.LayerModel
import com.galacticwarev2.griddle.domain.modifier.GestureColors
import com.galacticwarev2.griddle.domain.util.PreferencesHelper
import kotlinx.serialization.Transient
import kotlin.math.roundToInt

/**
 * Base class for a default implementation of [LayerDefinable].
 */
abstract class AbstractLayerDefinition(
    @Transient val imeService: IMEService,
    override var buttonBuilders: ButtonBuilders,
    override val keyboardHandedness: KeyboardHandedness,
    private val defaultButtonSize: IntSize,
    override var defaultGestureColors: GestureColors,
    override val isPrimary: Boolean,
    override val name: String,
    override val charSet: CharSet,
    override val layerTags: List<LayerTag>,
    override val languageLayerTag: LayerTag?,
): LayerDefinable {

    override val model: LayerModel
        get() = LayerModel(
            buttonBuilders.associate {
                it.gridPosition.toString() to it.model
            },
            keyboardHandedness,
            defaultButtonSize,
            defaultGestureColors,
            isPrimary,
            name,
            charSet,
            layerTags,
        )

    override var offsetX = 0f

    /**
     * Define the rowShift as the integer needed for the top-most row to be row 0.
     */
    private val rowShift = buttonBuilders.minOf { f -> f.gridPosition.rowStart }

    /**
     * Define the colShift as the integer needed for the left-most column to be column 0.
     */
    private val colShift = buttonBuilders.minOf { f -> f.gridPosition.colStart }

    private var buttons = run {
        buttonBuilders.map {
            Button(
                gridPosition = it.gridPosition.copy(),
                gestureMap = it.gestureMap,
                widthRuler = it.size.width,
                heightRuler = it.size.height,
                overrideTheme = it.overrideTheme,
                builder = it,
                buttonPaletteTemplate = it.buttonPaletteTag,
            )
        }
            .associateWith { it.gestureMap }
    }


    override val rowSpan: Int get() = buttons.keys.maxOf { it.rowStart + it.rowSpan } - rowShift
    override val colSpan: Int get() = buttons.keys.maxOf { it.colStart + it.colSpan } - colShift

    override fun resizeToFitScreen() {
        val density = imeService.resources.displayMetrics.density
        val screenWidth = imeService.resources.displayMetrics.widthPixels / density
        if(screenWidth <= this.colWidth * this.colSpan) {
            val possibleRowHeight = (this.colWidth / aspectRatio).roundToInt().coerceAtMost(maxRowHeight)
            this.colWidth = (screenWidth / this.colSpan).roundToInt().coerceAtLeast(minColWidth)
            val desiredRowHeight = (screenWidth / aspectRatio).roundToInt()
            this.rowHeight = desiredRowHeight.coerceAtMost(possibleRowHeight).coerceAtLeast(minRowHeight)
        }

        rowHeight = rowHeight.coerceAtLeast(minRowHeight).coerceAtMost(maxRowHeight)
        this.colWidth = (this.rowHeight * aspectRatio).roundToInt().coerceAtMost(maxColWidth)
        saveBoardPositionAndSize(
            KeyboardOffsetAndSize(
                offsetX,
                rowHeight.toFloat(),
                colWidth.toFloat()
            )
        )
    }

    override fun saveBoardPositionAndSize(
        value: KeyboardOffsetAndSize
    ) {
        PreferencesHelper.saveBoardPositionAndSize(imeService, value, this.name)
    }

    override fun withSingleButton(builder: IButtonBuilder): LayerDefinable = object: AbstractLayerDefinition(
        imeService,
        ButtonBuilders(builder),
        keyboardHandedness,
        defaultButtonSize,
        defaultGestureColors,
        isPrimary,
        name,
        charSet,
        layerTags,
        layerTags.firstOrNull { it.isAlphabetic },
    ){}

    override fun copy(builders: LinkedHashSet<IButtonBuilder>): LayerDefinable = object: AbstractLayerDefinition(
        imeService,
        builders.toButtonBuilders(),
        keyboardHandedness,
        defaultButtonSize, 
        defaultGestureColors,
        isPrimary,
        name,
        charSet,
        layerTags,
        layerTags.firstOrNull { it.isAlphabetic },
    ){}

    override val maxColWidth: Int
        get() = run {
            (imeService.resources.displayMetrics.let {
                it.widthPixels / it.density
            } / colSpan).toInt()
        }
    override val minColWidth: Int
        get() = (maxColWidth / 2).coerceAtLeast(35)

    override val maxRowHeight: Int
        get() = run {
            (imeService.resources.displayMetrics.let {
                it.heightPixels * .45 / it.density
            } / rowSpan).toInt()
        }
    override val minRowHeight: Int
        get() = maxRowHeight / 2
    override val originalColWidth: Int get() = defaultButtonSize.width

    override val originalRowHeight: Int get() = defaultButtonSize.height

    private val aspectRatio get() = this.originalColWidth.toDouble() / this.originalRowHeight

    override fun toString(): String = charSet.toString()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is AbstractLayerDefinition) return false

        return charSet == other.charSet
    }

    override fun hashCode(): Int {
        var result = charSet.hashCode()
        result = 31 * result + rowSpan
        result = 31 * result + rowShift
        result = 31 * result + colSpan
        result = 31 * result + colShift
        result = 31 * result + originalColWidth.hashCode()
        result = 31 * result + originalColWidth.hashCode()
        result = 31 * result + buttons.hashCode()
        return result
    }

    override var rowHeight = defaultButtonSize.height
    override var colWidth = defaultButtonSize.width


    init {
        offsetX = try {
            PreferencesHelper.getBoardPositionAndSize(imeService, this::class.qualifiedName!!)
                .offsetX
        } catch (e: NullPointerException) {
            0f
        }
    }
}