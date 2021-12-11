import java.io.File

fun main() {

    val input = File("src/resources/day11.txt")
        .readLines()
        .map { it.map { l -> l - '0' }.toMutableList() }.toMutableList()

    input.forEachIndexed { li, e ->
        e.forEachIndexed { i, v ->
        }
    }

    println(input[0][3])

    repeat(100) {
        val flashStack = ArrayDeque<Pair<Int, Int>>()
        input.forEachIndexed { li, e ->
            e.forEachIndexed { i, v ->
                input[li][i] += v + 1
                if (input[li][i] == 10) {
                    flashStack.add(Pair(li, i))
                }
            }
        }

    }
    input.forEachIndexed { li, e ->
        println(e)
    }

}
