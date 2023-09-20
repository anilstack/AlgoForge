package com.anilstack.ds.linkedlist;

import com.anilstack.ds.util.SingleNode;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class RemoveLinkedListElement {

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 3};
        SingleNode head = new SingleNode(values[0]);
        SingleNode current = head;

        // Create and link the remaining nodes
        for (int i = 1; i < values.length; i++) {
            current.setNextNode(new SingleNode(values[i]));
            current = current.getNextNode();
        }

        System.out.println(removeKFromLinkedList(head,3));
    }

    private static SingleNode removeKFromLinkedList(SingleNode head, int k) {

        SingleNode dummy = new SingleNode(-1);
        dummy.setNextNode(head);

        SingleNode prev = dummy;
        SingleNode curr = dummy.getNextNode();

        while (curr!=null) {

            while (curr!=null && curr.getValue() == k) {
                prev.setNextNode(curr.getNextNode());
                curr = curr.getNextNode();
            }

            prev = prev.getNextNode();
            if (curr!=null) curr = curr.getNextNode();

        }
        return dummy.getNextNode();

    }
}
