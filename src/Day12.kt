import java.io.File

fun main() {

    fun part1(): Int {
        val input = File("src/resources/day12.txt")
            .readLines()
            .map { it.split("-") }

        val smallCaves: MutableList<String> = mutableListOf()
        val bigCaves: MutableList<String> = mutableListOf()
        val startPoints: MutableList<List<String>> = mutableListOf()

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
                if (it[0] == "start") {
                    if (it !in startPoints) {
                        startPoints.add(it)
                    }
                }
            }
        }

        fun canVisit(current: String, paths: MutableList<String>): Boolean {
            return (current in bigCaves || current !in paths)
        }


        fun findPaths(current: String, lastArg: String, paths: MutableList<String>): MutableList<String> {
            var last = lastArg
//            println("last: $last")
            println("current: $current")
            paths.add(last)
            val nextList = input.filter { it[0] == current }.toMutableList()
            while (nextList.isNotEmpty()) {
                val next = nextList.removeFirst()[1] // before slice: [A,c] [A,b] [A,end] [] [b,d] [b,end] []
                val nextNotEmpty = findPaths(next, last, paths).isNotEmpty()
                if (next == "end") {
                    paths.add(next)
                    println("End")
                } else if (canVisit(next, paths)) {
                    findPaths(next, current, paths)
                } else if (canVisit(last, paths)) {
                    findPaths(last, current, paths)
                }
            }

            println("---")
            return paths
        }

        var ans = mutableListOf<String>()
        startPoints.forEachIndexed { i, j ->
            val paths = mutableListOf<String>()
            println("current: start")
            println(findPaths(j[1], "start", paths))
        }
//        println("ANS $ans")


//        println(input[1][1].isLowerCase())

        return 0
    }

    fun part2(): Int {
        return 0
    }
    part1()
    part2()
//    println("Answer 1: ${part1()}")
//    println("Answer 2: ${part2()}")
}


