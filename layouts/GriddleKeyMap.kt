package org.galacticware.griddle.keyboarddefinition.opensource.layouts

import android.content.Context
import org.galacticware.griddle.domain.layer.LayerDefinable
import java.util.Locale

/***
 * The definitions for English keys, roughly-based on the MessagEase layout.
 * Alphas and numerics are in the same place, with the same possible gestures for them.
 */
abstract class GriddleKeyMap: GridKeyMapper {
    private val nameRegex = Regex("(?<=[a-z])(?=[A-Z])")
    override val name = this::class.simpleName!!.split(nameRegex).dropLast(1).joinToString(" ") { s ->
        s.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
    }
    override fun build(context: Context): LayerDefinable = CreateLayout(
        context,
        name,
        allMappings(),
        keyboardHandedness,
        defalultSize,
        isPrimary,
        layerKind,
        languageTag,
    )
}