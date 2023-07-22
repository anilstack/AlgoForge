package com.anilstack.ds.binarysearch;

public class findMinimumInRotatedSortedArrayI {

    public static void main(String[] args) {
        //given rotated sorted array find minimum number exist in array.
        int[] nums = {3,4,5,1,2};
        int[] nums1 = {120,150,2,40,0,70,80,90,91,92,94,96,98,99,100};
        System.out.println(findMinimumInRotatedSortedArrayI.findMinimumNumber(nums));

    }

    private static int findMinimumNumber(int[] nums) {
        //if mid element is lower than the high element.(from mid element to high array is sorted so minelement is mid only).
        int low = 0;
        int high = nums.length-1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[high]) {
                 high = mid;
            } else {
                 low = mid + 1;
            }
        }
        return nums[low];
    }
}
