package com.galacticwarev2.griddle.domain.design.base.layer

import com.galacticwarev2.griddle.domain.model.type.base.tag.AppSymbol
import com.galacticwarev2.griddle.domain.design.base.collection.ButtonBuilders
import com.galacticwarev2.griddle.domain.input.IMEService
import com.galacticwarev2.griddle.domain.language.LayerTag
import com.galacticwarev2.griddle.domain.usercontolled.Answer.Companion.YES
import com.galacticwarev2.griddle.domain.usercontolled.Answer.Companion.NO
import com.galacticwarev2.griddle.domain.usercontolled.SettingManipulationType.TOGGLEABLE
import com.galacticwarev2.griddle.domain.usercontolled.SettingParams
import com.galacticwarev2.griddle.domain.util.PreferencesHelper.checkAndGetIncrementalValue
import com.galacticwarev2.griddle.domain.util.PreferencesHelper.checkAndSetUserDefinedValue
import com.galacticwarev2.griddle.domain.view.composable.helper.SingleSettingDelegate
import kotlinx.serialization.Serializable
import java.util.SortedSet
import java.util.TreeSet

/**
 * A [CharSet] in the context of Griddle is a unique set of [LayerTag]s.
 *  This helps us:
 *  1. Uniquely identify a layer in a keyboard.
 *  2. Validate that each layer of a keyboard has buttons that have the required kinds of
 *  functionality for the corresponding CharSet.
 */
@Serializable(with = CharSetSerializer::class)
abstract class CharSet(
    layerTag: LayerTag,
    vararg layerTags: LayerTag,
): ICharSet, Comparable<CharSet> {

    init {
        val predicate: (LayerTag) -> Boolean = { it != layerTag && it.isAlphabetic }
        if(!layerTag.isAlphabetic && layerTags.any(predicate)) {
            throw Exception("Language layer tag $layerTag is not alphabetic, but the following" +
                    "non-language layer tags were declared afterward:\n\t${layerTags.filter(predicate)}}")
        }
    }

    /**
     * This is safe because every CharSet has at least one LanguageTag.
     */
    open val layerTags: SortedSet<LayerTag> = layerTags.toList().plus(layerTag).toSortedSet()

    val languageTag by lazy { this.layerTags.firstOrNull { it.isAlphabetic } }
    val isAlphabetical by lazy { languageTag != null }

    override val name get() = toString()
    override fun toString(): String =  layerTags.joinToString("-"){ it.camelCasedName }

    val symbol by lazy {
        when (this) {
            LayerTag.Function() -> AppSymbol.FUNCTION_LAYER_SYMBOL
            LayerTag.Numpad() -> AppSymbol.NUMPAD_LAYER_SYMBOL
            LayerTag.Symbolic() -> AppSymbol.SYMBOLIC_NUMERIC_LAYER_SYMBOL
            else -> AppSymbol.ALPHA_LAYER_SYMBOL
        }
    }

    /**
     * This implementation always ensured that alpha layer tags are sorted to the beginning of the
     * list, and all layer tags are secondarily sorted by their ordinals
     */
    override fun compareTo(other: CharSet): Int {
        val thisItr = layerTags.iterator()
        val thatItr = other.layerTags.iterator()
        do {
            val(thisTag, thatTag) = thisItr.next() to thatItr.next()
            if (thisTag.isAlphabetic && !thatTag.isAlphabetic) {
                return -1
            } else if (!thisTag.isAlphabetic && thatTag.isAlphabetic) {
                return 1
            } else if (thisTag != thatTag) {
                return thisTag.ordinal.compareTo(thatTag.ordinal)
            }
        } while (thisItr.hasNext() && thatItr.hasNext())
        return if(thisItr.hasNext()) 1 else if(thatItr.hasNext()) -1 else 0
    }

    /**
     * Any two CharSet objects with the same set of[LayerTag]s are equal, no
     * matter what.
     */
    override fun equals(other: Any?): Boolean =
        if (this === other) true
        else if (other !is CharSet) false
        else layerTags == other.layerTags

    override fun hashCode(): Int {
        return super.hashCode()
    }

    fun languagePackFor(
        charSet: CharSet,
        alphaNumericCharSet: CharSet?,
        builders: ButtonBuilders
    ): LanguagePack =
        if(charSet.isAlphabetical) {
            LanguagePack(layerTags.first(), charSet, alphaNumericCharSet, builders)
        } else throw Exception("Cannot pack a non-language layer.")

    /**
     * Make a language
     */
    fun languagePackFor(builders: ButtonBuilders): LanguagePack
    = languagePackFor(this, null, builders)

    data class LanguagePack(
        val layerTag: LayerTag,
        val alphaCharSet: CharSet,
        val alphaNumericCharSet: CharSet?,
        val buttonsToUse: ButtonBuilders
    ) {
        init {
            val minX = buttonsToUse.minOf { it.colStart }
            val minY = buttonsToUse.minOf { it.rowStart }
            val maxX = buttonsToUse.maxOf { it.colStart }
            val maxY = buttonsToUse.maxOf { it.rowStart }
            if(maxX - minX > 3 ||maxY - minY > 3) throw Exception(
                "language packs for MessagEase style layers must be 3x3." +
                        "minX: $minX, minY: $minY, maxX: $maxX, maxY: $maxY")
        }
    }
    companion object {
        private val registry = mutableMapOf<SortedSet<LayerTag>, CharSet>()
        /**
         * Create a new [CharSet] with the given [LayerTag]s. We purposely name this method `id`
         * because it is used in our button builders, and reads extremely well while also being
         * very short (e.g. `+Click.switchLayer(ENGLISH_LAYER)`).
         */
        fun id(vararg layerTags: LayerTag) = layerTags.toSortedSet().let{ ss->
            registry.getOrPut(ss) {
                val firstTag = layerTags.first()
                val otherTags = layerTags.drop(1).toTypedArray()
                object : CharSet(firstTag, *otherTags) {
                    override val layerTags: TreeSet<LayerTag> get()
                    = sortedSetOf(firstTag, *otherTags)
                }
            }
        }
    }
}

class booleanDelegate(val title: String, imeService: IMEService, isDefaultLayer: Boolean) {
    private val _bool = SettingParams(if(isDefaultLayer)YES else NO, 0, 1, 1, TOGGLEABLE, title).let { params ->
        SingleSettingDelegate<Boolean, Number>(
            svc = imeService,
            saver = { { svc, i -> checkAndSetUserDefinedValue(imeService, i.toInt(), params) } },
            loader = { { scv ->
                checkAndGetIncrementalValue<Int>(scv, params) { i ->
                    checkAndSetUserDefinedValue<Int>(scv, i.toInt(), params) } == YES.toLong()
            } },
        )}
    var value = isDefaultLayer
        get() = _bool.get()
        set(value) {
            _bool.set(if (value) YES else NO)
            field = value
        }
}