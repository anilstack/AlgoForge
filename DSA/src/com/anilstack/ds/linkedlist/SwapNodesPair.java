package com.anilstack.ds.linkedlist;

import com.anilstack.ds.util.SingleNode;

public class SwapNodesPair {

    public static void main(String[] args) {
        SingleNode list2 = new SingleNode();
        list2.setValue(1);
        list2.setNextNode(new SingleNode());
        list2.getNextNode().setValue(2);
        list2.getNextNode().setNextNode(new SingleNode());
        list2.getNextNode().getNextNode().setValue(3);
        list2.getNextNode().getNextNode().setNextNode(new SingleNode());
        list2.getNextNode().getNextNode().getNextNode().setValue(4);

        System.out.println(swapAdjacentNodes(list2));
    }

    private static SingleNode swapAdjacentNodes(SingleNode head) {


        SingleNode dummy = new SingleNode(-1);
        dummy.setNextNode(head);

        SingleNode prev = dummy;

        while (prev.getNextNode() !=null && prev.getNextNode().getNextNode() != null) {

            SingleNode current = prev.getNextNode();
            SingleNode forward = current.getNextNode();
            SingleNode temp = forward.getNextNode();

            prev.setNextNode(forward);
            forward.setNextNode(current);
            current.setNextNode(temp);

            prev = current;
        }
        return dummy.getNextNode();

    }
 }
