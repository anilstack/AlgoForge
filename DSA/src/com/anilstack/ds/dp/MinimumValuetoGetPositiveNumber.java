package com.anilstack.ds.dp;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class MinimumValuetoGetPositiveNumber {

    public static void main(String[] args) {
        int[] nums = {-3,2,-3,4,2};
        System.out.println(findMinimumPositiveNumber(nums));
    }

    public static int findMinimumPositiveNumber(int[] nums) {

        int min = 0;
        int prefixSum = 0;
        for (int num:nums) {
            prefixSum += num;
            min = Math.min(prefixSum,min);
        }
        // x +(min number) >= 1
        return min < 0 ? Math.abs(min) + 1 : 1;
    }

}
