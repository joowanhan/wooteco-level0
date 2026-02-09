// 일반 클래스
class NormalUser(val name: String, val age: Int)

// 데이터 클래스
data class DataUser(val name: String, val age: Int)

fun main() {
    val user1 = NormalUser("JW", 25)
    val user2 = NormalUser("JW", 25)

    // 1. equals 비교
    println("NormalUser 비교: ${user1 == user2}") // 결과: false (주소값이 다르므로)

    val data1 = DataUser("JW", 25)
    val data2 = DataUser("JW", 25)
    println("DataUser 비교: ${data1 == data2}") // 결과: true (값이 같으므로)

    // 2. toString 출력
    println(user1) // 결과: NormalUser@6d06d69c (알 수 없는 주소값)
    println(data1) // 결과: DataUser(name=JW, age=25) (읽기 쉬운 형태)

    // 3. copy() 활용 (불변성 유지하며 값 변경)
    val olderData = data1.copy(age = 26)
    println(olderData) // 결과: DataUser(name=JW, age=26)

    // 4. 구조 분해 할당
    val (name, age) = data1
    println("이름: $name, 나이: $age") // 결과: 이름: JW, 나이: 25
}
