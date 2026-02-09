package part0.ch01

// null
// 코틀린의 핵심 특징 중 하나는 널 안전성(Null Safety)
// 런타임에 발생하는 NullPointerException (NPE)을 컴파일 시점에 감지하고 방지하기 위해 설계되었다.

fun main() {
    // 널 불가능 타입 (Non-Nullable Types): 기본적으로 선언되는 모든 타입은 널을 허용하지 않는다.
    var name: String = "JW"
    var number: Int = 10

    // 널 가능 타입 (Nullable Types): 타입 이름 뒤에 물음표(?)를 붙여 해당 변수가 널을 가질 수 있음을 명시한다.
    // 랭귀지 단에서 널의 유무를 나뉘어서 컴파일 단계에서 에러를 표시해준다.

    // 컴파일러는 Nullable 타입의 변수를 널 처리 없이 직접 접근하려 하면(예: nickname.length) 오류를 발생시킨다.
    // 널일 가능성이 있는 객체에 안전하게 접근하기 위해 다음 연산자들을 사용한다.
    var nickname: String? = null
    nickname = "jw"

    var secondNumber: Int? = null

//    val result = if (nickname == null) {
//        "no value"
//    } else {
//        nickname
//    }
//
//
    // elvis operator
    // 엘비스 연산자 (Elvis Operator) ?:
    // Nullable 타입을 다룰 때 null 대신 사용할 기본값을 지정한다.
    // 값이 null인 경우 오른쪽의 값을 가진다.
    // 용도: 널 대신 기본값을 제공하여 널 불가능 타입 변수에 값을 할당할 때 유용하다.
    var result = nickname ?: "no value"

    // 안전한 호출 연산자 (Safe Call Operator) ?
    // 만약 nickname이 null이면 null을, 아니면 값을 반환한다.
    // 이 표현식의 결과 타입은 Int? (Nullable Int)가 된다.
    var size = nickname?.length
    println(size)

    // 널 아님 단언 연산자 (Non-Null Assertion Operator) !!
    // 개발자가 해당 변수가 절대 null이 아님을 컴파일러에게 강제로 주장할 때 사용한다.
    size = nickname!!.length

    println(size)

//    println(result)
}