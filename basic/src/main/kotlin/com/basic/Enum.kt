package com.basic

class Enum {
}

// 서로 연관된 상수들의 집합을 enum class 를 사용해서 정의할 수 있다.
// enum class 도 클래스이므로 생성자와 프로퍼티를 정의할 수 있습니다.
enum class PaymentStatus(val label: String): Payable {
    UNPAID("미지급") {
        override fun isPayable(): Boolean = true
    },
    PAID("지급완료") {
        override fun isPayable(): Boolean = false
    },
    FAILED("지급실패") {
        override fun isPayable(): Boolean = false
    },
    REFUNDED("환불") {
        override fun isPayable(): Boolean = false
    }; // 정의된 상수 목록 뒤에 함수를 정의할 경우 세미콜론을 붙여야한다.
}

interface Payable {
    fun isPayable(): Boolean
}

fun main() {

    if (PaymentStatus.UNPAID.isPayable()) {
        println("결제 가능 상태")
    }

    // valueOf 를 사용해서 enum 클래스를 생성할 수 있다.
    val paymentStatus = PaymentStatus.valueOf("PAID")
    println(paymentStatus.label)

    if (paymentStatus == PaymentStatus.PAID) {
        println("결제 완료 상태")
    }

    // enum 클래스의 상수를 나열하려면 values(): Array<EnumClass> 를 사용한다.
    for (status in PaymentStatus.values()) {
        println("[$status](${status.label}) : ${status.ordinal}")
    }

}
