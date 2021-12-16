data class Header(val version: Int, val typeID: Int, val typeIDLength: Char)

fun main() {
    val hexadecimalNumber = "38006F45291200"
    val binaryNumber = hexToBinary(hexadecimalNumber)
    val p = parseHeader(binaryNumber)

    if (p.typeID == 4) {
//        literalValue(packets)
    } else {
        val (bits, subPackets) = operator(p, binaryNumber)
        println(subPackets)
        val pp = parseHeader(subPackets)
    }
}

private fun operator(p: Header, binaryNumber: String): Pair<String, String> {
    var subPackets = ""
    var bits = ""
    if (p.typeIDLength == '0') {
        bits = binaryNumber.slice(7 until 22)
        subPackets = binaryNumber.slice(22 until binaryNumber.length)
    } else if (p.typeIDLength == '1') {
        bits = binaryNumber.slice(7 until 18)
        subPackets = binaryNumber.slice(18 until binaryNumber.length)
    }
    return Pair(bits, subPackets)
}

private fun parseHeader(binaryNumber: String): Header {
    val version = convertBinaryToDecimal(binaryNumber.slice(0..2).toLong())
    val typeID = convertBinaryToDecimal(binaryNumber.slice(3..5).toLong())
    val typeIDLength = binaryNumber[6]
    return Header(version, typeID, typeIDLength)

}

//private fun parseBits(binaryNumber: String) {
//    val version = convertBinaryToDecimal(binaryNumber.slice(0..2).toLong())
//    val typeID = convertBinaryToDecimal(binaryNumber.slice(3..5).toLong())
//    val typeIDLength = binaryNumber[6]
//    println(version)
//    println(typeID)
//    packets.forEachIndexed { i, v ->
//        if (i == 0) {
//            packets[0] = v.slice(1 until 5)
//        } else {
//            packets[0] += v.slice(1 until 5)
//        }
//        if (v.first() == '0') {
//            println(packets)
//            repeat(i) {
//                packets.removeAt(1)
//            }
//            println(packets)
//            return
//        }
//    }
//    return
//}

//private fun operator(packets: String, typeIDLength: Char) {
////    println(packets)
//    if (typeIDLength == '0') { // 15
//
//    } else if (typeIDLength == '1') // 11
//    {
//
//    } else {
//        println("invalid typeID")
//    }
//}
//
//private fun literalValue(binaryNumber: String): Int {
//    // [0111, 1110, 0101]
//    val packets = binaryNumber
//        .slice(6 until binaryNumber.length)
//        .trimEnd('0')
//        .chunked(5)
//        .map { it.slice(1 until 5) }
//
//    println(packets)
//
//    // 2021
//    val decimal = convertBinaryToDecimal(packets
//        .flatMap { it.toList() }
//        .joinToString(" ")
//        .replace(" ", "")
//        .trimStart('0')
//        .toLong())
//    return decimal
//}

//private fun parsePackets(binaryNumber: String): MutableList<String> {
//    val packets = binaryNumber
//        .slice(6 until binaryNumber.length)
//        .chunked(5).toMutableList()
//
//    if (packets.last().all { it == '0' }) {
//        packets.remove(packets.last())
//    }
//    return packets
//}


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
