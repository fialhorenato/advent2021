package task1

import util.Input

class TaskN {
    companion object {
        private const val DAY = "N"

        @JvmStatic
        fun main(args: Array<String>) {
            val arg = if (args.isNotEmpty()) args[0] else "day${DAY}.txt"
            Input.printStrings(arg)
            val input = Input.readStrings(arg)
        }
    }
}
