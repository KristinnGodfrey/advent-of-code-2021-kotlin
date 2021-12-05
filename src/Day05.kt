import java.io.File

data class InputPointsString(val x: Pair<Int, Int>, val y: Pair<Int, Int>)

fun main() {
    fun create10x10Grid(): MutableList<List<Int>> {
        val grid = mutableListOf<List<Int>>()
        for (i in 0..9) {
            for (j in 0..9) {
                grid.add(listOf(i, j, 0))
            }
        }
        return grid
    }

    fun part1(input: List<InputPointsString>): Int {
        val grid = create10x10Grid()
        for (array in grid) {
            print(array)
            for (value in grid) {

            }
            println()
        }

        for (line in input) {
            val xFirst = line.x.first
            val yFirst = line.y.first
            val xSecond = line.x.second
            val ySecond = line.y.second
            println(
                "xFirst: $xFirst, xSecond: $xSecond \nyFirst: $yFirst, xSecond: $ySecond"
            )

            if (xFirst > xSecond) {
                println("WASUP")
                for (i in xSecond..xFirst) {
//                    grid[i][y]
                    println(i)
                }

            } else if (xFirst > xSecond) {

            } else if (xSecond > xSecond) {

            } else if (xSecond < xSecond) {

            }
            println()
        }
        return 0
    }

    fun part2(input: List<InputPointsString>): Int {
        return 0
    }

    val input = File("src/resources/day5Tester.txt")
        .readLines()
        .map {
            val (left, right) = it.split(" -> ")
            val (x, y) = left.split(",")
            val (z, t) = right.split(",")
            InputPointsString(Pair(x.toInt(), y.toInt()), Pair(z.toInt(), t.toInt()))
        }

    println("Answer 1: ${part1(input)}")
    println("Answer 2: ${part2(input)}")
}
