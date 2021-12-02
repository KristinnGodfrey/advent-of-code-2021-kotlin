import java.io.File

fun main() {
    fun part1(input: List<Commands>): Int {
        var horizontalPosition: Int = 0
        var verticalPosition: Int = 0

        for ((keyword, value) in input) {
            when (keyword) {
                "forward" -> horizontalPosition += value
                "up" -> verticalPosition -= value
                "down" -> verticalPosition += value
            }
        }

        return horizontalPosition * verticalPosition
    }

    fun part2(input: List<Commands>): Int {
        var horizontalPosition: Int = 0
        var verticalPosition: Int = 0
        var aim: Int = 0

        for ((keyword, value) in input) {
            when (keyword) {
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

    val input = File("src/resources/day2.txt")
        .readLines()
        .map {
            val (command, value) = it.split(" ")
            Commands(command, value.toInt())
        }

    println("Answer 1: ${part1(input)}")
    println("Answer 2: ${part2(input)}")
}

data class Commands(val command: String, val value: Int)
