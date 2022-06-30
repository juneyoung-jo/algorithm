package programmers

class Solution_k진수에서소수개수구하기 {
    fun solution(n: Int, k: Int): Int {
        return n.toString(k)
            .split("0")
            .filter { it != "" && isPrime(it.toLong()) }
            .size
    }

    fun isPrime(number: Long): Boolean {
        if (number <= 1) return false
        for (i in 2..Math.sqrt(number.toDouble()).toLong()) {
            if (number % i == 0L) return false
        }
        return true
    }
}
