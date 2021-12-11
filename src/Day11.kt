import java.io.File

fun main() {

    val input = File("src/resources/day11.txt")
        .readLines()
        .map { it.map { l -> l - '0' }.toMutableList() }.toMutableList()

    input.forEachIndexed { li, e ->
        println(input[e[0]])
        e.forEachIndexed { i, v ->
//            println(v)
        }
        println("")
    }


}
