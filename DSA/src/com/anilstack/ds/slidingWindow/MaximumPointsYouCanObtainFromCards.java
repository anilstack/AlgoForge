package com.anilstack.ds.slidingWindow;

public class MaximumPointsYouCanObtainFromCards {
    //max we need to return max of k elements
    public static void main(String[] args) {

        int[] points = {10,2,3,4,1,3,40,9,1,3};
        int k = 5;
        System.out.println(MaximumPointsYouCanObtainFromCards.findMaxPoints(points,k));
    }
//TC: O(K)
    private static int findMaxPoints(int[] points, int k) {

        int kElementSum = 0;
        for (int i = 0; i < k; i++) {
            kElementSum += points[i];
        }

        int length = points.length;
        int maxSum = kElementSum;

        int i = 0;

        while (i < k) {
            // sub left point and add right most point.
            kElementSum = kElementSum - points[k-1-i] + points[length-1-i];
            maxSum = Math.max(maxSum,kElementSum);
            i++;
        }

        return maxSum;
    }
}
