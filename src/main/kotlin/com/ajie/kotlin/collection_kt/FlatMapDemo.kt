package com.ajie.kotlin.collection_kt

/**
 * @author Ajie
 * @date 2023/3/22
 * @function
 */

fun main() {
    //将所有生成的集合合并为一个扁平化的集合
    val nestedList = listOf(
        listOf(1, 2, 3),
        listOf(4, 5, 6),
        listOf(7, 8, 9)
    )

    val flatList = nestedList.flatMap { it }
    println(flatList) // 输出：[1, 2, 3, 4, 5, 6, 7, 8, 9]


    //集合中的元素创建一个新的集合
    val originalList = listOf(1, 2, 3, 4, 5)
    val transformedList = originalList.flatMap { listOf(it.toString(), (it * 10).toString()) }//List<String>
    println(transformedList) // 输出：[1, 10, 2, 20, 3, 30, 4, 40, 5, 50]


    val list = listOf(1, 2, 3, 4)

    list.asSequence()
        .flatMap {
            (0 until it).asSequence()
        }
        .joinToString().let(::println)
}