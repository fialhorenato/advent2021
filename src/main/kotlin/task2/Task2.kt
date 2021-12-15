package task2

import util.Input

fun main() {
    val input = Input.readStrings("day2.txt")
    println(finalPosition1(input));
    println(finalPosition2(input));
}

private fun finalPosition1(input: List<String>): Int {
    var horizontal = 0
    var depth = 0

    fun process(command: String, value: Int) {
        when(command) {
            "forward" -> horizontal += value
            "down" -> depth += value
            "up" -> depth -= value
        }
    }

    input.forEach {
        val vars = it.split(" ")
        val command = vars[0]
        val arg = vars[1].toInt()
        process(command, arg)
    }

    return horizontal * depth
}

private fun finalPosition2(input: List<String>): Int {
    var horizontal = 0
    var depth = 0
    var aim = 0

    fun process(command: String, value: Int) {
        when(command) {
            "forward" -> {
                horizontal += value
                depth  += value * aim
            }
            "down" -> aim += value
            "up" -> aim -= value
        }
    }

    input.forEach {
        val vars = it.split(" ")
        val command = vars[0]
        val arg = vars[1].toInt()

        process(command, arg)
    }

    return horizontal * depth
}



