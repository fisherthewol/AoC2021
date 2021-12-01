import java.io.File

// From https://github.com/kotlin-hands-on/advent-of-code-kotlin-template/blob/main/src/Utils.kt
fun readInput(name: String) = File("src/main/kotlin", "$name.txt").readLines()