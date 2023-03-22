package com.ajie.kotlin.coroutinebasics.common

import android.os.Handler
import com.ajie.kotlin.coroutinebasics.common.Dispatcher

object HandlerDispatcher: Dispatcher {
    private val handler = Handler()

    override fun dispatch(block: () -> Unit) {
        handler.post(block)
    }
}