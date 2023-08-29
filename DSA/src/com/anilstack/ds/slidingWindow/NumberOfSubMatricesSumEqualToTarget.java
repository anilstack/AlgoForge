package com.anilstack.ds.slidingWindow;

import java.util.Arrays;

public class NumberOfSubMatricesSumEqualToTarget {

    public static void main(String[] args) {

        int[][] matrix = {
                            {0,1,2},
                            {3,4,5},
                            {6,7,8}
                         };
        int target = 5;

        System.out.println(NumberOfSubMatricesSumEqualToTarget.numSubmatrixSumTarget(matrix,target));


    }


    private static int numSubmatrixSumTarget(int[][] matrix, int target) {

        int rowCount = matrix.length;
        int columnCount = matrix[0].length;

        int[] summedRow = new int[columnCount];
        int ans = 0;
//outer loop is for covering all possible sub-matrixs
        for (int i = 0; i < rowCount; i++) {
            Arrays.fill(summedRow,0);
            for (int j = i; j < rowCount; j++) {
                for (int k = 0; k < columnCount; k++) {
                    summedRow[k] += matrix[j][k];
                }

                ans += SubArraySumEqualToK.findContinuousSubArraysSumEqualToK(summedRow,target);

            }
        }


        return ans;
    }

}
