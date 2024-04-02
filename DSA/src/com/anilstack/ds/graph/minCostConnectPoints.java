package com.anilstack.ds.graph;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class minCostConnectPoints {

    public static void main(String[] args) {
       int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
       System.out.println(minCostToConnectAllPoints(points));

    }


    public static int minCostToConnectAllPoints(int[][] points) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a,b) -> a[2] - b[2]);
        int cost = 0;

        minHeap.offer(new int[] {1,1,0});
        Set<Integer> visited = new HashSet<>();
        int num = points.length;
        while (!minHeap.isEmpty() && visited.size() < num)  {

            int[] curr = minHeap.poll();
            int endIndex = curr[1];
            int currentCost = curr[2];

            if (visited.contains(endIndex)) continue;

            cost += currentCost;
            visited.add(endIndex);
            for (int i = 0 ; i < num; i++) {
                if (!visited.contains(i)) {
                    minHeap.offer(new int[]{endIndex,i,distance(points,endIndex,i)});
                }
            }
        }
        return cost;
    }

    private static int distance(int[][] points, int i , int j) {
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1]- points[j][1]);
    }




}
