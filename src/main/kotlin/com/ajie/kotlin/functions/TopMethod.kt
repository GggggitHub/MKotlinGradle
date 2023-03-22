package com.ajie.kotlin.functions

/**
 * @author Ajie
 * @date 2023/3/22
 * @function 顶层函数
 *  定义在文件或包级别的函数，而不是定义在类或对象中。
 */
fun HelloTopMethod() {
    println("Hello, HelloTopMethod")
}

//: 操作符获取该函数的引用：
//val topMethod = com.ajie.kotlin.functions::HelloTopMethod
//fun helloTopRef(topMethod: com.ajie.kotlin.functions::HelloTopMethod){
//
//}

//kotlin
