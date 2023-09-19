package com.emmatblingx.algorithms;

/**
 * Bisect array till we reach the lowest points in the tree
 * Merge arrays
 * O(nlogn) , S(n)
 * bisection -> (O(log(n)) * merge -> (0(n))
 */
public class MergeSort {
    public int[] sort(int[] data){
        return bisectData(data, 0, data.length - 1);
    }

    private int[] bisectData(int[] data, int start, int end) {
        if(end <= start) {
            return new int[]{data[start]};
        }

        int mid = (start + end) / 2;

        return merge(
                bisectData(data, start, mid),
                bisectData(data, mid + 1, end)
        );
    }

    public int[] merge(int[] a, int[] b) {
        if(b.length == 0) return a;
        if(a.length == 0) return b;

        int[] result = new int[a.length + b.length];

        int i = 0, j = 0;
        int k = 0;


        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                result[k] = a[i];
                i++;
            } else {
                result[k] = b[j];
                j++;
            }

            ++k;
        }

        while (i < a.length) {
            result[k] = a[i];
            i++;
            k++;
        }

        while (j < b.length) {
            result[k] = b[j];
            j++;
            k++;
        }

        return result;
    }
}
