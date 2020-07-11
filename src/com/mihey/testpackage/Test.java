package com.mihey.testpackage;

import java.util.*;

class Test {

    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(str));
        String[] str1 = sc.nextLine().split(" ");
        List<String> list1 = new ArrayList<>(Arrays.asList(str1));
        System.out.println(list);
        System.out.println(list1);
        int a = Collections.indexOfSubList(list, list1);
        int b = Collections.lastIndexOfSubList(list, list1);
        System.out.printf("%d %d", a, b);
    }
}
