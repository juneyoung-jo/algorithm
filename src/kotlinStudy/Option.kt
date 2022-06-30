package kotlinStudy

import kotlin.concurrent.thread

fun main() {
//    val lock = Any()
//    var num = 0
//    for (i in 1..1000) {
//        thread {
//            Thread.sleep(10)
//            num += 1
//            synchronized(lock) { num += 1 }
//        }
//    }
//    Thread.sleep(1000)
//    println(num)

//    val list = listOf(1, 2, 3)
//    if (list is MutableList) {
//        list.add(4)
//    }
//    println(list)

//    var list = listOf<Int>()
//    for (i in 1..1000) {
//        thread {
//            list = list + i
//        }
//    }
//
//    println(list.size) // 1000이 안 나옴.
    // -from=2014-07-19T00:00:00 -to=2014-07-19T23:59:59

//    val primes: Sequence<Int> = sequence {
//        var numbers = generateSequence(2) { it + 1 }
//
//        while (true) {
//            val prime = numbers.first()
//            yield(prime)
//            numbers = numbers.drop(1)
//                .filter { it % prime != 0 }
//        }
//    }
//    println(primes.take(10).toList())

    /**/
    class User(
        val name: String,
        val surname: String
    ) {
        fun withSurname(surname: String) = User(name, surname)
    }

    var user = User("jo", "june")
    println(user)
    user = user.withSurname("youg")
    println(user)




}


