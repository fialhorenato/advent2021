package task1

import util.Input

fun main() {
    val input = Input.readIntegers("day1.txt")
    println(countIncrements(input))
    println(countMovingIncrements(input))
}

private fun countIncrements(input : List<Int>): Int {
    return input
            // Creates a window of 2 numbers
        .windowed(2, 1)
            // Count if the first number is less than the second number
        .count{ (x,y) -> x < y}
}

private fun countMovingIncrements(input : List<Int>): Int {
    val movingAverage =  input
            // Creates windows of 3 numbers
        .windowed(3,1)
            // Sum those numbers
        .map { it.sum() }

    // Call the previous function to count the increments
    return countIncrements(movingAverage)
}

