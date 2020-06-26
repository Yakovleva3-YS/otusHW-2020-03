package ru.otus;

public class TestLogging implements TestLoggingInterface{

    @Override
    public void calculation(int param) {
        System.out.println("calculation, param:" + param);
    }

    @Override
    public void print(String string) {
        System.out.println("print:" + string);
    }

    @Override
    public void square(int param) {
        System.out.println("calculation, param:" + param);
    }
}
