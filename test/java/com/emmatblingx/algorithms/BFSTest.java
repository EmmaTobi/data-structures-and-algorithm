package com.emmatblingx.algorithms;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BFSTest {

    @Test
    void search() {
        BFS bfs = new BFS();

        BFS.Node actual = bfs.search("CAB", "BAT");

        assertNotNull(actual);
    }

    @Test
    void getShortestPath() {
        BFS bfs = new BFS();

        List<BFS.Node> shortestPath = bfs.getShortestPath("CAB", "BAT");

        for (BFS.Node node: shortestPath) {
            System.out.println(node.name);
        }

        int expected = 3;
        assertEquals(expected, shortestPath.size());
    }
}