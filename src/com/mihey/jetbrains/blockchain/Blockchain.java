package com.mihey.jetbrains.blockchain;

import java.security.MessageDigest;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

class Block {
    private int id;
    private int magicNumber;
    private long timeStamp;
    private long genTime;
    private String hash;
    private String prevHash;

    public Block(int id, String prevHash) {
        this.id = id;
        this.timeStamp = new Date().getTime();
        this.prevHash = prevHash;
        this.hash = getHash();
    }

    String getPrevHash() {
        return hash;
    }

    String getHash() {
        return StringUtil.applySha256(input());
    }

    String input() {
        return prevHash + id + timeStamp + magicNumber;
    }

    public String mineBlock(int prefix) {
        Random r = new Random();
        String prefixString = new String(new char[prefix]).replace('\0', '0');
        while (!hash.substring(0, prefix).equals(prefixString)) {
            magicNumber=r.nextInt(100_000_000);
            hash = getHash();
        }
        genTime = new Date().getTime() - timeStamp;
        return hash;
    }

    @Override
    public String toString() {
        return "Block:\n" +
                "Id: " + id + "\n" +
                "Timestamp: " + timeStamp + "\n" +
                "Magic number:" + magicNumber + "\n" +
                "Hash of the previous block: \n" + prevHash + "\n" +
                "Hash of the block: \n" + hash + "\n" +
                "Block was generating for " + genTime/1000 + " seconds" + "\n";
    }
}



class StringUtil {

    /* Applies Sha256 to a string and returns a hash. */
    public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            /* Applies sha256 to our input */
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte elem : hash) {
                String hex = Integer.toHexString(0xff & elem);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

public class Blockchain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many zeros the hash must start with: ");
        int prefix = sc.nextInt();
        Block[] blocks = new Block[5];
        blocks[0] = new Block(1, "0");
        blocks[0].mineBlock(prefix);
        for (int i = 1; i < 5; i++) {
            blocks[i] = new Block(i + 1, blocks[i - 1].getPrevHash());
            blocks[i].mineBlock(prefix);
        }
        for (Block b : blocks) {
            System.out.println(b.toString());
        }
    }
}
