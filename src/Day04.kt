data class Player(var board: MutableList<MutableList<Int>>, var hasWon: Boolean)

fun main() {

    fun calculateWinningScore(player: Player, value: Int): Int {
        val scoreMap = player.board.flatMap {
            it.filter { l -> l != 999 }
        }
        return scoreMap.sum() * value
    }

    fun checkWinner(player: Player, y: Int, x: Int): Boolean {
        val b = player.board

        if (b[y].all { it == 999 }) return true

        if (b.count { row -> row[x] == 999 } == 5) return true

        return false
    }

    fun findValueInBoard(player: Player, value: Int, hasWon: Boolean = false): Int {
        player.board.forEachIndexed { y, mutableList ->
            mutableList.forEachIndexed { x, v ->
                if (value == v) {
                    player.board[y][x] = 999
                    if (checkWinner(player, y, x)) {
                        player.hasWon = true
                        return calculateWinningScore(player, value)
                    }
                }
            }
        }
        return 0
    }

    fun mapInput(input: List<String>, listOfPlayers: MutableList<Player>) {
        input
            .slice(1 until input.size)
            .map { it.replace("  ", " ") }
            .filter { it.isNotEmpty() }
            .map { it.trim() }
            .map { it.split(" ") }
            .map { it.map { l -> l.toInt() } }
            .chunked(5)
            .forEach { listOfPlayers.add(Player(it as MutableList<MutableList<Int>>, false)) }
    }

    fun mapInputNumbers(input: List<String>): List<Int> {
        return input[0]
            .split(",")
            .map { it.toInt() }
    }

    fun part1(input: List<String>): Int {
        val listOfPlayers = mutableListOf<Player>()
        val inputNumbers = mapInputNumbers(input)
        mapInput(input, listOfPlayers)

        var ans = 0
        for (i in inputNumbers) {
            listOfPlayers.forEach {
                if (ans == 0) ans += findValueInBoard(it, i)
                else return ans
            }
        }
        return ans
    }


    fun part2(input: List<String>): Int {
        val listOfPlayers = mutableListOf<Player>()
        val inputNumbers = mapInputNumbers(input)
        mapInput(input, listOfPlayers)

        for (i in inputNumbers) {
            listOfPlayers.forEach {
                findValueInBoard(it, i)
                if (listOfPlayers.all { l -> l.hasWon }) return calculateWinningScore(it, i)

            }
        }
        return 0
    }

    val input: List<String> = readInput("resources/day4Tester")

    println("Answer 1: ${part1(input)}")
    println("Answer 2: ${part2(input)}")
}



