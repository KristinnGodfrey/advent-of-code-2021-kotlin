import java.io.File

fun main() {
    val flashStack = ArrayDeque<Pair<Int, Int>>()
    val hasFlashed = ArrayDeque<Pair<Int, Int>>()

    fun checkState(y: Int, x: Int, input: MutableList<MutableList<Int>>) {
        if (input[y][x] == 10) {
            if (Pair(y, x) !in hasFlashed) {
                flashStack.add(Pair(y, x))
            }
        }
    }

    fun flash(pos: Pair<Int, Int>, flashCounter: Int, input: MutableList<MutableList<Int>>): Int {
        var fc = flashCounter
        fc++
        val y = pos.first
        val x = pos.second

        //left
        try {
            input[y][x - 1] += 1
            checkState(y, x - 1, input)
        } catch (e: Exception) {
        }
        // right
        try {
            input[y][x + 1] += 1
            checkState(y, x + 1, input)
        } catch (e: Exception) {
        }
        // top
        try {
            input[y - 1][x] += 1
            checkState(y - 1, x, input)
        } catch (e: Exception) {
        }
        //down
        try {
            input[y + 1][x] += 1
            checkState(y + 1, x, input)
        } catch (e: Exception) {
        }
        //topleft
        try {
            input[y - 1][x - 1] += 1
            checkState(y - 1, x - 1, input)
        } catch (e: Exception) {
        }
        //topright
        try {
            input[y - 1][x + 1] += 1
            checkState(y - 1, x + 1, input)
        } catch (e: Exception) {
        }
        //downleft
        try {
            input[y + 1][x - 1] += 1
            checkState(y + 1, x - 1, input)
        } catch (e: Exception) {
        }
        //downright
        try {
            input[y + 1][x + 1] += 1
            checkState(y + 1, x + 1, input)
        } catch (e: Exception) {
        }
        return fc
    }

    fun part1(): Int {
        val input = File("src/resources/day11.txt")
            .readLines()
            .map { it.map { l -> l - '0' }.toMutableList() }.toMutableList()
        flashStack.clear()
        hasFlashed.clear()

        var flashCounter = 0

        repeat(100) {
            hasFlashed.clear()

            input.forEachIndexed { y, e ->
                e.forEachIndexed { x, v ->
                    input[y][x] += 1
                    checkState(y, x, input)
                }
            }

            while (flashStack.isNotEmpty()) {
                val pos = flashStack.removeFirst()
                hasFlashed.add(pos)
                flashCounter = flash(pos, flashCounter, input)
            }

            hasFlashed.forEachIndexed { i, e ->
                input[e.first][e.second] = 0
            }
        }
        return flashCounter
    }

    fun part2(): Int {
        val input = File("src/resources/day11.txt")
            .readLines()
            .map { it.map { l -> l - '0' }.toMutableList() }.toMutableList()
        flashStack.clear()
        hasFlashed.clear()

        var flag = true
        var counter = 0
        var flashCounter = 0

        while (flag) {
            counter++
            hasFlashed.clear()

            input.forEachIndexed { y, e ->
                e.forEachIndexed { x, v ->
                    input[y][x] += 1
                    checkState(y, x, input)
                }
            }

            while (flashStack.isNotEmpty()) {
                if (hasFlashed.size == 99) flag = false
                val pos = flashStack.removeFirst()
                hasFlashed.add(pos)
                flash(pos, flashCounter, input)
            }

            hasFlashed.forEachIndexed { i, e ->
                input[e.first][e.second] = 0
            }
        }
        return counter
    }

    println("Answer 1: ${part1()}")
    println("Answer 2: ${part2()}")

}



