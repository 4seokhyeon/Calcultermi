import com.first.calcultermi.*
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val calculator = Calculator()

    while (true) {
        println("첫번째 숫자를 입력하셈 (끝내려면 'q' 입력)")
        val firstInput = scanner.next()

        if (firstInput == "q") {
            break
        }

        val a = firstInput.toInt()

        println("두번째 숫자를 입력하셈")
        val b = scanner.nextInt()

        println("+,-,*,/ 연산자를 입력하세요 (끝내려면 'q' 입력)")
        val operator = scanner.next()[0]

        if (operator == 'q') {
            break
        }

        val operand = when (operator) {
            '+' -> AdditionOperand()
            '-' -> SubtractionOperand()
            '*' -> MultiplicationOperand()
            '/' -> DivisionOperand()
            else -> {
                println("잘못된 연산자")
                continue
            }
        }

        println("결과: ${calculator.calculate(a, b, operand)}")
    }
}
