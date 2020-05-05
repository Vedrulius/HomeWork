package com.mihey.exeptions;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class ThrowsDemo {
    public static void main(String args[])
    {
        String str;
        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(System.in));
//        Chapter 10:  Using I/O
        System.out.println("Enter text ('stop' to quit).");
        try (FileWriter fw = new FileWriter("test.txt"))
        {
            do {
                System.out.print(": ");
                str = br.readLine();
//                Create a FileWriter.
                if(str.equals("stop")) break;
                str = str + "\r"; // add newline
                fw.write(str);
//                Write strings to the file.
            } while(!str.equals("stop"));
        } catch(IOException exc) {
            System.out.println("I/O Error: " + exc);
        }
    }
}
