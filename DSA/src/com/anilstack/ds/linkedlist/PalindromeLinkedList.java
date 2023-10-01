package com.anilstack.ds.linkedlist;

import com.anilstack.ds.util.SingleNode;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        SingleNode list1 = new SingleNode();
        SingleNode currentNode = list1;

        int[] values = {1,2,2,1};

        for (int value : values) {
            currentNode.setValue(value);

            if (value != values[values.length - 1]) {
                currentNode.setNextNode(new SingleNode());
                currentNode = currentNode.getNextNode();
            }
        }

        System.out.println(isPalindrome(list1));

    }

//    private static boolean isLinkedListPanlindrome(SingleNode head) {
//
//        if (head == null || head.getNextNode() == null) return true;
//
//        SingleNode fast = head;
//        SingleNode slow = head;
//
//        while (fast!=null && fast.getNextNode() != null) {
//            fast = fast.getNextNode();
//            if (fast.getNextNode()!=null) fast = fast.getNextNode();
//
//            slow = slow.getNextNode();
//        }
//        //if it is odd in nature.
//        if (fast.getNextNode()!=null) {
//            slow = slow.getNextNode();
//        }
//
//        SingleNode reverseListHead = reverse(slow);
//        SingleNode originalHead = head;
//
//        while (reverseListHead != null && originalHead != null) {
//
//            if (reverseListHead.getValue() != originalHead.getValue()) { return false;}
//
//            reverseListHead = reverseListHead.getNextNode();
//            originalHead = originalHead.getNextNode();
//
//        }
//        return true;
//
//    }
//
////    private static SingleNode reverse(SingleNode head) {
////
////        if (head==null || head.getNextNode() == null) return head;
////
////        SingleNode curr = head;
////        SingleNode prev = null;
////
////        while (curr!=null) {
////            SingleNode nextNode = curr.getNextNode();
////            curr.setNextNode(prev);
////            prev = curr;
////            curr = nextNode;
////        }
////        return prev;
////    }
//
//    public static SingleNode reverse(SingleNode head) {
//
//        if (head == null || head.getNextNode() == null) return head;
//
//        SingleNode curr = head;
//        SingleNode prev = null;
//
//        while (curr!=null) {
//            SingleNode nextNode = curr.getNextNode();
//            curr.setNextNode( prev);
//            prev = curr;
//            curr = nextNode;
//        }
//        return prev;
//
//
//    }

    public static boolean isPalindrome(SingleNode head) {

        if(head==null || head.getNextNode()==null){
            return true;
        }

        SingleNode slow =head;
        SingleNode fast = head;
        while(fast!=null && fast.getNextNode()!=null){
            fast=fast.getNextNode();
            if(fast!=null){
                fast = fast.getNextNode();
            }

            slow = slow.getNextNode();
        }

        //                  F
        // 1    2   3   2   1
        //              S
        //                  F
        // 1    2   2   1
        //      S   S

        if(fast!=null){
            slow = slow.getNextNode();
        }


        SingleNode head2 = reverse(slow);
        SingleNode head1 = head;

        while(head1!=null && head2!=null){
            if(head1.getValue() !=head2.getValue()){
                return false;
            }

            head1 = head1.getNextNode();
            head2 = head2.getNextNode();
        }


        return true;

    }

    private static  SingleNode reverse(SingleNode head){
        if(head == null || head.getNextNode() == null){
            return head;
        }
        SingleNode curr = head;
        SingleNode prev = null;

        while(curr!=null){
            SingleNode next = curr.getNextNode();
            curr.setNextNode(prev);
            prev = curr;
            curr = next;
        }
        return prev;

    }
}
