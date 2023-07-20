package com.first.calcultermi

import java.util.*

fun main() {
    val calculator = Calculator() // Calculator 클래스의 인스턴스 생성
    val scanner = Scanner(System.`in`) // 사용자 입력을 받기 위한 Scanner 생성

    while (true) {
        println("계산식을 입력하세요 (예: 1+2*3) 또는 'exit'을 입력하여 종료: ")
        val input = scanner.nextLine()

        // 'exit'을 입력한 경우 프로그램 종료
        if (input.equals("exit", ignoreCase = true)) {
            println("안녕히 가세요!")
            break
        }

        try {
            // 입력된 식 출력
            println("입력된 식: $input")
            // evaluateExpression 함수를 호출하여 입력된 식의 결과를 계산
            val result = evaluateExpression(input, calculator)
            // 계산 결과를 사용자에게 출력
            println("결과: $result")
        } catch (e: Exception) {
            // 계산 중에 오류가 발생한 경우 오류 메시지를 사용자에게 출력
            println("오류: ${e.message}")
        }
    }


}

fun evaluateExpression(input: String, calculator: Calculator): Int {
    // 입력된 계산식을 토큰화
    val tokens = input.split("\\s*(?<=[+\\-*/])|(?=[+\\-*/])\\s*".toRegex())

    // 숫자와 연산자를 분리하여 저장할 리스트들 생성
    val numbers = mutableListOf<Int>()
    val operators = mutableListOf<Operand>()

    for (token in tokens) {
        when {
            // 숫자인 경우 숫자 리스트에 추가
            token.matches(Regex("-?\\d+")) -> numbers.add(token.toInt())
            // '+'인 경우 AdditionOperand 인스턴스 생성 후 연산자 리스트에 추가
            token == "+" -> operators.add(AdditionOperand())
            // '-'인 경우 SubtractionOperand 인스턴스 생성 후 연산자 리스트에 추가
            token == "-" -> operators.add(SubtractionOperand())
            // '*'인 경우 MultiplicationOperand 인스턴스 생성 후 연산자 리스트에 추가
            token == "*" -> operators.add(MultiplicationOperand())
            // '/'인 경우 DivisionOperand 인스턴스 생성 후 연산자 리스트에 추가
            token == "/" -> operators.add(DivisionOperand())
            else -> throw IllegalArgumentException("잘못된 토큰: $token")
        }
    }

    // 연산자보다 숫자가 하나 더 많아야 유효한 식이므로 확인
    if (numbers.size != operators.size + 1) {
        throw IllegalArgumentException("잘못된 식입니다")
    }

    // Calculator를 사용하여 식을 한 단계씩 계산하여 결과 계산
    var result = numbers[0]
    for (i in operators.indices) {
        result = calculator.calculate(result, numbers[i + 1], operators[i])
    }

    // 최종 결과 반환
    return result
}
