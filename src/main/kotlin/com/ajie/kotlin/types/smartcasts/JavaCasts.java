package com.ajie.kotlin.types.smartcasts;

import com.ajie.kotlin.types.smartcasts.java.Kotliner;
import com.ajie.kotlin.types.smartcasts.java.Person;

public class JavaCasts {
    public static void main(String... args) {


        Kotliner kotliner = new Person("benny", 20);
        if(kotliner instanceof Person){
            System.out.println(((Person) kotliner).name);
        }



    }
}


