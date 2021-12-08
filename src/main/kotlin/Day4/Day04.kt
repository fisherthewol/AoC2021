package Day4
import readInput

fun main() {
    val lines = readInput("Day4", "Day4Test")
    val boards: MutableList<BingoBoard> = mutableListOf()
    var start: Int
    var end = Int.MIN_VALUE
    for (line in lines.indices) {
        if (line < end) {
            continue
        }
        if (lines[line] == "") {
            start = line + 1
            for (index in start..lines.lastIndex) {
                if (lines[index] == "" || index == lines.lastIndex) {
                    end = index - 1
                    boards.add(BingoBoard(lines.slice(start until end)))
                    break
                }
            }

        }
    }
    println(boards.size)
}