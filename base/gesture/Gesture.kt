package com.galacticware.griddle.domain.design.base.gesture

import com.galacticware.griddle.domain.button.ButtonBuilder
import com.galacticware.griddle.domain.button.ButtonBuilder.Companion.buttonBuilder
import com.galacticware.griddle.domain.design.base.button.IButtonBuilder
import com.galacticware.griddle.domain.gesture.GestureData
import com.galacticware.griddle.domain.gesture.HotSwapGestureType
import com.galacticware.griddle.domain.keyboard.Keyboard
import com.galacticware.griddle.domain.model.geometry.CompassDirection
import com.galacticware.griddle.domain.model.geometry.OrientationMeasurement
import com.galacticware.griddle.domain.model.gesture.GestureMagnitude
import com.galacticware.griddle.domain.model.gesture.GestureShape
import com.galacticware.griddle.domain.model.gesture.GestureType
import com.galacticware.griddle.domain.model.gesture.possibleGestureTypes
import com.galacticware.griddle.domain.model.type.base.tag.ModifierKeyKind.ALT
import com.galacticware.griddle.domain.model.type.base.tag.ModifierKeyKind.CONTROL
import com.galacticware.griddle.domain.model.type.base.tag.ModifierKeyKind.SHIFT
import com.galacticware.griddle.domain.model.type.base.tag.ModifierKeyState
import com.galacticware.griddle.domain.modifier.ModifierManipulation
import com.galacticware.griddle.domain.modifier.sets.ModifierColorSet
import com.galacticware.griddle.domain.operation.implementation.noargs.backspace.HOT_SWAP_DURATION_MILLIS
import com.galacticware.griddle.domain.operation.implementation.someargs.changemodifier.ChangeModifier
import com.galacticware.griddle.domain.visual.ColorElement.BACKGROUND_COLOR
import com.galacticware.griddle.domain.visual.ColorElement.BORDER_COLOR
import com.galacticware.griddle.domain.visual.ColorElement.FOREGROUND_COLOR
import kotlinx.serialization.Serializable
import java.util.Locale

/**
 * The base class for all gestures.
 */
@Serializable(with = GestureSerializer::class)
abstract class Gesture(
    var data: GestureData,
    val type: GestureType,
    swapGesture: Gesture? = null,
) : ViewModelUser() {
    private var doRegister = false
    constructor(
        gestureType: GestureShape,
        gestureSize: GestureMagnitude,
        direction: OrientationMeasurement?,
        primaryData: GestureData,
        doRegister: Boolean = false,
    ): this(primaryData, type = GestureType(gestureType, gestureSize, direction)) {
        this.doRegister = doRegister
    }
    /**
     * If the state is hot-swapped and this gesture is on that button and has a hot swap assignment,
     * prefer the hot swap implementation.
     */
    var hotSwapData: GestureData? = swapGesture?.currentData

    private val currentData get() = if(
        vm().lastTimeHotSwapped.value != Long.MAX_VALUE
        &&
        vm().lastTimeHotSwapped.value + HOT_SWAP_DURATION_MILLIS > System.currentTimeMillis()
    ) {
        hotSwapData ?: data
    } else data

    val optionsLabel: String = this.type.prettyPrinted

    var parentButton: IButtonBuilder = blankButton

    fun copy(
        gestureData: GestureData = this.data,
        id: GestureType = this.type,
        hotSwapGestureType: HotSwapGestureType? = null,
    ) : Gesture = object : Gesture(gestureData, GestureType(id.gestureShape, id.gestureSize, id.direction), swapGesture =

    if(hotSwapGestureType != null) { object : Gesture(gestureData, GestureType(id.gestureShape, id.gestureSize, id.direction), null) {} } else null) {}

    val currentGestureData get() = if(!currentData.isIndicator) {
        // Only indicators get borders
        currentData.copy(modifierSets = currentData.modifierSets.copy()
            .apply { this[BORDER_COLOR] = ModifierColorSet.TRANSPARENT })
    } else currentData

    /**
     * A formatted text representation of this gesture and its gestureData's details.
     */
    val prettyPrinted: String
        get() = "${
            this::class
                .simpleName!!
                .let { s ->
                    "([A-Z][a-z]+)"
                        .toRegex().find(s)?.groups
                        ?.mapNotNull { str ->
                            str?.value?.replaceFirstChar {
                                if (it.isLowerCase()) it.titlecase(
                                    Locale.ROOT
                                ) else it.toString()
                            }
                        }
                        ?.joinToString(" ") { it }
                        ?: s
                    s
                }
        }:" +
                "\n${currentGestureData.operation.menuItemDescription}" +
                "\n${currentGestureData.operation.userHelpDescription}"

    /**
     * The function to run when this gesture is performed.
     */
    val editorOperation get() = currentGestureData.operation

    /**
     * A [Gesture] is displayable only if it is a swipe or click
     */
    val isDisplayable: Boolean get() {
        currentGestureData.let {
            return (isVisibleGesture && (
                    hasVisibleText ||
                            // this check helps us only display the un-shift modifier if shift is
                            //  not UNPPRESSED, but directly checking the values is better than
                            // checking the modifier state.
                            (it.operation.let { op -> op is ChangeModifier &&
                    op.provideArgs(it.argsJson!!).modifierManipulation == ModifierManipulation.RELEASE
            })))
        }
    }

    /**
     * @return true if the current GestureData contains text
     */
    val hasVisibleText get() = isVisibleGesture && currentGestureData.currentText.isNotBlank()

    /**
     * @return true if his is a Swipes or Clicks, since they are the only visible gesture types.
     */
    val isVisibleGesture get() = type.gestureSize == GestureMagnitude.SMALL
            && type.gestureShape in GestureShape.visibleShapes

    /**
     * Retrieves the text to be displayed based on modifier state.
     */
    val currentText: String
        get() = currentGestureData.currentText

    fun currentTheme() = setOf(BACKGROUND_COLOR, FOREGROUND_COLOR, BORDER_COLOR).associate { themeElement ->
        val modifierSetFor = currentGestureData.modifierSetFor(themeElement)
        themeElement to modifierSetFor.let { modifierSet ->
                modifierSet.entries.map { (_, modifierSet) ->
                val modifierKeyState = when (modifierSet.modifierKeyKind) {
                    SHIFT -> Keyboard.shiftState
                    CONTROL -> Keyboard.ctrlState
                    ALT -> Keyboard.altState
                }
                when (modifierKeyState) {
                    ModifierKeyState.UNPRESSED -> modifierSet.unpressedStateValue
                    ModifierKeyState.ONE_SHOT -> modifierSet.oneShotStateValue
                    ModifierKeyState.PERSISTENT -> modifierSet.persistentStateValue
                }
            }
        }
    }
    /*
    fun currentText(): GestureColors {
        val modifierKeyState = when (currentGestureData.modifierSetFor) {
            ModifierKeyKind.SHIFT -> KeyboardState.shiftState
            ModifierKeyKind.CONTROL -> KeyboardState.ctrlState
            ModifierKeyKind.ALT -> KeyboardState.altState
        }
        return when (modifierKeyState) {
            ModifierKeyState.OFF -> currentGestureData.currentText
            ModifierKeyState.ONE_SHOT -> currentGestureData.oneShotTheme
            ModifierKeyState.ON -> currentGestureData.repeatTheme
        }
    }*/

    override fun toString(): String {
        return "${this::class.simpleName}," +
                "${editorOperation.name}," +
                if (currentText.isEmpty()) "text is empty" else "text=\"${currentText}\""
    }

    val model: GestureModel get() = GestureModel(this, currentGestureData.model)

    override fun hashCode(): Int = type.hashCode()

    companion object Builders: ViewModelUser() {

        private val prototypes by lazy { AddOnlyMap<GestureType, GestureBuilder>() }
        fun init() {
            possibleGestureTypes
            prototypes.lockMapPermanently()
        }

        fun prototypes() = prototypes.values

        fun get(type: GestureType) = prototypes[type]

        fun allForDirection(d: CompassDirection): Set<Gesture> = if(d.isCardinal) emptySet()
        else prototypes.filter {
            it.key.direction?.let{it in d.adjacentDirections} == true
        }
            .map { it.value }
            .toSet()

        val blankButton: ButtonBuilder get() =
            buttonBuilder("",rowStart =  0, colStart = 0, rowSpan = 1, colSpan = 1,
                gestureMap = mutableMapOf<GestureType, GestureData>()
            )

        val defaultLongSwipes get() = prototypes.filter { it.key.let {
            it.gestureSize == GestureMagnitude.LARGE && it.gestureShape == GestureShape.SWIPE
        } }

        private val gestureData = mutableMapOf<AssignmentId, GestureData>()

        val visibleGestures by lazy {
            prototypes.values.filter { it.type.gestureShape in GestureShape.visibleShapes
                    && it.type.gestureSize == GestureMagnitude.SMALL
            }.map { it.type }.toSet()
        }

        @JvmStatic
        fun addPrototype(prototype: GestureBuilder) = prototypes.getOrPut(prototype.type) { prototype }

        @JvmStatic
        fun addPrototype(
            gestureShape: GestureShape,
            gestureSize: GestureMagnitude,
            direction: OrientationMeasurement?
        ) = addPrototype(object : GestureBuilder(gestureShape, gestureSize, direction){})

        fun prototypeFor(id: GestureType) = prototypes[id]
            ?: object : GestureBuilder(id.gestureShape, id.gestureSize, id.direction) {}
                .also { prototypes.put(id, it) }

        fun allPrototypes() = prototypes
    }

    /**
     *  We only make anonymous Gestures for actual use, based on Prototype gestures.
     *  Each anonymous Gesture is member of its youngest child class.
     *  Equality is based on the combination of class, size, and direction.
     */
    override fun equals(other: Any?) = other is Gesture && this.type == other.type
}

/**
 * This class should only be used for maps where the computed size is known ahead of time.
 */
class AddOnlyMap<K, V> : MutableMap<K, V> {

    private var _isFinishedRegistering = false
    fun lockMapPermanently() { _isFinishedRegistering = true }
    val isFinishedRegistering get() = _isFinishedRegistering

    private val map = mutableMapOf<K, V>()

    override val entries: MutableSet<MutableMap.MutableEntry<K, V>> get() = map.entries
    override fun isEmpty(): Boolean = map.isEmpty()

    override val keys: MutableSet<K> get() = map.keys
    override val values: MutableCollection<V> get() = map.values
    override val size: Int get() = map.size

    // Only allow adding new entries, no modifying existing ones
    override fun put(key: K, value: V): V? = map[key]?: map.put(key, value)

    override fun putAll(from: Map<out K, V>) = from.forEach { put(it.key, it.value) }

    override fun remove(key: K): V? = null

    override fun clear() {}

    override fun containsKey(key: K): Boolean {
        return map.containsKey(key)
    }

    override fun containsValue(value: V): Boolean {
        return map.containsValue(value)
    }

    override fun get(key: K): V? {
        return map[key]
    }
}
