package task3

import util.Input

fun main() {
    val input = Input.readStrings("day3.txt")
    println(firstTask(input))
    println(secondTask(input))
}

private fun firstTask(input : List<String>): Int {
    // Get the size of the string to compare char by chat
    var lenght = input.first().length

    // Char by char, goes into each Nth element in the list to count more 0 or 1
    var gamma = (0 until lenght)
        .map { input.distribution(it) }
        .joinToString("") {
                (numberOfZeros, numberOfOnes) -> if(numberOfZeros > numberOfOnes) "0" else "1"
        }

    // If the most common is 0, the least common is 1, and vice-versa
    var epsilon = gamma.map {
        if (it == '0') "1" else "0"
    }.joinToString("")

    // Binary to Int
    return gamma.toInt(2) * epsilon.toInt(2)
}

private fun secondTask(input : List<String>): Int {
    var oxygen = input.map { it }

    var oxygenIndex = 0
    while (oxygen.size > 1) {
        val (zeros, ones) = oxygen.distribution(oxygenIndex)
        oxygen = oxygen.filter { it[oxygenIndex] == if (zeros > ones) '0' else '1' }
        oxygenIndex++
    }

    var co2 = input.map { it }
    var co2Index = 0

    while (co2.size > 1) {
        val (zeros, ones) = co2.distribution(co2Index)
        co2 = co2.filter { it[co2Index] == if (zeros <= ones) '0' else '1' }
        co2Index++
    }

    return oxygen.first().toInt(2) * co2.first().toInt(2)
}

fun List<String>.distribution(index: Int): Pair<Int, Int> {
    var numberOfZeros = 0
    var numberOfOnes = 0
    this.forEach {
        when (it[index]) {
            '0' -> numberOfZeros++
            '1' -> numberOfOnes++
        }
    }
    return numberOfZeros to numberOfOnes
}



