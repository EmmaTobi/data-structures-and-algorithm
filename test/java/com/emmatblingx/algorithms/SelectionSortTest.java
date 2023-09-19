package com.emmatblingx.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    @Test
    void sort() {
        SelectionSort selectionSort = new SelectionSort();
        int[] data = { 3, 4, 8, 6,12};
        int[] expected = { 3, 4, 6, 8, 12};
        int[] actual = selectionSort.sort(data);

        assertArrayEquals(expected, actual);
    }
}