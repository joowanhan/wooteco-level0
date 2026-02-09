package part0.ch01

// type check, casting
// 타입 확인(is), 타입 캐스팅(as, as?), 그리고 스마트 캐스트

fun main() {

//    object instanceof
//    object is type
	println(check("Hello"))
	println(check(3))
	println(check(true))
	
	cast("Hello")
	cast(123)
	
	println(smartcast("Hello"))
	println(smartcast(123))
	println(smartcast(true))
	
}

// 타입 확인 (Type Check - is)
// is 연산자는 런타임에 객체가 특정 타입인지 확인한다. 자바의 instanceof와 유사하다.
// 동작: [obj] is [Type]은 [obj]가 [Type]과 호환되면 true를, 아니면 false를 반환한다.
fun check(a: Any): String {
//    return if (a is String) {
//        "string"
//    }
//    else if (a is Int) {
//        "integer"
//    }
//    else {
//        "IDK"
//    }
	// when -> Example5 참고(switch문)
	return when (a) {
		is String -> {
			"string"
		}
		
		is Int -> {
			"integer"
		}
		
		else -> {
			"IDK"
		}
	}
}

// 타입 캐스팅 (Type Casting - as, as?)
// 타입을 명시적으로 변환(캐스팅)할 때 사용
fun cast(a: Any) {
	// 불안전한 캐스트 (Unsafe Cast): [a] as [String]  -> [a]를 [String] 타입으로 강제 변환한다.
	// 만약 [a]가 [String] 타입이 아니면 (예: Int) 런타임에 ClassCastException이 발생한다.
//    if (a is String) {
//        (a as String).length
//    }
	
	// 안전한 캐스트 (Safe Cast): [a] as? [String] -> [a]를 [String] 타입으로 변환하려 시도한다. 성공하면 변환된 값을, 실패하면 (타입이 맞지 않으면) null을 반환한다.
	// 예외를 발생시키지 않는다.
	// Elvis Operator를 연계사용 -> 캐스팅 실패 시 기본값을 지정하기에 유용
	val result = (a as? String) ?: "failed"
	println(result)
}

// smartcast
// 코틀린 컴파일러의 핵심 기능 중 하나이다.
// is로 타입을 확인하거나 as?로 캐스팅에 성공한 경우, 컴파일러는 해당 변수가 그 타입임을 "인지"
// 명시적인 캐스팅 없이도 해당 타입의 멤버에 접근할 수 있게 해준다.
fun smartcast(a: Any): Int {
	return if (a is String) {
		// 이미 String 인것을 확인했으므로 이 Bracket 안에서는 a를 String으로 처리한다.
		a.length
	} else if (a is Int) {
		a.dec()
	} else {
		-1
	}
}