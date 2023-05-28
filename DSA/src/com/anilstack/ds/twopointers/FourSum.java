package com.anilstack.ds.twopointers;

import java.util.HashMap;
import java.util.Map;
/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class FourSum {

    public static void main(String[] args) {
        int nums1[] = {1, 2};
        int nums2[] = {-2, -1};
        int nums3[] = {-1, 2};
        int nums4[] = {0, 2};
        int result = FourSum.fourSum(nums1, nums2, nums3, nums4);
        System.out.println(result);
    }

    //SC: O(n2)
    private static int fourSum(int A[], int B[], int C[], int D[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum_AB = A[i] + B[j];
                map.put(sum_AB, map.getOrDefault(sum_AB, 0) + 1);
            }
        }

        int ans = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum_CD = C[i] + D[j];
                int sum_AB = -sum_CD;
                ans += map.getOrDefault(sum_AB, 0);
            }
        }

        return ans;
    }

}
