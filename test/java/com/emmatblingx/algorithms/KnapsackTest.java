package com.emmatblingx.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnapsackTest {

    @Test
    void fillBags() {
        Knapsack knapsack = new Knapsack();
        knapsack.fillBags(15);
    }
}