package com.mihey.blockchain;

import java.util.Date;
import java.util.Random;

public class Block {
    private int id;
    private long timeStamp;
    private long genTime;
    private int magicNumber;
    private String previousHash;
    private String hash;

    public Block(Block prevBlock) {
        if (prevBlock == null) {
            id = 1;
            previousHash = "0";
        } else {
            id = prevBlock.getId() + 1;
            previousHash = prevBlock.getHash();
        }
        timeStamp = new Date().getTime();
        hash = calculateHash();
    }

    public int getId() {
        return id;
    }

    public String getHash() {
        return hash;
    }

    private String calculateHash() {
        return StringUtil
                .applySha256(previousHash + id + timeStamp + magicNumber);
    }

    private String mineBlock(int prefix) {
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
                "Hash of the previous block: \n" + previousHash + "\n" +
                "Hash of the block: \n" + hash + "\n" +
                "Block was generating for " + genTime/1000 + " seconds" + "\n";
    }
}
