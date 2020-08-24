package com.mihey.homework.generics;

import java.util.ArrayList;
import java.util.List;

/**
 Class to modify
 */
public class ListMultiplicator {
    public static <T> void multiplyHelper(List<T> list, int n) {
        List<T> newList=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            newList.addAll(list);
        }
        list.clear();
        list.addAll(newList);
    }
    /**
     Multiplies original list provided number of times
     @param list list to multiply
     @param n times to multiply, should be zero or greater
     */
    public static void multiply(List<?> list, int n) {
        multiplyHelper(list,n);
    }

    public static void main(String[] args) {
        System.out.println("Well done!");
    }
}
