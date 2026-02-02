package part0.ch01

fun main() {
    max3(1, 2)
    isHoliday("fri")
	isHoliday(3)
}

// 조건식
fun max(a: Int, b: Int) {
    if (a > b) {
        println(a)
    } else {
        println(b)
    }
}

// 조건식 -> 조건표현(expression)
// return 값이 Unit
fun max2(a: Int, b: Int) {
    // println의 반환 값인 Unit이 result에 할당
    val result = if (a > b) {
        println(a)
    } else {
        println(b)
    }
    println(result)
}

// 자바에서는 조건문(state)로, 코틀린에서는 표현식(expression)으로 값을 꺼낼 수도 있다!

// 3항연산자처럼 사용하기
// if가 expression으로 사용됨
fun max3(a: Int, b: Int) {
    val result = if (a > b) a else b
    println(result)
}

//switch -> when expression
// mon tue wed thu fri sat sun
fun isHoliday(dayOfWeek: Any) {
    val result = when (val day = dayOfWeek) {
        "mon", "tue", "wed" -> false
        "sat", "sun" -> if (day == "sat") "nice" else "bad"
        in 2..4 -> {
            "YEAH"
        }

        in listOf("thu", "fri") -> "thufri!"

        else -> false
    }
    println(result)

}