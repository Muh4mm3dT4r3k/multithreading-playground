package com.mohamed;

public class PriorityDemo {
    public static void main(String[] args) {
        Thread[] threads = createThreads();
        startThreads(threads);
    }

    public static void execute() {
        System.out.println(Thread.currentThread().getName());
    }

    private static Thread[] createThreads() {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(PriorityDemo::execute);
            threads[i].setPriority(i + 1);
        }
        return threads;
    }

    private static void startThreads(Thread[] threads) {
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
