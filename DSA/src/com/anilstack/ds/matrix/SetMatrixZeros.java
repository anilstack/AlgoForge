package com.anilstack.ds.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class SetMatrixZeros {

    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
    }

    public static void setZeros(int[][] matrix) {

        List<Integer> rowZeros = new ArrayList<>();
        List<Integer> colZeros = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for  (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][i] == 0) {
                    rowZeros.add(i);
                    colZeros.add(j);
                }
            }
        }

        for (int rowIndex : rowZeros) {
            makeRowZero(matrix,rowIndex);
        }

        for (int colIndex : colZeros) {
            makeColZero(matrix,colIndex);
        }
        return;
    }

    private static void makeRowZero(int[][] matrix, int rowIndex) {
        for (int j=0; j<matrix[0].length; j++) {
            matrix[rowIndex][j]=0;
        }
    }

    private static void makeColZero(int[][] matrix, int colIndex) {
        for (int i=0; i<matrix.length; i++) {
            matrix[i][colIndex] = 0;
        }
    }
}
