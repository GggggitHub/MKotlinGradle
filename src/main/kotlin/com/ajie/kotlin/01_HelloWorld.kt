package com.ajie.kotlin

import JAVA_SRC_TEST
import kotlin.random.Random

//顶级函数 一等公民，不需要 receiver
fun main(){
//    var nextInt = Random(10).nextInt()//-129340023  ????
    var nextInt = Random(100).nextInt(10)//-129340023  ????
    println("Hello world. random ${nextInt}")
    var javaSrcTest = JAVA_SRC_TEST()
    javaSrcTest.main()
}
/**
 * @author Ajie
 * @date 2022/3/18
 * @function
 */
class HelloWorld {
    fun main(){
        print("Hello world")
    }
}