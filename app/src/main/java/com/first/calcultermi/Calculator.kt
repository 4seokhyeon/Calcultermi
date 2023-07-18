package com.first.calcultermi

class Calculator {
    fun calculate(a:Int,b:Int,operation: AbstractOperation):Int{
        return operation.operate(a,b)
    }
}