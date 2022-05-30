package com.ajie.kotlin.types.classes;

import com.ajie.kotlin.types.classes.java.SimpleClass;

public class JavaClasses {
    public static void main(String[] args) {
        SimpleClass simpleClass = new SimpleClass(9);
        System.out.println(simpleClass.x);
        simpleClass.y();
    }
}
