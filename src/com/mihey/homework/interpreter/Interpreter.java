package com.mihey.homework.interpreter;

/**
 * Interpreter for linux command:
 * - data;
 * - echo;
 * - ls;
 * - head;
 * - tail;
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

abstract class Reader {
    List<String> readFromFile(File file) {
        if (!file.exists()) {
            System.out.println("cannot open " + file + " for reading: No such file or directory");
        }
        if (file.isDirectory()) {
            System.out.println("error reading " + file + ": Is a directory");
        }
        List<String> reader = new ArrayList<>();
        int count = 0;
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                reader.add(count, line);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reader;
    }
}

class Head extends Reader {                        // prints the first 10 lines of a given file (head linux)
    void getHead(File file) {
        List<String> head = readFromFile(file);
        for (int i = 0; i < head.size() && i < 10; i++) {
            System.out.println(head.get(i));
        }
    }
}

class Tail extends Reader {                      // prints the last 10 lines of a given file (tail linux)
    void getTail(File file) {
        List<String> tail = readFromFile(file);
        int size = tail.size();
        if (size > 10) {
            for (int i = tail.size() - 10; i < tail.size(); i++) {
                System.out.println(tail.get(i));
            }
        } else {
            for (String s : tail) {
                System.out.println(s);
            }
        }
    }
}

class ListNames {                              //displays information about files in the current folder
    String getPathNames(File file) {
        int remove = file.toString().length();
        File[] pathName = file.listFiles();
        StringBuilder sb = new StringBuilder();
        for (File f : pathName) {
            sb.append(f.toString().substring(remove + 1) + "\t");
        }
        return sb.toString();
    }
}

public class Interpreter {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("load properties file");
            return;
        }
        Date d = new Date();
        ListNames list = new ListNames();
        Head head = new Head();
        Tail tail = new Tail();
        Properties prop = new Properties();
        prop.load(new FileReader(args[0]));
        File file = new File(prop.getProperty("interpreter"));
        File currDir = new File(".");
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                if (line.matches("date *")) {
                    System.out.println(d);
                }
                if (line.matches("echo .*")) {
                    System.out.println(line.substring(5));
                }
                if (line.matches("ls *")) {
                    System.out.println(list.getPathNames(currDir));
                }
                if (line.matches("head .*")) {
                    head.getHead(new File(line.substring(5)));
                }
                if (line.matches("tail .*")) {
                    tail.getTail(new File(line.substring(5)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




