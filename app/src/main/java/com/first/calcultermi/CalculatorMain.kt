import com.first.calcultermi.*
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val calculator = Calculator()
    println("----------------------계산기 입 니 다 . 종료 하 려 면 q 입력해요----------------------")

    while (true) {
        println("수식을 입력하십시오 ex) 1+2*3")
        val input = scanner.nextLine()

        try {
            // q입력시 종료
            if (input == "q") {
                println("계산기를 종료합니다")
                break
            }

            val result = evaluateExpression(input)
            println("입력한 식 : $input")
            println("결과: $result")
        } catch (e: Exception) {
            println("잘못된 입력 또는 연산 오류가 발생했습니다.")
        }
    }
}

fun evaluateExpression(expression: String): Int {  // evaluateExpression 메소드는 expression이라는 String형으로 선언 정수 값을 반환
    val tokens = mutableListOf<String>()  //mutableListOf는 입력을 변환 가능한 리스트로 함
    var currentNumber: String= ""

    for (char in expression) {// 입력 식에서 각 문자를 반복
        if (char.isDigit()) { // 문자가 숫자인경우
            currentNumber += char //번호에 문자열을 추가
        } else {
            if (currentNumber.isNotEmpty()) { //문자열이 비어있지 않은경우
                tokens.add(currentNumber) //리스트 목록에 추가
                currentNumber = ""
            }
            tokens.add(char.toString())
        }
    }


    val addSubResult = mutableListOf<String>()  //덧셈과 뺄셈일 경우 먼저 수행하는 로직 가변리스트로 중간 값을 저장하게함
    var i = 0  //토큰의 값을 0으로 초기화함
    while (i < tokens.size) {
        val token = tokens[i] //i에서 현재 토큰에 입력된 값을 가져옴
        if (token == "+" || token == "-") {  //+, - 인지 확인한다.
            val left = addSubResult.removeAt(addSubResult.size - 1).toInt() //addSubResult의 마지막 요소를 정수로 변환
            val right = tokens[i + 1].toInt() // 리스트에 입력된 다음 요소를 가져와서 정수로 변환함
            val result = if (token == "+") left + right else left - right   // + 연산자 이면 left + right를 실행
            addSubResult.add(result.toString())  // 실행한 값을 결과에 문자열로 저장함
            i += 2   // 'i' 인덱스를 2만큼 증가시켜 다음 숫자와 방금 처리된 연산자를 건너뛰게함
        } else {  //연산자가 없으면 그냥 추가하고 다음 연산을 처리
            addSubResult.add(token)
            i++
        }
    }


    var finalResult = addSubResult[0].toInt()
    i = 1
    while (i < addSubResult.size) {
        val token = addSubResult[i]
        if (token == "*" || token == "/") {
            try {
                val right = addSubResult[i + 1].toInt()
                finalResult = if (token == "*") finalResult * right else finalResult / right
                i += 2
            } catch (e: Exception) {
                println("잘못된 연산자")
                return finalResult
            }
        } else {
            println("잘못된 연산자")
            return finalResult
        }
    }

    return finalResult

}
