fun toCols(lines: List<String>): MutableMap<Int, MutableList<Char>> {
    val lineSize = lines[0].length;
    var cols = mutableMapOf<Int, MutableList<Char>>()
    for (i in 0 until lineSize) {
        cols[i] = mutableListOf()
    }
    for (line in lines) {
        for (i in 0 until lineSize) {
            var col = cols[i]
            col?.add(line[i])
        }
    }
    return cols
}

fun binaryDiagnostics(lines: List<String>): Int {
    var cols = toCols(lines)
    var gamma = ""; var epsilon = ""
    for (col in cols){
        gamma += col.value.groupingBy { it }.eachCount().maxByOrNull { it.value }?.key
        epsilon += col.value.groupingBy { it }.eachCount().minByOrNull { it.value }?.key
    }
    return gamma.padStart(16, '0').toInt(2) * epsilon.padStart(16, '0').toInt(2)
}

fun lifeSupportRating(lines: List<String>): Int {
    var cols = toCols(lines)
}

fun main() {
    val lines = readInput("Day03Input")
    println("Power Consumption: ${binaryDiagnostics(lines)}")
    println("Life support rating: ${lifeSupportRating(lines)}")
}