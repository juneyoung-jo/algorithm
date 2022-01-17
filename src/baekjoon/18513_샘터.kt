package baekjoon

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var (_, k) = readLine().split(' ').map { it.toInt() }
    val sumValue = 100000001
    val list = readLine().split(' ').map { it.toInt() + sumValue }
    var result = 0L
    val v = mutableSetOf<Int>()
    val q: Queue<Point_18513> = LinkedList()

    list.forEach {
        q += Point_18513(it, 0)
        v += it
    }

    var left = 0
    var right = 0
    while (true) {
        if (k == 0) break
        val p = q.poll()
        left = p.idx - 1
        right = p.idx + 1
        if (!v.contains(left) && k > 0) {
            v += left
            k--
            q += Point_18513(left, p.cnt + 1)
            result += p.cnt + 1
        }

        if (!v.contains(right) && k > 0) {
            v += right
            k--
            q += Point_18513(right, p.cnt + 1)
            result += p.cnt + 1
        }
    }

    println(result)

}

data class Point_18513(
    val idx: Int,
    val cnt: Int,
)
