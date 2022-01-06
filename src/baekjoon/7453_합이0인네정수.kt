package baekjoon

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val aList = mutableListOf<Long>()
    val bList = mutableListOf<Long>()
    val cList = mutableListOf<Long>()
    val dList = mutableListOf<Long>()
    val abSumList = LongArray(n * n)
    val cdSumList = LongArray(n * n)

    (0 until n).forEach { _ ->
        val temp = readLine().split(' ').map { it.toLong() }
        aList += temp[0]
        bList += temp[1]
        cList += temp[2]
        dList += temp[3]
    }

    var idx = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            abSumList[idx] += aList[i] + bList[j]
            cdSumList[idx] += cList[i] + dList[j]
            idx++
        }
    }

    abSumList.sort()
    cdSumList.sortDescending()

    var abIdx = 0
    var cdIdx = 0
    var result: Long = 0
    var sumVal: Long
    val size = abSumList.size
    while (true) {
        if (abIdx == size || cdIdx == size) break
        sumVal = abSumList[abIdx] + cdSumList[cdIdx]
        when {
            sumVal == 0L -> {
                var abCnt: Long = 1
                var cdCnt: Long = 1
                while (true) {
                    if (++abIdx == size) break
                    if (abSumList[abIdx - 1] == abSumList[abIdx]) {
                        abCnt++
                    } else break
                }

                while (true) {
                    if (++cdIdx == size) break
                    if (cdSumList[cdIdx - 1] == cdSumList[cdIdx]) {
                        cdCnt++
                    } else break
                }
                result += (abCnt * cdCnt)
            }
            sumVal > 0 -> {
                cdIdx++
            }
            else -> {
                abIdx++
            }
        }
    }

    println(result)

}
