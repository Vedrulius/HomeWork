package com.mihey.homework.combinationevaluator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CombinationEvaluatorTest {

    CombinationEvaluator evaluator;

    @BeforeEach
    void setUp() {
        evaluator = new CombinationEvaluator();
    }

    @Test
    void testFullhouseEvaluationCorrect() {
        assertTrue(evaluator.isFullhouse(new int[]{2, 3, 2, 3, 2}));

//        invalid cases
        assertFalse(evaluator.isFullhouse(new int[]{2, 3, 2, 3, 2, 2}));
        assertFalse(evaluator.isFullhouse(new int[]{2, 3, 3, 3, 3}));
        assertFalse(evaluator.isFullhouse(new int[]{3, 3, 3, 3, 3}));
        assertFalse(evaluator.isFullhouse(null));
        assertFalse(evaluator.isFullhouse(new int[0]));
    }

    @Test
    void testStraightEvaluationCorrect() {
        assertTrue(evaluator.isStraight(new int[]{5, 1, 3, 2, 4}));

//        invalid cases
        assertFalse(evaluator.isStraight(new int[]{1, 2, 3, 4, 5, 6}));
        assertFalse(evaluator.isStraight(new int[]{4, 2, 3, 1, 6}));
        assertFalse(evaluator.isStraight(null));
        assertFalse(evaluator.isStraight(new int[0]));
    }
}