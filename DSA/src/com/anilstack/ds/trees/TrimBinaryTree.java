package com.anilstack.ds.trees;

import com.anilstack.ds.util.TreeNode;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class TrimBinaryTree {

    /**
     *       3
     *      / \
     *     0   4
     *      \
     *       2
     *      /
     *     1
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.setLeft(new TreeNode(1));
        root.setRight(new TreeNode(6));
        root.getLeft().setLeft(new TreeNode(0));
        root.getLeft().setRight(new TreeNode(2));
        root.getRight().setLeft(new TreeNode(5));
        root.getRight().setRight(new TreeNode(7));
        root.getLeft().getRight().setRight(new TreeNode(3));
        root.getRight().getRight().setRight(new TreeNode(8));
        TreeNode trimedBST = trimBST(root,1,3);
        root.inorderTraversal(trimedBST);
    }


    private static TreeNode trimBST(TreeNode root, int low, int high) {

        if (root==null) {
            return null;
        } else {
            if (root.getVal() >= low && root.getVal() <= high) {
                root.setLeft(trimBST(root.getLeft(),low,high));
                root.setRight(trimBST(root.getRight(),low,high));
                return root;
            } else if(root.getVal() < low) {
                trimBST(root.getRight(),low,high);
            } else if (root.getVal() > high) {
                trimBST(root.getLeft(),low,high);
            }
        }
        return root;
    }

}
