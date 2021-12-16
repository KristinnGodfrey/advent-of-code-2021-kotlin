data class num(val version: String, val typeID: String)

fun main() {
    val hexadecimalNumber = "8A004A801A8002F478"
    val binaryNumber = hexToBinary(hexadecimalNumber)
    println(binaryNumber)
    val version = convertBinaryToDecimal(binaryNumber.slice(0..2).toLong())
    val typeID = convertBinaryToDecimal(binaryNumber.slice(3..5).toLong())
//    val packets = parsePackets(binaryNumber)

    println(version)
    println(typeID)

    if (typeID == 4) {
        val packets = binaryNumber.slice(6..binaryNumber.length)
//        literalValue(binaryNumber)
    } else {
        val typeIDLength = binaryNumber[6].toInt()
        if (typeIDLength == 0) { // 15

        } else if (typeIDLength == 1) // 11
        {

        } else {
            println("invalid typeID")
        }
    }
//    val currentBits = parseBits(packets)
}

private fun parseBits(packets: MutableList<String>) {
    packets.forEachIndexed { i, v ->
        if (i == 0) {
            packets[0] = v.slice(1 until 5)
        } else {
            packets[0] += v.slice(1 until 5)
        }
        if (v.first() == '0') {
            println(packets)
            repeat(i) {
                packets.removeAt(1)
            }
            println(packets)
            return
        }
    }
    return
}

private fun parsePackets(binaryNumber: String): MutableList<String> {
    val packets = binaryNumber
        .slice(6 until binaryNumber.length)
        .chunked(5).toMutableList()

    if (packets.last().all { it == '0' }) {
        packets.remove(packets.last())
    }
    return packets
}

private fun operator() {

}

private fun literalValue(binaryNumber: String): Int {
    // [0111, 1110, 0101]
    val packets = binaryNumber
        .slice(6 until binaryNumber.length)
        .trimEnd('0')
        .chunked(5)
        .map { it.slice(1 until 5) }

    println(packets)

    // 2021
    val decimal = convertBinaryToDecimal(packets
        .flatMap { it.toList() }
        .joinToString(" ")
        .replace(" ", "")
        .trimStart('0')
        .toLong())
    return decimal
}

private fun hexToBinary(hexaDecimalN: String): String {

    if (checkHexaDecimalNumber(hexaDecimalN)) {
        var i = 0
        var binaryNum = ""
        while (i < hexaDecimalN.length) {
            when (hexaDecimalN[i]) {
                '0' -> binaryNum += "0000"
                '1' -> binaryNum += "0001"
                '2' -> binaryNum += "0010"
                '3' -> binaryNum += "0011"
                '4' -> binaryNum += "0100"
                '5' -> binaryNum += "0101"
                '6' -> binaryNum += "0110"
                '7' -> binaryNum += "0111"
                '8' -> binaryNum += "1000"
                '9' -> binaryNum += "1001"
                'A', 'a' -> binaryNum += "1010"
                'B', 'b' -> binaryNum += "1011"
                'C', 'c' -> binaryNum += "1100"
                'D', 'd' -> binaryNum += "1101"
                'E', 'e' -> binaryNum += "1110"
                'F', 'f' -> binaryNum += "1111"
            }
            i++
        }
        return binaryNum
    } else {
        return "$hexaDecimalN is not a hexadecimal number"
    }
}

private fun checkHexaDecimalNumber(hexaDecimalNum: String): Boolean {
    var isHexaDecimalNum = true

    for (charAtPos in hexaDecimalNum) {
        if (!(
                    ((charAtPos >= '0') && (charAtPos <= '9'))
                            || ((charAtPos >= 'A') && (charAtPos <= 'F'))
                            || ((charAtPos >= 'a') && (charAtPos <= 'f'))
                    )
        ) {
            isHexaDecimalNum = false
            break
        }
    }
    return isHexaDecimalNum
}
