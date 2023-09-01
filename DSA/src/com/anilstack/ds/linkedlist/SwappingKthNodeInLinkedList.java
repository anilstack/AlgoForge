package com.anilstack.ds.linkedlist;

import com.anilstack.ds.util.SingleNode;

public class SwappingKthNodeInLinkedList {

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

      //  System.out.println("printing linkedlist" +list1);

        int k = 2;

        System.out.println(swapLinkedList(list1,k));

    }


//using fast and slow pointer algo.
    public static SingleNode swapLinkedList(SingleNode head, int k) {

        k = k - 1;
        SingleNode firstNode = head;

        while (k > 0) {
            firstNode = firstNode.getNextNode();
            k--;
        }

        SingleNode firstPointer = firstNode;
        SingleNode secondPointer = head;

        while (firstPointer.getNextNode()!= null) {

            firstPointer = firstPointer.getNextNode();
            secondPointer = secondPointer.getNextNode();

        }

        int temp = firstNode.getValue();
        firstNode.setValue(secondPointer.getValue());
        secondPointer.setValue(temp);

        return head;




    }



}
