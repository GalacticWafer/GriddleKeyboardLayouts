package com.galacticware.griddle.domain.design.base.keyboard

import com.galacticware.griddle.domain.design.base.layer.CharSet
import com.galacticware.griddle.domain.design.base.layer.CharSet.Companion.id
import com.galacticware.griddle.domain.language.LayerTag
import com.galacticware.griddle.domain.layer.EntityModel
import com.galacticware.griddle.domain.model.type.base.tag.VariantTypeTag
import com.galacticware.griddle.domain.util.toPascalCase
import kotlinx.serialization.Serializable

@Serializable
data class KeyboardKindModel(
    val label: String,
    val canExecuteOperations: Boolean,
    val canDrawGestureTrails: Boolean,
): EntityModel {
    fun toKeyboardKind() = (KeyboardKind.entries as Array<KeyboardKind>).first {
        it.label == label
                && it.canDrawGestureTrails == canDrawGestureTrails
                && it.canExecuteOperations == canExecuteOperations
    }
}

/**
 * The kinds of keyboards used in the Griddle System, to pivot certain logic when gestured occur.
 */
sealed class KeyboardKind(
    val label: String,
    val canExecuteOperations: Boolean,
    val canDrawGestureTrails: Boolean,
) : VariantTypeTag() {
    val model by lazy { KeyboardKindModel(label, canExecuteOperations, canDrawGestureTrails) }
    object DEFAULT: KeyboardKind("default", true, true)
    object SINGLE_BUTTON_DESIGNER_MODE: KeyboardKind("design a button", false, true)
    object USER_DEFINED: KeyboardKind("user-defined", true, true)
    object LAYER_EDITOR: KeyboardKind("layer editor preview", false, false)
    override val variants: Array<VariantTypeTag> by lazy { if (this in entries) arrayOf() else entries }
    companion object {
        internal val entries: Array<VariantTypeTag> by lazy {
            arrayOf(DEFAULT, SINGLE_BUTTON_DESIGNER_MODE, USER_DEFINED, LAYER_EDITOR)
        }
        val designerTypes by lazy { setOf(SINGLE_BUTTON_DESIGNER_MODE, LAYER_EDITOR)}
    }

    /**
     * Small functions that help us to ensure specific layer tags exist within layer kind's set of
     * layer tags. This is how we manage support for boards with various logical groupings of both
     * keys and charsets.
     */
    private val alphaLayerChecker = { it: CharSet -> it.layerTags.first().isAlphabetic }
    private val symbolLayerChecker = { it: CharSet -> it == id(LayerTag.Symbolic) }
    private val numpadLayerChecker = { it: CharSet -> it == id(LayerTag.Numpad) }
    private val functionLayerChecker = { it: CharSet -> it == id(LayerTag.Function) }

    /**
     * @return the set of required [CharSet]s for this [KeyboardKind]
     */
    val mandatoryAlphaLayerCheckers by lazy {
        when (this) {
            DEFAULT -> {
                setOf(
                    numpadLayerChecker,
                    symbolLayerChecker,
                    functionLayerChecker,
                    alphaLayerChecker,
                )
            }
            USER_DEFINED -> setOf(
                numpadLayerChecker,
                symbolLayerChecker,
                alphaLayerChecker,
            )
            else -> emptySet()
        }
    }

    override fun toString(): String = name.toPascalCase()

    val isDesignerKind by lazy { this in designerTypes }
}