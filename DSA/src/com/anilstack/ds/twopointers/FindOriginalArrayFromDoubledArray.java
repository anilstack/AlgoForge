package com.anilstack.ds.twopointers;

import java.util.Arrays;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class FindOriginalArrayFromDoubledArray {

    public static void main(String[] args) {
        int [] changedArray = {1,3,4,2,6,8};
        int[] orginalArray = FindOriginalArrayFromDoubledArray.findOriginalArray(changedArray);
        System.out.println(Arrays.toString(orginalArray));
    }

    private static int[] findOriginalArray(int[] changedArray) {

        if (changedArray.length%2 != 0) {
            return new int[]{};
        }

        int mid = changedArray.length/2;
        int[] ans = new int[mid];
        int [] freq = new int[100001];

        for (int num : changedArray) {
            freq[num]++;
        }

        int index = 0;
        for (int num = 0; num < freq.length; num++) {
            while (freq[num] > 0 && num * 2 < 100001 && freq[num * 2] > 0) {
                freq[num]--;
                freq[num*2]--;
                if (freq[num*2] < 0) {
                    return new int[]{};
                }
                ans[index] = num;
                index++;
            }
        }

        for (int i = 0; i<freq.length; i++) {
            if (freq[i] != 0) {
                return new int[]{};
            }
        }

        return ans;
    }
}
