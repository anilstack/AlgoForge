package com.anilstack.ds.util;

public class SingleNode {

    private int value;
    private SingleNode nextNode;

    public SingleNode() {
        this.value = 0;
        //this.nextNode = null;
    }

    public SingleNode(int value) {
        this.value = value;
        //this.nextNode = null;
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public SingleNode getNextNode() {
        return nextNode;
    }
    public void setNextNode(SingleNode nextNode) {
        this.nextNode = nextNode;
    }
    @Override
    public String toString() {
        return "SingleNode [value=" + value + ", nextNode=" + nextNode + "]";
    }



}

