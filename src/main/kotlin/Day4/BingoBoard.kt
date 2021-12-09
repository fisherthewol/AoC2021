package Day4

class BingoBoard(BoardString: List<String>) {
    private var board: List<List<Point>> = BoardString.map {
        it.trim().split("  ", " ").map {
            Point(it.toInt(), false)
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

        for (row in board) {
            if (row.all { it.called }) {
                return true
            }
        }
        for (index in 0 until board[0].size) {
            var total = 0
            for (row in board) {
                if (row[index].called) total++
            }
            if (total == board[0].size) {
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
                }
            }
        }
    }

    fun score(): Int {
        var sum = 0
        for (row in board) {
            for (point in row) {
                if (!point.called) {
                    sum += point.value
                }
            }
        }
        return sum
    }

    fun resetBoard() {
        board.forEach { row -> row.forEach { it.called = false } }
    }
}