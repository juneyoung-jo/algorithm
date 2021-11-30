package baekjoon

lateinit var coin: Array<IntArray>
lateinit var dp: Array<IntArray>

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val k = readLine().toInt()

    coin = Array(k) { IntArray(2) }
    dp = Array(k) { IntArray(t + 1) { -1 } }

    (0 until k).forEach {
        val (p, n) = readLine().split(' ').map { it.toInt() }
        coin[it][0] = p // 10 5 1
        coin[it][1] = n //
    }

    println(cal_2624(0, 0, t, k))

}

private fun cal_2624(cnt: Int, idx: Int, t: Int, k: Int): Int {
    if (cnt == t) {
        return 1
    }

    if (cnt > t || idx == k) {
        return 0
    }

    if (dp[idx][cnt] != -1) {
        return dp[idx][cnt]
    }

    var ans = 0
    (0..coin[idx][1]).forEach {
        ans += cal_2624(cnt + coin[idx][0] * it, idx + 1, t, k)
    }

    dp[idx][cnt] = ans
    return ans
}
