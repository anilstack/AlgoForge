package com.anilstack.ds.dp;

import java.util.Arrays;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class ProductArrayExpectSelf {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(Arrays.toString(findProductExpectSelf(arr)));
    }

    public static int[] findProductExpectSelf(int[] nums) {

        int[] ans = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        int leftPrefixProduct = 1;
        for(int i=0; i <nums.length; i++) {
            leftPrefixProduct *= nums[i];
            left[i] = leftPrefixProduct;
        }

        int rightPrefixProduct = 1;
        for (int i=nums.length-1;i>=0;i--) {
            rightPrefixProduct *= nums[i];
            right[i] = rightPrefixProduct;
        }

        for (int i=0; i<nums.length; i++) {
            int leftProduct = i>=1?left[i-1]:1;
            int rightProduct = i<nums.length-1?right[i+1]:1;
            ans[i] = leftProduct * rightProduct;
        }

        return ans;
    }



}
