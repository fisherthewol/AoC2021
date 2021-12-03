fun List<String>.toCols(): Map<Int, MutableList<Char>> {
    val lineSize = this[0].length;
    val cols = mutableMapOf<Int, MutableList<Char>>()
    for (i in 0 until lineSize) {
        cols[i] = mutableListOf()
    }
    for (line in this) {
        for (i in 0 until lineSize) {
            val col = cols[i]
            col?.add(line[i])
        }
    }
    return cols
}

fun binaryDiagnostics(lines: List<String>): Int {
    val cols = lines.toCols()
    var gamma = ""; var epsilon = ""
    for (col in cols){
        gamma += col.value.groupingBy { it }.eachCount().maxByOrNull { it.value }?.key
        epsilon += col.value.groupingBy { it }.eachCount().minByOrNull { it.value }?.key
    }
    return gamma.padStart(16, '0').toInt(2) * epsilon.padStart(16, '0').toInt(2)
}

fun oxygenGenRating(lines: List<String>): Int {

}

fun co2ScrubRating(lines: List<String>): Int {

}

fun lifeSupportRating(lines: List<String>): Int {
    return oxygenGenRating(lines) * co2ScrubRating(lines)
}

fun main() {
    val lines = readInput("Day03Input")
    println("Power Consumption: ${binaryDiagnostics(lines)}")
    println("Life support rating: ${lifeSupportRating(lines)}")
}