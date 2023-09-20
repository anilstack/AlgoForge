package com.anilstack.ds.linkedlist;

import com.anilstack.ds.util.SingleNode;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class InsertionSortList {

    public static void main(String[] args) {

        int[] values = {1, 6, 4, 5, 3,2};
        SingleNode head = new SingleNode(values[0]);
        SingleNode current = head;

        // Create and link the remaining nodes
        for (int i = 1; i < values.length; i++) {
            current.setNextNode(new SingleNode(values[i]));
            current = current.getNextNode();
        }

        System.out.println(insertionSort(head));

    }

        private static SingleNode insertionSort(SingleNode head) {

            SingleNode dummy = new SingleNode(-1);
            dummy.setNextNode(head);
            SingleNode nodeToBeInserted;
            SingleNode preInsertionNode;

            SingleNode currItr = head;

            while (currItr != null && currItr.getNextNode() != null) {

                if (currItr.getValue() < currItr.getNextNode().getValue()) {
                    currItr = currItr.getNextNode();
                } else {

                    nodeToBeInserted = currItr.getNextNode();
                    preInsertionNode = dummy;

//                    while (preInsertionNode.getNextNode() != null && preInsertionNode.getNextNode().getValue() < preInsertionNode.getValue()) {
//                        preInsertionNode = preInsertionNode.getNextNode();
//                    }
                    while (preInsertionNode.getNextNode() != null &&
                            preInsertionNode.getNextNode().getValue() < nodeToBeInserted.getValue()) {
                        preInsertionNode = preInsertionNode.getNextNode();
                    }

                    currItr = nodeToBeInserted.getNextNode();
                    nodeToBeInserted.setNextNode(preInsertionNode.getNextNode());
                    preInsertionNode.setNextNode(nodeToBeInserted);



                }


            }



        return dummy.getNextNode();
        }

}
