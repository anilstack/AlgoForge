package com.anilstack.ds.dp;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class UniquePaths {
    /**
     * There is a robot on an m x n grid. The robot is initially located at the top-left corner
     * (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
     * The robot can only move either down or right at any point in time.
     * @param args
     */
    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println(findUniquePaths(m,n));
    }

    public static int findUniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        for (int i=0; i<m; i++) {
            //fill columns default values
            dp[i][0] = 1;
        }

        for (int j=0; j<n; j++) {
            //fill rows default values
            dp[0][j] = 1;
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

}
