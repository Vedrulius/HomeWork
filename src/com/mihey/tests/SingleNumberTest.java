package com.mihey.tests;

import com.mihey.homework.leetcode.SingleNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SingleNumberTest {
    SingleNumber snt;

    @BeforeEach
    void setUp() {
        snt = new SingleNumber();
    }

    @Test
    void testSingleNumber() {
        assertEquals(9, snt.singleNumber(new int[]{1, 1, 2, 2, 5, 5, 9}));
        assertEquals(5, snt.singleNumber(new int[]{1, 1, 2, 2, 5, 9, 9}));
        assertEquals(0, snt.singleNumber(new int[0]));
        assertNotEquals(0, snt.singleNumber(new int[]{1, 1, 2, 2, 5, 5, 9}));
    }
}