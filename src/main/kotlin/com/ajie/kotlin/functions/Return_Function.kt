package com.ajie.kotlin.functions

import com.bennyhuo.kotlin.builtintypes.functions.Foo

/**
 * @author Ajie
 * @date 2022/5/31
 * @function 返回函数类型
 */

fun main() {
    var returnFunction = returnFunction("main input")
    var returnFunction1 = returnFunction("zhangsan", 18)
    System.out.println(":main: "+returnFunction1);
    var returnFunction2 = returnFunction2("2")
    // TODO: 2022/5/31  展示不知道，怎么写 具名函数 返回值
//    returnFunction2("1",1L) //？？？
}
//showMethod函数              返回一个匿名函数
fun returnFunction(info:String):(String, Int)->String{
    println("我是returnFunction函数 info:$info")
    //返回一个匿名函数
    return { name:String, age:Int ->
        "我就是匿名函数：我的name:$name,age:$age"
    }
}
val x31:(Foo, String, Long)->Any = Foo::bar //x3--> (Foo, String, Long) -> Any

fun normalMethod(string: String){"normalMethod $string"}

//todo  展示不知道，怎么写 具名函数 返回值
fun returnFunction2(info: String):Any{
//    return Foo().bar("1", 1L)
    return Foo::bar
}
