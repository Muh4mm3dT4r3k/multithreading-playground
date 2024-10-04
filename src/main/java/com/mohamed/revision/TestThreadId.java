package com.mohamed.revision;

public class TestThreadId {
    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println("Thread ID: " + ThreadId.get());
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);
        Thread thread4 = new Thread(task);
        System.out.println("Main Thread ID: " + ThreadId.get());
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
