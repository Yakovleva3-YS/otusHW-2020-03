package ru.otus;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Otm implements OtmInterface {

    private ArrayList<Cell> listOfCells;

    public Otm() {
        listOfCells = (ArrayList<Cell>) Stream.of(
                new Cell(FaceValue.FIVE_THOUSAND),
                new Cell(FaceValue.THOUSAND),
                new Cell(FaceValue.FIVE_HUNDRED),
                new Cell(FaceValue.HUNDRED),
                new Cell(FaceValue.FIFTY),
                new Cell(FaceValue.TEN)
        ).collect(Collectors.toList());
    }

    @Override
    public void takeBanknotes(int amountOfMoney) {
        for (int i=0; i<listOfCells.size();i++) {
            if (i==0) {
                listOfCells.get(i).addCount((amountOfMoney)/listOfCells.get(i).getFaceValue().getValue());
            } else {
                listOfCells.get(i).addCount((amountOfMoney%listOfCells.get(i-1).getFaceValue().getValue())/listOfCells.get(i).getFaceValue().getValue());
            }
        }
    }

    @Override
    public void giveOutBanknotes(int amountOfMoney) {

        int balance = getBalance();
        if(amountOfMoney > balance) {
            throw new RuntimeException("Не достаточно средств в банкомате");
        }

        Integer[] saveArrayOfCount = saveArrayOfCount();

        for(Cell cell: listOfCells) {
            int numberOfNotes = amountOfMoney/cell.getFaceValue().getValue();
            int sumOfMoneyTheFaceValue = cell.getCount() * cell.getFaceValue().getValue();

            if (numberOfNotes > 0 && cell.getCount() >= numberOfNotes) {
                cell.subtractCount(numberOfNotes);
                amountOfMoney -= numberOfNotes * cell.getFaceValue().getValue();
            } else if (cell.getCount() < numberOfNotes) {
                cell.subtractCount(cell.getCount());
                amountOfMoney -= cell.getCount() * cell.getFaceValue().getValue();
            }
            if(amountOfMoney > balance - sumOfMoneyTheFaceValue) {
                for (int i = 0; i < listOfCells.size(); i++) {
                    listOfCells.get(i).setCount(saveArrayOfCount[i]);
                }
                throw new RuntimeException("Банкомат не может выдать запрашиваемую сумму");
            }
        }
    }

    @Override
    public int getBalance() {
        int balance = 0;
        for (Cell cell: listOfCells) {
            balance += cell.getCount() * cell.getFaceValue().getValue();
        }
        return balance;
    }

    private Integer[] saveArrayOfCount() {
        Integer[] saveArrayOfCount = new Integer[6];
        for (int i = 0; i < saveArrayOfCount.length; i++) {
            saveArrayOfCount[i] = listOfCells.get(i).getCount();
        }
        return saveArrayOfCount;
    }
}
