package com.mihey.tests;

import com.mihey.homework.leetcode.HappyNumber;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HappyNumberTest {
    HappyNumber hn;

    @BeforeEach
    void setUp() {
        hn = new HappyNumber();
    }

    @Test
    void testSingleNumber() {
        assertTrue(hn.isHappy(19));
        assertTrue(hn.isHappy(13));
        assertTrue(hn.isHappy(1));
        assertTrue(hn.isHappy(7));

        assertFalse(hn.isHappy(11));
        assertFalse(hn.isHappy(2));
        assertFalse(hn.isHappy(3));
        assertFalse(hn.isHappy(5));
        assertFalse(hn.isHappy(6));
        assertFalse(hn.isHappy(71));
        assertFalse(hn.isHappy(8));
        assertFalse(hn.isHappy(9));

    }
}