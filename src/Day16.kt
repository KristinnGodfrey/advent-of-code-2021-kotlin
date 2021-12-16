data class num(val version: String, val typeID: String)

fun main() {
    val hexadecimalNumber = "D2FE28"
    val binaryNumber = hexToBinary(hexadecimalNumber)
    val version = convertBinaryToDecimal(binaryNumber.slice(0..2).toLong())
    val typeID = convertBinaryToDecimal(binaryNumber.slice(3..5).toLong())
    val packets = parsePackets(binaryNumber)
    packets.add("10100")
    println(packets)
    val currentBits = findBitRange(packets)
    println(currentBits)

//        .map { it.slice(1 until 5) }

//    val typeIDLength = binaryNumber[6].toInt()
//    println(typeIDLength)
//
//    println(version)
//    println(typeID)
//    if (typeID == 4) {
//        println(literalValue(binaryNumber))
//    }
//    else {
//        if (typeIDLength == 0) { // 15 bit number bits
//            val packets = binaryNumber
//                .slice(7 until binaryNumber.length)
//                .trimEnd('0')
//        } else if (typeIDLength == 1) { // 11 bit number
//            println(operator())
//        }
//        println(operator())
//    }
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

private fun findBitRange(packets: MutableList<String>): String {
    val builder = StringBuilder()
    packets.forEachIndexed { i, v ->
        builder.append(v.slice(1 until 5))
        if (v.first() == '0') {
            return builder.toString()
        }
    }
    return builder.toString()
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
