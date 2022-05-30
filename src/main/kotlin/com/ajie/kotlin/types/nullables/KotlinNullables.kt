package com.ajie.kotlin.types.nullables

import java.io.File

fun main() {
//    var nonNull: String = "Hello"
//    // nonNull = null
//    val length = nonNull.length

//    var nullable: String? = "Hello"
    var nullable: String? = null
//    val length = nullable!!.length //直接 exception
    val length = nullable?.length ?: 0 //elvis  boolean? a : b

    System.out.println(":main: $length");



//里氏替换原则，任何基类可以出现的地方。子类一定可以出现。
//    String : String?() //不可控 ：可空。 不可控加了更多的限制
    var x: String = "Hello"
    var y: String? = "World"//

//    x = y // Type mismatch
    y = x // OK

    var a: Int = 2
    var b: Number = 10.0

//    a = b // Type mismatch
    b = a // OK


    val person : PersonA = PersonA()
    val title = person.title // null

    val titleLength = title?.length // null

    val file = File("abc")

    val files = file.listFiles()
    println(files?.size)// null ，kotlin 针对平台类型最好 判空。
    println(files.size)// NullPointerException














}

