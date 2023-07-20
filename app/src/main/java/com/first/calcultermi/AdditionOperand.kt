package com.first.calcultermi

class AdditionOperand: Operand {   // 더하기 메소드
    override fun operate(a: Int, b: Int): Int { //a,b를 오버라이드 하여 자료형을 int형으로 주었다. operate의 기능으로 a와b를 더하는 메소드를 만듦
        return a + b
    }

}