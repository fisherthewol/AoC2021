package Day4
import readInput

fun main() {
    val lines = readInput("Day4", "Day4Test")
    val boards: MutableList<BingoBoard> = mutableListOf()
    for (line in lines.indices) {
        if (lines[line] == "") {
            val start = line + 1
            for (index in start..lines.lastIndex) {
                if (lines[index] == "") {
                    boards.add(BingoBoard(lines.slice(start until index)))
                    break
                }
            }
        }
    }
    println(boards.size)
}