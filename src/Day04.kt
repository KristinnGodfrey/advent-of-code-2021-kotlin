data class Player(var board: List<String>, val hasWon: Boolean)

fun main() {
    fun part1(input: List<String>): Int {
        val inputNumbers = input[0]
        val listOfPlayers = mutableListOf<Player>()

        val boardsPrint = input
            .slice(1 until input.size)
            .chunked(6)
        println("\n")
        println(boardsPrint)
        val boards = input
            .slice(1 until input.size)
            .chunked(6)
            .map {
                it.map { l ->
                    if (l != "") {
                        val (a, b, c, d, e) = l.split(" ")
                        listOfPlayers.add(Player(board = listOf(a, b, c, d, e), false))
                    }
                }
            }


//        println("inputNumbers $inputNumbers")
        println(listOfPlayers)
        println("\n")


//        for (b in boards) {
//            val player = Player(mutableListOf(), false)
//            if (b != "") {
//                player.board += "row"
//            } else if (b == "") {
//                player.board += "new Row"
//            } else {
//                listOfPlayers.add(player)
//                continue
//            }
//        }
//        println(listOfPlayers)

        return 0
    }

    fun part2(input: List<String>): Int {

        return 0
    }

    val input: List<String> = readInput("resources/day4Tester")

    println("Answer 1: ${part1(input)}")
    println("Answer 2: ${part2(input)}")

}


