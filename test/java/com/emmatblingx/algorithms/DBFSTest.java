package com.emmatblingx.algorithms;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DBFSTest {

    @Test
    void getFastestPath() {
        DBFS dbfs = new DBFS();

        List<DBFS.Node> shortestPath = dbfs.getFastestPath("book", "piano");

        for (DBFS.Node node: shortestPath) {
            System.out.println(node.name);
        }

        int expected = 4;
        assertEquals(expected, shortestPath.size());
    }
}