package com.galacticwarev2.griddle.domain.design.base.keyboard

import com.galacticwarev2.griddle.domain.design.base.collection.ButtonBuilders
import com.galacticwarev2.griddle.domain.design.base.layer.CharSet
import com.galacticwarev2.griddle.domain.language.LayerTag
import com.galacticwarev2.griddle.domain.modifier.GestureColors

/**
 * Interface for all [AbstractKeyboardDefinition] to manage and modify layers.
 * All classes implementing keyboard-definable must be named:
 *
 * `"${keyboardName}KeyboardDefinition"`
 *
 * Where `keyboardName`:
 * - Is in `PascalCase`
 * - Is the desired simple name of your board
 * - Is NOT the name of the language (keyboards support multiple languages,
 *    by defining alternative layers from the defaults).
 */
private const val suffix: String = "KeyboardDefinition"

interface KeyboardDefinable {

    val name: String get() = this::class.simpleName.toString().let {
        if (it.endsWith(suffix)) {
            it.removeSuffix(suffix)
        } else throw Exception(
            "All classes implementing keyboard-definable must have names ending with the suffix" +
                    " \"$suffix\". Name: $it"
        )
    }

    val defaultGestureColors: GestureColors
}