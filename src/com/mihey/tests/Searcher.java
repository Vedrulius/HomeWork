package com.mihey.tests;

import java.util.Arrays;

public class Searcher {
    int search(int[] ints, int elem) {
        if (ints == null) {
            throw new AssertionError("Wrong array value");
        }
        return Arrays.binarySearch(ints, elem);
    }


    public static void main(String[] args) {
        Searcher s = new Searcher();
        System.out.println(s.search(new int[]{1,2,3,4}, 10));
    }
}