package com.emmatblingx.algorithms;

public class BubbleSort {
    // 0(n square)
    public int[] sort(int[] data){
        for(int i = 1; i < (data.length - 1); ++i){
            for(int j = 1; j < (data.length -  i); ++j){
                if(data[j - 1] > data[j]){
                    int temp = data[j - 1];
                    data[j - 1] = data[j];
                    data[j] = temp;
                }
            }
        }

        return data;
    }
}
