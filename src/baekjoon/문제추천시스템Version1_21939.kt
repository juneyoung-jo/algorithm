package baekjoon

import java.lang.StringBuilder
import java.util.*

const val digits = 1000000
fun main() = with(System.`in`.bufferedReader()) {
    val set = TreeSet<Int>()
    val map = mutableMapOf<Int, Int>()
    val sb = StringBuilder()

    (1..readLine().toInt()).forEach { _ ->
        val (number, level) = readLine().split(" ").map { it.toInt() }
        val problem = computeProblem(number, level)
        set += problem
        map[number] = problem
    }

    (1..readLine().toInt()).forEach { _ ->
        val arr = readLine().split(" ")
        when (arr[0]) {
            "add" -> {
                map[arr[1].toInt()] = arr[2].toInt()
                set += computeProblem(arr[1].toInt(), arr[2].toInt())
            }
            "solved" -> set.remove(map[arr[1].toInt()])
            else -> if (arr[1].toInt() == 1) sb.append("${set.last() % digits}\n") else sb.append("${set.first() % digits}\n")
        }
    }

    println(sb)
}

private fun computeProblem(number: Int, level: Int) = number + level * digits
