package com.mihey.thread;

import java.util.concurrent.TimeUnit;

public class StopThread {
    private static /*volatile*/ boolean stopRequested;

    public static void main(String[] args)
            throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (!stopRequested)
                    i++;
            }
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(3);
        stopRequested = true;
        System.out.println("Stop!");
    }
}
