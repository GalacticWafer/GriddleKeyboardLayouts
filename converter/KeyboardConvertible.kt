package com.galacticware.griddle.model.keyboard.definition.converter

interface KeyboardConvertible {
    fun buildLayouts(path: String)
    fun mapKeys(inputFilePath: String, outPath: String, prefix: String): String
}