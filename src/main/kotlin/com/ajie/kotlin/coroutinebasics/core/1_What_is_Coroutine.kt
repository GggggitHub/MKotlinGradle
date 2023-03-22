package com.ajie.kotlin.coroutinebasics.core

import com.ajie.kotlin.coroutinebasics.api.User
import com.ajie.kotlin.coroutinebasics.api.githubApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

suspend fun main() {

    System.out.println(":main:tName:["+Thread.currentThread().getName()+"]: ");
//    async()

//    协程请求
    var launch = GlobalScope.launch {
//        coroutine()
        coroutineLoop()
        System.out.println(
            ":main:tName:[" + Thread.currentThread().getName() + "]: GlobalScope.launch coroutineLoop() over after"
        );
    }
    System.out.println(":main:tName:["+Thread.currentThread().getName()+"]: main go suspend afer");
    Thread.sleep(3000L) // 阻塞主线程 2 秒钟来保证 JVM 存活
    println("main over") // 协程已在等待时主线程还在继续
//    launch.join()
    //阻塞，直到 launch.join()结束
//    System.out.println(":main:tName:["+Thread.currentThread().getName()+"]: join after over");
}

//异步
fun async() {
    System.out.println("tName:"+Thread.currentThread().getName()+":async: ");

    val call = githubApi.getUserCallback("bennyhuo")
    call.enqueue(object : Callback<User> {
        override fun onFailure(call: Call<User>, t: Throwable) {
            System.out.println("tName:"+Thread.currentThread().getName()+":onFailure: ");
            showError(t)
        }
        override fun onResponse(call: Call<User>, response: Response<User>) {
            System.out.println("tName:"+Thread.currentThread().getName()+":onResponse: ");
            response.body()?.let(::showUser) ?: showError(NullPointerException())
        }
    })
    System.out.println("tName:"+Thread.currentThread().getName()+":async: over");
}

fun asyncLoop() {
    val names = arrayOf("abreslav","udalov", "yole")
    names.forEach { name ->
        val call = githubApi.getUserCallback(name)
        call.enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
                showError(t)
            }
            override fun onResponse(call: Call<User>, response: Response<User>) {
                response.body()?.let(::showUser) ?: showError(NullPointerException())
            }
        })
    }
}

//协程请求
suspend fun coroutine(){
    val names = arrayOf("abreslav","udalov", "yole")
    System.out.println("tName:["+Thread.currentThread().getName()+"] :coroutine: ");
    names.forEach { name ->
        try {
            val user = githubApi.getUserSuspend(name)
            showUser(user)
        } catch (e: Exception) {
            showError(e)
        }
    }
    System.out.println("tName:["+Thread.currentThread().getName()+"] :coroutine: over");
}

suspend fun coroutineLoop(){
    System.out.println(":coroutineLoop:tName:["+Thread.currentThread().getName()+"]: ");

    val names = arrayOf("abreslav","udalov", "yole")
    val users = names.map { name ->
        githubApi.getUserSuspend(name)
    }
    System.out.println(":coroutineLoop:tName:["+Thread.currentThread().getName()+"]: over");
    users.forEach { showUser(it) }
}