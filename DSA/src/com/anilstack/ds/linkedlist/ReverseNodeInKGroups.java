package com.anilstack.ds.linkedlist;

import com.anilstack.ds.util.SingleNode;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class ReverseNodeInKGroups {

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

        System.out.println(reverseKGroup(list1,2));
    }

    public static SingleNode reverseKGroup(SingleNode head, int k) {
        if(head == null || k ==1) {
            return head;
        }

        SingleNode dummy = new SingleNode(-1);
        dummy.setNextNode(head);


        int totalNodes = 0;

        SingleNode curr = head;

        // counts the total no of nodes
        while(curr!= null){
            totalNodes++;
            curr = curr.getNextNode();
        }

        curr = head;
        SingleNode next = null;
        SingleNode prev = dummy;

        while(totalNodes>=k){
            curr = prev.getNextNode();
            next = curr.getNextNode();

            for(int i=1;i<k;i++) {// k-1 times
                curr.setNextNode( next.getNextNode());;
                next.setNextNode(prev.getNextNode());
                prev.setNextNode(next);
                next = curr.getNextNode();

            }

            prev = curr;
            totalNodes = totalNodes - k;

        }
        return dummy.getNextNode();


    }

}
