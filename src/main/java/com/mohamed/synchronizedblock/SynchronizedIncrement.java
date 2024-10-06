package com.mohamed.synchronizedblock;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedIncrement {

    private static int counter;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threadList = new ArrayList<>();
        int numberOfIncrement = 10000;

        for (int i = 0; i < numberOfIncrement; i++) {
            var thread = new Thread(SynchronizedIncrement::increment);
            threadList.add(thread);
            thread.start();
        }

        for (Thread thread : threadList)
            thread.join();

        System.out.println(counter);
    }

    private synchronized static void increment() {
        counter++;
    }

    private static void incrementWithSyncBlock() {
        synchronized (SynchronizedIncrement.class) {
            counter++;
        }
    }
}
