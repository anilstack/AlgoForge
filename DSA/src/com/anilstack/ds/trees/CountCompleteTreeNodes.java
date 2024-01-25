package com.anilstack.ds.trees;

import com.anilstack.ds.util.TreeNode;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class CountCompleteTreeNodes {


    /**
     *       1
     *      / \
     *     2   3
     *    / \   \
     *   4   5   6
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));
        root.getRight().setRight(new TreeNode(6));

        System.out.println("count of the tree is "+countOfNodes(root));
    }

    private static int countOfNodes(TreeNode root) {

        if (root == null) return 0;

        int height = 1;
        TreeNode left = root.getLeft();
        TreeNode right = root.getRight();

        while (left != null && right != null) {

            height++;
            left = left.getLeft();
            right = right.getRight();

        }

        return left == null && right == null ? (int) Math.pow(2,height) - 1
                                             : 1 + countOfNodes(root.getLeft())
                                                 + countOfNodes(root.getRight());

    }
}
