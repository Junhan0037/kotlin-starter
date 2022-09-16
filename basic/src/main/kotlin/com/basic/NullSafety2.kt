package com.basic

class NullSafety2 {
}

fun getNullStr(): String? = null

fun getLengthIfNotNull(str: String?) = str?.length ?:0

fun main() {
    val nullableStr = getNullStr()

    val nullableStrLength = nullableStr?.length ?:"null 인 경우 반환"
    println(nullableStrLength)

    println(getLengthIfNotNull(null))

    // 명시적 NPE 호출
    throw NullPointerException()

    // !! NotNull 임을 단언하는 단언 연사자를 사용
    val c: String? = null
    val d = c!!.length // NPE 발생

    println(getNullStr()?.length) // Nullable 가능성 염두

}
