package com.anilstack.ds.linkedlist;

import com.anilstack.ds.util.SingleNode;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class ReverseLinkedListII {

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

        System.out.println(reverseLinkedListNode(list1,1,6));
    }

    private static SingleNode reverseLinkedListNode(SingleNode head, int leftPosition, int rightPosition) {

        if (head==null || head.getNextNode()==null) return head;

        SingleNode dummy = new SingleNode(-1);
        dummy.setNextNode(head);

        SingleNode it = dummy;
        SingleNode previousToit = null;

        for (int i = 0; i < leftPosition; i++) {
            previousToit = it;
            it = it.getNextNode();
        }

        SingleNode currentR = it;
        SingleNode previousR = previousToit;

        for (int i=leftPosition; i <= rightPosition; i++) {
            SingleNode forward = currentR.getNextNode();
            currentR.setNextNode(previousR);
            previousR = currentR;
            currentR = forward;
        }

        //connect
        previousToit.setNextNode(previousR);
        it.setNextNode(currentR);

        return dummy.getNextNode();


    }
}
