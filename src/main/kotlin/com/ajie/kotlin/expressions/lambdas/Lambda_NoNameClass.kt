package com.ajie.kotlin.expressions.lambdas

/**
 * @author Ajie
 * @date 2022/6/7
 * @function 使用Lambda简化匿名内部类
 * https://www.jianshu.com/p/6dc6faf58041
 */

//一、Lambda 简化演变
//这篇文章是介绍 Kotlin 的 Lambda，而不是 Java 的，两者大体相似，但是在语法上略有不同。
// 下面用三个例子（接口中抽象方法的参数，分别是无参数、单个参数、多个参数）来具体说明简化步骤：


// 接口中的抽象方法无参数
fun main() {
    // region //1.先来看最原始的写法，不使用 Lambda 表达式
    // 接口中的抽象方法无参数
    Thread(object : Runnable {
        override fun run() {
            println("run")
        }
    }).start()


//// 接口中的抽象方法一个参数
//button.setOnClickListener(object : View.OnClickListener {
//    override fun onClick(v: View?) {
//        v?.visibility = View.GONE
//    }
//})

    //// 接口中的抽象方法多个参数
    //AlertDialog.Builder(this).apply {
    //    setTitle("This is AlertDialog")
    //    setMessage("Message")
    //    setPositiveButton("OK", object : DialogInterface.OnClickListener {
    //        override fun onClick(dialog: DialogInterface?, which: Int) {
    //            println("Ok")
    //        }
    //    })
    //    setNegativeButton("Cancel", object : DialogInterface.OnClickListener {
    //        override fun onClick(dialog: DialogInterface?, which: Int) {
    //            println("Cancel")
    //        }
    //    })
    //    show()
    //}
    // endregion
}
