package com.first.calcultermi

import java.util.Scanner


fun main() {
    val scanner = Scanner(System.`in`)

    println("첫번째 숫자를 입력하셈")
    val a =scanner.nextInt()

    println("두번째 숫자를 입력하셈")
    val b = scanner.nextInt()

    val addOperation = AdditionOperand()
    val subtractOperation = SubtractionOperand()
    val multiplyOperation = MultiplicationOperand()
    val divideOperation = DivisionOperand()

    val calculator = Calculator()

    println("덧셈 결과: ${calculator.calculate(a, b, addOperation)}")
    println("뺄셈 결과: ${calculator.calculate(a, b, subtractOperation)}")
    println("곱셈 결과: ${calculator.calculate(a, b, multiplyOperation)}")
    println("나눗셈 결과: ${calculator.calculate(a, b, divideOperation)}")
}