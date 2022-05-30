package com.bennyhuo.kotlin.builtintypes.basics

fun main() {

    var aInt = 2
    val bString = "Hello Kotlin"

//    val c = 12345678910l // compile error.
    val cLong = 12345678910L // ok

    val cFloat  = 3.0F;
    val dDouble = 3.0 // Double, 3.0f Float

    val e: Int = 10
    //val f: Long = e // implicitness not allowed
    val f: Long = e.toLong() // implicitness not allowed

    val float1: Float = 1f
    val double1 = 1.0

    val g: UInt = 10u
    val h: ULong = 100000000000000000u

    val i: UByte = 1u


    println("Range of Int: [${Int.MIN_VALUE}, ${Int.MAX_VALUE}]")
    println("Range of UInt: [${UInt.MIN_VALUE}, ${UInt.MAX_VALUE}]")

    val aInt2 = 128
    val aResult = UByte.MAX_VALUE - aInt2.toUInt()
    println("Range of UByte: [${UByte.MIN_VALUE}, ${UByte.MAX_VALUE}],(128-${UByte.MAX_VALUE}=)"+(aResult))

    val cChar = 'a';
    val cTest = 65534;//2^16==65536.
    println("Range of Char: [${Char.MIN_VALUE}, ${Char.MAX_VALUE}]"+(Char.MAX_VALUE - cTest.toChar()))


    val j = "I❤️China" //String
    println("Value of String 'j' is: $j") //--> Value of String 'j' is: I❤️China
    println("Length of String 'j' is: ${j.length}") //--> Length of String 'j' is: 8
    System.out.printf("Length of String 'j' is: %d\n", j.length)

    val k = "Today is a sunny day."
    val m = String("Today is a sunny day.".toCharArray())
    println(k === m) // compare references.
    println(k == m) // compare values.

    val n = """
                <!doctype html>
                <html>
                <head>
                    <meta charset="UTF-8"/>
                    <title>Hello World</title>
                </head>
                <body>
                    <div id="container">
                        <H1>Hello World</H1>
                        <p>This is a demo page.</p>
                    </div>
                </body>
                </html>
                """.trimIndent()

    println(n)
}