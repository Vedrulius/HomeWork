package com.mihey.hello;


import java.util.*;
import java.util.stream.Collectors;

class MapUtils {

    public static SortedMap<String, Integer> wordCount(String[] strings) {
        SortedMap<String,Integer> map = new TreeMap<>();

        for (String s : strings) {
            if(!map.containsKey(s)) {
                map.put(s,1);
            } else{
                map.put(s,map.get(s)+1);
            }
        }
        return Arrays.stream(strings).collect(Collectors.toMap(s -> s, s -> 1, Integer::sum, TreeMap::new));
    }

    public static void printMap(Map<String, Integer> map) {
        map.forEach((key,value)-> System.out.println(key + ": " + value));
    }

}

/* Do not change code below */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        MapUtils.printMap(MapUtils.wordCount(words));
    }
}





