package kotlinStudy

import kotlinStudy.Expr.*
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
    println(alphabet())

}

fun alphabet() = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nend")
    toString()
}


fun String.lastChar() = get(length - 1)
fun max(a: Int, b: Int) = if (a > b) a else b


