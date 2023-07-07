package com.anilstack.ds.binarysearch;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */

public class SearchTwoDMatrixII {


    //given an 2d matrix where rows and columns are sorted in nature and we need to identify the target value exist in the matrix or not.
    //if exists return true else false.
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3, 4},
                {2, 4, 6, 8},
                {3, 6, 9, 12},
                {4, 8, 12, 16}
        };

        int[][] firstMatrix = {
                {1,5,9},
                {10,11,13},
                {12,13,15}
        };


        System.out.println(SearchTwoDMatrixII.findTargetTest(matrix,20));

    }

    private static boolean findTargetTest(int[][] firstMatrix, int target) {

        int row = firstMatrix.length;
        int column = 0;

        if (row != 0) column = firstMatrix[0].length;

        //which is pointing to last row.
        int i = row - 1;
        //pointing to columns of current row.
        int j = 0;

        while (i>=0 && j < column) {

            int currentValue = firstMatrix[i][j];

            if (currentValue == target) {
                return true;
            } else if (currentValue > target) {
                i--;
            } else if (currentValue < target) {
                j++;
            }
        }

        return false;
    }









    //Two pointers Approach Row pointer points to last row and column pointer points to first column.
    private static boolean findTarget(int[][] matrix, int target) {


        int rows = matrix.length;
        int columns = 0;

        if (rows!=0) columns = matrix[0].length;

        if (columns == 0 || rows == 0) return false;

        //last row index
        int i = rows-1;
        //column index currently we are at.
        int j = 0;

        while (i > 0 && j < columns) {
            int curr = matrix[i][j];
            if (curr == target) {
                return true;
            } else if (curr > target) {
                i--;
            } else {
                j++;
            }
        }

        return false;
    }
}
