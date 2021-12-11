import java.io.File

fun main() {

    val input = File("src/resources/day11.txt")
        .readLines()
        .map { it.map { l -> l - '0' }.toMutableList() }.toMutableList()

    input.forEachIndexed { li, e ->
        println(e)
    }

    println(input[0][1])

    repeat(100) {
        val flashStack = ArrayDeque<Pair<Int, Int>>()
        input.forEachIndexed { y, e ->
            e.forEachIndexed { x, v ->
                input[y][x] = v + 1
                if (input[y][x] == 10) {
                    flashStack.add(Pair(y, x))
                }
            }
        }

    }
    input.forEachIndexed { li, e ->
        println(e)
    }

}
