package com.anilstack.ds.heap;

import java.util.PriorityQueue;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class KthSmallestElementMatrix {
    public int kthSmallestElementWithQueue(int[][] matrix, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->(b-a));

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                queue.offer(matrix[i][j]);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }
        return queue.peek();
    }


    public int kthSmallestElement(int[][] matrix, int k) {

        int n = matrix.length, low = matrix[0][0], high = matrix[n-1][n-1];

        while (low < high) {

            int mid = low + (high - low) / 2;
            int count = lessEqual(matrix,mid);
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int lessEqual(int[][] matrix, int target) {

        int cnt = 0, n = matrix.length, i = n - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] > target) {
                i--;
            } else {
                cnt = cnt + i + 1;
                j++;
            }
        }
        return cnt;
    }




    public static void main(String[] args) {
        int[][] matrix = {
                {1,5,9 },
                {10,11,13},
                {12,13,15}
        };
        KthSmallestElementMatrix kthSmallestElementMatrix  = new KthSmallestElementMatrix();
        System.out.println(kthSmallestElementMatrix.kthSmallestElementWithQueue(matrix,8));
        System.out.println(kthSmallestElementMatrix.kthSmallestElement(matrix,8));

    }


}
