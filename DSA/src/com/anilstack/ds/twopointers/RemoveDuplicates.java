package com.anilstack.ds.twopointers;
/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 4, 4, 4};
        int output = RemoveDuplicates.removeDuplicates(nums);
        System.out.println(output);
    }

    private static int removeDuplicates(int[] nums) {

        int oIndex = 0;
        int i = 0;
        while (i < nums.length) {
            int sIndex = i;
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
            int length = i - sIndex + 1;
            //in output array we can have a same number to be 2 times in a row.
            int freq = Math.min(length, 2);

            while (freq-- > 0) {
                nums[oIndex] = nums[sIndex];
                oIndex++;
            }
            i++;
        }

        return oIndex;
    }

}
