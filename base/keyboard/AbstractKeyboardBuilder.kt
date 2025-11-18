package com.galacticware.griddle.domain.design.base.keyboard
import androidx.compose.ui.unit.IntSize
import com.galacticware.griddle.domain.design.base.collection.ButtonBuilders
import com.galacticware.griddle.domain.design.base.collection.IButtonBuilderSet.Companion.toButtonBuilders
import com.galacticware.griddle.domain.design.base.layer.CharSet
import com.galacticware.griddle.domain.design.base.layer.ILayerBuilder
import com.galacticware.griddle.domain.language.LayerTag
import com.galacticware.griddle.domain.visual.GesturePaletteTemplate
import com.galacticware.griddle.domain.visual.IKeyboardColorScheme
import java.lang.Exception
class UnknownKeyboardException(message: String): Exception(message)


/**
 * This class has implementation sufficient to instantiate an [IKeyboardBuilder] object.
 */
abstract class AbstractKeyboardBuilder(
    override val name: String,
    override val kind: KeyboardKind,
    override val layers: LinkedHashSet<ILayerBuilder>,
    override val keyboardColorScheme: IKeyboardColorScheme,
    val doRegister: Boolean = true,
) : IKeyboardBuilder {
    object KeyboardRegistry {
        private val registeredKeyboardBuilders = mutableMapOf<String, IKeyboardBuilder>()
        operator fun plusAssign(value: IKeyboardBuilder) {
            registeredKeyboardBuilders.putIfAbsent(
                value.name,
                value.copy(
                    value.name,
                    value.kind,
                    value.layers,
                    value.keyboardColorScheme,
                    false,
                )
            )
        }
        operator fun get(name: String) = registeredKeyboardBuilders
            .throwUponAbsenceOf<UnknownKeyboardException>(name) { "No keyboard with name \"$name\" found." }
    }
    init {
        if(doRegister) {
            KeyboardRegistry += this
        }
    }

    override fun toString(): String = "$name-${kind.label}-${layers
        .flatMap { it.layerTags }
        .toSet()
        .sorted()
        .joinToString("_")
    }"

    override fun withColors(keyboardColorScheme: IKeyboardColorScheme): IKeyboardBuilder = run {
        privateCopy(keyboardColorScheme = keyboardColorScheme)
    }

    override fun copy(
        name: String,
        kind: KeyboardKind,
        layers: LinkedHashSet<ILayerBuilder>,
        keyboardColorScheme: IKeyboardColorScheme,
        doRegister: Boolean
    ): IKeyboardBuilder = object : AbstractKeyboardBuilder(name, kind, linkedSetOf(*layers.map {
        it.copy(
            name,
             it.layerTags.map { it },
             it.charSet.layerTags.first()(*it.layerTags.drop(1).toTypedArray()),
             it.isPrimary,
             it.keyboardHandedness,
             it.defaultSize,
             it.defaultGestureColors,
            it.buttonBuilders().map {
                val keys = it.gestureMap.keys
                val values = it.gestureMap.values
                it.copy(
                    keys.zip(values).associate { (k, v) ->
                        k to v.copy()
                    }.toMutableMap(),
                    it.buttonPaletteTemplate,
                    it.size,
                    it.gridPosition.copy(),
                    it.overrideTheme,
                    it.info.name
                )
            }.toButtonBuilders()
        )
    }.toTypedArray()),
    keyboardColorScheme, doRegister
    ) {}

    private fun privateCopy(
        name: String = this.name,
        kind: KeyboardKind = this.kind,
        layers: LinkedHashSet<ILayerBuilder> = this.layers,
        keyboardColorScheme: IKeyboardColorScheme = this.keyboardColorScheme,
        doRegister: Boolean = this.doRegister,
    ): IKeyboardBuilder = copy(name, kind, layers, keyboardColorScheme, doRegister)

    override fun replaceLanguageLayersWith(
        name: String,
        builder: ILayerBuilder,
        vararg layerBuilders: ILayerBuilder
    ): IKeyboardBuilder =  privateCopy(name, doRegister = true).apply {
        layers.removeIf { it.layerTags.isNotEmpty() }
        layers.add(builder)
        layers.addAll(layerBuilders)
    }

    companion object {
        fun getKeyboardBuilder(
            keyboardDefinable: KeyboardDefinable,
            kind: KeyboardKind = KeyboardKind.DEFAULT,
            keyboardColorScheme: IKeyboardColorScheme,
            vararg layers: ILayerBuilder,
        ): IKeyboardBuilder = object : AbstractKeyboardBuilder(
            keyboardDefinable.name,
            kind,
            linkedSetOf(*layers.map { it.renameWithKeyboardName(keyboardDefinable.name) }.toTypedArray()),
            keyboardColorScheme,
        ){}
    }
}

inline fun <reified E : Exception> MutableMap<String, IKeyboardBuilder>.throwUponAbsenceOf(
    key: String,
    message: () -> String
): IKeyboardBuilder {
    return this[key] ?: throw createException<E>(message())
}


inline fun <reified E : Exception> createException(message: String): E {
    return try {
        // Try a (String) constructor first
        E::class.constructors.firstOrNull { ctor ->
            ctor.parameters.size == 1 &&
                    ctor.parameters[0].type.classifier == String::class
        }?.call(message)
            ?: E::class.java.getDeclaredConstructor().newInstance()
    } catch (e: Exception) {
        throw IllegalArgumentException("Cannot instantiate exception ${E::class.simpleName}", e)
    }
}
