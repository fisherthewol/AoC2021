fun Part1(lines: List<String>): Int {
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

fun Part2(lines: List<String>): Int {
    var a: Int; var b = lines[0].toInt(); var c = lines[1].toInt()
    var prevSum: Int
    var currentSum = Int.MAX_VALUE
    var index = 2
    var sumIncrease = 0
    while (index < lines.size) {
        a = b
        b = c
        c = lines[index].toInt()
        prevSum = currentSum
        currentSum = a + b + c
        if (currentSum > prevSum) sumIncrease++
        index++
    }
    return sumIncrease
}

fun main() {
    val lines = readInput("Day01input")
    println(Part1(lines))
    println(Part2(lines))
}