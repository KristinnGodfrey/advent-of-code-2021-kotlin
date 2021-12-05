data class Player(var board: List<String>, val hasWon: Boolean)

fun main() {
    fun part1(input: List<String>): Int {
        val inputNumbers = input[0]
        val boards = input
            .slice(2 until input.size)

        println("\n")
        println("inputNumbers $inputNumbers")
        println("boards $boards")
        println("\n")

        val listOfPlayers = mutableListOf<Player>()
        for (b in boards) {
            val player = Player(mutableListOf(), false)
            if (b != "") {
                player.board += "row"
            } else if (b == "") {
                player.board += "new Row"
            } else {
                listOfPlayers.add(player)
                continue
            }
        }
        println(listOfPlayers)

        return 0
    }

    fun part2(input: List<String>): Int {

        return 0
    }

    val input: List<String> = readInput("resources/day4Tester")
    println(input)

    println("Answer 1: ${part1(input)}")
    println("Answer 2: ${part2(input)}")

}


