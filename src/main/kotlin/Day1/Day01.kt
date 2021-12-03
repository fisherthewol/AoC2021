package Day1

import readInput

fun part1(lines: List<Int>): Int {
    var depthIncrease = 0
    var prevMeasure: Int
    var currentMeasure = Int.MAX_VALUE
    for (line in lines) {
        prevMeasure = currentMeasure // Move along one.
        currentMeasure = line
        if (currentMeasure > prevMeasure) depthIncrease++
    }
    return depthIncrease
}

fun part2(lines: List<Int>): Int {
    var a: Int; var b = lines[0]; var c = lines[1]
    var prevSum: Int
    var currentSum = Int.MAX_VALUE
    var index = 2
    var sumIncrease = 0
    while (index < lines.size) {
        a = b
        b = c
        c = lines[index]
        prevSum = currentSum
        currentSum = a + b + c
        if (currentSum > prevSum) sumIncrease++
        index++
    }
    return sumIncrease
}

fun main() {
    val lines = readInput("Day1","Day01input").map { it.toInt() }
    println("Measurements greater than previous: ${part1(lines)}.")
    println("Sums greater than previous window: ${part2(lines)}.")
}