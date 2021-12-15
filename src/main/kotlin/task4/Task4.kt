package task4

import util.Input

fun main(args: Array<String>) {
    val arg = if (args.isNotEmpty()) args[0] else "day4.txt"
    val input = Input.readStrings(arg)
    println(processBingo(input))
    println(processBingo2(input))
}

private fun processBingo(input: List<String>): Int {
    val numbers = parseNumbers(input)
    val bingoBoards = parseBoards(input)

    var selectedNumbers = numbers.take(4).toMutableSet()
    return numbers.drop(4).firstNotNullOf { draw ->
        selectedNumbers += draw
        bingoBoards.firstOrNull { it.isWinner(selectedNumbers) }?.let { winner ->
            draw * winner.sum(selectedNumbers)
        }
    }

}

private fun processBingo2(input: List<String>): Int {
    val numbers = parseNumbers(input)
    val bingoBoards = parseBoards(input)

    var selectedNumbers = numbers.toMutableSet()
    return numbers.reversed().firstNotNullOf { draw ->
        selectedNumbers -= draw
        bingoBoards.firstOrNull {
            !it.isWinner(selectedNumbers)}?.let { winner ->
            draw * (winner.sum(selectedNumbers) - draw)
        }
    }

}

private fun parseNumbers(input: List<String>) = input[0]
    .split(",")
    .toMutableSet()
    .map { it.toInt() }

private fun parseBoards(input: List<String>) = input
    .asSequence()
    .drop(1)
    .chunked(6)
    .map { line -> line.filter { it.isNotBlank() } }
    .map { board ->
        board.map { line ->
            line.split(" ", " ")
                .filter { it.isNotBlank() }
                .map { it.toInt() }
        }
    }
    .map { Board(it.toSet()) }
    .toList()

class Board(private val elements : Set<List<Int>>) {
    fun isWinner(numbers: Set<Int>): Boolean {
        return isWinOnRow(numbers) || isWinOnColumn(numbers)
    }

    private fun isWinOnRow(numbers : Set<Int>): Boolean {
        return elements.any {row -> row.all { it in numbers }}
    }

    private fun isWinOnColumn(numbers : Set<Int>): Boolean {
        return (0..4).any{col -> elements.all { row -> row[col] in numbers }}
    }

    fun sum(numbers: MutableSet<Int>): Int {
        return elements.sumOf { row ->
            row.filterNot { it in numbers }.sum()
        }
    }
}
