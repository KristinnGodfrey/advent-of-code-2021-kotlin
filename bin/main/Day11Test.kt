import java.io.File

fun main() {

    val input = File("src/resources/day11.txt")
        .readLines()
        .map { it.map { l -> l - '0' }.toMutableList() }.toMutableList()

    var flashCounter = 0

    input.forEachIndexed { li, e ->
        println(e)
    }
    println("---")
    val y = 0
    val x = 9
    val current = input[y][x]
    println("Current: ${current}")

    //left
    try {
        println("Left ${input[y][x - 1]}")
    } catch (e: Exception) {
    }
    // right
    try {
        println("Right: ${input[y][x + 1]}")
    } catch (e: Exception) {
    }
    // top
    try {
        println("Top: ${input[y - 1][x]}")
    } catch (e: Exception) {
    }
    //down
    try {
        println("Down: ${input[y + 1][x]}")
    } catch (e: Exception) {
    }
    //topleft
    try {
        println("Topleft: ${input[y - 1][x - 1]}")
    } catch (e: Exception) {
    }
    //topright
    try {
        println("Topright: ${input[y - 1][x + 1]}")
    } catch (e: Exception) {
    }
    //downleft
    try {
        println("Downleft ${input[y + 1][x - 1]}")
    } catch (e: Exception) {
    }
    //downright
    try {
        println("Downright: ${input[y + 1][x + 1]}")
    } catch (e: Exception) {
    }


}


