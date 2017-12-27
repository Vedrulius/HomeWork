package com.mihey.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringBuilderAppendTest {
    StringBuilderAppend sba;
    @BeforeEach
    void setUp(){
        sba=new StringBuilderAppend();
    }

    @Test
    void testStringBuilderAppendCorrect() {
        assertEquals("abcdef",sba.appendString("abc","def"));
        assertEquals("12345qwert",sba.appendString("12345","qwert"));
        assertNotEquals("abcdef",sba.appendString("abc","ded"));
    }

}