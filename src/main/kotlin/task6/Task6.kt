package task6

import util.Input

class Task6 {
    fun resolve() {
        val strings = Input.readStrings("day6.txt")
        val input = strings[0]
            .split(",")
            .map { it.toInt() }
            .groupingBy { it }
            .eachCount()
            .mapValues { (_, value) -> value.toLong() }

        task1(input)
        task2(input)
    }

    private fun task1(input : Map<Int, Long>) {
        println(solve(input, 80))
    }

    private fun task2(input : Map<Int, Long>) {
        println(solve(input, 256))
    }

    private fun solve(input: Map<Int, Long>, repeats: Int): Long {
        var lanternFishs = input

        repeat(repeats) {
            val newMap = mutableMapOf<Int, Long>()

            lanternFishs.forEach {
                if (it.key == 0) {
                    newMap[8] = newMap.getOrDefault(8, 0) + it.value
                    newMap[6] = newMap.getOrDefault(6, 0) + it.value
                } else {
                    newMap[it.key - 1] = newMap.getOrDefault(it.key - 1, 0) + it.value
                }
            }

            lanternFishs = newMap
        }

        return lanternFishs
            .map { it.value }
            .sum()
    }


}

fun main() {
    Task6().resolve()
}