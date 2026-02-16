package part0.ch02

// Lambda Expression
// 사용 예
// 1. 익명 함수(Anonymous Function)
// 2. 변수처럼 사용돼서, 함수의 argument 또는 return
// 3. 한번 사용되고 재사용되지 않는 함수

// 코틀린에서 함수는 일급 객체(First-class citizen)로 취급되므로, 변수에 저장하거나 함수의 인자로 전달하고 반환값으로 사용할 수 있다.

fun main() {
	val a = fun() { println("Hello") }
	
	// 명시적 매개변수
	val b: (Int) -> Int = { a -> a * 10 }
	
	// 암시적 매개변수 (매개변수가 하나뿐인 경우 가능)
	val b2: (Int) -> Int = { it * 10 }
	
	// 타입 추론: 변수 선언 시 타입을 명시하지 않아도, 람다식 내부 { i: Int, j: Int -> ... }에서 파라미터 타입을 지정하면 컴파일러가 변수 c의 타입을 (Int, Int) -> Int로 추론한다.
	val c = { i: Int, j: Int -> i * j }
	
	// 미사용 매개변수 처리: 람다식에서 사용하지 않는 매개변수는 언더스코어(_)로 표기한다. 이는 "이 변수는 사용하지 않음"을 명시하여 컴파일러 경고를 방지하고 가독성을 높인다.
	val d: (Int, String, Boolean) -> String = { _, b, _ -> b }
	
	// println(b(10))
	
	// 고차 함수 (Higher-Order Function)
	// 파라미터로 함수 받기: b: (Int) -> Int 파라미터는 정수를 받아 정수를 반환하는 함수를 인자로 요구한다. hello(10, b2) 호출 시 b2 람다식이 넘겨져 내부에서 b(20)으로 실행된다.
	hello(10, b2)
	
	// 함수 반환하기: 반환 타입이 (Int) -> Int로 선언되어 있다. 함수 내부 실행 후 return b를 통해 전달받은 함수 자체를 다시 반환한다. 따라서 hello2(10, b2)(30) 형태의 연쇄 호출이 가능하다.
	println(hello2(10, b2)(30))
	
}

inline fun hello(a: Int, b: (Int) -> Int) {
	println(a)
	println(b(20))
}

fun hello2(a: Int, b: (Int) -> Int): (Int) -> Int {
	println(a)
	println(b(20))
	return b
}
