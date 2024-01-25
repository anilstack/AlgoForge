package com.anilstack.ds.trees;

import com.anilstack.ds.util.TreeNode;

import static com.anilstack.ds.util.TreeNode.inorderTraversal;
import static com.anilstack.ds.util.TreeNode.postOrderTraversal;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class DeleteANodeInBST {


    /**
     *     5
     *    / \
     *   3   6
     *  / \   \
     * 2   4   7
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.setLeft(new TreeNode(3));
        root.setRight(new TreeNode(6));
        root.getLeft().setLeft(new TreeNode(2));
        root.getLeft().setRight(new TreeNode(4));
        root.getRight().setRight(new TreeNode(7));
        TreeNode ans = deleteNode(root,3);
        postOrderTraversal(ans);
    }

    private static TreeNode deleteNode(TreeNode root, int value) {

        if (root == null) return root;

        if (root.getVal() < value) {
            root.setRight(deleteNode(root.getRight(),value));
            return root;
        } else if (root.getVal() > value) {
            root.setLeft(deleteNode(root.getLeft(),value));
            return root;
        } else {

            if (root.getLeft()==null && root.getRight()==null) {
                return null;
            }

            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight()==null) {
                return root.getLeft();
            } else {

                TreeNode nextMinNode = root.getRight();

                while (nextMinNode.getLeft()!=null) {
                    nextMinNode = nextMinNode.getLeft();
                }

                nextMinNode.setLeft(root.getLeft());
                return root.getRight();




            }
        }



    }

}
