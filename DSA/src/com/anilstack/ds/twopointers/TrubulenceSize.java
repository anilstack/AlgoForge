package com.anilstack.ds.twopointers;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class TrubulenceSize {

    public static void main(String[] args) {
        int[] nums = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        int maxSize = TrubulenceSize.findMaxTrubulenceSize(nums);
        System.out.println(maxSize);
    }

    private static int findMaxTrubulenceSize(int[] nums) {

        if (nums.length < 2) return nums.length;

        int max = 1;
        int start = 0;
        int end = 0;
        int len = nums.length;

        while (start + 1 < len) {
            if (nums[start] == nums[start + 1]) {
                start++;
                continue;
            }
            end = start + 1;
            while (end + 1 < len && isValleyORMountain(nums, end)) {
                end++;
            }
            max = Math.max(max, end - start + 1);
            start = end;
        }
        return max;
    }

    private static Boolean isValleyORMountain(int[] nums, int k) {
        return (nums[k] > nums[k - 1] && nums[k] > nums[k + 1] || nums[k] < nums[k - 1] && nums[k] < nums[k + 1]);
    }

}
