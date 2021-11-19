package baekjoon

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var (n, k) = readLine().split(' ').map { it.toInt() }
    val list = readLine().toCharArray()
    val totalCnt = n - k
    val dq = ArrayDeque<Char>()

    list.forEach {
        while (k > 0 && dq.isNotEmpty() && dq.peekFirst() < it) {
            k--
            dq.pollFirst()
        }
        dq.addFirst(it)
    }

    println(dq.reversed().joinToString("").substring(0, totalCnt))

}
