package com.ajie.kotlin.collection_kt

/**
 * @author Ajie
 * @date 2023/3/22
 * @function
 */
fun main() {
    var arrayOf = arrayOf(1, 2, 5)
    println(" in arrayOf:${1 in arrayOf}")
    var setOf = setOf(1, 2, 5)
    println(" in setOf :${1 in setOf}")
    var mapOf = mapOf(1 to 11, 2 to 22, 5 to 55)
    println(" in mapOf :${1 in mapOf}")
    println(" in mapOf.keys :${11 in mapOf.keys}")
    println(" in mapOf.values :${11 in mapOf.values}")
}