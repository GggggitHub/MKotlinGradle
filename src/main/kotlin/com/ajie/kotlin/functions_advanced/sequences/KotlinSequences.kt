package com.ajie.kotlin.functions_advanced.sequences

fun main() {
    val list = listOf(1, 2, 3, 4)

    //region sequence
    list.asSequence()
        .filter {
            println("filter: $it")
            it % 2 == 0
        }.map {
            println("map: $it")
            it * 2 + 1
        }
        .forEach {
            println("forEach: $it")
        }
    //rxjava
    //endregion

    var flatMap = list.asSequence()
        .flatMap {
            (0 until it).asSequence()
        }
    flatMap.joinToString().let(::println)
    //rxjava




    //region
    for (i in 0..10) {
        print(i)
        print(",")
    }

    println()
    for (e in list) {
        print(e)
        print(",")
    }

    var i = 0
    while (i++ < 10) {
        print("when:$i ")
    }

    println()
    do {
        println("Hello")
    } while (false)
    //endregion

    //不能跳出 return@forEach
    //region for each
    list.forEach {
        if (it == 2) {
            return@forEach
        }
        println("return it==2 in{}: $it")
    }

    list.forEach {
        if (it == 2) return@forEach
        println("return it==2 no{}: $it")
    }
    //endregion

    //region
    val newList = list.flatMap {
        ArrayList<String>(it)
    }

    list.filter { it % 2 == 0 }
    list.asSequence()
        .filter { it % 2 == 0 }

//    list.map { it *2 +1 }
    list.asSequence()
        .map { it * 2 + 1 }

//    list.flatMap {  }
    list.asSequence()
        .flatMap {
            (0 until it).asSequence()
        }
        .joinToString().let(::println)

    list.fold(StringBuilder()) { acc, i ->
        acc.append(i)
    }
    list.forEach { print("$it ,")  }//1 ,2 ,3 ,4 ,
    println()
    list.joinToString().let(::println )//1, 2, 3, 4

    list.asSequence()
        .filter {
            it % 2 == 0
        }.map {
            it * 2 + 1
        }.flatMap {
            (0 until it).asSequence()
        }.forEach(::println)
    //endregion
}
