package com.mihey.jetbrains;

/**
 * Encrypte and decrypte message input from console? fomat:
 * first line: "enc" or "dec" without
 */

import java.util.Scanner;

public class EncrypteDecrypte {
    public String encrypte(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            char newChar = (char) (encrypted.charAt(i) + key);
            encrypted.setCharAt(i, newChar);
        }
        return encrypted.toString();
    }

    public String decrypte(String input, int key) {
        StringBuilder decrypted = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            char newChar = (char) (decrypted.charAt(i) - key);
            decrypted.setCharAt(i, newChar);
        }
        return decrypted.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String type = sc.nextLine();
        String input = sc.nextLine();
        int key = sc.nextInt();
        EncrypteDecrypte enc = new EncrypteDecrypte();
        if (type.equals("enc")) {
            System.out.println(enc.encrypte(input, key));
        }
        if (type.equals("dec")) {
            System.out.println(enc.decrypte(input, key));
        }
    }
}
