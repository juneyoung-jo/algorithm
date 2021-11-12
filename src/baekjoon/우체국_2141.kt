package baekjoon

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = mutableListOf<Town>()
    var totalCount: Long = 1
    (1..n).forEach { _ ->
        val (lo, co) = readLine().split(' ').map { it.toInt() }
        list.add(Town(lo, co))
        totalCount += co
    }
    totalCount /= 2
    list.sortBy { it.location }

    var sumCount: Long = 0
    list.forEach {
        sumCount += it.count
        if (sumCount >= totalCount) {
            println(it.location)
            return
        }
    }
}

private data class Town(
    val location: Int,
    val count: Int
)
