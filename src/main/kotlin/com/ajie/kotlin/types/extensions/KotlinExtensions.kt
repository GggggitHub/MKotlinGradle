package com.ajie.kotlin.types.extensions

class PoorGuy{
    var pocket: Double = 0.0
}

fun PoorGuy.noMoney(){
    System.out.println("扩展方法:noMoney: ");
}

//不能定义 backing field，因为没有receiver 来接受。这是个今天变量
//property = backing field + getter + setter
var PoorGuy.moneyLeft: Double //定义属性：剩余资金。
    get() {
        return this.pocket
    }
    set(value) {
        pocket = value
    }

interface Guy {
    var moneyLeft: Double
        get() {
            return 0.0
        }
        set(value) {
        }

    fun noMoney(){
        println("no money called.")
    }
}

class GuySon (money :Double): Guy{
    override var moneyLeft: Double = money
        get() = field
        set(value) {
            field = value
        }

    override fun noMoney() {
        System.err.println("GuySon:noMoney: ");
    }
}

fun String.padding(count: Int, char: Char = ' '): String {
    val padding = (1 .. count).joinToString(""){ char.toString() }
    return "${padding}${this}${padding}"
}

fun String.isEmail(): Boolean {
    return matches(Regex("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"))
}

//复制几次
fun String.times(count: Int): String {
    return (1 .. count).joinToString("") { this }
}

fun main() {
    PoorGuy().noMoney();

    var guySon = GuySon(2.0)
    System.err.println(":main: "+guySon.moneyLeft);
    guySon.noMoney()

    var email = "admin@bennyhuo.com".isEmail()
    System.out.println(":main: \"admin@bennyhuo.com\".isEmail():"+email);


    println("Hello".padding(1))
    println("*".times(10))

    val stringTimes = String::times
    val stringTimesBound = "*"::times

    arrayOf(1,3,3).forEach {  }

    val x = 2
}