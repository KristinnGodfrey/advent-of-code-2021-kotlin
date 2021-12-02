fun main() {
    fun twoMeasurements(input: List<Int>): Int {
        var counter = 0
        val inputIt = input.listIterator(1)
        while (inputIt.hasNext()) {
            val inputItPrev = inputIt.previous().let { inputIt.next() }
            val inputItNext = inputIt.next()
            if (inputItNext > inputItPrev) {
                counter++
            }
        }
        return counter
    }

    fun threeMeasurements(input: List<Int>): Int {
        var counter = 0
        val inputIt = input.listIterator(3)
        while (inputIt.hasNext()) {
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
