package baekjoon

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(' ').map { it.toInt() }
    val dr = arrayOf(1, -1, 0, 0)
    val dc = arrayOf(0, 0, 1, -1)
    val q: Queue<Point_14940> = LinkedList()
    val vFlag = 10000000
    val result = Array(n) { IntArray(m) }

    var row = 0
    var col = 0
    val map = Array(n) {
        readLine().split(' ').mapIndexed { m, mVal ->
            if (mVal.toInt() == 2) {
                row = it
                col = m
            }
            mVal.toInt()
        }.toTypedArray()
    }

    q.add(Point_14940(row, col, 0))
    map[row][col] = vFlag
    while (q.isNotEmpty()) {
        val p = q.poll()
        result[p.r][p.c] = p.cnt

        for (k in 0..3) {
            val nr = p.r + dr[k]
            val nc = p.c + dc[k]

            if (nr < 0 || nc < 0 || nr >= n || nc >= m || map[nr][nc] == 0 || map[nr][nc] == vFlag) continue
            q.add(Point_14940(nr, nc, p.cnt + 1))
            map[nr][nc] = vFlag
        }
    }

    map.forEachIndexed { i, iVal ->
        iVal.forEachIndexed { j, jVal ->
            if (jVal == 1) {
                result[i][j] = -1
            }
        }
    }

    val sb = StringBuilder()

    result.forEach {
        it.forEach { value ->
            sb.append("$value ")
        }
        sb.append("\n")
    }

    println(sb)
}

data class Point_14940(
    val r: Int,
    val c: Int,
    val cnt: Int
)
