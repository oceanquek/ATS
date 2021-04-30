package com.fundamentals.java8.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamPerformanceTest {
    // Set up the collection with data
    public static void main(String[] args) {
        serialStreamPerformance(1000000);
        parallelStreamPerformance(1000000);
    }

    private static void serialStreamPerformance(int count) {
        List<Integer> productList = new ArrayList<Integer>();
        productList.add(1000);
        for (int i= 0;i< count;i++) {
            Integer lastValue = productList.get(i);
            productList.add(lastValue+1000);
        }

        long start = System.nanoTime();
        List serialIntegerList = new ArrayList<Integer>();
        Stream<Integer> productListStream = productList.stream();
        Stream<Integer> productListFilteredStream = productListStream.filter(product -> product > 3000);
        productListFilteredStream.forEach((product)-> {
            //System.out.println("Thread name -->" + Thread.currentThread().getName());
            serialIntegerList.add(product);
        });
        long finish = System.nanoTime();
        long timeElapsed = finish-start;
        System.out.println(String.format("Serial performance: %d",timeElapsed/(1000)));

    }

    private static void parallelStreamPerformance(int count) {
        List<Integer> productList = new ArrayList<Integer>();
        productList.add(1000);
        for (int i= 0;i< count;i++) {
            Integer lastValue = productList.get(i);
            productList.add(lastValue+1000);
        }

        long start = System.nanoTime();
        List serialIntegerList = new ArrayList<Integer>();
        Stream<Integer> productListStream = productList.parallelStream();
        Stream<Integer> productListFilteredStream = productListStream.filter(product -> product > 3000);
        productListFilteredStream.forEach((product)-> {
            //System.out.println("Thread name -->" + Thread.currentThread().getName());
            serialIntegerList.add(product);
        });
        long finish = System.nanoTime();
        long timeElapsed = finish-start;
        System.out.println(String.format("Parallel performance: %d",timeElapsed/(1000)));
    }
}
