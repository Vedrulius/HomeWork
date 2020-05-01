package com.mihey.homework.leetcode;

import java.util.HashMap;
import java.util.Map;
/**
 * Given a non-empty array of integers, every element appears twice except for one.
 * Find that single one.
 */
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int res=0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i:nums) {
            if (!map.containsKey(i)) {
                map.put(i,0);
            }
            else {
                map.put(i,1);
            }
        }
        for (int i : nums) {
            if (map.get(i) == 0) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        System.out.println(singleNumber(new int[]{2,2,1,1,5}));
    }
}
