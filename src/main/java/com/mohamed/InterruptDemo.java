package com.mohamed;

import java.util.concurrent.TimeUnit;

public class InterruptDemo implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        InterruptDemo runnableTask = new InterruptDemo();
        Thread thread = new Thread(runnableTask);
        thread.start();

        Thread.sleep(2);
//	    TimeUnit.MILLISECONDS.sleep(2000);
//		TimeUnit.SECONDS.sleep(2);

        System.out.println("in main() - interrupting other thread");
        thread.interrupt();

        thread.join();
        System.out.println("in main() - leaving");
    }

    @Override
    public void run() {
        try {
            System.out.println("in run() - about to work()");
            work();
            System.out.println("in run() - back from work() - this line will not be executed");

        } catch (InterruptedException e) {
            System.out.println("in run() - interrupted in work()");
//            return;
        }

        System.out.println("in run() - doing stuff after nap");
        System.out.println("in run() - leaving normally");
    }

    public void work() throws InterruptedException {
        while (true) {
            System.out.println("Working...");
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("isInterrupted(): " + Thread.currentThread().isInterrupted());
//                System.out.println("interrupted(): " + Thread.interrupted());
//                System.out.println("isInterrupted(): " + Thread.currentThread().isInterrupted());
                TimeUnit.MICROSECONDS.sleep(1);
                System.out.println("This line will not be executed");
                break;
            }
        }
    }

}
