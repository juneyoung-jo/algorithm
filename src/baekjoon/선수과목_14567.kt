package baekjoon

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(' ').map { it.toInt() }
    val list = IntArray(n + 1)
    val result = IntArray(n)
    val q: Queue<Point_14567> = LinkedList()

    val map = mutableMapOf<Int, MutableList<Int>>()
    (1..n).forEach { map[it] = mutableListOf() }

    (1..m).forEach { _ ->
        val (preOrder, order) = readLine().split(' ').map { it.toInt() }
        list[order]++
        map[preOrder]!!.add(order)
    }

    (1..n).forEach {
        if (list[it] == 0) {
            q.add(Point_14567(it, 1))
        }
    }

    while (q.isNotEmpty()) {
        val p = q.poll()
        if (result[p.idx - 1] != 0) continue
        result[p.idx - 1] = p.cnt

        map[p.idx]!!.forEach {
            list[it]--
            if (list[it] == 0) {
                q.add(Point_14567(it, p.cnt + 1))
            }
        }
    }

    println(result.joinToString(" "))
}

data class Point_14567(
    val idx: Int,
    val cnt: Int
)
