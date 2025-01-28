package com.galacticware.griddle.model.keyboard.definition.converter

import java.io.File

abstract class MatrixKeyboardConvertible:
    KeyboardConvertible {
    /**
     * Provide a file path to the directory containing the layout files, and they will be output to an adjacent
     * directory with the same name, but with the current date and time appended to the name.
     * @param path The path to the directory containing the layout files.
     */
    override fun buildLayouts(path: String) {
        val time = System.currentTimeMillis()
        val file = File(path)
        file.parent?.plus("/converted/")?.let { outputDir ->
            if (!File(outputDir).exists()) {
                File(outputDir).mkdir()
            }
            file.walk().forEach {
                if (it.isFile && it.extension == "kt") {
                    mapKeys(it.absolutePath, "${outputDir}_${time}_${it.name}", it.nameWithoutExtension)
                }
            }
        }
    }
}
