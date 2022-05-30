package com.ajie.kotlin.types.classes.kotlin

interface SimpleInf {

    //只能 init 1次。不能 set(value)
    val simpleProperty: Int // property

    fun simpleMethod()
}