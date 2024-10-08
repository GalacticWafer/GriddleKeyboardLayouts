import org.galacticware.griddle.keyboarddefinition.layouts.converter.MatrixKeyboardConverter
import java.util.Stack
import java.io.File
import java.io.PrintStream
import java.io.PrintWriter

class FLickBoardConverter : MatrixKeyboardConverter() {
    companion object {
        private val lineRegex = Regex("Direction\\.(\\w+) to Action\\.Text\\(\"(.+)\"\\)")
        private fun mapKeys(
            inputFilePath: String,
            outPath: String,
            prefix: String,
        ): String {
            val outFile = File(outPath)
            with(outFile) {
                val printStream = PrintWriter(PrintStream(this@with))  // Use 'this@with' to reference the outer object
                if (exists()) {
                    createNewFile()  // Just create, don't delete
                }
                val docString = "/**\n" +
                        " * This file was generated by the FlickBoardConverter.kt script.\n" +
                        " */\n\n"
                println(docString)
                printStream.println(docString)
                val stack = Stack<String>()
                var j = -1
                var i = -1
                val lines = File(inputFilePath).readLines()

                lines.map { line ->
                    val find = lineRegex.find(line)
                    find?.let { match ->
                        val (flickBoardDirection, text) = match.destructured
                        val gestureType = when (flickBoardDirection) {
                            "CENTER" -> "CLICK"
                            "TOP" -> "SWIPE_UP"
                            "BOTTOM" -> "SWIPE_DOWN"
                            "LEFT" -> "SWIPE_LEFT"
                            "RIGHT" -> "SWIPE_RIGHT"
                            "TOP_LEFT" -> "SWIPE_UP_LEFT"
                            "TOP_RIGHT" -> "SWIPE_UP_RIGHT"
                            "BOTTOM_LEFT" -> "SWIPE_DOWN_LEFT"
                            else /* "BOTTOM_RIGHT"*/ -> "SWIPE_DOWN_RIGHT"
                        }
                        printStream.print("\n\t\tbind($gestureType, simpleInput, threeStrings = caseSensitive(\"$text\")),")
                    } ?: run {
                        if (line.contains(" = Layer(")) {
                            stack.push(")")
                        } else if (line == "        listOf(") {
                            stack.push(")")
                            i++
                            j = -1
                        } else if (line == "        keyRows = listOf(") {/*skip*/

                        } else if (line.endsWith("KeyM(")) {
                            stack.push(")")
                            printStream.print(
                                "\nprivate val _${prefix}_button${i}_${++j} = makeClassicGestureButton(" +
                                        "\n\trowStart = ${i}, colStart = ${j}, rowSpan = 1, colSpan = 1," +
                                        "\n\tgestureSet = mutableSetOf("
                            )
                        } else if (line.contains("actions = mapOf(")
                            || line == "                )"
                        ) {/* skip */
                        } else if (stack.isNotEmpty() && (line == "                ),"
                                    || line == "\t\t\t\t),"
                                    )
                        ) {
                            j = -1
                        } else if (stack.isNotEmpty() && (line.endsWith("\t\t\t),")
                                    || line == "            ),"
                                    )
                        ) {
                            printStream.print("\n\t)")
                            printStream.print("\n${stack.pop()}")
                        } else {/* skip */
                        }
                    }
                }
                printStream.flush()
                printStream.close()
                return absolutePath
            }
        }
    }

    override fun mapKeys(inputFilePath: String, outPath: String, prefix: String) =
        Companion.mapKeys(inputFilePath, outPath, prefix)
}