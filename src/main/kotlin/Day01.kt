fun Part1(lines: List<String> ): Int {
    var depthIncrease = 0
    var prevMeasure: Int
    var currentMeasure = Int.MAX_VALUE
    for (line in lines) {
        if (line == "") break // If we reach empty line at end, leave.
        prevMeasure = currentMeasure // Move along one.
        currentMeasure = line.toInt()
        if (currentMeasure > prevMeasure) depthIncrease++
    }
    return depthIncrease
}

fun main() {
    val lines = readInput("Day01input")
    println(Part1(lines))
}