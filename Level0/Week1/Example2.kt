package part0.ch01

fun main() {
    println(times(3, 4))


}

// 2. 함수
// overloading
fun test(a: Int, b: Int = 3, c: Int = 5): Int {
    println(a * b * c)
    return a + b + c

}

// single expression
fun times(a: Int, b: Int) = a * b