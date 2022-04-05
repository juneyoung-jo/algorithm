package kotlinStudy

import java.math.BigInteger

fun main() {
//    (0 until 100).forEach { println(fibonacci(it)) }
//    (0 until 100).forEach { println(fib(it)) }
    println(fib(100))
}


fun fib(x: Int): BigInteger {
    tailrec fun fib(val1: BigInteger, val2: BigInteger, x: BigInteger): BigInteger =
        when (x) {
            BigInteger.ZERO -> BigInteger.ONE
            BigInteger.ONE -> val1 + val2
            else -> fib(val2, val1 + val2, x - BigInteger.ONE)
        }

    return fib(BigInteger.ZERO, BigInteger.ONE, BigInteger.valueOf(x.toLong()))
}

private fun fibonacci(number: Int): Int {
    if (number == 0 || number == 1)
        return 1
    else
        return fibonacci(number - 1) + fibonacci(number - 2)
}
