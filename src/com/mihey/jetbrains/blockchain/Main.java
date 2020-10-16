package com.mihey.jetbrains.blockchain;

public class Main {
    public static void main(String[] args) {
        BlockChain blockChain = new BlockChain();
        for (int i = 0; i < 5; i++) {
            blockChain.addBlock();
        }
        blockChain.getBlockList().forEach(System.out::println);
    }
}

