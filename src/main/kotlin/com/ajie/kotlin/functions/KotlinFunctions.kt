package com.bennyhuo.kotlin.builtintypes.functions


fun main(vararg args: String) {
    println(args.contentToString())


    val x0 = Foo()::bar //x0--> KFunction2<String, Long, Any>
    val x1 = Foo()::bar //x1--> KFunction2<String, Long, Any>
    //x2 x3 x4 相同。 没有把 Receiver 写成固定值。
    val x2 = Foo::bar   //x2--> KFunction3< Foo, String, Long, Any>
    val x3:(Foo, String, Long)->Any = Foo::bar //x3--> (Foo, String, Long) -> Any
    val x4: Function3<Foo, String, Long, Any> = Foo::bar // 与上面相等。把 receiver, Any 返回值 放到了参数列表。

    println(x0==x1) //false 因为 Receiver的【对象实例】不同
    println(x1==x2) //false 因为 Foo() 固定了 Receiver 【对象实例】。
    println(x2==x3) //true
    println(x3==x4) //true
    println("method equals:")
    val y: (Foo, String, Long) -> Any = x3
    val z: Function3<Foo, String, Long, Any> = x3

    var yy = yy(x3)
    println("yy(x3)>>"+yy) //yy(x3)>>hello12345

    val f: ()->Unit = ::foo
    val g: (Int) ->String = ::foo
    val h: (Foo, String, Long)->Any
            = Foo::bar

    //变长，参数
    val listOf = listOf(1, 2, 3)//val listOf : List<Int>
    multiParameters(1, 2, 3, 4)
    val arrayOf = arrayOf("h", "e", "l", "l", "o")
    multiParameters(arrayOf)

    defaultParameter(6, "HelloKt")
    defaultParameter(y = "Hello")

    val (a, b, c) = multiReturnValues() //伪
    val r = a + b
    val r1 = a + c

}



fun yy(p: (Foo, String, Long) -> Any):Any{
    return p(Foo(),"hello",12345L)
}

class Foo {
    fun bar(p0: String, p1: Long): Any{ return p0+p1.toString() }
}

fun foo() { }
fun foo(p0: Int): String { TODO() }

//具名参数，指定参数的具体名字。
//不传参数，使用默认值
fun defaultParameter(x: Int = 5, y: String, z: Long = 0L){//x: 5, y:Hello, z:0
    println("defaultParameter: x: $x, y:$y, z:$z")
}

//可变参数
fun multiParameters(vararg ints: Int){//ints 就是 IntArray
    println(ints.contentToString())//[1, 2, 3, 4]
}

fun multiParameters(arrayOf: Array<String>) {
    println(arrayOf.contentToString())//[h, e, l, l, o]
}

fun multiParameters(array: Array<Any>){
    println(array.contentToString())
}



fun multiReturnValues(): Triple<Int, Long, Double> {
    return Triple(1, 3L, 4.0)
}

