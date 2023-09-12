package com.anilstack.ds.linkedlist;

import com.anilstack.ds.util.SingleNode;

public class RotateList {

    public static void main(String[] args) {

        SingleNode list1 = new SingleNode();
        SingleNode currentNode = list1;

        int[] values = {1, 2, 3, 4, 5};

        for (int value : values) {
            currentNode.setValue(value);

            if (value != values[values.length - 1]) {
                currentNode.setNextNode(new SingleNode());
                currentNode = currentNode.getNextNode();
            }
        }

        int k = 2;
        System.out.println(rotateListFirst(list1,k));
    }

    private static SingleNode rotateListFirst(SingleNode head, int k) {

        int listLength = getListLengthTest(head);

        SingleNode temp = head;
        SingleNode prev = null;
        int breakagePoint = listLength - k;

        while (temp != null && breakagePoint > 0) {

            prev = temp;
            temp = temp.getNextNode();
            breakagePoint--;

        }

        prev.setNextNode(null);

        SingleNode iterator = temp;
        if (iterator!=null) {
            while (iterator.getNextNode()!=null) {
                iterator=iterator.getNextNode();
            }
            iterator.setNextNode(head);
        }
        return temp;
    }

    private static int getListLengthTest(SingleNode head) {
        int count=0;

        SingleNode temp = head;
        while(temp!=null) {
            temp=temp.getNextNode();
            count++;
        }
        return count;
    }
    private static SingleNode rotateList(SingleNode head,int k) {

            int length = getListLength(head);

            int breakagePoint = length - k;
            SingleNode temp = head; //it2
            SingleNode prev = null; //it

            while (breakagePoint > 0 && temp != null) {
                    prev = temp;
                    temp = temp.getNextNode();
                    breakagePoint--;
            }

            prev.setNextNode(null);
            SingleNode iterator = temp;
            if (iterator!=null) {
                while (iterator.getNextNode()!=null) {
                    iterator=iterator.getNextNode();
                }
                iterator.setNextNode(head);
            }
        return temp;
    }

    private static int getListLength(SingleNode head) {

        int count = 0;
        SingleNode temp = head;

        while (temp != null) {
            temp = temp.getNextNode();
            count++;
        }
        return count;
    }
}
