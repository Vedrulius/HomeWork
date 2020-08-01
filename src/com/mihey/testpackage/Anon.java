package com.mihey.testpackage;

public class Anon {

    public static Runnable createRunnable(String text, int repeats) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < repeats; i++) {
                    System.out.println(text);
                }
            }
        };

        return r;// an instance here
    }

    public static void main(String[] args) {
        createRunnable("!!!", 3).run();
    }
}
