package com.basic

class NullSafety {
}

fun main() {

//    val a: String = null // 컴파일 오류
//    var b: String = "aabbcc"
//    b = null // 컴파일 오류

    var a: String? = null
//    println(a.length) // 컴파일 오류
    println(a?.length) // safe-call 연산자

    val b: Int = if (a != null) a.length else 0

    // 엘비스 연산자를 사용하면 죄변이 null 인 경우 우변을 리턴한다.
    val c = a?.length ?:0

}
