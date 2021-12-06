import java.io.File


fun solve1() {
    var input: MutableList<Int> = File("src/resources/day6.txt")
        .readLines()[0]
        .split(",")
        .map { it.toInt() } as MutableList<Int>

    val fishArray = LongArray(9)

    input.map {
        fishArray[it] = fishArray[it] + 1
    }

    for (day in 0 until 256) {
        val count8s = fishArray[0]

        for (i in 1 until fishArray.size) {
            fishArray[i - 1] = fishArray[i]
        }
        fishArray[fishArray.size - 1] = 0

        fishArray[6] += count8s
        fishArray[8] += count8s
    }

    println(fishArray.sum())
}

fun main() {
    solve1()
}
