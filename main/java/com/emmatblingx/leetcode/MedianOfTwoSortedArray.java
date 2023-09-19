package com.emmatblingx.leetcode;

public class MedianOfTwoSortedArray {
    // observing the solutions for medians of two sorted arrays,
    // we can deduce that medians occur at the middle point of the s0lution result(array)
    // the left side of the median are always lesser than the median,
    // the right side of the median is always greater then the median
    // hence we try to partition both arrays such that each side have approx equal number of elements
    //partition the smallest array such that
    //partitionXleft < partitionYright
    //partitionYleft > partitionXleft
    //Assume negative infinity if left border is reached of num1
    //Assume positive infinity if right border is reached of num1
    // if sum of array length is even
    //median = (Max (partitionXleft, partitionYleft) + Min(partitionXright, partitionXleft)) / 2
    // if sum of array length is odd
    //median = Max (partitionXleft, partitionYleft)
    public double getMedianOfTwoSortedArray(int[] num1, int[] num2){
        //ensure num1 is the smallest array
        if (num1.length > num2.length) getMedianOfTwoSortedArray(num2, num1);

        int x = num1.length;
        int y = num2.length;

        int start = 0;
        int end = x;

        while(start <= end){
            int partitionX = (start + end) / 2;
            int partitionY = ((x + y + 1) / 2) - partitionX;

            int partitionXLeft = partitionX == 0 ? Integer.MIN_VALUE : num1[partitionX - 1];
            int partitionXRight = partitionX == x ? Integer.MAX_VALUE : num1[partitionX];

            int partitionYLeft = partitionY == 0 ? Integer.MIN_VALUE : num2[partitionY - 1];
            int partitionYRight = partitionY == y ? Integer.MAX_VALUE : num2[partitionY];

            if(partitionXLeft <= partitionYRight && partitionYLeft <= partitionXRight){
                return (x + y) % 2 == 0 ?
                        (Math.max(partitionXLeft, partitionYLeft) + Math.min(partitionXRight, partitionYRight)) / 2.0 :
                        Math.max(partitionXLeft, partitionYLeft);

            } else if (partitionXLeft > partitionYRight) {
                end = partitionX - 1;
            } else {
                start = partitionX + 1;
            }
        }

        throw new IllegalArgumentException("Array not sorted");
    }
}
