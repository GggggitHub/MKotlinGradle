package com.ajie.kotlin.ranges

fun main() {

    val intRange = 1..10 // [1, 10]
    val charRange = 'a'..'z'
    val longRange = 1L..100L
    println(intRange.joinToString())

    val floatRange = 1f .. 2f // [1, 2] //1.5 in 'floatRange'
    val doubleRange = 1.0 .. 2.0 //连续 1.5 in doubleRange
    println(floatRange.toString())
    if (1.5 in floatRange) {
        println("1.5 in 'floatRange'")
    }

    if (3.0 !in doubleRange) {
        println("3.0 !in 'doubleRange'")
    }
    if (1.5 in doubleRange) {
        println("1.5 in range 'intRange'")
    }else {
        System.err.println("1.5 not in range 'intRange'")
    }

    val uintRange = 1U..10U
    val ulongRange = 1UL..10UL

    val intRangeWithStep = 1..10 step 2 //1, 3, 5, 7, 9
    val charRangeWithStep = 'a'..'z' step 2
    val longRangeWithStep = 1L..100L step 5

    println("intRangeWithStep = 1..10 step 2 :>>"+intRangeWithStep.joinToString())

    val intRangeExclusive = 1 until 10 // [1, 10)
    val charRangeExclusive = 'a' until 'z'
    val longRangeExclusive = 1L until 100L

    println(intRangeExclusive.joinToString())

    val intRangeReverse = 10 downTo 1 // [10, 9, ... , 1]
    val charRangeReverse = 'z' downTo 'a'
    val longRangeReverse = 100L downTo 1L

    println(intRangeReverse.joinToString())

    for (element in intRange) {
        print(element)
        print("、")
    }
    println("---")

    intRange.forEach {
        print(it)
        print(",")
    }
    println("---")


    if (12 !in intRange) {
        println("12 not in range 'intRange'")
    }

    val array = intArrayOf(1, 3, 5, 7)
    for (i in 0 until array.size) {
        print(array[i])
        print(", ")
    }
    println("---")
    for(i in array.indices){//返回 [0,arraysize）
        print("  . $i 》》")
        print(array[i])
    }
}