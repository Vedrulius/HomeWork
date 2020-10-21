package com.mihey.jetbrains.blockchain;

import java.util.ArrayList;
import java.util.List;

public class BlockChain {
    private List<Block> blockList;
    private int numberOfZeros;

    public BlockChain(int numberOfZeros) {
        blockList = new ArrayList<>();
        this.numberOfZeros = numberOfZeros;
    }

    public void addBlock() {
        if (blockList.isEmpty()) {
            blockList.add(new Block(null,numberOfZeros));
        } else {
            blockList.add(new Block(blockList.get(blockList.size() - 1),numberOfZeros));
        }
    }

    public List<Block> getBlockList() {
        return List.copyOf(blockList);
    }

}
