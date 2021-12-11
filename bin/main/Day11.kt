import java.io.File

fun main() {

    val input = File("src/resources/day11.txt")
        .readLines()
        .map { it.map { l -> l - '0' }.toIntArray() }
    println(input)
    println(input[0])
    for (i in input[0].indices) {
        println(input[0][i])
    }
}
