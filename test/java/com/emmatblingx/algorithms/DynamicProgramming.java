package com.emmatblingx.algorithms;

/**
 * O(n ^ 3)
 * All Paths within a matrix/graph
 */
public class DynamicProgramming {

    void optimisePath(int[][] matrix) {
        for(int k = 0; k < matrix.length; k++){//k maps to all possible outcomes from the view of a node
            for(int i = 0; i < matrix.length; i++){//column
                for(int j = 0; j < matrix.length; j++){//row
                    if(i == j) matrix[i][j] = 0;
                    else {
                        if (i != k && j != k) {
                            if (matrix[i][k] != -1 && matrix[k][j] != -1) { // -1 flag to denote infinity/no relationship
                                if (matrix[i][j] == -1) {
                                    matrix[i][j] = matrix[i][k] + matrix[k][j];
                                } else {
                                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]); //
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
