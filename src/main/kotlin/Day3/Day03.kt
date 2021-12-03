package Day3

import readInput

fun List<String>.toCols(): List<MutableList<Char>> {
    val lineSize = this[0].length
    val cols : MutableList<MutableList<Char>> = mutableListOf()
    for (i in 0 until lineSize) {
        cols.add(mutableListOf())
    }
    for (line in this) {
        for (i in 0 until lineSize) {
            val col = cols[i]
            col.add(line[i])
        }
    }
    return cols
}

fun binaryDiagnostics(lines: List<String>): Int {
    val cols = lines.toCols()
    var gamma = ""; var epsilon = ""
    for (col in cols){
        gamma += col.groupingBy { it }.eachCount().maxByOrNull { it.value }?.key
        epsilon += col.groupingBy { it }.eachCount().minByOrNull { it.value }?.key
    }
    return gamma.padStart(16, '0').toInt(2) * epsilon.padStart(16, '0').toInt(2)
}

fun oxygenGenRating(lines: List<String>): Int {
    val working = lines.toMutableList()
    for (i in working.indices) {
        if (working.size == 1) break
        // Don't know what this does on equal values.
        val d = working.toCols()[i].groupingBy { it }.eachCount()
        val c: Char? = if (d['0'] == d['1']) '1'
        else d.maxByOrNull { it.value }?.key
        working.retainAll { it[i] == c }
    }
    return working[0].padStart(16, '0').toInt(2)
}

fun co2ScrubRating(lines: List<String>): Int {
    val working = lines.toMutableList()
    for (i in working.indices) {
        if (working.size == 1) break
        // Don't know what this does on equal values.
        val d = working.toCols()[i].groupingBy { it }.eachCount()
        val c: Char? = if (d['0'] == d['1']) '0'
        else d.minByOrNull { it.value }?.key
        working.retainAll { it[i] == c }
    }
    return working[0].padStart(16, '0').toInt(2)
}

fun lifeSupportRating(lines: List<String>): Int {
    return oxygenGenRating(lines) * co2ScrubRating(lines)
}

fun main() {
    val lines = readInput("Day3", "Day03Input")
    println("Power Consumption: ${binaryDiagnostics(lines)}")
    println("Life support rating: ${lifeSupportRating(lines)}")
}