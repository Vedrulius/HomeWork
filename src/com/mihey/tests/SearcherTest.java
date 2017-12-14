package com.mihey.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class SearcherTest {
    Searcher searcher;

    @BeforeAll
    public static void beforAll() {
        System.out.println("Start test");
    }

    @BeforeEach
    public void setUp() throws Exception {
        searcher = new Searcher();
    }

    @Test
    public void testIndexNotFound() throws Exception {
        Assert.assertEquals(-1, searcher.search(new int[0], 0));
        Assert.assertEquals(-1, searcher.search(new int[]{0, 1, 2, 3, 4, 5}, 7));
    }

    @AfterEach
    public void cleanUp() {
        System.out.println("Cleanup");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test finish");
    }
}

