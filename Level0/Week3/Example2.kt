package part0.ch02

// 확장함수 (Extension function)
// 기존에 정의되어 있는 클래스에 함수를 추가하는 기능
// 라이브러리에서 클래스를 가져와서 사용 할 때 유용함

class Test() {
	
	fun hello() = println("Hello")
	fun bye() = println("bye")
	
}

fun Test.hi() = print("Hi")

fun main() {
	Test().hello()
	Test().hi()
	
}