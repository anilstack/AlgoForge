package com.anilstack.ds.linkedlist;

import com.anilstack.ds.util.DoubleNode;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class FlatternMultiLevelDoublyLinkedList {

    public static void main(String[] args) {
        // Creating the nodes with the specified values
        DoubleNode head = new DoubleNode(1);
        DoubleNode node2 = new DoubleNode(2);
        DoubleNode node3 = new DoubleNode(3);
        DoubleNode node4 = new DoubleNode(4);
        DoubleNode node5 = new DoubleNode(5);
        DoubleNode node6 = new DoubleNode(6);
        DoubleNode node7 = new DoubleNode(7);
        DoubleNode node8 = new DoubleNode(8);
        DoubleNode node9 = new DoubleNode(9);
        DoubleNode node10 = new DoubleNode(10);
        DoubleNode node11 = new DoubleNode(11);
        DoubleNode node12 = new DoubleNode(12);

// Building the linked list with children
        head.next = node2;
        node2.prev = head;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;
        node5.next = node6;
        node6.prev = node5;
        node3.child = node7;
        node7.next = node8;
        node8.prev = node7;
        node8.next = node9;
        node9.prev = node8;
        node9.next = node10;
        node10.prev = node9;
        node8.child = node11;
        node11.next = node12;
        node12.prev = node11;

//        System.out.println("Printing the double linked list:");
//        printDoubleLinkedList(head);
//
//        System.out.println("\nPrinting the multi-level linked list:");
//        printMultiLevelLinkedList(head);
        head = flatten(head);

        // Print the flattened linked list
        System.out.println("Printing the flattened double linked list:");
        printDoubleLinkedList(head);

    }
    public static void printDoubleLinkedList(DoubleNode head) {
        DoubleNode current = head;

        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void printMultiLevelLinkedList(DoubleNode head) {
        DoubleNode current = head;

        while (current != null) {
            System.out.print(current.val + " ");
            if (current.child != null) {
                printMultiLevelLinkedList(current.child);
            }
            current = current.next;
        }
    }

    public static DoubleNode flatten(DoubleNode head) {

        if (head == null) return head;

        DoubleNode it = head;
        while (it!=null) {
            if (it.child != null) {
                DoubleNode next = it.next;
                // whatever it returns
                it.next = flatten(it.child);
                it.next.prev = it;
                it.child = null;
                // move to the last node
                while (it.next!=null) {
                    it = it.next;
                }
                // stich
                if(next!=null){
                    it.next = next;
                    it.next.prev = it;

                }
            }
            it = it.next;
        }
        return head;
    }


}
