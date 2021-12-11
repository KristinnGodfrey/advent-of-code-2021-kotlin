import java.io.File

fun main() {

    fun create10x10Grid(input: List<InputPoints>): Array<IntArray> {
        val rows = input.maxOf { l -> maxOf(l.x1, l.x2) }
        val columns = input.maxOf { l -> maxOf(l.y1, l.y2) }
        return Array(rows + 1) { IntArray(columns + 1) }
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

    val inputString = StringBuilder()
    val tmp = File("src/resources/day9.txt")
        .readLines()
        .forEach { i -> inputString.append(":$i") }
//    println(inputString)

    val listOfListOfInts: Array<IntArray> = arrayOf()
    val input = inputString
        .replace(".".toRegex(), "$0 ") // inputString with spaces
        .replace(" : ", ": ")
        .trim()
        .split(": ")

    // : 2 1 9 9 9 4 3 2 1 0: 3 9 8 7 8 9 4 9 2 1: 9 8 5 6 7 8 9 8 9 2: 8 7 6 7 8 9 6 7 8 9: 9 8 9 9 9 6 5 6 7 8

    println(input)
//    val (left, right) = input.toString().split(": ")
//    println(right)

    val inputSliced = input
        .slice(1 until input.size)

//    println(input)
////        .trim()
//        .split(" ")
//        .map { it.toInt() }

//
//    val grid: Array<IntArray> = arrayOf(input.toIntArray())
//
//    printGrid(grid)
}
