package com.basic

import kotlin.Exception

class Exception {
}

fun main() {

    // 코틀린은 checked exception 을 강제하지 않는다.
    Thread.sleep(1)

    // 원하는 경우에는 try-catch 를 쓸 수 있다.
    try {
        Thread.sleep(1)
    } catch (e: Exception) {
        println("예외 발생!")
    } finally {
        println("finally 실행!")
    }

    val a = try {
        "1234".toInt()
    } catch (e: kotlin.Exception) {
        println("예외 발생!")
    }
    println(a)

//    throw kotlin.Exception("예외 발생!")

    val b: String? = null
    val c: String = b ?: failFast("b is null")

    println(c.length)
}

fun failFast(message: String): Nothing { // Nothing 타입을 사용하면 컴파일러는 해당 코드 이후는 실행되지 않는다는 경고를 보여준다.
    throw IllegalArgumentException(message)
}
