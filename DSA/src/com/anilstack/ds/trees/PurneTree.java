package com.anilstack.ds.trees;

import com.anilstack.ds.util.TreeNode;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class PurneTree {
    /**
     *       1
     *        \
     *         0
     *        / \
     *       0   1
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setRight(new TreeNode(0));
        root.getRight().setLeft(new TreeNode(0));
        root.getRight().setRight(new TreeNode(1));

        System.out.println("after purne the tree : " );
        root.inorderTraversal(purneTree(root));
    }


    private static TreeNode purneTree(TreeNode node) {

        if (node == null) return node;

        //we are following post order travesel left,right,root.
        node.setLeft(purneTree(node.getLeft()));
        node.setRight(purneTree(node.getRight()));

        if (canDeleteThisNode(node)) return null;
        return node;

    }

    private static boolean canDeleteThisNode(TreeNode node) {
        if (node.getLeft() == null && node.getRight() == null && node.getVal() == 0) {
            return true;
        } else  {
            return false;
        }
    }


}
