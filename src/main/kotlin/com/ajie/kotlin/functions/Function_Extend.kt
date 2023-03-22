package com.ajie.kotlin.functions

/**
 * @author Ajie
 * @date 2022/3/29
 * @function 扩展方法
 * 是能够直接访问扩展对象 public 的变量的
 *
 * 扩展是静态解析的
 * 不会根据，真实类型解析.
 */
fun main() {
    val first = "hello".first()
    println("result:"+first)

    //是能够直接访问扩展对象 public 的变量的
    var first1 = Function_Extend_Origin().first()
    println("main:"+first1)

    printClassName(Rectangle())

    var shape :Shape = Shape()
    var rectangle : Rectangle =Rectangle()
//    rectangle = shape;//type mismatch// 父类不能转换成子类。
    shape = rectangle;

    System.out.println(":main: ");
}

fun String.first() :Char{
    if (isEmpty()){
        throw NoSuchElementException("String is empty")
    }
    println("first:this:-->"+this)
    return this[0]
}

//新增扩展方法
fun Function_Extend_Origin.first() : Char{
    return this.name[0];
}

//扩展是静态解析的
//不会根据，真实类型解析
open class Shape{
    companion object {
        @JvmStatic fun getStaticName(): String {return "Shape-static"}
    }
    open fun test(){
        System.out.println("Shape:test: ");
    }
}

class Rectangle: Shape(){
    companion object {
        @JvmStatic fun getStaticName(): String {return "Rectangle-static"}
    }
    override fun test(){
        System.out.println("Rectangle:test: ");
    }
}

//扩展方法
fun Shape.getName() = "Shape"
fun Rectangle.getName() = "Rectangle"

fun printClassName(s: Shape) {
    println(s.getName())//Shape ，，扩展方法，静态解析。原因。扩展方法是 Static
    println(Shape.getStaticName())//Shape-static，，companion object,只能静态调用。
    println(Rectangle.getStaticName())//Rectangle-static
    println(s.test())//Rectangle:test:  方法覆写，动态解析。非静态。
}

