package com.first.calcultermi

abstract class AbstractEvaluator {
    abstract fun evaluateExpression(input: String, calculator: Calculator): Pair<String, Int>
}

class SimpleEvaluator : AbstractEvaluator() {
    override fun evaluateExpression(input: String, calculator: Calculator): Pair<String, Int> {
        val tokens = input.split("\\s*(?<=[+\\-*/])|(?=[+\\-*/])\\s*".toRegex())
        val numbers = mutableListOf<Int>()
        val operators = mutableListOf<AbstractOperation>()

        for (token in tokens) {
            when {
                token.matches(Regex("-?\\d+")) -> numbers.add(token.toInt())
                token == "+" -> operators.add(AddOperation())
                token == "-" -> operators.add(SubtractOperation())
                token == "*" -> operators.add(MultiplyOperation())
                token == "/" -> operators.add(DivideOperation())
                else -> throw IllegalArgumentException("잘못된 토큰: $token")
            }
        }

        if (numbers.size != operators.size + 1) {
            throw IllegalArgumentException("잘못된 식입니다")
        }

        var result = numbers[0]
        for (i in operators.indices) {
            result = calculator.calculate(result, numbers[i + 1], operators[i])
        }

        return Pair(input, result)
    }
}
