package com.galacticware.griddle.domain.design.base.gesture

import androidx.compose.ui.graphics.Color
import com.galacticware.griddle.domain.gesture.GestureData.Companion.EMPTY_DATA
import com.galacticware.griddle.domain.design.base.layer.CharSet
import com.galacticware.griddle.domain.design.base.layer.CharSet.Companion.id
import com.galacticware.griddle.domain.geometry.GridPosition
import com.galacticware.griddle.domain.gesture.GestureData
import com.galacticware.griddle.domain.gesture.HotSwapGestureType
import com.galacticware.griddle.domain.gesture.modifierFollowerMap
import com.galacticware.griddle.domain.language.LayerTag
import com.galacticware.griddle.domain.model.geometry.CompassDirection
import com.galacticware.griddle.domain.model.geometry.CompassDirection.*
import com.galacticware.griddle.domain.model.geometry.OrientationMeasurement
import com.galacticware.griddle.domain.model.geometry.RotationDirection.*
import com.galacticware.griddle.domain.model.gesture.GestureShape
import com.galacticware.griddle.domain.model.gesture.GestureShape.BOOMERANG
import com.galacticware.griddle.domain.model.gesture.GestureShape.CIRCLE
import com.galacticware.griddle.domain.model.gesture.GestureShape.PRESS
import com.galacticware.griddle.domain.model.gesture.GestureShape.SWIPE
import com.galacticware.griddle.domain.model.gesture.GestureMagnitude
import com.galacticware.griddle.domain.model.gesture.GestureMagnitude.LARGE
import com.galacticware.griddle.domain.model.gesture.GestureMagnitude.SMALL
import com.galacticware.griddle.domain.model.gesture.GestureType
import com.galacticware.griddle.domain.model.type.base.tag.AppSymbol
import com.galacticware.griddle.domain.visual.IndicatorOverrideColorTag.OVERRIDE_BACKGROUND_COLOR
import com.galacticware.griddle.domain.visual.IndicatorOverrideColorTag.OVERRIDE_BORDER_COLOR
import com.galacticware.griddle.domain.visual.IndicatorOverrideColorTag.OVERRIDE_FOREGROUND_COLOR
import com.galacticware.griddle.domain.visual.IndicatorOverrideColorTag.OVERRIDE_TEXT
import com.galacticware.griddle.domain.model.type.base.tag.ModifierKeyKind
import com.galacticware.griddle.domain.model.type.base.tag.TextElement.TEXT_ELEMENT_CHARS
import com.galacticware.griddle.domain.model.type.base.tag.TextElement.TEXT_ELEMENT_FONT
import com.galacticware.griddle.domain.model.type.base.tag.TextElement.TEXT_ELEMENT_SIZE
import com.galacticware.griddle.domain.model.type.base.tag.TypeTag
import com.galacticware.griddle.domain.modifier.AppColor
import com.galacticware.griddle.domain.modifier.AppModifierEntity
import com.galacticware.griddle.domain.modifier.sets.IModifierSet
import com.galacticware.griddle.domain.modifier.GestureText
import com.galacticware.griddle.domain.modifier.ModifierCycleDirection
import com.galacticware.griddle.domain.modifier.ModifierManipulation
import com.galacticware.griddle.domain.modifier.sets.GestureDisplayTextSet
import com.galacticware.griddle.domain.modifier.sets.ModifierColorSet
import com.galacticware.griddle.domain.operation.base.Operation
import com.galacticware.griddle.domain.operation.base.ParameterizedOperation
import com.galacticware.griddle.domain.operation.implementation.noargs.accentchars.CycleAccentCharacters
import com.galacticware.griddle.domain.operation.implementation.noargs.noop.NoOp
import com.galacticware.griddle.domain.operation.implementation.noargs.repeatable.IRepeatable
import com.galacticware.griddle.domain.operation.implementation.someargs.inserttext.InsertText
import com.galacticware.griddle.domain.operation.implementation.someargs.inserttext.InsertTextArgs
import com.galacticware.griddle.domain.operation.implementation.someargs.changemodifier.ChangeModifier
import com.galacticware.griddle.domain.operation.implementation.someargs.changemodifier.ChangeModifier.applyModifierColorization
import com.galacticware.griddle.domain.operation.implementation.someargs.changemodifier.ChangeModifierArgs
import com.galacticware.griddle.domain.operation.implementation.someargs.presskey.PressKey
import com.galacticware.griddle.domain.operation.implementation.someargs.presskey.PressKeyArgs
import com.galacticware.griddle.domain.operation.implementation.someargs.switchlanguage.SwitchLanguage
import com.galacticware.griddle.domain.operation.implementation.someargs.switchlanguage.SwitchLanguageArgs
import com.galacticware.griddle.domain.operation.implementation.someargs.switchlayer.SwitchLayer
import com.galacticware.griddle.domain.operation.implementation.someargs.switchlayer.SwitchLayerArgs
import com.galacticware.griddle.domain.operation.implementation.someargs.switchscreens.SwitchScreenArgs
import com.galacticware.griddle.domain.operation.implementation.someargs.switchscreens.SwitchScreens
import com.galacticware.griddle.domain.view.colorization.Hue
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.serializer
import com.galacticware.griddle.util.GriddleJson


abstract class AbstractGestureBuilder(
    gestureShape: GestureShape,
    gestureSize: GestureMagnitude,
    direction: OrientationMeasurement? = null
): Gesture(EMPTY_DATA, GestureType(gestureShape, gestureSize, direction)), IGestureBuilder {
    /**
     * Helper method for specifying a Triple of <lowerCase, uppercase, uppercase>
     * Strings to use for key legends.
     */
    fun reversedCase(
        threeStrings: Triple<String, String, String>,
        hotSwapType: HotSwapGestureType? = null,
    ) = assign(
        InsertText,
        string1 = threeStrings.first,
        string2 = threeStrings.second,
        string3 = threeStrings.third,
        respectShift = false, hotSwapType = hotSwapType,
    )

    /**
     * Create a gesture binding that can listen for and execute repeatable operations.
     */
    fun listen(legend: AppSymbol.KeyLegend? = null)
    = assign(NoOp, legend, hotSwapType =  HotSwapGestureType.LISTENER)

    /**
     * This is the function that all other methods in this interface call, in order to create a
     * GestureBinding.Incubator, which can later be added to a gestureMap.
     */
    fun assign(
        operation: Operation,
        legend: AppSymbol? = operation.legend,
        string1: String? = legend?.value,
        string2: String? = string1,
        string3: String? = string2,
        isIndicator: Boolean = false,
        modifiers: Set<ModifierKeyKind> = setOf(),
        respectShift: Boolean = true, keycode: Int? = null,
        charSet: CharSet? = null,
        changeModifierArgs: ChangeModifierArgs? = null,
        switchScreenArgs: SwitchScreenArgs? = null,
        duration: Long = -1L,
        modifierSetMap: ModifierSets
        = ModifierSets(modifierFollowerMap().apply {
            if (changeModifierArgs != null) {
                applyModifierColorization(changeModifierArgs, legend, string1, string2, string3)
            } else {
                put(
                    TEXT_ELEMENT_FONT, GestureDisplayTextSet(
                        ModifierKeyKind.SHIFT,
                        GestureText(string1),
                        GestureText(string2),
                        GestureText(string3),
                    )
                )
                put(
                    TEXT_ELEMENT_SIZE, GestureDisplayTextSet(
                        ModifierKeyKind.SHIFT,
                        GestureText(string1),
                        GestureText(string2),
                        GestureText(string3),
                    )
                )
                put(
                    TEXT_ELEMENT_CHARS, GestureDisplayTextSet(
                        ModifierKeyKind.SHIFT,
                        GestureText(string1),
                        GestureText(string2),
                        GestureText(string3),
                    )
                )
            }
        }),
        hotSwapType: HotSwapGestureType? = null,
        modifierCycleDirection: ModifierCycleDirection? = null
    ): GestureBinding.Incubator = when(operation) {
        is ParameterizedOperation<*> -> encodeOperationArgs(
            operation,
            modifiers,
            string1,
            keycode,
            respectShift, charSet,
            changeModifierArgs, switchScreenArgs, modifierCycleDirection
        )
        else -> null
    }.let { args ->
        GestureBinding.Incubator(type, operation, modifiers, modifierSetMap, legend, isIndicator, args, duration, hotSwapType)
    }


    @OptIn(InternalSerializationApi::class)
    fun encodeOperationArgs(
        operation: Operation,
        modifiers: Set<ModifierKeyKind>,
        label: String?,
        keycode: Int?,
        respectShift: Boolean,
        switchCharSet: CharSet?,
        handleModifierArgs: ChangeModifierArgs?,
        switchScreenArgs: SwitchScreenArgs?,
        modifierCycleDirection: ModifierCycleDirection?,
    ) = when(operation) {

        InsertText -> GriddleJson.encodeToString(
            InsertTextArgs::class.serializer(), InsertTextArgs(modifiers, label!!, respectShift)
        )

        PressKey -> GriddleJson.encodeToString(
            PressKeyArgs::class.serializer(), PressKeyArgs(
                modifierKeys = modifiers,
                keycode!!,
                respectShift,
                overrideMetaState = false
            )
        )

        SwitchLayer -> GriddleJson.encodeToString(
            SwitchLayerArgs::class.serializer(),
            SwitchLayerArgs(switchCharSet!!)
        )

        SwitchScreens -> GriddleJson.encodeToString(
            SwitchScreenArgs::class.serializer(),
            switchScreenArgs!!
        )

        ChangeModifier -> GriddleJson.encodeToString(
            ChangeModifierArgs::class.serializer(),
            handleModifierArgs!!
        )

        SwitchLanguage -> GriddleJson.encodeToString(
            SwitchLanguageArgs::class.serializer(),
            SwitchLanguageArgs(modifierCycleDirection!!)
        )

        else -> throw UnsupportedOperationException()
    }
}

abstract class GestureBuilder(
    gestureShape: GestureShape,
    gestureSize: GestureMagnitude,
    direction: OrientationMeasurement? = null
): AbstractGestureBuilder(gestureShape, gestureSize, direction) {
    fun switchLayer(
        charSet: CharSet,
        hotSwapType: HotSwapGestureType? = null,
    ) = assign(
        SwitchLayer,
        charSet = charSet,
        legend = charSet.symbol,
        hotSwapType = hotSwapType,
    )

    override fun switchLayer(
        vararg layerTag: LayerTag,
        hotSwapType: HotSwapGestureType?,
    ) = switchLayer(id(*layerTag), hotSwapType)

    override fun switchScreens(
        switchScreenArgs: SwitchScreenArgs,
        hotSwapType: HotSwapGestureType?,
    ) = assign(
        SwitchScreens,
        switchScreenArgs = switchScreenArgs,
        legend = switchScreenArgs.screenSwitch.legend,
        hotSwapType = hotSwapType,
    )

    override fun insertText(
        threeStrings: Triple<String, String, String>,
        hotSwapType: HotSwapGestureType?,
    ) = assign(
        InsertText,
        string1 = threeStrings.first,
        string2 = threeStrings.second,
        string3 = threeStrings.third,
        hotSwapType = HotSwapGestureType.SIGNAL
    )

    override fun cycleAccentCharacters() = assign(
        CycleAccentCharacters,
        AppSymbol.CYCLE_ACCENTED_CHARS_LEGEND,
    )

    override fun switchLanguage(
        modifierCycleDirection: ModifierCycleDirection
    ) = assign(
        SwitchLanguage,
        modifierCycleDirection = modifierCycleDirection
    )

    override fun insertText(
        unpressedStateText: String,
        oneShotStateText: String,
        persistentStateText: String,
    ) = insertText(
        threeStrings = Triple(unpressedStateText, oneShotStateText, persistentStateText),
        hotSwapType = HotSwapGestureType.SIGNAL
    )

    /**
     * Bind this gesture to press a key. Provide an legend or [threeStrings] to include avisual
     * representation.
     */
    override fun pressKey(
        keycode: Int,
        modifiers: Set<ModifierKeyKind>,
        respectShift: Boolean,
        legend: AppSymbol?,
        label: String?,
    ): GestureBinding.Incubator = assign(
        PressKey,
        keycode = keycode,
        modifiers = modifiers,
        respectShift = respectShift,
        legend = legend,
        string1 = label,
        hotSwapType = HotSwapGestureType.SIGNAL
    )

    override fun changeModifier(
        changeModifierArgs: ChangeModifierArgs.Incubator,
    ) = assign(
        ChangeModifier,
        legend = changeModifierArgs().legend,
        isIndicator = true,
        changeModifierArgs = changeModifierArgs.invoke(),
        hotSwapType = if(changeModifierArgs.modifierManipulation == ModifierManipulation.CYCLE) HotSwapGestureType.SIGNAL else null
    )

    override fun repeat(iRepeatable: IRepeatable)
    = assign(iRepeatable.repeatableOperation, hotSwapType = HotSwapGestureType.SIGNAL)


    operator fun invoke(positionProvider: GestureBuilder.() -> Any) {
        (positionProvider(this) as? GridPosition)?.let {
            this.parentButton = blankButton.at(it)
        }
    }

    fun at(
        rowStart:Int = 0, colStart:Int = 0, rowSpan:Int = 1, colSpan:Int = 2
    ) = GridPosition(rowStart = rowStart, colStart = colStart, rowSpan = rowSpan, colSpan = colSpan)
}


/**
 * Helper method to create an override modifier theme for ctrl, alt, or shift.
 */
fun MutableMap<TypeTag, IModifierSet<out AppModifierEntity>>.applyModifierColorization(
    changeModifierArgs: ChangeModifierArgs,
    legend: AppSymbol?,
    string1: String?,
    string2: String?,
    string3: String?
) {
    val modifierKeyKind = changeModifierArgs.modifierKeyKind
    when (legend) {
        AppSymbol.APPLY_SHIFT_SYMBOL -> {
            put(
                OVERRIDE_TEXT, GestureDisplayTextSet(
                    modifierKeyKind,
                    GestureText(string1),
                    GestureText(string1),
                    GestureText(""),
                )
            )
        }

        AppSymbol.RELEASE_SHIFT_SYMBOL -> {
            put(
                OVERRIDE_TEXT, GestureDisplayTextSet(
                    modifierKeyKind,
                    GestureText(""),
                    GestureText(string1),
                    GestureText(string1),
                )
            )
        }
        // Ctrl and Alt
        else -> {
            put(
                OVERRIDE_TEXT, GestureDisplayTextSet(
                    modifierKeyKind,
                    GestureText(string1),
                    GestureText(string2),
                    GestureText(string3),
                )
            )
        }
    }
    when (legend) {
        AppSymbol.RELEASE_SHIFT_SYMBOL -> {
            // The unshift modifier is the only modifier symbol that is not always visible
            put(
                OVERRIDE_FOREGROUND_COLOR, ModifierColorSet(
                    changeModifierArgs.modifierKeyKind,
                    AppColor(Color.Transparent),
                    AppColor(Hue.modifierGrayBackground),
                    AppColor(Hue.modifierGrayBackground),
                )
            )
        }

        AppSymbol.APPLY_SHIFT_SYMBOL -> {
            put(
                OVERRIDE_FOREGROUND_COLOR, ModifierColorSet(
                    changeModifierArgs.modifierKeyKind,
                    AppColor(Hue.modifierGrayBackground),
                    AppColor(Hue.modifierYellowBackground),
                    AppColor(Hue.modifierRedBackground),
                )
            )
        }

        else -> {
            put(
                OVERRIDE_BACKGROUND_COLOR, ModifierColorSet(
                    changeModifierArgs.modifierKeyKind,
                    AppColor(Hue.modifierGrayBackground),
                    AppColor(Hue.modifierYellowBackground),
                    AppColor(Hue.modifierRedBackground),
                )
            )
            put(
                OVERRIDE_BORDER_COLOR, ModifierColorSet(
                    changeModifierArgs.modifierKeyKind,
                    AppColor(Color.Black),
                    AppColor(Hue.Tan),
                    AppColor(Hue.Roarnge),
                )
            )
            put(
                OVERRIDE_FOREGROUND_COLOR, ModifierColorSet(
                    changeModifierArgs.modifierKeyKind,
                    AppColor(Color.Black),
                )
            )
        }
    }
}

abstract class DirectionalGesture(gestureData: GestureData, gestureShape: GestureShape, gestureSize: GestureMagnitude, direction: OrientationMeasurement? = null)
    : Gesture(gestureData, GestureType(gestureShape, gestureSize, direction))
abstract class Swipe(gestureData: GestureData, size: GestureMagnitude, direction: CompassDirection) : DirectionalGesture(gestureData, SWIPE, size, direction)

private fun get(
    gestureShape: GestureShape,
    gestureSize: GestureMagnitude,
    direction: OrientationMeasurement? = null,
) = Gesture.Builders.addPrototype(gestureShape, gestureSize, direction)

val Click : GestureBuilder by lazy { get(PRESS, SMALL, null) }
val Hold : GestureBuilder by lazy { get(PRESS, LARGE, null) }
val SmallCircleClockwise : GestureBuilder by lazy { get(CIRCLE, SMALL, CLOCKWISE) }
val BigCircleClockwise : GestureBuilder by lazy { get(CIRCLE, LARGE, CLOCKWISE) }
val SmallCircleCounterClockwise : GestureBuilder by lazy { get(CIRCLE, SMALL, ANTI_CLOCKWISE) }
val BigCircleCounterClockwise : GestureBuilder by lazy { get(CIRCLE, LARGE, ANTI_CLOCKWISE) }
val ShortSwipeNorth : GestureBuilder by lazy { get(SWIPE, SMALL, NORTH) }
val LongSwipeNorth : GestureBuilder by lazy { get(SWIPE, LARGE, NORTH) }
val ShortSwipeSouth : GestureBuilder by lazy { get(SWIPE, SMALL, SOUTH) }
val LongSwipeSouth : GestureBuilder by lazy { get(SWIPE, LARGE, SOUTH) }
val ShortSwipeEast : GestureBuilder by lazy { get(SWIPE, SMALL, EAST) }
val LongSwipeEast : GestureBuilder by lazy { get(SWIPE, LARGE, EAST) }
val ShortSwipeWest : GestureBuilder by lazy { get(SWIPE, SMALL, WEST) }
val LongSwipeWest : GestureBuilder by lazy { get(SWIPE, LARGE, WEST) }
val ShortSwipeNorthEast : GestureBuilder by lazy { get(SWIPE, SMALL, NORTHEAST) }
val LongSwipeNorthEast : GestureBuilder by lazy { get(SWIPE, LARGE, NORTHEAST) }
val ShortSwipeSouthEast : GestureBuilder by lazy { get(SWIPE, SMALL, SOUTHEAST) }
val LongSwipeSouthEast : GestureBuilder by lazy { get(SWIPE, LARGE, SOUTHEAST) }
val ShortSwipeNorthWest : GestureBuilder by lazy { get(SWIPE, SMALL, NORTHWEST) }
val LongSwipeNorthWest : GestureBuilder by lazy { get(SWIPE, LARGE, NORTHWEST) }
val ShortSwipeSouthWest : GestureBuilder by lazy { get(SWIPE, SMALL, SOUTHWEST) }
val LongSwipeSouthWest : GestureBuilder by lazy { get(SWIPE, LARGE, SOUTHWEST) }
val ShortBoomerangNorth : GestureBuilder by lazy { get(BOOMERANG, SMALL, NORTH) }
val LongBoomerangNorth : GestureBuilder by lazy { get(BOOMERANG, LARGE, NORTH) }
val ShortBoomerangSouth : GestureBuilder by lazy { get(BOOMERANG, SMALL, SOUTH) }
val LongBoomerangSouth : GestureBuilder by lazy { get(BOOMERANG, LARGE, SOUTH) }
val ShortBoomerangEast : GestureBuilder by lazy { get(BOOMERANG, SMALL, EAST) }
val LongBoomerangEast : GestureBuilder by lazy { get(BOOMERANG, LARGE, EAST) }
val ShortBoomerangWest : GestureBuilder by lazy { get(BOOMERANG, SMALL, WEST) }
val LongBoomerangWest : GestureBuilder by lazy { get(BOOMERANG, LARGE, WEST) }
val ShortBoomerangNorthEast : GestureBuilder by lazy { get(BOOMERANG, SMALL, NORTHEAST) }
val LongBoomerangNorthEast : GestureBuilder by lazy { get(BOOMERANG, LARGE, NORTHEAST) }
val ShortBoomerangSouthEast : GestureBuilder by lazy { get(BOOMERANG, SMALL, SOUTHEAST) }
val LongBoomerangSouthEast : GestureBuilder by lazy { get(BOOMERANG, LARGE, SOUTHEAST) }
val ShortBoomerangNorthWest : GestureBuilder by lazy { get(BOOMERANG, SMALL, NORTHWEST) }
val LongBoomerangNorthWest : GestureBuilder by lazy { get(BOOMERANG, LARGE, NORTHWEST) }
val ShortBoomerangSouthWest : GestureBuilder by lazy { get(BOOMERANG, SMALL, SOUTHWEST) }
val LongBoomerangSouthWest : GestureBuilder by lazy { get(BOOMERANG, LARGE, SOUTHWEST) }
