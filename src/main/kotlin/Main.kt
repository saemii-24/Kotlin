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