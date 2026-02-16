# SAM (Single Abstract Method, 단일 추상 메서드) 변환

SAM은 추상 메서드가 오직 하나인 인터페이스를 의미한다. 자바의 함수형 인터페이스(Runnalbe, OnClickListener 등)가 이에 해당한다.

코틀린에서 함수 인터페이스를 람다로 넘기기     
*함수형 인터페이스: 추상 메서드가 하나인것

`val view = View(this)`

### 자바로 작성했을 때의 번거로움

자바에서는 인터페이스를 구현하기 위해 익명 내부 클래스(Anonymous Inner Class)를 사용해야 했다. 이는 불필요한 보일러플레이트 코드를 양산한다.

```
view.setOnClickListener(){
new View.OnClickListener(){
@Override
public void onClick(View: View){
// 내용 작성
}
}

}
```

### 코틀린으로 작성했을 때의 간편함 (코틀린의 SAM 변환)

코틀린은 자바의 SAM 인터페이스를 파라미터로 받는 메서드를 호출할 때, 익명 클래스 대신 람다식을 넘길 수 있도록 컴파일러 차원에서 지원한다. 이를 SAM 변환이라고 한다.   
작동 원리: 컴파일러가 람다식의 파라미터와 반환 타입을 분석하여, 해당 인터페이스의 유일한 추상 메서드와 매칭되면 자동으로 구현체를 생성해준다.    
인자가 하나뿐인 함수형 인터페이스인 부분을 인자로 받을 때, 람다식으로 간단히 받을 수 있다.

```
view.setOnClickListener(
{
// 내용 작성
}
)
```

후행 람다 (Trailing Lambda) 적용 (권장)
규칙: 함수의 마지막 매개변수가 함수 타입(또는 SAM 인터페이스)인 경우, 람다식을 소괄호 () 밖으로 빼낼 수 있다.
적용:

```
view.setOnClickListener {
// 내용 작성
}
```

이 문법 덕분에 코틀린 코드는 마치 언어 자체의 제어 구문(if, for)처럼 자연스럽게 읽히며, DSL(Domain Specific Language) 구축에도 유리하다.