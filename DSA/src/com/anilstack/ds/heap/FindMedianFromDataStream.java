package com.anilstack.ds.heap;

import java.util.PriorityQueue;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class FindMedianFromDataStream {


    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>( (a,b) -> (b-a) );
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> (a-b));

    public void addNum(int num) {

        if (maxHeap.size() == 0 || maxHeap.peek() >= num) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        balance();
    }

    public double findMedian() {

        if (maxHeap.size() >= minHeap.size()) {
            return maxHeap.peek();
        } else if (maxHeap.size() < minHeap.size()) {
            return minHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }

    }



    private void balance() {

        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.peek());
        } else if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.offer(minHeap.peek());
        }

    }


    public static void main(String[] args) {
        FindMedianFromDataStream findMedianFromDataStream = new FindMedianFromDataStream();
        findMedianFromDataStream.addNum(1);
        findMedianFromDataStream.addNum(2);
        //findMedianFromDataStream.addNum(3);
        System.out.println(findMedianFromDataStream.findMedian());
    }

}
