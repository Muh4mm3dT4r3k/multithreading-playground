package com.mohamed;

public class PriorityDemo {
    public static void main(String[] args) {
        var t0 = new Thread(PriorityDemo::execute);
        var t1 = new Thread(PriorityDemo::execute);
        var t2 = new Thread(PriorityDemo::execute);
        var t3 = new Thread(PriorityDemo::execute);
        var t4 = new Thread(PriorityDemo::execute);
        var t5 = new Thread(PriorityDemo::execute);
        var t6 = new Thread(PriorityDemo::execute);
        var t7 = new Thread(PriorityDemo::execute);
        var t8 = new Thread(PriorityDemo::execute);
        var t9 = new Thread(PriorityDemo::execute);

        t0.setPriority(1);
        t1.setPriority(2);
        t2.setPriority(3);
        t3.setPriority(4);
        t5.setPriority(5);
        t6.setPriority(6);
        t7.setPriority(7);
        t8.setPriority(8);
        t9.setPriority(9);

        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
    }

    public static void execute() {
        System.out.println(Thread.currentThread().getName());
    }
}
