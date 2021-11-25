package baekjoon

var n: Int = 0
lateinit var array: List<Int>

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    array = readLine().split(' ').map { it.toInt() }

    val newList = LongArray(21)
    newList[array[0]]++
    println(cal(1, newList))
}

private fun cal(idx: Int, prevList: LongArray): Long {
    if (idx == n - 1) {
        return prevList[array[n - 1]]
    }

    val newList = LongArray(21)

    (0..20).forEach {
        if (prevList[it] != 0L) {
            // 양수
            if (it - array[idx] >= 0) {
                newList[it - array[idx]] += prevList[it]
            }

            // 20 이하
            if (it + array[idx] < 21) {
                newList[it + array[idx]] += prevList[it]
            }
        }
    }

    return cal(idx + 1, newList)
}


