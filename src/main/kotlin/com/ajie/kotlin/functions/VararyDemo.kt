package com.ajie.kotlin.functions

/**
 * @author Ajie
 * @date 2023/3/22
 * @function
 */
fun main() {

    fun adb(vararg ints:Int){
        println("abc:${ints.contentToString()}")
    }

    fun adbArrays(ints:IntArray){
        println("adbArrays:${ints.contentToString()}")
    }

    adb()
    adbArrays(IntArray(0));
}