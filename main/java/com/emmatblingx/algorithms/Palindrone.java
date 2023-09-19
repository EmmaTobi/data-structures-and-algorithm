package com.emmatblingx.algorithms;

import java.util.Stack;

public class Palindrone {

    boolean v1(int number) {
        Stack<Character> st = new Stack<>();
        st.empty();

        if (number  < 0) return false;

        String num = String.valueOf(number);
        int end = num.length() - 1;
        int start = 0;

        while(start <= end) {
            if(num.charAt(start++) == num.charAt(end--)) return false;
        }

        return true;
    }


    boolean v2(int number) {
        if (number  < 0) return false;

        return number == reverse(number);
    }

    int counter = 0;

    int reverse(int number) {
        int digit = number - ((number / 10) * 10);
        if (number < 10) return digit;

        return reverse(number / 10) + ((digit * (int)Math.pow(10, ++counter)));
    }
}
