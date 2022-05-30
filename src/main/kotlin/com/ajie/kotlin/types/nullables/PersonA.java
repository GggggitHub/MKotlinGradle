package com.ajie.kotlin.types.nullables;

import org.jetbrains.annotations.NotNull;

public class PersonA {
    public static void main(String[] args) {
        new PersonA().getTitle();
        System.out.println("PersonA:main: ");
    }
//    @NotNull //返回 Null。IllegalStateException 因为注解的原因。
    public String getTitle(){
//        return "null";
        return null;
    }

}
