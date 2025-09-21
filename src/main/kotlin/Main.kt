fun main() {
    data()
    arithmetic()
    comparison()
    classExample()
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
    val x = 10
    val y = 9

    println(x > 5 && y < 10) // true
    println(x > 5 || y > 10) // true
    println(!(x > 5))        // false

    val x = 12
    val y = 12
    val areBothEven = (x % 2 == 0) && (y % 2 == 0)
    // 변수명이라 그냥 앞에 $ 붙여서 출력 가능
    println("is x an even number? $areBothEven") // true
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
    val number = input?.toIntOrNull() // 문자열을 숫자(Int)로 바꾸는데, 만약 변환이 불가능하면 null을 반환
ㄴ

    // val isEven = number?.let { it % 2 == 0 } ?: false
    val isEven = number!! % 2 == 0 // !!는 null이 아님을 보장, null이면 예외 발생, 실제로 null일 경우 프로그램이 강제로 종료
    println("Is the number even? $isEven")
    println("You entered: $number")

    val input2 = readln()
    val number2 = input2?.toIntOrNull()?.inc()  // 입력값을 Int로 변환, 변환 성공하면 1 증가, 실패하면 null
    //사용자가 1을 입력하면 toIntOrNull()로 1로 변환되고, inc()로 1이 더해져서 2가 출력 됨
    println("You entered: $number2")
  
    val input3 = readln()
    val number3 = input3?.toIntOrNull()?.rem(2)?.equals(0)
    // 변환 성공하면 2로 나눈 나머지를 구함
    // 그 나머지가 0이면 true(짝수), 아니면 false(홀수)
    // 만약 숫자로 변환이 안 되면 null
    // rem은 %와 같은 역할을 함

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
    val inputAsInt = input?.toIntOrNull()

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
