package com.mihey.hello;

public class Hello {
    public static void main(String args[]) {

        int a = 19;
        int sum = 0;
//        StringBuilder s = new StringBuilder();
        while (a > 0) {

            sum += (a % 10) * (a % 10);
            a = a / 10;
        }

//            s.insert(0,a % 10);

        System.out.println(sum);
        System.out.println(9/10);
    }
}



