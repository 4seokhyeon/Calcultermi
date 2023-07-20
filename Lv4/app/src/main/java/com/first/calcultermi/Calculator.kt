package com.first.calcultermi

class Calculator(private val operation: AbstractOperation) {
    fun calculate(a: Int, b: Int, abstractOperation: AbstractOperation): Int {
        return operation.operate(a, b)
    }
}
