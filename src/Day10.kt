import java.io.File

fun main() {

    val input = File("src/resources/day10.txt")
        .readLines()

    val putters: List<Char> = listOf('(', '[', '{', '<')
    val poppers: List<Char> = listOf(')', ']', '}', '>')

    val errorStack = mutableListOf<Char>()

    val stack = ArrayDeque<Char>()
    val remainderStack: MutableList<MutableList<Char>> = mutableListOf()
    var counter = 0
    for (line in input) {
        myloop@ for (char in line) {
            if (char in putters) {
                stack.add(char)
                print("${stack.last()} ")
            } else if (char in poppers) {
                val lastIndex = getLastIndex(stack, putters)
                for (j in poppers.indices) {
                    if (char == poppers[j]) {
                        if (lastIndex == j) {
                            stack.removeLast()
                            print("Char: $char ")
                        } else {
                            errorStack.add(char)
                            print("Char: $char ")
                            print("BROKEN --- Expected ${stack.last()} but found $char instead. ")
                            break@myloop
                        }
                    }
                }
            }
        }
        counter++
        println("iteration: $counter")
    }
    var points = 0;
    var par = 0;
    var brace = 0;
    var curl = 0;
    var greater = 0
    errorStack.forEach {
        when (it) {
            ')' -> par++
            ']' -> brace++
            '}' -> curl++
            '>' -> greater++
        }
    }
    points += par * 3
    points += brace * 57
    points += curl * 1197
    points += greater * 25137


    println("Errorstack $errorStack")
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
