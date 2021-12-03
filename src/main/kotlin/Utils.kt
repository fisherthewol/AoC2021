import java.io.File

// Modified from https://github.com/kotlin-hands-on/advent-of-code-kotlin-template/blob/c49b33e2ac11c87e96e902a2cc2afa31e4fc093d/src/Utils.kt
fun readInput(module: String, name: String) = File("src/main/kotlin/$module", "$name.txt").readLines()