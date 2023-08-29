package com.anilstack.ds.linkedlist;

import com.anilstack.ds.util.SingleNode;

public class ConvertBinaryNumberToLinkedListInteger {

    public static void main(String[] args) {

        SingleNode list = new SingleNode();
        list.setValue(1);
        list.setNextNode(new SingleNode());
        list.getNextNode().setValue(1);
        list.getNextNode().setNextNode(new SingleNode());
        list.getNextNode().getNextNode().setValue(0);

        System.out.println(ConvertBinaryNumberToLinkedListInteger.convertBinaryToInteger(list));


    }

    public static int convertBinaryToInteger(SingleNode head) {

        int num = 0;
        SingleNode list = head;

        while (list != null) {
            num = 2 * num + list.getValue();
            list = list.getNextNode();
        }



        return num;

    }

}
