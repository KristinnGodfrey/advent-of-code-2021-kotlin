import java.io.File
import kotlin.math.abs
import kotlin.math.ceil

fun main() {

    fun Int.likelyNumber(average: Int, max: Int?): Boolean {
        /* Relative to the average, remove the first quarter and last quarter of values.
         * Test input optimized by 50% using this. */
        return !((this < average / 2) or (this > (average + max!!) / 2))
    }

    fun Int.gaussTriangular(): Int {
        return ((this * (this + 1)) / 2)
    }

    fun solve(input: List<Int>, gaussTriangular: Boolean): Int {
        val average = ceil(input.average()).toInt()
        val max = input.maxOrNull()
        var minFuel = Int.MAX_VALUE

        for (i in 0..max!!) {
            if (i.likelyNumber(average, max)) {
                var fuel = 0
                if (gaussTriangular)
                    input.forEach { j -> fuel += abs(j - i).gaussTriangular() }
                else
                    input.forEach { j -> fuel += abs(j - i) }
                minFuel = minOf(minFuel, fuel)
            }
        }
        return minFuel
    }

    val input: List<Int> = File("src/resources/day7.txt")
        .readLines()[0]
        .split(",")
        .map { it.toInt() }

    println("Answer 1: ${solve(input, gaussTriangular = false)}")
    println("Answer 2: ${solve(input, gaussTriangular = true)}")
}
