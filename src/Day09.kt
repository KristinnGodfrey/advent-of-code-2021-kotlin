import java.io.File

fun main() {
    val inputString = StringBuilder()
    val inputInitial = File("src/resources/day9.txt")
        .readLines()
    val lineLength = inputInitial[0].length
    inputInitial.forEach { i -> inputString.append(i) }

    val input = inputString
        .replace(".".toRegex(), "$0 ") // inputString with spaces
        .trim()
        .split(" ")
        .map { it.toInt() }
    val inputSize = input.size - 1

    fun isTopLine(i: Int): Boolean {
        return i < lineLength
    }

    fun isBottomLine(i: Int, lineLength: Int): Boolean {
        return i > inputSize - lineLength
    }

    fun isLeft(i: Int): Boolean {
        return i % lineLength == 0
    }

    fun isRight(i: Int): Boolean {
        return i % lineLength == lineLength - 1
    }

    val lowPoints = mutableListOf<Int>()

    for (i in 0 until inputSize) {
        val currentValue = input[i]
        // define a nullable variable lastValue
        val lastValue: Int? = input[i - 1]
        val nextValue: Int? = input[i + 1]
        val overValue: Int? = input[i - lineLength]
        val underValue: Int? = input[i + lineLength]

        if (isLeft(i)) {
            val nextValue = input[i + 1]
            // upper left corner
            if (isTopLine(i)) {
                val underValue = input[i + lineLength]
                if ((currentValue < nextValue) and (currentValue < underValue))
                    lowPoints.add(input[i])
            }
            // bottom left corner
            else if (isBottomLine(i, lineLength)) {
                val overValue = input[i - lineLength]
                if ((currentValue < nextValue) and (currentValue < overValue))
                    lowPoints.add(input[i])
            }
            // left
            else {
                val overValue = input[i - lineLength]
                val underValue = input[i + lineLength]
                if ((currentValue < nextValue) and (currentValue < underValue) and (currentValue < overValue))
                    lowPoints.add(input[i])
            }
        } else if (isRight(i)) {
            val lastValue = input[i - 1]
            //upper right corner
            if (isTopLine(i)) {
                val underValue = input[i + lineLength]
                if ((currentValue < lastValue) and (currentValue < underValue))
                    lowPoints.add(input[i])
            }
            // bottom right corner
            else if (isBottomLine(i, lineLength)) {
                val overValue = input[i - lineLength]
                if ((currentValue < lastValue) and (currentValue < overValue))
                    lowPoints.add(input[i])
            }
            // right
            else {
                val underValue = input[i + lineLength]
                val overValue = input[i - lineLength]
                if ((currentValue < lastValue) and (currentValue < underValue) and (currentValue < overValue))
                    lowPoints.add(input[i])
            }
        } else if (isTopLine(i)) {
            // top
            val underValue = input[i + lineLength]
            if ((currentValue < lastValue!!) and (currentValue < underValue) and (currentValue < nextValue!!))
                lowPoints.add(input[i])
        } else if (isBottomLine(i, lineLength)) {
            // bottom
            val overValue = input[i - lineLength]
            if ((currentValue < lastValue!!) and (currentValue < overValue) and (currentValue < nextValue!!))
                lowPoints.add(input[i])
        } else {
            // middle

            if ((currentValue < lastValue!!) and (currentValue < nextValue!!) and (currentValue < overValue!!) and (currentValue < underValue!!)) {
                lowPoints.add(input[i])
            }
        }
    }

    val ans = lowPoints.sumOf { it + 1 }
    println(ans)
}
