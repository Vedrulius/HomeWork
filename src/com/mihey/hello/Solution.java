package com.mihey.hello;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {


    public static void addValueByIndex(long[] arr, int idx, long val) {
        arr[idx] = val + arr[idx];
        for (long l : arr) {
            System.out.print(l + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tmp = sc.nextLine().split(" ");
        int idx = sc.nextInt();
        long val = sc.nextLong();
        int n = tmp.length;
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(tmp[i], 10);
        }
        addValueByIndex(arr, idx, val);
    }
}


