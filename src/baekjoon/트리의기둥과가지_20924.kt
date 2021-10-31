import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max

private val map = mutableMapOf<Int, ArrayList<Point>>()
private lateinit var v: BooleanArray


fun main() = with(System.`in`.bufferedReader()) {
    val (n, r) = readLine().split(' ').map { it.toInt() }
    init(n)
    map[r]!!.add(Point(0, 0)) // Avoid edge case
    v = BooleanArray(n + 1)
    for (i in 1 until n) {
        val (a, b, d) = readLine().split(' ').map { it.toInt() }
        map[a]!!.add(Point(b, d))
        map[b]!!.add(Point(a, d))
    }
    val (pole, branch) = searchGiga(r)
    println("$pole $branch")
}

private fun searchGiga(r: Int): Pair<Int, Int> {
    val q: Queue<Point> = LinkedList()

    var giga = -1
    var gigaCnt = 0
    var sum = 0
    q.add(Point(r, 0))
    var p: Point? = null
    while (q.isNotEmpty()) {
        p = q.poll()
        if (v[p.node]) continue
        v[p.node] = true
        sum = max(sum, p.cnt)
        if (giga == -1 && map[p.node]!!.size > 2) {
            giga = p.node
            gigaCnt = p.cnt
        }

        map[p.node]!!.forEach {
            q.add(Point(it.node, it.cnt + p.cnt))
        }
    }

    if (giga == -1) {
        return sum to 0
    }
    return gigaCnt to sum - gigaCnt
}

private fun init(n: Int) = (0..n).forEach { i -> map[i] = arrayListOf() }

private data class Point(
    val node: Int,
    val cnt: Int
) 
