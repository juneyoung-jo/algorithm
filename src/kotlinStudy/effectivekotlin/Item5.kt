package kotlinStudy.effectivekotlin

import kotlin.math.log

class TestStack<T> {

    private val size = 1
    private val isOpen = false

    fun pop(num: Int = 1): List<T> {
        require(num <= size) {
            "Cannot remove more elements than current size"
        }
        check(isOpen) { "Cannot pop from closed stack" }
        return listOf()
    }
}

class Person(val email: String?)

fun validateEmail(email: String) {}

fun sendEmail(person: Person, text: String) {
//    val email = requireNotNull(person.email)
//    validateEmail(email)

    val email = person.email ?: run {
        println("Error Log")
        return
    }
}


fun main() {
    val testStack = TestStack<Int>()
//    testStack.pop(100) // require
//    testStack.pop() // check
    val person = Person("hi")
    if(person?.email == "hi") {
        println("testStack = ${person.email}")
    }
}

