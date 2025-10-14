package com.galacticware.griddle.domain.design.implementation.alpha4x4alnum7x4

import androidx.compose.ui.unit.IntSize
import com.galacticware.griddle.domain.design.base.collection.ButtonBuilders
import com.galacticware.griddle.domain.design.base.collection.IButtonBuilderSet.Companion.toButtonBuilders
import com.galacticware.griddle.domain.design.base.keyboard.AbstractKeyboardBuilder.Companion.getKeyboardBuilder
import com.galacticware.griddle.domain.design.base.keyboard.AbstractKeyboardDefinition
import com.galacticware.griddle.domain.design.base.keyboard.KeyboardKind
import com.galacticware.griddle.domain.design.base.layer.AbstractLayerBuilder.Companion.getLayerBuilder
import com.galacticware.griddle.domain.design.implementation.alpha4x4alnum7x4.Alpha4X4AlphaNum7X4KeyboardDefinition.colemakoidAlphaLayerButtons
import com.galacticware.griddle.domain.design.implementation.alpha4x4alnum7x4.Alpha4X4AlphaNum7X4KeyboardDefinition.colemakoidSymbolicLayerButtons
import com.galacticware.griddle.domain.design.implementation.alpha4x4alnum7x4.Alpha4X4AlphaNum7X4KeyboardDefinition.englishAlphaLayerButtons
import com.galacticware.griddle.domain.design.implementation.alpha4x4alnum7x4.Alpha4X4AlphaNum7X4KeyboardDefinition.functionLayerButtons
import com.galacticware.griddle.domain.design.implementation.alpha4x4alnum7x4.Alpha4X4AlphaNum7X4KeyboardDefinition.numpadLayerButtons
import com.galacticware.griddle.domain.design.implementation.alpha4x4alnum7x4.Alpha4X4AlphaNum7X4KeyboardDefinition.symbolicLayerButtons
import com.galacticware.griddle.domain.keyboard.KeyboardHandedness
import com.galacticware.griddle.domain.language.LayerTag.*
import com.galacticware.griddle.domain.modifier.SimpleDefaultColorPalettes
import com.galacticware.griddle.domain.modifier.GestureColors
import com.galacticware.griddle.domain.view.colorization.Hue

val DEFAULT_PRIMARY_THEME = GestureColors(
    textColorGroup = Hue.Gold,
    backgroundColorGroup = Hue.DarkGray,
    borderColorGroup = Hue.LightGray,
)

val defaultLayerColorization = SimpleDefaultColorPalettes.Theme.entries.first().colorScheme

val DEFAULT_SIZE = IntSize(90, 70)
/**
 * This design has GestureButtonBuilders that are positioned in MessagEase inspired positions.
 * It supports 4x4 layers for alphabetic layouts and 7x4 layers for alphanumeric layouts.
 */
object Alpha4X4AlphaNum7X4KeyboardDefinition: AbstractKeyboardDefinition() {
    override val defaultGestureColors: GestureColors by lazy { DEFAULT_PRIMARY_THEME }
    /**
     * Reuse 4x4 handedness for designs that want the same 4x4 keyboard handedness rules to apply.
     */
    val alpha4x4Handedness = KeyboardHandedness(hasHandedness = true, pivotColumn = 0)

    /**
     * Reuse 7x4 handedness for designs that want the same 4x4 keyboard handedness rules to apply.
     */
    val alphanumeric7x4Handedness = KeyboardHandedness(hasHandedness = true, pivotColumn = 3)

    /**
     * A layer with a 3x3 grid of numbers-only buttons, with zero on the fourth row.
     */
    val numpadLayerButtons by lazy {
        ButtonBuilders(
            numpad1, numpad2, numpad3, settingsButton,
            numpad4, numpad5, numpad6, alphabeticLayerToggle,
            numpad7, numpad8, numpad9, backspace,
            numericSpaceLeft, numpad0, numericSpaceRight, enter,
        )
    }

    /**
     * A layer with a 3x3 grid buttons containing numbers and symbols, with zero on the fourth row.
     */
    val symbolicLayerButtons by lazy {
        ButtonBuilders(
            symbol1, symbol2, symbol3, settingsButton,
            symbol4, symbol5, symbol6, alphabeticLayerToggle,
            symbol7, symbol8, symbol9, backspace,
            numericSpaceLeft, symbol0, numericSpaceRight, enter,
        )
    }

    /**
     * A layer with a 3x4 grid of function buttons.
     */
    val functionLayerButtons by lazy {
        ButtonBuilders(
            f1, f2, f3, settingsButton,
            f4, f5, f6, alphabeticLayerToggle,
            f7, f8, f9, backspace,
            f10, f11, f12, enter,
        )
    }

    /**
     * A layer with a 3x3 grid of english alphabet buttons.
     */
    val englishAlphaLayerButtons by lazy {
        ButtonBuilders(
            englishA, englishN, englishI,
            englishH, englishO, englishR,
            englishT, englishE, englishS,
            settingsButton, numericLayerToggle, backspace, space3u, enter
        )
    }


    /**
     * A set of buttons that may be added to or removed from another set for double-wide layer
     * building.
     */
    val peripheralButtons by lazy {
        ButtonBuilders(
            settingsButton, numericLayerToggle, backspace, space3u, enter, alphabeticLayerToggle
        )
    }

    /**
     * A layer with two 3x3 grids of english and number/symbols buttons respectively.
     */
    val englishNumericLayerButtons by lazy {
        shiftButtonsForAlphanumericLayer(englishAlphaLayerButtons)
    }

    /**
     * Todo:LANG_SUPPORT, make actual colemakoid and colemakoid-numeric layers (and other
     *  languages).
     */
    val colemakoidAlphaLayerButtons by lazy {
        ButtonBuilders(
            colemakoidA, colemakoidN, colemakoidI,
            colemakoidH, colemakoidO, colemakoidR,
            colemakoidT, colemakoidE, colemakoidS,
            settingsButton, colemakoidNumericLayerToggle, backspace, space3u, enter
        )
    }

    /**
     * A layer with two 3x3 grids of colemakoid and number/symbols buttons respectively.
     */
    val colemakoidSymbolicLayerButtons  by lazy {
        ButtonBuilders(
            colemakoid1, colemakoid2, colemakoid3,
            colemakoid4, colemakoid5, colemakoid6,
            colemakoid7, colemakoid8, colemakoid9,
            settingsButton, colemakoidAlphaLayerToggle, backspace, space3u, enter,
            symbol0,
        )
    }

    private fun shiftButtonsForAlphanumericLayer(builders: ButtonBuilders): ButtonBuilders
    = ButtonBuilders(
        settingsButton,
        alphabeticLayerToggle,
        backspace,
        space3u, enter
    ).plus(
        builders
            .filter { it.colStart < 3 }
            .map { it.at(colStart = it.colStart + 4) }
    )

    override val abbreviation: String
        get() = "A4-N7"
}

/**
 * Builder for a numeric 4x4 English layer.
 */
val Function4x4LayerBuilder by lazy {
    getLayerBuilder(Function,
        keyboardDefinable = Alpha4X4AlphaNum7X4KeyboardDefinition,
        keyboardHandedness = Alpha4X4AlphaNum7X4KeyboardDefinition.alpha4x4Handedness,
        buttonBuilders = functionLayerButtons,
    )
}

/**
 * Builder for a numeric 4x4 English layer.
 */
val EnglishSymbolic4x4LayerBuilder by lazy {
    getLayerBuilder(English, Symbolic,
        keyboardDefinable = Alpha4X4AlphaNum7X4KeyboardDefinition,
        keyboardHandedness = Alpha4X4AlphaNum7X4KeyboardDefinition.alpha4x4Handedness,
        buttonBuilders = ButtonBuilders(
            symbol1, symbol2, symbol3,
            symbol4, symbol5, symbol6,
            symbol7, symbol8, symbol9,
            settingsButton, alphabeticLayerToggle, backspace, space3u, enter,
            symbol0,
        ),
    )
}

/**
 * Builder for a numeric 4x4 English layer.
 */
val Numpad4x4LayerBuilder by lazy {
    getLayerBuilder(Numpad,
        keyboardDefinable = Alpha4X4AlphaNum7X4KeyboardDefinition,
        keyboardHandedness = Alpha4X4AlphaNum7X4KeyboardDefinition.alpha4x4Handedness,
        buttonBuilders = numpadLayerButtons,
    )
}

/**
 * Builder for an alphanumeric 7x4 English layer.
 */
val EnglishSymbolic7x4LayerBuilder by lazy {
    getLayerBuilder(English, Symbolic, Hybrid,
        keyboardDefinable = Alpha4X4AlphaNum7X4KeyboardDefinition,
        keyboardHandedness = Alpha4X4AlphaNum7X4KeyboardDefinition.alphanumeric7x4Handedness,
        buttonBuilders = symbolicLayerButtons.minus(settingsButton, alphabeticLayerToggle, backspace, enter)
            .map { it.at(colStart = it.colStart + 4) }
            .plus(englishAlphaLayerButtons)
            .toButtonBuilders(),
    )
}

/**
 * Builder for an alphabetic 4x4 English layer.
 */
val English4x4LayerBuilder by lazy {
    getLayerBuilder(English,
        keyboardDefinable = Alpha4X4AlphaNum7X4KeyboardDefinition,
        keyboardHandedness = Alpha4X4AlphaNum7X4KeyboardDefinition.alpha4x4Handedness,
        buttonBuilders = englishAlphaLayerButtons,
    )
}

/**
 * Builder for an alphabetic 4x4 colemakoid layer.
 */
val ColemakoidLayerBuilder by lazy {
    getLayerBuilder(Colemakoid,
        keyboardDefinable = Alpha4X4AlphaNum7X4KeyboardDefinition,
        keyboardHandedness = Alpha4X4AlphaNum7X4KeyboardDefinition.alpha4x4Handedness,
        buttonBuilders = colemakoidAlphaLayerButtons,
    )
}

/**
 * Builder for an alphabetic 4x4 colemakoid layer.
 */
val ColemakoidSymbolicLayerBuilder by lazy {
    getLayerBuilder(Colemakoid, Symbolic,
        keyboardDefinable = Alpha4X4AlphaNum7X4KeyboardDefinition,
        keyboardHandedness = Alpha4X4AlphaNum7X4KeyboardDefinition.alpha4x4Handedness,
        buttonBuilders = colemakoidSymbolicLayerButtons,
    )
}

/**
 * Builder for an alphanumeric 7x4 colemakoid layer.
 */
val ColemakoidSymbolic7X4LayerBuilder by lazy {
    getLayerBuilder(Colemakoid, Symbolic, Hybrid,
        keyboardDefinable = Alpha4X4AlphaNum7X4KeyboardDefinition,
        keyboardHandedness = Alpha4X4AlphaNum7X4KeyboardDefinition.alphanumeric7x4Handedness,
        buttonBuilders = symbolicLayerButtons
                .map { it.at(colStart = it.colStart + 4) }
                .plus(colemakoidAlphaLayerButtons)
                .toButtonBuilders(),
    )
}

/**
 * Builder for an English keyboard with 4x4 normal layers and 4x7 unified alphanumeric layers.
 */
val NumericSymbolic7X4LayerBuilder by lazy {
    getLayerBuilder(Numpad, Symbolic, Hybrid,
        keyboardDefinable = Alpha4X4AlphaNum7X4KeyboardDefinition,
        keyboardHandedness = Alpha4X4AlphaNum7X4KeyboardDefinition.alphanumeric7x4Handedness,
        buttonBuilders = symbolicLayerButtons
            .map { it.at(colStart = it.colStart + 4) }
            .plus(numpadLayerButtons)
            .toButtonBuilders(),
    )
}

/**
 * Builder for an English keyboard with 4x4 normal layers and 4x7 unified alphanumeric layers.
 */
val English4x4_7x4KeyboardBuilder by lazy {
    getKeyboardBuilder(
        Alpha4X4AlphaNum7X4KeyboardDefinition,
        KeyboardKind.DEFAULT,
        defaultLayerColorization,
        English4x4LayerBuilder,
        Function4x4LayerBuilder,
        Numpad4x4LayerBuilder,
        EnglishSymbolic4x4LayerBuilder,
        EnglishSymbolic7x4LayerBuilder,
        NumericSymbolic7X4LayerBuilder,
    )
}

/**
 * Builder for a colemakoid keyboard with 4x4 normal layers and 4x7 unified alphanumeric layers.
 */
val Colemakoid4x4_7x4KeyBoardBuilder by lazy {
    English4x4_7x4KeyboardBuilder.replaceLanguageLayersWith(
        "colemakoid4x4_7x4",
        ColemakoidLayerBuilder,
        ColemakoidSymbolicLayerBuilder,
        ColemakoidSymbolic7X4LayerBuilder,
    )
}

/**
 * Todo:LANG_SUPPORT, Make more language layers, then use [Colemakoid4x4_7x4KeyBoardBuilder] as an
 *  example of how to declare an [IKeyboardBuilder].
 */