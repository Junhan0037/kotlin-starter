package com.basic

class Interface {
}

class Product(val name: String, val price: Int)

interface Wheel {
    fun roll()
}

// 상위 인터페이스를 가질 수 있다.
interface Cart: Wheel {
    var coin: Int // 코틀린의 인터페이스는 프로퍼티가 존재할 수 있다.
    val weiggt: String
        get() = "20KG"

    fun add(product: Product)

    fun rent() {
        if (coin > 0) {
            println("카트를 대여합니다.")
        }
    }

    override fun roll() {
        println("카트가 굴러갑니다.")
    }

    fun printId() = println("1234")
}

interface Order {
    fun add(product: Product) {
        println("${product.name} 주문이 완료되었습니다.")
    }

    fun printId() = println("5678")
}

// 클래스는 하나 이상의 인터페이스를 구현할 수 있다.
class MyCart(override var coin: Int) : Cart, Order {
    override fun add(product: Product) {
        if (coin <= 0) println("코인을 넣어주세요.")
        else println("${product.name}이 카트에 추가됐습니다.")

        // 동일한 시그니처를 가진 함수가 있는경우 super<인터페이스> 를 사용해 호출할 수 있다.
        super<Order>.add(product)
    }

    // 두 인터페이스에 구현을 가진 동일한 디폴트 함수를 사용할 경우, 하위 클래스에서 직접 구현하도록 컴파일 오류가 발생한다.
    // 하위 클래스에서 직접 구현해서 인터페이스의 디폴트 함수를 사용하면 된다.
    override fun printId() {
        super<Cart>.printId()
        super<Order>.printId()
    }
}

fun main() {
    val cart = MyCart(coin = 100)
    cart.rent()
    cart.roll()
    cart.add(Product(name = "장난감", price = 1000))
    cart.printId()
}
