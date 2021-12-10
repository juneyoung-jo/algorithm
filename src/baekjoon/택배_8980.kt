package baekjoon

import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val (n, c) = readLine().split(' ').map { it.toInt() }
    val dp = IntArray(n + 1) { c }
    val m = readLine().toInt()
    val list = mutableListOf<Point_8980>()

    (1..m).forEach { _ ->
        val (from, to, amount) = readLine().split(' ').map { it.toInt() }
        list += Point_8980(from, to, amount)
    }

    var result = 0
    list.sortedWith(compareBy({ it.to }, { it.from }))
        .forEach { p ->
            val minValue = min(dp.slice(p.from until p.to).minByOrNull { it }!!, p.amount)
            for (i in p.from until p.to) {
                dp[i] -= minValue
            }
            result += minValue
        }
    println(result)
}

data class Point_8980(
    val from: Int,
    val to: Int,
    val amount: Int
)
