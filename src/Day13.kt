import java.io.File

data class Pt(val x: Int, val y: Int)

class Day13(input: List<String>) {

    fun parsePoints(input: List<String>): String {
        return input[input.indexOf("") + 1]
    }

    fun parseInstructions(input: List<String>): Set<Pt> =
        input.takeWhile { it.isNotEmpty() }.map { it.split(",").map { it.toInt() }.let { (x, y) -> Pt(x, y) } }.toSet()

    fun parseFoldDirection(input: List<String>): String =
        input[input.indexOf("") + 1].split("=")[0].split(" ").last()

    fun parseFoldValue(input: List<String>): Int =
        input[input.indexOf("") + 1].split("=")[1].toInt()

    val foldDirectionMap = mapOf(
        "x" to "y",
        "y" to "x"
    )

    fun fold(input: Set<Pt>, foldDirection: String, foldValue: Int): Set<Pt> {
        return if (foldDirection == "x") input.filter { it.y < foldValue }.toSet()
        else input.filter { it.x < foldValue }.toSet()

        // input = filter
        // remainder = not in filter
        // 8 - 2
        // 9 - 4
        // 10 - 6

        // foldValue = 7, subtract= 0
        // y = 8 - (subtract), subtract = 2
        // y = 9 - (subtract), subtract = 4
        // y = 10 - (subtract), subtract = 6

        // not modulus then (foldvalue * 2) % foldvalue will be 0
        // (y - foldvalue) * 2
        // (8 - 7) * 2 = 2
        // (9 - 7) * 2 = 4
        // (14 - 7) * 2 = 14

    }
}

fun main() {
    val input = File("src/resources/day13.txt")
        .readLines()

    val d = Day13(input)
    val points = d.parsePoints(input)
    val instr = d.parseInstructions(input)
    val foldDirection = d.parseFoldDirection(input)
    val foldValue = d.parseFoldValue(input)

    println(foldDirection)
    println(foldValue)

    // initial:       [Pt(x=6, y=10), Pt(x=0, y=14), Pt(x=9, y=10), Pt(x=0, y=3), Pt(x=10, y=4), Pt(x=4, y=11), Pt(x=6, y=0), Pt(x=6, y=12), Pt(x=4, y=1), Pt(x=0, y=13), Pt(x=10, y=12), Pt(x=3, y=4), Pt(x=3, y=0), Pt(x=8, y=4), Pt(x=1, y=10), Pt(x=2, y=14), Pt(x=8, y=10), Pt(x=9, y=0)]
    // chunked(7)[0]: [Pt(x=6, y=10), Pt(x=0, y=14), Pt(x=9, y=10), Pt(x=0, y=3), Pt(x=10, y=4), Pt(x=4, y=11), Pt(x=6, y=0)]
    println(d.fold(instr, foldDirection, foldValue))

}
