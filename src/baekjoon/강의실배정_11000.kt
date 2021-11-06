import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val pq = PriorityQueue<Lecture>()
    val endQ = PriorityQueue<Lecture>{o1,o2 -> o1.end - o2.end}

    for (i in 1..n) {
        val (s, t) = readLine().split(' ').map { it.toInt() }
        pq.add(Lecture(s, t))
    }

    while(pq.isNotEmpty()) {
        val nextLec = pq.poll()

        if(endQ.isNotEmpty() && endQ.peek().end <= nextLec.start) {
            endQ.poll()
        }

        endQ.add(nextLec)
    }

    println(endQ.size)
}

private data class Lecture(
    val start: Int,
    val end: Int
) : Comparable<Lecture> {
    override fun compareTo(o: Lecture): Int {
        if (o.start == this.start) {
            return this.end - o.end
        }
        return this.start - o.start
    }
}
