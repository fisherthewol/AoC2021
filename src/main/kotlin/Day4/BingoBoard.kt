package Day4

class BingoBoard(BoardString: List<String>) {
    var board: List<List<Point>> = BoardString.map {
        it.trim().split("  ", " ").map {
            Point(it.toInt(), false)
        }
    }
}