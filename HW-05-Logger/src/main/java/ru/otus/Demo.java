package ru.otus;

public class Demo {
    public static void main(String[] args) {
        TestLoggingInterface testLogging = Ioc.createMyClass();
        testLogging.calculation(10);
        testLogging.print("Hello");
        testLogging.square(134);
    }
}
