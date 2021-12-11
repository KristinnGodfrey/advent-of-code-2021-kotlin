import java.io.File

fun main() {

    val input = File("src/resources/day10.txt")
        .readLines()

    val putters: List<Char> = listOf('(', '[', '{', '<')
    val poppers: List<Char> = listOf(')', ']', '}', '>')

    val stack = ArrayDeque<Char>()
    var counter = 0
    for (line in input) {
        for (char in line) {
            if (char in putters) {
                stack.add(char)
            } else if (char in poppers) {
                val lastIndex = getLastIndex(stack, putters)
//                val currentIndex = getCurrentIndex(lastIndex, poppers)
                for (j in poppers.indices) {
                    if (char == poppers[j]) {
                        if (lastIndex == j) {
                            print("Char: ${stack.last()} --- ")
                            println("P: ${poppers[j]}")
                        } else {
                            print("Char: ${stack.last()} XXX ")
                            println("P: ${poppers[j]}")
                        }
                    }

                }
//                println("${stack.last()}: $lastIndex")
//                println("$char: $currentIndex")
//                println()
//                if (lastIndex == currentIndex)
            }

        }
        counter++
        println("iteration: $counter")
    }
    println(stack)
}

fun getLastIndex(stack: ArrayDeque<Char>, putters: List<Char>): Int {
    for (j in putters.indices) {
        if (stack.last() == putters[j]) {
            return j
        }
    }
    return 300
}

//fun getCurrentIndex(lastIndex: Int, poppers: List<Char>): Int {
//    for (j in poppers.indices) {
//        if (lastIndex == poppers[j]) {
//            return j
//        }
//    }
//    return 300
//}
