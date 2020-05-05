package com.mihey.tests;

import com.mihey.homework.leetcode.TwoSum;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {
    TwoSum ts;

    @BeforeEach
    void setUp() {
        ts = new TwoSum();
    }
    @Test
    void testTwoSum() {
        assertArrayEquals(new int[]{0,1},ts.twoSum(new int[]{2,7,5,4,3},9));
        assertArrayEquals(new int[]{0,2},ts.twoSum(new int[]{2,3,7,4,3},9));
        assertArrayEquals(new int[]{1,3},ts.twoSum(new int[]{2,3,7,4,3},7));

        assertNotEquals(new int[]{1,3},ts.twoSum(new int[]{2,3,7,4,3},1));
    }
}