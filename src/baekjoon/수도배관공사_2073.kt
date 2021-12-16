package baekjoon

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (d, p) = readLine().split(' ').map { it.toInt() }
    val list = mutableListOf<Point_2073>()
    (1..p).forEach { _ ->
        val (l, c) = readLine().split(' ').map { it.toInt() }
        list += Point_2073(l, c, 0)
    }

    val sortedList = list.sortedByDescending { it.c }

    val q: PriorityQueue<Point_2073> = PriorityQueue { o1, o2 -> o2.c - o1.c }

    q += Point_2073(0, 0, 0)
    while (q.isNotEmpty()) {
        val point = q.poll()
        if (point.l == d) {
            return@with println(point.c)
        }
        (point.idx until p).forEach { idx ->
            if (point.l + sortedList[idx].l <= d) {
                q += Point_2073(point.l + sortedList[idx].l, sortedList[idx].c, idx + 1)
            }
        }
    }

}

data class Point_2073(
    val l: Int,
    val c: Int,
    val idx: Int,
)
