package com.mihey.testpackage;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class Test extends Thread {

    final Scanner sc = new Scanner(System.in); // use it to read string from the standard input

    @Override
    public void run() {
        while (sc.hasNext()) {
            String s = sc.nextLine();
            Pattern p = Pattern.compile(".*[a-z].*");
            Matcher m = p.matcher(s);
            if (m.matches()) {
                System.out.println(s.toUpperCase());
            } else {
                System.out.println("FINISHED");
                return;
            }
        }
        // implement this method
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.run();
    }
}



