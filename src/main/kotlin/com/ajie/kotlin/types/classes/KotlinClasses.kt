package com.ajie.kotlin.types.classes

import com.ajie.kotlin.types.classes.kotlin.Person
import com.ajie.kotlin.types.classes.kotlin.SimpleClass
import com.ajie.kotlin.types.classes.kotlin.SimpleClass2

fun main() {
    var initOrderDemo = InitOrderDemo("张三")
//    InitOrderDemo("张三", Person(18,"zhangsan"))

    val simpleClass = SimpleClass(9, "Hello")
//    val simpleClass = SimpleClass2(9, "Hello")
    println(simpleClass.simpleProperty)
    println(simpleClass.x)
    println(simpleClass.y)
    println(simpleClass.z)
    simpleClass.y()
    simpleClass.overridable()
    simpleClass.zzz("Sleeping ZZZ!")
}

