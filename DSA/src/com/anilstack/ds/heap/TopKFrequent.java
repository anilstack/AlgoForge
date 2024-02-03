package com.anilstack.ds.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>( (a,b)-> b[1]-a[1] );

        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {

            priorityQueue.offer(new int[]{entry.getKey(),entry.getValue()});

        }

        int[] ans = new int[k];

        while (k > 0) {
            ans[k-1] = priorityQueue.poll()[0];
            k--;
        }

        return ans;

    }


    public static void main(String[] args) {
        int[] input = {1,1,1,2,2,3};
        int k = 2;
        TopKFrequent topKFrequent = new TopKFrequent();
        System.out.println(Arrays.toString  (topKFrequent.topKFrequent(input,k)));
    }
}
