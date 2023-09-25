package com.anilstack.ds.interivew;

import java.util.Arrays;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class ProductOfNumberExceptSelf {


    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};
        int result[] = findProduct(arr);

        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(findProductExceptSelfBestApproach(arr)));
    }

    private static int[] findProduct(int[] arr) {

        int resultArray[] = new int[arr.length];
        int totalProduct = 1;

        for (int i =0; i < arr.length; i++) {
            totalProduct *= arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            resultArray[i] = totalProduct / arr[i];
        }

        return resultArray;
    }


    private static int[] findProductExceptSelfBestApproach(int[] nums) {

        int [] leftProduct = new int[nums.length];
        int [] rightProduct = new int[nums.length];

        leftProduct[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
        }

        rightProduct[nums.length-1] = 1;
        for (int i = nums.length - 2; i > -1; i--) {
            rightProduct[i] = rightProduct[i+1] * nums[i+1];
        }

        int [] ans = new int[nums.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = leftProduct[i] * rightProduct[i];
        }
        return ans;


    }
}
