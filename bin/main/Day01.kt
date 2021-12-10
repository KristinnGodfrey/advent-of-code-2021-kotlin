fun main() {
    // 1-1
    fun twoMeasurements(input: List<Int>): Int {
        var counter = 0
        val inputWindowed = input.windowed(2)
        for (window in inputWindowed) {
            val windowIt = window.listIterator(1)
            if (windowIt.previous().let { windowIt.next() } < windowIt.next()) counter++
        }
        return counter
    }

    // 1-2
    fun threeMeasurements(input: List<Int>): Int {
        var counter = 0
        val inputWindowed = input.windowed(3)
        var oldWindow = Int.MAX_VALUE
        for (window in inputWindowed) {
            if (window.sum() > oldWindow) counter++
            oldWindow = window.sum()
        }
        return counter
    }

    // test if implementation meets criteria from the description, like:
    val testInput: List<Int> = readInput("resources/day1")
        .map(String::toInt)

    println("Answer 1: ${twoMeasurements(testInput)}")
    println("Answer 2: ${threeMeasurements(testInput)}")
}

