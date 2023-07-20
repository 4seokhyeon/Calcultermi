import com.first.calcultermi.AddOperation
import com.first.calcultermi.Calculator
import com.first.calcultermi.SimpleEvaluator

fun main() {
    val addOperation = AddOperation()
    val calculator = Calculator(addOperation)
    val evaluator = SimpleEvaluator()

    while (true) {
        print("계산식을 입력하세요 (예: 1+2*3) 또는 'exit'을 입력하여 종료: ")
        val input = readLine() ?: ""

        if (input.equals("exit", ignoreCase = true)) {
            println("안녕히 가세요!")
            break
        }

        try {
            val (expression, result) = evaluator.evaluateExpression(input, calculator)
            println("$expression = $result")
        } catch (e: Exception) {
            println("오류: ${e.message}")
        }
    }
}