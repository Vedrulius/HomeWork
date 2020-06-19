package com.mihey.exceptions;

import java.util.Scanner;

public class DemoInputFromConsole {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        while (!s.equals("0")) {
            try {
                while (!s.equals("0")) {

                    System.out.println(Integer.parseInt(s) * 10);
                    s = sc.nextLine();
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid user input: " + s);
                s = sc.nextLine();
            }
        }
    }
}