package com.emmatblingx.algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DynamicProgrammingTest {

    @Test
    void optimisePath() {
        DynamicProgramming dp = new DynamicProgramming();
        int[][] matrix = {
                {0, 3, -1, 7},
                {8, 0, 2, -1},
                {5, -1, 0, 1},
                {2, -1, -1, 0},
        };
        dp.optimisePath(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}