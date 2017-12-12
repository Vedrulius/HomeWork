package com.mihey.homework.combinationevaluator;

import java.util.Arrays;

public class CombinationEvaluator {
    public CombinationEvaluator() {
    }
    /**
     * Check if array contains straight combination (5 "cards", initial order does not matter).
     *
     * @return true if combination is full house, false otherwise
     */


    public boolean isStraight(int[] combination) {
        if (combination == null || combination.length != 5) return false;
        Arrays.sort(combination);
        for (int i = 0; i < 4; i++) {
            if (combination[i] != combination[i + 1] - 1)
                return false;
        }
        return true;


//        throw new AssertionError("not implemented yet!");
    }


    /**
     * Check if array contains valid full house combination (5 "cards", initial order does not matter).
     *
     * @return true if combination is full house, false otherwise
     */
    public boolean isFullhouse(int[] combination) {
        if (combination == null || combination.length != 5) return false;
        Arrays.sort(combination);
        if(combination[1]==combination[3])
            return false;
        if (combination[0] == combination[1] && combination[3] == combination[4])
            if(combination[2]==combination[1]||combination[2]==combination[3])
                return true;
        return false;

//        throw new AssertionError("not implemented yet!");
    }

}



