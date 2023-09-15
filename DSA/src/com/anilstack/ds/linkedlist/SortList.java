package com.anilstack.ds.linkedlist;

import com.anilstack.ds.util.SingleNode;

public class SortList {

    public static void main(String[] args) {
        SingleNode list1 = new SingleNode();
        list1.setValue(1);
        list1.setNextNode(new SingleNode());
        list1.getNextNode().setValue(3);
        list1.getNextNode().setNextNode(new SingleNode());
        list1.getNextNode().getNextNode().setValue(4);
        list1.getNextNode().getNextNode().setNextNode(new SingleNode());
        list1.getNextNode().getNextNode().getNextNode().setValue(6);
        list1.getNextNode().getNextNode().getNextNode().setNextNode(new SingleNode());
        list1.getNextNode().getNextNode().getNextNode().getNextNode().setValue(5);

        SingleNode list2 = new SingleNode();
        list2.setValue(2);
        list2.setNextNode(new SingleNode());
        list2.getNextNode().setValue(5);
        list2.getNextNode().setNextNode(new SingleNode());
        list2.getNextNode().getNextNode().setValue(10);
        list2.getNextNode().getNextNode().setNextNode(new SingleNode());
        list2.getNextNode().getNextNode().getNextNode().setValue(16);
        list2.getNextNode().getNextNode().getNextNode().setNextNode(new SingleNode());
        list2.getNextNode().getNextNode().getNextNode().getNextNode().setValue(15);

        System.out.println(sortList(list1));
    }


    private static SingleNode sortList(SingleNode head) {

        if (head == null || head.getNextNode() == null) return head;

        SingleNode fast = head;
        SingleNode slow = head;
        SingleNode prev = null;

        while (fast != null && fast.getNextNode() != null) {

            prev = slow;
            slow = slow.getNextNode();
            fast = fast.getNextNode();

            if (fast != null) fast = fast.getNextNode();
        }
            prev.setNextNode(null);

            SingleNode firstNode = sortList(head);
            SingleNode secondNode = sortList(slow);

            return merge(firstNode,secondNode);

    }




    private static SingleNode merge(SingleNode head1, SingleNode head2 ) {

        if (head1 == null) return head2;
        if (head2 == null) return head1;

        SingleNode result = new SingleNode();
        SingleNode iter = result;

        while (head1 !=null && head2 != null) {

            if (head1.getValue() < head2.getValue()) {
                result.setNextNode(head1);
                result = result.getNextNode();
                iter = iter.getNextNode();
            } else {
                result.setNextNode(head2);
                result = result.getNextNode();
                iter = iter.getNextNode();
            }
        }

        while (head1 != null) {
            result.setNextNode(head1);
            result = result.getNextNode();
            iter = iter.getNextNode();
        }

        while (head2 != null) {
            result.setNextNode(head2);
            result = result.getNextNode();
            iter = iter.getNextNode();
        }

        return result.getNextNode();

    }
}
