package part0.ch02

// Scope Function (범위 지정 함수)
// let, run, with, apply, also

fun main() {
	
	// 1. let
	val a = 3
	a.let {
	
	}
	val user: User? = User("joowan", 10, true)
	val age = user?.let {
		user.age
	}
	println(age)
}

class User(
	val name: String,
	val age: Int,
	val gender: Boolean,
)