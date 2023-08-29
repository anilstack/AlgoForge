package com.anilstack.ds.linkedlist;

import com.anilstack.ds.util.SingleLinkedList;
import com.anilstack.ds.util.SingleNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {


    //using fast pointer and slow pointer approach we are using.
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.createSingleLinkedList(1);

        singleLinkedList.insertLinkedList(2,1);
        singleLinkedList.insertLinkedList(3,2);
        singleLinkedList.insertLinkedList(4,3);
        singleLinkedList.insertLinkedList(5,4);

        System.out.println(hasCycle(singleLinkedList));

    }

    private static boolean hasCycle(SingleLinkedList singleLinkedList) {

//        Set<SingleNode> set = new HashSet<>();
//        SingleNode head = singleLinkedList.getHead();
//
//        while (head!=null) {
//            if (set.contains(head)) {
//                return true;
//            }
//            set.add(head);
//            head = head.getNextNode();
//        }

        if (singleLinkedList == null || singleLinkedList.getSize() == 0) {
            return false;
        }

        SingleNode fastPointer = singleLinkedList.getHead();
        SingleNode slowPointer = singleLinkedList.getHead();

        while (fastPointer != null && fastPointer.getNextNode() != null) {

            slowPointer = slowPointer.getNextNode();
            fastPointer = fastPointer.getNextNode();

            if (fastPointer != null) {
                fastPointer = fastPointer.getNextNode();
            }

            if (slowPointer == fastPointer) {
                return true;
            }

        }

        return false;
    }

}
