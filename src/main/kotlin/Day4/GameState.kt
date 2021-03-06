package Day4

class GameState(lines: List<String>) {
    private val plays: List<Int> = lines[0].split(',').map { it.toInt() }
    private val boards: MutableList<BingoBoard> = mutableListOf()

    init {
        var start: Int
        var end = Int.MIN_VALUE
        for (line in lines.indices) {
            if (line < end) {
                continue
            }
            if (lines[line] == "") {
                start = line + 1
                for (index in start..lines.lastIndex) {
                    if (lines[index] == "") {
                        end = index
                        boards.add(BingoBoard(lines.slice(start until end)))
                        break
                    } else if (index == lines.lastIndex) {
                        end = index
                        boards.add(BingoBoard(lines.slice(start..end)))
                    }
                }
            }
        }
    }

    fun resetGame() {
        boards.forEach { it.resetBoard() }
    }

    fun playGame(): Int{
        var latest: Int
        for (play in plays) {
            latest = play
            for (board in boards) {
                board.playNum(play)
            }
            for (board in boards) {
                if (board.checkForWin()) {
                    return board.score * latest
                }
            }
        }
        return -1
    }

    fun findLastWinning(): Int {
        val removed = mutableListOf<BingoBoard>()
        var latest: Int
        for (play in plays) {
            latest = play
            for (board in boards) {
                board.playNum(play)
            }
            for (b in boards.indices) {
                if (boards[b].checkForWin()) {
                    if (boards[b] !in removed) removed.add(boards[b])
                    if (boards.none { it !in removed }) {
                        return boards[b].score * latest
                    }
                }
            }
        }
        return -1
    }
}