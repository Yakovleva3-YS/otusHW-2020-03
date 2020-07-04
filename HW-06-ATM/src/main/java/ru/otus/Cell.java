package ru.otus;

public class Cell {

    private FaceValue faceValue;
    private int count = 0;

    public Cell(FaceValue faceValue) {
        this.faceValue = faceValue;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public FaceValue getFaceValue() {
        return faceValue;
    }

    public void addCount(int numberBanknotesToAdd) {
        count += numberBanknotesToAdd;
    }

    public void subtractCount(int numberBanknotesToSubtract) {
        count -= numberBanknotesToSubtract;
    }
}
