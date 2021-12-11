fun main() {
    val arr = listOf(
        listOf(1, 2, 3),
        listOf(4, 5),
        listOf(6)
    )
    println(arr)

    val newArr = mutableListOf<Int>()
    arr.forEach { it.forEach { l -> newArr.add(l) } }
    println(newArr)
}
