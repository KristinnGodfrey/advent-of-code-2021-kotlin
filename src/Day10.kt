import java.io.File

fun main() {


    val inputStringBuilder = StringBuilder()
    File("src/resources/day10.txt")
        .readLines()
        .forEach { i -> inputStringBuilder.append("$i ") }

    val inputString = inputStringBuilder
        .trim()
        .split(" ")

//    val input = inputString
//        .trim()
//        .split(" ")
////        .map { it.single() }

    println(inputString)

//
//    val charArray: List<List<Char>> =
//        listOf(input.map { it. })

//    println(charArray[0])

//    val inputChar: List<Char> = input
//        .forEach { it.forEach { l -> l.toChar() } }

    val putters: List<Char> = listOf('(', '[', '{', '<')
    val poppers: List<Char> = listOf(')', ']', '}', '<')
    val stack = ArrayDeque<Char>()

//    for (i in input) {
//        var counter = 0
//        if (i in putters) {
//            stack.add(i)
//        } else if (i in poppers) {
//            val lastIndex = getLastIndex(stack, putters)
//            val currentIndex = getCurrentIndex(stack, poppers)
//            println("${stack.last()}: $lastIndex")
//            println("$i: $currentIndex")
//            println()
//        }
//        counter++
//        println("iteration: $counter")
//    }
//    println(stack)
}

fun getLastIndex(stack: ArrayDeque<Char>, putters: List<Char>): Int {
    for (j in putters.indices) {
        if (stack.last() == putters[j]) {
            return j
        }
    }
    return 300
}

fun getCurrentIndex(stack: ArrayDeque<Char>, poppers: List<Char>): Int {
    for (j in poppers.indices) {
        if (stack.last() == poppers[j]) {
            return j
        }
    }
    return 300
}
