package com.ajie.kotlin.msuspend

import kotlinx.coroutines.*
import kotlin.math.abs

/**
 * @author Ajie
 * @date 2022/4/20
 * @function
 * https://www.kotlincn.net/docs/reference/coroutines/basics.html
 */

suspend fun main() {
    //1 非阻塞式协程    没有block 主线程。
//    GlobalScopeLaunch()

    //2 非阻塞式协程    没有block 主线程。
//    runBlockingDemo()

    //3job.join block 当前线程
//    GlobalScopeJobJoin()

    //4
    coroutineScopeDemo()//

//    GlobalScope.launch {
//        repeat(100_000) { // 启动大量的协程
//        delay(100L)
//        System.out.println(":main:tName:["+Thread.currentThread().getName()+"]: $it");
////            println("$it ,")
//        }
//    }.join()

    System.out.println(":main:tName:["+Thread.currentThread().getName()+"]: repeat after");
    Thread.sleep(10000L)



//    System.out.println(":main: method end");
//    Thread.sleep(2000L)
//    System.out.println(":main:tName:["+Thread.currentThread().getName()+"]: sleep end");

}

fun coroutineScopeDemo() {
    println("coroutineScopeDemo:"+"threaName:"+Thread.currentThread().name)
    
    runBlocking { // this: CoroutineScope
        launch {
            System.out.println("coroutineScopeDemo: "+"threadName: "+Thread.currentThread().name);
            delay(200L)//没有 block 主线程
            println("Task from runBlocking 1")//执行顺序 2
        }

        coroutineScope { // 创建一个协程作用域
            launch {
                System.out.println("coroutineScopeDemo: "+"threadName: "+Thread.currentThread().name);
                delay(500L)
                println("Task from nested launch 2")//执行顺序 3
            }

            delay(100L)
            println("Task from coroutine scope 3") //执行顺序1， 这一行会在内嵌 launch 之前输出
        }

        println("Coroutine scope is over 4") //执行顺序4， 这一行在内嵌 launch 执行完毕后才输出
    }
    System.out.println(":coroutineScopeDemo:tName:["+Thread.currentThread().getName()+"]: runBlocking after");

}


//3
private suspend fun GlobalScopeJobJoin() {
    //延迟一段时间来等待另一个协程运行并不是一个好的选择。
    //让我们显式（以非阻塞方式）等待所启动的后台 Job 执行结束：
    System.err.println("main: " + "测试3 》》》》》》》  ")//在 上面 delay(2000L) 后执行。block 了主线程。
    val job = GlobalScope.launch { // 启动一个新协程并保持对这个作业的引用
        delay(1000L)
        println("World!")
    }
    println("Hello,")
    job.join() // 等待直到子协程执行结束 ,block 当前线程。
    println("main: join over")
}

//2
private fun runBlockingDemo() {
    println("main:" + "strat runBlocking....测试2》》》》》》")
    //2 非阻塞式协程    没有block 主线程。
    runBlocking<Unit> { // 开始执行主协程
        GlobalScope.launch { // 在后台启动一个新的协程并继续
            delay(1000L)
            System.out.println(":runBlockingDemo:tName:["+Thread.currentThread().getName()+"]: World!")
        }
        System.out.println(":runBlockingDemo:tName:["+Thread.currentThread().getName()+"]: Hello,") // 主协程在这里会立即执行
        delay(2000L)      //block 主线程。 延迟 2 秒来保证 JVM 存活
        System.out.println(":runBlockingDemo:tName:["+Thread.currentThread().getName()+"]:delay 2000L afer runBlocking end")
    }
    System.out.println(":runBlockingDemo:tName:["+Thread.currentThread().getName()+"]: out runBlocking over");

}

//1
private fun GlobalScopeLaunch() {
    //1 非阻塞式协程    没有block 主线程。
    GlobalScope.launch { // 在后台启动一个新的协程并继续
        delay(1000L) // 非阻塞的等待 1 秒钟（默认时间单位是毫秒）
        println("World!") // 在延迟后打印输出 ,Thread.sleep(2000L)之后打印。主线程被block 了
        System.out.println(":GlobalScopeLaunch:tName:["+Thread.currentThread().getName()+"]: World！");

    }
    System.out.println(":GlobalScopeLaunch:tName:["+Thread.currentThread().getName()+"]: Hello,");
//    println("Hello,") // 协程已在等待时主线程还在继续
    Thread.sleep(2000L) // 阻塞主线程 2 秒钟来保证 JVM 存活
}