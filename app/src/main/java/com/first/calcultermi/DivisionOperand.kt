package com.first.calcultermi

class DivisionOperand : Operand{// 인터페이스를 상속 받아 나누기를 하는 메소드를 만듦
    override fun operate(a: Int, b: Int): Int {
        return a / b // 값을 나눈걸 리턴한다
    }

}