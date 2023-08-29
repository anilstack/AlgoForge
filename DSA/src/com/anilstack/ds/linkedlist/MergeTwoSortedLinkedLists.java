package com.anilstack.ds.linkedlist;

import com.anilstack.ds.util.SingleNode;

public class MergeTwoSortedLinkedLists {

    public static void main(String[] args) {

        SingleNode list1 = new SingleNode();
        list1.setValue(1);
        list1.setNextNode(new SingleNode());
        list1.getNextNode().setValue(3);
        list1.getNextNode().setNextNode(new SingleNode());
        list1.getNextNode().getNextNode().setValue(6);
        list1.getNextNode().getNextNode().setNextNode(new SingleNode());
        list1.getNextNode().getNextNode().getNextNode().setValue(10);

        // Creating the second linked list with size 3 and elements 4, 7, 9
        SingleNode list2 = new SingleNode();
        list2.setValue(4);
        list2.setNextNode(new SingleNode());
        list2.getNextNode().setValue(7);
        list2.getNextNode().setNextNode(new SingleNode());
        list2.getNextNode().getNextNode().setValue(9);

        // Printing the linked lists
//        System.out.println("List 1: " + list1);
//        System.out.println("List 2: " + list2);
        SingleNode result = mergeLinkedLists(list1,list2);
        System.out.println(result.toString());
    }

        public static SingleNode mergeLinkedLists(SingleNode list1, SingleNode list2) {

            SingleNode returnNode = new SingleNode();

            SingleNode headNode = returnNode;

            while (list1 != null && list2 != null) {

                if (list1.getValue() <= list2.getValue()) {
                    returnNode.setNextNode(list1);
                    list1 = list1.getNextNode();
                } else {
                    returnNode.setNextNode(list2);
                    list2 = list2.getNextNode();
                }

                returnNode = returnNode.getNextNode();
            }

            if (list1 == null) {
                returnNode.setNextNode(list2);
            } else if (list2 == null) {
                returnNode.setNextNode(list1);
            }

            return headNode.getNextNode();
        }


}












