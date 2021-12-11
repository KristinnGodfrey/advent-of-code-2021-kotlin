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

    repeat(100) {

        val flashStack = ArrayDeque<Pair<Int, Int>>()
        val hasFlashed = ArrayDeque<Pair<Int, Int>>()
        hasFlashed.clear()

        fun checkState(y: Int, x: Int) {
            if (input[y][x] >= 10) {
                if (Pair(y, x) !in hasFlashed) {
                    flashStack.add(Pair(y, x))
                }
//                } else {
////                    println("PAIR ($y, $x) in hasFlashed")
//                }
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
//            println("FLASH: (${y}, ${x})")

            //left
            try {
//                if (Pair(y, x - 1) !in hasFlashed) {
                input[y][x - 1] += 1
                checkState(y, x - 1)
//                }
            } catch (e: Exception) {
            }
            // right
            try {
//                if (Pair(y, x + 1) !in hasFlashed) {
                input[y][x + 1] += 1
                checkState(y, x + 1)
//                }
            } catch (e: Exception) {
            }
            // top
            try {
//                if (Pair(y - 1, x) !in hasFlashed) {
                input[y - 1][x] += 1
                checkState(y - 1, x)
//                }
            } catch (e: Exception) {
            }
            //down
            try {
//                if (Pair(y + 1, x) !in hasFlashed) {
                input[y + 1][x] += 1
                checkState(y + 1, x)
//                }
            } catch (e: Exception) {
            }
            //topleft
            try {
//                if (Pair(y - 1, x - 1) !in hasFlashed) {
                input[y - 1][x - 1] += 1
                checkState(y - 1, x - 1)
//                }

            } catch (e: Exception) {
            }
            //topright
            try {
//                if (Pair(y - 1, x + 1) !in hasFlashed) {
                input[y - 1][x + 1] += 1
                checkState(y - 1, x + 1)
//                }

            } catch (e: Exception) {
            }
            //downleft
            try {
//                if (Pair(y + 1, x - 1) !in hasFlashed) {
                input[y + 1][x - 1] += 1
                checkState(y + 1, x - 1)
//                }

            } catch (e: Exception) {
            }
            //downright
            try {
//                if (Pair(y + 1, x + 1) !in hasFlashed) {
                input[y + 1][x + 1] += 1
                checkState(y + 1, x + 1)
//                }
            } catch (e: Exception) {
            }
        }

        while (flashStack.isNotEmpty()) {
            val pos = flashStack.removeFirst()
            hasFlashed.add(pos)
            if (pos !in hasFlashed) {
                flash(pos)
            }
        }

        hasFlashed.forEachIndexed { i, e ->
            val y = e.first
            val x = e.second
            input[y][x] = 0
        }

        input.forEachIndexed { li, e ->
            println(e)
        }
        println("---")
    }
//    input.forEachIndexed { li, e ->
//        println(e)
//    }
    println("flashcounter: $flashCounter")

}



