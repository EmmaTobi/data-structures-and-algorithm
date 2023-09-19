package com.emmatblingx.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class HeapTest {

    @Test
    void heapify() {
        int [] nums = {23, 1, 67, 54, 32, 100};
        MaxHeap.heapifyMax(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    void push() {
        MaxHeap heap = new MaxHeap();
        heap.push(23);
        heap.push(1);
        heap.push(67);
        heap.push(54);
        heap.push(32);
        heap.push(100);

        System.out.println(heap);
    }

    @Test
    void pop() {
        MaxHeap heap = new MaxHeap();
        heap.push(23);
        heap.push(1);
        heap.push(67);
        heap.push(54);
        heap.push(32);
        heap.push(100);

        while (!heap.isEmpty()) {
            System.out.println(heap.pop());
        }
    }
}