package com.ajie.kotlin.expressions.lambdas

import kotlin.Function1

fun main() {
    //普通函数
    fun func1(){
        println("normal method hello")
    }

    fun(){//匿名函数
        println("hello 匿名 method")
    }

    //匿名函数的传递
    val func: () -> Unit = fun() {
        println("Hello")
    }

    //用变量，调用 匿名函数
    func()

    val lambda: () -> Unit = {
        println("Hello lambda () -> Unit =")
    }
    val lambda1 = {
        println("Hello lambda1 = ")
    }

    //匿名函数，语法糖
    val lambda2: (Int) -> Unit = {
        println("Hello lambda (Int) -> Unit "+it)
    }
    //函数 表达式参数类型，从，表达式类型，推断而来
//    val lambda3: Function1<Int,Unit> = {
    val lambda3: Function1<Int,Unit> = {
        println("Hello lambda Function1<Int,Unit> "+it)
    }
    lambda()
    lambda1()
    lambda2(2)
    lambda3(3)


    //表达式类型, 从 声明，推断而来。 返回 String
    val f1 = { p: Int ->
        println(p)
        "Hello"
    }
    println(f1(1))

    //    public inline constructor(size: Int, init: (Int) -> Int)
    // 接受一个 int 和  函数类型输入int返回int的。
    //构造方法
    IntArray(5) { it + 1 }
    var intArray1 = IntArray(5)
    var intArray2 = IntArray(5) { it + 1 }
}