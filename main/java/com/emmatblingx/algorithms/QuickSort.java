package com.emmatblingx.algorithms;

public class QuickSort {
    /**
     * Here in a collection, attempt is made to ensure for a given index
     * all items after the index are partially sorted relative to that index element
     * for example [2,3,1] = items
     * starting at index 0, relative to element 2, the left element (3) should be less than the right element (1)
     * in our case it isnt, so we swap, [2,1,3],
     * notice the left index crossed path the right index i.e
     * left index which was 1 now is 2
     * right index which was 2 now is 1,
     * when left index > right index
     * swap right index element with current iteration index element
     * repeat this process for all items in the list
     *
     * 0(NlogN), S(LogN)
     * @param data
     * @return
     */
    public int[] sort(int[] data){
        for(int i = 0; i < data.length; ++i){
            int temp;
            int left = i + 1;
            int right = data.length - 1;

            while(left <= right){
                if((data[left] > data[i]) && (data[right] < data[left])) {
                    temp = data[left];
                    data[left] = data[right];
                    data[right] = temp;
                }

                if(data[left] < data[i]){
                    ++left;
                }

                if(data[right] > data[i]){
                    --right;
                }
            }

            temp = data[i];
            data[i] = data[right];
            data[right] = temp;
        }

        return data;
    }
}
