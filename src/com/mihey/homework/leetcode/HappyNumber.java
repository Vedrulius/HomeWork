package com.mihey.homework.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number n is "happy".
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the
 * sum of the squares of its digits, and repeat the process until
 * the number equals 1 (where it will stay), or it loops endlessly
 * in a cycle which does not include 1. Those numbers for which
 * this process ends in 1 are happy numbers.
 * Return True if n is a happy number, and False if not.
 */

public class HappyNumber {
    public boolean isHappy(int n) throws StackOverflowError {
        if (n == 1) return true;
        if (n == 89) return false;
        if (n < 1) return false;

        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        System.out.println(sum);
        return isHappy(sum);
    }

//        Set<Integer> inLoop = new HashSet<>();
//        int squareSum, remain;
//        while (inLoop.add(n)) {
//            squareSum = 0;
//            while (n > 0) {
//                remain = n % 10;
//                squareSum += remain * remain;
//                n /= 10;
//            }
//            if (squareSum == 1)
//                return true;
//            else
//                n = squareSum;
//        }
//        return false;
//    }
}
