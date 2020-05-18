package com.mihey.io;

import java.io.*;
import java.util.*;

public class UniqueWords {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("load properties file");
            return;
        }
        Properties prop = new Properties();
        prop.load(new FileReader(args[0]));
        File file = new File(prop.getProperty("TheInvisibleMan"));
        String line;
        int count = 0;
        Map<String, Integer> map = new TreeMap<>();
        if (file.exists() && file.isFile()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                while ((line = br.readLine()) != null) {
                    String[] words = line.replace(",", "").replace(".", "").
                            replace("(","").replace(")","").
                            replace("‑","").replace("«","").
                            replace("[","").replace("]","").
                            replace(":", "").replace(";", "").replace("'", "").
                            replace("\"", "").replace("?", "").replace("–", "").
                            replace("!", "").replace("...", "").toLowerCase().split(" ");
                    for (String w : words) {
                        if (w.length() > 4) {
                            if (!map.containsKey(w)) {
                                count++;
                                map.put(w, 1);
                            } else {
                                map.put(w, map.get(w) + 1);
                            }
                        }
                    }
                }
            }
            map.remove("");
            System.out.println(count);

        } else {
            System.out.println("file doesn't exist");
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("/home/mihey/words.csv"))) {
            for (String s : map.keySet()) {
                bw.write(s + ", " + map.get(s) + "\n");
            }
        }

    }
}