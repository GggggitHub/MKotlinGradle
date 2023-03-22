package com.ajie.kotlin.fanxingT

import FanXingT.fclass.Apple
import FanXingT.fclass.Basket

/**
 * @author Ajie
 * @date 2022/12/3
 * @function
 */
fun main(){
    val apple:Apple
    var basket1 :Basket<Apple> = Basket<Apple>()
    var basket2 :Basket<Apple> = Basket<Apple>()

    var intArray = IntArray(5)
    //方法 1，直接赋值
    var fruits : Array<Basket<Apple>> = arrayOf<Basket<Apple>>(basket1,basket2);

    //方法 2  可以直接声明 数组，包含泛型的元素
    var fruits2 : Array<Basket<Apple>?> = arrayOfNulls<Basket<Apple>>(5);
    fruits2[0] = basket1;

    //方法 3
    var fruits3 : Array<Basket<Apple>> = Array(5){//lambda 初始化数组内容。
        println("array3:"+it)
        Basket<Apple>()
    };


    System.out.println(":main: "+fruits.size);
}
class FanxingDemo {


}