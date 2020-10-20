package com.mihey.jetbrains.blockchain;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many zeros the hash must start with: ");
        int prefix=sc.nextInt();
        BlockChain blockChain = new BlockChain();
        for (int i = 0; i < 5; i++) {
            blockChain.addBlock();
        }
        blockChain.getBlockList().forEach(System.out::println);
    }
}

