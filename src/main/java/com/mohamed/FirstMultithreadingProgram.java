package com.mohamed;

public class FirstMultithreadingProgram extends Thread{
    public static void main(String[] args) {
        Runnable task = new DefaultRunnable();
        Thread thread1 = new FirstMultithreadingProgram();
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I'm new thread! my name is " + Thread.currentThread().getName());
            }
        });
        Thread thread4 = new Thread(() -> {
            System.out.println("I'm new thread! my name is " + Thread.currentThread().getName());
        });

        System.out.println("Current Thread name " + Thread.currentThread().getName());
        Thread thread5 = new Thread(FirstMultithreadingProgram::execute);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

    public static void execute() {
        System.out.println("I'm a new thread my name is " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("I'm a new thread my name is " + Thread.currentThread().getName());
    }
}

class DefaultRunnable implements  Runnable {
    private String externalString;
    public DefaultRunnable () {}
    public DefaultRunnable (String externalString) {
        this.externalString = externalString;
    }
    @Override
    public void run() {
        System.out.println("I'm a new thread my name is " + Thread.currentThread().getName());
        // use fields of class if needed
        if (externalString != null) {
            System.out.println(externalString);
        }
    }
}