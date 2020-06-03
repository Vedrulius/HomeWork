package com.mihey.homework.collections.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.mihey.homework.randomstring.RandomString.generateRandomString;

public class RandomList {
    public List<String> generateRandomList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity of the list can't be negative");
        }
        List<String> list = new ArrayList<>(capacity);
        Random r = new Random();
        for (int i = 0; i < capacity; i++) {
            list.add(generateRandomString(1 + r.nextInt(10)));
        }
        return list;
    }

    public static void main(String[] args) {
        RandomList r=new RandomList();
        System.out.println(r.generateRandomList(5));
    }
}
