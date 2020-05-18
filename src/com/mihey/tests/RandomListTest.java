package com.mihey.homework.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomListTest {
    RandomList rl;

    @BeforeEach
    public void setUp() {
        rl = new RandomList();
    }

    @Test
    public void generateRandomList() {
        List<String> list = rl.generateRandomList(100);
        assertEquals(20, rl.generateRandomList(20).size());
        assertEquals(0, rl.generateRandomList(0).size());
        assertFalse(list.contains(null));
        assertFalse(list.contains(""));
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
