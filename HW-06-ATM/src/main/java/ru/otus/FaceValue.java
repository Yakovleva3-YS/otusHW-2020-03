package ru.otus;

public enum FaceValue {
    TEN(10),
    FIFTY(50),
    HUNDRED(100),
    FIVE_HUNDRED(500),
    THOUSAND(1000),
    FIVE_THOUSAND(5000);

    private int value;

    FaceValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
