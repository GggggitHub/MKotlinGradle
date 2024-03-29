package com.ajie.kotlin.functions_advanced.sams

fun main() {
    val eventManager = EventManager()

    val onEvent = object : EventManager.OnEventListener {
        override fun onEvent(event: Int) {
            println("onEvent $event")
        }
    }

    val onEvent2 = EventManager.OnEventListener{
        println("onEvent $it")
    }

    // DO NOT use this.
//    val onEvent3 = { event: Int ->
//        println("onEvent $event")
//    }

    eventManager.addOnEventListener(onEvent)

    eventManager.removeOnEventListener(onEvent)

}