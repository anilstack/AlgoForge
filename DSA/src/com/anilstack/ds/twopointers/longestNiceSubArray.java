package com.anilstack.ds.twopointers;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class longestNiceSubArray {

    public static void main(String[] args) {
        int[] nums = {1,3,8,48,10};
        int length = longestNiceSubArray.longestNiceSubArray(nums);
        System.out.println(length);
    }
//sliding window if two numbers bitwise and is equal to 0 then it is nice sub array. subarray is continuous.
    private static int longestNiceSubArray(int[] nums) {

        int startIndex = 0;
        int ans = 0;

        int bitsUnion = 0;

        for (int i = 0; i < nums.length; i++) {
            int newEl = nums[i];

            while ((bitsUnion & newEl) != 0) {
                //violates the window
                int startingEl = nums[startIndex];
                //removing elements from start
                bitsUnion ^= startingEl;
                startIndex++;
            }
            //happy case
            //including new element
            bitsUnion = bitsUnion | newEl;
            ans = Math.max(ans, i - startIndex + 1);
        }
        return ans;
    }
}
