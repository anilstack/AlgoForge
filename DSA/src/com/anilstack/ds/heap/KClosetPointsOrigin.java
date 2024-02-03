package com.anilstack.ds.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class KClosetPointsOrigin {


    public int[][] kCloset(int[][] points, int k) {

        // sum of the squares of the values in the arrays.
        // 0 is x co-ordinate and 1 is y co-ordinate.
        // Distance from origin (0,0) to co-ordinate i.e (3,3) etc. distance^2 = x^2 + y^2
        //(b[0]−a[0])^2 + +(b[1]−a[1])^2 = (5-3)^2 + (-1-3)^2
        // = 2^2 + (-4)^2
        // = 4 + 16
        // = 20
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>( (a,b) -> ( b[0]*b[0] + b[1]*b[1] - a[0]*a[0] - a[1]*a[1] ));

        for (int[] point : points) {
            priorityQueue.offer(point);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        int[][] res = new int[priorityQueue.size()][k];
        int count = 0;
        while (!priorityQueue.isEmpty()) {
            res[count] = priorityQueue.poll();
            count++;
        }
        return res;
    }




    public static void main(String[] args) {
        int[][] input = {{3,3},{5,-1},{-2,4}};
        int k = 2;
        KClosetPointsOrigin kClosetPointsOrigin = new KClosetPointsOrigin();
        System.out.println(Arrays.deepToString(kClosetPointsOrigin.kCloset(input,k)));

    }


}
