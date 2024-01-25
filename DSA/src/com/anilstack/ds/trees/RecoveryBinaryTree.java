package com.anilstack.ds.trees;

import com.anilstack.ds.util.TreeNode;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class RecoveryBinaryTree {
    private static TreeNode prev = null;
    private static TreeNode one = null;
    private static TreeNode two = null;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setRight(new TreeNode(3));
        root.getRight().setLeft(new TreeNode(2));
        recoverTree(root);

    }


    public static void recoverTree(TreeNode root) {
        inOrder(root);
        //swapping correct the binary tree.
        int temp = one.getVal();
        one.setVal(two.getVal());
        two.setVal(temp);
    }

    private static void inOrder(TreeNode curr) {
        // Left,Root,Right inorder will work.
        if (curr==null) return;
        //left
        inOrder(curr.getLeft());

        //Root
        //This is a dip condition.
        if (prev!=null && prev.getVal() > curr.getVal()) {
            if (one==null) {
                one = prev;
            }
            two = curr;
        }
        prev = curr;

        //Right
        inOrder(curr.getRight());


    }



}
