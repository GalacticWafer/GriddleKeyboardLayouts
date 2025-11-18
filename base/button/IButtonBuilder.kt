package com.galacticware.griddle.domain.design.base.button

import androidx.compose.ui.unit.IntSize
import com.galacticware.griddle.domain.button.Button
import com.galacticware.griddle.domain.button.ButtonBuilder
import com.galacticware.griddle.domain.button.ButtonModel
import com.galacticware.griddle.domain.design.base.layer.CharSet
import com.galacticware.griddle.domain.design.implementation.alpha4x4alnum7x4.Alpha4X4AlphaNum7X4KeyboardDefinition
import com.galacticware.griddle.domain.design.implementation.alpha4x4alnum7x4.DEFAULT_SIZE
import com.galacticware.griddle.domain.geometry.GridPosition
import com.galacticware.griddle.domain.design.base.gesture.GestureBuilder
import com.galacticware.griddle.domain.gesture.GestureData
import com.galacticware.griddle.domain.layer.AppEntity
import com.galacticware.griddle.domain.model.gesture.GestureType
import com.galacticware.griddle.domain.visual.ButtonPaletteTemplate
import com.galacticware.griddle.domain.visual.Colorable
import com.galacticware.griddle.domain.visual.GesturePaletteTemplate
import com.galacticware.griddle.domain.modifier.GestureColors
import com.galacticware.griddle.domain.design.base.gesture.GestureBinding
import com.galacticware.griddle.domain.design.base.gesture.ViewModelUser

interface IButtonBuilder: AppEntity<ButtonModel>, Colorable, () -> Button {
    val info: ButtonInfo
    val gridPosition: GridPosition get() = info.gridPosition
    val gestureSetAbbreviation: String get() = "{${gestureMap.keys.joinToString("|") {
        it.toString()
    }}}"

    fun  MutableMap<GestureType, GestureData>.putAll(vararg bindings: GestureBinding)
        = gestureMap.putAll(bindings.map { it.pair() })

    fun with(vararg bindings: GestureBinding) = copy().apply { gestureMap.putAll(*bindings) }

    val gestureMap: MutableMap<GestureType, GestureData> get() = info.gestureMap
    val size: IntSize get() = info.size
    val overrideTheme: GestureColors get() = info.overrideTheme
    val buttonPaletteTemplate: ButtonPaletteTemplate

    override val model: ButtonModel get() {

        return ButtonModel(
            gridPosition,
            gestureMap.toMutableModelMap { Pair(it.key, it.value.model) },
            size,
            overrideTheme,
            buttonPaletteTemplate,
            info.name,
        )
    }

    operator fun get(prototype: GestureBuilder) = gestureMap[prototype.type]

    val colStart get() = gridPosition.colStart
    val colSpan get() = gridPosition.colSpan
    val rowStart get() = gridPosition.rowStart
    val rowSpan get() = gridPosition.rowSpan

    /**
     * Return a deep copy of this [ButtonBuilder] with a new position according to the
     * parameters.
     */
    fun at(
        colStart: Int = gridPosition.colStart,
        rowStart: Int = gridPosition.rowStart,
        colSpan: Int = gridPosition.colSpan,
        rowSpan: Int = gridPosition.rowSpan,
    ): ButtonBuilder = at(
        GridPosition(
            rowStart = rowStart,
            colStart = colStart,
            rowSpan = rowSpan,
            colSpan = colSpan,
        )
    )

    /**
     * Return a deep copy of this [ButtonBuilder] with a new position according to the
     * parameters.
     */
    fun at(gridPosition: GridPosition): ButtonBuilder = copy(gridPosition = gridPosition)

    /**
     * Return a deep copy of this [ButtonBuilder] with a new position according to the
     * parameters.
     */
    fun withDefaultSize(size: IntSize): ButtonBuilder = copy(size = size)

    /**
     * Return a deep copy of this GestureButtonBuilder with a new gesture according to the
     * parameters.
     */
    fun addAssignments(
        vararg moreGestures: Pair<GestureBinding.Incubator, GesturePaletteTemplate>,
    ) = run {
        copy(gestureMap = gestureMap
            .map { it.key to it.value }
            .associate { it }
            .toMutableMap()
            .apply {
                putAll(
                    moreGestures.map { (incubator, template) ->
                        incubator.build(template).pair()
                    }
                )
            }
        )
    }

    /**
     * Removes the first gesture that matches the given function.
     */
    fun withoutGesture(function: (GestureData) -> Boolean): ButtonBuilder = copy().apply {
        gestureMap.entries.firstOrNull { function(it.value) }?.key?.let {
            gestureMap.remove(it)
        }
    }

    /**
     * Removes the first gesture that matches the given function.
     */
    fun withoutGestures(vararg predicates: (GestureType) -> Boolean): ButtonBuilder =
        predicates.fold(copy()) { copy, function ->
            copy.apply {
                gestureMap.apply {
                    forEach {
                        if(function(it.key)) {
                            remove(it.key)
                        }
                    }
                }
            }
        }

    /**
     * Removes all gestures that input letters.
     */
    fun withoutLetters(): ButtonBuilder = copy(
        gestureMap = gestureMap.mapNotNull { (type, assignment) ->
            if (assignment.currentText.let {it.length > 1 ||  it.isNotEmpty() && it[0].isLetter()}) {
                null
            } else {
                type to assignment.copy()
            }
        }.associate { it }.toMutableMap()
    )

    /**
     * Removes all gestures that input letters.
     */
    fun renameTo(name: String): ButtonBuilder = copy(
        name = name
    )

    /**
     * Removes all gestures that input numbers.
     */
    fun withoutNumbers(charSets: Set<CharSet>) = copy(
        gestureMap = gestureMap.apply {
            filter { (_, assignment) ->
                assignment.currentText.let {
                    it.length == 1 && it[0].isDigit()
                }
            }
        }
    )

    /**
     * Replace all gestures with the provided gestures.
     */
    fun replaceGesturesWith(
        vararg replacementGestures: Pair<GestureBinding.Incubator, GesturePaletteTemplate>,
    ): ButtonBuilder {
        val copy = copy()
        copy.gestureMap.clear()
        copy.gestureMap.putAll(replacementGestures.map { (incubator, template) ->
            incubator.build(template).pair()
        })
        return copy
    }

    fun updateGesture(gesture: GestureType, assignment: GestureData) {
        gestureMap.entries.first { it == gesture }
        gestureMap[gesture] = assignment
    }

    fun copy(
        gestureMap: MutableMap<GestureType, GestureData> = this.gestureMap.entries.associate { it.key.copy() to it.value.copy() }.toMutableMap(),
        paletteType: ButtonPaletteTemplate = this.buttonPaletteTemplate,
        size: IntSize = this.size,
        gridPosition: GridPosition = this.gridPosition,
        overrideTheme: GestureColors = this.overrideTheme,
        name: String = this.info.name,
    ) = ButtonBuilder(
        gridPosition = gridPosition,
        gestureSet = gestureMap,
        size = IntSize(size.width, size.height),
        overrideTheme = overrideTheme.copy(),
        buttonPaletteTemplate = paletteType,
        name = name,
    )

    /**
     * @return the compliment of the passed filterFunction
     */
    fun without(
        filterFunction: (GestureType) -> Boolean
    ) = copy(
        gestureMap = gestureMap.keys.filter(filterFunction).let { filtered ->
            gestureMap.filter { it.key in filtered }
        }.toMutableMap()
    )

    companion object : ViewModelUser() {
        fun button(
            buttonPaletteTemplate: ButtonPaletteTemplate,
            rowStart: Int,
            colStart: Int,
            rowSpan: Int,
            colSpan: Int,
            gestureMap: MutableMap<GestureType, GestureData>,
            name: String,
        ) = ButtonBuilder(
            gridPosition = GridPosition(rowStart = rowStart, colStart = colStart, rowSpan = rowSpan, colSpan = colSpan),
            size = DEFAULT_SIZE,
            overrideTheme = Alpha4X4AlphaNum7X4KeyboardDefinition.defaultGestureColors,
            buttonPaletteTemplate = buttonPaletteTemplate,
            gestureSet = gestureMap,
            name = name,
        ) as IButtonBuilder
    }
}