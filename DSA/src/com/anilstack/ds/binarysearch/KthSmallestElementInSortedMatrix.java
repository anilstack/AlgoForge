package com.anilstack.ds.binarysearch;

import java.util.PriorityQueue;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */

public class KthSmallestElementInSortedMatrix {

    public static void main(String[] args) {

        int[][] matrix = {
                            {1,5,9},
                            {10,11,13},
                            {12,13,15}
                         };
        //find 8th element in above matrix and return.
        int target = 3;

     //   System.out.println(KthSmallestElementInSortedMatrix.findKthSmallestElementUsingHeap(matrix, target));
        System.out.println(KthSmallestElementInSortedMatrix.findKthSmallestElementTest(matrix, target));


    }

    private static int findKthSmallestElementTest(int[][] matrix, int k) {

//        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> (b-a));
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                heap.offer(matrix[i][j]);
//                if (heap.size() > k) {
//                    heap.poll();
//                }
//            }
//        }
//        return heap.peek();

        int n = matrix.length;
        //here we are doing binary search on values and try to identify mid value and identify at which index it will fall.
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int correctIndexForMid = findCorrectIndexForMid(matrix,mid);
            if (correctIndexForMid > k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int findCorrectIndexForMid(int[][] matrix, int mid) {

        int n = matrix.length;
        int row = n - 1;
        int col = 0;
        int counter = 0;

        while (row >=0 && col < n) {

            if (matrix[row][col] > mid) {
                row--;
            } else {
                counter = counter + row + 1;
                col++;
            }
        }
        return counter;
    }









    private static int findKthSmallestElement(int[][] matrix, int target) {

        //we will apply binary search not on the indexs rather on range.

        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];

        while (low < high) {

            int mid = low + (high - low) / 2;
            int rank =  findLessEqual(matrix, mid);
            if (rank < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private static int findLessEqual(int[][]matrix, int mid) {

        int count = 0, n = matrix.length, row = n - 1, col = 0;
        while (row >= 0 && col < n) {
            if (matrix[row][col] > mid) {
                row--;
            } else {
                count = count + row + 1;
                col++;
            }
        }
        return count;
    }

    private static int findKthSmallestElementUsingHeap(int[][] matrix, int target) {

        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> (b-a));

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                heap.offer(matrix[i][j]);
                if (heap.size() > target) {
                    heap.poll();
                }
            }
        }
        return heap.peek();
    }


}
