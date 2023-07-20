package com.first.calcultermi

class Calculator {
    fun calculate(a:Int,b:Int,operation: Operand):Int{ //Calculator 클래스의 메소드는 operation을
        // Operand 인터페이스를 상속 받음.
        return operation.operate(a,b) //a,b의 값을 리턴
    }
}