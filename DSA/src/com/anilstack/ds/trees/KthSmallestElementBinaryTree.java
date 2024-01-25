package com.anilstack.ds.trees;

import com.anilstack.ds.util.TreeNode;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class KthSmallestElementBinaryTree {

    private static int count;
    private static int res;

    /**
     *     5
     *    / \
     *   3   6
     *  / \
     * 2   4
     *  \
     *   1
     * @param args
     */
    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.setLeft(new TreeNode(3));
        root.setRight(new TreeNode(6));
        root.getLeft().setLeft(new TreeNode(2));
        root.getLeft().setRight(new TreeNode(4));
        root.getLeft().getLeft().setRight(new TreeNode(1));


    //    printTree(root,0);

        int result = kthSmallestElement(root,3);
        System.out.println("printing result "+result);
    }



    public static int kthSmallestElement(TreeNode root, int k) {
        count = k;
        kthSmallestUtil(root);
        return res;

    }

    public static void kthSmallestUtil(TreeNode root) {

        if (root == null) return;

        //InOrder trasevel Left,Root,Right.

        kthSmallestUtil(root.getLeft());

        count -=1;

        if (count==0) {
            res = root.getVal();
            return;
        }

        kthSmallestUtil(root.getRight());

    }







    private static void printTree(TreeNode root, int level) {
        if (root != null) {
            printTree(root.getRight(), level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.getVal());
            printTree(root.getLeft(), level + 1);
        }
    }




}
