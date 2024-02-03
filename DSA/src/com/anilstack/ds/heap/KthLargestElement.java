package com.anilstack.ds.heap;

import java.util.PriorityQueue;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class KthLargestElement {


    private PriorityQueue<Integer> minHeap = null;
    private final int k;

    public KthLargestElement(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for (Integer num : nums) {
           System.out.println(add(num));
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
    public static void main(String[] args) {

        KthLargestElement kthLargestElement = new KthLargestElement(3,new int[]{4,5,8,2,1,3,7,6,9});


    }


}
