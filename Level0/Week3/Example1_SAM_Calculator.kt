package part0.ch02

// SAM(Single Abstract Method)

// https://blog.naver.com/2oowan/224119206806

// [1] SAM 인터페이스 정의 (주문서 양식)
// 'fun' 키워드를 interface 앞에 붙이면 "이건 함수형 인터페이스(SAM)다"라고 명시하는 것이다.
fun interface MyCalculator {
	
	// 추상 메서드 (빈 칸): "숫자 두 개(Int)를 받아서 결과(Int)를 내놓는다"는 규칙만 있음.
	fun calculate(num1: Int, num2: Int): Int
	
}

// [2] 고차 함수 정의 (계산기 기계)
// 이 함수는 '숫자 두 개'와 '계산 규칙(MyCalculator)'을 받아서 실행한다.
fun runCalculation(a: Int, b: Int, calculator: MyCalculator) {
	val result = calculator.calculate(a, b) // 여기서 전달받은 규칙(람다)이 실행됨
	println("계산 결과: $result")
}

fun main() {
	
	println("=== SAM 변환 테스트 ===")
	
	// [3] 람다식으로 호출 1: 덧셈
	// runCalculation을 부를 때, MyCalculator의 'calculate' 내용을 람다로 즉석에서 구현함.
	runCalculation(10, 5) { x, y ->
		x + y // 빈 칸을 '덧셈'으로 채움
	}
	
	// [3] 람다식으로 호출 2: 뺄셈
	// 똑같은 함수지만, 다른 내용을 채워 넣음.
	runCalculation(10, 5) { x, y ->
		x - y // 빈 칸을 '뺄셈'으로 채움
	}
	
	// [3] 람다식으로 호출 3: 곱셈 (매개변수 이름 변경 가능)
	runCalculation(10, 5) { a, b ->
		a * b // 빈 칸을 '곱셈'으로 채움
	}
	
	// SAM 변환시 컴파일러가 실제로 해석하게 되는 코드
	runCalculation(10, 5, object : MyCalculator { // 1. 인터페이스를 구현하는 객체를 즉석에서 만듦
		// 2. 유일한 메서드인 'calculate'를 오버라이드함
		override fun calculate(num1: Int, num2: Int): Int {
			// 3. 람다에 적었던 { x + y } 내용을 여기에 집어넣음
			val x = num1
			val y = num2
			return x + y
		}
	})
	// 람다식의 { x, y -> x + y } 부분은 사실 override fun calculate(...) 함수의 본문(Body)으로 쏙 들어가는 것이다.
	// 이 귀찮은 object : ... override fun ... 껍데기 작성을 코틀린이 대신 해주는 것이다.
}

