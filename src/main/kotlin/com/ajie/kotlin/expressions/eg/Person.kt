package com.ajie.kotlin.expressions.eg

class Person(var age: Int, val name: String){
    override fun equals(other: Any?): Boolean {
        val other = (other as? Person)?: return false
        return other.age == age && other.name == name
    }

//    override fun hashCode(): Int {
//        return 1 + 7 * age + 13 * name.hashCode()
//        return 13 * name.hashCode()
//    }
}

fun main() {
    val persons = HashSet<Person>()

//    (0..5).forEach {
//        persons += Person(20, "Benny")
//    }

    val person = Person(20, "Benny")
    persons += person

    // a moment later
    println(persons.size)// 1

    val person2 = Person(person.age+1, person.name)

    //重写hashcode. hashcode 变了. 不能移出
    //不重写。hashcode 没变。可以移出。
    person.age++;//。看是否


    //能否 remove，取决于 hash 是否改变了。
    //->hash 相同 -> del
    //->hash 不相同 -> 不能del
    //与 equals 无关。 kotlin hashset->java hashset remove 源码。
    persons -= person


    println(persons.size)//0

    //结论：.Person@2c7b84de ，后面的值就是 16进制的 hashcode.
    System.out.println(":main: "+person);//com.ajie.kotlin.expressions.eg.Person@2c7b84de
    System.out.println(":main: "+Integer.toHexString(person.hashCode()));//2c7b84de
    //另一种获取 hashcode的方式
    System.out.println(":main: "+System.identityHashCode(person))//746292446
    System.out.println(":main: 获取对象的 hashcode:"+person.hashCode());//746292446
}