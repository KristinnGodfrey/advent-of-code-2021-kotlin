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
    val scoreMapping = mapOf(
        ')' to 1,
        ']' to 2,
        '}' to 3,
        '>' to 4
    )

    val stack = ArrayDeque<Char>()
    val remainderStack: MutableList<MutableList<Char>> = mutableListOf()
    for (line in input) {
        var corrupt = false
        stack.clear()
        myloop@ for (char in line) {
            if (char in putters) {
                stack.add(char)
            } else if (char in poppers) {
                val lastIndex = getLastIndex(stack, putters)
                for (j in poppers.indices) {
                    if (char == poppers[j]) {
                        if (lastIndex == j) {
                            stack.removeLast()
                        } else {
                            corrupt = true
                            errorStack.add(char)
                            stack.add(char)
                            break@myloop
                        }
                    }
                }
            }
        }
        if (!corrupt) {
            var tmpList = mutableListOf<Char>()
            stack.reversed().forEach {
                if (it in mapping.keys) {
                    tmpList.add(mapping.getValue(it))
                }
            }
            remainderStack.add(tmpList)
        }
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

    println("Answer 1: $points")

    val listOfScores: MutableList<Long> = mutableListOf()
    remainderStack.forEach { line ->
        var finalScore: Long = 0
        line.forEach { i ->
            finalScore = (finalScore * 5) + scoreMapping.getValue(i)
        }
        listOfScores.add(finalScore)
    }

    val sortedList = listOfScores.sorted()
    println("Answer 2: ${sortedList[listOfScores.size / 2]}")
}

fun getLastIndex(stack: ArrayDeque<Char>, putters: List<Char>): Int {
    for (j in putters.indices) {
        if (stack.last() == putters[j]) {
            return j
        }
    }
    return 300
}
