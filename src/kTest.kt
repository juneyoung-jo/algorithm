fun main() {
    val languages = arrayListOf("Java") // 불변 참조를 선언한다.
    languages.add("Kotlin")
    val str : String
    str = "hi"
    languages.forEach{s-> println(s)}
}
