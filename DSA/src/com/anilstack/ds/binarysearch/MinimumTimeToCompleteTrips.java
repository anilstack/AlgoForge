package com.anilstack.ds.binarysearch;

public class MinimumTimeToCompleteTrips {

    public static void main(String[] args) {
        int[] tripTimes = {1,2,3};
        int totalTrips = 5;
        System.out.println(MinimumTimeToCompleteTrips.findMinimumTimeToCompleteTotalTrips(tripTimes,totalTrips));
    }

    private static int findMinimumTimeToCompleteTotalTrips(int[] arr, int totalTrips) {

        long low = 1;
        long min = arr[0];

        for (int num : arr) {
            min = Math.min(min, num);
        }

        long high = min * totalTrips;

        while (low < high) {

            long mid = low + (high - low) / 2;
            long total = totalTripInGivenTime(arr,mid);

            if (total < totalTrips ) {
                low = mid + 1;
            } else {
                high = mid;
            }


        }

        return (int)low;
    }

    private static long totalTripInGivenTime(int[] arr, long givenTime) {

        long totalTrips = 0;
        for (int tripTime : arr) {
            totalTrips += ((long) givenTime) / tripTime;
        }
        return totalTrips;
    }
}
