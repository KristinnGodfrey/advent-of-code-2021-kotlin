import java.io.File

fun main() {
    fun part1(input: MutableList<Int>): Int {
        var mutableInput = input
        for (i in 0 until 80) {
            for (j in 0 until mutableInput.size) {
                if (mutableInput[j] == 0) {
                    mutableInput[j] = 6 + 1
                    mutableInput.add(8 + 1)
                }
            }
            mutableInput = mutableInput.map { it - 1 } as MutableList<Int>
        }
        return mutableInput.size
    }

    fun part2(input: MutableList<Int>): Long {
        val fishArray = LongArray(9)

        input.forEach { l -> fishArray[l] = fishArray[l] + 1 }

        for (i in 0 until 256) {
            val depletedFishes = fishArray[0]

            for (j in 1 until fishArray.size) {
                fishArray[j - 1] = fishArray[j]
            }
            fishArray[6] += depletedFishes
            fishArray[8] = depletedFishes
        }

        return fishArray.sum()
    }

    val input: MutableList<Int> = File("src/resources/day6.txt")
        .readLines()[0]
        .split(",")
        .map { it.toInt() } as MutableList<Int>

    println("Answer 1: ${part1(input)}")
    println("Answer 2: ${part2(input)}")
}
