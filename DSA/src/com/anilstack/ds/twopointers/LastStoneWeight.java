package com.anilstack.ds.twopointers;

import java.util.PriorityQueue;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class LastStoneWeight {

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        int lastStone = LastStoneWeight.findLastStoneWeight(stones);
        System.out.println(lastStone);
    }

    private static int findLastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> (b-a));

        for (int stone:stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
                int largestElement = maxHeap.poll();
                int secondLargestElement = maxHeap.poll();
                if (largestElement==secondLargestElement) {
                    continue;
                } else {
                    int diff = largestElement - secondLargestElement;
                    maxHeap.offer(diff);
                }
        }
        return maxHeap.size() == 0 ? 0 : maxHeap.poll();
    }
}
