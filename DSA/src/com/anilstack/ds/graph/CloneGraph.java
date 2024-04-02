package com.anilstack.ds.graph;

import com.anilstack.ds.util.GraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class CloneGraph {

    public static void main(String[] args) {
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);

        // Connect nodes to form an undirected graph
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        GraphNode result = cloneGraph(node1);
        GraphNode.printAllLinks(result);
    }

    public static GraphNode cloneGraph(GraphNode node) {

        if (node==null) return node;

        Map<GraphNode,GraphNode> newNodesMap = new HashMap<>();

        Queue<GraphNode> queue = new LinkedList<>();
        GraphNode newNode = new GraphNode(node.getVal());
        newNodesMap.put(node,newNode);
        queue.offer(node);

        while (!queue.isEmpty()) {

            int size = queue.size();
            while (size-- > 0) {
                GraphNode orignalNode = queue.poll();
                for (GraphNode child:orignalNode.getNeighbors()) {
                    if (!newNodesMap.containsKey(child)) {
                        GraphNode newChild = new GraphNode(child.getVal());
                        queue.offer(child);
                        newNodesMap.put(child,newChild);
                    }
                    GraphNode newListNode = newNodesMap.get(orignalNode);
                    newListNode.getNeighbors().add(newNodesMap.get(child));
                }
            }


        }

        return newNodesMap.get(node);

    }
}
