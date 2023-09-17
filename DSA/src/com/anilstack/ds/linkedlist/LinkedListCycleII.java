package com.anilstack.ds.linkedlist;

import com.anilstack.ds.util.SingleNode;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class LinkedListCycleII {

    public static void main(String[] args) {
        SingleNode head = new SingleNode(3);
        SingleNode node2 = new SingleNode(2);
        SingleNode node0 = new SingleNode(0);
        SingleNode nodeNeg4 = new SingleNode(-4);

        // Connect the nodes to form the linked list
        head.setNextNode(node2);
        node2.setNextNode(node0);
        node0.setNextNode(nodeNeg4);

        // Connect the tail to node2 to create a cycle
        nodeNeg4.setNextNode(node2);
        System.out.println(detectCycle(head));

    }

    public static SingleNode detectCycle(SingleNode head) {

        if (head==null) return null;

        SingleNode fast = head;
        SingleNode slow = head;
        boolean start = true;

        while (fast!=slow || start) {
            start = false;
            if (slow != null) slow  = slow.getNextNode();
            if (fast != null) fast = fast.getNextNode();
            if (fast != null) fast = fast.getNextNode();
        }

        fast = head;
        while (fast != slow) {
            if (slow != null) slow = slow.getNextNode();
            if (fast != null) fast = fast.getNextNode();
        }

        return fast;




    }
}
