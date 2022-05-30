package com.ajie.kotlin.types.classes

import com.ajie.kotlin.types.classes.kotlin.Person

/**
 * @author Ajie
 * @date 2022/5/29
 * @function
 * https://www.kotlincn.net/docs/reference/classes.html
 *
 * 在实例初始化期间，初始化块按照它们出现在类体中的顺序执行，与属性初始化器交织在一起：
 */
class InitOrderDemo(name: String) {
    var children: MutableList<Person> = mutableListOf()
    constructor(name: String, child: Person) : this(name) {
        children.add(child)
    }

    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints ${name}")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }


}