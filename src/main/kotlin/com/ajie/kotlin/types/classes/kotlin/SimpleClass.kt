package com.ajie.kotlin.types.classes.kotlin

open class SimpleClass(var x: Int, val y: String)
    : AbsClass(), SimpleInf {
    override val simpleProperty: Int
        get() {
            return 2
        }

    val z : Long
        get() {
            return simpleProperty * 2L
        }

    override fun absMethod() {}
    override fun simpleMethod() {}
    fun y(){}

    fun zzz(string: String){

    }

//    final override fun overridable(){
    override fun overridable(){
       System.err.println("SimpleClass:overridable: ");
    }

    fun defaultMethod(){
        System.err.println("SimpleClass:defaultMethod: ");
    }
}

class SimpleClass2(x: Int, y: String): SimpleClass(x, y){
    override fun overridable() {
        System.err.println("SimpleClass2:overridable: ");
    }
}