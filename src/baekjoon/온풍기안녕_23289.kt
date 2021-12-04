package baekjoon

lateinit var map_23289: Array<IntArray>
lateinit var tmpMap_23289: Array<IntArray>
lateinit var wallSet: MutableSet<Int>
val dr_23289 = arrayOf(1, -1, 0, 0, -1, -1, 1, 1) // 하상우좌 왼위 오위 오아래 왼아래
val dc_23289 = arrayOf(0, 0, 1, -1, -1, 1, 1, -1)

fun main() = with(System.`in`.bufferedReader()) {
    val (r, c, k) = readLine().split(' ').map { it.toInt() }
    map_23289 = Array(r) { IntArray(c) }
    tmpMap_23289 = Array(r) { IntArray(c) }
    val checkList = mutableListOf<Point_23289>()
    val heaterList = mutableListOf<Point_23289>()
    wallSet = mutableSetOf<Int>()

    (0 until r).forEach {
        readLine().split(' ').map { it.toInt() }
            .forEachIndexed { index, i ->
                when (i) {
                    1 -> heaterList += Point_23289(it, index, 2)
                    2 -> heaterList += Point_23289(it, index, 3)
                    3 -> heaterList += Point_23289(it, index, 1)
                    4 -> heaterList += Point_23289(it, index, 0)
                    5 -> checkList += Point_23289(it, index, k)
                }
            }
    }

    val w = readLine().toInt()

    (1..w).forEach { _ ->
        val (x, y, f) = readLine().split(' ').map { it.toInt() }
        when (f) {
            0 -> wallSet += calWall_23289(x - 1, y - 1) + calWall_23289(x - 2, y - 1)
            1 -> wallSet += calWall_23289(x - 1, y - 1) + calWall_23289(x - 1, y)
        }
    }

    var candy: Int = 0
    while (true) {
        if (candy > 100) break
        heaterList.forEach {
            val nr = it.r + dr_23289[it.dir]
            val nc = it.c + dc_23289[it.dir]
            cal_23289(Point_23289(nr, nc, it.dir), 5, r, c)
            clearTmpMap_23289()
        }

        go_23289(r, c)
        copyMap()
        clearTmpMap_23289()

        // 가장자리 온도 1 감소
        for (j in 0 until c) {
            if (map_23289[0][j] >= 1) map_23289[0][j]--
            if (map_23289[r - 1][j] >= 1) map_23289[r - 1][j]--

        }

        for (j in 0 until r) {
            if (j == 0 || j == r - 1) continue
            if (map_23289[j][0] >= 1) map_23289[j][0]--
            if (map_23289[j][c - 1] >= 1) map_23289[j][c - 1]--
        }

        // 초콜릿
        candy++
        var flag = true
        checkList.forEach {
            if (map_23289[it.r][it.c] < k) {
                flag = false
                return@forEach
            }
        }

        if (flag) break
    }

    println(candy)

}

fun go_23289(r: Int, c: Int) {
    for (i in 0 until r) {
        for (j in 0 until c) {
            tmpMap_23289[i][j] += map_23289[i][j]
            for (k in 0..3) {
                val nr = i + dr_23289[k]
                val nc = j + dc_23289[k]

                if (nr < 0 || nc < 0 || nr >= r || nc >= c) continue
                if (wallSet.contains(calWall_23289(i, j) + calWall_23289(nr, nc)) || map_23289[i][j] - map_23289[nr][nc] <= 0) continue
                val div = (map_23289[i][j] - map_23289[nr][nc]) / 4
                tmpMap_23289[nr][nc] += div
                tmpMap_23289[i][j] -= div
            }
        }
    }
}

fun copyMap() {
    for (i in map_23289.indices) {
        for (j in map_23289[i].indices) {
            map_23289[i][j] = tmpMap_23289[i][j]
        }
    }
}

fun clearTmpMap_23289() {
    for (i in tmpMap_23289.indices) {
        for (j in tmpMap_23289[i].indices) {
            tmpMap_23289[i][j] = 0
        }
    }
}


fun cal_23289(p: Point_23289, idx: Int, r: Int, c: Int) {
    if (idx == 0 || p.r < 0 || p.c < 0 || p.r >= r || p.c >= c || tmpMap_23289[p.r][p.c] != 0) return
    tmpMap_23289[p.r][p.c] += idx
    map_23289[p.r][p.c] += idx

    when (p.dir) {
        0 -> {
            // 왼아래  3,7
            if (checkWall(p, listOf(3,7))) {
                cal_23289(Point_23289(p.r + dr_23289[7], p.c + dc_23289[7], p.dir), idx - 1, r, c)
            }
            // 아래 0
            if (checkWall(p, listOf(0))) {
                cal_23289(Point_23289(p.r + dr_23289[0], p.c + dc_23289[0], p.dir), idx - 1, r, c)
            }
            // 오른아래 2,6
            if (checkWall(p, listOf(2,6))) {
                cal_23289(Point_23289(p.r + dr_23289[6], p.c + dc_23289[6], p.dir), idx - 1, r, c)
            }
        }
        1 -> {
            // 왼위 3,4
            if (checkWall(p, listOf(3,4))) {
                cal_23289(Point_23289(p.r + dr_23289[4], p.c + dc_23289[4], p.dir), idx - 1, r, c)
            }
            // 위 1
            if (checkWall(p, listOf(1))) {
                cal_23289(Point_23289(p.r + dr_23289[1], p.c + dc_23289[1], p.dir), idx - 1, r, c)
            }
            // 오른위 2,5
            if (checkWall(p, listOf(2,5))) {
                cal_23289(Point_23289(p.r + dr_23289[5], p.c + dc_23289[5], p.dir), idx - 1, r, c)
            }

        }
        2 -> {
            // 오른위 1,5
            if (checkWall(p, listOf(1,5))) {
                cal_23289(Point_23289(p.r + dr_23289[5], p.c + dc_23289[5], p.dir), idx - 1, r, c)
            }

            // 오른 2
            if (checkWall(p, listOf(2))) {
                cal_23289(Point_23289(p.r + dr_23289[2], p.c + dc_23289[2], p.dir), idx - 1, r, c)
            }
            // 오른아래 0, 6
            if (checkWall(p, listOf(0,6))) {
                cal_23289(Point_23289(p.r + dr_23289[6], p.c + dc_23289[6], p.dir), idx - 1, r, c)
            }
        }
        3 -> {
            // 왼위 1,4
            if (checkWall(p, listOf(1,4))) {
                cal_23289(Point_23289(p.r + dr_23289[4], p.c + dc_23289[4], p.dir), idx - 1, r, c)
            }

            // 왼 3
            if (checkWall(p, listOf(3))) {
                cal_23289(Point_23289(p.r + dr_23289[3], p.c + dc_23289[3], p.dir), idx - 1, r, c)
            }
            // 왼아래 0,7
            if (checkWall(p, listOf(0,7))) {
                cal_23289(Point_23289(p.r + dr_23289[7], p.c + dc_23289[7], p.dir), idx - 1, r, c)
            }
        }

    }

}

fun checkWall(p: Point_23289, list: List<Int>): Boolean {
    return if(list.size == 2)
        (!wallSet.contains(calWall_23289(p.r, p.c) + calWall_23289(p.r + dr_23289[list[0]], p.c + dc_23289[list[0]]))
                && !wallSet.contains(calWall_23289(p.r + dr_23289[list[0]], p.c + dc_23289[list[0]]) + calWall_23289(p.r + dr_23289[list[1]], p.c + dc_23289[list[1]])))
    else
        !wallSet.contains(calWall_23289(p.r, p.c) + calWall_23289(p.r + dr_23289[0], p.c + dc_23289[0]))
}

fun calWall_23289(x: Int, y: Int) = x * 100000 + y

data class Point_23289(
    val r: Int,
    val c: Int,
    val dir: Int,
)
