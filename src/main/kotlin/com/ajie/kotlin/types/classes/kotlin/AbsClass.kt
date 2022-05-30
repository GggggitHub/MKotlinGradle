package com.ajie.kotlin.types.classes.kotlin

abstract class AbsClass {
    abstract fun absMethod()
    open fun overridable(){
        System.err.println("AbsClass: overridable: ");
    }
    fun nonOverridable(){
        System.err.println("AbsClass: nonOverridable: ");
    }
}