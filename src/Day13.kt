import java.io.File

data class Pt(val x: Int, val y: Int)

class Day13 {
    fun parseInput(input: List<String>): Set<Pt> =
        input.takeWhile { it.isNotEmpty() }.map { it.split(",").map { it.toInt() }.let { (x, y) -> Pt(x, y) } }.toSet()

    fun parseFoldDirection(input: List<String>): String =
        input[input.indexOf("") + 1].split("=")[0].split(" ").last()

    fun parseFoldValue(input: List<String>): Int =
        input[input.indexOf("") + 1].split("=")[1].toInt()

    fun fold(input: Set<Pt>, foldDirection: String, foldValue: Int): MutableSet<Pt> {
        val (filtered, remainder) = input
            .partition { if (foldDirection == "x") it.x < foldValue else it.y < foldValue }
            .toList().map { it.toMutableSet() }

        remainder.forEach {
            if (foldDirection == "y") filtered.add(Pt(it.x, (it.y - ((it.y - foldValue) * 2))))
            else filtered.add(Pt(it.x - ((it.x - foldValue) * 2), it.y))
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

