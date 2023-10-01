package com.anilstack.ds.trees;

import com.anilstack.ds.util.TreeNode;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class DiameterOfBinaryTree {
    /**
     *  the "diameter" refers to the length of the longest path between any two nodes in a tree.
     *  This path does not necessarily need to pass through the root node.
     *  In simpler terms, it is the number of edges on the longest route between two nodes in the tree.
     * @param args
     *     1
     *    / \
     *   2   3
     *  / \
     * 4   5
     */
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        // Creates the root node with value 1
        root.setLeft(new TreeNode(2));     // Creates left child with value 2
        root.setRight(new TreeNode(3));    // Creates right child with value 3
        // Creates left child of 2 with value 4
        root.getLeft().setLeft(new TreeNode(4));

        // Creates right child of 2 with value 5
        root.getLeft().setRight(new TreeNode(5));

        System.out.println(diameterOfBinaryTree(root));
    }

    public static int diameterOfBinaryTree(TreeNode root) {

        if (root == null) return 0;

        int currentDiameter =  Math.max(maxDepthOfTree(root.getLeft()),maxDepthOfTree(root.getRight()));

        int leftDiameter = maxDepthOfTree(root.getLeft());
        int rightDiameter = maxDepthOfTree(root.getRight());

        return Math.max(currentDiameter,Math.max(leftDiameter,rightDiameter));

    }

    private static int maxDepthOfTree(TreeNode node) {

        if (node == null) return 0;

        return 1 + Math.max(maxDepthOfTree(node.getLeft()),maxDepthOfTree(node.getRight()));


    }
}
