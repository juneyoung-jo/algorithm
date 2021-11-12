package baekjoon

import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = mutableListOf<Home>()
    (1..n).forEach { _ ->
        val (lo, co) = readLine().split(' ').map { it.toInt() }
        list.add(Home(lo, co))
    }

    list.sortBy { it.location }

    val sumList = LongArray(list.size)
    sumList[0] = list[0].count.toLong()
    for (i in 1 until sumList.size) {
        sumList[i] = sumList[i - 1] + list[i].count
    }

    var left = 0
    var right = list.size - 1
    val totalCount = sumList[list.size - 1]
    var answer = 100001
    while (left <= right) {
        val mid = (left + right) / 2

        if (sumList[mid] >= totalCount - sumList[mid]) {
            right = mid - 1
            answer = min(answer, mid)
        } else {
            left = mid + 1
        }
    }

    println(list[answer].location)

}

private data class Home(
    val location: Int,
    val count: Int
)
