package com.mihey.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringBuilderReverseTest {
    StringBuilderReverse sbr;

    @BeforeEach
    public void setUp() {
         sbr = new StringBuilderReverse();
    }

    @Test
    public void testStringBuilderReverseCorrect() throws Exception {
        assertEquals("trewq", sbr.reverseString("qwert"));
        assertEquals("реверс", sbr.reverseString("сревер"));
        assertEquals("123456qwert", sbr.reverseString("trewq654321"));
        assertNotEquals("trewq", sbr.reverseString("qwett"));
    }

}