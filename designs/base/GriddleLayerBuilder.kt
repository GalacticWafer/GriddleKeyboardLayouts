package com.galacticware.griddle.model.keyboard.definition.designs.base

import android.content.Context
import com.galacticware.griddle.model.layer.CreateLayer
import com.galacticware.griddle.model.layer.LayerDefinable
import java.util.Locale

/**
 * The base class for all layer builders.
 */
abstract class GriddleLayerBuilder: LayerBuilder {
    private val nameRegex by lazy { Regex("(?<=[a-z])(?=[A-Z])") }
    override val name by lazy {
        this::class.simpleName!!.split(nameRegex).dropLast(1).joinToString(" ") { s ->
            s.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
        }
    }
    override fun build(context: Context): LayerDefinable =
        CreateLayer(
            context,
            name,
            buttonBuilders(),
            keyboardHandedness,
            defalultSize,
            isPrimary,
            layerKind,
            languageTag,
        )
}