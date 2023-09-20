package com.anilstack.ds.linkedlist;

import com.anilstack.ds.util.SingleNode;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class OddEvenLinkedList {

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, };
        SingleNode head = new SingleNode(values[0]);
        SingleNode current = head;

        // Create and link the remaining nodes
        for (int i = 1; i < values.length; i++) {
            current.setNextNode(new SingleNode(values[i]));
            current = current.getNextNode();
        }

        System.out.println(rearrangeList(head));
    }

    private static SingleNode rearrangeList(SingleNode head) {

        if (head == null || head.getNextNode() == null || head.getNextNode().getNextNode() == null) return head;

        SingleNode oddItr = head;
        SingleNode evenItr = head.getNextNode();

        SingleNode evenHead = evenItr;

        while (oddItr.getNextNode() != null && evenItr.getNextNode() != null) {
            oddItr.setNextNode(evenItr.getNextNode());
            oddItr = oddItr.getNextNode();

            if (oddItr != null) {
                evenItr.setNextNode(oddItr.getNextNode());
                evenItr = evenItr.getNextNode();
            }

        }

        oddItr.setNextNode(evenHead);
        return head;
    }
}
