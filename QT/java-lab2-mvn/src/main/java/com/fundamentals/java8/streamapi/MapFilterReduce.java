package com.fundamentals.java8.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapFilterReduce {

    public static void oldStyleIteration() {
        ArrayList<Integer> integerList = new ArrayList<>();
        int i = 1;
        integerList.add(1);
        integerList.add(2);
        integerList.add(20);
        integerList.add(25);
        integerList.add(12);

        /*
        for (int j = 0;j< integerList.size();j++) {
            System.out.println(integerList.get(j));
        }
        */

        for (Integer integer2: integerList) {
            System.out.println(integer2);
        }

        Iterator<Integer> iterator = integerList.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void napping() {
        String[] colorString = new String[]{"red","green","blue","yellow"};
        Stream<String> colorStream = Arrays.stream(colorString);
        Stream<String> upperCaseStream = colorStream.map((color)-> (color.toUpperCase()));
        String[] upperStrings = upperCaseStream.toArray(String[]::new);
        for (String color : upperStrings) {
            System.out.println(color);
        }

    }

    public static void filter() {
        String[] colorString = new String[]{"red","green","blue","yellow"};
        Stream<String> colorStream = Arrays.stream(colorString);
        Stream<String> filteredStream = colorStream.filter(color -> color.length() > 4);
        String[] filteredStrings = filteredStream.toArray(String[]::new);
        for (String color : filteredStrings) {
            System.out.println(color);
        }

    }

    public static void reduction() {
        int[] ballCount = new int[]{5000,3000,2000,1000};

        int sum = 0;
        for (int i = 0;i< ballCount.length;i++) {
            sum += ballCount[i];
        }
        System.out.println(sum);
        IntStream ballStream = Arrays.stream(ballCount);
        System.out.println(ballStream.sum());
        ballStream = Arrays.stream(ballCount);
        System.out.println(ballStream.min());
        ballStream = Arrays.stream(ballCount);
        System.out.println(ballStream.max());
        ballStream = Arrays.stream(ballCount);
        System.out.println(ballStream.count());

    }

    public static void main(String[] args) {
        //oldStyleIteration();
        //napping();
        //filter();
        reduction();
    }
}
