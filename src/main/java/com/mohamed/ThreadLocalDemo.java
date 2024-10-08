package com.mohamed;

import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo implements Runnable {
    private static ThreadLocal<Integer> transactionId = new ThreadLocal<>();
    public static void main(String[] args) {
        ThreadLocalDemo runnable = new ThreadLocalDemo();

        var thread1 = new Thread(runnable);
        var thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        transactionId.set((int) (Math.random()*100));
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(transactionId.get());
    }
}
