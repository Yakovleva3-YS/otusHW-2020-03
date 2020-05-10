package ru.otus;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//        List<Integer> myList = new MyArrayList<>();
//        Collections.addAll(myList, 1, 2, 3, 4, 5);
//        for (Integer value:myList) {
//            System.out.println(value);
//        }
//        test();
        testArray();
//        testCopy();
//        testSort();
    }

    public static void test() {
        List<String> dfs = new DIYarrayList<>();
        dfs.add("First");
        dfs.add("Second");
        dfs.set(1, "Third");
        Collections.addAll(dfs, "Four", "Five", "Six", "Seven", "8", "9", "10", "12");
        dfs.add("11");
        for(int i=0; i<dfs.size(); i++) {
            System.out.println(dfs.get(i));
        }
    }

    public static void testArray() {
        List<String> dfs = new ArrayList<>();
        dfs.add("First");
        dfs.add("Second");
        dfs.set(1, "Third");
        Collections.addAll(dfs, "Four", "Five", "Six", "Seven", "8", "9", "10", "12");

        for (String value: dfs) {
            System.out.println(value);
        }

        System.out.println("------------");

        Collections.sort(dfs);
        dfs.stream().forEach(System.out::println);
//        ListIterator<String> listIterator = dfs.listIterator();
//        for(int i=0; i<2; i++) {
//            System.out.println(listIterator.next());
//            System.out.println(listIterator.nextIndex());
//        }

    }

    public static void testCopy() {
        List<String> array = new DIYarrayList<>();
        array.add("First");
        array.add("Second");

        List<String> array2 = new DIYarrayList<>();
        array2.add("3");
        array2.add("4");
        ListIterator<String> listIterator = array.listIterator();
        Collections.copy(array, array2);
        for(int i=0; i<array.size(); i++) {
            System.out.println(array.get(i));
        }

        for(int i=0; i<array2.size(); i++) {
            System.out.println(array2.get(i));
        }
    }

    public static void testSort() {
        List<String> array = new DIYarrayList<>();
        array.add("First");
        array.add("Second");

        for(int i=0; i<array.size(); i++) {
            System.out.println(array.get(i));
        }

        Collections.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

        for(int i=0; i<array.size(); i++) {
            System.out.println(array.get(i));
        }
//        simpsons.stream().map(s -> s.name).forEach(System.out::print);
        array.stream().forEach(System.out::println);
    }
}
