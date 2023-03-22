package com.ajie.kotlin.functions_advanced.inlines

fun main() {
    //region local return
    val ints = intArrayOf(1, 2, 3, 4)
    ints.forEach {
        if(it == 3) return@forEach //跳出1次内联函数，下次还会执行。
        println("test return inline return forEach: $it")
    }

    for (element in ints) {
//        if (element ==3) return // 从 main 函数返回。
        if(element == 3) continue //与之相同 return@forEach //跳出1次内联函数，下次还会执行。
        println("continue inline continue for: $element")
    }
    //endregion

    //region non-local return
    nonLocalReturn {
        //return
        System.out.println(":main:nonLocalReturn $it");
//        if (it == 2){
//            return
//        }
    }

    Runnable {
        println("xxx")
        println("yyy")
    }
    //endregion

    //region cost
    cost {
        println("Hello")
    }
    //endregion

    //region inline property
    money = 5.0
    //endregion
}

inline fun Runnable(noinline block: () -> Unit): Runnable {
    return object : Runnable {
        override fun run() {
            block()
        }
    }
}

public inline fun IntArray.forEach(crossinline action: (Int) -> Unit): Unit {
    for (element in this) action(element)
}

inline fun nonLocalReturn(block: (Int) -> Unit){
//    for( i in 1..5) {
        block(1)
//        if (i==2)return //可以renturn 到 调用这个函数的地方。
//    }
}

inline fun hello(){
    println("Hello")
}

  fun cost(block: () -> Unit) {
    val start = System.currentTimeMillis()
    block()
    println(System.currentTimeMillis() - start)
}

var pocket: Double = 0.0
var money: Double
    inline get() = pocket
    inline set(value) {
         pocket = value
    }