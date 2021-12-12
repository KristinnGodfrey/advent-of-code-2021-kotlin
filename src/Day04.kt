data class Player(var board: MutableList<MutableList<Int>>, var hasWon: Boolean)

fun main() {

    fun calculateWinningScore(player: Player, value: Int): Int {
        println("We have a winner!")
        println(player)
        val scoreMap = player.board.flatMap {
            it.filter { l -> l != 999 }
        }
        return scoreMap.sum() * value
    }

    fun checkWinner(player: Player, y: Int, x: Int): Boolean {
        val b = player.board
//        println("YX: $y,$x")
//        var counter = 0
//        var counter2 = 0
//        var col = 0 - 1
//        var row = 4 + 1
//        for (i in 0..4) {
//            col++
//            row--
//            if (b[i][i] == 999) counter++
//            if (b[col][row] == 999) counter2++
//        }
//        if (counter == 5) {
//            println("diagonal")
//            return true
//        }
//        if (counter2 == 5) {
//            println("diagonal")
//            return true
//        }
        
        if (b[y].all { it == 999 }) {
            println("horizontal")
            println(b[y])
            return true
        }
        var counter = 0
        for (i in b.indices) {
            if ((b[i][x]) == 999) counter++
        }
        if (counter == 5) {
            println("vertical")
            return true
        }
        return false
    }

    fun findValueInBoard(player: Player, value: Int): Int {
        player.board.forEachIndexed { y, mutableList ->
            mutableList.forEachIndexed { x, v ->
                if ((value == v) and (!player.hasWon)) {
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

        println("I: XX, $listOfPlayers")

        var ans = 0
        for (i in inputNumbers) {
            listOfPlayers.forEach {
                if (ans == 0) ans += findValueInBoard(it, i)
                else return ans
            }
            println("I: $i, $listOfPlayers")
        }
        return ans
    }


    fun part2(input: List<String>): Int {

        return 0
    }

    val input: List<String> = readInput("resources/day4Tester")

    println("Answer 1: ${part1(input)}")
    println("Answer 2: ${part2(input)}")

}



