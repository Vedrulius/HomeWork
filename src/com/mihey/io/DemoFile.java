package com.mihey.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DemoFile {
    public static void main(String[] args) throws IOException {
        File file = new File("/home/mihey/file.txt");
        FileWriter writer = new FileWriter(file);

        writer.write(1122);
        writer.write("Java");

        writer.close();

        try (PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.print("Hello"); // prints a string
            printWriter.println("Java"); // prints a string and then terminates the line
            printWriter.println(123); // prints a number
            printWriter.printf("You have %d %s", 400, "gold coins"); // prints a formatted string
            printWriter.printf("%s dolor sit %s", "Lorem", "ipsum", "amet");
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }
}

