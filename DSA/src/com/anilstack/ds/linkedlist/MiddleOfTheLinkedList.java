package com.anilstack.ds.linkedlist;

import com.anilstack.ds.util.SingleNode;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class MiddleOfTheLinkedList {

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5,6};
        SingleNode head = new SingleNode(values[0]);
        SingleNode current = head;

        // Create and link the remaining nodes
        for (int i = 1; i < values.length; i++) {
            current.setNextNode(new SingleNode(values[i]));
            current = current.getNextNode();
        }

        System.out.println(middleOfTheLinkedList(head));
    }

    private static SingleNode middleOfTheLinkedList(SingleNode head) {

        SingleNode fast = head, slow = head;

        while (fast != null && fast.getNextNode() != null) {

            fast = fast.getNextNode();
            if (fast.getNextNode() != null) fast = fast.getNextNode();
            slow = slow.getNextNode();
        }

        return slow;

    }

}
