fun main() {
//    data()
//    arithmetic()
//    comparison()
//    classExample()
    arrayPractice()
}

fun data(){
    val text: String = "Hello World"   // 문자열
    println(text)

    val x: Int = 5                     // 정수 (자동 추론 시 Int)
    println(x)

    val y: Int = 5                     // 정수 (명시적으로 Int)
    println(y)

    val z: Float = 5F                  // 실수 (단정도, F 붙여야 함)
    println(z)

    val i: Double = 5.123              // 실수 (배정도)
    println(i)

    val bool: Boolean = true           // 논리형 (true/false)
    println(bool)

    val letter: Char = 'A'             // 문자 1개
    println(letter)

    val b: Byte = 127                  // 작은 정수 (-128 ~ 127)
    println(b)

    val s: Short = 32000               // 16비트 정수 (-32768 ~ 32767)
    println(s)

    val bigNumber: Long = 10000000000  // 큰 정수
    println(bigNumber)

    val numbers: Array<Int> = arrayOf(1, 2, 3, 4, 5)   // 배열
    println(numbers.joinToString())

    val names: List<String> = listOf("Kim", "Lee", "Park")   // 불변 리스트
    println(names)

    val mutableNames: MutableList<String> = mutableListOf("Kim", "Lee") // 가변 리스트
    mutableNames.add("Choi")
    println(mutableNames)
}

fun arithmetic() {
    var x = 10  // 변하는 값
    val y = 9   // 변하지 않는 값

    println(x / y)
    println(x + y)
    println(x % y)
    println(x - y)

    println(x++)
    println(x--)

    x = x + 5
    println(x)

    println(x.toDouble() / y)
}


fun comparison() {
    var x = 11
    var y = 9
    println(x == y) // false

    var a = 12
    var b = 12
    val areNumbersTheSame = a === b
    println(areNumbersTheSame) // true (Int는 캐싱됨, 객체라면 false일 수 있음)

    var z = 13
    // 안에 수식이 들어가야 하므로 {} 필요
    println("is z an even number? ${z % 2 == 0}") // false
}

data class MyClass(val value: Int)

fun classExample() {
    val a = MyClass(10)
    val b = MyClass(10)
    val c = a

    println(a == b)   // true : 값(내용)이 같으니까
    println(a === b)  // false: 서로 다른 객체(다른 메모리)
    println(a === c)  // true : 같은 인스턴스
}

fun logical() {
    val x1 = 10
    val y1 = 9

    println(x1 > 5 && y1 < 10)
    println(x1 > 5 || y1 > 10)
    println(!(x1 > 5))

    val x2 = 12
    val y2 = 12
    val areBothEven = (x2 % 2 == 0) && (y2 % 2 == 0)
    println("are both even? $areBothEven")
}


fun inputToOutput() {
    print("Enter your name: ")
    val name = readLine() ?: "Unknown" // null일 경우 대비
    println("Hello, $name!")

    println("Enter a number:")
    val input = readLine()
    val number = input?.toIntOrNull() // 문자열을 숫자(Int)로 바꾸는데, 만약 변환이 불가능하면 null을 반환

    if (number != null) {
        println("You entered: $number")
    } else {
        println("Invalid input")
    }
}

fun nullability() {
    println("Enter a number:")
    val input = readln()
    val number = input.toIntOrNull()

    val isEven = number?.let { it % 2 == 0 } ?: false
    println("Is the number even? $isEven")
    println("You entered: $number")

    val input2 = readln()
    val number2 = input2.toIntOrNull()?.inc()
    println("You entered: $number2")

    val input3 = readln()
    val number3 = input3.toIntOrNull()?.rem(2)?.equals(0)
    println("You entered: $number3")
}


fun condition(): String? {
    println("Enter a number:")
    val input = readln()
    val inputAsInt = input.toIntOrNull()

    if (inputAsInt == null) {
        println("Invalid input")
        return null 
    }

    // 짝수/홀수 판별
    if (inputAsInt % 2 == 0) {
        println("The number is even")
    } else {
        println("The number is odd")
    }

    println("Enter another number:")
    val input2 = readln()
    val inputAsInt2 = input2.toIntOrNull()

    if (inputAsInt2 == null) {
        println("Invalid input")
        return null 
    }

    val result = if (inputAsInt2 % 2 == 0) "even" else "odd"
    println("The number is $result")

    return result
}


fun whenExpression() {
    println("Enter a number:")
    val input = readln()
    val inputAsInt = input.toIntOrNull()

    val result = when {
        inputAsInt == null -> "Invalid input"
        inputAsInt % 2 == 0 -> "even"
        else -> "odd"
    }
    println("The number is $result")

    println("Enter your nation in English: ")
    val nation = readln()
    val greeting = when (nation.lowercase()) {
        "korea" -> "안녕하세요"
        "us", "uk" -> "Hello"
        "france" -> "Bonjour"
        "spain" -> "Hola"
        else -> "Hello"
    }
    println(greeting)
}


fun arrayPractice(){
    //코틀린 배열은 크기 고정.
    // push/pop 같은 동적 추가 삭제 지원 안함
    println("Enter an index (0 ~ 3):")
    val input = readln()
    val inputAsInteger = input.toIntOrNull() //문자열을 숫자로 변환하고, 실패하면 null로 처리
    val favoriteNumbers = intArrayOf(1, 2, 3, 69)

    if (inputAsInteger != null && inputAsInteger in favoriteNumbers.indices) {
        // null이 아니고 배열 범위 안에 있으면 출력
        println("Your number is ${favoriteNumbers[inputAsInteger]}")
    } else {
        println("Invalid input or out of range")
    }
}

fun mutableListPractice() {
    // 배열과 비슷하지만 동적으로 값 추가/삭제 가능
    val list = mutableListOf(1, 2, 3)

    // 끝에 추가
    list.add(4)
    println(list)      // [1, 2, 3, 4]

    // 끝에서 하나 떼어내기
    val last = list.removeLast()
    println(last)      // 4
    println(list)      // [1, 2, 3]

    // 원하는 인덱스 값 꺼내기
    println(list[1])   // 2

    // 원하는 인덱스 값 제거하기
    list.removeAt(0)
    println(list)      // [2, 3]

    // 리스트 크기 확인
    println(list.size) // 2
}

fun loopPractice() {
    // 1부터 5까지 범위 순회
    for (n in 1..5) {
        println("for-in range: $n")
    }
    println("-----")

    // 리스트 순회
    // list는 불변의 데이터다.
    val names = listOf("피카츄", "라이츄", "파이리")
    for (name in names) {
        println("List element: $name")
    }
    println("-----")

    // 배열 순회
    // array는 데이터 값은 바뀔 수 있지만 크기가 고정이다.
    val numbers = arrayOf(10, 20, 30)

    // 인덱스로 접근
    for (i in numbers.indices) {
        println("Index $i has value ${numbers[i]}")
    }

    // 인덱스와 값을 동시에
    for ((i, value) in numbers.withIndex()) {
        println("withIndex → $i: $value")
    }
    println("-----")

    // while
    var x = 0
    while (x < 5) {
        println("while loop: $x")
        x++
    }
    println("-----")

    // do-while 최소 1번은 실행한다.
    var y = 0
    do {
        println("do-while loop: $y")
        y++
    } while (y < 3)
}

fun userString(){
    //1. 사용자로부터 문자열을 입력받아 그대로 출력
    println("Enter a string: ");
    val input = readln()
    //2. 입력받은 문자열을 거꾸로 뒤집어서 출력
    val reversedInput = reverse(input)
    println("You entered: $input now reversed: $reversedInput")
}

fun reverse(input: String): String {
   val reversedInput = buildString { //buildString { } 안에서 append()를 하면 하나의 문자열로 합쳐짐
      append(input[i])
    }
    return reversedInput
}

// 확장 함수
// String 클래스에 reversed()라는 새로운 메서드를 추가
// "hello".reversed() 처럼 문자열에서 바로 호출 가능
// 확장 함수에서는 이미 대상 객체(this) 가 넘어와 있기 때문에 매개변수를 받을 필요가 없ㅇㅁ
fun String.reversed(): String {
    val finalString = buildString {
        for (i in lastIndex downTo 0) {
            //확장 함수 안에서 this는 현재 String 객체 자기 자신
            append(this@reversed[i])
        }
    }
    return finalString
}

fun exception() {
    try {
        println("Enter a number:")
        val input = readln()
        val number = input.toIntOrNull() 
            ?: throw IllegalArgumentException("Invalid number format") //잘못된 인수가 전달되었을 때의 예외
        
        println("You entered: $number")
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    } catch (e: Exception) {
        println("Unexpected error occurred")
    } finally {
        println("End of input")
    }
}

// 오버로딩된 함수
// 함수 오버로딩이란 동일한 이름의 함수를 여러 개 정의하는 것
// 매개변수의 타입이나 개수가 다르면 같은 이름을 사용할 수 있음
fun greet(name: String) {
    println("Hello, $name!")
}

fun greet(name: String, age: Int) {
    println("Hello, $name! You are $age years old.")
}

fun greet() {
    println("Hello, stranger!")
}

// 알아서 각자 적절함 매개변수가 있는 함수 호출함
fun callGreet() {
    greet("Alice")            
    greet("Bob", 25)          
    greet()                  
}

// 기본 매개변수와 null 허용 매개변수
// 함수 오버로딩 하지 않고 아래와 같이 하나의 함수로 처리 가능
fun greet2(name: String = "stranger", age: Int? = null) {
    if (age != null) {
        println("Hello, $name! You are $age years old.")
    } else {
        println("Hello, $name!")
    }
}

fun callGreet2() {
    greet2("Alice")
    greet2("Bob", 25)
    greet2()
}

//람다 함수
//{ 매개변수들 -> 함수 본문 }

fun lambdaExample() {
    val add: (Int, Int) -> Int = { a, b -> a + b }
    val result = add(3, 5)
    println("Result of addition: $result") 

    val square: (Int) -> Int = { x -> x * x }
    println("Square of 4: ${square(4)}")

    // Unit은 반환값이 없음을 나타냄
    val greet3: (String) -> Unit = { name -> println("Hello, $name!") }
    greet3("Kotlin") 

    // 매개변수가 하나일 때는 it 키워드 사용 가능
    // it은 람다식의 단일 매개변수를 가리킴
    val greet4: (String) -> Unit = { println("Hello, $it!") }
}


//클래스
//일반 클래스
//행위 중심
class NormalPerson(val name: String, val age: Int) {

    // equals(), hashCode(), toString(), copy() 같은 기능이 없음
    fun introduce() {
        println("안녕하세요, 제 이름은 $name이고, 나이는 $age살 입니다.")
    }
}

fun testNormalClass() {
    val n1 = NormalPerson("Tom", 20)
    val n2 = NormalPerson("Tom", 20)

    println("=== Normal Class ===")
    println(n1 == n2)          // false (내용 같아도 참조 다르면 false)
    println(n1.toString())     // NormalPerson@5a07e868 (주소값 출력)
    n1.introduce()
}

// 데이터 클래스
// 데이터 중심
// API 요청/응답 모델, 단순 상태(State)등 데이터가 중요시 될 때 사용함
// val / var은 그냥 개별 변수, data class는 관련된 데이터들을 하나의 "타입"으로 묶는 도구
data class DataPerson(val name: String, val age: Int)

fun testDataClass() {
    val d1 = DataPerson("Tom", 20)
    val d2 = DataPerson("Tom", 20)
    val d3 = d1.copy(age = 30) // copy 기능

    println("\n=== Data Class ===")
    println(d1 == d2)          // true (값 비교)
    println(d1.toString())     // DataPerson(name=Tom, age=20)
    println(d3)                // DataPerson(name=Tom, age=30)



    // 구조 분해
    val (name, age) = d1
    println("$name is $age years old")
}
