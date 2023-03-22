package com.ajie.kotlin.functions

/**
 * @author Ajie
 * @date 2022/7/15
 * @function
 * https://blog.csdn.net/qq_29966203/article/details/124524844?spm=1001.2014.3001.5502
 */

fun main() {
    var person = Person()

    //public inline fun <T, R> T.let(block: (T) -> R): R {
    var let = person.let {
        it.function1()
        it.getStr()
    }
    System.out.println(":main: let:"+let);
    // 最终结果 = 返回 str 给变量result


    //public inline fun <T> T.also(block: (T) -> Unit): T {
    var also = person.also {
        it.function1()
        it.getStr()
    }
    System.out.println(":main: also:"+also);
    // 最终结果 = 返回一个 person 对象给变量result


    //需要调用同一个对象的多个方法 / 属性
    //public inline fun <T, R> with(receiver: T, block: T.() -> R): R {
    var with = with(person) {
        System.out.println(":main: with: person name:$name age:$age");
        function1()
        getStr()
    }
    System.out.println(":main: with:"+with);
    // 最终结果 = 返回一个 str 对象给变量result


    //run
    //结合了let、with两个函数的作用，即：
    //
    //调用同一个对象的多个方法 / 属性时，可以省去对象名重复，直接调用方法名 / 属性即可
    //定义一个变量在特定作用域内
    //统一做判空处理
    //public inline fun <T, R> T.run(block: T.() -> R): R {
    var run = person?.run {
        System.out.println(":main: run: person name:$name age:$age");
        999
    }
    System.out.println(":main: run:"+run);
    // 最终结果 = 返回一个 str 对象给变量result


    //public inline fun <T> T.apply(block: T.() -> Unit): T {
    var apply = person?.apply {
        System.out.println(":main: apply: person name:$name age:$age");
        999
    }
    System.out.println(":main: apply:" + apply);
    // 最终结果 = 返回一个people对象给变量result


}

class Function_LetAlsoWithRunApplay {

}

class Person{
    var name :String? = "zhangsan" ;
    var age :Int = 0

    fun function1(){
        System.out.println("Person:function1: ");
    }

    fun getStr():String{
        System.out.println("Person:getStr: ");
        return "str";
    }
}