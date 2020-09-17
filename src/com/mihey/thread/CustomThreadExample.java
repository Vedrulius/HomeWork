package com.mihey.thread;

public class CustomThreadExample {
    public static void main(String[] args) {
        Thread t1 = new HelloThread(); // a subclass of Thread

        Thread t2 = new Thread(new HelloRunnable()); // passing runnable

        Thread myThread = new Thread(new HelloRunnable(), "my-thread");

        Thread t3 = new Thread(() -> {
            System.out.println(String.format("Hello, i'm %s", Thread.currentThread().getName()));
        });

        Thread t = new HelloThread(); // an object representing a thread
        t.start();

    }
}

class HelloThread extends Thread {

    @Override
    public void run() {
        String helloMsg = String.format("Hello, i'm %s", getName());
        System.out.println(helloMsg);
    }
}

class HelloRunnable implements Runnable {

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        String helloMsg = String.format("Hello, i'm %s", threadName);
        System.out.println(helloMsg);
    }
}
