package Day4
import readInput


class Point(val value: Int, val called: Boolean)

class BingoBoard(BoardString: List<String>) {
    var board: List<List<Point>> = BoardString.map { it.trim().split("  ", " ").map { Point(it.toInt(), false) } }
}

fun main() {
    val lines = readInput("Day4", "Day4Test")
    var b = BingoBoard(lines.slice(3..6))
    println(lines.size)
}