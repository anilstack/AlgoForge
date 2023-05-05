package com.anilstack.ds.twopointers;

import java.util.Arrays;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2,11,7,15};
        int[] indices = TwoSum.twoSum(nums, 9);
        System.out.println(Arrays.toString(indices));
    }

    private static int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length-1;
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                return new int[] {start, end};
            }  else if (nums[start] + nums[end] > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[]{-1,-1};
    }
}
