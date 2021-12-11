fun main() {
    var num = 10

    var twoD = Array(4) { IntArray(3) }

    for (i in twoD.indices) {
        var colArray = IntArray(3)
        for (j in colArray.indices) {
            colArray[j] = num++
        }
        twoD[i] = colArray
    }

    for (colArray in twoD) {
        for (j in colArray) {
            print(j)
            print(" ")
        }
        println()
    }
}
