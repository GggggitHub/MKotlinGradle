package com.ajie.kotlin

/**
 * @author Ajie
 * @date 2022/3/24
 * @function 计算器
 */
/**
 * input: 3 * 4
 * @param args Array<out String>
 */
fun main(vararg args: String) {
    if (args.size!=3){
        return showHelp()
    }

    val operators = mapOf(
        "+" to ::plus,
        "-" to ::minus,
        "*" to ::times,
        "/" to ::div
    )

    val opFun = operators[args[1]] ?: return showHelp()
//    val opFun = operators[args[1]] ?: return "no this operator" //类型不匹配。

    try {
        //调用 args.joinToString ,里面设置了 参数的默认值 。可以选填不同的参数。
        println("Input: ${args.joinToString (" ") }")
        println("OutPut: ${opFun(args[0].toInt(),args[2].toInt())}")

    } catch (e: Exception) {
        e.printStackTrace()
        showHelp()
    }
}

fun plus(arg0: Int,arg1: Int):Int{
    return arg0+arg1;
}

fun minus(arg0: Int, arg1: Int): Int{
    return arg0 - arg1
}

fun times(arg0: Int, arg1: Int): Int{
    return arg0 * arg1
}

fun div(arg0: Int, arg1: Int): Int{
    return arg0 / arg1
}


fun showHelp() {
    println("""
        
        input error
        Simple Calculator:
            Input: 3 * 4
            Output: 12
    """.trimIndent())
}
