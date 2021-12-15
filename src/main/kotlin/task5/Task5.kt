package taskN

import util.Input
import kotlin.math.absoluteValue

private const val DAY = "5"

fun main() {
    val input = Input.readStrings("day$DAY.txt")
    print(Day05(input).solvePart1())
    print(Day05(input).solvePart2())
}

class Day05(input: List<String>) {

    private val instructions = input.map { parseInput(it) }

    fun solvePart1(): Int =
        solve { it.first hasSameAxis it.second }

    fun solvePart2(): Int =
        solve { true }

    private fun solve(lineFilter: (Pair<Coordinate, Coordinate>) -> Boolean) =
        instructions
            .filter { lineFilter(it) }
            .map { it.first parseLine it.second }
            .flatten()
            .groupingBy { it }
            .eachCount()
            .count { it.value > 1 }

    private fun parseInput(input: String): Pair<Coordinate, Coordinate> =
        Pair(
            input.substringBefore(" ").split(",").map { it.toInt() }.let { Coordinate(it.first(), it.last()) },
            input.substringAfterLast(" ").split(",").map { it.toInt() }.let { Coordinate(it.first(), it.last()) }
        )
}

data class Coordinate(val x: Int, val y: Int) {

    infix fun hasSameAxis(that: Coordinate): Boolean =
        x == that.x || y == that.y

    infix fun parseLine(that: Coordinate): List<Coordinate> {
        val xDelta = walkStep(x, that.x)
        val yDelta = walkStep(y, that.y)
        val steps = maxOf((x - that.x).absoluteValue, (y - that.y).absoluteValue)
        return (1..steps)
            .scan(this) { last, _ -> Coordinate(last.x + xDelta, last.y + yDelta) }
    }

    private fun walkStep(a: Int, b: Int): Int =
        when {
            a > b -> -1
            a < b -> 1
            else -> 0
        }
}