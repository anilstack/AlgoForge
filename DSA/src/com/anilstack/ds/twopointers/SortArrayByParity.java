package com.anilstack.ds.twopointers;

import java.util.Arrays;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class SortArrayByParity {

    public static void main(String[] args) {
        int[] nums = {1,3,4,6,5,7,8,10};
        int[] result = SortArrayByParity.sortArray(nums);
        System.out.println(Arrays.toString(result));
    }

    private static int[] sortArray(int[] nums) {

        int n = nums.length;
        int oddNoAtEvenIndex = 0;
        int evenNoAtOddIndex = 1;

        while (oddNoAtEvenIndex < n && evenNoAtOddIndex < n) {

            while (oddNoAtEvenIndex < n && nums[oddNoAtEvenIndex] %2 != 0) {
                    oddNoAtEvenIndex+=2;
            }

            while (evenNoAtOddIndex < n && nums[evenNoAtOddIndex] %2 == 0) {
                evenNoAtOddIndex+=2;
            }

            if (evenNoAtOddIndex < n && oddNoAtEvenIndex < n) {
                swap(nums,oddNoAtEvenIndex, evenNoAtOddIndex);
            }


        }



        return nums;
    }

    private static void swap(int[] nums, int i, int j) {

        if (i!=j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    }



}
