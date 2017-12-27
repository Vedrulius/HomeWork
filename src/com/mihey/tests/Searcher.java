package com.mihey.tests;

import java.io.IOException;
import java.util.Arrays;

public class Searcher {
    int search(int[] ints, int elem)  {
        if (ints == null) {
            throw new AssertionError("Wrong array value");
        }
        return Arrays.binarySearch(ints, elem);
    }
}

