package com.ajie.kotlin.msuspend

import kotlinx.coroutines.*

/**
 * @author Ajie
 * @date 2022/6/7
 * @function
 */
fun main() {
//    testCoroutineExceptionHandler()
//    testException()
//    testException1()
//    testException2()
//    testException3()
    testException4()

    Thread.sleep(100)
}

private fun testCoroutineExceptionHandler(){
    GlobalScope.launch {
        val job = launch {
            System.out.println(":testCoroutineExceptionHandler:  ${Thread.currentThread().name}  抛出未捕获异常")
            throw NullPointerException("异常测试")
        }
        job.join()
        System.out.println(":testCoroutineExceptionHandler>>>: ${Thread.currentThread().name} end")
    }
}

//捕获了异常
private fun testException(){
    GlobalScope.launch{
        launch(start = CoroutineStart.UNDISPATCHED) {
            System.out.println(":testException: ${Thread.currentThread().name}  我要开始抛异常了")
            try {
                throw NullPointerException("异常测试")
            } catch (e: Exception) {
                System.out.println(":testException: >>>>");
                e.printStackTrace()
            }
        }
        System.out.println(":testException: ${Thread.currentThread().name} end")
    }
}

//没有捕获 到异常。在协程外 try catch  。在其他线程。
private fun testException1(){
    var a:MutableList<Int> = mutableListOf(1,2,3)
    GlobalScope.launch{
        launch {
            System.out.println(":testException:tName:["+Thread.currentThread().getName()+"]: 我要开始抛异常了" )
            try {
                launch{
                    System.out.println(":testException1:tName:["+Thread.currentThread().getName()+"]: start");
                    System.out.println(":testException:tName:["+Thread.currentThread().getName()+"]: data:${a[1]}")
                }
                a.clear()//已经被 clear 了
                //执行了
                System.out.println(":testException1:tName:["+Thread.currentThread().getName()+"]: 0");
            } catch (e: Exception) {
                System.out.println(":testException1:tName:["+Thread.currentThread().getName()+"]: >>>>");
                e.printStackTrace()
            }
            //执行了
            System.out.println(":testException1:tName:["+Thread.currentThread().getName()+"]: end 1");
        }
        System.out.println(":testException:tName:["+Thread.currentThread().getName()+"]: end 2")
    }
}

//捕获异常
private fun testException2(){
    val exceptionHandler = CoroutineExceptionHandler  { coroutineContext, throwable ->
        System.out.println(":testException2:tName:["+Thread.currentThread().getName()+"] exceptionHandler>>>> ${coroutineContext[CoroutineName]} ：$throwable")
    }
    GlobalScope.launch(CoroutineName("异常处理") + exceptionHandler){
        val job = launch{
            System.out.println(":testException2:tName:["+Thread.currentThread().getName()+"]: 我要开始抛异常了" )
            throw NullPointerException("异常测试")
        }
        System.out.println(":testException2:tName:["+Thread.currentThread().getName()+"]: end");
    }
}

//因为异常会导致父协程被取消执行，
// 同时导致后续的所有子协程都没有执行完成(可能偶尔有个别会执行完)。
//如果有一个页面，它最终展示的数据，是通过请求多个服务器接口的数据拼接而成的，而其中某一个接口出问题都将不进行数据展示，而是提示加载失败。
// 那么你就可以使用上面的方案去做，都不用管它们是谁报的错，反正都是统一处理，一劳永逸。类似这样的例子我们在开发中应该经常遇到。
private fun testException3(){
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        System.out.println(":testException3:tName:["+Thread.currentThread().getName()+"]:>>> ${coroutineContext[CoroutineName]} 处理异常 ：$throwable")
    }
    GlobalScope.launch(CoroutineName("父协程") + exceptionHandler){
        val job = launch(CoroutineName("子协程")) {
            System.out.println(":testException3:tName:["+Thread.currentThread().getName()+"]: 我要开始抛异常了");
            for (index in 0..10){
                launch(CoroutineName("孙子协程$index")) {
                    Thread.sleep(10)
                    System.out.println(":testException3:tName:["+Thread.currentThread().getName()+"]:孙子协程:::  ${coroutineContext[CoroutineName]}" )
                }
            }
            throw NullPointerException("空指针异常")
        }
        for (index in 0..10){
            launch(CoroutineName("子协程$index")) {
                Thread.sleep(10)
                System.out.println(":testException3:tName:["+Thread.currentThread().getName()+"]: 子协程::: ${coroutineContext[CoroutineName]}" )
            }
        }
        try {
            job.join()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        System.out.println(":testException3:tName:["+Thread.currentThread().getName()+"]: end");
    }
}

//协程取消操作的单向传播性，子协程的异常不会导致其它子协程取消。
//即使当中有多个协程都出现问题，我们还是能够让所有的子协程执行完成。
private fun testException4(){
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        System.out.println(":testException4:tName:["+Thread.currentThread().getName()+"]>>>>: exceptionHandler ${coroutineContext[CoroutineName].toString()} 处理异常 ：$throwable")
    }
    GlobalScope.launch(exceptionHandler) {
        supervisorScope {
            launch(CoroutineName("异常子协程")) {
                System.out.println(":testException4:tName:["+Thread.currentThread().getName()+"]: 我要开始抛异常了")
                throw NullPointerException("空指针异常")
            }
            for (index in 0..10) {
                launch(CoroutineName("子协程$index")) {
                    Thread.sleep(50)
                    System.out.println(":testException4:tName:["+Thread.currentThread().getName()+"]:正常执行 $index")
                    if (index %3 == 0){
                        throw NullPointerException("子协程${index}空指针异常")
                    }
                }
            }
        }
    }

    System.out.println(":testException4:tName:["+Thread.currentThread().getName()+"]: end");

}