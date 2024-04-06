package com.anilstack.ds.matrix;

import java.util.Arrays;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class DiagonalTraverse {

    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.toString(findDiagonalOrder(grid)));
    }

    public static int[] findDiagonalOrder(int[][] matrix) {

        int m = matrix.length;
        if (m==0) return new int[]{};
        int n = matrix[0].length;
        if (n==0) return new int[]{};

        int[] ans = new int[m*n];
        int row = 0;
        int col = 0;
        for (int i = 0; i < m * n; i++) {
            ans[i] = matrix[row][col];
            if ((row+col) %2 == 0) {
                //if it is even then upward directions
                if (col == n-1) {
                    row++;
                } else if (row == 0) {
                    col++;
                } else {
                    row--;
                    col++;
                }
            } else {
                //if it is odd then downward directions
                if (row == m-1) {
                    col++;
                } else if (col==0) {
                    row++;
                } else {
                    row++;
                    col--;
                }
            }
        }
        return ans;
    }

}
