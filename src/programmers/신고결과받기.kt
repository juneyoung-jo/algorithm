package programmers


fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
    return report.map { it.split(' ') }
        .groupBy { it[1] } // frodo=[[muzi, frodo], [apeach, frodo]]\n neo=[[frodo, neo], [muzi, neo]]\n muzi=[[apeach, muzi]]
        .asSequence()
        .map { it.value.distinct() } // [[muzi, frodo], [apeach, frodo]\n [[frodo, neo], [muzi, neo]]\n [[apeach, muzi]]
        .filter { it.size >= k }
        .flatten() // [muzi, frodo], [apeach, frodo], [frodo, neo], [muzi, neo]
        .map { it[0] }
        .groupingBy { it }
        .eachCount()
        .run { id_list.map { getOrDefault(it, 0) } }.toIntArray()
}

fun main() {
    val idList = arrayOf("muzi", "frodo", "apeach", "neo")
    val report = arrayOf("muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi")
    solution(idList, report, 2)
}

private fun solution2(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
    val v = mutableMapOf<String, Int>()
    val vMap = mutableMapOf<String, Int>()
    val s = report.distinct()
    s.forEach {
        val (_, from) = it.split(' ')
        v.merge(from, 1, Integer::sum)
    }

    val keys = v.filter { it.value >= k }.keys

    s.forEach {
        val (to, from) = it.split(' ')
        if (keys.contains(from)) {
            vMap.merge(to, 1, Integer::sum)
        }
    }


    return id_list.map { vMap[it] ?: 0 }.toIntArray()
}
