package part0.ch01

fun main() {
    val user = User("JW")
    println(user.age)
    Kid("kiddo", 3, "male")


}

// 클래스

// 'open' 키워드는 이 클래스가 상속될 수 있음을 나타낸다.
// 클래스 헤더(header)에 주 생성자(primary constructor)를 직접 선언
// 코틀린은 자바와 달리 생성자를 클래스 이름 바로 옆에 선언할 수 있다. 이를 주 생성자(primary constructor)라고 하며, 클래스 정의와 동시에 객체 초기화에 필요한 핵심 데이터를 정의하는 방식이다.
open class User(open val name: String, open var age: Int = 100)
// 생성자 파라미터에 val(읽기 전용) 또는 var(수정 가능) 키워드를 붙이면, 해당 파라미터는 단순한 인자가 아니라 클래스의 속성(Property)으로 자동 선언 및 초기화된다.
// 즉, 별도의 멤버 변수를 선언하고 할당하는 코드를 작성할 필요가 없다.

// 상속(Inheritance)
// :(콜론)을 사용하여 부모 클래스를 지정하고, 부모 클래스의 생성자(User(name, age))를 호출
// Kid의 주 생성자에서 받은 name과 age는 User의 name과 age를 재정의(override)한다. (부모 속성이 open이어야 가능)
class Kid(override val name: String, override var age: Int) : User(name, age) {
    var gender: String = "female"

    // 초기화 블록 (Initializer Block)
    // 객체가 생성될 때(주 생성자가 호출될 때) 실행되는 코드 블록
    // 주 생성자에서 받은 파라미터를 검증하거나, 속성을 초기화하는 등 추가적인 로직을 수행할 때 사용
    // Fragment 초기화를 위해 사용됨
    init {
        println("초기화 중입니다.")
    }


    // 부 생성자(secondary constructor)
	// 클래스 본문 { ... } 안에 constructor 키워드를 사용하여 정의하는 추가적인 생성자
    // 주 생성자 외에 다른 방식으로 객체를 생성해야 할 때 사용한다.
	// 클래스에 주 생성자가 존재한다면, 부 생성자는 반드시 주 생성자를 직간접적으로 호출해야 한다. 이를 위해 : this(...) 구문을 사용한다. 이는 주 생성자가 정의한 필수 속성들의 초기화를 보장하기 위함이다.
    // 반드시 this(...) 키워드(괄호가 포함된 키워드)를 통해 주 생성자(또는 다른 부 생성자)를 호출해야 한다.
	// this(...) 키워드는 같은 클래스 내의 다른 생성자를 호출(Constructor Delegation) 할 때 사용하는 구문이다.
	// ------------------------------------------------------
	// 주의!!! this (괄호 없음): 현재 객체 참조 (Reference)
    // 괄호 없이 단독으로 쓰이거나 점(.)과 함께 쓰이는 this는 "지금 실행 중인 이 객체 인스턴스"를 의미한다.
    // ------------------------------------------------------
    constructor(name: String, age: Int, gender: String) : this(name, age) {
        this.gender = gender
        println("secondary constructor")
    }
	// 객체 생성 시 다양한 파라미터 조합을 허용하기 위해(오버로딩) 사용된다. 예를 들어, gender 없이 이름과 나이만으로 생성할 수도 있고(주 생성자 사용), gender까지 포함하여 생성할 수도 있게(부 생성자 사용) 하여 유연성을 제공한다. 다만, 코틀린에서는 디폴트 인자(Default Arguments)를 통해 부 생성자의 역할을 대체하는 경우가 많아, 부 생성자의 사용 빈도는 자바보다 낮다.

}