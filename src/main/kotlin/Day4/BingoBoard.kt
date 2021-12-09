package Day4

class BingoBoard(BoardString: List<String>) {
    private var board: List<List<Point>> = BoardString.map {
        it.trim().split("  ", " ").map {
            Point(it.toInt(), false)
        }
    }
    var score = board.sumOf {
        it.sumOf {
            it.value
        }
    }

    override fun toString(): String {
        var s = ""
        for (row in board) {
            for (point in row) {
                s += "${point.value},"
            }
            s += "\n"
        }
        return s
    }

    fun checkForWin(): Boolean {
        // Check rows.
        for (row in board) {
            if (row.all { it.called }) {
                return true
            }
        }
        // check columns
        for (index in 0 until board[0].size) {
            var total = 0
            board.forEach { if (it[index].called) total++ }
            if (total == board.size) {
                return true
            }
        }
        return false
    }

    fun playNum(num: Int) {
        for (row in board) {
            for (point in row) {
                if (point.value == num) {
                    point.called = true
                    score -= point.value
                    return
                }
            }
        }
    }

    fun resetBoard() {
        board.forEach { row -> row.forEach { it.called = false } }
        score = board.sumOf {
            it.sumOf {
                it.value
            }
        }
    }
}