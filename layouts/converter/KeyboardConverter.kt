package org.galacticware.griddle.keyboarddefinition.layouts.converter

interface KeyboardConverter {
    fun buildLayouts(path: String)
    fun mapKeys(inputFilePath: String, outPath: String, prefix: String): String
}