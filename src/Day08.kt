import java.io.File

fun main() {
    val input = File("src/resources/day8.txt")
        .readLines()
        .map { it.split(" | ")[1].split(" ") }

    var counter = 0
    val uniqueSegments = listOf(2, 3, 4, 7)
    input.forEach { i ->
        println(i)
        i.forEach { j ->
            if (j.length in uniqueSegments) counter++
        }
    }
    println(counter)

//    println(input)
}

