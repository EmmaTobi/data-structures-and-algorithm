package com.emmatblingx.algorithms;

public class InsertionSort {
    /**
     * Here we assume the left side is a list of sorted items
     * for each iteration , we wonna right place the current iteration element in the right order
     * in the sorted listed
     * in place sorting
     */
    public int[] sort(int[] data){
        for(int i = 1; i < data.length ; ++i){
            for(int j = i - 1; j >= 0 ; --j){
                if(data[j] > data[j + 1]){
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }

        return data;
    }
}
