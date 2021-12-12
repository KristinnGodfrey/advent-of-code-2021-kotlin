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

        fun findPaths(current: List<String>, paths: MutableList<String>): Int {
//            println("current: ${current[1]}")
//            input.forEach { println("IT: ${it[1]}") }

            println("---")
            val next = input.filter { it[0] == current[1] }
            print("current: $current, ")
            print("next: $next, ")
            println("---")

//            paths.add(next)
//            findPaths(next, paths)

//            println(paths)
//
//            // check these paths
//            filter.forEach {
//                paths.add(it[1])
//            }
//            paths.forEachIndexed { i, j ->
//
//            }
            return 0
        }

        input.forEachIndexed { i, j ->
            val paths = mutableListOf<String>()
            findPaths(j, paths)
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

