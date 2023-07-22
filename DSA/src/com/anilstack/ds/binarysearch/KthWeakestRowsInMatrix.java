package com.anilstack.ds.binarysearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthWeakestRowsInMatrix {

    public static void main(String[] args) {

        int[][] matrix = {
                {1,1,0,0,0,0,1},
                {1,1,1,1,1,1,1},
                {0,0,0,1,0,1,0},
                {1,0,0,0,0,0,0}
                         };
        System.out.println(Arrays.toString(KthWeakestRowsInMatrix.findKthWeakestRows(matrix,2)));

    }

    private static int[] findKthWeakestRows(int[][] matrix, int k) {

        Comparator<int[]> customComparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                } else {
                    //based on higher ones highes ones will get rejected.
                    return b[0] - a[0];
                }
            }
        };

        PriorityQueue<int[]> pq = new PriorityQueue<>(customComparator);

        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];

            int countOnes = getCount(row);

            pq.offer(new int[]{countOnes, i});

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int ans[] = new int[k];

        int i = k - 1;
        while (!pq.isEmpty()) {
            ans[i] = pq.poll()[1];
            i--;
        }


        return ans;
    }


    private static int getCount(int[] rows) {

        int count = 0;

        for (int el : rows) {
            if (el == 1) {
                count++;
            }
        }
        return count;
    }
}
