package util

import java.io.File

class Input {
    companion object {
        fun readStrings(fileName : String) : List<String> {
            return File("src/main/resources/${fileName}")
                .useLines {it.toList()}
        }

        fun printStrings(fileName : String){
            readStrings(fileName)
                .forEach{ println(it) }
        }

        fun readIntegers(fileName : String) : List<Int> {
            return readStrings(fileName)
                .map { it.toInt() }
        }

        fun printIntegers(fileName : String){
            readIntegers(fileName)
                .forEach{ println(it) }
        }
    }
}