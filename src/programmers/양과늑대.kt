package programmers

import kotlin.math.max

var result = 0
val map = mutableMapOf<Int, MutableList<Int>>()

private fun solution(info: IntArray, edges: Array<IntArray>): Int {
    info.forEachIndexed { index, _ -> map[index] = mutableListOf() }
    edges.forEach { map[it[0]]?.add(it[1]) }
    cal(0, 0, 0, mutableListOf(), info)
    return result
}

private fun cal(idx: Int, sheep: Int, wolf: Int, route: MutableList<Int>, info: IntArray) {
    var sheep = sheep
    var wolf = wolf

    when (info[idx]) {
        0 -> sheep += 1
        else -> wolf += 1
    }

    if (wolf == sheep) return

    result = max(result, sheep)

    val to = mutableListOf<Int>()
    to.addAll(map[idx]!!)
    to.addAll(route)
    to.remove(idx)
    to.forEach { cal(it, sheep, wolf, to, info) }
}

private fun main() {
    val info = intArrayOf(0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1)
    val edges = arrayOf(
        intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(1, 4), intArrayOf(0, 8), intArrayOf(8, 7),
        intArrayOf(9, 10), intArrayOf(9, 11), intArrayOf(4, 3), intArrayOf(6, 5), intArrayOf(4, 6),
        intArrayOf(8, 9)
    )
    println(solution(info, edges))
}
