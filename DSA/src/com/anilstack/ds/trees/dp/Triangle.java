package com.anilstack.ds.trees.dp;

import java.util.List;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class Triangle {

    /**
     * Given a triangle array, return the minimum path sum from top to bottom.
     *
     * For each step, you may move to an adjacent number of the row below.
     * More formally, if you are on index i on the current row,
     * you may move to either index i or index i + 1 on the next row.
     * @param args
     *
     *
     *    2
     *   3 4
     *  6 5 7
     * 4 1 8 3
     */

    public static void main(String[] args) {

       // List<List<Integer>>  triangle = [[2],[3,4],[6,5,7],[4,1,8,3]];

        List<List<Integer>> triangle = List.of(
                List.of(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3)
        );

        System.out.println(minSum(triangle));
    }

    private static int minSum(List<List<Integer>> triangle) {

        int[] dp = new int[triangle.size()+1];


        for (int i = triangle.size() - 1; i >= 0; i--) {

            for (int j = 0; j < triangle.get(i).size(); j++) {

                dp[j] = Math.min(dp[j],dp[j+1]) + triangle.get(i).get(j);
            }

        }
        return dp[0];
    }
}
