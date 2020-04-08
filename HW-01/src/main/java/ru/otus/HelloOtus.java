package ru.otus;

import com.google.common.base.Strings;

public class HelloOtus {
    public String getHello() {
        return "Hello";
    }

    public static void main(String[] args) {
        System.out.println(Strings.repeat(new HelloOtus().getHello(), 3));
    }
}
