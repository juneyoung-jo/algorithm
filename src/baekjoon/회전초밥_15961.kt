package baekjoon

fun main() = with(System.`in`.bufferedReader()) {
    val (n, d, k, c) = readLine().split(' ').map { it.toInt() }
    val v = IntArray(d + 1)
    val list = mutableListOf<Int>()
    (1..n).forEach { _ ->
        list += readLine().toInt()
    }

    var result = 0

    (0 until k).forEach {
        v[list[it]]++
        if (v[list[it]] == 1) result++
    }

    var tmp = result
    (1 until n).forEach {
        if (tmp <= result) {
            tmp = if (v[c] == 0) result + 1 else result
        }

        v[list[it - 1]]--
        if (v[list[it - 1]] == 0) {
            result--
        }

        v[list[(it + k - 1) % n]]++
        if (v[list[(it + k - 1) % n]] == 1) {
            result++
        }
    }

    println(tmp)

}
