package ru.otus;

public interface TestLoggingInterface {
    @Log
    void calculation(int param);

    @Log
    void print(String string);

    void square(int param);
}
