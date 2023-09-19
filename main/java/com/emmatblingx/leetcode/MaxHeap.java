package com.emmatblingx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Complete Binary Tree in which each sub-child of the parent is less than or equal to the parent
 */
public class MaxHeap {
    List<Integer> items = new ArrayList<>();

    public static void heapifyMax(int[] nums) {
        for(int i = nums.length - 1; i >= 0; --i) {
            siftUp(nums, i,  ((i + 1) * 2), ((i + 1) * 2) + 1);
        }
    }

    /**
     * O(logn)
     * @param num
     */
    void push (int num) {
        items.add(num);
        int current = items.size() - 1;
        int parent = items.size() / 2;

        while(parent > 0) {
            if (items.get(parent - 1) < items.get(current) ) {
                swap(items, parent - 1, current);
                current = parent - 1;
                parent = parent / 2;
            } else {
                return;
            }
        }
    }

    boolean isEmpty() {
        return items.isEmpty();
    }

    /**
     * O(logn)
     * @return
     */
    int pop () {
        int deletedItem = items.remove(0);
        if (!items.isEmpty()) {
            items.add(0, items.remove(items.size() - 1));
            siftDown(items, 0);
        }

        return deletedItem;
    }

    @Override
    public String toString() {
        return items.toString();
    }

    private static void siftDown(List<Integer> items, int parentIndex) {
        int leftChild = (int)Math.pow(2, parentIndex);
        int rightChild = ((int)Math.pow(2, parentIndex)) + 1;
        int maxIndex = 0;

        if (leftChild < items.size() || rightChild < items.size()) {
            if (leftChild >= items.size() && items.get(rightChild) > items.get(parentIndex)) {
                maxIndex = rightChild;
                swap(items, maxIndex, parentIndex);
            } else if(rightChild >= items.size() && items.get(leftChild) > items.get(parentIndex)) {
                maxIndex = leftChild;
                swap(items, maxIndex, parentIndex);
            } else if (leftChild < items.size() && rightChild < items.size()) {
                maxIndex = Math.max(items.get(leftChild), items.get(rightChild)) == items.get(leftChild) ? leftChild: rightChild;
                if(items.get(maxIndex) > items.get(parentIndex)) {
                    swap(items, maxIndex, parentIndex);
                }
            }

            siftDown(items, maxIndex);
        }
    }

    private static void siftUp(int[] nums, int i, int leftChild, int rightChild) {
        int maxIndex = -1;

        if (leftChild <= nums.length || rightChild <= nums.length) {
            if (leftChild > nums.length && nums[rightChild - 1] > nums[i]) {
                maxIndex = rightChild - 1;
                swap(nums, maxIndex, i);
            } else if(rightChild > nums.length && nums[leftChild - 1] > nums[i]) {
                maxIndex = leftChild - 1;
                swap(nums, maxIndex, i);
            } else if (leftChild <= nums.length && rightChild <= nums.length) {
                maxIndex = Math.max(nums[leftChild - 1], nums[rightChild - 1]) == nums[leftChild - 1] ? leftChild - 1 : rightChild - 1;
                if(nums[maxIndex] > nums[i]) {
                    swap(nums, maxIndex, i);
                }
            }

            siftUp(nums, maxIndex, (i + 1) * 2, ((i + 1) * 2) + 1);
        }
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private static void swap(List<Integer> items, int index1, int index2) {
        int temp = items.get(index1);
        int temp2 = items.get(index2);
        items.remove(index1);
        items.add(index1, temp2);
        items.remove(index2);
        items.add(index2, temp);
    }
}
