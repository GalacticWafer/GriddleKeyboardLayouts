package com.galacticware.griddle.model.keyboard.definition.designs.base

import android.content.Context
import com.galacticware.griddle.model.keyboard.Keyboard

interface KeyboardBuilder {
    fun build(context: Context): Keyboard
}