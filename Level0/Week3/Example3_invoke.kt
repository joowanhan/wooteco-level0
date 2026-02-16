package part0.ch02

class MyFunction {

    operator fun invoke(str: String) {
        println("나는 클래스지만 함수처럼 호출됐어: $str")
    }
}

fun main() {
    val obj = MyFunction()
    obj("Hello") // obj.invoke("Hello")와 같다.
}
