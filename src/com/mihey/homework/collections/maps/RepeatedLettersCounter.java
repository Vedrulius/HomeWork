package com.mihey.homework.collections.maps;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class RepeatedLettersCounter {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) throw new ArrayIndexOutOfBoundsException("No path");
        Properties prop = new Properties();
        prop.load(new FileReader(args[0]));
        File file = new File(prop.getProperty("fileToList"));
        Map<Character, Integer> map = new HashMap<>();
        if (file.exists() && file.isFile()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    char[] letters = line.toCharArray();
                    for (char c : letters) {
                        if (Character.isLetter(c)) {
                            if (!map.containsKey(c)) {
                                map.put(c, 1);
                            } else {
                                Integer value = map.get(c);
                                map.put(c, value + 1);
                            }
                        }
                    }

                }
            }
        } else {
            System.out.println("File does not exist");
        }
        System.out.println(map);
    }
}
