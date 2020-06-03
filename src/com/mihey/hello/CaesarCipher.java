package com.mihey.hello;

public class CaesarCipher {
    public String encrypte(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        for (int i = 0; i < input.length(); i++) {
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(currChar);
            if (idx != -1) {
                char newChar = shiftedAlphabet.charAt(idx);
                encrypted.setCharAt(i, newChar);

            }
        }
        return encrypted.toString();
    }

    public static void main(String[] args) {
        CaesarCipher cc=new CaesarCipher();
        System.out.println(cc.encrypte("ABC",1));
    }
}
