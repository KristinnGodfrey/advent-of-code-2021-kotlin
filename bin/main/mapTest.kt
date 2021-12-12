import java.io.File

fun main() {
    val input = File("src/resources/day11.txt")
        .readLines()
    println(input)

    val input2 = input
        .map { it.map { l -> l - '0' } }
    println(input2)


}
