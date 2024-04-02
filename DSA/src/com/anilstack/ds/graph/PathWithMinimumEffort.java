package com.anilstack.ds.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class PathWithMinimumEffort {

    private static int[] directions = new int[]{0,1,0,-1,0};

    public static void main(String[] args) {
        int[][] heights =   {
                                {1,2,3},
                                {3,8,2},
                                {5,3,5}
                            };
        System.out.println(minimumEffort(heights));
    }

    public static int minimumEffort(int[][] heights) {

        int rowsLength = heights.length;
        int columnsLength = heights[0].length;

        int[][] efforts = new int[rowsLength][columnsLength];

        for (int[] effort:efforts) {
            Arrays.fill(effort,Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        efforts[0][0] = 0;

        pq.offer(new int[]{0,0,0});


        while (!pq.isEmpty()) {

            int[] head = pq.poll();
            int x = head[1];
            int y = head[2];
            int currentEffort = head[0];
            if (x == rowsLength-1 && y == columnsLength-1) {
                return currentEffort;
            }

        for (int k=0; k<4;k++) {
            int newX = x + directions[k];
            int newY = y + directions[k+1];

            if (newX >= 0 && newX < rowsLength && newY >= 0 && newY < columnsLength) {
                int nextEffort = Math.max(currentEffort, Math.abs(heights[newX][newY] - heights[x][y]));
                if (nextEffort < efforts[newX][newY]) {
                    efforts[newX][newY] = nextEffort;
                    pq.offer(new int[] {nextEffort,newX,newY});
                }
            }
        }
        }
        return 0;
    }
}
