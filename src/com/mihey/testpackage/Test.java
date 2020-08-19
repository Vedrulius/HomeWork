package com.mihey.testpackage;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String codeWithComments = scanner.nextLine();
        String regex = "/\\*.*?\\*/";
        String regex1 = "//.*";
        System.out.println(codeWithComments.replaceAll(regex, "").replaceAll(regex1, ""));
    }
}

