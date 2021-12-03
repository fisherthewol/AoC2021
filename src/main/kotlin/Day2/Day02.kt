package Day2

import readInput

fun dive(commands: List<String>): Int {
    var depth = 0
    var horizontal = 0
    for (line in commands) {
        val (command, numStr) = line.split(' ')
        val num = numStr.toInt()
        when (command) {
            "forward" -> horizontal += num
            "down" -> depth += num
            "up" -> depth -= num
            else -> {
                println("WEIRD: command $command, num $num")
            }
        }
    }
    return depth * horizontal
}

fun aim(commands: List<String>): Int {
    var depth = 0; var horizontal = 0; var aim = 0
    for (line in commands) {
        val (command, numStr) = line.split(' ')
        val num = numStr.toInt()
        when (command) {
            "forward" -> {
                horizontal += num
                depth += aim * num
            }
            "down" -> aim += num
            "up" -> aim -= num
            else -> {
                println("WEIRD: command $command, num $num")
            }
        }
    }
    return depth * horizontal
}

fun main() {
    val lines = readInput("Day2", "Day02Input")
    println("Depth * Horizontal = ${dive(lines)}")
    println("With aiming = ${aim(lines)}")
}