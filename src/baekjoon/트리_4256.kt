package baekjoon

private lateinit var preOrders: List<Int>
private lateinit var inOrders: List<Int>
fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    for (i in 1..t) {
        val n = readLine().toInt()
        preOrders = readLine().trim().split(' ').map { it.toInt() }
        inOrders = readLine().trim().split(' ').map { it.toInt() }
        calPostOrder(0, n, 0)
        println()
    }
}

fun calPostOrder(start: Int, end: Int, root: Int) {
    for (i in start until end) {
        if (preOrders[root] == inOrders[i]) {
            calPostOrder(start, i, root + 1)
            calPostOrder(i + 1, end, root + i - start + 1)
            print("${preOrders[root]} ")
        }
    }
}
