package com.mihey.jetbrains;

/**
 * Encrypt and decrypt message input from command-line arguments, format:
 * The program must parse three arguments: -mode, -key and -data.
 * The first argument should determine the program’s mode
 * (enc - encryption, dec - decryption). The second argument is an integer
 * key to modify the message, and the third argument is a text or
 * ciphertext within quotes to encrypt or decrypt.
 * Example: java EncryptDecrypt -mode enc -key 5 -data "Welcome to Java!"
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EncryptDecrypt {

    public String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);  // -mode enc -key 5 -in in.txt -out output.txt
        for (int i = 0; i < input.length(); i++) {
            char newChar = (char) (encrypted.charAt(i) + key);
            encrypted.setCharAt(i, newChar);
        }
        return encrypted.toString();
    }

    public String decrypt(String input, int key) {
        StringBuilder decrypted = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            char newChar = (char) (decrypted.charAt(i) - key);
            decrypted.setCharAt(i, newChar);
        }
        return decrypted.toString();
    }

    public static String readFileAsString(String fileName) throws IOException {
        Scanner sc = new Scanner(new File(fileName));
        StringBuilder a = new StringBuilder("");
        while (sc.hasNext()) {
            a.append(sc.nextLine());
        }
        return a.toString();
        //        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static void writeToFile(String text, String pathToFile) throws IOException {
        File file = new File(pathToFile);
        FileWriter writer = new FileWriter(file);
        writer.write(text);
        writer.close();
    }

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < args.length - 1; i += 2) {
            map.put(args[i], args[i + 1]);
        }

        String type = "enc";
        int key = 0;
        String input = "";
        String pathToFile = "";

        if (map.containsKey("-key")) {
            key = Integer.parseInt(map.get("-key"));
        }

        if (map.containsKey("-mode")) {
            type = map.get("-mode");
        }

        if (map.containsKey("-data") /*|| !map.containsKey("-out")*/) {
            input = map.get("-data");
        }


        if (map.containsKey("-in") && map.containsKey("-out") && !map.containsKey("-data")) {
            pathToFile = "./" + map.get("-out");
            try {
                input = readFileAsString("./" + (map.get("-in")));
            } catch (IOException e) {
                System.out.println("Error");
            }

        }

        EncryptDecrypt enc = new EncryptDecrypt();

        if (type.equals("enc")) {
            if (map.containsKey("-data") || !map.containsKey("-out")) {
                System.out.println(enc.encrypt(input, key));
            } else {
                try {
                    writeToFile(enc.encrypt(input, key), pathToFile);
                } catch (IOException e) {
                    System.out.println("Error");
                }
            }
        }

        if (type.equals("dec")) {
            if (map.containsKey("-data") || !map.containsKey("-out")) {
                System.out.println(enc.decrypt(input, key));
            } else {
                try {
                    writeToFile(enc.decrypt(input, key), pathToFile);
                } catch (IOException e) {
                    System.out.println("Error");
                }
            }
        }
    }
}
