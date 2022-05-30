package com.ajie.kotlin.functions

/**
 * @author Ajie
 * @date 2022/3/29
 * @function  重载与多态
 * 只与扩展对象本身有关系，在编译时已经确定，不存在多态。
 */

open class Animal

class Dog : Animal()

fun Animal.desc() = "Animal"
fun Dog.desc() = "Dog"

fun main(args: Array<String>) {
    //如果扩展方法能够被重载，那么两次都应该输出 Dog，我们还是和前面方法一样，来看看真相。
    println(Dog().desc())

    var animal: Animal = Dog()
    println(animal.desc())
}

// output:
// Dog
// Animal
