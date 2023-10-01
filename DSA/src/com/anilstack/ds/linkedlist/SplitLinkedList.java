package com.anilstack.ds.linkedlist;

import com.anilstack.ds.util.SingleNode;

import java.util.Arrays;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class SplitLinkedList {

    public static void main(String[] args) {
        SingleNode list1 = new SingleNode();
        SingleNode currentNode = list1;

        int[] values = {1, 2, 3, 4, 5,6,7,8,9,10};

        for (int value : values) {
            currentNode.setValue(value);

            if (value != values[values.length - 1]) {
                currentNode.setNextNode(new SingleNode());
                currentNode = currentNode.getNextNode();
            }
        }

        int divideListInTo = 3;
        SingleNode[] result = splitLinkedListInToParts(list1,divideListInTo);
        for (SingleNode node : result) {
            System.out.println(node);
        }
    }

    private static SingleNode[] splitLinkedListInToParts(SingleNode head, int dividedListInto) {

        SingleNode[] ans = new SingleNode[dividedListInto];

        int length = 0;

        SingleNode it = head;

        while (it!=null) {
            length++;
            it = it.getNextNode();
        }


        int minNodesInEachList = length/dividedListInto;
        int distribute = length%dividedListInto;


        SingleNode node = head;
        SingleNode prev = null;

        int newHeadsCount = 0;

        while (node!=null && newHeadsCount<dividedListInto) {

            ans[newHeadsCount] = node;

            for (int j = 0; j < minNodesInEachList+(distribute>0?1:0); j++) {
                prev = node;
                node = node.getNextNode();
            }

            prev.setNextNode(null);
            distribute--;
            newHeadsCount++;
        }
        return ans;
    }
}
