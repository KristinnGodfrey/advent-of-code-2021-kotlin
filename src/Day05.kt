import java.io.File


data class InputPointsString(val x: Pair<Int, Int>, val y: Pair<Int, Int>)

fun main() {
    fun create10x10Grid(input: List<InputPointsString>): Array<IntArray> {
        val mx = input.maxOf { l -> maxOf(l.x.first, l.x.second) }
        val my = input.maxOf { l -> maxOf(l.y.first, l.y.second) }
        val grid = Array(mx + 1) { IntArray(mx + 1) }
        for (i in input.indices) {
            val row = IntArray(10)
            for (j in row.indices) {
                row[j] = 0
            }
            grid[i] = row
        }
        return grid
    }

    fun part1(input: List<InputPointsString>): Int {
        val grid = create10x10Grid(input)

//        grid[5][5] = 5


        for (line in input) {
            val x1 = line.x.first
            val x2 = line.x.second
            val y1 = line.y.first
            val y2 = line.y.second
            println("x1: $x1, x2: $x2")
            println("y1: $y1, y2: $y2")

            if (x1 == y1) {
                println("up")
                for (i in minOf(y1, y2)..maxOf(y1, y2)) {
                    grid[x1][i]++
                }
            } else if (x2 == y2) {
                println("down")
                for (i in minOf(x1, x2)..maxOf(x1, x2)) {
                    grid[i][y1]++
                }
            } else {
                println("neither")
            }

            for (array in grid) {
                for (value in array) {
                    print(value)
                    print(" ")
                }
                println()
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
