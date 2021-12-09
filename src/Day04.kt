data class Player(var board: List<Int>, var hasWon: Boolean)


fun main() {

    fun calculateBoard(board: MutableList<Int>, player: Player) {
        var countx = 0
        for (i in board) {
            if (board[i] == 999) countx++
        }
        if (countx == 5) player.hasWon = true
    }

    fun checkPlayerBoard(num: Int, player: Player) {
        for (j in 0 until player.board.size) {
            val mutablePlayer = player.board.toMutableList()
            if (player.board[j] == num) {
                mutablePlayer[j] = 999
                calculateBoard(mutablePlayer, player)
            }
        }
    }

    fun part1(input: List<String>): Int {
        val listOfPlayers = mutableListOf<Player>()
        val inputNumbers = input[0]
            .split(",")
            .map { it.toInt() }
        input
            .slice(1 until input.size)
            .chunked(6)
            .map {
                it.map { l ->
                    if (l.isNotEmpty()) {
                        val (a, b, c, d, e) = l
                            .replace("  ", " ")
                            .trim()
                            .split(" ")
                            .map { s -> s.toInt() }
                        listOfPlayers.add(Player(board = listOf(a, b, c, d, e), false))
                    }
                }
            }

        for (i in inputNumbers) {
            for (player in listOfPlayers) {
                checkPlayerBoard(i, player)
            }
        }

        for (player in listOfPlayers) {
            println(player)
        }
        return 0
    }


    fun part2(input: List<String>): Int {

        return 0
    }

    val input: List<String> = readInput("resources/day4Tester")

    println("Answer 1: ${part1(input)}")
    println("Answer 2: ${part2(input)}")

}


