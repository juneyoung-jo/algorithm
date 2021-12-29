package baekjoon

import kotlin.math.abs
import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = readLine().split(' ').map { it.toLong() }.sorted()

    var result: Long = Long.MAX_VALUE
    for (i in list.indices) {
        for (j in i + 1 until n) {
            val snow1 = list[i] + list[j]
            var start = 0
            var end = n - 1
            while (true) {
                if (start == end) break
                if (i == start || j == start) {
                    start++
                    continue
                }
                if (i == end || j == end) {
                    end--
                    continue
                }

                val snow2 = list[start] + list[end]
                result = min(result, abs(snow1 - snow2))
                when {
                    result == 0L -> {
                        return@with println(0)
                    }
                    snow1 < snow2 -> {
                        end--
                    }
                    else -> {
                        start++
                    }
                }
            }
        }
    }

    println(result)
}
