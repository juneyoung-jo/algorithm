package baekjoon

import kotlin.math.min

lateinit var dp_17485: Array<Array<IntArray>>
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(' ').map { it.toInt() }
    val map = Array(n) { IntArray(m) }
    dp_17485 = Array(n) { Array(m) { IntArray(3) } }

    (0 until n).forEach { i ->
        readLine().split(' ').map { it.toInt() }.forEachIndexed { j, value -> map[i][j] = value }
    }

    (0 until m).forEach {
        dp_17485[0][it][0] = map[0][it]
        dp_17485[0][it][1] = map[0][it]
        dp_17485[0][it][2] = map[0][it]
    }


    for (r in 1 until n) {
        for (c in 0 until m) {
            for (k in 0..2) {
                dp_17485[r][c][k] = calDistance_17485(r - 1, c - 1 + k, k, m) + map[r][c]
            }
        }
    }

    var result = 1000000000
    for (c in 0 until m) {
        for (l in 0..2) {
            result = min(dp_17485[n - 1][c][l], result)
        }
    }

    println(result)
}

fun calDistance_17485(r: Int, c: Int, dir: Int, col: Int): Int {
    if (c < 0 || c >= col) return 1000000000;
    if (dir == 0) return min(dp_17485[r][c][1], dp_17485[r][c][2]);
    if (dir == 1) return min(dp_17485[r][c][0], dp_17485[r][c][2]);
    return min(dp_17485[r][c][0], dp_17485[r][c][1]);
}
