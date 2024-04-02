package com.anilstack.ds.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class GraphNode {


    public int val;
    public List<GraphNode> neighbors;


    public GraphNode(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }
    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public List<GraphNode> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<GraphNode> neighbors) {
        this.neighbors = neighbors;
    }

    public static void printAllLinks(GraphNode node) {
        System.out.print("Node " + node.val + " is connected to: ");
        for (GraphNode neighbor : node.neighbors) {
            System.out.print(neighbor.val + " ");
        }
        System.out.println();
    }

}
