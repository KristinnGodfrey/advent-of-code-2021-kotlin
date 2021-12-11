import java.io.File

fun main() {

    val input = File("src/resources/day10.txt")
        .readLines()

    val putters: List<Char> = listOf('(', '[', '{', '<')
    val poppers: List<Char> = listOf(')', ']', '}', '>')
//
//    val points = mapOf(
//        ')' to 3,
//        ']' to 57,
//        '}' to 1197,
//        '>' to 25137
//    )

    val errorStack = mutableListOf<Char>()

    val stack = ArrayDeque<Char>()
    var counter = 0
    for (line in input) {
        for (char in line) {
            if (char in putters) {
                stack.add(char)
                println("Char: ${stack.last()}")
            } else if (char in poppers) {
                val lastIndex = getLastIndex(stack, putters)
                for (j in poppers.indices) {
                    if (char == poppers[j]) {
                        if (lastIndex == j) {
                            stack.removeLast()
                            errorStack.add(char)
                        } else {
                            break
                        }
                    }
                }
            }
        }
        counter++
        println("iteration: $counter")
        println("Stack: $stack")
//        stack.forEach { errorStack.add(it) }
        println("Errorstack $errorStack")
    }
    errorStack.forEach { println(it) }
    var points = 0
    errorStack.forEach {
        when (it) {
            ')' -> points += 37
            ']' -> points += 57
            '}' -> points += 1197
            '>' -> points += 25137
        }
    }
    println(points)
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
