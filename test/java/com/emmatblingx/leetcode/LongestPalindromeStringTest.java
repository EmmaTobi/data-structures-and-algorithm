package com.emmatblingx.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromeStringTest {

    @Test
    void longestPalindromeString() {
        String word = "aaaabbaaaa";
        LongestPalindromeString longestPalindromeString = new LongestPalindromeString();
        String actual = longestPalindromeString.longestPalindromeString(word);
        String expected = "aaaabbaaaa";

        assertEquals(expected, actual);
    }
}