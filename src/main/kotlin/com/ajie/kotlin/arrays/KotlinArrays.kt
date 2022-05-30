package com.bennyhuo.kotlin.builtintypes.arrays

fun main() {

    val a = IntArray(5)
    println(a.size) //same with the Collections(e.g. List)

    val b = ArrayList<String>()
    println(b.size)

    val c0 = intArrayOf(1, 2, 3, 4, 5)
    val c1 = IntArray(5){ 3 * (it + 1) } // y = 3*(x + 1)

    println(c1.contentToString())

   val d = arrayOf("Hello", "World")
    d[1] = "Kotlin"
    println("${d[0]}, ${d[1]}")

    val e = floatArrayOf(1f, 3f, 5f, 7f)
    for (element in e) {
        println(element)
    }

    e.forEach {
        println(it)
    }

    if(1f in e){
        println("1f exists in variable 'e'")
    }

    if(1.2f !in e){
        println("1.2f not exists in variable 'e'")
    }

    println("遍历的4种方式")
    var namesArray = arrayOf("a", "b", "c")
    println("method 1")
    //1
    for (name in namesArray)
        print(" $name"+',')  // a, b, c,
    //2
    println("")
    println("method 2")
    for (i in namesArray.indices)
        print(" $i $namesArray[i] ,") // 0 [Ljava.lang.String;@5a39699c[i] , 1 [Ljava.lang.String;@5a39699c[i] , 2 [Ljava.lang.String;@5a39699c[i] ,
    //3
    println("")
    println("method 3")
    for (e in namesArray.withIndex()){ //e IndexedValue<T>
        println(" ${e.index} ${e.value} ,")
    }

    for ((index, name) in namesArray.withIndex())
        println(" $index $name ,")

    //4
    println("")
    println("method 4")
    for (index in 1..5) {
        println(" $index ,")
    }


}