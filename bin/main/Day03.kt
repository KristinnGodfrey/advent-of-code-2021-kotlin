fun main() {
    fun countBits(input: List<String>, i: Int): Pair<Int, Int> {
        var zerosAndOnes = Pair(0, 0)
        for (line in input) {
            if (line[i].toString() == "0") {
                zerosAndOnes = zerosAndOnes.copy(first = zerosAndOnes.first + 1)
            } else if (line[i].toString() == "1") {
                zerosAndOnes = zerosAndOnes.copy(second = zerosAndOnes.second + 1)
            }
        }
        return zerosAndOnes
    }

    fun xCommonValue(input: MutableList<String>, mostCommonValueBool: Boolean): Int {
        val delArray = mutableListOf<String>()
        val mostCommonValue = if (mostCommonValueBool) Pair("0", "1") else Pair("1", "0")
        for (i in input[0].indices) {
            val (countZeros, countOnes) = countBits(input, i)
            for (line in input) {
                if ((countOnes > countZeros) or (countOnes == countZeros)) {
                    if (line[i].toString() == mostCommonValue.first) {
                        delArray.add(line)
                    }
                } else if ((countOnes < countZeros)) {
                    if (line[i].toString() == mostCommonValue.second) {
                        delArray.add(line)
                    }
                }
            }
            delArray.forEach { k -> input.remove(k) }

            if (input.size == 1) break
        }
        return convertBinaryToDecimal(input[0].toLong())
    }

    fun part1(): Int {
        val input: List<String> = readInput("resources/day3")
        var gammaBinary = ""
        var epsilonBinary = ""
        for (i in input[0].indices) {
            val (countZeros, countOnes) = countBits(input, i)
            if (countOnes > countZeros) gammaBinary += "0".also { epsilonBinary += 1 }
            else if (countOnes < countZeros) gammaBinary += "1".also { epsilonBinary += 0 }
        }
        return convertBinaryToDecimal(gammaBinary.toLong()) * convertBinaryToDecimal(epsilonBinary.toLong())
    }

    fun part2(): Int {
        val input1: MutableList<String> = readInput("resources/day3") as MutableList<String>
        val input2: MutableList<String> = readInput("resources/day3") as MutableList<String>
        val oxygenGeneratorRating = xCommonValue(input1, true)
        val carbonDioxideRating = xCommonValue(input2, false)
        return oxygenGeneratorRating * carbonDioxideRating
    }

    println("Answer 1: ${part1()}")
    println("Answer 2: ${part2()}")
}
