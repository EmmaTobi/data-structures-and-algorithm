package com.emmatblingx.algorithms;

public class SelectionSort {
    /**
     * Each iteration,
     * we try to get the index of min item in the list
     * then swap with current iteration index
     * O(n ^ 2), S(1)
     * @param data
     * @return
     */
    public int[] sort(int[] data) {
        for(int i = 0; i < data.length ; ++i) {
            int min = i;
            for(int j = i+1; j < data.length; ++j){
                if(data[i] > data[j]){
                    min = j;
                }
            }
            // constant amount of swappings (1)
            int temp = data[i];
            data[i] = data[min];
            data[min] = temp;
        }

        return data;
    }
}
