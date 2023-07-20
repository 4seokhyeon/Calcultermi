package com.first.calcultermi

class SubtractionOperand : Operand{ // 상속받아 사용
    override fun operate(a: Int, b: Int): Int {  //메소드를 오버라이드 하여 코드 재사용성에 용이
        return a - b // 결과를 리턴
    }


}
