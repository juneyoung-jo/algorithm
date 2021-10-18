package baekjoon

data class Point(
    val to: Int,
    val cnt: Int
)

var maxValue = 0
var maxIndex = 0
val map = hashMapOf<Int, MutableList<Point>>()
fun main() = with(System.`in`.bufferedReader()) {

    val n = readLine().toInt()
    init(map)

    for (i in 1 until n) {
        val (from, to, cnt) = readLine().split(' ').map { it.toInt() }
        map[from]!!.add(Point(to, cnt))
        map[to]!!.add(Point(from, cnt))
    }

    dfs(1, 0, BooleanArray(10001))
    dfs(maxIndex, 0, BooleanArray(10001))
    println(maxValue)
}

fun dfs(idx: Int, sum: Int, v: BooleanArray): Int {
    if (v[idx]) return 0
    v[idx] = true
    map[idx]?.forEach {
        val result = dfs(it.to, sum + it.cnt, v)
        if (maxValue < result) {
            maxValue = result
            maxIndex = it.to
        }
    }
    return sum
}

fun init(hashMapOf: HashMap<Int, MutableList<Point>>) = (1..10000).forEach { hashMapOf[it] = mutableListOf() }

