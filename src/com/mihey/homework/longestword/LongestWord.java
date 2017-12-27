package com.mihey.homework.longestword;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class LongestWord {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("No path");
            return;
        }
        Properties prop = new Properties();
        prop.load(new FileReader(args[0]));
        File file = new File(prop.getProperty("fileToList"));
        String result = "";
        int longest = 0;
        if (file.exists() && file.isFile()) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String allText = line.replace(",", "").replace(".", "");//remove "." and ","
                String[] arrText = allText.split(" "); //text to string array
                for (int i = 0; i < arrText.length; i++) {
                    if (longest <= arrText[i].length()) {
                        result = arrText[i];
                        longest = arrText[i].length();
                    }
                }
            }
            br.close();
            System.out.println("The longest word is: " + result + ". And it's length: " + longest);
        } else
            System.out.println("File does not exist");
    }
}


