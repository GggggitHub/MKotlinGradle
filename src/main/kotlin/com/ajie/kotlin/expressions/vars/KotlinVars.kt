package com.ajie.kotlin.expressions.vars

const val b = 3
//只能定义在全局的范围
//只能修饰 基本类型
//必须立即 初始化。

class KotlinVars {
    companion object {
        const val b = 3
    }
}

object KotlinVars2 {
    const val b = 3
}


class X {
    val b: Int
        get() {
            return (Math.random() * 100).toInt()
        }
}

fun main() {
    var a = 2
    a = 3


    val b = 3


    val c: Int

    if (a == 3) {
        c = 4
    } else {
        c = 5
    }


    //堆上创建对象
    val person = Person(18, "Bennyhuo")
    person.age = 19 //对象内容改变。 引用没变
}

class Person(var age: Int, var name: String)