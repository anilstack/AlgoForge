package com.anilstack.ds.linkedlist;

import com.anilstack.ds.util.SingleNode;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class ReorderList {

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5,6};
        SingleNode head = new SingleNode(values[0]);
        SingleNode current = head;

        // Create and link the remaining nodes
        for (int i = 1; i < values.length; i++) {
            current.setNextNode(new SingleNode(values[i]));
            current = current.getNextNode();
        }

        System.out.println(reOrderList(head));
    }


    private static SingleNode reOrderList(SingleNode head) {


        SingleNode fast = head;
        SingleNode slow = head;

        SingleNode slowPrevious = null;

        while (fast != null && fast.getNextNode()!=null) {
            slowPrevious = slow;
            slow = slow.getNextNode();
            fast = fast.getNextNode();
            if (fast.getNextNode() != null) fast = fast.getNextNode();
        }

        slowPrevious.setNextNode(null);

        SingleNode reverseHead = reverse(slow);

        SingleNode dummy = new SingleNode(-1);
        SingleNode it = dummy;
        SingleNode it1 = head;
        SingleNode it2 = reverseHead;

        while (it1 != null && it2 != null) {

            SingleNode forward1 = it1.getNextNode();
            it.setNextNode(it1);
            it1 = forward1;
            it = it.getNextNode();

            SingleNode forward2 = it2.getNextNode();
            it.setNextNode(it2);
            it2 = forward2;
            it = it.getNextNode();
        }
        return dummy.getNextNode();
    }

    private static SingleNode reverse(SingleNode head) {

       SingleNode curr = head;
       SingleNode prev = null;

       while (curr != null) {
           SingleNode forward = curr.getNextNode();
           curr.setNextNode(prev);
           prev = curr;
           curr = forward;
       }
       return prev;
    }



}
