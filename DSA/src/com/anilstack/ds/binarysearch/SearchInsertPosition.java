package com.anilstack.ds.binarysearch;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */

public class SearchInsertPosition {
//Given a sorted array of distinct integers and a target value, return the index if target is found.
    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        int target = 5;
        System.out.println(SearchInsertPosition.searchCorrectIndexPosition(arr,target));
    }

    private static int searchCorrectIndexPosition(int[] arr, int target) {

        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if(arr[mid]>=target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

}
