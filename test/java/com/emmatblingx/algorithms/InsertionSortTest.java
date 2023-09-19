package com.emmatblingx.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    @Test
    void sort() {
        InsertionSort insertionSort = new InsertionSort();
        int[] data = { 3, 4, 8, 6,12, -1, 0, 7};
        int[] expected = { -1, 0, 3, 4, 6, 7, 8, 12};
        int[] actual = insertionSort.sort(data);

        assertArrayEquals(expected, actual);
    }
}