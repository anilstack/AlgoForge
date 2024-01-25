package com.anilstack.ds.trees;

import com.anilstack.ds.util.TreeNode;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class MaxDifferenceBetweenNodeAndAncestor {


    private static int maxDiff = 0;

    /**
     *       8
     *      / \
     *     3   10
     *    / \    \
     *   1   6   14
     *      / \   /
     *     4   7 13
     * @param args
     */
    public static void main(String[] args) {

        TreeNode root = new TreeNode(8);
        root.setLeft(new TreeNode(3));
        root.setRight(new TreeNode(10));
        root.getLeft().setLeft(new TreeNode(1));
        root.getLeft().setRight(new TreeNode(6));
        root.getRight().setRight(new TreeNode(14));
        root.getLeft().getRight().setLeft(new TreeNode(4));
        root.getLeft().getRight().setRight(new TreeNode(7));
        root.getRight().getRight().setLeft(new TreeNode(13));

        System.out.println(maxAncestorDiff(root));
    }


    private static int maxAncestorDiff(TreeNode root) {
        maxDiffHelper(root);
        return maxDiff;
    }

    private static int[] maxDiffHelper(TreeNode root) {

        if (root == null) {
            return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE};
        }

        //post order

        int[] left = maxDiffHelper(root.getLeft());

        int[] right = maxDiffHelper(root.getRight());

        int leftMin = left[0];
        int rightMin = right[0];

        int min = Math.min(root.getVal(),Math.min(leftMin,rightMin));

        int leftMax = left[1];
        int rightMax = right[1];

        int max = Math.max(root.getVal(),Math.max(leftMax,rightMax));

        maxDiff = Math.max((max - root.getVal()),Math.max((root.getVal()-min),maxDiff));

        return new int[]{min,max};


    }
}
