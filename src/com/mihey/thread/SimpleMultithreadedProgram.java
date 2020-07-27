package com.mihey.thread;

import java.util.Scanner;

public class SimpleMultithreadedProgram {

    static class SquareWorkerThread extends Thread {
        private final Scanner scanner = new Scanner(System.in);

        public SquareWorkerThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                int number = scanner.nextInt();
                if (number == 0) {
                    break;
                }
                System.out.println(number * number);
            }
            System.out.println(String.format("%s finished", getName()));
        }
    }

    public static void main(String[] args) {
        Thread worker = new SquareWorkerThread("square-worker");
        worker.start(); // start a worker (not run!)

        for (long i = 0; i < 5_555_555_543L; i++) {
            if (i % 1_000_000_000 == 0) {
                System.out.println("Hello from the main!");
            }
        }
    }
}