package baekjoon

import java.util.*
import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val LIS = IntArray(n)
    var size = 0

    (0 until n).forEach { _ ->
        val num = readLine().toInt()
        var tmp = Arrays.binarySearch(LIS, 0, size, num)

        if (tmp < 0) {
            tmp = abs(tmp) - 1
            LIS[tmp] = num

            if (tmp == size) {
                size++
            }
        }
    }

    println(n - size)

}
