package kotlinStudy

import kotlinStudy.Expr.*
import java.lang.IllegalArgumentException
import java.lang.StringBuilder

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() = height == width
}

data class Person(val name: String, val age: Int)


fun main() {
//    val rectangle = Rectangle(10, 9)
//    println(rectangle.isSquare)

//    println(Color.RED.rgb())

//    println(eval(Sum(Sum(Num(3), Num(2)), Num(4))))

//    println("Kotlin".lastChar())

//    val list1 = arrayOf(1,2,3)
//    val listOf = listOf(0,*list1)
//    println(listOf)

//    val (number,name) = 1 to "one"
//    println("$number: $name")

//    val str = "12.345-6.A"
//    println(str.split("."))

//    val user = User(1, "a","a")
//    user.saveUser(user)

//    val people = listOf(Person("Alice", 29), Person("Bob", 31))
//    println(people.joinToString(" ") { it.name })

//    val createPerson = ::Person
//    val person = createPerson("bread", 1)
//    println(person)

//    println(people.count { it.age <= 29 })
//    println(alphabet())

//    printAllCaps("A")

//    val map = mapOf<Int,Int>(1 to 1, 2 to 2)
//    val maxOf = map.values.maxOf { it }
//    println(maxOf)

//    twoAndThree { x, y -> x + y }

    // 연습문제 3-1,2
//    val squareOfTriple = compose(::square, ::triple)
//    println(squareOfTriple(2))

    // 연습문제 3-3
//    val add: (Int) -> (Int) -> Int = { a -> { b -> a + b } }
//    println(add(3)(5))

//    val squareOfTriple2 = higherCompose<Int, Int, Int>()(::square)(::triple)

    HeadTailList().main()
}

class HeadTailList {
    fun main() {
        val list = listOf(1, 2, 3, 4)
        println(head(list))
        println(tail(list))
    }

    fun <T> head(list: List<T>): T {
        if (list.isEmpty())
            throw IllegalArgumentException("Head called on empty list")
        else
            return list[0]
    }

    fun <T> tail(list: List<T>): List<T> {
        if (list.isEmpty())
            throw IllegalArgumentException("Head called on empty list")
        else
            return list.drop(1)
    }
}


fun <T, U, V> higherCompose() =
    { f: (U) -> V ->
        { g: (T) -> U ->
            { x: T -> f(g(x)) }
        }
    }

fun <T, U, V> compose(f: (U) -> V, g: (T) -> U): (T) -> V = { f(g(it)) }

//fun compose(f: (Int) -> Int, g: (Int) -> Int): (Int) -> Int = { f(g(it)) }
fun triple(n: Int) = n * 3
fun square(n: Int) = n * n

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println(result)
}

fun printAllCaps(s: String?) {
    val allCaps = s?.toUpperCase()
    println(allCaps)
}


// apply
fun alphabet() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nend")
}.toString()

/*
// with
fun alphabet() = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nend")
    toString()
}
 */



fun String.lastChar() = get(length - 1)
fun max(a: Int, b: Int) = if (a > b) a else b


