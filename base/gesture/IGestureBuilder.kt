package com.galacticware.griddle.domain.design.base.gesture

import com.galacticware.griddle.domain.design.base.layer.CharSet
import com.galacticware.griddle.domain.gesture.HotSwapGestureType
import com.galacticware.griddle.domain.gesture.ModifierSets
import com.galacticware.griddle.domain.gesture.applyModifierColorization
import com.galacticware.griddle.domain.gesture.modifierFollowerMap
import com.galacticware.griddle.domain.language.LayerTag
import com.galacticware.griddle.domain.model.type.base.tag.AppSymbol
import com.galacticware.griddle.domain.model.type.base.tag.ModifierKeyKind
import com.galacticware.griddle.domain.model.type.base.tag.TextElement.GESTURE_DISPLAY_TEXT
import com.galacticware.griddle.domain.model.type.base.tag.TextElement.TEXT_ELEMENT_FONT
import com.galacticware.griddle.domain.model.type.base.tag.TextElement.TEXT_ELEMENT_SIZE
import com.galacticware.griddle.domain.modifier.GestureText
import com.galacticware.griddle.domain.modifier.ModifierCycleDirection
import com.galacticware.griddle.domain.modifier.sets.GestureDisplayTextSet
import com.galacticware.griddle.domain.operation.base.Operation
import com.galacticware.griddle.domain.operation.implementation.noargs.repeatable.RepeatSignalOperation
import com.galacticware.griddle.domain.operation.implementation.someargs.changemodifier.ChangeModifierArgs
import com.galacticware.griddle.domain.operation.implementation.someargs.inserttext.InsertText
import com.galacticware.griddle.domain.operation.implementation.someargs.switchscreens.SwitchScreenArgs

/**
 * These are the methods available for developers to build and assign gestures to buttons.
 */
interface IGestureBuilder {
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
                    GESTURE_DISPLAY_TEXT, GestureDisplayTextSet(
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
    ): GestureBinding.Incubator

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
        hotSwapType: HotSwapGestureType? = null,
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
        hotSwapType: HotSwapGestureType? = null,
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
        operation: RepeatSignalOperation,
        hotSwapType: HotSwapGestureType = HotSwapGestureType.SIGNAL
    ): GestureBinding.Incubator

    /**
     * Cycle through the selected languages of the keyboard either forward or reversed.
     */
    fun switchLanguage(
        modifierCycleDirection: ModifierCycleDirection = ModifierCycleDirection.FORWARD
    ): GestureBinding.Incubator
}
