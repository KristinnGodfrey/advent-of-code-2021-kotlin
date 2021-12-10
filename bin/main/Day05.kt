import java.io.File

data class InputPoints(val x1: Int, val y1: Int, val x2: Int, val y2: Int)

fun main() {

    fun create10x10Grid(input: List<InputPoints>): Array<IntArray> {
        val rows = input.maxOf { l -> maxOf(l.x1, l.x2) }
        val columns = input.maxOf { l -> maxOf(l.y1, l.y2) }
        return Array(rows + 1) { IntArray(columns + 1) }
    }

    fun countHits(grid: Array<IntArray>): Int {
        var counter = 0
        for (array in grid) {
            for (value in array) {
                if (value > 1) {
                    counter++
                }
            }
        }
        return counter
    }

    fun incrementHorizontalAndVerticalGrid(input: List<InputPoints>, grid: Array<IntArray>): Array<IntArray> {
        for (i in input) {
            if (i.x1 == i.x2) {
                for (j in minOf(i.y1, i.y2)..maxOf(i.y1, i.y2)) {
                    grid[i.x1][j]++
                }
            } else if (i.y1 == i.y2) {
                for (j in minOf(i.x1, i.x2)..maxOf(i.x1, i.x2)) {
                    grid[j][i.y1]++
                }
            }
        }
        return grid
    }

    fun printGrid(grid: Array<IntArray>): Int {
        for (array in grid) {
            for (value in array) {
                print("$value ")
            }
            println()
        }
        return 0
    }
    
    fun part1(input: List<InputPoints>): Int {
        var grid = create10x10Grid(input)
        grid = incrementHorizontalAndVerticalGrid(input, grid)
        printGrid(grid)
        return countHits(grid)
    }

    fun part2(input: List<InputPoints>): Int {
        return 0
    }

    val input = File("src/resources/day5Tester.txt")
        .readLines()
        .map {
            val (left, right) = it.split(" -> ")
            val (x1, y1) = left.split(",").map { it.toInt() }
            val (x2, y2) = right.split(",").map { it.toInt() }
            InputPoints(x1, y1, x2, y2)
        }

    println("Answer 1: ${part1(input)}")
    println("Answer 2: ${part2(input)}")
}
