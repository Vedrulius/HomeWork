package com.mihey.homework.collections;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RandomListTest {
    RandomList rl;

    @BeforeEach
    public void setUp() {
        rl = new RandomList();
    }

    @Test
    public void generateRandomList() {
        assertEquals(20, rl.generateRandomList(20).size());
        assertEquals(0, rl.generateRandomList(0).size());
    }

}
