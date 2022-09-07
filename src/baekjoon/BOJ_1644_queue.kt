package baekjoon

import java.util.*
import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val isPrime = BooleanArray(N + 1) { true }

    for (i in 2..sqrt(N.toDouble()).toInt()) {
        for (j in (i * i)..N step (i)) {
            isPrime[j] = false
        }
    }

    val q: Queue<Int> = LinkedList()
    var result = 0
    var sum = 0
    (2..N).reversed().forEach {
        if (!isPrime[it]) return@forEach
        sum += it
        q.add(it)

        if (sum == N) result++
        else if (sum > N) {
            while (q.isNotEmpty() && sum > N) {
                val poll = q.poll()
                sum -= poll
                if (sum == N) result++
            }
        }
    }
    println(result)

}
