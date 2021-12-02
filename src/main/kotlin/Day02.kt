fun dive(commands: List<String>): Int {
    var depth = 0
    var horizontal = 0
    for (line in commands) {
        val (command, num) = line.split(' ')
        when (command) {
            "forward" -> horizontal += num.toInt()
            "down" -> depth += num.toInt()
            "up" -> depth -= num.toInt()
            else -> {
                println("WEIRD: command $command, num $num")
            }
        }
    }
    return depth * horizontal
}

fun main() {
    val lines = readInput("Day02Input")
    println("Depth * Horizontal = ${dive(lines)}")
}