package com.emmatblingx.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindroneTest {

    @Test
    void v1() {
        Palindrone p = new Palindrone();

        assertFalse(p.v1(100));
    }

    @Test
    void v2() {
        Palindrone p = new Palindrone();

        assertTrue(p.v2(1221));
    }
}