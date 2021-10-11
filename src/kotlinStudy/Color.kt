package kotlinStudy

enum class Color(
    val r: Int,
    val g: Int,
    val b: Int
) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0)
    ;

    fun rgb() = (r * 256 + g) * 256 + b
}
