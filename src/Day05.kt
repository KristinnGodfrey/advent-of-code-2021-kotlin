import java.io.File


data class InputPointsString(val x1: Int, val y1: Int, val x2: Int, val y2: Int)

fun main() {

    fun create10x10Grid() {
        val mx = input.maxOf { l -> maxOf(l.x1, l.x2) }
        val my = input.maxOf { l -> maxOf(l.y1, l.y2) }
        val grid = Array(mx + 1) { IntArray(my + 1) }
    }

    fun part1(input: List<InputPointsString>): Int {


        for (l in input) {
//            println("x1: ${l.x1}, x2: ${l.x2}")
//            println("y1: ${l.y1}, y2: ${l.y2}")

            if (l.x1 == l.x2) {
                for (y in minOf(l.y1, l.y2)..maxOf(l.y1, l.y2)) {
                    grid[l.x1][y]++
                }
            } else if (l.y1 == l.y2) {
                for (x in minOf(l.x1, l.x2)..maxOf(l.x1, l.x2)) {
                    grid[x][l.y1]++
                }
            }
        }

        var counter = 0
        for (array in grid) {
            for (value in array) {
//                print(value)
//                print(" ")
                if (value > 1) {
                    counter++
                }
            }
//            println()
        }
        return counter


    }

    fun part2(input: List<InputPointsString>): Int {
        return 0
    }

    val input = File("src/resources/day5Tester.txt")
        .readLines()
        .map { l ->
            val s = l.split(" -> ")
            val (x1, y1) = s[0].split(",").map { it.toInt() }
            val (x2, y2) = s[1].split(",").map { it.toInt() }
            InputPointsString(x1, y1, x2, y2)
        }

    println("Answer 1: ${part1(input)}")
    println("Answer 2: ${part2(input)}")
}
