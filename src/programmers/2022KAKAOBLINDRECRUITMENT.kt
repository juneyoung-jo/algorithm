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

class Solution_양궁대회 {
    var answer: IntArray  = intArrayOf(-1)
    var maxValue = 0
    fun solution(n: Int, info: IntArray): IntArray {
        val resultArray = IntArray(11)
        dfs(0, n, 0, 0, info, resultArray)
        return answer
    }

    fun checkResult(resultArray: IntArray) : Boolean {
        if(answer.size == 1) return true
        for(i in 0..10) {
            if(resultArray[10-i] == answer[10-i]) continue
            else return resultArray[10-i] < answer[10-i]
        }
        return false
    }

    fun dfs(index: Int, n: Int, aResult: Int, bResult: Int, info: IntArray, resultArray: IntArray)  {
        if(index == 11) {
            if(aResult < bResult && bResult - aResult > maxValue) {
                maxValue = bResult - aResult
                resultArray[10] += n
                answer = resultArray.copyOf()
                resultArray[10] -= n
            } else if(aResult < bResult && bResult - aResult == maxValue) {
                resultArray[10] += n
                if(!checkResult(resultArray)) {
                    answer = resultArray.copyOf()
                }
                resultArray[10] -= n
            }
            return
        }

        var result = aResult
        if(info[index] > 0) result += 10-index
        dfs(index+1, n, result, bResult, info, resultArray)

        if(info[index] < n) {
            resultArray[index] = info[index] + 1
            dfs(index+1, n-info[index]-1, aResult, bResult+10-index, info, resultArray)
            resultArray[index] -= info[index] + 1
        }

    }
}
