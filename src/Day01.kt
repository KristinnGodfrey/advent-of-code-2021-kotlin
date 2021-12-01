fun main() {
    fun part1(input: List<Int>): Int {
        var counter = 1
        for (i in 1 until input.size) {
            if (input[i] > input[i - 1]) {
                counter++
            }
        }
        return counter
    }

    fun part2(input: List<Int>): Int {
        var counter = 1
        var oldSum: Int = input[0] + input[1] + input[2]
        for (i in 1 until (input.size - 3)) {
            val newSum: Int = input[i] + input[i + 1] + input[i + 2]
            if (newSum > oldSum) {
                counter++
            }
            oldSum = newSum
        }
        return counter
    }

    // test if implementation meets criteria from the description, like:
    val testInput: List<Int> = readInput("resources/day1")
        .map(String::toInt)


    // iterate through testInput
    println("Answer 1: ${part1(testInput)}")
    println("Answer 2: ${part2(testInput)}")

//    val input = readInput("Day01")
//    println(part1(input))
//    println(part2(input))
}
