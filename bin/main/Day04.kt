data class Player(var board: MutableList<MutableList<Int>>, var hasWon: Boolean)

fun main() {

    val checkWinnerStack = ArrayDeque<Pair<Int, Int>>()

    fun findValueInBoard(Player: Player, value: Int) {
        val lop = listOfPlayers
        for (l in listOfPlayers.indices) {
            lop[l].board.forEachIndexed { i, e ->
                e.forEachIndexed { j, v ->
                    if (value == v) {
                        lop[l].board[i][j] = 999

                    }
                }
            }
            println()
        }

    }

    fun part1(input: List<String>): Int {
        val listOfPlayers = mutableListOf<Player>()
        val inputNumbers = input[0]
            .split(",")
            .map { it.toInt() }
//        println(input)

        input
            .slice(1 until input.size)
            .map { it.replace("  ", " ") }
            .filter { it.isNotEmpty() }
            .map { it.trim() }
            .map { it.split(" ") }
            .map { it.map { l -> l.toInt() } }
            .chunked(5)
            .forEach { listOfPlayers.add(Player(it as MutableList<MutableList<Int>>, false)) }

        listOfPlayers.forEach {
            findValueInBoard(it, 22)
        }
        findValueInBoard(listOfPlayers, 22)
        println(listOfPlayers)


//                    if (l.isNotEmpty()) {
//                        val (a, b, c, d, e) = l
//                            .replace("  ", " ")
//                            .trim()
//                            .split(" ")
//                            .map { s -> s.toInt() }
//                        listOfPlayers.add(Player(board = listOf(a, b, c, d, e), false))
//                    }


        return 0
    }


    fun part2(input: List<String>): Int {

        return 0
    }

    val input: List<String> = readInput("resources/day4Tester")

    println("Answer 1: ${part1(input)}")
    println("Answer 2: ${part2(input)}")

}


