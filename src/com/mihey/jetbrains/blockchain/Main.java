package com.mihey.jetbrains.blockchain;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter how many zeros the hash must start with: ");
        final int numberOfZeros = new Scanner(System.in).nextInt();
        BlockChain blockChain = new BlockChain(numberOfZeros);
        for (int i = 0; i < 5; i++) {
            blockChain.addBlock();
        }
        blockChain.getBlockList().forEach(System.out::println);
    }
}

