package com.mihey.homework.collections;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class FileToList {
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
            System.out.println(list);
            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i).length() < 3)
                    list.remove(i);
            }
            System.out.println(list);

        } else {
            System.out.println("File does not exist");
        }

    }
}
