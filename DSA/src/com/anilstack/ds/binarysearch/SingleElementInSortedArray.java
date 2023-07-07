package com.anilstack.ds.binarysearch;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */

public class SingleElementInSortedArray {

    //given an array of integers which is sorted in nature every element appears exactly twice, except for one element which appears exactly once.
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,8,8};
        System.out.println(SingleElementInSortedArray.findSingleElement(arr));
    }

    private static int findSingleElement(int[] arr) {

        int low = 0;
        int high = arr.length-1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if ((mid % 2 == 1 && arr[mid-1]==arr[mid]) || ((mid % 2 == 0) && arr[mid] == arr[mid+1])) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return arr[low];
    }
}
