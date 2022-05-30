package com.ajie.kotlin.functions

/**
 * @author Ajie
 * @date 2022/3/29
 * @function  扩展属性
kotlin 并不能真的给扩展对象添加一个属性，而只是提供了一个语法糖 。静态方法
 */
fun main() {
    "Hello, World".first = 'G'
    println("Hello,World".first) //没有打印出 G
}

var String.first: Char
    get() {
        if (isEmpty()) {
            throw NoSuchElementException("String is empty")
        }
        return this[0]
    }
    set(value) {
        println("set value to $value")
    }

