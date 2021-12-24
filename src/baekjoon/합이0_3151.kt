package baekjoon

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val countList = LongArray(40001)
    val fixedValue = 20000
    val list = readLine().split(' ').map { it.toInt() }

    var result = 0L
    list.forEachIndexed { index, value ->
        result += countList[fixedValue - value]
        (0 until index).forEach {
            countList[value + list[it] + fixedValue]++
        }
    }
    print(result)
}
