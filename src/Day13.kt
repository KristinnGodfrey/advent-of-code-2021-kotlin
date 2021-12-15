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
        foldSet(remainder, filtered, foldValue, foldDirection)
        return filtered
    }

    private fun foldSet(remainder: MutableSet<Pt>, filtered: MutableSet<Pt>, foldValue: Int, foldDirection: String) {
        remainder.forEach {
            if (foldDirection == "y") filtered.add(Pt(it.x, (it.y - ((it.y - foldValue) * 2))))
            else filtered.add(Pt(it.x - ((it.x - foldValue) * 2), it.y))
        }
    }
}

fun main() {
    val input = File("src/resources/day13.txt")
        .readLines()

    val d = Day13()
    val parsedInput = d.parseInput(input)
    println(parsedInput)
    val foldDirection = d.parseFoldDirection(input)
    val foldValue = d.parseFoldValue(input)

    // initial:       [Pt(x=6, y=10), Pt(x=0, y=14), Pt(x=9, y=10), Pt(x=0, y=3), Pt(x=10, y=4), Pt(x=4, y=11), Pt(x=6, y=0), Pt(x=6, y=12), Pt(x=4, y=1), Pt(x=0, y=13), Pt(x=10, y=12), Pt(x=3, y=4), Pt(x=3, y=0), Pt(x=8, y=4), Pt(x=1, y=10), Pt(x=2, y=14), Pt(x=8, y=10), Pt(x=9, y=0)]
    // chunked(7)[0]: [Pt(x=6, y=10), Pt(x=0, y=14), Pt(x=9, y=10), Pt(x=0, y=3), Pt(x=10, y=4), Pt(x=4, y=11), Pt(x=6, y=0)]
    println(d.fold(parsedInput, foldDirection, foldValue).size)
}

