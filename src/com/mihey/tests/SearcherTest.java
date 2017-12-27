package com.mihey.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SearcherTest {
    Searcher searcher;

//    @BeforeAll
//    public static void beforAll() {
//        System.out.println("Start test");
//    }

    @Before
    public void setUp() throws Exception {
        searcher = new Searcher();
    }

    @org.junit.Test
    public void testIndexCorrect() {
        assertEquals(0, searcher.search(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 0));
        assertEquals(7, searcher.search(new int[]{ 2, 3, 4, 5, 6, 7, 8, 9}, 9));
        assertEquals(4, searcher.search(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 4));
//        index not found
        assertEquals(-1, searcher.search(new int[0], 0));
        assertEquals(-1, searcher.search(new int[]{3,4,5,6,7,8,9}, 1));
        assertEquals(-11, searcher.search(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 12));

    }
}

