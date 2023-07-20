package com.first.calcultermi

class Calculator {
    fun calculate(a: Int, b: Int, operation: Operand): Int {
        return operation.operate(a, b)
    }
}
