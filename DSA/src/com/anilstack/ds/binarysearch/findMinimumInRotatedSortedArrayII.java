package com.anilstack.ds.binarysearch;

public class findMinimumInRotatedSortedArrayII {

    public static void main(String[] args) {
        //we are giving rotated sortedArray find min. in that.
        int[] nums = {100,120,120,1,1,3,6,7,20,60,80,90,100,100};
        int[] nums1 = {120,120,120,120,10,120,120};

        System.out.println(findMinimumInRotatedSortedArrayII.findMinimum(nums));

    }

    private static int findMinimum(int[] arr) {

        int low = 0;
        int high = arr.length-1;

        while (low < high) {

            int mid = low + (high - low) / 2;
            if (arr[mid] < arr[high]) {
                high = mid;
            } else if (arr[mid] == arr[high]) {
                high = high - 1;
            } else {
                low = mid + 1;
            }

        }
        return arr[low];
    }
}
