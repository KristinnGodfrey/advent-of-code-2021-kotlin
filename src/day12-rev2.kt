import java.io.File

/*
 * Copyright (c) 2021 by Todd Ginsberg
 */
class Day12(input: List<String>) {

    private val caves: Map<String, List<String>> = parseInput(input)

    fun solvePart1(): Int {
        return traverse(::part1VisitRule).size
    }

    fun solvePart2(): Int {
        return traverse(::part2VisitRule).size
    }

    private fun traverse(
        allowedToVisit: (String, List<String>) -> Boolean, path: List<String> = listOf("start")
    ): List<List<String>> {
        if (path.last() == "end") return listOf(path)
        else return caves.getValue(path.last())
            .filter { allowedToVisit(it, path) }
            .flatMap {
                traverse(allowedToVisit, path + it)
            }
    }


    private fun part1VisitRule(name: String, path: List<String>): Boolean {
        return name.isUpperCase() || name !in path
    }


    private fun part2VisitRule(name: String, path: List<String>): Boolean {
        return when {
            name.isUpperCase() -> true
            name == "start" -> false
            name !in path -> true
            else -> path
                .filterNot { it.isUpperCase() }
                .groupBy { it }
                .none { it.value.size == 2 }
        }
    }


    private fun String.isUpperCase(): Boolean {
        return all { it.isUpperCase() }
    }


    private fun parseInput(input: List<String>): Map<String, List<String>> {
        return input
            .map { it.split("-") }
            .flatMap {
                listOf(
                    it.first() to it.last(),
                    it.last() to it.first()
                )
            }
            .groupBy({ it.first }, { it.second })
    }

}

fun main() {
    val input = File("src/resources/day12.txt")
        .readLines()

    val d = Day12(input)
    println(d.solvePart1())
}




