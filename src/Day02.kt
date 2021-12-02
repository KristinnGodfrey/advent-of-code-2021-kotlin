fun main() {
    fun part1(input: List<String>): Int {
        var horizontalPosition: Int = 0
        var verticalPosition: Int = 0
        for (line in input) {
            when (line.substringBeforeLast(" ")) {
                "forward" -> horizontalPosition += line.substringAfterLast(" ").toInt()
                "up" -> verticalPosition -= line.substringAfterLast(" ").toInt()
                "down" -> verticalPosition += line.substringAfterLast(" ").toInt()
            }
        }
        return horizontalPosition * verticalPosition
    }

    fun part2(input: List<String>): Int {
        var horizontalPosition: Int = 0
        var verticalPosition: Int = 0
        var aim: Int = 0
        var depth: Int = 0
        for (line in input) {
            when (line.substringBeforeLast(" ")) {
                "forward" ->
                    horizontalPosition += line.substringAfterLast(" ")
                        .toInt().also { depth += aim * line.substringAfterLast(" ").toInt() }
                "up" -> aim -= line.substringAfterLast(" ").toInt()
                "down" -> aim += line.substringAfterLast(" ").toInt()
            }
        }
        return horizontalPosition * depth
    }
    // test if implementation meets criteria from the description, like:
    val input: List<String> = readInput("resources/day2")

    println("Answer 1: ${part1(input)}")
    println("Answer 2: ${part2(input)}")
}

