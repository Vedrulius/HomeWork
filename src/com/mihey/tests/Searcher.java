package com.mihey.tests;

import java.util.Arrays;

public class Searcher {
    int search(int[] ints, int elem) {
        return Arrays.binarySearch(ints, elem);
    }
}
