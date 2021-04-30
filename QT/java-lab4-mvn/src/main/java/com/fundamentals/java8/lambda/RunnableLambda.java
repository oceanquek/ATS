package com.fundamentals.java8.lambda;

public class RunnableLambda {

    public static void main(String[] args) {
        //traditionalThreading();
        //traditionalThreading1();
        //anonymousClass();
        Java8RunnableLambda();
    }

    public static void traditionalThreading() {
        String ThreadNameString = Thread.currentThread().getName();
        System.out.println("Executing in Main: " + ThreadNameString);
        TestThread testThread = new TestThread();
        testThread.start();
        testThread.method1();
        TestThread testThread1 = new TestThread();
        testThread.start();
        testThread.setName("Custom Thread 2");
        testThread.method2();
    }

    public static void traditionalThreading1() {
        String ThreadNameString = Thread.currentThread().getName();
        System.out.println("Executing in Main: " + ThreadNameString);
        SpecialTest specialTest = new SpecialTest();
        Thread childThread = new Thread(specialTest);
        childThread.start();
        childThread.setName("Custom Thread 1");
        specialTest.method1();
    }

    public static void anonymousClass() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("Anonymous class with Thread: " + Thread.currentThread().getName());
            }
        };
        thread.start();
    }

    public static void Java8RunnableLambda() {
        Runnable runnable = () -> System.out.println("Lambda with runnable");
        new Thread(runnable).start();

        new Thread(()-> System.out.println("Even shorter lambda")).start();
    }
}

class TestThread extends Thread {
    @Override
    public void start() {
        System.out.println("Test start()..." + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("Child thread executing: " + Thread.currentThread().getName());
    }

    public void method1() {
        System.out.println("method1");
    }

    public void method2() {
        System.out.println("method2");
    }
}

class SpecialTest implements Runnable {

    @Override
    public void run() {
        System.out.println("Child thread executing: " + Thread.currentThread().getName());
    }

    public void method1() {
        System.out.println("method1");
    }

    public void method2() {
        System.out.println("method2");
    }
}