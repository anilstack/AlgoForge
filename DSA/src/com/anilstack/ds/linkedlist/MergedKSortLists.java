package com.anilstack.ds.linkedlist;

import com.anilstack.ds.util.SingleNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergedKSortLists {

    public static void main(String[] args) {

        List<List<Integer>> lists = List.of(
                List.of(1, 4, 5),
                List.of(1, 3, 4),
                List.of(2, 6)
        );

        SingleNode[] heads = new SingleNode[lists.size()];

        // Populate the heads array with linked lists
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> values = lists.get(i);
            SingleNode dummy = new SingleNode(); // Dummy node to simplify insertion
            SingleNode current = dummy;

            for (int val : values) {
                current.setNextNode(new SingleNode(val));
                current = current.getNextNode();
            }

            heads[i] = dummy.getNextNode(); // Store the head of the linked list
        }

        // Print the linked lists
        for (int i = 0; i < heads.length; i++) {
            SingleNode current = heads[i];
            System.out.print("Linked List " + i + ": ");

            while (current != null) {
                System.out.print(current.getValue() + " ");
                current = current.getNextNode();
            }

            System.out.println(); // Move to the next line for the next linked list
        }
        System.out.println(mergeKLists(heads));
    }



    private static SingleNode mergeKLists(SingleNode[] lists) {

        if (lists == null || lists.length == 0) return null;

        return helper(lists,0,lists.length-1);
    }

    private static SingleNode helper(SingleNode[] lists,int start, int end) {

        if (start > end) {
            return null;
        } else if (start == end) {
            return lists[start];
        } else {
            int mid = start + (end - start) / 2;
            SingleNode left = helper(lists,start,mid);
            SingleNode right = helper(lists,mid+1, end);
            return merge(left,right);
        }
    }



    private static SingleNode merge(SingleNode head1, SingleNode head2) {

        if (head1==null) return head2;
        if (head2==null) return head1;


        SingleNode dummy = new SingleNode(-1);
        SingleNode t = dummy;
        SingleNode t1 = head1;
        SingleNode t2 = head2;

        while (t1!=null && t2!=null) {
            if (t1.getValue() < t2.getValue()) {
                t.setNextNode(t1);
                t = t.getNextNode();
                t1 = t1.getNextNode();
            } else {
                t.setNextNode(t2);
                t = t.getNextNode();
                t2 = t2.getNextNode();
            }
        }

        while (t1!=null) {
            t.setNextNode(t1);
            t=t.getNextNode();
            t1=t1.getNextNode();
        }

        while (t2!=null) {
            t.setNextNode(t2);
            t=t.getNextNode();
            t2=t2.getNextNode();
        }


        return dummy.getNextNode();
    }


    private static SingleNode mergeKListsUsingPriHeap(SingleNode[] lists) {

        if (lists == null || lists.length == 0) return null;

        Comparator<SingleNode> customComparator = new Comparator<SingleNode>() {
            @Override
            public int compare(SingleNode o1, SingleNode o2) {
                return o1.getValue() - o2.getValue();
            }
        };

        PriorityQueue<SingleNode> priorityQueue = new PriorityQueue<>(customComparator);

        for (SingleNode list : lists) {
            if (list != null) priorityQueue.offer(list);
        }

        SingleNode dummy = new SingleNode(-1);
        SingleNode t = dummy;

        while (!priorityQueue.isEmpty()) {
            SingleNode lowestValueNode = priorityQueue.poll();
            t.setNextNode(lowestValueNode);
            t = t.getNextNode();
            if (lowestValueNode.getNextNode() != null) {
                priorityQueue.offer(lowestValueNode.getNextNode());
            }
        }


    return dummy.getNextNode();

    }

}
