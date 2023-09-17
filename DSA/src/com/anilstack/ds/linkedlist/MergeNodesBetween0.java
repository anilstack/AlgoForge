package com.anilstack.ds.linkedlist;

import com.anilstack.ds.util.SingleNode;

public class MergeNodesBetween0 {

    public static void main(String[] args) {
        SingleNode list2 = new SingleNode();
        list2.setValue(0);
        list2.setNextNode(new SingleNode());
        list2.getNextNode().setValue(3);
        list2.getNextNode().setNextNode(new SingleNode());
        list2.getNextNode().getNextNode().setValue(1);
        list2.getNextNode().getNextNode().setNextNode(new SingleNode());
        list2.getNextNode().getNextNode().getNextNode().setValue(0);
        list2.getNextNode().getNextNode().getNextNode().setNextNode(new SingleNode());
        list2.getNextNode().getNextNode().getNextNode().getNextNode().setValue(4);

// Continue adding nodes for the remaining values
        list2.getNextNode().getNextNode().getNextNode().getNextNode().setNextNode(new SingleNode());
        list2.getNextNode().getNextNode().getNextNode().getNextNode().getNextNode().setValue(5);
        list2.getNextNode().getNextNode().getNextNode().getNextNode().getNextNode().setNextNode(new SingleNode());
        list2.getNextNode().getNextNode().getNextNode().getNextNode().getNextNode().getNextNode().setValue(2);
        list2.getNextNode().getNextNode().getNextNode().getNextNode().getNextNode().getNextNode().setNextNode(new SingleNode());
        list2.getNextNode().getNextNode().getNextNode().getNextNode().getNextNode().getNextNode().getNextNode().setValue(0);

        System.out.println(mergeNodes(list2));
    }


    private static SingleNode mergeNodes(SingleNode head) {

//        SingleNode dummyHead = new SingleNode(-1);
//        SingleNode newIt = dummyHead;
//        SingleNode it = head;
//        while(it!=null){
//            it = it.getNextNode();
//            int sumNodes = 0;
//            while(it!=null && it.getValue()!=0){
//                sumNodes +=  it.getValue();
//                it = it.getNextNode();
//            }
//
//            if(sumNodes!=0) {
//                newIt.setNextNode( new SingleNode(sumNodes));
//                newIt = newIt.getNextNode();
//            }
//        }
//        return dummyHead.getNextNode();

        SingleNode dummyNode = new SingleNode(-1);
        SingleNode newIter = dummyNode;
        SingleNode iter = head;

        while (iter != null) {

            iter = iter.getNextNode();
            int sumOfNodes = 0;
            while (iter != null && iter.getValue() != 0){

                sumOfNodes += iter.getValue();
                iter = iter.getNextNode();

            }

            if (sumOfNodes != 0) {
                newIter.setNextNode(new SingleNode(sumOfNodes));
                newIter = newIter.getNextNode();
            }


        }

        return dummyNode.getNextNode();



    }
}
