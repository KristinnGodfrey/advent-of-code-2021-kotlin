import java.io.File

fun main() {

    fun part1(): Int {
        val input = File("src/resources/day12.txt")
            .readLines()
            .map { it.split("-") }

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

        fun smallCaveInList(current: List<String>, paths: MutableList<String>): Boolean {
            if (current[1] in smallCaves && current[1] in paths) {
                return true
            }
            return false
        }

        fun findPaths(current: List<String>, lastArg: List<String>, paths: MutableList<String>): MutableList<String> {
            var last = lastArg

            paths.add(current[1])
            println("current: $current")
            val nextList = input.filter { it[0] == current[1] }.toMutableList()
            while (nextList.isNotEmpty()) {
                val next = nextList.removeFirst()
                if (next[1] == "end") {
                    paths.add("end")
                } else if (!smallCaveInList(next, paths)) {
                    findPaths(next, current, paths)
                } else if (current[0] in bigCaves) {
                    println("lol")
                    findPaths(last, current, paths)
                }
            }
            println("---")
            return mutableListOf("")
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

