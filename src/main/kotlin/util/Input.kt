package util

import java.io.File

class Input {
    companion object {
        fun readStrings(fileName : String) : List<String> {
            return File("src/main/resources/${fileName}")
                .useLines {it.toList()}
        }

        fun readIntegers(fileName : String) : List<Int> {
            return File("src/main/resources/${fileName}")
                .useLines {it.toList()}
                .map { it.toInt() }
        }
    }
}