package com.mihey.homework.collections;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileToList {
    private List<String> filterByLength(List<String> list, int length) { // list filtered by length < length
        Iterator<String> li = list.listIterator();
        while (li.hasNext()) {
            if (li.next().length() < length) {
                li.remove();
            }
        }
        return list;
    }

    private List<String> removeDuplicates(List<String> list) {  // list without duplicates
        for (int i = list.size() - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (list.get(i).equals(list.get(j)))
                    list.remove(j);
            }
        }
        return list;
    }

    private List<String> removeDupWithSet(List<String> list) {
        Set<String> set = new HashSet<>();
        set.addAll(list);
        list.clear();
        list.addAll(set);
        return list;
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("No path");
            return;
        }
        Properties prop = new Properties();
        prop.load(new FileReader(args[0]));
        File file = new File(prop.getProperty("fileToList"));
        List<String> list = new ArrayList<>();
        if (file.exists() && file.isFile()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) { // try-with-resources
                String line;
                while ((line = br.readLine()) != null) {
                    String[] tokens = line.replace(",", "").replace(".", "").split(" ");//remove "." and ","
                    list.addAll(Arrays.asList(tokens));
                }
            }
        } else {
            System.out.println("File does not exist");
        }
        System.out.println(list);
    }
}
