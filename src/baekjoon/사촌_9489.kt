fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        val (n, k) = readLine().split(' ').map { it.toInt() }
        if (n == 0 && k == 0) break
        val nodes = readLine().split(' ').map { it.toInt() }.toIntArray()
        val parent = IntArray(n) { -1 }
        var idx = -1
        var kIndex = 0

        (1 until n).forEach { i ->
            if (nodes[i - 1] + 1 != nodes[i]) idx++
            parent[i] = idx
            if (nodes[i] == k) kIndex = i
        }

        parent.asSequence()
            .filter { it >= 1 && parent[kIndex] != it && parent[parent[kIndex]] == parent[it] }
            .count()
            .also(::println)
    }
}
