package programmers

class 신규아이디추천 {

    fun solution(new_id: String): String {
        return new_id.toLowerCase()
            .replace("[^a-z0-9-_.]".toRegex(), "")
            .replace("[.]{2,}".toRegex(), ".")
            .replace("^[.]|[.]$".toRegex(), "")
            .ifEmpty { "a" }
            .chunked(15)[0]
            .removeSuffix(".")
            .let { it.padEnd(3, it.last()) }
    }

}

