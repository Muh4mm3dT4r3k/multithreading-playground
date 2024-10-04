package com.mohamed.revision;

import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo {
//    private static final ThreadLocal<Integer> transactionId = ThreadLocal.withInitial(() -> new AtomicInteger(0).getAndIncrement());
    private static final ThreadLocal<Integer> transactionId = new ThreadLocal<>();
    public static void main(String[] args) {
        Runnable task = () -> {
            transactionId.set((int)(Math.random() * 100));
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(transactionId.get());
        };


        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();
    }
}
