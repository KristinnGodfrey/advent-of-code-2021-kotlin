import java.io.File

fun main() {
    val input = File("src/resources/day11.txt")
        .readLines()
        .map { it.map { l -> l - '0' }.toMutableList() }.toMutableList()

    var flashCounter = 0

    repeat(100) {
        val flashStack = ArrayDeque<Pair<Int, Int>>()
        val hasFlashed = ArrayDeque<Pair<Int, Int>>()
        hasFlashed.clear()

        fun checkState(y: Int, x: Int) {
            if (input[y][x] == 10) {
                if (Pair(y, x) !in hasFlashed) {
                    flashStack.add(Pair(y, x))
                }
            }
        }

        input.forEachIndexed { y, e ->
            e.forEachIndexed { x, v ->
                input[y][x] += 1
                checkState(y, x)
            }
        }

        fun flash(pos: Pair<Int, Int>) {
            flashCounter++
            val y = pos.first
            val x = pos.second

            //left
            try {
                input[y][x - 1] += 1
                checkState(y, x - 1)
            } catch (e: Exception) {
            }
            // right
            try {
                input[y][x + 1] += 1
                checkState(y, x + 1)
            } catch (e: Exception) {
            }
            // top
            try {
                input[y - 1][x] += 1
                checkState(y - 1, x)
            } catch (e: Exception) {
            }
            //down
            try {
                input[y + 1][x] += 1
                checkState(y + 1, x)
            } catch (e: Exception) {
            }
            //topleft
            try {
                input[y - 1][x - 1] += 1
                checkState(y - 1, x - 1)
            } catch (e: Exception) {
            }
            //topright
            try {
                input[y - 1][x + 1] += 1
                checkState(y - 1, x + 1)
            } catch (e: Exception) {
            }
            //downleft
            try {
                input[y + 1][x - 1] += 1
                checkState(y + 1, x - 1)
            } catch (e: Exception) {
            }
            //downright
            try {
                input[y + 1][x + 1] += 1
                checkState(y + 1, x + 1)
            } catch (e: Exception) {
            }
        }

        while (flashStack.isNotEmpty()) {
            val pos = flashStack.removeFirst()
            hasFlashed.add(pos)
            flash(pos)
        }

        hasFlashed.forEachIndexed { i, e ->
            input[e.first][e.second] = 0
        }

        input.forEachIndexed { li, e ->
            println(e)
        }
        println("---")
    }
    println("flashcounter: $flashCounter")

}



