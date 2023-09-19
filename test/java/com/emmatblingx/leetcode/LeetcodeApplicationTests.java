package com.emmatblingx.leetcode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class LeetcodeApplicationTests {

    @Test
    void medianOfTwoSortedArrays() {
        int[] num1 = {1,2,3};
        int[] num2 = {4,5};
        MedianOfTwoSortedArray medianOfTwoSortedArray = new MedianOfTwoSortedArray();
        double actual = medianOfTwoSortedArray.getMedianOfTwoSortedArray(num1, num2);
        double expected = 3.0;
        assertEquals(expected, actual);

        num1 = new int[]{4, 7, 8};
        num2 = new int[]{4, 5, 6};

        actual = medianOfTwoSortedArray.getMedianOfTwoSortedArray(num1, num2);
        expected = 5.5;
        assertEquals(expected, actual);
    }

}
