package kotlinStudy.effectivekotlin

open class Animal
class Zebra : Animal()

// 리턴타입을 확실하게 지정해야 함.
fun main() {
    var animal = Zebra()
//    animal = Animal() // Type missmatch

    var animal2: Animal = Zebra()
    animal2 = Animal()
}

