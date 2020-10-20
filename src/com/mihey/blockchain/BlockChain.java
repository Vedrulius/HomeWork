package com.mihey.blockchain;

import java.util.ArrayList;
import java.util.List;

public class BlockChain {
    private List<Block> blockList;

    public BlockChain() {
        blockList = new ArrayList<>();
    }

    public void addBlock() {
        if (blockList.isEmpty()) {
            blockList.add(new Block(null));
        } else {
            blockList.add(new Block(blockList.get(blockList.size() - 1)));
        }
    }

    public List<Block> getBlockList() {
        return List.copyOf(blockList);
    }
}
