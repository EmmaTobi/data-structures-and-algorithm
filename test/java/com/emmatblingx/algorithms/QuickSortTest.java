package com.emmatblingx.algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void sort() {
        QuickSort quickSort = new QuickSort();
        int[] data = { 3, 4, 8, -3, 6, 12, -1};
        int[] expected = { -3, -1, 3, 4, 6, 8, 12};
        int[] actual = quickSort.sort(data);

        assertArrayEquals(expected, actual);
    }
}