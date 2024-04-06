package com.anilstack.ds.dp;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class climbingStars {

    public static void main(String[] args) {
        int n=3;
        System.out.println(climbingStars(n));
    }

    public static int climbingStars(int n) {

        int[] dp = new int[n+1];
        dp[1] = 1;
        if (n==1) return 1;
        dp[2] = 2;
        for (int i=3;i<n;i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
