package com.anilstack.ds.twopointers;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class MaximumScorePerformingMultiplication {

    private static int n,m;
    private static Integer[][] memo;

    public static void main(String[] args) {
            int[] nums = {1,2,3,4};
            int[] muls = {3,2,1,4};
            MaximumScorePerformingMultiplication MaximumScorePerformingMultiplication = new MaximumScorePerformingMultiplication();
        //    int maximumScore = MaximumScorePerformingMultiplication.maximumScore(nums,muls);
            int maximumScore = MaximumScorePerformingMultiplication.maximumScoreBottomUpApproach(nums,muls);
            System.out.println(maximumScore);
    }

//given nums and muls array we need to identify max score that can be generated after performing 'm' operations.
//m - length of muls array.
//we need to select num from muls array and multiply with left most index or the right most index in nums array.
//after performing 'm' operations one for each element in muls array we need to tell what is the max. score that can be generated.

//DynamicProgramming
 private int maximumScore(int[] nums, int[] muls) {
        n = nums.length;
        m = muls.length;
        this.memo = new Integer[m+1][m+1];
//        return dp(0, n - 1, nums, muls, 0);
        return dp(0, 0, nums, muls);
    }

    private static int dp(int l, int i, int[] nums, int[] muls) {

        if (i == m) return 0;

        if (memo[l][i] != null) return memo[l][i];

        int pickLeft = dp(l+1, i+1, nums, muls) + nums[l] * muls[i];
        int pickRight = dp(l, i+1, nums, muls) + nums[n-(m-1)-1] * muls[i];
        Arrays.stream(memo)
                .map(row -> Arrays.stream(row)
                        .map(val -> String.valueOf(val))
                        .collect(Collectors.joining(" ")))
                .forEach(System.out::println);
        return memo[l][i] = Math.max(pickLeft,pickRight);

    }

// Bottom Up Approach

        public int maximumScoreBottomUpApproach(int[] nums, int[] multipliers) {
            int n = nums.length, m = multipliers.length;
            int[][] dp = new int[m + 1][m + 1];

            // m denotes the multiplier index
            for(int i = m -1; i >= 0; i--){
                // left denotes the current left end index
                for(int left = 0; left <= i; left++){
                    int right = left + n - i - 1; // Using left index we can get the right index

                    if(i == m - 1){ // If we are calculating for last index of multiplier, it is either multiplication with left element or right element
                        dp[left][i] = Math.max(nums[left] * multipliers[i], nums[right] * multipliers[i]);
                    } else { // Else it will be maximum of chossing either left or right with sum of already calculated step.
                        dp[left][i] = Math.max(nums[left] * multipliers[i] + dp[left + 1][i+1], nums[right] * multipliers[i] + dp[left][i+1]);
                    }
                }
            }

            return dp[0][0];
        }
    }


