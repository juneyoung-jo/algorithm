package baekjoon

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(' ').map { it.toInt() }
    val array = IntArray(n) {
        readLine().toInt()
    }

    var min: Long = 1
    var max: Long = array.maxByOrNull { it }!!.toLong()

    while (min <= max) {
        val mid = (min + max) / 2
        var count: Long = 0
        array.forEach { count += it / mid }

        if (count >= k) {
            min = mid + 1
        } else {
            max = mid - 1
        }
    }

    println(max)
}
