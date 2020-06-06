package ru.otus;

import ru.otus.annotations.After;
import ru.otus.annotations.Before;

public class MyTest {

    @Before
    public void beforeTest1() {
        System.out.println("Before test 1");
    }

    @Before
    public void beforeTest2() {
        System.out.println("Before test 2");
    }

    @ru.otus.annotations.Test
    public void test1() {
        System.out.println("Test 1");
    }

    @ru.otus.annotations.Test
    public void test2() {
        System.out.println("Test 2");
        throw new RuntimeException("Ошибка при выполнении теста2");
    }

    @ru.otus.annotations.Test
    public void test3() {
        System.out.println("Test 3");
    }

    @After
    public void afterTest1() {
        System.out.println("After test 1");
    }

    @After
    public void afterTest2() {
        System.out.println("After test 2");
    }
}
