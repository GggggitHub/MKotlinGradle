package com.ajie.kotlin.functions_advanced.highorderfuncs

fun main() {
    cost {
        val fibonacciNext = fibonacci()
        for (i in 0..10) {
            println(fibonacciNext())
        }
    }

    // region +折叠
    val intArray = IntArray(5){ it + 1 }
    intArray.forEach {
        print("$it ,")
    }

    //常见的 高阶 函数，入参 函数。
    intArray.forEach(::println)
    //public inline fun IntArray.forEach(action: (Int) -> Unit): Unit {
    //    for (element in this) action(element)
    //}

    intArray.forEach {
        println("Hello $it")
    }
    //endregion

    var map = intArray.map { it + 10 }
//    public inline fun <R> IntArray.map(transform: (Int) -> R): List<R> {
//        return mapTo(ArrayList<R>(size), transform)
//    }

    //public inline fun <T> Iterable<T>.forEach(action: (T) -> Unit): Unit {
    //    for (element in this) action(element)
    //}
    map.forEach { println("map foreach $it") }
}

//region +折叠
fun needsFunction(block: () -> Unit) {
    block()
}

fun returnsFunction(): () -> Long {
    return { System.currentTimeMillis() }
}
//endregion

fun cost(block: () -> Unit) {
    val start = System.currentTimeMillis()
    block()
    println("${System.currentTimeMillis() - start}ms")
}

fun fibonacci(): () -> Long {
    //作为了 lamb 的入参。和临时变量保存。
    // 当 for 循环lambda 时更新 first second。每次
    var first = 0L
    var second = 1L
    //执行1次
    System.out.println(":fibonacci: first: $first second: $second");
    return {//执行 n 次
        val next = first + second
        val current = first
        first = second
        second = next
        current //返回current
    }
}