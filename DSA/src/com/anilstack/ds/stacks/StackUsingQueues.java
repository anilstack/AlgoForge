package com.anilstack.ds.stacks;


import java.util.LinkedList;
import java.util.Queue;
/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class StackUsingQueues {

    private static Queue<Integer> queue = new LinkedList<>();


    //push, top, pop, empty need to use queues only.
    public static void main(String[] args) {
        push(10);
        System.out.println(top());
        System.out.println(pop());
        System.out.println(empty());

    }

    private static void push(int x) {
        queue.add(x);
        int size = queue.size()-1;
        while (size-- > 0) {
            //reverse the entire queue
            queue.add(queue.poll());
        }
    }

    private static int pop() { return queue.poll(); }

    private static int top() { return queue.peek(); }

    private static boolean empty() { return queue.isEmpty(); }

}
