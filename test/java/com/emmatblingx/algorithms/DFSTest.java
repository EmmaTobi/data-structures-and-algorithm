package com.emmatblingx.algorithms;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DFSTest {

    @Test
    void getLongestPath() {
        DFS dfs = new DFS();

        List<DFS.Node> longestPath = dfs.getLongestPath("book", "piano");

        for (DFS.Node node: longestPath) {
            System.out.println(node.name);
        }

        int expected = 4;
        assertEquals(expected, longestPath.size());
    }
}