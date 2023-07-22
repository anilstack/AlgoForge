package com.anilstack.ds.binarysearch;

public class SplitArrayLargestSum {

    public static void main(String[] args) {

        int[] arr = {7,2,5,10,8};
        int m = 2;
        System.out.println(SplitArrayLargestSum.splitArray(arr,m));
    }

    //given an array which consists of non-negative numbers and integer m, you can split array into m non-empty
    //continuous subarrays.
    //write algorithm to minimize the largest sum among these m subarrays.
    private static int splitArray(int[] arr, int m) {

        int maxNo = 0;
        long total = 0;

        for (int element : arr) {
            maxNo = Math.max(element,maxNo);
            total += element;
        }

        long low = maxNo;
        long high = total;

        while(low < high) {
            long mid = low + (high - low) / 2;
            if (isDivisionPossible(arr, mid, m)) {
                high = mid;
            } else {
                low = mid + 1;
            }

        }

        return (int) low;
    }

    private static boolean isDivisionPossible(int [] arr, long maxPossibleSum, int m) {

        int totalSubsetCount = 1;
        int totalRunningSum = 0;

        for (int num : arr) {

            totalRunningSum += num;

            if (totalRunningSum > maxPossibleSum) {

                totalRunningSum = 0;
                totalRunningSum += num;
                totalSubsetCount++;

            }

            if (totalSubsetCount > m) {
                return false;
            }

        }

        return true;
    }
}
