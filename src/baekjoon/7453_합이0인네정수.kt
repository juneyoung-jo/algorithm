package baekjoon

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val aList = mutableListOf<Long>()
    val bList = mutableListOf<Long>()
    val cList = mutableListOf<Long>()
    val dList = mutableListOf<Long>()
    val adSumList = mutableListOf<Long>()
    val cdSumList = mutableListOf<Long>()

    (0 until n).forEach {
        val temp = readLine().split(' ').map { it.toLong() }
        aList += temp[0]
        bList += temp[1]
        cList += temp[2]
        dList += temp[3]
    }


    for (i in 0 until n) {
        for (j in 0 until n) {
            adSumList += aList[i] + bList[j]
            cdSumList += cList[i] + dList[j]
        }
    }

    adSumList.sort()
    cdSumList.sortByDescending { it }


}
