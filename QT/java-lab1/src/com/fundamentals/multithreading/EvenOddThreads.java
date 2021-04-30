package com.fundamentals.multithreading;

public class EvenOddThreads {
    public static void main(String[] args) {
        EvenThread evenThread = new EvenThread();
        evenThread.start();
        OddThread oddThread = new OddThread();
        oddThread.start();

    }
}

class EvenThread extends Thread {
    @Override
    public void run() {
        for (int i = 0;i< 51;i=i+2) {
            System.out.println(i);
        }
        System.out.println("Even thread " + Thread.currentThread().getName());
    }
}

class OddThread extends Thread {
    @Override
    public void run() {
        for (int i = 1;i< 51;i=i+2) {
            System.out.println(i);
        }
        System.out.println("Odd thread " + Thread.currentThread().getName());
    }
}

