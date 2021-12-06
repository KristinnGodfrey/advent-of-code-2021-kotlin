import java.io.File

fun insertionsort(items: MutableList<Int>): MutableList<Int> {
    if (items.isEmpty() || items.size < 2) {
        return items
    }
    for (count in 1..items.count() - 1) {
        // println(items)
        val item = items[count]
        var i = count
        while (i > 0 && item < items[i - 1]) {
            items[i] = items[i - 1]
            i -= 1
        }
        items[i] = item
    }
    return items
}

fun grow(n: Int): List<Int> =
    if (n == 0) {
        listOf(6, 8)
    } else {
        listOf(n - 1)
    }

fun main() {
    fun part1(input: MutableList<Int>): Int {
        var l_input = insertionsort(input)
        var listOfOnes: List<Int> = listOf()
        var listOfTwos: List<Int> = listOf()
        var listOfThrees: List<Int> = listOf()
        var listOfFours: List<Int> = listOf()
        var listOfFives: List<Int> = listOf()
        var listOfSixes: List<Int> = listOf()
        println(l_input)
        for (i in 0 until 5) {
            for (j in 0 until l_input.size)
                if (l_input[j] == 0) {
                    l_input[j] = 6 + 1
                    l_input.add(8 + 1)
                }
            l_input = l_input.map { it - 1 } as MutableList<Int>
            println(l_input)

        }
        return l_input.size
    }

    var input: MutableList<Int> = File("src/resources/day6.txt")
        .readLines()[0]
        .split(",")
        .map { it.toInt() } as MutableList<Int>

    // read file and convert to list of ints


    // println(input)
    // println(input[0] + input[1])
    println("Answer 1: ${part1(input)}")
}
