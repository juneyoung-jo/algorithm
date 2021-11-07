fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    (1..t).forEach { _ ->
        val n = readLine().toInt()
        val costList = readLine().split(' ').map { it.toInt() }
        val cost = readLine().toInt()
        val dp = IntArray(cost + 1)
        dp[0] = 1
        costList.forEach {
            for (i in it..cost) {
                dp[i] += dp[i - it]
            }
        }

        println(dp[cost])

    }
}
