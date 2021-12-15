import java.io.File

data class Pt(val x: Int, val y: Int)

class Day13 {
    fun parseInput(input: List<String>): Set<Pt> =
        input.takeWhile { it.isNotEmpty() }.map { it.split(",").map { it.toInt() }.let { (x, y) -> Pt(x, y) } }.toSet()

    fun parseFoldDirection(input: List<String>, parseIndex: Int = 1): String =
        input[input.indexOf("") + parseIndex].split("=")[0].split(" ").last()

    fun parseFoldValue(input: List<String>, parseIndex: Int = 1): Int =
        input[input.indexOf("") + parseIndex].split("=")[1].toInt()

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

    fun printSet(input: Set<Pt>) {
        for (y in 0..input.maxOf { it.y }) {
            for (x in 0..input.maxOf { it.x }) {
                print(if (Pt(x, y) in input) "#" else " ")
            }
            println()
        }
    }
}

fun main() {
    val d = Day13()

    fun part1(): Int {
        val input = File("src/resources/day13.txt").readLines()
        val filtered = d.parseInput(input)
        val foldDirection = d.parseFoldDirection(input)
        val foldValue = d.parseFoldValue(input)
        return d.fold(filtered, foldDirection, foldValue).size
    }

    fun part2() {
        val input = File("src/resources/day13.txt").readLines()
        var filtered = d.parseInput(input)
        var parseIndex = 1
        repeat(12) {
            val foldDirection = d.parseFoldDirection(input, parseIndex)
            val foldValue = d.parseFoldValue(input, parseIndex)
            parseIndex += 1
            filtered = d.fold(filtered, foldDirection, foldValue)
        }
        d.printSet(filtered)
        print2DGrid(filtered)
    }
    println("answer 1: ${part1()}")
    println("answer 2:").apply { part2() }
}



