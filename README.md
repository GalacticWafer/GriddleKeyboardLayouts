# Griddle Keyboard Contribution

This document allows developers to contribute custom keyboard layouts for different languages to the IME project. Below is a guide to the open-source files, the classes and functions available in the API, and instructions for creating new keyboard layouts.

## Open Source Files Overview

Griddle is partially open sourced, to allow users to create default layouts for the community. These files define the default 
layers and boards for the Griddle English keyboard. Developers can use these as templates or extend them for other languages:

- **`GriddleEnglishDefaultAlphaLayer`**: Defines the default alpha (alphabetic) layer.
- **`GriddleEnglishDefaultBoard.kt`**: Defines the overall layout and properties of the default board.
- **`GriddleEnglishDefaultKeys.kt`**: Manages key configurations and mappings.
- **`GriddleEnglishDefaultUnifiedAlphaNumericLayer`**: Defines a unified alphanumeric layer, including both letters and numbers.
- **`GriddleEnglishDefaultFunctionLayer`**: Handles function keys (e.g., Shift, Control).
- **`GriddleEnglishDefaultNumericLayer`**: Manages the numeric keypad.

## API Documentation for Developers

### Class: `KeyboardLayer`
Base class for creating keyboard layers. All layers (e.g., alpha, numeric) must extend this class.

- **Property: `definition`**  
  Defines the layer type (e.g., `ALPHA_LAYER`, `NUMERIC_LAYER`). Use `LayerDefinition.ALPHA_LAYER` for alphabetic layers and `LayerDefinition.ALPHA_NUMERIC_UNIFIED` for layers that include both letters and numbers.

- **Property: `gestureBoxBuilders`**  
  Set of `GestureBoxBuilder` instances that define the gestures and their associated operations for this layer.

- **Function: `default()`**  
  Returns the singleton instance of the layer.

### Class: `ModifierTheme`
Defines the appearance and behavior of a gesture's visual representation.

- **Function: `withText(s: String)`**  
  Returns a copy of the `ModifierTheme`, updating the displayed text.

- **Function: `withBoxBackgroundColor(color: Color)`**  
  Returns a copy of the `ModifierTheme`, updating the background color.

- **Function: `withTextSize(sp: TextUnit)`**  
  Returns a copy of the `ModifierTheme`, updating the text size.

### Class: `ModifierThemeSet`
Manages themes for modifier keys across different states (e.g., `NONE`, `ONCE`, `REPEAT`).

- **Function: `forModifierWithDefaultTheme(noneStateText: String, onceStateText: String, repeatStateText: String, kind: ModifierKeyKind)`**  
  Creates a `ModifierThemeSet` with default themes for each state.

- **Function: `withThemeForState(newColorSet: ModifierTheme, modifierKeyState: ModifierKeyState)`**  
  Returns a copy of the `ModifierThemeSet` with an updated theme for the specified state.

### Enum: `ModifierKeyKind`
Defines the types of modifier keys (e.g., `SHIFT`, `CONTROL`, `ALT`).

### Enum: `ModifierKeyState`
Represents the state of a modifier key (e.g., `NONE`, `ONCE`, `REPEAT`).

### Enum: `GestureType`
Represents the 20 supported gestures on a MessagEase-style swipe keyboard.
```kt
enum class GestureType {
    BOOMERANG_DOWN,
    BOOMERANG_DOWN_LEFT,
    BOOMERANG_DOWN_RIGHT,
    BOOMERANG_LEFT,
    BOOMERANG_RIGHT,
    BOOMERANG_UP,
    BOOMERANG_UP_LEFT,
    BOOMERANG_UP_RIGHT,
    CIRCLE_ANTI_CLOCKWISE,
    CIRCLE_CLOCKWISE,
    HOLD,
    CLICK,
    COPYABLE_CLICK,
    MESSAGE_BOX_NO_OP,
    SWIPE_DOWN,
    SWIPE_DOWN_LEFT,
    SWIPE_DOWN_RIGHT,
    SWIPE_LEFT,
    SWIPE_RIGHT,
    SWIPE_UP,
    SWIPE_UP_LEFT,
    SWIPE_UP_RIGHT,
    ;
```

## Guidelines for Contributors

To contribute a new keyboard layout, follow these steps:

1. **Create a New Layer Class**:
    - Extend `KeyboardLayer`.
    - Set the `definition` property to the appropriate `LayerDefinition`.
    - Define `gestureBoxBuilders` to specify the keys and gestures.

2. **Customize the Board**:
    - Extend the `Keyboard` class to define the board layout.
    - Ensure the class name follows the convention `<LayoutName><Language>DefaultBoard`. Keep in mind that:
      - all KeyboardLayer classes should be in the same package as the default board.
      - If you don't like the button arrangements of the Griddle layout, the you can make a new one by creating a new
        package in the `layouts` package and creating a new class that extends `Keyboard`
      - All layouts must have:
        - a unique <LayoutName>
        - all alpha characters for the specified language available on the alpha layer
        - all numeric characters for the specified language available on the numeric layer
        - all function keys on the function layer
        - all alpha and numeric characters on the unified alpha numeric layer
      - The unified alphanumeric layer is not required, but it is recommended for ease of use.
      - you can mix and match layers from any layout, allowing multi-language boards. 

3. **Modify Themes and Gestures**:
    - Use `ModifierTheme` and `ModifierThemeSet` to customize the appearance of keys.
    - Utilize the `bind` function to associate gestures with specific operations.

4. **Test and Document**:
    - Thoroughly test the new layout.
    - Provide clear documentation for any custom classes or functions.

# Function Documentation: `bind`

## Overview

The `bind` function is used to create a gesture for a custom keyboard. A gesture is a specific user action (like a swipe or tap) that performs a predefined operation. This function lets you define what happens when the gesture is recognized, including the visual appearance of the key and its behavior.

## Parameters

### `gestureType: GestureType`
- **Description**: Specifies the type of gesture (e.g., swipe, tap) that the user will perform.
- **Example**: `GestureType.SWIPE_UP`

### `griddleOperation: GriddleOperation`
- **Description**: Defines the operation that should be executed when the gesture is detected. This could be inserting text, executing a command, etc.
- **Example**: `GriddleOperation.INSERT_TEXT`

### `appSymbol: AppSymbol?`
- **Description**: An optional symbol associated with the gesture. If not provided, the `char` parameter will be used instead.
- **Example**: `AppSymbol("★")`

### `char: String?`
- **Description**: The character to be input or displayed on the key when the gesture is recognized. Defaults to the value of `appSymbol` if provided.
- **Example**: `"A"`

### `threeChars: Triple<String, String, String>`
- **Description**: A set of three characters representing different states (e.g., normal, shifted, caps lock). This helps in displaying different characters based on the state of the keyboard.
- **Example**: `Triple("a", "A", "AA")`

### `foregroundColor: Color?`
- **Description**: The color of the text or symbol on the key. If not set, it uses the default color.
- **Example**: `Color.White`

### `backgroundColor: Color?`
- **Description**: The background color of the key. Defaults to transparent if not provided.
- **Example**: `Color.Black`

### `borderColor: Color?`
- **Description**: The color of the key's border. If not specified, it will be transparent.
- **Example**: `Color.Gray`

### `fontSize: TextUnit?`
- **Description**: The size of the text displayed on the key. Defaults to a size appropriate for the gesture type if not provided.
- **Example**: `16.sp`

### `modifierTheme: ModifierTheme?`
- **Description**: Defines the visual theme of the gesture key, including text color, background color, and font size. If not provided, a default theme is used.
- **Example**:
  ```kotlin
  ModifierTheme(
      textColor = Color.White,
      backgroundColor = Color.Black,
      borderColor = Color.Gray,
      fontSizeHint = 16.sp,
      text = "A"
  )

# Class Documentation: `GriddleEnglishDefaultAlphaLayer`

## Overview

The `GriddleEnglishDefaultAlphaLayer` class represents the default alpha (letter) layer for the Griddle keyboard layout in English. It extends the `KeyboardLayer` class and configures how the alpha keys (letters) are displayed and behave on the keyboard.

## Constructor

The `GriddleEnglishDefaultAlphaLayer` class is initialized with the following parameters:

- **`definition: LayerDefinition`**: Specifies that this layer is an alpha layer. The value is set to `LayerDefinition.ALPHA_LAYER`.
- **`gestureBoxBuilders: Set<GestureBoxBuilder>`**: A set of `GestureBoxBuilder` instances used to construct the `GestureBox`es for this layer.
- **`borderColor: Color`**: The default color for the border of the layer. If not provided for a `GestureBox`, it defaults to the `textColor` from `EnglishDefaultBoard.defaultModifierTheme`.
- **`backgroundColor: Color`**: The default background color for the layer. If not provided for a `GestureBox`, it defaults to `Color.Black`.
- **`textColor: Color`**: The default color of the text on the layer. If not provided for a `GestureBox`, it defaults to the `textColor` from `EnglishDefaultBoard.defaultModifierTheme`.
- **`fontSize: TextUnit`**: The default font size for the text on the layer. It is calculated using `EnglishDefaultBoard.defaultModifierTheme.calculateFontSize` based on the available space.
- **`layerType: LayerType`**: Specifies the type of layer. For this class, it is set to `LayerType.ALPHA`.

## Companion Object

### `boxBuilders`
- **Description**: A set of `GestureBoxBuilder` instances used to construct the `GestureBox`es for this layer.
- you can mix and match boxes from any layout, allowing multi-language boards.

### `instance`
- **Description**: A singleton instance of the `GriddleEnglishDefaultAlphaLayer` class.

## Methods

### `default()`
- **Description**: Returns the singleton instance of the `GriddleEnglishDefaultAlphaLayer` class.
- **Return Type**: `GriddleEnglishDefaultAlphaLayer`
- **Usage**: This method provides a way to access the default instance of this layer, ensuring a consistent configuration across the application.

## Usage Example

To create a new instance of the `GriddleEnglishDefaultAlphaLayer` and use it in your keyboard setup, you can do the following:

```kotlin
val alphaLayer = GriddleEnglishDefaultAlphaLayer()
