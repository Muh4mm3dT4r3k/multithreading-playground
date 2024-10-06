package com.mohamed;

import java.util.concurrent.TimeUnit;

public class DaemonThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    System.out.print("Daemon is Working\r");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.print("Daemon is Working.\r");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.print("Daemon is Working..\r");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.print("Daemon is Working...\r");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {

                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        TimeUnit.SECONDS.sleep(10);
        System.out.println("Main thread finished");
    }
}
