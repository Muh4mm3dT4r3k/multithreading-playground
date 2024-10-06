package com.mohamed;

import java.util.concurrent.TimeUnit;

public class ThreadGroupDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup threadGroup = new ThreadGroup("thread-group");
        Thread[] threads = createThreads(threadGroup);
        startThreads(threads);
        TimeUnit.SECONDS.sleep(2);
        threadGroup.interrupt();
    }

    private static void startThreads(Thread[] threads) {
        for (Thread thread : threads)
            thread.start();
    }

    private static Thread[] createThreads(ThreadGroup threadGroup) {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(threadGroup, ThreadGroupDemo::execute);
        }
        return threads;
    }

    private static void execute() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
