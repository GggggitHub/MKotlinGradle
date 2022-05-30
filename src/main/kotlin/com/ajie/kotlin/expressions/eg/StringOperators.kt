package com.ajie.kotlin.expressions.eg

//del
operator fun String.minus(right: Any?)
        = this.replaceFirst(right.toString(), "")

//重复
operator fun String.times(right: Int): String {
    return (1..right).joinToString(""){ this }
}

//包含几次 ,滑动窗口。
operator fun String.div(right: Any?): Int {
    val right = right.toString()
    return this.windowed(right.length, 1, transform = {
        it == right
    }) // [false, false, false, false ... false, true, ..., true]
        .count { it }
}

fun main() {
    val value = "HelloWorld World"

    println(value - "World")
    println(value * 2)
    val star = "*"
    println("*" * 20) //20次

    println(value)//HelloWorld World
    println(value / 3) //0 包含 0次
    println(value / "l") //4
    println(value / "ld")//2
}

