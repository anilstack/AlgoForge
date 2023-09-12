package com.anilstack.ds.linkedlist;

import com.anilstack.ds.util.SingleNode;

public class AddTwoNumbers {
//given two linked lists which stores linked lists in reverse order. each node stores one digit.
//return the sum of two numbers as third list.
    public static void main(String[] args) {

        SingleNode list1 = new SingleNode();
        SingleNode currentNode1 = list1;

        int[] values1 = {9, 9, 9, 9, 9};

        for (int value : values1) {
            currentNode1.setValue(value);

            if (value != values1[values1.length - 1]) {
                currentNode1.setNextNode(new SingleNode());
                currentNode1 = currentNode1.getNextNode();
            }
        }

        // Create the second linked list with values 9, 9, 9
        SingleNode list2 = new SingleNode();
        SingleNode currentNode2 = list2;

        int[] values2 = {9, 9, 9};

        for (int value : values2) {
            currentNode2.setValue(value);

            if (value != values2[values2.length - 1]) {
                currentNode2.setNextNode(new SingleNode());
                currentNode2 = currentNode2.getNextNode();
            }
        }

        System.out.println(addTwoLinkedLists(list1, list2));
    }

    private static SingleNode addTwoLinkedLists(SingleNode list1, SingleNode list2) {

        SingleNode result = new SingleNode(0);
        SingleNode iterator = result;

        int carry = 0;

        while (list1 != null || list2 != null) {

            int sum = 0 + carry;

            if (list1 != null) {
                sum += list1.getValue();
                list1 = list1.getNextNode();
            }

            if (list2 != null) {
                sum += list2.getValue();
                list2 = list2.getNextNode();
            }

            carry = sum / 10;
            sum = sum % 10; // will return last digit in number.
            iterator.setNextNode(new SingleNode(sum));
            iterator = iterator.getNextNode();

        }
            if (carry == 1) {
                iterator.setNextNode(new SingleNode(carry));
            }

        return result.getNextNode();
    }
}
