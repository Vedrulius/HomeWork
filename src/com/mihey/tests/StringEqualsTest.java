package com.mihey.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class StringEqualsTest {
    StringEquals compare;

    @Before
    public void setUp() {
         compare = new StringEquals();
    }

    @Test
    public void testCompareStringsCorrect()  {
        assertTrue( compare.compareStrings("abc","abc"));
        assertFalse(compare.compareStrings("abc","abd"));
        assertFalse(compare.compareStrings("abc",null));
        assertFalse(compare.compareStrings("abc","аbc"));
        assertFalse(compare.compareStrings("abc","Abc"));
    }


}