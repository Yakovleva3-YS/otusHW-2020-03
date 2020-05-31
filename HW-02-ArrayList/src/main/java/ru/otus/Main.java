package ru.otus;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        testAddAll();
        testCopy();
        testSort();
    }

    public static void testAddAll() {
        System.out.println("----Test addAll----");
        List<String> array = new DIYarrayList<>();
        array.add("1");
        array.add("2");
        array.set(1, "3");
        Collections.addAll(array,
                "Four", "Five", "Six", "Seven", "8", "9", "10", "12", "13",
                "14", "15", "16", "17", "18", "19", "20", "21");
        array.add("11");
        for(int i=0; i<array.size(); i++) {
            System.out.println(array.get(i));
        }
    }

    public static void testCopy() {
        System.out.println("----Test copy----");
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i<22; i++) {
            array.add(i);
        }
        List<Integer> array2 = new ArrayList<>();
        for (int i = 0; i<22; i++) {
            array2.add(i+100);
        }
        Collections.copy(array, array2);

        for(int i=0; i<array.size(); i++) {
            System.out.println(array.get(i));
        }
    }

    public static void testSort() {
        System.out.println("----Test sort----");
        List<String> array = new DIYarrayList<>();
        Collections.addAll(array,"First", "Second", "1", "A", "s", "asw", "23", "delete", "one");

        Collections.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });

        for(int i=0; i<array.size(); i++) {
            System.out.println(array.get(i));
        }
    }
}
