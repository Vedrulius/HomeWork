package com.mihey.homework.rometoarabic;

import org.junit.Test;

import static com.mihey.homework.rometoarabic.RomeToArabicConverter.convertRomeToArabic;
import static org.junit.Assert.assertEquals;

public class RomeToArabicConverterTest {
    @Test
    public void testValid() {

        assertEquals(900, convertRomeToArabic("CM"));
        assertEquals(4, convertRomeToArabic("IV"));
        assertEquals(9, convertRomeToArabic("IX"));
        assertEquals(40, convertRomeToArabic("XL"));
        assertEquals(90, convertRomeToArabic("XC"));
        assertEquals(400, convertRomeToArabic("CD"));

        assertEquals(1, convertRomeToArabic("I"));
        assertEquals(5, convertRomeToArabic("V"));
        assertEquals(10, convertRomeToArabic("X"));
        assertEquals(50, convertRomeToArabic("L"));
        assertEquals(100, convertRomeToArabic("C"));
        assertEquals(500, convertRomeToArabic("D"));
        assertEquals(1000, convertRomeToArabic("M"));

        assertEquals(1954, convertRomeToArabic("MCMLIV"));
        assertEquals(1990, convertRomeToArabic("MCMXC"));
        assertEquals(2014, convertRomeToArabic("MMXIV"));
        assertEquals(1903, convertRomeToArabic("MCMIII"));
        assertEquals(3989, convertRomeToArabic("MMMCMLXXXIX"));
        assertEquals(3999, convertRomeToArabic("MMMCMXCIX"));
    }

}