import java.io.File

data class InputPoints(val x: Int, val y: Int)
data class InputPointsString(val x: String, val y: String)

fun main() {
    fun create10x10Grid(): MutableList<Triple<Int, Int, Int>> {
        var listOfGridItems: MutableList<Triple<Int, Int, Int>> = mutableListOf()
        for (i in 0..9) {
            for (j in 0..9) {
                listOfGridItems.add(Triple(i, j, 0))
            }
        }
        return listOfGridItems
    }

    fun createInputPoints(input: List<InputPointsString>): MutableList<InputPoints> {
        val listOfInputPoints: MutableList<InputPoints> = mutableListOf()

        return listOfInputPoints
    }

    fun part1(input: List<InputPointsString>): Int {
        var grid = create10x10Grid()

        println(input)


//        val listOfInputPoints = createInputPoints(input)

        for (i in 0 until grid.size) {
            if (grid[i].first == 0 && grid[i].second == 0) {
                grid[i] = grid[i].copy(third = 3)
            }
        }

        return 0
    }

    fun part2(input: List<InputPointsString>): Int {
        return 0
    }

    val input = File("src/resources/day5Tester.txt")
        .readLines()
        .map {
            val (left, right) = it.split("-> ")
            InputPointsString(left, right)
        }

    println("Answer 1: ${part1(input)}")
    println("Answer 2: ${part2(input)}")
}
