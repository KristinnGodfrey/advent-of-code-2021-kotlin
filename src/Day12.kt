import java.io.File

fun main() {

    fun part1(): Int {
        val input = File("src/resources/day12.txt")
            .readLines()
            .map { it.split("-") }

//        println(input)

        val smallCaves: MutableList<String> = mutableListOf()
        val bigCaves: MutableList<String> = mutableListOf()

        input.forEach {
            it.forEach { l ->
                l.map { k ->
                    if (l != "start" && l != "end") {
                        if (k.isLowerCase() && l !in smallCaves) {
                            smallCaves.add(l)
                        }
                        if (k.isUpperCase() && l !in bigCaves) {
                            bigCaves.add(l)
                        }
                    }
                }
            }
        }

//        val distinct = input.toSet().toList()
//        println("distinct $distinct")

//        println(smallCaves)
//        println(bigCaves)

        val path: MutableList<String> = mutableListOf()

        fun findPaths(current: String): List<String> {
            val paths = mutableListOf<String>()

            val filter = input.filter { it[0] == current }

            // check these paths
            filter.forEach {
                paths.add(it[1])
            }
            paths.forEachIndexed { i, j ->
                
            }
            return paths
        }

        input.forEachIndexed { i, j ->
            println(findPaths(j[0]))
        }


//        println(input[1][1].isLowerCase())

        return 0
    }

    fun part2(): Int {
        return 0
    }

    println("Answer 1: ${part1()}")
    println("Answer 2: ${part2()}")
}

