package taskN

import util.Input

class TaskN {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val arg = if (args.isNotEmpty()) args[0] else "day1.txt"
            val input = Input.readIntegers(arg)
            println(countIncrements(input))
            println(countMovingIncrements(input))
        }

        private fun countIncrements(input : List<Int>): Int {
            return input
                .windowed(2, 1)
                .count{ (x,y) -> x < y}
        }

        private fun countMovingIncrements(input : List<Int>): Int {
            return input
                .windowed(3,1)
                .map { it.sum() }
                .let { countIncrements(it) }
        }
    }
}
