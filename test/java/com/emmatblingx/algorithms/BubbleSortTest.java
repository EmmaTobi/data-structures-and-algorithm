package com.emmatblingx.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void sort() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] data = { 3, 4, 8, 6,12};
        int[] expected = { 3, 4, 6, 8, 12};
        int[] actual = bubbleSort.sort(data);

        assertArrayEquals(expected, actual);
    }
}