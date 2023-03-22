package com.ajie.kotlin.msuspend

import com.ajie.kotlin.coroutinebasics.api.githubApi
import com.ajie.kotlin.coroutinebasics.core.getUserSuspend
import kotlinx.coroutines.*
import kotlin.concurrent.thread

/**
 * @author Ajie
 * @date 2022/6/3
 * @function
 */
fun main() {

    runBlocking {
        var launch = launch(Dispatchers.IO) {
            "launch"
        }

    }


//    thread {
//        System.out.println(":main:tName:["+Thread.currentThread().getName()+"]: thread:");
//
//    }
//    GlobalScope.launch(Dispatchers.IO){
//        withContext(Dispatchers.IO){
//
//        }
//        System.out.println(":main:tName:["+Thread.currentThread().getName()+"]: IO start...");
//        val user = `githubApi.getUserSuspend("abreslav")
//        launch(Dispatchers.Default){
//            System.out.println(":main:tName:["+Thread.currentThread().getName()+"]: user:"+user);
//
//        }
//    }
//    GlobalScope.launch(Dispatchers.Default){
//        System.out.println(":main:tName:["+Thread.currentThread().getName()+"]: GlobalScope.launch(Dispatchers.Default)");
//    }
    Thread.sleep(1000)

    suspend fun suspendingGetImage(imageId: String){
        withContext(Dispatchers.IO){
            System.out.println(":suspendingGetImage:tName:["+Thread.currentThread().getName()+"]: getImage from image id $imageId");
        }
    }

    suspend fun suspendUntilDone(mills : Long){
        delay(mills)
        System.out.println(":suspendUntilDone:tName:["+Thread.currentThread().getName()+"]: over");
    }
}

