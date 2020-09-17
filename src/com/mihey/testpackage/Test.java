package com.mihey.testpackage;

import java.util.List;
import java.util.concurrent.*;

public class Test {

    public static int executeCallableObjects(List<Future<Callable<Integer>>> items) {
        int res = 0;
        for (int i = items.size() - 1; i >= 0; i--) {
            try {
                res += items.get(i).get().call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;

    }

    public static void main(String[] args) {

    }
}