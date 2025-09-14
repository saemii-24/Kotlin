fun main() {
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
