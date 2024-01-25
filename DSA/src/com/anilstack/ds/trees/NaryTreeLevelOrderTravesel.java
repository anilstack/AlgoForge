package com.anilstack.ds.trees;

import com.anilstack.ds.util.TreeNode;
import com.anilstack.ds.util.TreeNodeV1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class NaryTreeLevelOrderTravesel {

    /**
     *     1
     *    /|\
     *   3 2 4
     *  / \
     * 5   6
     * @param args
     */
    public static void main(String[] args) {
            // Creating the binary tree
            TreeNodeV1 root = new TreeNodeV1(1);

        TreeNodeV1 child1 = new TreeNodeV1(3);
        TreeNodeV1 child2 = new TreeNodeV1(2);
        TreeNodeV1 child3 = new TreeNodeV1(4);

        TreeNodeV1 grandchild1 = new TreeNodeV1(5);
        TreeNodeV1 grandchild2 = new TreeNodeV1(6);

            // Setting the relationships
            root.getChildren().add(child1);
            root.getChildren().add(child2);
            root.getChildren().add(child3);

            child1.getChildren().add(grandchild1);
            child1.getChildren().add(grandchild2);

            // Accessing values using get methods
            int rootValue = root.getVal();
            int child1Value = root.getChildren().get(0).getVal();
            int grandchild1Value = root.getChildren().get(0).getChildren().get(0).getVal();

            // Displaying values
            System.out.println("Root Value: " + rootValue);
            System.out.println("Child 1 Value: " + child1Value);
            System.out.println("Grandchild 1 Value: " + grandchild1Value);

            System.out.println(levelOrder(root));


    }

    private static List<List<Integer>> levelOrder(TreeNodeV1 root) {

        if (root==null) return null;

        List<List<Integer>> ans = new ArrayList<>();

        Queue<TreeNodeV1> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> nodesAtOneLevel = new ArrayList<>();
            while (size-- > 0) {
              TreeNodeV1 head = queue.poll();
              nodesAtOneLevel.add(head.getVal());
              for(TreeNodeV1 child : head.getChildren()) {
                  queue.offer(child);
              }
            }
            ans.add(nodesAtOneLevel);
        }
        return ans;
    }
}
