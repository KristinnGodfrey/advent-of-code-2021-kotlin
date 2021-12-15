import java.io.File

data class Pt(val x: Int, val y: Int)

class Day13 {
    fun parseInput(input: List<String>): Set<Pt> =
        input.takeWhile { it.isNotEmpty() }.map { it.split(",").map { it.toInt() }.let { (x, y) -> Pt(x, y) } }.toSet()

    fun parseFoldDirection(input: List<String>): List<String> {
        val listOfFoldDirections = mutableListOf<String>()
        var counter = 1
        repeat(12) {
            listOfFoldDirections.add(input[input.indexOf("") + counter].split("=")[0].split(" ").last())
            counter += 1
        }

        return listOfFoldDirections
    }

    fun parseFoldValue(input: List<String>): List<Int> {
        val listOfFoldValues = mutableListOf<Int>()
        var counter = 1
        repeat(12) {
            listOfFoldValues.add(input[input.indexOf("") + counter].split("=")[1].toInt())
            counter += 1
        }
        return listOfFoldValues
    }

    fun fold(input: Set<Pt>, foldDirection: List<String>, foldValue: List<Int>): MutableSet<Pt> {

        foldDirection.forEachIndexed { i, v ->
            val (filtered, remainder) = input
                .partition { if (foldDirection[i] == "x") it.x < foldValue[i] else it.y < foldValue[i] }
                .toList().map { it.toMutableSet() }

            remainder.forEach {
                if (foldDirection[i] == "y") filtered.add(Pt(it.x, (it.y - ((it.y - foldValue[i]) * 2))))
                else filtered.add(Pt(it.x - ((it.x - foldValue[i]) * 2), it.y))
            }
        }

        return filtered
    }
}

fun main() {
    val input = File("src/resources/day13.txt")
        .readLines()

    val d = Day13()
    val parsedInput = d.parseInput(input)
    val foldDirection = d.parseFoldDirection(input)
    val foldValue = d.parseFoldValue(input)

    println(d.fold(parsedInput, foldDirection, foldValue).size)
}

