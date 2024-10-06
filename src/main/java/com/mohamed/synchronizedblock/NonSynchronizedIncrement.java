package com.mohamed.synchronizedblock;

import java.util.ArrayList;
import java.util.List;

public class NonSynchronizedIncrement {
    private static int counter;
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threadList = new ArrayList<>();
        int numberOfIncrements = 1000000;
        for (int i = 0; i < numberOfIncrements; i++) {
            var thread = new Thread(NonSynchronizedIncrement::increment);
            threadList.add(thread);
            thread.start();
        }
        for (Thread thread : threadList)
            thread.join();
        System.out.println(counter);
    }

    private static void increment() {
        counter++;
    }
}
