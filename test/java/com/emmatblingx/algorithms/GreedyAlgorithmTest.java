package com.emmatblingx.algorithms;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GreedyAlgorithmTest {

    @Test
    void scheduleClass() {
        GreedyAlgorithm ga = new GreedyAlgorithm();
        List<GreedyAlgorithm.Subject> subjects = ga.scheduleClass();

        assertEquals(subjects.size(), 3);

    }
}