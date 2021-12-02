fun main() {
    // 1-1
    fun twoMeasurements(input: List<Int>): Int {
        var counter = 0
        val inputWindowed = input.windowed(2)
        for (window in inputWindowed) {
            val inpIt = window.listIterator(1)
            if (inpIt.previous().let { inpIt.next() } < inpIt.next()) counter++
        }
        return counter
    }

    // 1-2
    fun threeMeasurements(input: List<Int>): Int {
        var counter = 0
        val inputWindowed = input.windowed(4)
        for (window in inputWindowed) {
            val inputIt = window.listIterator(3)
            val prev = inputIt.previous() + inputIt.previous() + inputIt.previous()
            inputIt.next().let { inputIt.next() }.let { inputIt.next() }.let { inputIt.next() }
            val current = inputIt.previous() + inputIt.previous() + inputIt.previous()
            inputIt.next().let { inputIt.next() }.let { inputIt.next() }
            if (current > prev) counter++
        }
        return counter
    }

    // test if implementation meets criteria from the description, like:
    val testInput: List<Int> = readInput("resources/day1")
        .map(String::toInt)

    println("Answer 1: ${twoMeasurements(testInput)}")
    println("Answer 2: ${threeMeasurements(testInput)}")
}

