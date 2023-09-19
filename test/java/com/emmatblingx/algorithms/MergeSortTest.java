package com.emmatblingx.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void merge() {
        MergeSort mergeSort = new MergeSort();

        int[] a = {3,4, 20};
        int[] b = {2,5, 8 };
        int[] expected = {2, 3, 4, 5, 8, 20};

        int[] actual = mergeSort.merge(a, b);

        assertArrayEquals(expected, actual);

        a = new int[]{1,4, 5};
        b = new int[]{6, 8, 10, 20 };
        expected = new int[]{1, 4, 5, 6, 8, 10, 20};

        actual = mergeSort.merge(a, b);
        assertArrayEquals(expected, actual);

        a = new int[]{1, 2, 5, 6};
        b = new int[]{6, 8, 9, 9 };
        expected = new int[]{1, 2, 5, 6, 6, 8, 9, 9};

        actual = mergeSort.merge(a, b);

        assertArrayEquals(expected, actual);
    }

    @Test
    void sort() {
        MergeSort mergeSort = new MergeSort();
        int[] data = { 3, 4, 8, -3, 6, 12, -1};
        int[] expected = { -3, -1, 3, 4, 6, 8, 12};
        int[] actual = mergeSort.sort(data);

        for (int a: actual) {
            System.out.println(a);
        }

        assertArrayEquals(expected, actual);
    }
}