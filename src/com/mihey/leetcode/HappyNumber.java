package com.mihey.leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) throws StackOverflowError {
//        if (n == 1) return true;
//        if(n==89) return false;
//        if (n < 1) return false;
//
//        int sum = 0;
//        while (n > 0) {
//            sum += (n % 10) * (n % 10);
//            n = n / 10;
//        }
//        System.out.println(sum);
//        return isHappy(sum);
        Set<Integer> inLoop = new HashSet<Integer>();
        int squareSum, remain;
        while (inLoop.add(n)) {
            squareSum = 0;
            while (n > 0) {
                remain = n % 10;
                squareSum += remain * remain;
                n /= 10;
            }
            if (squareSum == 1)
                return true;
            else
                n = squareSum;

        }
        return false;
    }

    public static void main(String[] args) {
        HappyNumber h = new HappyNumber();
        System.out.println(h.isHappy(13));
        Set<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(3);
        System.out.println(set);
    }
}
