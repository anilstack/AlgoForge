package com.anilstack.ds.heap;

import java.util.PriorityQueue;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class FurthestBuilding {
    public int furthestBuilding(int[] heights,int bricks,int ladders) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < heights.length - 1; i++) {

            int gap = heights[i+1] - heights[i];

            if (gap > 0) {
                priorityQueue.add(gap);
            }

            if (priorityQueue.size() > ladders) {
                bricks -= priorityQueue.poll();
            }

            if (bricks < 0) {
                return i;
            }
        }
        return heights.length - 1;
    }

    public static void main(String[] args) {
        int[] heights = {4,12,2,7,3,18,20,3,19};
        FurthestBuilding furthestBuilding = new FurthestBuilding();
        System.out.println(furthestBuilding.furthestBuilding(heights,8,2));
    }
}
