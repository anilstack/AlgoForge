package com.anilstack.ds.trees;

import com.anilstack.ds.util.TreeNode;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class RangeSumInBST {

    private static int ans = 0;

    /**
     *      10
     *     /  \
     *    5    15
     *   / \     \
     *  3   7    18
     * @param args
     */
    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.setLeft(new TreeNode(5));
        root.setRight(new TreeNode(15));
        root.getLeft().setLeft(new TreeNode(3));
        root.getLeft().setRight(new TreeNode(7));
        root.getRight().setRight(new TreeNode(18));

        int low = 7, high = 15;

        System.out.println(rangeSumBST(root,low,high));
    }

    private static int rangeSumBST(TreeNode root, int low, int high) {
        rangeSumHelper(root,low,high);
        return ans;
    }

    private static void rangeSumHelper(TreeNode root, int low, int high) {

        if (root == null) return;

        if (root.getVal() >= low&& root.getVal() <= high) {
            ans += root.getVal();
            rangeSumHelper(root.getLeft(),low, root.getVal());
            rangeSumHelper(root.getRight(),root.getVal(), high);
        } else if (root.getVal() < low) {
            rangeSumHelper(root.getRight(),low,high);
        } else if (root.getVal() > high) {
            rangeSumHelper(root.getLeft(),low,high);
        }


    }


}
