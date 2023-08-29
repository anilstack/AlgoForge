package com.anilstack.ds.linkedlist;

import com.anilstack.ds.util.SingleNode;

public class ReverseLinkedList {

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


        System.out.println(reverseLinkedList(list1));
    }

    private static SingleNode reverseLinkedList(SingleNode head) {

        SingleNode previous = null;
        SingleNode current = head;
        SingleNode next = null;

        while (current != null) {

            next = current.getNextNode();
            current.setNextNode(previous);
            previous = current;
            current = next;

        }

        return previous;


    }



}
