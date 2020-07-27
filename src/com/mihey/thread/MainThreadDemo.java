package com.mihey.thread;

public class MainThreadDemo {
    public static void main(String[] args) {
        Thread t = Thread.currentThread(); // main thread

        System.out.println("Name: " + t.getName());
        System.out.println("ID: " + t.getId());
        System.out.println("Alive: " + t.isAlive());
        System.out.println("Priority: " + t.getPriority());
        System.out.println("Daemon: " + t.isDaemon());
        System.out.println(java.lang.Thread.MIN_PRIORITY);
        System.out.println(java.lang.Thread.MAX_PRIORITY);

        t.setName("my-thread");
        System.out.println("New name: " + t.getName());

    }

    static class HelloThread extends Thread {

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

}
