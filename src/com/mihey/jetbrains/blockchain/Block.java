package com.mihey.jetbrains.blockchain;

import java.util.Date;

public class Block {
    private int id;
    private long timestamp;
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
        timestamp = new Date().getTime();
        hash = calculateHash();
    }

    public int getId() {
        return id;
    }

    public String getHash() {
        return hash;
    }

    private String calculateHash() {
        return StringUtil.applySha256(previousHash + id + timestamp);
    }

    @Override
    public String toString() {
        return "Block:" +
                "\nId: " + id +
                "\nTimestamp: " + timestamp +
                "\nHash of the previous block: \n" + previousHash +
                "\nHash of the block:\n" + hash + "\n";
    }
}
