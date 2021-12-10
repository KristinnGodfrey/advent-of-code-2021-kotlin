fun main() {
    fun part1(input: List<String>): Int {
        var horizontalPosition: Int = 0
        var verticalPosition: Int = 0
        for (line in input) {
            val command = line.substringBeforeLast(" ")
            val value = line.substringAfterLast(" ").toInt()
            when (command) {
                "forward" -> horizontalPosition += value
                "up" -> verticalPosition -= value
                "down" -> verticalPosition += value
            }
        }
        return horizontalPosition * verticalPosition
    }

    fun part2(input: List<String>): Int {
        var horizontalPosition: Int = 0
        var verticalPosition: Int = 0
        var aim: Int = 0
        for (line in input) {
            val command = line.substringBeforeLast(" ")
            val value = line.substringAfterLast(" ").toInt()
            when (command) {
                "forward" -> {
                    horizontalPosition += value
                    verticalPosition += aim * value
                }
                "up" -> aim -= value
                "down" -> aim += value
            }
        }
        return horizontalPosition * verticalPosition
    }

    val input: List<String> = readInput("resources/day2")

    println("Answer 1: ${part1(input)}")
    println("Answer 2: ${part2(input)}")
}
