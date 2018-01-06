package com.mihey.homework.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

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
        assertFalse(rl.generateRandomList(100).contains(null));
        assertFalse(rl.generateRandomList(100).contains(""));
    }

    @Test
    public void invalidRandomListLimit() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                rl.generateRandomList(-1);
            }
        });

    }
}
