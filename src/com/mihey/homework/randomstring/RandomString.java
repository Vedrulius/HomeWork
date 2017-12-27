package com.mihey.homework.randomstring;

import java.util.Random;

public class RandomString {
    public static String generateRandomString(int limit) {
        if (limit <= 0) return "Limit must be positive";
        StringBuilder result = new StringBuilder();
        Random randomABC = new Random();
        for (int i = 0; i < limit; i++) {
            result.append((char) ('a' + randomABC.nextInt(26)));
        }
        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println("\"" + generateRandomString(5) + "\"");
    }
}
