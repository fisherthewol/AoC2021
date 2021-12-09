package Day4
import readInput

fun main() {
    val lines = readInput("Day4", "Day4Test")
    val gameState = GameState(lines)
    println("${gameState.playGame()}")
    gameState.resetGame()
    println("${gameState.findLastWinning()}")
}