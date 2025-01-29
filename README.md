# Griddle Keyboard Contribution

This document allows developers to contribute custom keyboard layouts for different languages to the IME project. Below is a guide to the open-source files, the classes and functions available in the API, and instructions for creating new keyboard layouts.

## Open Source Files Overview

In Griddle, anyone can design their own keyboard layout. 

Griddle keyboards are made from nesting information like so:
- `Keyboard`s have a name and one or more `Layer`s.
    - `Layer`s have a name, some defaults for buttons which all children object omit information for, and one or more `Button`s.
      - `Buttons` have information about their position, size, a defaults theme for `Buttons` and `Gesture`s that omit it, and zero or more `Gestures`.
        - `Gesture`s have information describing how to accomplish some action that you've chosen, and a `ModifierThemeSet`[][][].
          - `ModifierThemeSet`s have three `ModifierTheme`s holding display information on color and text for a specific gesture,
               and the `AppModifierKey` allows one of ,the three themes to be in use depending on the Keyboard's `AppModifierState`[][][].

## Make an example keyboard with code.

To make a Keyboard named "FooBar" that supports alphabet + numbers

You can accomplish this by following these steps:
- Create a directory lowercase-named `foobar` in your repository clone at `app/src/main/kotlin/com/galacticware/griddle/model/keyboard/builders/designs/foobar`
- Within your new directory, create the directories `/buttonbuilders`, `/english` and `/shared`, then create all of these files:
  - **`/buttonbuilders/FooBarEnglishBoardBuilder.kt`**: Defines fields to build a keyboard.
  - **`/buttonbuilders/FooBarSharedButtonBuilders.kt`**: Defines buttons that are used on more than one layer.
  - **`/english/FooBarAlphanumericEnglishLayerBuilder.kt`**: Defines fields to build buttons with English and numbers.
- In the `FooBarEnglishButtonBuilders` file, amke an empty button named button_<rowStart>_<colStart> describing the location of each button.
    These empty buttons can be reused to build finalized buttons in the correct location.
  ```kt
  val button_0_0 by lazy { gestureButton(rowStart = 0, colStart = 0, rowSpan = 1, colSpan = 1) }
  val button_0_1 by lazy { gestureButton(rowStart = 0, colStart = 1, rowSpan = 1, colSpan = 1) }
  val button_1_0 by lazy { gestureButton(rowStart = 1, colStart = 0, rowSpan = 1, colSpan = 1) }
  val button_1_1 by lazy { gestureButton(rowStart = 1, colStart = 1, rowSpan = 1, colSpan = 1) }
  val button_2_0 by lazy { gestureButton(rowStart = 0, colStart = 2, rowSpan = 2, colSpan = 1) }
  ```
  This keyboard will have 2 rows and 3 columns - a 2x2 grid of board plus one a button on the right.
- For each button builder you just made, and for each layer, create new buttons with meaningful names.
  - Put buttons that only exist on the alpha layer in `FooBarEnglishButtonBuilders.kt`
  - Put buttons that will be used on multiple layers in `FooBarSharedButtonBuilders.kt`
      For example, a button that handles arrow keys and cursor movement:
    ```kt
    val cursorControlButton = button_0_0.replaceGesturesWith(
      mutableSetOf(
        bindGesture(SWIPE_LEFT, MoveLeft, appSymbol = AppSymbol.LEFT_ARROW),
        bindGesture(BOOMERANG_LEFT, MoveWordLeft),
        bindGesture(SWIPE_RIGHT, MoveRight, appSymbol = RIGHT_ARROW),
        bindGesture(BOOMERANG_RIGHT, MoveWordRight),
        pressKey(SWIPE_UP, KEYCODE_DPAD_UP, appSymbol = UP_ARROW),
        pressKey(BOOMERANG_UP, KEYCODE_PAGE_UP, appSymbol = MOVE_PGUP),
        pressKey(BOOMERANG_UP_RIGHT, KEYCODE_DPAD_UP, modifiers = setOf(control)),
        pressKey(SWIPE_DOWN_RIGHT, KEYCODE_DPAD_RIGHT),
        bindGesture(BOOMERANG_RIGHT, MoveWordRight),
        pressKey(SWIPE_UP_LEFT, KEYCODE_DPAD_LEFT),
        pressKey(SWIPE_DOWN_LEFT, KEYCODE_DPAD_LEFT),
        bindGesture(BOOMERANG_LEFT, MoveWordLeft),
        pressKey(SWIPE_DOWN, KEYCODE_DPAD_UP, appSymbol = DOWN_ARROW),
        pressKey(BOOMERANG_DOWN, KEYCODE_PAGE_DOWN, appSymbol = MOVE_PGDN),
        bindGesture(CIRCLE_CLOCKWISE, MoveEnd, threeStrings = triple(MOVE_END)),
        bindGesture(CIRCLE_ANTI_CLOCKWISE, MoveHome, threeStrings = triple(MOVE_HOME)),
      ),
    )
    ```
- In each of the `FooBarAlphanumericEnglishLayerBuilder.kt` file, add the appropriate ButtonBuilders that you just made.
    ```kt
    object FooBarAlphanumericEnglishLayerBuilder : FooBarLayerBuilder() {
        override val isPrimary: Boolean = false
        override val keyboardHandedness = KeyboardHandedness(hasHandedness = true, pivotColumn = 1)
        override val layerKind: LayerKind = LayerKind.UNIFIED_ALPHA_NUMERIC
        override val languageTag = null
        override val defalultSize: IntSize = IntSize(45, 35)
    
        override fun buttonBuilders(): MutableSet<GestureButtonBuilder> {
            return setOf(
                englishABCDEFGHI, englishJKLMNOPQR, englishSTUVWXYZ,
                backspaceAndSpace, enter
            ).plus(
                setOf(
                    button1234, button5678, button9,
                    button0.withPosition(colStart = 0, colSpan = 3),
                    // right-side buttons start at column <pivot column + 1> == 2
                ).map { it.withPosition(colStart = 2 + it.gridPosition.colStart) }
            ).toMutableSet()
        }
    }
    ```
  You can add more layers later on by creating another file like this one.
- Now define the `builder/FooBarEnglishBoardBuilder.kt` file
    ```kt
    val FooBarEnglishBoardBuilder = { context: Context ->
        Keyboard(
            context,
            name = "FooBarEnglishBoard",
            layers = setOf(
                FooBarEnglishLayerBuilder,
                FooBarNumericLayerBuilder,
                FooBarNumeroSymbolicLayerBuilder,
                FooBarAlphanumericEnglishLayerBuilder,
                FooBarFunctionLayerBuilder,
            )
            .map { it.build(context) }
            .toMutableSet()
        )
    }
    ```
- That's it! You're ready to submit your new design for a PR! For details on advanced usage on all the helper methods you can call to build buttons, see the [Button Builder guide(TODO)].
