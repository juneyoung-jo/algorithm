package baekjoon

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, t) = readLine().split(' ').map { it.toInt() }
    val map = Array(n) { IntArray(m) }
    val dr = listOf(1, -1, 0, 0)
    val dc = listOf(0, 0, 1, -1)
    val v = Array(2) { Array(n) { BooleanArray(m) } }
    val q: PriorityQueue<Point_17836> = PriorityQueue { o1, o2 -> o1.cnt - o2.cnt }

    (1..n).forEach {
        readLine().split(' ').forEachIndexed { j, jVal ->
            map[it - 1][j] = jVal.toInt()
        }
    }

    q.add(Point_17836(0, 0, 0, 0))
    v[0][0][0]
    var result = 0
    var p: Point_17836
    while (q.isNotEmpty()) {
        p = q.poll()
        if (p.r == n - 1 && p.c == m - 1) {
            result = p.cnt
            break
        }

        for (k in 0..3) {
            val nr = p.r + dr[k]
            val nc = p.c + dc[k]

            if (nr < 0 || nc < 0 || nr >= n || nc >= m || v[p.f][nr][nc]) continue
            if (p.f == 0 && map[nr][nc] == 1) continue

            v[p.f][nr][nc] = true
            if (map[nr][nc] == 2) {
                q.add(Point_17836(nr, nc, 1, p.cnt + 1))
            } else {
                q.add(Point_17836(nr, nc, p.f, p.cnt + 1))
            }
        }
    }

    if (result == 0 || result > t) println("Fail") else println(result)

}

data class Point_17836(
    val r: Int,
    val c: Int,
    val f: Int,
    val cnt: Int
)
