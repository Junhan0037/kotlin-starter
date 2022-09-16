package com.basic

class ClassProperty {
}

// 생성자는 기본 생성자와 하나 이상의 보조 생성자가 존재할 수 있다.
// constructor 생략 가능
// 후행 쉼표를 사용할 수 있다.
// var 로 선언된 파라미터는 getter, setter 를 자동으로 생성한다.
class Coffee(
    var name: String = "", // 기본 값 추가
    var price: Int = 0,
    var iced: Boolean = false,
    ) {

    val brand: String
        get() {
            return "스타벅스"
        }

    var quantity: Int = 0
        set(value) {
            if (value > 0) {
                field = value // field 라는 식별자를 사용해 필드의 참조에 접근 (재귀 호출 방지)
            }
        }
}

// 본문을 생략할 수 있다.
class EmptyClass

fun main() {
    val coffee = Coffee()
    coffee.name = "아이스 아메리카노"
    coffee.price = 2000
    coffee.quantity = 1
    coffee.iced = true

    if (coffee.iced) {
        println("아이스 커피")
    }

    println("${coffee.brand} ${coffee.name} 가격은 ${coffee.price} 수량은 ${coffee.quantity}")
}
