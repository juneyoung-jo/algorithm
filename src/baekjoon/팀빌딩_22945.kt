package baekjoon

import kotlin.math.max
import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = readLine().split(' ').map { it.toInt() }

    var start = 0
    var end = n - 1
    var result = 0
    while (true) {
        if (end == start) break
        result = max(result, (end - start - 1) * min(list[start], list[end]))
        if (list[start] > list[end]) {
            end--
        } else {
            start++
        }
    }

    println(result)
}
