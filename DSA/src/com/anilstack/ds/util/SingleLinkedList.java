package com.anilstack.ds.util;

public class SingleLinkedList {

    // Head ref to store first node ref of linkedlist.
    // Tail ref to store last node ref of linkelist.
    // Node will create and insert data into that and ref part is null.

    private SingleNode head;
    private SingleNode tail;
    private int size;

    public SingleNode createSingleLinkedList(int nodeValue) {
        head = new SingleNode();
        SingleNode node = new SingleNode();
        node.setValue(nodeValue);
        node.setNextNode(null);
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insertLinkedList(int nodeValue, int locationToBeInserted) {
        SingleNode node = new SingleNode();
        node.setValue(nodeValue);
        if (!existLinkedList()) { // LinkedList doesnot exist..,
            System.out.println("The linked list does not exist!!");
            return;
        } else if (locationToBeInserted == 0) {// insert value at 0 location
            node.setNextNode(head);
            head = node;
        } else {
            SingleNode tempNode = head;
            int index = 0;
            while (index < locationToBeInserted - 1) {// insert value at specified location ex : 3 i.e.., 2
                tempNode = tempNode.getNextNode();
                index++;
            }
            SingleNode nextNode = tempNode.getNextNode();
            tempNode.setNextNode(node);
            node.setNextNode(nextNode);
        }
        setSize(getSize() + 1);
    }

    public void traversalLinkedList() {
        if (existLinkedList()) {
            SingleNode tempNode = head;
            for (int i = 0; i < getSize(); i++) {
                System.out.print(tempNode.getValue());
                if (i != getSize() - 1) {
                    System.out.print("-->");
                }
                tempNode = tempNode.getNextNode();
            }
        } else {
            System.out.println("Linked list doesnot exist!");
        }
        System.out.println("\n");
    }

    public boolean searchForAValue(int value) {
        if(existLinkedList()) {
            SingleNode tempNode = head;
            for(int i=0;i<getSize();i++) {
                if(tempNode.getValue() == value) {
                    System.out.println("value found at this location in list :"+i);
                    return true;
                }
                tempNode = tempNode.getNextNode();
            }
        }
        System.out.println("value didnt found in linked list");
        return false;
    }

    public void deletionOfNode(int location) {

        if (!existLinkedList()) {
            System.out.println("The LinkedList Doest not exist..,");
        } else if (location == 0) {
            head = head.getNextNode();
            setSize(getSize() - 1);
            if (getSize() == 0) {
                tail = null;
            }
        } else if (location >= getSize()) {
            SingleNode tempNode = head;
            for (int i = 0; i < size; i++) {
                tempNode = tempNode.getNextNode();
            }
            if (tempNode == head) {
                tail = head = null;
                setSize(getSize() - 1);
            }
            tempNode.setNextNode(null);
            tail = tempNode;
            setSize(getSize() - 1);
        } else {
            SingleNode tempNode = head;
            for (int i = 0; i < location; i++) {
                tempNode = tempNode.getNextNode();
            }
            tempNode.setNextNode(tempNode.getNextNode().getNextNode());
            setSize(getSize() - 1);
        }

    }

    public void deleteSingleLinkedList() {
        head = null;
        tail = null;
        System.out.println("deleteSingleLinkedList");
    }

    public boolean existLinkedList() {
        return head != null;
    }

    public SingleNode getHead() {
        return head;
    }

    public void setHead(SingleNode head) {
        this.head = head;
    }

    public SingleNode getTail() {
        return tail;
    }

    public void setTail(SingleNode tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}

