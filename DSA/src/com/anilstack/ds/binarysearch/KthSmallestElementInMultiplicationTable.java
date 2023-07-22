package com.anilstack.ds.binarysearch;

public class KthSmallestElementInMultiplicationTable {

    public static void main(String[] args) {
//by using below m and n this multiplication matrix will form.
//        int[][] multiplication = {
//                {1, 2, 3},
//                {2, 4, 6},
//                {3,6,9}
//        };

        int m = 3, n = 3, k = 5;
        System.out.println(KthSmallestElementInMultiplicationTable.findKThSmallestElement(m,n,k));
    }


    private static int findKThSmallestElement(int rows, int cols, int k) {

        int low = 1;
        int high = rows * cols;

        while (low < high) {

            int mid = low + (high - low) / 2;
            int count = count(mid,rows, cols);

            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static int count(int mid, int rows, int cols) {

        int count = 0;
        for (int i = 1; i <= rows; i++ ) {
            int temp = Math.min(mid/i,cols);
            count += temp;
        }
        return count;
    }

}
