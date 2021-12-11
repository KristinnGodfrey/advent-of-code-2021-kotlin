import java.io.File

fun main() {

    val input = File("src/resources/day10.txt")
        .readLines()

    val putters: List<Char> = listOf('(', '[', '{', '<')
    val poppers: List<Char> = listOf(')', ']', '}', '>')

    val errorStack = mutableListOf<Char>()

    val mapping = mapOf(
        '(' to ')',
        '[' to ']',
        '{' to '}',
        '<' to '>'
    )

    val stack = ArrayDeque<Char>()
    val tmpStack = ArrayDeque<Char>()
    val remainderStack: MutableList<MutableList<Char>> = mutableListOf()
    var counter = 0
    for (line in input) {
        var corrupt = false
        tmpStack.clear()
        myloop@ for (char in line) {
            if (char in putters) {
                tmpStack.add(char)
                stack.add(char)
//                print("${stack.last()} ")
            } else if (char in poppers) {
                val lastIndex = getLastIndex(stack, putters)
                for (j in poppers.indices) {
                    if (char == poppers[j]) {
                        if (lastIndex == j) {
                            tmpStack.removeLast()
                            stack.removeLast()
//                            print("Char: $char ")
                        } else {
                            corrupt = true
                            tmpStack.clear()
                            errorStack.add(char)
//                            print("Char: $char ")
//                            print("BROKEN --- Expected ${stack.last()} but found $char instead. ")
                            break@myloop
                        }
                    }
                }
            }
        }
        if (!corrupt) {
            var tmpList = mutableListOf<Char>()
            tmpStack.reversed().forEach {
                if (it in mapping.keys) {
                    tmpList.add(mapping.getValue(it))
                }
            }
            remainderStack.add(tmpList)
        }
        counter++
//        println("iteration: $counter")
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


//    println("Errorstack $errorStack")
    println("Answer 1: $points")


    //part 2
//    println(stack)

//    remainderStack.forEach { println(it) }

    val scoreMapping = mapOf(
        ')' to 1,
        ']' to 2,
        '}' to 3,
        '>' to 4
    )

    val listOfScores: MutableList<Long> = mutableListOf()
    val testList = listOf(
        listOf('}', '}', ']', ']', ')', '}', ')', ']'),
        listOf(')', '}', '>', ']', '}', ')')
    )
    remainderStack.forEach { line ->
        var finalScore: Long = 0
        line.forEach { i ->
            finalScore = (finalScore * 5) + scoreMapping.getValue(i)
//            println("UNDER TEST: ${i}, FINAL SCORE: $finalScore")
        }
//        println(finalScore)
        listOfScores.add(finalScore)
    }

    val sortedList = listOfScores.sorted()
    println(sortedList[listOfScores.size / 2])
}

fun getLastIndex(stack: ArrayDeque<Char>, putters: List<Char>): Int {
    for (j in putters.indices) {
        if (stack.last() == putters[j]) {
            return j
        }
    }
    return 300
}
