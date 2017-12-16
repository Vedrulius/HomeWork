package com.mihey.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class StringEqualsTest {
    StringEquals compare;

    @BeforeEach
    public void setUp() {
        StringEquals compare = new StringEquals();
    }

    @Test
    public void testCompareStringsCorrect()  {
        assertTrue( compare.compareStrings("abc","abc"));
    }

}