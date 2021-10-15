package baekjoon

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val cnt = IntArray(n + 1)
    val sb = StringBuilder()

    for (i in 1 until n)
        readLine().split(' ').forEach { cnt[it.toInt()]++ }

    for (i in 1..readLine().toInt()) {
        val (n, m) = readLine().split(' ').map { it.toInt() }
        when (n) {
            1 -> if (cnt[m] == 1) sb.append("no\n") else sb.append("yes\n")
            2 -> sb.append("yes\n")
        }
    }

    println(sb)
}
