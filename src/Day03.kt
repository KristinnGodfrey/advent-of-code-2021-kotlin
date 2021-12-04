fun main() {
    fun leastCommonValue(input: MutableList<String>): Int {
        val delArray = mutableListOf<String>()
        for (i in input[0].indices) {
            val (countZeros, countOnes) = countBits(input, i)
            for (line in input) {
                if ((countOnes > countZeros) or (countOnes == countZeros)) {
                    if (line[i].toString() == "1") {
                        delArray.add(line)
                    }
                } else if ((countOnes < countZeros)) {
                    if (line[i].toString() == "0") {
                        delArray.add(line)
                    }
                }
            }
            delArray.forEach { k -> input.remove(k) }

            if (input.size == 1) break
        }
        return convertBinaryToDecimal(input[0].toLong())
    }

    fun mostCommonValue(input: MutableList<String>): Int {
        val delArray = mutableListOf<String>()
        for (i in input[0].indices) {
            val (countZeros, countOnes) = countBits(input, i)
            for (line in input) {
                if ((countOnes > countZeros) or (countOnes == countZeros)) {
                    if (line[i].toString() == "0") {
                        delArray.add(line)
                    }
                } else if (countOnes < countZeros) {
                    if (line[i].toString() == "1") {
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
        val oxygenGeneratorRating = mostCommonValue(input1)
        val carbonDioxideRating = leastCommonValue(input2)
        return oxygenGeneratorRating * carbonDioxideRating
    }

    println("Answer 1: ${part1()}")
    println("Answer 2: ${part2()}")
}
