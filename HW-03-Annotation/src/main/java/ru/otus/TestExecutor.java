package ru.otus;

import ru.otus.annotations.After;
import ru.otus.annotations.Before;
import ru.otus.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestExecutor {

    public static void testExecutor(Class clazz) throws NoSuchMethodException {

        Method[] methods = clazz.getMethods();
        Method[] methodsBefore = getMethodsByAnnotation(methods, Before.class);
        Method[] methodsTest = getMethodsByAnnotation(methods, Test.class);
        Method[] methodsAfter = getMethodsByAnnotation(methods, After.class);

        int countPass = 0;
        int countFail = 0;

        Constructor<MyTest> constructor = clazz.getConstructor();

        for (Method method: methodsTest) {
            try {
                MyTest object = constructor.newInstance();
                for (Method methodBefore : methodsBefore) {
                    methodBefore.invoke(object);
                }
                method.invoke(object);
                for (Method methodAfter : methodsAfter) {
                    methodAfter.invoke(object);
                }
                countPass++;
            } catch (InvocationTargetException | IllegalAccessException | InstantiationException e) {
                countFail++;
                e.printStackTrace();
            }
        }
        printReport(countPass, countFail);
    }

    private static Method[] getMethodsByAnnotation(Method[] methods, Class<? extends Annotation> annotation) {
        Method[] methodsNew = new Method[methods.length];
        int j = 0;
        for (int i = 0; i<methods.length; i++) {
            if (methods[i].isAnnotationPresent(annotation)) {
                methodsNew[j] = methods[i];
                System.out.println(methodsNew[j].toString());
                j++;
            }
        }
        return Arrays.copyOf(methodsNew, j);
    }

    private static void printReport(int countPass, int countFail) {
        System.out.println("---------------Report--------------");
        System.out.println("Number of passed tests: " + countPass);
        System.out.println("Number of failed tests: " + countFail);
        int allTests = countPass + countFail;
        System.out.println("Number of all tests: " + allTests);
    }
}
