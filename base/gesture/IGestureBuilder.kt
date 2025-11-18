package com.galacticware.griddle.domain.design.base.gesture

import com.galacticware.griddle.domain.gesture.HotSwapGestureType
import com.galacticware.griddle.domain.language.LayerTag
import com.galacticware.griddle.domain.model.type.base.tag.AppSymbol
import com.galacticware.griddle.domain.model.type.base.tag.ModifierKeyKind
import com.galacticware.griddle.domain.modifier.ModifierCycleDirection
import com.galacticware.griddle.domain.operation.implementation.noargs.repeatable.IRepeatable
import com.galacticware.griddle.domain.operation.implementation.someargs.changemodifier.ChangeModifierArgs
import com.galacticware.griddle.domain.operation.implementation.someargs.switchscreens.SwitchScreenArgs

/**
 * These are the methods available for developers to build and assign gestures to buttons.
 */
interface IGestureBuilder {

    /**
     * Press an Android KeyEvent.KeyCode by specifying its Int representation.
     * Check the list of all KeyCodes at
     * https://developer.android.com/reference/android/view/KeyEvent
     */
    fun pressKey(
        keycode: Int,
        modifiers: Set<ModifierKeyKind> = setOf(),
        respectShift: Boolean = true,
        legend: AppSymbol? = null,
        label: String? = null,
    ): GestureBinding.Incubator

    fun cycleAccentCharacters(): GestureBinding.Incubator

    fun changeModifier(
        changeModifierArgs: ChangeModifierArgs.Incubator,
    ): GestureBinding.Incubator

    /**
     * Specify the CharSet to switch to a layer that matches that charSet. Ex:
     * switchLayer(German) // switch to German alpha (4x4) layer
     * switchLayer(English(Symbolic, DoubleWide)) // switch to English+number&symbols 7x4 layer
     * switchLayer(Symbolic(Numeric, DoubleWide)) // switch to English+number&symbols 7x4 layer
     */
    fun switchLayer(
        vararg layerTag: LayerTag,
        hotSwapType: HotSwapGestureType? = null,
    ): GestureBinding.Incubator

    /**
     * Switch to another options screen, ex:
     * switchScreens(SwitchScreenArgs.OpenEmoji) // Open the Emoji picker
     * switchScreens(SwitchScreenArgs.OpenClipboard) // Open the clipboard
     * switchScreens(SwitchScreenArgs.OpenLanguagePreferences) // Open the language options menu
     */
    fun switchScreens(
        switchScreenArgs: SwitchScreenArgs,
        hotSwapType: HotSwapGestureType? = null,
    ): GestureBinding.Incubator

    /**
     * Send characters directly to the input by specify the three strings to use during different
     * shift states (unpressed, one-shot, persistent)
     */
    fun insertText(
        unpressedStateText: String,
        oneShotStateText: String = unpressedStateText,
        persistentStateText: String = oneShotStateText,
    ): GestureBinding.Incubator
    
    /**
     * Specify the triple of strings to insert text in
     */
    fun insertText(
        threeStrings: Triple<String, String, String>,
        hotSwapType: HotSwapGestureType? = null,
    ): GestureBinding.Incubator

    /**
     * Repeat the previous operation when this operation is triggered.
     */
    fun repeat(
        iRepeatable: IRepeatable
    ): GestureBinding.Incubator

    /**
     * Cycle through the selected languages of the keyboard either forward or reversed.
     */
    fun switchLanguage(
        modifierCycleDirection: ModifierCycleDirection = ModifierCycleDirection.FORWARD
    ): GestureBinding.Incubator
}