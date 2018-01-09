package com.mihey.homework.collections.maps;

import com.mihey.homework.collections.Person;
import com.mihey.homework.collections.PersonComparator;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        Map<Integer,String> map=new TreeMap<>();
        map.put(1, "Home");
        map.put(2, "Andrey home");
        map.put(3, "Home2");
        map.put(-3, "Home3");
        map.put(-3, "Home4");
        map.put(-4, "Home5");
        map.put(5, "Home6");
        map.get(1);
        String s="asdgh";
    }
}
