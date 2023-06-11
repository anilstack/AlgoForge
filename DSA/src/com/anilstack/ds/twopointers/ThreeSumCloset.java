package com.anilstack.ds.twopointers;

import java.util.Arrays;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class ThreeSumCloset {
    public static void main(String[] args) {
        int [] nums = {-1,2,1,-4};
        int target = 3;
        int closetSum = ThreeSumCloset.findClosetNumber(nums,target);
        System.out.println(closetSum);
    }

    public static int findClosetNumber(int[] arr, int target) {

        Arrays.sort(arr);
        int closetSum = arr[0] + arr[1] + arr[arr.length - 1];

        for (int i = 0; i < arr.length - 2; i++) {
            int start = i + 1;
            int end = arr.length - 1;
            while (start < end) {
                int currentSum = arr[i] + arr[start] + arr[end];
                if (currentSum > target) {
                    end--;
                } else if (currentSum < target) {
                    start++;
                }

                if (Math.abs(currentSum - target) < Math.abs(closetSum - target)) {
                    closetSum = currentSum;
                }
            }

        }
        return closetSum;
    }
}
