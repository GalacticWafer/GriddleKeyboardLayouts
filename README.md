# Griddle Language Layer Contribution

This document allows people to contribute custom keyboard layouts for different languages.

In Griddle, a "layer" is all the buttons you see at one time on the screen. You don't have to know how to code to declare your own language layer. Just follow these four steps:

1. Rename a copy of [A4N7_EnglishButtons.kt](implementation/alpha4x4alnum7x4/A4N7_EnglishButtons.kt) `A4N7_Yourlanguage` (replace "Yourlanguage" with the name of your language, first letter capitalized.)
2. Change the names of the buttons from `englishA` to `<yourlanguage><CenterKey>` where `<yourlanguage>` is the all lowercase name of your language, and `<Centerkey>` is the capitalized name of the language.
3. To assign a gesture, choose a combination of button palette, gesture palette, gesture type, and operation
    - **button palette** - describes the background color. Choose one of:
        - MultiColorButtonTemplate
        - BrightMonochromeTemplate
        - DarkMonochromeTemplate
    - **gesture palette** - describes the foreground color. Choose one of:
        - CentralAlphanumericColor
        - NonCentralAlphanumericColor
        - PeripheralSymbolicColor
        - BrightMonochromeColor
        - DarkMonochromeColor
        - NoColor
    - **gesture type** - these are the possible gestures in Griddle. Choose one of:
        - Click
        - Hold
        - SmallCircleClockwise
        - BigCircleClockwise
        - SmallCircleCounterClockwise
        - BigCircleCounterClockwise
        - ShortSwipeNorth
        - LongSwipeNorth
        - ShortSwipeSouth
        - LongSwipeSouth
        - ShortSwipeEast
        - LongSwipeEast
        - ShortSwipeWest
        - LongSwipeWest
        - ShortSwipeNorthEast
        - LongSwipeNorthEast
        - ShortSwipeSouthEast
        - LongSwipeSouthEast
        - ShortSwipeNorthWest
        - LongSwipeNorthWest
        - ShortSwipeSouthWest
        - LongSwipeSouthWest
        - ShortBoomerangNorth
        - LongBoomerangNorth
        - ShortBoomerangSouth
        - LongBoomerangSouth
        - ShortBoomerangEast
        - LongBoomerangEast
        - ShortBoomerangWest
        - LongBoomerangWest
        - ShortBoomerangNorthEast
        - LongBoomerangNorthEast
        - ShortBoomerangSouthEast
        - LongBoomerangSouthEast
        - ShortBoomerangNorthWest
        - LongBoomerangNorthWest
        - ShortBoomerangSouthWest
        - LongBoomerangSouthWest
    - **operation** - describes the actions that a gesture can invoke in Griddle. Choose one of:
        - InsertText: Inserts up to 4 characters at the cursor position.
        - KeyLegendLookup: Performs the action associated with a special key that doesn't have a single-character ASCII representation (such as Tab, Enter, or custom remapped keys).
        - SwitchScreens: Opens a user-controllable screen, such as Text Replacements, Color options, or Gesture options.
        - PressKey: Simulates a hardware key press (e.g., Enter, Tab, Arrow keys, etc.).
        - Backspace: Deletes a character to the left of the cursor. Optimized for rapid or repeated deletion.
        - DeleteWordLeft: Deletes entire words to the left of the cursor. Repeatable by clicking on the Settings key.
        - ChangeInputMethod: Opens the system input method picker, allowing the user to switch to a different keyboard app.
        - SpeechToText: Activates speech recognition, allowing the user to dictate text instead of typing.
        - SwapHandedness: Switches the keyboard layout between left-handed and right-handed modes.
        - ResizeBoard: Allows the user to move and resize the keyboard by dragging it on the screen.
        - ChangeModifier: Changes the state of a modifier key (Shift, Ctrl, or Alt.) according to the specified action (e.g., apply one-shot, toggle, etc.). The user can choose which modifier and what action to apply.
        - DeleteWordRight: Deletes entire words to the right of the cursor. Repeatable by clicking on the Settings key.
        - SelectAll: Selects all text in the current input field.
        - MoveLeft: Moves the cursor one character to the left. Repeatable by clicking on the Settings key.
        - MoveRight: Moves the cursor one character to the right. Repeatable by clicking on the Settings key.
        - MoveWordLeft: Moves the cursor one word to the left. Repeatable by clicking on the Settings key.
        - MoveWordRight: Moves the cursor one word to the right. Repeatable by clicking on the Settings key.
        - Undo: Undoes the last text operation. Repeatable by clicking on the Settings key.
        - Redo: Redoes the last undone text operation. Repeatable by clicking on the Settings key.
        - MoveHome: Moves the cursor to the beginning of the line or field.
        - MoveUp: Moves the cursor up one line. Repeatable by clicking on the Settings key.
        - MoveDown: Moves the cursor down one line. Repeatable by clicking on the Settings key.
        - MoveEnd: Moves the cursor to the end of the line or field.
        - MovePageUp: Moves the cursor up by one page. Repeatable by clicking on the Settings key.
        - MovePageDown: Moves the cursor down by one page. Repeatable by clicking on the Settings key.
        - ToggleGestureCorrection: Toggles gesture correction mode on or off.
        - SwitchLanguage: Switches to the next or previous language layout.
        - SwitchLayer: Switches to a different keyboard layer (such as symbols, numbers, or custom layouts).
        - PressEnterKey: Presses the Enter key, context-sensitive (e.g., triggers 'Next', 'Go', or 'Enter' actions depending on the input field).
        - SendNewLineFeed: Sends a literal new line (\n) character at the cursor position. Repeatable by clicking on the Settings key.
        - PressTab: Presses the Tab key (moves focus to the next field or inserts a tab, depending on context). Repeatable by clicking on the Settings key.
        - PressUnTab: Presses Shift+Tab (moves focus to the previous field or performs an un-indent, depending on context). Repeatable by clicking on the Settings key.
        - SendTab: Sends a literal tab (\t) character at the cursor position. Repeatable by clicking on the Settings key.
4. When you are satisfied with your button/gesture definitions, submit a [pull request](https://github.com/GalacticWafer/GriddleKeyboardLayouts/pulls)