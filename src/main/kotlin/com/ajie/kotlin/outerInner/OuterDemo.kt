package com.ajie.kotlin.outerInner

/**
 * @author Ajie
 * @date 2022/11/11
 * @function
 */
class Outer {
    fun foo(){

    }
}

open class Fruit(){

}

class Apple() :Fruit(){

}
class Orange() :Fruit(){

}