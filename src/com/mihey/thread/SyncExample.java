package com.mihey.thread;

public class SyncExample {
    public static void main(String[] args) throws InterruptedException {
       /* SomeClass instance1 = new SomeClass("instance-1");
        SomeClass instance2 = new SomeClass("instance-2");

        MyThreadEx first = new MyThreadEx(instance1);
        MyThreadEx second = new MyThreadEx(instance1);
        MyThreadEx third = new MyThreadEx(instance2);

        first.start();
        second.start();
        third.start();*/
        SynchronizedCounter counter = new SynchronizedCounter();

        Worker worker1 = new Worker(counter);
        Worker worker2 = new Worker(counter);
        Worker worker3 = new Worker(counter);

        worker1.start();
        worker2.start();
        worker3.start();

        worker1.join();
        worker2.join();
        worker3.join();

        System.out.println(counter.getValue());
    }
}

class SynchronizedCounter {

    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getValue() {
        return count;
    }
}

class Worker extends Thread {

    private final SynchronizedCounter counter;

    public Worker(SynchronizedCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10_000_000; i++) {
            counter.increment();
        }
    }
}

class MyThreadEx extends Thread{

    private SomeClass someclass;

    public MyThreadEx(SomeClass someclass) {
        this.someclass = someclass;
    }

    @Override
    public void run() {
        someclass.doSomething();
    }
}

class SomeClass {

    private String name;

    public SomeClass(String name) {
        this.name = name;
    }

    public synchronized void doSomething() {

        String threadName = Thread.currentThread().getName();
        System.out.println(String.format("%s entered the method of %s", threadName, name));
        System.out.println(String.format("%s leaves the method of %s", threadName, name));
    }
}