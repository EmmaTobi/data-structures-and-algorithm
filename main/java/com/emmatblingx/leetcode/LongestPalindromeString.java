package com.emmatblingx.leetcode;

public class LongestPalindromeString {
    // start index of the longest palindrome in the string
    int resultStart = 0;

    // length of max palindrome in the string
    int resultLen = 0;

    //Palindromes are words/strings, which are equal to its reversed form
    public String longestPalindromeString(String s){
        //palindromes of string s lesser than 2 is same as s
        if(s.length() < 2) return s;

        // loop all string
        for (int start = 0; start < s.length(); ++start) {
            // At every point in the string, we check if the current point is a middle point
            // for a possible palindrome, all palindrones have middle point
            // If the length of string ids even, then it has two middle point
            // if the length of string is od, then it has just one middle point
            // for case of s length is odd, we consider a point as middle
            expandFromMiddle(s, start, start);
            // for case of s length is even, we consider two point as middle
            expandFromMiddle(s, start, start + 1);
        }

        return s.substring(resultStart, resultStart + resultLen);
    }

    private void expandFromMiddle(String s, int start, int end) {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            --start;
            ++end;
        }

        if( resultLen < end - start - 1) {
            resultStart = start + 1;
            resultLen = end - start - 1;
        }
    }
}