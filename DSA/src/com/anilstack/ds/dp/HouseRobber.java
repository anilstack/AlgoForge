package com.anilstack.ds.dp;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class HouseRobber {

    /**
     * You are a professional robber planning to rob houses along a street.
     * Each house has a certain amount of money stashed,
     * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
     *
     * Given an integer array nums representing the amount of money of each house,
     * return the maximum amount of money you can rob tonight without alerting the police.
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(houseRobber(nums));
    }

    public static int houseRobber(int[] nums) {

        if (nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0],nums[1]);
        } else {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = nums[1];
            dp[2] = nums[0] + nums[2];
            int maxRobberyAmount = Math.max(dp[2],dp[1]);
            for (int i=3; i < nums.length; i++) {
                dp[i] = Math.max(nums[i-2],nums[i-3])+nums[i];
                maxRobberyAmount = Math.max(maxRobberyAmount,dp[i]);
            }
            return maxRobberyAmount;
        }
    }
}
