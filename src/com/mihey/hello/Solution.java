package com.mihey.hello;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {


    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] table = new int[m][n];
        for (int t = n - 1; t >= 0; --t) {
            for (int i = 0; i < m; i++) {
                table[i][t] = sc.nextInt();
//                System.out.print(table[t][i] + " ");
            }
        }
        for (int t = 0; t < m; ++t) {
            for (int i = 0; i < n; i++) {
                System.out.print((table[t][i] + " "));
            }
            System.out.println();
        }
    }
}

