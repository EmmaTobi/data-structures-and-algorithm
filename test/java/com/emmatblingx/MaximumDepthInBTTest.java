package com.emmatblingx;

import com.emmatblingx.puzzle.MaximumDepthInBT;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumDepthInBTTest {

    @Test
    void getMaxDepth() {
        MaximumDepthInBT bt = new MaximumDepthInBT();

        assertEquals(4, bt.getMaxDepth());
    }
}