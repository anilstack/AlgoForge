package com.anilstack.ds.twopointers;


import java.util.Arrays;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class ValidTriangleNumber {

    public static void main(String[] args) {
        int[] arr = {2,6,7,8,16,21};
        System.out.println(ValidTriangleNumber.findValidTriangle(arr));
    }

    private static int findValidTriangle(int[] arr) {

        int maxTriangles = 0;
        if (arr.length < 3) return maxTriangles;
        Arrays.sort(arr);

        for (int i = 2; i < arr.length; i++) {
            int left = 0;
            int right = i -1;

            while (left < right) {
                if (arr[left] + arr[right] > arr[i]) {
                    maxTriangles = right - left;
                    right--;
                } else {
                    left++;
                }
            }

        }
        return maxTriangles;
    }
}
