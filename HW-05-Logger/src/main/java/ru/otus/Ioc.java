package ru.otus;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Set;

public class Ioc {

    private Ioc() {
    }

    static TestLoggingInterface createMyClass() {
        InvocationHandler handler = new DemoInvocationHandler(new TestLogging());
        return (TestLoggingInterface) Proxy.newProxyInstance(Ioc.class.getClassLoader(),
                new Class<?>[]{TestLoggingInterface.class}, handler);
    }

    static class DemoInvocationHandler implements InvocationHandler {
        private final TestLoggingInterface testLogging;
        private Set<Method> methodsAnnotatedLog = getMethodsAnnotLog();

        DemoInvocationHandler(TestLoggingInterface testLogging) {
            this.testLogging = testLogging;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            for(Method mtd: methodsAnnotatedLog) {
                if (mtd.equals(method)) {
                    System.out.println("invoking method:" + method);
                    break;
                }
            }
            return method.invoke(testLogging, args);
        }

        private static Set<Method> getMethodsAnnotLog() {
            Reflections reflections = new Reflections(Demo.class.getPackage().getName(), new MethodAnnotationsScanner());
            return reflections.getMethodsAnnotatedWith(Log.class);
        }

        @Override
        public String toString() {
            return "DemoInvocationHandler{" +
                    "myClass=" + testLogging +
                    '}';
        }
    }
}
