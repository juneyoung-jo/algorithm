package baekjoon

fun main() = with(System.`in`.bufferedReader()) {
    val (n, _, h) = readLine().split(' ').map { it.toInt() }
    val blockList = Array(n) { mutableListOf<Int>() }
    val dp = Array(n + 1) { IntArray(h + 1) }
    val div = 10007

    for (i in 0 until n) {
        dp[i][0] = 1
        readLine().split(' ')
            .map { it.toInt() }
            .forEach { blockList[i] += it }
        blockList[i] += 0
    }

    for (i in 1..n) {
        for (j in 1..h) {
            for (k in blockList[i - 1].indices) {
                if (j - blockList[i - 1][k] >= 0) {
                    dp[i][j] += dp[i - 1][j - blockList[i - 1][k]]
                    dp[i][j] %= div
                }
            }
        }
    }

    println(dp[n][h])

}
