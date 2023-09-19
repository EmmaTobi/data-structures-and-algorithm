package com.emmatblingx.leetcode;

import java.util.Arrays;
//4
//PAYPALISHIRING
//PINALSIGYAHRPI
//3
//PAYPALISHIRING
//PAHNAPLSIIGYIR
public class ZigZagConversion {
        public String convert(String s, int numRows) {
            if(numRows == 1) return s;

            String[] result = new String[numRows];
            Arrays.fill(result, "");

            //This is the interval for each items in the first row
            int boundInterval = 2 * (numRows - 1);

            int bound = 0;
            int current = 0;
            while (current < s.length()){
                if(current % boundInterval == 0) {
                    bound += boundInterval;
                    result[0] += s.charAt(current);
                } else if(current >=  (((bound - boundInterval)  + bound) / 2)){
                    result[bound - current] += s.charAt(current);
                } else {
                    result[current - (bound - boundInterval)] += s.charAt(current);
                }

                ++current;
            }

            StringBuilder r = new StringBuilder();
            for(String item: result){
                r.append(item);
            }

            return r.toString();
        }
}
