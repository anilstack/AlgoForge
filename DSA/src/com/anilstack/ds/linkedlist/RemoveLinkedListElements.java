package com.anilstack.ds.linkedlist;

import com.anilstack.ds.util.SingleNode;

public class RemoveLinkedListElements {

    public static void main(String[] args) {
        SingleNode list1 = new SingleNode();
        list1.setValue(1);
        list1.setNextNode(new SingleNode());
        list1.getNextNode().setValue(2);
        list1.getNextNode().setNextNode(new SingleNode());
        list1.getNextNode().getNextNode().setValue(3);
        list1.getNextNode().getNextNode().setNextNode(new SingleNode());
        list1.getNextNode().getNextNode().getNextNode().setValue(4);
        list1.getNextNode().getNextNode().getNextNode().setNextNode(new SingleNode());
        list1.getNextNode().getNextNode().getNextNode().getNextNode().setValue(5);

        System.out.println(removeKthInstanceInLinkedList(list1,5));
    }

    private static SingleNode removeKthInstanceInLinkedList(SingleNode head, int target) {

        SingleNode dummy = new SingleNode();
        dummy.setNextNode(head);

        SingleNode prev = dummy;
        SingleNode curr = dummy.getNextNode();

        while (curr!=null) {
            while (curr!=null && curr.getValue() == target) {
                prev.setNextNode(curr.getNextNode());
                curr = curr.getNextNode();
            }

            prev = prev.getNextNode();
            if (curr !=null) {
                curr = curr.getNextNode();
            }

        }
        return dummy.getNextNode();











    }
}
