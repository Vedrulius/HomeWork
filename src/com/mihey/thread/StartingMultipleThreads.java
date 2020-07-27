package com.mihey.thread;

public class StartingMultipleThreads {

    public static void main(String[] args) {
        Thread t1 = new MainThreadDemo.HelloThread();
        Thread t2 = new MainThreadDemo.HelloThread();

        t1.start();
        t2.start();

        System.out.println("Finished");
    }
}
