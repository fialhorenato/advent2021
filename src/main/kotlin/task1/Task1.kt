package task1

import util.Input

private fun countIncrements(input: List<Int>): Int {
    return input
        .windowed(2, 1)
        .count { (x, y) -> x < y }
}

private fun countMovingIncrements(input: List<Int>): Int {
    return input
        .windowed(3, 1)
        .map { it.sum() }
        .let { countIncrements(it) }
}


fun main() {
    val input = Input.readIntegers("day1.txt")
    println(countIncrements(input))
    println(countMovingIncrements(input))
}
