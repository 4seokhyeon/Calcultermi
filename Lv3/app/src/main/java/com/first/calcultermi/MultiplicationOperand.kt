package com.first.calcultermi

class MultiplicationOperand :Operand{ // 마찬가지로 인터페이스를 상속 받아 곱셉을 하는 클래스 선언
    override fun operate(a: Int, b: Int): Int { // 곱셉을 하게되는 메소드
        return a * b
    }

}