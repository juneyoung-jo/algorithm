package baekjoon

import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val isPrime = BooleanArray(N + 1) { true }

    for (i in 2..sqrt(N.toDouble()).toInt()) {
        for (j in (i * i)..N step (i)) {
            isPrime[j] = false
        }
    }

    var start = 2
    var result = 0
    var sum = 0

    for (i in 2..N) {
        if (!isPrime[i]) continue
        sum += i
        if (sum == N) result++
        else if (sum > N) {
            while (sum > N) {
                if (start > i) break
                if (isPrime[start] && start <= i) {
                    sum -= start
                    if (sum == N) result++
                }
                start++
            }
        }
    }

    println(result)

}
