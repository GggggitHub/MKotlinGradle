package com.ajie.kotlin.functions_advanced.extensions

import java.io.File

class Person(var name: String, var age: Int)

fun main() {
    val person = Person("benny", 20)

    person.let(::println)
    person.run(::println)

    val person2 = person.also {
        it.name = "hhh"
    }
    System.out.println(":main: also person2 :${person2.name}  person:"+person +" person2:"+ person2);

    val person3 = person.apply {
        name = "xxx"
    }
    System.out.println(":main: also person3 :${person3.name}  person:"+person +" person3:"+ person3);
    System.out.println(":main: also person :${person.name} ");


    var use = File("build.gradle").inputStream().reader().buffered()
        .use {
            it.readLines()
//            println(it.readLines())
        }
    //打印内容 与上面相同。
    System.out.println(":main: use read result: $use");


}