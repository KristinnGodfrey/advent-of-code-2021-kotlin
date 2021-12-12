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

        fun findPaths(current: List<String>, paths: MutableList<String>): MutableList<String> {
//            println("current: ${current[1]}")
//            input.forEach { println("IT: ${it[1]}") }

//            paths.add(current[1])
            println(current)
            val next = input.filter { it[0] == current[1] }.toMutableList()
            while (next.isNotEmpty()) {
                val currentTmp = next.removeFirst()
                if (findPaths(currentTmp, paths).isEmpty()) {
                    println("current: $currentTmp, is empty")
                    return paths
                } else {
                    findPaths(currentTmp, paths)
                }
            }
            return paths
        }

        input.forEachIndexed { i, j ->
            val paths = mutableListOf<String>()
            val ans = findPaths(j, paths)
            println(ans)
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

