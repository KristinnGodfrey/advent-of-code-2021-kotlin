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

        fun smallCaveInList(current: List<String>, paths: MutableList<String>): Boolean {
            if (current[1] in smallCaves && current[1] in paths) {
                return true
            }
            return false
        }

        fun findPaths(current: List<String>, lastArg: List<String>, paths: MutableList<String>): MutableList<String> {
            var last = lastArg
//            println("current: ${current[1]}")
//            input.forEach { println("IT: ${it[1]}") }

//            paths.add(current[1])
            paths.add(current[1])
            val nextList = input.filter { it[0] == current[1] }.toMutableList()
            var flag = false
            while (nextList.isNotEmpty()) {
                if (!flag) {
                    println(nextList)
                    flag = true
                }
                val next = nextList.removeFirst()
                println("last: $last")
                println("current: $current")
                println("next: $next")
                if (next[1] == "end") {
                    paths.add("end")
                } else if (!smallCaveInList(next, paths)) {
                    last = current
                    findPaths(next, current, paths)
                }
//                else if (current[1] in bigCaves) {
//                    println("lol")
//                    findPaths(next, last, paths)
//                }
            }
            println("---")
            return mutableListOf()
        }

        input.forEachIndexed { i, j ->
            val paths = mutableListOf<String>("start")
//            println(findPaths(j, paths))
            findPaths(j, listOf(""), paths)

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

