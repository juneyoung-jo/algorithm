package baekjoon

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val list = readLine().toCharArray()
    val leftMap = mutableMapOf<Int, Int>()
    val rightMap = mutableMapOf<Int, Int>()

    val size = list.size - 1
    var result = 0
    var kCount = 0
    var rightKCount = 0
    list.forEachIndexed { index, c ->
        if (c == 'R') {
            leftMap[index] = kCount
            result++
        } else kCount++
        if (list[size - index] == 'R') rightMap[size - index] = rightKCount
        else rightKCount++
    }

    var left = 0
    var right = size
    var rCount = result
    while (rCount > 0) {
        if (list[left] != 'R') {
            left++
            continue
        }

        if (list[right] != 'R') {
            right--
            continue
        }

        when {
            leftMap[left] == rightMap[right] -> {
                result = max(result, rCount + leftMap[left]!! * 2)
                left++
                right--
                rCount -= 2
            }
            leftMap[left]!! > rightMap[right]!! -> {
                result = max(result, rCount + rightMap[right]!! * 2)
                right--
                rCount--
            }
            else -> {
                result = max(result, rCount + leftMap[left]!! * 2)
                left++
                rCount--
            }
        }
    }

    println(result)

}
