package com.ajie.kotlin.expressions.operators

import com.ajie.kotlin.expressions.vars.Person

fun main() {
    //https://kotlinlang.org/docs/reference/operator-overloading.html

    "Hello" == "World"
    "Hello".equals("World")
    System.out.println(":main: =="+("hello"=="hello"));//true
    System.out.println(":main: ==="+("hello"==="hello"));//true
    System.out.println(":main: Person==="+(Person(1,"1")=== Person(1,"1")));//false
    System.out.println(":main: equals:"+("hello".equals("hello")));//true

    2 + 3
    2.plus(3)

    val list = listOf(1, 2, 3, 4)

    2 in list

    list.contains(2)

    val map = mutableMapOf(
        "Hello" to 2,
        "World" to 3
    )
    val value = map["Hello"]

//    val value = map.get("Hello")

    map["World"] = 4
    map.set("World", 4)


    val func = fun(){
        println("Hello func method")
    }

    2 > 3
    2.compareTo(3) > 0

    func.invoke()

    func()

    var pair = 2 to 3
    pair.first
    pair.second

    var to = 2.to(3)




    println("HelloWorld" rotate 5)

    val book = Book()
    val desk = Desk()
    book on desk

}

infix fun String.rotate(count: Int): String {
    val index = count % length
    return this.substring(index) + this.substring(0, index)
}

class Book
class Desk

infix fun Book.on(desk: Desk){

}
