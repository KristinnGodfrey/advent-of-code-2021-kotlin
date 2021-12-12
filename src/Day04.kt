data class Player(var board: MutableList<MutableList<Int>>, var hasWon: Boolean)

fun main() {

    fun calculateWinningScore(player: Player, value: Int) {
        println("---")
        println("WE HAVE A WINNER:")
        println(player.board)
        println("Value: $value")
        println("---")
        var score = 0
        val scoreMap = player.board.flatMap {
            it.filter { l -> l != 999 }

        }
        println("SCOREMAP")
        println(scoreMap.sum() * value)
        println("SCOREMAP")
    }

    fun checkWinner(player: Player, y: Int, x: Int): Boolean {
        val b = player.board
//        println("YX: $y, $x")
        if ((y == 0 && x == 0) or (y == 1 && x == 1) or (y == 2 && x == 2) or (y == 3 && x == 3) or (y == 4 && x == 4)) {
            if ((b[0][0] == 999) and (b[1][1] == 999) and (b[2][2] == 999) and (b[3][3] == 999) and (b[3][3] == 999) and (b[4][4] == 999)) {
                return true
            }
        } else if (b[y].all { it == 999 }) {
            return true
        } else {
            var counter = 0
            for (i in b.indices) {
                if ((b[i][x]) == 999) counter++
            }
            if (counter == 5) return true
        }

        return false

    }

    fun findValueInBoard(player: Player, value: Int) {
        player.board.forEachIndexed { y, mutableList ->
            mutableList.forEachIndexed { x, v ->
                if ((value == v) and (!player.hasWon)) {
                    player.board[y][x] = 999
                    if (checkWinner(player, y, x)) {
                        player.hasWon = true
                        calculateWinningScore(player, value)
                    }

                }
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
            .map { it.replace("  ", " ") }
            .filter { it.isNotEmpty() }
            .map { it.trim() }
            .map { it.split(" ") }
            .map { it.map { l -> l.toInt() } }
            .chunked(5)
            .forEach { listOfPlayers.add(Player(it as MutableList<MutableList<Int>>, false)) }

//        println("INITIAL")
//        println(listOfPlayers)
//        println("END INITIAL")

        val counter = 0
        for (i in inputNumbers) {
            listOfPlayers.forEach {
                findValueInBoard(it, i)
            }
//            println(listOfPlayers)

        }
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


