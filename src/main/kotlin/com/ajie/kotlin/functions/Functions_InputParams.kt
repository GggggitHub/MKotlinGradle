package com.bennyhuo.kotlin.builtintypes.functions

class Greeter {
    fun sayHello() {
        println("Hello from Greeter!")
    }
    fun sayGoodbye() {
        println("Goodbye from Greeter!")
    }
}

fun main(vararg args: String) {
    //指定参数为。 Greeter 中的函数。不能指定函数名称。
    fun executeGreeterFunction(greeter: Greeter, function: Greeter.() -> Unit) {
        println("executeGreeterFunction inputParams Greeter.() -> Unit")
        greeter.function()
    }
    //调用
    executeGreeterFunction(Greeter(),Greeter::sayHello)
    executeGreeterFunction(Greeter(),Greeter::sayGoodbye)

    //入参不能指定 【特定的类中的函数】。编写扩展函数，调用那个【特定的函数】
    fun Greeter.executeSayHello(function: (Greeter.() -> Unit) -> Unit) {
        function(Greeter::sayHello)//强制调用特定函数。
    }
    //调用
    val greeter = Greeter()
    greeter.executeSayHello { sayHelloFunction ->
        println("executeSayHello")
        sayHelloFunction.invoke(greeter);
    }

}
